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
 * ��¼���Ʋ�
 * @author chen gen
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	/** �û���¼ ��֤
	 * UsernamePassowrdToken  ������Ҫ��SimpleAuthenticationInfo���Ӧ
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
			  /** �����û���ȡ�û�������ɫid */
	        String[] rolesId = sysUserRoleMapper.selectByUserId(user.getUserId());
	        
	        /** ��ȡ��ɫ���� �����Ƿ�Ϊadmin*/
	        for (int i = 0; i < rolesId.length; i++) {
	        	String roleKey = sysRoleMapper.selectByPrimaryKey(rolesId[i]).getRoleKey();
	        	if(roleKey.equals("admin")) {
	        		user.setAdmin(true);
	        	}
	        }
	        
			return AjaxResult.success(null, null);
		}catch (Exception e) {
			return AjaxResult.error("�û��������������", null);
		}
		
	}
	/** ��ת��login.jsp */
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
}
