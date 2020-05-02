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
		// TODO Auto-generated method stub
		return sysMenuMapper.selectAllMenu();
	}

	public int deleteByPrimaryKey(String menuId) {
		// TODO Auto-generated method stub
		return sysMenuMapper.deleteByPrimaryKey(menuId);
	}

	public int insertMenu(SysMenu record) {
		// TODO Auto-generated method stub
		return sysMenuMapper.insertMenu(record);
	}

	public SysMenu selectByPrimaryKey(String menuId) {
		// TODO Auto-generated method stub
		return sysMenuMapper.selectByPrimaryKey(menuId);
	}

	public int updateMenu(SysMenu record) {
		// TODO Auto-generated method stub
		return sysMenuMapper.updateMenu(record);
	}

	public int checkMenuNameUnique(String menuName) {
		// TODO Auto-generated method stub
		return sysMenuMapper.checkMenuNameUnique(menuName);
	}

	public int checkMenuKeyUnique(String menuKey) {
		// TODO Auto-generated method stub
		return sysMenuMapper.checkMenuKeyUnique(menuKey);
	}

	public Set<String> selectPermsByUserId(String userId) {
		
		return sysMenuMapper.selectPermsByUserId(userId);
	}

	public List<SysMenu> selectMenusByUserId(String userId) {
		
		return sysMenuMapper.selectMenusByUserId(userId);
	}
	

	
}
