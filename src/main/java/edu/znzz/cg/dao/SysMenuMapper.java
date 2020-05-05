package edu.znzz.cg.dao;

import java.util.List;
import java.util.Set;

import edu.znzz.cg.entity.SysMenu;
/**
 * �˵����ݲ�
 * @author chen gen
 *
 */
public interface SysMenuMapper {
	/**
	 * ��ѯ���в˵�
	 * @return
	 */
	List<SysMenu> selectAllMenu();
	
    int deleteByPrimaryKey(String menuId);
    /**
     * ����˵�
     * @param record
     * @return
     */
    int insertMenu(SysMenu record);
    /**
     * menuid��ѯ
     * @param menuId
     * @return
     */
    SysMenu selectByPrimaryKey(String menuId);
    /**
     * �޸Ĳ˵�
     * @param record
     * @return
     */
    int updateMenu(SysMenu record);
    /**
     * У��˵�����
     * @param menuName
     * @return
     */
    int checkMenuNameUnique(String menuName);
    /**
     * У��˵�shiro key 
     * @param menuKey
     * @return
     */
    int checkMenuKeyUnique(String menuKey);
    /**
     * ����userid��ѯ���ɫ��Ӧ��perms
     * @param userId
     * @return set<String>
     */
    Set<String> selectPermsByUserId(String userId);
    /**
     * ����userid��ѯ�˵�
     * @param userId
     * @return List<SysMenu>
     */
    List<SysMenu> selectMenusByUserId(String userId);
    /**
     * ����SysMenu��ѯ�˵�
     * @param SysMenu
     * @return List<SysMenu>
     */
    List<SysMenu> selectMenusByMenu(SysMenu sysMenu);
}