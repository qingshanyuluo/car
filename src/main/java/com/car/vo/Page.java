package com.car.vo;

public class Page {
	private int curPage;//当前页
	private int showNumber;//显示的页数
	private int count;//总条目数
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getShowNumber() {
		return showNumber;
	}
	public void setShowNumber(int showNumber) {
		this.showNumber = showNumber;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Page(int curPage, int showNumber, int count) {
		super();
		this.curPage = curPage;
		this.showNumber = showNumber;
		this.count = count;
	}
	//计算总的页数
	public int getTotalNumber() {
		return (this.count-1)/this.showNumber+1;
	}
	//计算起始页
	public int getSelectIndex() {
		return (this.curPage-1)*this.showNumber;
	}
	//上一页数
	public int getPrePage() {
		int temp=this.curPage-1;
		if(temp<1){
			temp=1;
		}
		return temp;
	}
	//下一页数
	public int getNextPage() {
		int temp=this.curPage+1;
		if(temp>this.getTotalNumber()){
			temp=this.getTotalNumber();
		}
		return temp;
	}
}
