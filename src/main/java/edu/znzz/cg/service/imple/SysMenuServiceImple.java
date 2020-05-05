package edu.znzz.cg.service.imple;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.znzz.cg.dao.SysMenuMapper;
import edu.znzz.cg.entity.SysMenu;
import edu.znzz.cg.service.inter.SysMenuService;

@Service
public class SysMenuServiceImple implements SysMenuService{

	@Autowired
	private SysMenuMapper sysMenuMapper;

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

	

	
}
