package ssm.blog.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.blog.entity.Blog;
import ssm.blog.service.BlogService;
import ssm.blog.util.PageUtil;
import ssm.blog.util.StringUtil;

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
		
		//��ȡ�ؼ���
		String keyWords = blog.getKeyWord();
		if(StringUtil.isNotEmpty(keyWords)) {
			String[] strArray = keyWords.split(" ");
			List<String> keyWordsList = StringUtil.filterWhite(Arrays.asList(strArray));
			modelAndView.addObject("keyWords", keyWordsList);
		} else {
			modelAndView.addObject("keyWords", null);
		}
		
		modelAndView.addObject("blog", blog);
		blog.setClickHit(blog.getClickHit() + 1); //�����ͷ�������1
		blogService.update(blog); //���²���
		
		modelAndView.addObject("commonPage", "foreground/blog/blogDetail.jsp");
		modelAndView.addObject("title", blog.getTitle() + " - ������Ĳ���");
		
		//������һƪ����һƪ����ʾ����
		modelAndView.addObject("pageCode", PageUtil.getPrevAndNextPageCode(
				blogService.getPrevBlog(id), 
				blogService.getNextBlog(id), 
				request.getServletContext().getContextPath()));
		
		modelAndView.setViewName("mainTemp");
		
		return modelAndView;
	}

}
