package edu.znzz.cg.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.znzz.cg.dao.SysDepartMapper;
import edu.znzz.cg.entity.SysDepart;
import edu.znzz.cg.service.inter.SysDepartService;

/**
 * depart serviceimple
 * @author chen gen
 *
 */
@Service
public class SysDepartServiceImple implements SysDepartService{

	@Autowired
	private SysDepartMapper sysDepartMapper;

	public int deleteByPrimaryKey(String departId) {

		return sysDepartMapper.deleteByPrimaryKey(departId);
	}

	public int insertDepart(SysDepart record) {

		return sysDepartMapper.insertDepart(record);
	}

	public SysDepart selectByPrimaryKey(String departId) {
	
		return sysDepartMapper.selectByPrimaryKey(departId);
	}

	public int updateDepart(SysDepart record) {
	
		return sysDepartMapper.updateDepart(record);
	}

	public int checkDepartNameUnique(String departName) {
	
		return sysDepartMapper.checkDepartNameUnique(departName);
	}

	public List<SysDepart> selectAllDepart() {
		
		return sysDepartMapper.selectAllDepart();
	}
	
	
}
