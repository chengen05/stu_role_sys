package edu.znzz.cg.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.znzz.cg.dao.SysUserRoleMapper;
import edu.znzz.cg.entity.SysUserRoleKey;
import edu.znzz.cg.service.inter.SysUserRoleService;

@Service
public class SysUserRoleServiceImple implements SysUserRoleService {

	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	public int deleteByPrimaryKey(SysUserRoleKey key) {
		
		return sysUserRoleMapper.deleteByPrimaryKey(key);
	}

	public int insert(SysUserRoleKey record) {
	
		return sysUserRoleMapper.insert(record);
	}

	public String[] selectByUserId(String userId) {
		
		return sysUserRoleMapper.selectByUserId(userId);
	}

	public String[] selectByRoleId(String roleId) {
		
		return sysUserRoleMapper.selectByRoleId(roleId);
	}

}
