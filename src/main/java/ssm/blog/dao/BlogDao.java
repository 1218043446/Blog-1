package ssm.blog.dao;

import java.util.List;

import ssm.blog.entity.Blog;

/**
 * @Description ����Dao�ӿ�
 * @author Ni Shengwu
 *
 */
public interface BlogDao {
	
	//��ȡ������Ϣ�����������·ݷ����ѯ
	public List<Blog> getBlogData();
}
