package edu.znzz.cg.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.znzz.cg.dao.SysRoleMapper;
import edu.znzz.cg.entity.SysRole;
import edu.znzz.cg.entity.SysUser;
import edu.znzz.cg.tools.AjaxResult;
import edu.znzz.cg.tools.TableDataInfo;
import edu.znzz.cg.tools.UuidTool;

@Controller
@RequestMapping("/system/role")
public class SysRoleController {
	private static String prefix = "system/role";
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

	@RequestMapping()
	public String toRole() {
		return prefix + "/role";
	}
	/**
	 * 角色查询
	 * @param sysRole
	 * @return tableDataInfo
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo roleList(SysRole sysRole) {
		TableDataInfo subData = new TableDataInfo();
		PageHelper.startPage(1,20);
		List<SysRole> roleList = sysRoleMapper.selectByRole(sysRole);
		subData.setRows(roleList);
		subData.setTotal(new PageInfo<SysRole>(roleList).getTotal());
		return subData;
	}
	/**
	 * 添加界面
	 * @return
	 */
	@GetMapping("/add")
	public String toAdd() {
		return prefix + "/add";
	}
}
