package com.honglu.crm.common.baseEntityBo;

/**
 * 公用
 * @author xiajiyun
 *
 */
public class BaseBo {

	/**
	 * 这2个参数由layui页面初始化list表单时，传过来
	 */
	/**
	 *  当前页码
	 */
	private Integer	pageIndex = 0;
	/**
	 * 当前页条数
	 */
	private Integer pageSize = 10;
	
	
	public BaseBo() {
	}
	
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		// 当前页
		if(pageIndex != null && pageIndex >=1){
			this.pageIndex = (pageIndex - 1 )*10;
		}else{
			this.pageIndex = pageIndex;
		}
		
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
