package exam02_select;

import lombok.Data;

@Data
public class Pager {
	private int totalRows;      //전체 행수
	private int totalPageNo;   //전체 페이지 수
	private int totalGroupNo;   //전체 그룹 수
	private int startPageNo;   //그룹의 시작 페이지 번호
	private int endPageNo;      //그룹의 끝 페이지 번호
	private int pageNo;         //현재 페이지 번호
	private int pagesPerGroup;   //그룹당 페이지 수
	private int groupNo;      //현재 그룹 번호
	private int rowsPerPage;   //페이지당 행 수 
	private int startRowNo;      //페이지의 시작 행 번호
	private int endRowNo;      //페이지의 마지막 행 번호
	
	//Constructor
	public Pager(int rowsperPage, int pagesPerGroup, int totalRows, int pageNo) {
		this.rowsPerPage = rowsperPage;
		this.pagesPerGroup = pagesPerGroup;
		this.totalRows = totalRows;
		this.pageNo = pageNo;
		
		this.totalPageNo = (int)(Math.ceil((double)totalRows /rowsPerPage));
		this.totalGroupNo = (int)(Math.ceil((double)totalPageNo /rowsPerPage));
		
		this.groupNo = (pageNo - 1) / pagesPerGroup + 1;
		
		this.startPageNo = (groupNo-1)*pagesPerGroup + 1;
		
		this.endPageNo = startPageNo + pagesPerGroup -1;
		if(groupNo == totalGroupNo) endPageNo = totalPageNo;
		
		this.startRowNo = (pageNo - 1)*rowsPerPage + 1;
		this.endRowNo = pageNo*rowsPerPage;
	}
}
