package edu.znzz.cg.dao;

import java.util.List;

import edu.znzz.cg.entity.SysUser;

/**
 * �û���dao
 * @author chen gen
 *
 */
public interface SysUserMapper {
    

    int insert(SysUser record);
    
    int update(SysUser record);
    
    int deleteByPrimaryKey(String userId);

    /**
     * ������ѯ
     * @param userId
     * @return
     */
    SysUser selectByPrimaryKey(String userId);
    
	/**
	 * ��ѯȫ��
	 * @return
	 */
    List<SysUser> selectAll();
    
    /**
     * �绰�����ѯ
     * @param phoneNum
     * @return sysUser
     */
    SysUser selectByPhoneNum(String phoneNum);
    
    /**
     * �ʼ���ѯ
     * @param email
     * @return sysUser
     */
    SysUser selectByEmail(String email);
    
    /**
     * ���ݵ�¼�˺Ų�ѯ
     * @param loginName
     * @return sysUser
     */
    SysUser selectByLoginName(String loginName);
    /**
     * �жϵ�¼�˺��Ƿ�Ψһ
     * @param loginName
     * @return sysUser
     */
    SysUser checkLoginNameUnique(String loginName);
    /**
     * У���ֻ����Ƿ�Ψһ
     * @param phoneNum
     * @return sysUser
     */
    SysUser checkPhoneUnique(String phoneNum);
    /**
     * emailУ��
     * @param email
     * @return sysUser
     */
    SysUser checkEmailUnique(String email);
   /**
    * ���֤У��
    * @param idcard
    * @return
    */
    SysUser checkIdCardUnique(String idcard);
    /**
     * user ������ѯ
     * @param sysuser
     * @return list<SysUser>
     */
    List<SysUser> selectListByUser(SysUser sysuser);
    
}