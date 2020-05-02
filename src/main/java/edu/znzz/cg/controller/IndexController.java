package edu.znzz.cg.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import edu.znzz.cg.dao.SysMenuMapper;
import edu.znzz.cg.entity.SysMenu;
import edu.znzz.cg.entity.SysUser;

/**
 * ��ҳ
 * @author chen gen
 *
 */
@Controller
public class IndexController {
	
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@GetMapping("/index")
	public String index(ModelMap map) {
		/** ȡ���û� */
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		List<SysMenu> menus = new ArrayList<SysMenu>();
		/** �����û�ȡ����Ӧ�˵�*/
        if(user.isAdmin()) {
        	menus = sysMenuMapper.selectAllMenu();	
        }else {
        	menus = sysMenuMapper.selectMenusByUserId(user.getUserId());
        }
		map.put("menus", menus);
		map.put("user", user);
		return "index";
	}
	@GetMapping("/system/main")
	public String notices() {
		
		return "main";
	}
}
