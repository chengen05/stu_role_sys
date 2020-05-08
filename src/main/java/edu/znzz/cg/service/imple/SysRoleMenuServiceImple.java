package edu.znzz.cg.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.znzz.cg.dao.SysRoleMenuMapper;
import edu.znzz.cg.entity.SysRoleMenuKey;
import edu.znzz.cg.service.inter.SysRoleMenuService;

@Service
public class SysRoleMenuServiceImple implements SysRoleMenuService{

	@Autowired
	SysRoleMenuMapper sysRoleMenuMapper;
	
	public int deleteByPrimaryKey(SysRoleMenuKey key) {
		
		return sysRoleMenuMapper.deleteByPrimaryKey(key);
	}

	public int insert(SysRoleMenuKey record) {
		
		return sysRoleMenuMapper.insert(record);
	}

	public String[] selectByRoleId(String roleId) {
		
		return sysRoleMenuMapper.selectByRoleId(roleId);
	}

	public int batchRoleMenu(List<SysRoleMenuKey> roleMenuList) {
		
		return sysRoleMenuMapper.batchRoleMenu(roleMenuList);
	}

	public int selectCountRoleMenuByMenuId(String menuId) {
		
		return sysRoleMenuMapper.selectCountRoleMenuByMenuId(menuId);
	}

}
