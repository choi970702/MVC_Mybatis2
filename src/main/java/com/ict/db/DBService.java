package com.ict.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// config.xml을 읽어 MyBatis가 DB에 접근 하고 실행할 수 있도록 도와주는 클래스
// java에서 MyBatis를 사용하기 위해서는 SqlSession이라는 객체를 사용한다.
// DAO에서 SqlSession객체를 사용하기 위해서 SqlSessionFactory 클래스를 생성하는 역할을 한다.
public class DBService 
{
	static private SqlSessionFactory factory;
	
	// static 초기화
	static
	{
		try 
		{
			factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("com/ict/db/config.xml"));
		} catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public static SqlSessionFactory getFactory()
	{
		
		return factory;
	}
	
	
	
}



