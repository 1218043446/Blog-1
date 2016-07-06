package ssm.blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.blog.entity.Blog;
import ssm.blog.service.BlogService;

/**
 * @Description ����Controller��
 * @author Ni Shengwu
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Resource
	private BlogService blogService;
	
	//���󲩿���ϸ��Ϣ
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id") Integer id, HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		Blog blog = blogService.findById(id); //����id��ȡ����
		modelAndView.addObject("blog", blog);
		blog.setClickHit(blog.getClickHit() + 1); //�����ͷ�������1
		blogService.update(blog); //���²���
		
		modelAndView.addObject("commonPage", "foreground/blog/blogDetail.jsp");
		modelAndView.addObject("title", blog.getTitle() + " - ������Ĳ���");
		modelAndView.setViewName("mainTemp");
		
		return modelAndView;
	}

}
