package ssm.blog.entity;

/**
 * @Description ��������ʵ��
 * @author Ni Shengwu
 *
 */
public class Link {
	
	private Integer id;
	private String linkname; //��������
	private String linkurl; //���ӵ�ַ
	private Integer linkorder; //������������
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkname() {
		return linkname;
	}
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	public String getLinkurl() {
		return linkurl;
	}
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
	public Integer getOrder() {
		return linkorder;
	}
	public void setOrder(Integer linkorder) {
		this.linkorder = linkorder;
	}

	
}
