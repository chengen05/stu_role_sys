package edu.znzz.cg.service.inter;

import java.util.List;

import edu.znzz.cg.entity.SysUser;

/**
 * �û���
 * @author chen gen
 *
 */
public interface SysUserService {
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
	     * @return
	     */
	    SysUser selectByPhoneNum(String phoneNum);
	    
	    /**
	     * �ʼ���ѯ
	     * @param email
	     * @return
	     */
	    SysUser selectByEmail(String email);
	    
	    /**
	     * ���ݵ�¼�˺Ų�ѯ
	     * @param loginName
	     * @return
	     */
	    SysUser selectByLoginName(String loginName);
	    /**
	     * �жϵ�¼�˺��Ƿ�Ψһ
	     * @param loginName
	     * @return
	     */
	    SysUser checkLoginNameUnique(String loginName);
	    /**
	     * У���ֻ����Ƿ�Ψһ
	     * @param phoneNum
	     * @return
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