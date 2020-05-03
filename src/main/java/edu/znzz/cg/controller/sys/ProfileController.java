package edu.znzz.cg.controller.sys;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.znzz.cg.dao.SysClazzMapper;
import edu.znzz.cg.dao.SysDepartMapper;
import edu.znzz.cg.entity.SysUser;


/**
 * ������Ϣ���Ʋ�
 * @author chen gen
 *
 */
@Controller
@RequestMapping("/system/user/profile")
public class ProfileController {
	
	private static String prefix = "system/user/profile";
	
	@Autowired
	private SysDepartMapper sysDepartMapper;
	
	@Autowired
	private SysClazzMapper sysClazzMapper;
	/**
	 * ��ת��������Ϣ
	 * 
	 * @return
	 */
	@RequestMapping()
	public String toProfilePage(Model model) {
		/** ��ȡ��ǰ�û�*/
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		System.out.println(user.toString());
		String departName = sysDepartMapper.selectByPrimaryKey(user.getDepartId()).getDepartName();
		String clazzName= sysClazzMapper.selectByPrimaryKey(user.getClazzId()).getClazzName();
		model.addAttribute("depart", departName);
		model.addAttribute("clazz", clazzName);
		model.addAttribute("user", user);
		return prefix + "/profile";
	}
}
