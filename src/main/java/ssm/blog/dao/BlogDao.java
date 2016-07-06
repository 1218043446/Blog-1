package ssm.blog.dao;

import java.util.List;
import java.util.Map;

import ssm.blog.entity.Blog;

/**
 * @Description ����Dao�ӿ�
 * @author Ni Shengwu
 *
 */
public interface BlogDao {

	// ��ȡ������Ϣ�����������·ݷ����ѯ
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
