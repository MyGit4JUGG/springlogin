package cn.tedu.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.login.entity.User;
import cn.tedu.login.service.AppException;
import cn.tedu.login.service.LoginService;

@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService service;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(
			HttpServletRequest request){
		System.out.println("login()");
		//��ȡ�û���������
		String uname = 
				request.getParameter("username");
		String pwd = 
				request.getParameter("pwd");
		System.out.println("uname:" 
				+ uname + " pwd:" + pwd);
		
		//����ҵ���ķ�����е�¼��֤
		try{
			User user = 
					service.checkLogin(uname, pwd);
			
		}catch(Exception e){
			e.printStackTrace();
			if(e instanceof AppException){
				//Ӧ���쳣����Ҫ��ȷ��ʾ�û�
				//��ȡ��ȷ�Ĳ�����
				request.setAttribute("login_failed",
						e.getMessage());
				//ת������¼ҳ��
				return "login";
			}
			//ϵͳ�쳣����ʾ�û��Ժ�����
			return "error";
		}
		//��¼�ɹ����ض�����ҳ
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
}







