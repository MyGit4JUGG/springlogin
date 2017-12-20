package test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.login.dao.UserDAO;
import cn.tedu.login.entity.User;
import cn.tedu.login.service.LoginService;

public class TestCase {
	@Test
	//���ԡ����ӳ�
	public void test1() throws SQLException{
		String config = "spring-mvc.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					config);
		
//		BasicDataSource ds = 
//				ac.getBean("ds",
//						BasicDataSource.class);
		
		/*
		 * DataSource��һ���ӿ�,BasicDataSource
		 * �Ǹýӿڵ�ʵ���ࡣ
		 */
		DataSource ds = 
				ac.getBean("ds",DataSource.class);
		
		System.out.println(ds.getConnection());
		
		
	}
	
	@Test
	//���ԡ����ݷ��ʲ�
	public void test2(){
		String config = "spring-mvc.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					config);
		UserDAO dao = 
				ac.getBean("userDAO",UserDAO.class);
		User user = dao.findByUsername("King");
		System.out.println("user:" + user);
	}
	
	@Test
	//���ԡ���ҵ���
	public void test3(){
		String config = "spring-mvc.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					config);
		LoginService service = 
			ac.getBean("loginService",
					LoginService.class);
		User user = 
				service.checkLogin("King", "1234");
		System.out.println("user:" + user);
		
	}
	
	
	
	
	
}


