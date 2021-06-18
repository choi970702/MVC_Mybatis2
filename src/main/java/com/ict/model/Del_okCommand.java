package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;

public class Del_okCommand implements Command
{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response)
	{
		String idx = request.getParameter("idx");
		int result = DAO.getDelete(idx);
		if(result>0)
		{
			//response.sendRedirect("list.jsp");
			return "MyController?cmd=list";
		}
		return null;
	}
}