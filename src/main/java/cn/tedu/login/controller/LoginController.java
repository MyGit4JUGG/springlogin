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
		//读取用户名和密码
		String uname = 
				request.getParameter("username");
		String pwd = 
				request.getParameter("pwd");
		System.out.println("uname:" 
				+ uname + " pwd:" + pwd);
		
		//调用业务层的服务进行登录验证
		try{
			User user = 
					service.checkLogin(uname, pwd);
			
		}catch(Exception e){
			e.printStackTrace();
			if(e instanceof AppException){
				//应用异常，需要明确提示用户
				//采取正确的操作。
				request.setAttribute("login_failed",
						e.getMessage());
				//转发到登录页面
				return "login";
			}
			//系统异常，提示用户稍后重试
			return "error";
		}
		//登录成功，重定向到首页
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
}







