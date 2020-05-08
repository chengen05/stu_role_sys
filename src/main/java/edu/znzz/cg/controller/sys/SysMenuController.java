package edu.znzz.cg.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.znzz.cg.dao.SysMenuMapper;
import edu.znzz.cg.dao.SysRoleMapper;
import edu.znzz.cg.dao.SysRoleMenuMapper;
import edu.znzz.cg.entity.SysMenu;
import edu.znzz.cg.entity.SysRole;
import edu.znzz.cg.entity.SysZtree;
import edu.znzz.cg.service.inter.SysMenuService;
import edu.znzz.cg.tools.AjaxResult;
import edu.znzz.cg.tools.UuidTool;

@Controller
@RequestMapping("/system/menu")
public class SysMenuController {
	private static String prefix = "system/menu";
	
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	
	@Autowired
	private SysMenuService SysMenuService;
	/**
	 * �������
	 * @param sysMenu
	 * @return
	 */
	@PostMapping("/addsave")
	@ResponseBody
	public AjaxResult saveMenu(SysMenu sysMenu) {
		// У��˵�����
		int checkNameValue = sysMenuMapper.checkMenuNameUnique(sysMenu.getMenuName());
		if(checkNameValue > 0) {
			return AjaxResult.error("�Ѵ��ڸò˵�����", null);
		}
		// У��shiro-key
		int checkshiroValue = sysMenuMapper.checkMenuKeyUnique(sysMenu.getPermsKey());
		if(checkshiroValue > 0) {
			return AjaxResult.error("�Ѵ��ڲ˵�����", null);
		}
		sysMenu.setMenuId(UuidTool.getUuid());
		sysMenuMapper.insertMenu(sysMenu);
		return AjaxResult.success("�˵���ӳɹ�", null);
	}
	/**
	 * menu��ʾ
	 * @return
	 */
	@RequestMapping()
	public String menuPage() {
		return prefix + "/menu";
	}
	
	/**
	 * �˵�������ʾ
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
	 * ��ӽ���
	 * @param parentId
	 * @param model
	 * @return
	 */

	@GetMapping("/add/{parentId}")
	public String add(@PathVariable("parentId") String parentId, Model model) {
		SysMenu sysMenu = null;
		if( parentId != null && parentId != "" && !parentId.equals("x")) {
			/** ����parentid��ѯ�����˵� */
			sysMenu = sysMenuMapper.selectByPrimaryKey(parentId);
		}
		else {
			sysMenu = new SysMenu();
			sysMenu.setParentId("#");
			sysMenu.setMenuName("��Ŀ¼");
		}
		model.addAttribute("sysMenu", sysMenu);
		return  prefix + "/add";
	}
	/**
	 * �޸Ľ���
	 * @param menuId
	 * @param model
	 * @return
	 */
	@GetMapping("/update")
	public String edit(String menuId, Model model) {
		SysMenu sysmenu = null;
		String parentName = null;
		if(menuId != null && !menuId.equals("")) {
			sysmenu = sysMenuMapper.selectByPrimaryKey(menuId);
			String parentId = sysmenu.getParentId();
			if(parentId != null && !parentId.equals("")) {
				parentName = sysMenuMapper.selectByPrimaryKey(parentId).getMenuName();
			}else {
				parentName = "��Ŀ¼";
			}
		}
		model.addAttribute("sysMenu", sysmenu);
		model.addAttribute("parentName", parentName);
		return prefix + "/edit";
	}
	/**
	 * �˵�У��
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
	
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		if(ids != null && ids !="") {
			List<SysMenu> childrenMenu = sysMenuMapper.selectMenuByParentId(ids);
			int sizeChildren = childrenMenu.size();
			if(sizeChildren > 0) {
				 return AjaxResult.warn("�����Ӳ˵�,������ɾ��",null);
			}
			if(sysRoleMenuMapper.selectCountRoleMenuByMenuId(ids) > 0) {
				  return AjaxResult.warn("�˵��ѷ���,������ɾ��",null);
			}
			int del = sysMenuMapper.deleteByPrimaryKey(ids);
			if(del <= 0) {
				return AjaxResult.error("ɾ��ʧ��", null);
			}
		}
		return AjaxResult.success(null, null);
	}
	/**
	 * �޸ı���
	 * @param sysMenu
	 * @return
	 */
	@PostMapping("/editsave")
	@ResponseBody
	public AjaxResult editSave(SysMenu sysMenu) {
		int saveValue = sysMenuMapper.updateMenu(sysMenu);
		if(saveValue <= 0) {
			return AjaxResult.warn("�༭ʧ�ܣ�", null);
		}
		return AjaxResult.success(null, null);
	}
	
	/***
	 * �˵���
	 * @param sysRole
	 * @return
	 */
	@GetMapping("/roleMenuTree")
	@ResponseBody
	public List<SysZtree> roleMenuTree(SysRole sysRole){
		List<SysZtree> ztree = SysMenuService.roleMenuTree(sysRole);
		return ztree;
	}
}
