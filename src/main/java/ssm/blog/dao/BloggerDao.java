package ssm.blog.dao;

import ssm.blog.entity.Blogger;

/**
 * @Description ����dao�ӿ�
 * @author Ni Shengwu
 *
 */
public interface BloggerDao {
	
	//ͨ���û�����ѯ�û�
	public Blogger getByUsername(String username);
}
