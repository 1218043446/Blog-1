package ssm.blog.dao;

import java.util.List;

import ssm.blog.entity.BlogType;

/**
 * @Description �������dao�ӿ�
 * @author Ni Shengwu
 *
 */
public interface BlogTypeDao {

	//��ȡ���������Ϣ
	public List<BlogType> getBlogTypeData();
	
	//����id���Ҳ���������Ϣ
	public BlogType findById(Integer id);
}
