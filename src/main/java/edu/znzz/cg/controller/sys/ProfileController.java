package edu.znzz.cg.controller.sys;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.znzz.cg.dao.SysClazzMapper;
import edu.znzz.cg.dao.SysDepartMapper;
import edu.znzz.cg.dao.SysUserMapper;
import edu.znzz.cg.entity.SysUser;
import edu.znzz.cg.tools.AjaxResult;
import edu.znzz.cg.tools.PasswordTool;
import edu.znzz.cg.tools.ShiroUtils;


/**
 * ������Ϣ���Ʋ�
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
	 * ��ת��������Ϣ
	 * 
	 * @return
	 */
	@RequestMapping()
	public String toProfilePage(Model model) {
		/** ��ȡ��ǰ�û�*/
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		String departName = sysDepartMapper.selectByPrimaryKey(user.getDepartId()).getDepartName();
		String clazzName= sysClazzMapper.selectByPrimaryKey(user.getClazzId()).getClazzName();
		model.addAttribute("depart", departName);
		model.addAttribute("clazz", clazzName);
		model.addAttribute("user", user);
		return prefix + "/profile";
	}
	/**
	 * ���¸�����Ϣ
	 * @param sysUser
	 * @return AjaxResult
	 */
	@PostMapping("/update")
	@ResponseBody
	public AjaxResult updateSave(SysUser sysUser) {
		try {
			sysUserMapper.update(sysUser);
		}catch (Exception e) {
			return AjaxResult.error("����", null);
		}
	//	ShiroUtils.setUser(sysUser);
		return AjaxResult.success(null, null);
	}
	/**
	 * У������
	 * @param pwd
	 * @return String 
	 */
	@GetMapping("/checkPassword")
	@ResponseBody
	public boolean checkPassword(String oldPassword) {
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		System.out.println(user.getPassword() +"\t"+ user.getSalt());
		String Pwd = PasswordTool.encryptPassword(oldPassword, user.getSalt());
		if(Pwd.equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	@PostMapping("/resetPwd")
	@ResponseBody
	public AjaxResult changePwd(String oldPassword,String newPassword) {
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		String pwd =  PasswordTool.encryptPassword(oldPassword, user.getSalt());
		if(newPassword != null && pwd.equals(user.getPassword())) {
			user.setPassword(PasswordTool.encryptPassword(newPassword, user.getSalt()));
			int value = sysUserMapper.update(user);
			if(value <= 0) {
				return AjaxResult.error(null, null);
			}
			//ShiroUtils.setUser(user);
		}
		return AjaxResult.success(null, null);
	}
}
