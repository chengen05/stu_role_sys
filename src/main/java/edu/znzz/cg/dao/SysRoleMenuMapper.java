package edu.znzz.cg.dao;



import java.util.List;

import edu.znzz.cg.entity.SysRoleMenuKey;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(SysRoleMenuKey key);

    int insert(SysRoleMenuKey record);

    /**
     * 根据roleid查询menus 
     * @param roleId
     * @return String[] menuId
     */
    String[]  selectByRoleId(String roleId);
    
    /**
     * 批量添加role-menu 信息
     * 
     * @param roleMenuList
     * @return int 插入成功数据
     */
    int batchRoleMenu(List<SysRoleMenuKey> roleMenuList);

    
}