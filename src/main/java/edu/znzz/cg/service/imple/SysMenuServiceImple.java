package edu.znzz.cg.service.imple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.znzz.cg.dao.SysMenuMapper;
import edu.znzz.cg.dao.SysRoleMenuMapper;
import edu.znzz.cg.entity.SysMenu;
import edu.znzz.cg.entity.SysRole;
import edu.znzz.cg.entity.SysUser;
import edu.znzz.cg.entity.SysZtree;
import edu.znzz.cg.service.inter.SysMenuService;

@Service
public class SysMenuServiceImple implements SysMenuService{

	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	
	public List<SysMenu> selectAllMenu() {
		return sysMenuMapper.selectAllMenu();
	}

	public int deleteByPrimaryKey(String menuId) {
		return sysMenuMapper.deleteByPrimaryKey(menuId);
	}

	public int insertMenu(SysMenu record) {
		return sysMenuMapper.insertMenu(record);
	}

	public SysMenu selectByPrimaryKey(String menuId) {
		return sysMenuMapper.selectByPrimaryKey(menuId);
	}

	public int updateMenu(SysMenu record) {
		return sysMenuMapper.updateMenu(record);
	}

	public int checkMenuNameUnique(String menuName) {
		return sysMenuMapper.checkMenuNameUnique(menuName);
	}

	public int checkMenuKeyUnique(String menuKey) {
		return sysMenuMapper.checkMenuKeyUnique(menuKey);
	}

	public Set<String> selectPermsByUserId(String userId) {
		return sysMenuMapper.selectPermsByUserId(userId);
	}

	public List<SysMenu> selectMenusByUserId(String userId) {
		return sysMenuMapper.selectMenusByUserId(userId);
	}

	public List<SysMenu> selectMenusByMenu(SysMenu sysMenu) {

		return sysMenuMapper.selectMenusByMenu(sysMenu);
	}

	public List<SysMenu> selectMenuByParentId(String parentId) {
		
		return sysMenuMapper.selectMenuByParentId(parentId);
	}

	public List<SysZtree> roleMenuTree(SysRole sysRole) {
		String roleId = sysRole.getRoleId();
		List<SysZtree> ztrees = new ArrayList<SysZtree>();
		List<SysMenu> menus = selectAllMenu();
		if(roleId != null && !roleId.equals("")) {
			String[] roleMenu = sysRoleMenuMapper.selectByRoleId(roleId);
			// ��System.String[]ת��List<System.String>
			List<String> roleMenuList = Arrays.asList(roleMenu.toString().split(","));
			ztrees = initZtree(menus, roleMenuList, true);
		}else {
			ztrees = initZtree(menus, null, true);
		}
		return ztrees;
	}
	/**
	 * �����û�id��ѯ��Ӧ�˵�
	 * @return
	 */
	public List<SysMenu> selectMenuAll(){
		/** ȡ���û� */
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		List<SysMenu> menus = new ArrayList<SysMenu>();
		/** �����û�ȡ����Ӧ�˵�*/
        if(user.isAdmin()) {
        	menus = sysMenuMapper.selectAllMenu();	
        }else {
        	menus = sysMenuMapper.selectMenusByUserId(user.getUserId());
        }
        return menus;
	}

	
	/** ����ת�˵���
     * 
     * @param menuList �˵��б�
     * @param roleMenuList ��ɫ�Ѵ��ڲ˵��б�
     * @param permsFlag �Ƿ���Ҫ��ʾȨ�ޱ�ʶ
     * @return ���ṹ�б�
     */
    public List<SysZtree> initZtree(List<SysMenu> menuList, List<String> roleMenuList, boolean permsFlag)
    {
        List<SysZtree> ztrees = new ArrayList<SysZtree>();
        boolean isCheck = roleMenuList != null ? true:false;
        for (SysMenu menu : menuList)
        {
            SysZtree ztree = new SysZtree();
            ztree.setId(menu.getMenuId());
            ztree.setpId(menu.getParentId());
            ztree.setName(transMenuName(menu, roleMenuList, permsFlag));
            ztree.setTitle(menu.getMenuName());
            if (isCheck)
            {
                ztree.setChecked(roleMenuList.contains(menu.getMenuId() + menu.getPermsKey()));
            }
            ztrees.add(ztree);
        }
        return ztrees;
    }
    
    private String transMenuName(SysMenu menu, List<String> roleMenuList, boolean permsFlag)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(menu.getMenuName());
        if (permsFlag)
        {
            sb.append("<font color=\"#888\">&nbsp;&nbsp;&nbsp;" + menu.getPermsKey() + "</font>");
        }
        return sb.toString();
    }

	
}
