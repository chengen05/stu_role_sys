package edu.znzz.cg.service.inter;

import java.util.List;

import edu.znzz.cg.entity.SysRole;
/**
 * role service
 * @author chen gen
 *
 */
public interface SysRoleService {
	
	  int deleteByPrimaryKey(String roleId);
	    /**
	     * �����ɫ
	     * @param record
	     * @return
	     */
	    int insertRole(SysRole record);
	    /**
	     * ���ݽ�ɫid��ѯ
	     * @param roleId
	     * @return ��ɫ
	     */
	    SysRole selectByPrimaryKey(String roleId);
	    /**
	     * �޸Ľ�ɫ
	     * @param record
	     * @return
	     */
	    int updateRole(SysRole record);
	    /**
	     * У���ɫ����
	     * @param roleName
	     * @return
	     */
	    int checkRoleNameUnique(String roleName);
	    /**
	     * ��ѯ���н�ɫ
	     * @return
	     */
	    List<SysRole> selectAll();
	    /**
	     * У��shiro��ɫ����ʱ�����Ӧ��shiro-key
	     * @param roleKey
	     * @return
	     */
	    int checkRoleKeyUnique(String roleKey);
	
}