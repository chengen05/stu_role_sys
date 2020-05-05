package edu.znzz.cg.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.znzz.cg.dao.SysMenuMapper;
import edu.znzz.cg.entity.SysMenu;
import edu.znzz.cg.tools.AjaxResult;
import edu.znzz.cg.tools.UuidTool;

@Controller
@RequestMapping("/system/menu")
public class SysMenuController {
	private static String prefix = "system/menu";
	
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@PostMapping("/addsave")
	@ResponseBody
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
	/**
	 * menu显示
	 * @return
	 */
	@RequestMapping()
	public String menuPage() {
		return prefix + "/menu";
	}
	
	/**
	 * 菜单树表显示
	 * @param sysMenu
	 * @return
	 */
	@PostMapping("/list")
	@ResponseBody
	public List<SysMenu> list(SysMenu sysMenu){
		List<SysMenu> menuList = sysMenuMapper.selectMenusByMenu(sysMenu);
		return menuList;
	}
	/**
	 * 添加
	 * @param parentId
	 * @param model
	 * @return
	 */

	@GetMapping("/add/{parentId}")
	public String add(String parentId, Model model) {
		SysMenu sysMenu = null;
		if(parentId != "" && parentId != null) {
			/** 根据parentid查询出主菜单 */
			sysMenu = sysMenuMapper.selectByPrimaryKey(parentId);
		}
		else {
			sysMenu = new SysMenu();
			sysMenu.setParentId("#");
			sysMenu.setMenuName("主目录");
		}
		model.addAttribute("sysMenu", sysMenu);
		return  prefix + "/add";
	}
	/**
	 * 菜单图标
	 * @return
	 */
	@GetMapping("/icon")
	public String menuIcon() {
		return prefix + "/icon";
	}
	/**
	 * 菜单校验
	 * @param sysMenu
	 * @return
	 */
	@PostMapping("/checkUnique")
	@ResponseBody
	public String checkUnique(SysMenu sysMenu) {
		int checkValue = sysMenuMapper.checkMenuNameUnique(sysMenu.getMenuName());
		if(checkValue > 0) {
			return "false";
		}
		return null;
	}
	

	
}
