package edu.znzz.cg.dao;

import java.util.List;

import edu.znzz.cg.entity.SysClazz;
/**
 * �꼶
 * @author chen gen
 *
 */
public interface SysClazzMapper {
	/**
	 * ����ɾ��
	 * @param clazzId
	 * @return ɾ������	
	 */
    int deleteByPrimaryKey(String clazzId);

    /**
     * ����
     * @param record
     * @return �������
     */
    int insertClazz(SysClazz record);
    /**
     * ����clazzId ��ѯ
     * @param clazzId
     * @return sysclazz
     */
    SysClazz selectByPrimaryKey(String clazzId);
    /**
     * �޸�����
     * @param record
     * @return
     */
    int updateClazz(SysClazz record);
    /**
     * ��ѯ����clazz
     * @return list
     */
    List<SysClazz> selectAllClazz();
}	