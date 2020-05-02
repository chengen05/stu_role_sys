package edu.znzz.cg.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.znzz.cg.dao.SysRoleMapper;
import edu.znzz.cg.entity.SysRole;
import edu.znzz.cg.service.inter.SysRoleService;
/**
 * role  µœ÷≤„
 * @author chen gen
 *
 */
@Service
public class SysRoleServiceImple implements SysRoleService{

	@Autowired
	private SysRoleMapper sysRoleMapper;

	public int deleteByPrimaryKey(String roleId) {
		
		return sysRoleMapper.deleteByPrimaryKey(roleId);
	}

	public int insertRole(SysRole record) {
	
		return sysRoleMapper.insertRole(record);
	}

	public SysRole selectByPrimaryKey(String roleId) {
		
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}

	public int updateRole(SysRole record) {
		
		return sysRoleMapper.updateRole(record);
	}

	public int checkRoleNameUnique(String roleName) {
	
		return sysRoleMapper.checkRoleNameUnique(roleName);
	}

	public List<SysRole> selectAll() {
		
		return sysRoleMapper.selectAll();
	}

	public int checkRoleKeyUnique(String roleKey) {
		
		return sysRoleMapper.checkRoleKeyUnique(roleKey);
	}
}
