package ssm.blog.service;

import java.util.List;
import java.util.Map;

import ssm.blog.entity.Blog;

/**
 * @Description ����Service�ӿ�
 * @author Ni Shengwu
 *
 */
public interface BlogService {

	public List<Blog> getBlogData();

	// ��ҳ��ѯ����
	public List<Blog> listBlog(Map<String, Object> map);

	// ��ȡ�ܼ�¼��
	public Long getTotal(Map<String, Object> map);

	// ����id��ȡ����
	public Blog findById(Integer id);

	// ���²�����Ϣ
	public Integer update(Blog blog);
}
