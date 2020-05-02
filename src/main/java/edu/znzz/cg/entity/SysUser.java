package edu.znzz.cg.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SysUser {
	
    private String userId;

    private String departId;

    private String clazzId;

    private String loginName;

    private String userName;

    private String email;

    private String phoneNumber;

    private String sex;

    private String avatar;

    private String password;

    private String salt;

    private String idCard;

    private String address;

    private String status;

    private String delFlag;

    private String loginIp;

    private Date loginDate;
    
    /** 院 */
    private SysDepart depart;
    
    /** 年级班级*/
    private SysClazz clazz;
    
    /**  角色*/
    private List<SysRole> roles;
    
    private String[] roleIds;
    
    private boolean isAdmin;
    
    
    public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public SysDepart getDepart() {
		return depart;
	}

	public void setDepart(SysDepart depart) {
		this.depart = depart;
	}

	public SysClazz getClazz() {
		return clazz;
	}

	public void setClazz(SysClazz clazz) {
		this.clazz = clazz;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId == null ? null : clazzId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", departId=" + departId + ", clazzId=" + clazzId + ", loginName="
				+ loginName + ", userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", sex="
				+ sex + ", avatar=" + avatar + ", password=" + password + ", salt=" + salt + ", idCard=" + idCard
				+ ", address=" + address + ", status=" + status + ", delFlag=" + delFlag + ", loginIp=" + loginIp
				+ ", loginDate=" + loginDate + ", depart=" + depart + ", clazz=" + clazz + ", roles=" + roles
				+ ", roleIds=" + Arrays.toString(roleIds) + ", isAdmin=" + isAdmin + "]";
	}
   
}