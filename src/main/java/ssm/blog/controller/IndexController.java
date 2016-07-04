package ssm.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssm.blog.entity.Blog;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogService;
import ssm.blog.util.StringUtil;

/**
 * @Description ��ҳController
 * @author Ni Shengwu
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

	@Resource
	private BlogService blogService;

	/**
	 * @Description ������ҳ
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(
			@RequestParam(value = "page", required = false) String page)
			throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(StringUtil.isEmpty(page)) {
			page = "1";
		}
		//��ȡ��ҳ��bean
		PageBean pageBean = new PageBean(Integer.parseInt(page), 5);
		
		//map�з�װ��ʼҳ��ÿҳ�ļ�¼
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		
		//��ȡ������Ϣ
		List<Blog> blogList = blogService.listBlog(map);
		modelAndView.addObject("blogList", blogList);
		modelAndView.addObject("blogListPage", "foreground/blog/blogList.jsp");
		modelAndView.addObject("title", "������ҳ");
		modelAndView.setViewName("mainTemp");
		
		return modelAndView;
		

	}
}
