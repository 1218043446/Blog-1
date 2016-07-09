package ssm.blog.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.blog.entity.Blog;
import ssm.blog.service.BlogService;
import ssm.blog.util.ResponseUtil;

/**
 * @Description ����Ա����Controller��
 * @author Ni Shengwu
 *
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

	@Resource
	private BlogService blogService;
	
	@RequestMapping("/save")
	public String save(Blog blog, HttpServletResponse response) throws Exception {
		
		int resultTotal = 0; //���շ��ؽ����¼��
		if(blog.getId() == null) { //˵���ǵ�һ�β���
			resultTotal = blogService.addBlog(blog);
		} else {
			
		}
		
		JSONObject result = new JSONObject();
		if(resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
}
