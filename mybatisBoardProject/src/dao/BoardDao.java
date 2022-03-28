package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dto.Board;
import dto.Pager;

@Mapper
public interface BoardDao {
	public List<Board> selectPage(Pager pager);
	public List<Board> selectByBcount(Pager pager);
	public int selectTotalRowCount();
	public void insertBoard(Board board);
	public Board selectBoard(int num);
	public void modifyBoard(Board board);
	public void removeBoard(int num);
	public void count(int num);
	
}
