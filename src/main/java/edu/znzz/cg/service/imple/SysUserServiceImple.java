package edu.znzz.cg.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.znzz.cg.dao.SysUserMapper;
import edu.znzz.cg.entity.SysUser;
import edu.znzz.cg.service.inter.SysUserService;

/**
 * sysuser service
 * @author chen gen
 *
 */
@Service
public class SysUserServiceImple implements SysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;

	public int insert(SysUser record) {
		
		return sysUserMapper.insert(record);
	}

	public int update(SysUser record) {

		return sysUserMapper.update(record);
	}

	public int deleteByPrimaryKey(String userId) {
		
		return sysUserMapper.deleteByPrimaryKey(userId);
	}

	public SysUser selectByPrimaryKey(String userId) {
	
		return sysUserMapper.selectByPrimaryKey(userId);
	}

	public List<SysUser> selectAll() {
	
		return sysUserMapper.selectAll();
	}

	public SysUser selectByPhoneNum(String phoneNum) {
	
		return sysUserMapper.selectByPhoneNum(phoneNum);
	}

	public SysUser selectByEmail(String email) {
		
		return sysUserMapper.selectByEmail(email);
	}

	public SysUser selectByLoginName(String loginName) {
		
		return sysUserMapper.selectByLoginName(loginName);
	}

	public SysUser checkLoginNameUnique(String loginName) {
		
		return sysUserMapper.checkLoginNameUnique(loginName);
	}

	public SysUser checkPhoneUnique(String phoneNum) {
		
		return sysUserMapper.checkPhoneUnique(phoneNum);
	}

	public List<SysUser> selectListByUser(SysUser sysuser) {
		
		return sysUserMapper.selectListByUser(sysuser);
	}

	public SysUser checkEmailUnique(String email) {
		
		return sysUserMapper.checkEmailUnique(email);
	}

	public SysUser checkIdCardUnique(String idcard) {
		
		return sysUserMapper.checkIdCardUnique(idcard);
	}




}
