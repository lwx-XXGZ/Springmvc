package com.contronller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;



import com.entity.User;
@Controller
@RequestMapping(value="/user")
public class Student {
	private static final RequestMethod[] POST = null;
	//传入参数根据拼接字符串传入为参数名，@RequestParam给参数取别名
	@RequestMapping(value="/add")
	public String add(@RequestParam(value="username")String name,Integer age){
		System.out.println(name+age);
		return null;
	}
	//传入对象，表单属性的name值为对象的属性值，保证表单的name值与对象的属性值一致
	@RequestMapping(value="/login")
	public String login(User user,Model model,Exception ex){
		System.out.println(user.getUserName()+user.getUserPwd());
		if ("admin".equals(user.getUserName()) && "123".equals(user.getUserPwd())) {
			model.addAttribute("user",user);
			return "success";
		}else {
			return "fail";
		}
	}
	//测试传进来的参数类型不匹配看它是否执行异常方法
	@RequestMapping(method=RequestMethod.GET,value=("/update"))
	public String update(Integer age){
			return "fail";
	}
	//处理异常，添加@ExceptionHandler(value={Exception.class})注解表示处理什么类型的异常
	@ExceptionHandler(value={Exception.class})
	public String handlerException(){
		return "success";
	}
	
	//后台传值给前台jsp页面方法1
	public ModelAndView method1(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("stuName", "zhangsan");
		mav.setViewName("success");
		return mav;
	}
	//后台传值给前台jsp页面方法2
		public String method2(Model model){
			model.addAttribute("stuName", "张三");
			return "success";
		}
}
