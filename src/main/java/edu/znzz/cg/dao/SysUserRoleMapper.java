package edu.znzz.cg.dao;


import edu.znzz.cg.entity.SysUserRoleKey;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(SysUserRoleKey key);

    int insert(SysUserRoleKey record);

    int insertSelective(SysUserRoleKey record);
    /**
     * 根据userid查询对应的Roleid
     * @param userId
     * @return string[] roleid
     */
    String[] selectByUserId(String userId);
}