package edu.znzz.cg.service.imple;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.znzz.cg.dao.SysRoleMapper;
import edu.znzz.cg.dao.SysRoleMenuMapper;
import edu.znzz.cg.entity.SysRole;
import edu.znzz.cg.entity.SysRoleMenuKey;
import edu.znzz.cg.entity.SysUser;
import edu.znzz.cg.service.inter.SysRoleService;
/**
 * role 实现层
 * @author chen gen
 *
 */
@Service
public class SysRoleServiceImple implements SysRoleService{

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	
	public int deleteByPrimaryKey(String roleId) {
		
		return sysRoleMapper.deleteByPrimaryKey(roleId);
	}

	public int insertRole(SysRole record) {
		System.out.println("insert:" + record.toString());
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		record.setCreateBy(user.getUserName());
		sysRoleMapper.insertRole(record);
		return insertRoleMenu(record);
	}

	public SysRole selectByPrimaryKey(String roleId) {
		
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}

	public int updateRole(SysRole record) {
		
		return sysRoleMapper.updateRole(record);
	}

	public int checkRoleNameUnique(String roleName) {
	
		return sysRoleMapper.checkRoleNameUnique(roleName);
	}

	public List<SysRole> selectAll() {
		
		return sysRoleMapper.selectAll();
	}

	public int checkRoleKeyUnique(String roleKey) {
		
		return sysRoleMapper.checkRoleKeyUnique(roleKey);
	}

	public List<SysRole> selectByRole(SysRole sysRole) {
		
		return sysRoleMapper.selectByRole(sysRole);
	}
	
	/**
     * 新增角色菜单信息
     * 
     * @param role 角色对象
     */
    public int insertRoleMenu(SysRole role)
    {
        int rows = 1;
        // 新增用户与角色管理
        List<SysRoleMenuKey> list = new ArrayList<SysRoleMenuKey>();
        for (String menuId : role.getMenuIds())
        {
            SysRoleMenuKey rm = new SysRoleMenuKey();
            rm.setRoleId(role.getRoleId());
            rm.setMenuId(menuId);
            list.add(rm);
        }
        if (list.size() > 0)
        {
            rows = sysRoleMenuMapper.batchRoleMenu(list);
        }
        System.out.println("rows:" +rows );
        return rows;
    }
}
