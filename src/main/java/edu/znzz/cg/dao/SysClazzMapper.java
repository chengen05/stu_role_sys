package edu.znzz.cg.dao;

import java.util.List;

import edu.znzz.cg.entity.SysClazz;
/**
 * 年级
 * @author chen gen
 *
 */
public interface SysClazzMapper {
	/**
	 * 主键删除
	 * @param clazzId
	 * @return 删除数量	
	 */
    int deleteByPrimaryKey(String clazzId);

    /**
     * 插入
     * @param record
     * @return 添加数量
     */
    int insertClazz(SysClazz record);
    /**
     * 根据clazzId 查询
     * @param clazzId
     * @return sysclazz
     */
    SysClazz selectByPrimaryKey(String clazzId);
    /**
     * 修改数量
     * @param record
     * @return
     */
    int updateClazz(SysClazz record);
    /**
     * 查询所有clazz
     * @return list
     */
    List<SysClazz> selectAllClazz();
}	