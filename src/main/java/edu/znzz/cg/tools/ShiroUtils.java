package edu.znzz.cg.tools;





import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

import edu.znzz.cg.entity.SysUser;
/**
 * shiro����
 * @author chen gen
 *
 */
public class ShiroUtils {
	/**
	 * �޸�shiro��user
	 * @param sysUser
	 */
	public static void setUser(SysUser sysUser) {
	    Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(sysUser, realmName);
        // ���¼���Principal
        subject.runAs(newPrincipalCollection);
	}
}
