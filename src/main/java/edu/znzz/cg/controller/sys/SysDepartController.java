package edu.znzz.cg.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * Ôº ¿ØÖÆ²ã
 * @author chen gen
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;

import edu.znzz.cg.dao.SysDepartMapper;
import edu.znzz.cg.entity.SysDepart;
import edu.znzz.cg.tools.UuidTool;
@Controller
@RequestMapping("/depart")
public class SysDepartController {
	
	@Autowired
	private SysDepartMapper sysDepartMapper;
	
	@PostMapping("/addsave")
	public String addsave(SysDepart sysDepart) {
	
		sysDepart.setDepartId(UuidTool.getUuid());
		sysDepartMapper.insertDepart(sysDepart);
		return null;
	}
}
