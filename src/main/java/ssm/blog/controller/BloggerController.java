package ssm.blog.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.blog.service.BloggerService;

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
}
