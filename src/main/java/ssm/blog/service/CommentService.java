package ssm.blog.service;

import java.util.List;
import java.util.Map;

import ssm.blog.entity.Comment;

/**
 * @Description �û�����service�ӿ�
 * @author Ni Shengwu
 *
 */
public interface CommentService {

	// ��ȡ������Ϣ
	public List<Comment> getCommentData(Map<String, Object> map);

	// �������
	public int addComment(Comment comment);
}
