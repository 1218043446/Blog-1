package ssm.blog.dao;

import java.util.List;

import ssm.blog.entity.Link;

/**
 * @Description ��������dao�ӿ�
 * @author Ni Shengwu
 *
 */
public interface LinkDao {
	
	//��ȡ��������
	public List<Link> getLinkData();
}
