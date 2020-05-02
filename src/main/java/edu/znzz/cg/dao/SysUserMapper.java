package edu.znzz.cg.dao;

import java.util.List;

import edu.znzz.cg.entity.SysUser;

/**
 * 用户表dao
 * @author chen gen
 *
 */
public interface SysUserMapper {
    

    int insert(SysUser record);
    
    int update(SysUser record);
    
    int deleteByPrimaryKey(String userId);

    /**
     * 主键查询
     * @param userId
     * @return
     */
    SysUser selectByPrimaryKey(String userId);
    
	/**
	 * 查询全部
	 * @return
	 */
    List<SysUser> selectAll();
    
    /**
     * 电话号码查询
     * @param phoneNum
     * @return sysUser
     */
    SysUser selectByPhoneNum(String phoneNum);
    
    /**
     * 邮件查询
     * @param email
     * @return sysUser
     */
    SysUser selectByEmail(String email);
    
    /**
     * 根据登录账号查询
     * @param loginName
     * @return sysUser
     */
    SysUser selectByLoginName(String loginName);
    /**
     * 判断登录账号是否唯一
     * @param loginName
     * @return sysUser
     */
    SysUser checkLoginNameUnique(String loginName);
    /**
     * 校验手机号是否唯一
     * @param phoneNum
     * @return sysUser
     */
    SysUser checkPhoneUnique(String phoneNum);
    /**
     * email校验
     * @param email
     * @return sysUser
     */
    SysUser checkEmailUnique(String email);
   /**
    * 身份证校验
    * @param idcard
    * @return
    */
    SysUser checkIdCardUnique(String idcard);
    /**
     * user 条件查询
     * @param sysuser
     * @return list<SysUser>
     */
    List<SysUser> selectListByUser(SysUser sysuser);
    
}