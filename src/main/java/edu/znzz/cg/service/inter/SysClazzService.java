package edu.znzz.cg.service.inter;

import java.util.List;

import edu.znzz.cg.entity.SysClazz;

/**
 * sysclazz 
 * @author chen gen
 *
 */
public interface SysClazzService {
	
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