package edu.znzz.cg.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.znzz.cg.dao.SysRoleMapper;
import edu.znzz.cg.dao.SysUserRoleMapper;
import edu.znzz.cg.entity.SysUser;
import edu.znzz.cg.tools.AjaxResult;



/**
 * 登录控制层
 * @author chen gen
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	/** 用户登录 验证
	 * UsernamePassowrdToken  的密码要和SimpleAuthenticationInfo相对应
	 */

	@RequestMapping("/tologin")
	@ResponseBody
	public AjaxResult tologin(String username,String password,Boolean rememberMe) {
		System.out.println( username+"\r"+password + "\r"+rememberMe);
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			
			SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
			  /** 根据用户获取用户所属角色id */
	        String[] rolesId = sysUserRoleMapper.selectByUserId(user.getUserId());
	        
	        /** 获取角色集合 设置是否为admin*/
	        for (int i = 0; i < rolesId.length; i++) {
	        	String roleKey = sysRoleMapper.selectByPrimaryKey(rolesId[i]).getRoleKey();
	        	if(roleKey.equals("admin")) {
	        		user.setAdmin(true);
	        	}
	        }
	        
			return AjaxResult.success(null, null);
		}catch (Exception e) {
			return AjaxResult.error("用户名或者密码错误", null);
		}
		
	}
	/** 跳转到login.jsp */
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
}
