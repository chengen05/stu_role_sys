package edu.znzz.cg.tools;
/**
 * �������ҳ�������ݸ�ʽ
 * 
 * @author chen gen
 *
 */

import java.util.List;

public class TableDataInfo {
	/** �ܼ�¼*/
	private Long total;
	/** ���� */
	private List<?> rows;

	public TableDataInfo() {
		
	}
	public TableDataInfo(List<?> rows,Long total) {
		this.rows = rows;
		this.total = total;
	}
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
