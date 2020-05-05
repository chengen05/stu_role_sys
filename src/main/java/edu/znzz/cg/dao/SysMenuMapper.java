package edu.znzz.cg.dao;

import java.util.List;
import java.util.Set;

import edu.znzz.cg.entity.SysMenu;
/**
 * 菜单数据层
 * @author chen gen
 *
 */
public interface SysMenuMapper {
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
     * 根据SysMenu查询菜单
     * @param SysMenu
     * @return List<SysMenu>
     */
    List<SysMenu> selectMenusByMenu(SysMenu sysMenu);
}