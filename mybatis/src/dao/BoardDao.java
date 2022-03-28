package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dto.Board;
import dto.Pager;

@Mapper
public interface BoardDao {
	public Board selectBoard(int bno);
	public List<Board> selectAll();
	
	public int selectTotalRowCount();
	public List<Board> selectPage(Pager pager);
	public Board selectBoardWithUser1(int bno);
	public Board selectBoardWithUser2(int bno);
	
	public int insertBoard(Board board);
	
	public int updateBoard(Board board);
	public int deleteBoard(int bno);
}
