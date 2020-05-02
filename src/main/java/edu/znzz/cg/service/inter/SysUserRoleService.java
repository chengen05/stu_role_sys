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
     * 根据userid查询对应的Roleid
     * @param userId
     * @return string[] roleid
     */
    String[] selectByUserId(String userId);
   
}