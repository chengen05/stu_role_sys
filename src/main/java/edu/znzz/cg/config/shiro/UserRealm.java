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
    /*Ȩ����֤*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	System.out.println("---------------------����userRealm Ȩ����֤");
    	/** Ȩ��  */
        Set<String> permissionSet = new HashSet<String>();
        /** ��ɫ */
        Set<String> roleSet = new HashSet<String>();
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SysUser user = sysUserMapper.selectByLoginName(username);
        if (user != null) {
          
                /** �����û���ȡ�û�������ɫid */
                String[] rolesId = sysUserRoleMapper.selectByUserId(user.getUserId());
                
                /** ��ȡ��ɫ����*/
                for (int i = 0; i < rolesId.length; i++) {
                	roleSet.add(sysRoleMapper.selectByPrimaryKey(rolesId[i]).getRoleKey());
				}
               
                /** ���ݽ�ɫid��ȡȨ�޼��� */
                
                 permissionSet = sysMenuMapper.selectPermsByUserId(user.getUserId());
 
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);
        return info;
    }
 
 
    /*�����֤*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    	String userName = token.getUsername();
        String userPwd = new String(token.getPassword());
        SysUser user = sysUserMapper.selectByLoginName(userName);
        String password = "";
        if (user == null) {
            throw new UnknownAccountException("�˻�������");
        } else {
            //�����û��������ݿ��ȡ����
            password = user.getPassword();
            if (!PasswordTool.encryptPassword(userPwd, user.getSalt()).equals(password)) {
                throw new IncorrectCredentialsException("�˻������벻��ȷ");
            }
            
            /** ��Ҫ�ж��Ƿ�Ϊadmin*/
            /** �����û���ȡ�û�������ɫid */
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
