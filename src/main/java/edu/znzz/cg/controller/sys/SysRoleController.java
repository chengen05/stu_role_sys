package edu.znzz.cg.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.znzz.cg.dao.SysRoleMapper;
import edu.znzz.cg.dao.SysUserRoleMapper;
import edu.znzz.cg.entity.SysRole;
import edu.znzz.cg.entity.SysUser;
import edu.znzz.cg.service.inter.SysRoleService;
import edu.znzz.cg.tools.AjaxResult;
import edu.znzz.cg.tools.TableDataInfo;
import edu.znzz.cg.tools.UuidTool;

@Controller
@RequestMapping("/system/role")
public class SysRoleController {
	private static String prefix = "system/role";
	@Autowired
	SysRoleMapper sysRoleMapper;
	
	@Autowired
	SysRoleService sysRoleService;
	
	@Autowired
	SysUserRoleMapper sysUserRoleMapper;
	
	@PostMapping("/addsave")
	@ResponseBody
	public AjaxResult saveRole(SysRole sysRole) {
		System.out.println(sysRole.toString());
		String roleName = sysRole.getRoleName();
		int roleUnique = sysRoleMapper.checkRoleNameUnique(roleName);
		if(roleUnique > 0) {
			// 直接返回错误 角色名称重复
			return AjaxResult.warn("角色名称重复", null);
			
		}
		String roleKey = sysRole.getRoleKey();
		int roleKeyUnique = sysRoleMapper.checkRoleKeyUnique(roleKey);
		if(roleKeyUnique > 0) {
			// 角色key重复
			return AjaxResult.warn("key重复", null);
		} 
		
		sysRole.setRoleId(UuidTool.getUuid());
		 int rows = sysRoleService.insertRole(sysRole);
		if(rows <= 0) {
			
			return AjaxResult.error("添加失败", null);
		}
		
		return AjaxResult.success(null, null);
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
	/**
	 * 修改界面
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/update")
	public String edit(String id,Model model) {
		SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
		model.addAttribute("sysRole", sysRole);
		return prefix + "/edit";
	}
	
	@PostMapping("/checkRoleNameUnique")
	@ResponseBody
	public String checkRoleName(SysRole sysRole) {
		int countValue = sysRoleMapper.selectByRole(sysRole).size();
		if(countValue > 0) {
			return "重复";
		}
		return null;
	}
	@PostMapping("/checkRoleKeyUnique")
	@ResponseBody
	public String checkRoleKey(SysRole sysRole) {
		int countValue = sysRoleMapper.selectByRole(sysRole).size();
		if(countValue > 0) {
			return "重复";
		}
		return null;
	}
	/**
	 * 删除角色
	 * @param id
	 * @return ajaxResult
	 */
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String id) {
		if(id != null && !id.equals("")) {
			String[] userIds = sysUserRoleMapper.selectByRoleId(id);
			if(userIds.length > 0) {
				return AjaxResult.warn("该角色已经被分配给用户,不允许删除", null);
			}
		}
		return null;
	}
}
