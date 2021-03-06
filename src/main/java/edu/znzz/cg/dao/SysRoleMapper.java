package edu.znzz.cg.dao;

import java.util.List;

import edu.znzz.cg.entity.SysRole;
/**
 * 角色数据层
 * @author chen gen
 *
 */
public interface SysRoleMapper {
	
    int deleteByPrimaryKey(String roleId);
    /**
     * 插入角色
     * @param record
     * @return
     */
    int insertRole(SysRole record);
    /**
     * 根据角色id查询
     * @param roleId
     * @return 角色
     */
    SysRole selectByPrimaryKey(String roleId);
    /**
     * 修改角色
     * @param record
     * @return
     */
    int updateRole(SysRole record);
    /**
     * 校验角色名称
     * @param roleName
     * @return
     */
    int checkRoleNameUnique(String roleName);
    /**
     * 查询所有角色
     * @return
     */
    List<SysRole> selectAll();
    /**
     * 校验shiro角色插入时候，其对应的shiro-key
     * @param roleKey
     * @return
     */
    int checkRoleKeyUnique(String roleKey);
    /**
     * 根据role条件查询
     * @param sysRole
     * @return list
     */
    List<SysRole> selectByRole(SysRole sysRole);
 
}