package ssm.blog.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;
import ssm.blog.util.CryptographyUtil;

/**
 * @Description ����Controller�㣬ǰ̨���֣�����Ҫ��֤
 * @author Ni Shengwu
 *
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {
	
	@Resource
	private BloggerService bloggerService;
	
	@RequestMapping("/login")
	public String login(Blogger blogger, HttpServletRequest request) {
		
		Subject subject = SecurityUtils.getSubject(); //��ȡ��ǰ��½������
		String newPassword = CryptographyUtil.md5(blogger.getPassword(), "eson_15");//������ʹ��md5����
		//���û���Ϣ��װ��token��
		UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUsername(), newPassword);
		try {
			subject.login(token); //�����MyRealm�е�doGetAuthenticationInfo�������������֤
			return "redirect:/admin/main.jsp";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			request.setAttribute("blollger", blogger);
			request.setAttribute("errorInfo", "�û������������");
			return "login";
		} 

	}
}
