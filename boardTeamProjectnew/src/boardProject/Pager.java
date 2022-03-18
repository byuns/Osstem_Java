package boardProject;

import lombok.Data;

@Data
public class Pager {
	// Field
	private int totalRows;      //전체 행수
	private int totalPageNo;   //전체 페이지 수
	private int totalGroupNo;   //전체 그룹 수
	private int startPageNo;   //그룹의 시작 페이지 번호
	private int endPageNo;      //그룹의 끝 페이지 번호
	private int pageNo;         //현재 페이지 번호
	private int pagesPerGroup;   //그룹당 페이지 수
	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPageNo() {
		return totalPageNo;
	}

	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}

	public int getTotalGroupNo() {
		return totalGroupNo;
	}

	public void setTotalGroupNo(int totalGroupNo) {
		this.totalGroupNo = totalGroupNo;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPagesPerGroup() {
		return pagesPerGroup;
	}

	public void setPagesPerGroup(int pagesPerGroup) {
		this.pagesPerGroup = pagesPerGroup;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getStartRowNo() {
		return startRowNo;
	}

	public void setStartRowNo(int startRowNo) {
		this.startRowNo = startRowNo;
	}

	public int getEndRowNo() {
		return endRowNo;
	}

	public void setEndRowNo(int endRowNo) {
		this.endRowNo = endRowNo;
	}

	private int groupNo;      //현재 그룹 번호
	private int rowsPerPage;   //페이지당 행 수 
	private int startRowNo;      //페이지의 시작 행 번호(1, ..., n)
//	private int startRowIndex;   //페이지의 시작 행 인덱스(0, ..., n-1) for mysql
	private int endRowNo;      //페이지의 마지막 행 번호
//	private int endRowIndex;   //페이지의 마지막 행 인덱스
	
	// Constructor
	// pagesPerGrup -> 한 그룹당 설정할 페이지의 수, pageNo -> 내가 보고 싶은 페이지 번호
	public Pager(int rowsPerPage, int pagesPerGrup, int totalRows, int pageNo) {
		this.rowsPerPage = rowsPerPage;
		this.pagesPerGroup = pagesPerGrup;
		this.totalRows = totalRows;
		this.pageNo = pageNo;
		
		this.totalPageNo = (int) Math.ceil((double) totalRows / rowsPerPage);
		this.totalGroupNo = (int) Math.ceil((double) totalPageNo / pagesPerGroup);
		
		this.groupNo = (pageNo - 1) / pagesPerGroup + 1;
		this.startPageNo = (groupNo - 1) * pagesPerGroup + 1;
		
		this.endPageNo = startPageNo + pagesPerGroup - 1;
		if(groupNo == totalGroupNo) endPageNo = totalPageNo;
		
		this.startRowNo = (pageNo - 1) * rowsPerPage + 1;
		this.endRowNo = pageNo * rowsPerPage;
	}
}
