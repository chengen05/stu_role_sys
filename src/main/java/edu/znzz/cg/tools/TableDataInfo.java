package edu.znzz.cg.tools;
/**
 * 定义表格分页返回数据格式
 * 
 * @author chen gen
 *
 */

import java.util.List;

public class TableDataInfo {
	/** 总记录*/
	private Long total;
	/** 数据 */
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
