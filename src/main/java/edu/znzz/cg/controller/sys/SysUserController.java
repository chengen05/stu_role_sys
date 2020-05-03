package edu.znzz.cg.controller.sys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.znzz.cg.dao.SysClazzMapper;
import edu.znzz.cg.dao.SysDepartMapper;
import edu.znzz.cg.dao.SysRoleMapper;
import edu.znzz.cg.dao.SysUserMapper;
import edu.znzz.cg.dao.SysUserRoleMapper;
import edu.znzz.cg.entity.SysClazz;
import edu.znzz.cg.entity.SysDepart;
import edu.znzz.cg.entity.SysRole;
import edu.znzz.cg.entity.SysUser;
import edu.znzz.cg.entity.SysUserRoleKey;
import edu.znzz.cg.tools.AjaxResult;
import edu.znzz.cg.tools.PasswordTool;
import edu.znzz.cg.tools.TableDataInfo;
import edu.znzz.cg.tools.UuidTool;

@Controller
@RequestMapping("/system/user")
public class SysUserController {
	
	private String prefix = "system/user";
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Autowired
	private SysClazzMapper sysClazzMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysDepartMapper sysDepartMapper;
	/**
	 * 跳转到user界面
	 * @return
	 * 
	 */
	@RequestMapping()
	public String user(Model model) {
		List<SysDepart> departs = sysDepartMapper.selectAllDepart();
		model.addAttribute("departs", departs);
		return prefix + "/user";
	}
	/**
	 * 添加保存用户
	 * @param sysUser
	 * @return
	 */
	@PostMapping("/addsave")
	@ResponseBody
	public AjaxResult saveuser(SysUser sysUser) {
		SysUser user = sysUserMapper.checkLoginNameUnique(sysUser.getLoginName());
		int checkLoginName = user != null? 1:0;
		if(checkLoginName > 0) {
			return  AjaxResult.error("账号重复", null);
		}
		try {
			sysUser.setUserId(UuidTool.getUuid());
			sysUser.setSalt(PasswordTool.getRandomSalt());
			sysUser.setDelFlag("0");
			sysUser.setPassword(PasswordTool.encryptPassword(sysUser.getPassword(), sysUser.getSalt()));
			sysUserMapper.insert(sysUser);
			SysUserRoleKey sysUserRoleKey = new SysUserRoleKey();
			sysUserRoleKey.setUserId(sysUser.getUserId());
			// 进入系统默认为游客角色,再通过修改角色.
			sysUserRoleKey.setRoleId(sysUser.getRoleIds()[0]);
			sysUserRoleMapper.insert(sysUserRoleKey);
		}catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("服务器错误", null);
		}
		return AjaxResult.success(null, null);
	}
	/**
	 * 跳转到添加界面
	 * @return
	 */
	@GetMapping("/add")
	public String toadd(Model model) {
		/** 给页面赋值*/
		List<SysClazz> clazzs = sysClazzMapper.selectAllClazz();
		List<SysDepart> departs = sysDepartMapper.selectAllDepart();
		List<SysRole> roles = sysRoleMapper.selectAll();
		List<SysRole> rolesdisplay = new ArrayList<SysRole>();
		/** 处理一下role，不显示禁用角色 */
		for (SysRole sysRole : roles) {
			if(sysRole.getStatus().equals("0")) {
				rolesdisplay.add(sysRole);
				}
			}
 		model.addAttribute("clazzs", JSON.toJSONString(clazzs));
 		model.addAttribute("departs", departs);
 		model.addAttribute("roles", rolesdisplay);
		return prefix + "/add";
	}
	
	/**
	 * 条件查询系统用户,分页
	 * @param pageNum
	 * @param pageSize
	 * @param sysuser
	 * @return tableDataInfo
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo DataInfoUser(SysUser sysuser) {
		TableDataInfo subData = new TableDataInfo();
	//	if(1 != 0) {
			PageHelper.startPage(1,20);
			List<SysUser> userList = sysUserMapper.selectListByUser(sysuser);
			subData.setRows(userList);
			subData.setTotal(new PageInfo<SysUser>(userList).getTotal());
	//	}
//		else {
//			subData.setCode(403);
//			subData.setTotal(0L);
//			subData.setData(null);
//		}
		return subData;
	}
	/***
	 * 登录名校验
	 * @param loginName
	 * @return
	 */
	@PostMapping("/checkLoginNameUnique")
	@ResponseBody
	public String checkLoginName(String loginName) {
		SysUser user = sysUserMapper.checkLoginNameUnique(loginName);
		if(user!= null) {
			return "false";
		}
		return null;
	}
	/**
	 * 电话校验
	 * @param phoneNum
	 * @return
	 */
	@PostMapping("/checkPhoneUnique")
	@ResponseBody
	public String checkPhoneNum(String phonenumber) {
		SysUser user = sysUserMapper.checkPhoneUnique(phonenumber);
		if(user!= null) {
			return "false";
		}
		return null;
	}
	/***
	 * email校验
	 * @param email
	 * @return
	 */
	@PostMapping("/checkEmailUnique")
	@ResponseBody
	public String checkEmailUnique(String email) {

		SysUser user = sysUserMapper.checkEmailUnique(email);
		if(user!= null) {
			return "false";
		}
		return null;
	}
	/**
	 * 校验身份证号
	 * @param card
	 * @return
	 */
	@PostMapping("/checkIdCardUnique")
	@ResponseBody
	public String checkIdCardUnique(String card) {
		SysUser user = sysUserMapper.checkIdCardUnique(card);
		if(user!= null) {
			return "false";
		}
		return null;
	}
	/**
	 * 修改界面
	 * @return
	 */
	@GetMapping("/update")
	public String toupdate(String id,Model model) {
		SysUser user = sysUserMapper.selectByPrimaryKey(id);
		user.setAdmin(false);
		user.setPassword(null);
		user.setSalt(null);
		/** 给页面赋值*/
		List<SysClazz> clazzs = sysClazzMapper.selectAllClazz();
		List<SysDepart> departs = sysDepartMapper.selectAllDepart();
		List<SysRole> roles = sysRoleMapper.selectAll();
		List<SysRole> rolesdisplay = new ArrayList<SysRole>();
		/** 处理一下role，不显示禁用角色 */
		for (SysRole sysRole : roles) {
			if(sysRole.getStatus().equals("0")) {
				rolesdisplay.add(sysRole);
				}
			}
 		model.addAttribute("clazzs", JSON.toJSONString(clazzs));
 		model.addAttribute("departs", departs);
 		model.addAttribute("roles", rolesdisplay);
 		model.addAttribute("user", user);
		return prefix + "/edit";
	}
	/**
	 * 修改保存
	 * @param sysUser
	 * @return AjaxResult
	 */
	@PostMapping("/updatesave")
	@ResponseBody
	public AjaxResult updateSave(SysUser sysUser) {
		/** 修改后角色id*/
		String roleId = sysUser.getRoleIds()[0];
		/** 原本角色要删除   先获取 */
		SysUser userorigin = sysUserMapper.selectByPrimaryKey(sysUser.getUserId());
		String roleOrigin = userorigin.getRoles().get(0).getRoleId();
		try {
			sysUserMapper.update(sysUser);
			sysUserRoleMapper.deleteByPrimaryKey(new SysUserRoleKey(sysUser.getUserId(),roleOrigin));
			sysUserRoleMapper.insert(new SysUserRoleKey(sysUser.getUserId(),roleId));
		}catch(Exception e) {
			return AjaxResult.error("服务器错误", null);
		}
		return AjaxResult.success(null, null);
	}
	/**
	 * 删除用户
	 * @param ids
	 * @return AjaxResult
	 */
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		System.out.println("ids" + ids);
		return AjaxResult.success(null, null);
	}
}
