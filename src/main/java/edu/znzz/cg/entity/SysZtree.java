package edu.znzz.cg.entity;

/**
 * ztree���ṹ
 * @author chen gen
 *
 */
public class SysZtree {
	/** �ڵ�id */
	private String id;
	
	/** ���ڵ� */
	private String pId;
	
	/** �ڵ�����*/
	private String name;
	
	 /** �ڵ���� */
    private String title;

    /** �Ƿ�ѡ */
    private boolean checked = false;

    /** �Ƿ�չ�� */
    private boolean open = false;

    /** �Ƿ��ܹ�ѡ */
    private boolean nocheck = false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isNocheck() {
		return nocheck;
	}

	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}

    
}
