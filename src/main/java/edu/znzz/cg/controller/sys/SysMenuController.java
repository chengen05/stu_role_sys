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
		System.out.println("-----------menu���");
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
	 * ���
	 * @param parentId
	 * @param model
	 * @return
	 */

	@GetMapping("/add/{parentId}")
	public String add(String parentId, Model model) {
		SysMenu sysMenu = null;
		if(parentId != "" && parentId != null) {
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
	 * �˵�ͼ��
	 * @return
	 */
	@GetMapping("/icon")
	public String menuIcon() {
		return prefix + "/icon";
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
	

	
}
