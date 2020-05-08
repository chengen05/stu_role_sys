package edu.znzz.cg.service.inter;

import java.util.List;
import java.util.Set;

import edu.znzz.cg.entity.SysMenu;
import edu.znzz.cg.entity.SysRole;
import edu.znzz.cg.entity.SysZtree;

/**
 * menu service
 * @author chen gen
 *
 */
public interface SysMenuService {
	/**
	 * 查询所有菜单
	 * @return
	 */
	List<SysMenu> selectAllMenu();
	
    int deleteByPrimaryKey(String menuId);
    /**
     * 插入菜单
     * @param record
     * @return
     */
    int insertMenu(SysMenu record);
    /**
     * menuid查询
     * @param menuId
     * @return
     */
    SysMenu selectByPrimaryKey(String menuId);
    /**
     * 修改菜单
     * @param record
     * @return
     */
    int updateMenu(SysMenu record);
    /**
     * 校验菜单名称
     * @param menuName
     * @return
     */
    int checkMenuNameUnique(String menuName);
    /**
     * 校验菜单shiro key 
     * @param menuKey
     * @return
     */
    int checkMenuKeyUnique(String menuKey);
    
    /**
     * 根据userid查询其角色对应的perms
     * @param userId
     * @return set<String>
     */
    Set<String> selectPermsByUserId(String userId);
    /**
     * 根据userid查询菜单
     * @param userId
     * @return List<SysMenu>
     */
    List<SysMenu> selectMenusByUserId(String userId);
    
    /**
     * 根据sysMenu查询菜单
     * @param sysMenu
     * @return List<SysMenu>
     */
    List<SysMenu> selectMenusByMenu(SysMenu sysMenu);
    
    /**
     * 根据父id查询子菜单
     * @param parentId
     * @return List<SysMenu>
     */
    List<SysMenu> selectMenuByParentId(String parentId);
    /**
     * 根据角色查询菜单
     * @param sysRole
     * @return List<SysZtree>
     */
    List<SysZtree> roleMenuTree(SysRole sysRole);
 }