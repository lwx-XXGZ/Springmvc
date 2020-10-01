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
	//�����������ƴ���ַ�������Ϊ��������@RequestParam������ȡ����
	@RequestMapping(value="/add")
	public String add(@RequestParam(value="username")String name,Integer age){
		System.out.println(name+age);
		return null;
	}
	//������󣬱����Ե�nameֵΪ���������ֵ����֤����nameֵ����������ֵһ��
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
	//���Դ������Ĳ������Ͳ�ƥ�俴���Ƿ�ִ���쳣����
	@RequestMapping(method=RequestMethod.GET,value=("/update"))
	public String update(Integer age){
			return "fail";
	}
	//�����쳣�����@ExceptionHandler(value={Exception.class})ע���ʾ����ʲô���͵��쳣
	@ExceptionHandler(value={Exception.class})
	public String handlerException(){
		return "success";
	}
	
	//��̨��ֵ��ǰ̨jspҳ�淽��1
	public ModelAndView method1(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("stuName", "zhangsan");
		mav.setViewName("success");
		return mav;
	}
	//��̨��ֵ��ǰ̨jspҳ�淽��2
		public String method2(Model model){
			model.addAttribute("stuName", "����");
			return "success";
		}
}
