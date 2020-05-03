package edu.znzz.cg.controller.sys;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.znzz.cg.dao.SysClazzMapper;
import edu.znzz.cg.dao.SysDepartMapper;
import edu.znzz.cg.dao.SysUserMapper;
import edu.znzz.cg.entity.SysUser;
import edu.znzz.cg.tools.AjaxResult;


/**
 * 个人信息控制层
 * @author chen gen
 *
 */
@Controller
@RequestMapping("/system/user/profile")
public class ProfileController {
	
	private static String prefix = "system/user/profile";
	
	@Autowired
	private SysDepartMapper sysDepartMapper;
	
	@Autowired
	private SysClazzMapper sysClazzMapper;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	/**
	 * 跳转到个人信息
	 * 
	 * @return
	 */
	@RequestMapping()
	public String toProfilePage(Model model) {
		/** 获取当前用户*/
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		String departName = sysDepartMapper.selectByPrimaryKey(user.getDepartId()).getDepartName();
		String clazzName= sysClazzMapper.selectByPrimaryKey(user.getClazzId()).getClazzName();
		model.addAttribute("depart", departName);
		model.addAttribute("clazz", clazzName);
		model.addAttribute("user", user);
		return prefix + "/profile";
	}
	@PostMapping("/update")
	@ResponseBody
	public AjaxResult updateSave(SysUser sysUser) {
		try {
			sysUserMapper.update(sysUser);
		}catch (Exception e) {
			return AjaxResult.error("错误", null);
		}
		return AjaxResult.success(null, null);
	}
}
