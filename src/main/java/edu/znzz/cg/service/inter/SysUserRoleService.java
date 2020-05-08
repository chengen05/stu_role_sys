package edu.znzz.cg.service.inter;

import edu.znzz.cg.entity.SysUserRoleKey;
/**
 * userRole service
 * @author chen gen
 *
 */
public interface SysUserRoleService {
	
    int deleteByPrimaryKey(SysUserRoleKey key);

    int insert(SysUserRoleKey record);
    /**
     * ����userid��ѯ��Ӧ��Roleid
     * @param userId
     * @return string[] roleid
     */
    String[] selectByUserId(String userId);
    
    /**
     * ����roleid��Ӧ��userId
     * @param roleId
     * @return string[] roleId
     */
    String[] selectByRoleId(String roleId);
   
}