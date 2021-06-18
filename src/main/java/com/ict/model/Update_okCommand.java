package com.ict.model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Update_okCommand implements Command
{
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
			String path = request.getServletContext().getRealPath("/upload");
			MultipartRequest mr = new MultipartRequest(request,path,100*1024*1024,
					"utf-8",new DefaultFileRenamePolicy());
			
			VO vo = new VO();
			vo.setIdx(mr.getParameter("idx"));
			vo.setName(mr.getParameter("name"));
			vo.setSubject(mr.getParameter("subject"));
			vo.setContent(mr.getParameter("content"));
			vo.setEmail(mr.getParameter("email"));
			vo.setPwd(mr.getParameter("pwd"));
			String f_name2 = mr.getParameter("f_name2");
			
			// 첨부파일이 있을 때와 첨부파일이 없을 때을 구분하자 
			// 첨부파일이 없으면 이전파일로 대체한다.
			if(mr.getFile("f_name")==null)
			{
				vo.setF_name(f_name2);
			}else
			{
				// 첨부파일이 있으면 첨부파일을 사용한다.
				vo.setF_name(mr.getFilesystemName("f_name"));
			}
			int result = DAO.getUpdate(vo);
			if(result>0)
			{
				// response.sendRedirect("onelist.jsp?idx="+vo.getIdx());
				return "MyController?cmd=onelist&idx="+vo.getIdx();
				
			}
			
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		return null;
	}
}
