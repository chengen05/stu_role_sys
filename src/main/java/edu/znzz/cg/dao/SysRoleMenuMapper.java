package edu.znzz.cg.dao;



import java.util.List;

import edu.znzz.cg.entity.SysRoleMenuKey;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(SysRoleMenuKey key);

    int insert(SysRoleMenuKey record);

    /**
     * ����roleid��ѯmenus 
     * @param roleId
     * @return String[] menuId
     */
    String[]  selectByRoleId(String roleId);
    
    /**
     * �������role-menu ��Ϣ
     * 
     * @param roleMenuList
     * @return int ����ɹ�����
     */
    int batchRoleMenu(List<SysRoleMenuKey> roleMenuList);

    
}