package edu.znzz.cg.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMenu {
    private String menuId;

    private String menuName;

    private String parentId;

    private Integer orderNum;

    private String url;
    /** ����:0Ŀ¼,1�˵�,2��ť */
    private String menuType;
    /** �˵�״̬:0��ʾ,1���� */
    private String visible;
    /** Ȩ���ַ��� */
    private String permsKey;
    /** �˵�ͼ�� */
    private String icon;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
    /** �Ӳ˵� */
    private List<SysMenu> children = new ArrayList<SysMenu>();
    
    
    public List<SysMenu> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenu> children) {
		this.children = children;
	}

	public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible == null ? null : visible.trim();
    }

    public String getPermsKey() {
        return permsKey;
    }

    public void setPermsKey(String permsKey) {
        this.permsKey = permsKey == null ? null : permsKey.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}