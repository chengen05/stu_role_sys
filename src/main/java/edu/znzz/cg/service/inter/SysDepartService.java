package edu.znzz.cg.service.inter;

import java.util.List;

import edu.znzz.cg.entity.SysDepart;
/**
 * depart service
 * 
 * @author chen gen
 *
 */
public interface SysDepartService {
	
	 int deleteByPrimaryKey(String departId);
	    /**
	     * ����
	     * @param record
	     * @return
	     */
	    int insertDepart(SysDepart record);
	    /**
	     * departId��ѯ
	     * @param departId
	     * @return
	     */
	    SysDepart selectByPrimaryKey(String departId);
	    /**
	     * �޸�Ժϵ
	     * @param record
	     * @return
	     */
	    int updateDepart(SysDepart record);
	    /**
	     * У��Ժϵ�����Ƿ���ȷ
	     * @param departName
	     * @return
	     */
	    int checkDepartNameUnique(String departName);
	    /**
	     * ��ѯ����depart
	     * @return
	     */
	    List<SysDepart> selectAllDepart();
}