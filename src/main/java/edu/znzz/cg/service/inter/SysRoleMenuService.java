package edu.znzz.cg.service.inter;

import java.util.List;

import edu.znzz.cg.entity.SysRoleMenuKey;
/**
 * 
 * @author chen gen
 *
 */
public interface SysRoleMenuService {
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