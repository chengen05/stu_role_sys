package edu.znzz.cg.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.znzz.cg.dao.SysMenuMapper;
import edu.znzz.cg.entity.SysMenu;
import edu.znzz.cg.tools.AjaxResult;
import edu.znzz.cg.tools.UuidTool;

@Controller
@RequestMapping("/menu")
public class SysMenuController {
	
	
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@PostMapping("/addsave")
	public AjaxResult saveMenu(SysMenu sysMenu) {
		System.out.println("-----------menu添加");
		// 校验菜单名称
		int checkNameValue = sysMenuMapper.checkMenuNameUnique(sysMenu.getMenuName());
		if(checkNameValue > 0) {
			return AjaxResult.error("已存在该菜单名称", null);
		}
		// 校验shiro-key
		int checkshiroValue = sysMenuMapper.checkMenuKeyUnique(sysMenu.getPermsKey());
		if(checkshiroValue > 0) {
			return AjaxResult.error("已存在菜单参数", null);
		}
		sysMenu.setMenuId(UuidTool.getUuid());
		sysMenuMapper.insertMenu(sysMenu);
		return AjaxResult.success("菜单添加成功", null);
	}
}
