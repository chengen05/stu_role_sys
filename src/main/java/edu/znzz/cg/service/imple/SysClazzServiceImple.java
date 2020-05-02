package edu.znzz.cg.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.znzz.cg.dao.SysClazzMapper;
import edu.znzz.cg.entity.SysClazz;
import edu.znzz.cg.service.inter.SysClazzService;
/**
 * clazz service
 * @author chen gen
 *
 */

@Service
public class SysClazzServiceImple implements SysClazzService{

	@Autowired
	private SysClazzMapper sysClazzMapper;

	public int deleteByPrimaryKey(String clazzId) {
		
		return sysClazzMapper.deleteByPrimaryKey(clazzId);
	}

	public int insertClazz(SysClazz record) {
		
		return sysClazzMapper.insertClazz(record);
	}

	public SysClazz selectByPrimaryKey(String clazzId) {
		
		return sysClazzMapper.selectByPrimaryKey(clazzId);
	}

	public int updateClazz(SysClazz record) {
		
		return sysClazzMapper.updateClazz(record);
	}

	public List<SysClazz> selectAllClazz() {
		
		return sysClazzMapper.selectAllClazz();
	}
	
}
