package com.athena.pojo;

import java.util.List;

public class PageInfo {
	private int curNum;
	private int pageSize;
	private long totalPage;
	private List<?> list;
	public int getCurNum() {
		return curNum;
	}
	public void setCurNum(int curNum) {
		this.curNum = curNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageInfo [curNum=" + curNum + ", pageSize=" + pageSize + ", totalPage=" + totalPage + ", list=" + list
				+ "]";
	}
	
}
