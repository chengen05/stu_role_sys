package edu.znzz.cg.dao;

import java.util.List;

import edu.znzz.cg.entity.SysDepart;
/**
 * depart
 * @author chen gen
 *
 */
public interface SysDepartMapper {
	
    int deleteByPrimaryKey(String departId);
    /**
     * 插入
     * @param record
     * @return
     */
    int insertDepart(SysDepart record);
    /**
     * departId查询
     * @param departId
     * @return
     */
    SysDepart selectByPrimaryKey(String departId);
    /**
     * 修改院系
     * @param record
     * @return
     */
    int updateDepart(SysDepart record);
    /**
     * 校验院系名称是否正确
     * @param departName
     * @return
     */
    int checkDepartNameUnique(String departName);
    /**
     * 查询所有depart
     * @return
     */
    List<SysDepart> selectAllDepart();
}