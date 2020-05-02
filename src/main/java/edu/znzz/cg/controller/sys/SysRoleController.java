package edu.znzz.cg.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.znzz.cg.dao.SysRoleMapper;
import edu.znzz.cg.entity.SysRole;
import edu.znzz.cg.tools.UuidTool;

@Controller
@RequestMapping("/role")
public class SysRoleController {
	
	@Autowired
	SysRoleMapper sysRoleMapper;
	
	@PostMapping("/addsave")
	@ResponseBody
	public String saveRole(SysRole sysRole) {
		System.out.println("123");
		String roleName = sysRole.getRoleName();
		int roleUnique = sysRoleMapper.checkRoleNameUnique(roleName);
		if(roleUnique > 0) {
			// 直接返回错误 角色名称重复
			
		}
		String roleKey = sysRole.getRoleKey();
		int roleKeyUnique = sysRoleMapper.checkRoleKeyUnique(roleKey);
		if(roleKeyUnique > 0) {
			// 角色key重复
		} 
		
		sysRole.setRoleId(UuidTool.getUuid());
		sysRoleMapper.insertRole(sysRole);
		return null;
	}

	
}
