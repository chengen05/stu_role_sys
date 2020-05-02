package edu.znzz.cg.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.znzz.cg.dao.SysClazzMapper;
import edu.znzz.cg.entity.SysClazz;
import edu.znzz.cg.tools.AjaxResult;
import edu.znzz.cg.tools.UuidTool;

@Controller
@RequestMapping("/clazz")
public class SysClazzController {
	
	@Autowired
	private SysClazzMapper sysClazzMapper;
	
	@PostMapping("/addsave")
	public AjaxResult saveClazz(SysClazz sysClazz) {
		
		System.out.println("clazz:" + sysClazz.getClazzBrief());
		sysClazz.setClazzId(UuidTool.getUuid());
		int checkValue = sysClazzMapper.insertClazz(sysClazz);
		if(checkValue > 0) {
			return AjaxResult.success("添加成功", null);
		}
		return AjaxResult.error("添加错误", null);
	}
}
