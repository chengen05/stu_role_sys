package edu.znzz.cg.config.shiro;



import edu.znzz.cg.dao.SysMenuMapper;
import edu.znzz.cg.dao.SysRoleMapper;
import edu.znzz.cg.dao.SysUserMapper;
import edu.znzz.cg.dao.SysUserRoleMapper;
import edu.znzz.cg.entity.SysUser;
import edu.znzz.cg.tools.PasswordTool;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
 
import java.util.HashSet;
import java.util.Set;

 

 
public class UserRealm extends AuthorizingRealm {
   
    @Autowired
    private SysUserMapper sysUserMapper;
 
 
    @Autowired
    private SysMenuMapper sysMenuMapper;
 
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    
    @Autowired
    private SysRoleMapper sysRoleMapper;
    /*权限认证*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	System.out.println("---------------------进入userRealm 权限认证");
    	/** 权限  */
        Set<String> permissionSet = new HashSet<String>();
        /** 角色 */
        Set<String> roleSet = new HashSet<String>();
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SysUser user = sysUserMapper.selectByLoginName(username);
        if (user != null) {
          
                /** 根据用户获取用户所属角色id */
                String[] rolesId = sysUserRoleMapper.selectByUserId(user.getUserId());
                
                /** 获取角色集合*/
                for (int i = 0; i < rolesId.length; i++) {
                	roleSet.add(sysRoleMapper.selectByPrimaryKey(rolesId[i]).getRoleKey());
				}
               
                /** 根据角色id获取权限集合 */
                
                 permissionSet = sysMenuMapper.selectPermsByUserId(user.getUserId());
 
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);
        return info;
    }
 
 
    /*身份认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    	String userName = token.getUsername();
        String userPwd = new String(token.getPassword());
        SysUser user = sysUserMapper.selectByLoginName(userName);
        String password = "";
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        } else {
            //根据用户名从数据库获取密码
            password = user.getPassword();
            if (!PasswordTool.encryptPassword(userPwd, user.getSalt()).equals(password)) {
                throw new IncorrectCredentialsException("账户或密码不正确");
            }
            
            /** 主要判断是否为admin*/
            /** 根据用户获取用户所属角色id */
            String[] rolesId = sysUserRoleMapper.selectByUserId(user.getUserId());
            for (int i = 0; i < rolesId.length; i++) {
            	String roleKey =  sysRoleMapper.selectByPrimaryKey(rolesId[i]).getRoleKey();
            	if(roleKey.equals("admin")) {
            		user.setAdmin(true);
            	}
			}
        }
         return new SimpleAuthenticationInfo(user, userPwd, getName());
    }
 
    @Override
    protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
