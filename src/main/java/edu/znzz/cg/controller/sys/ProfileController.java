package edu.znzz.cg.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 个人信息控制层
 * @author chen gen
 *
 */
@Controller
@RequestMapping("/system/user/profile")
public class ProfileController {
	
	private static String prefix = "system/user/profile";
	
	@RequestMapping()
	public String toProfilePage() {
		return prefix + "profile";
	}
}
