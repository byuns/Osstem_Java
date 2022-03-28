package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import dto.Comment;
import dto.Pager;

@Mapper
public interface CommentDao {

	public int count(int bno);

	public List<Comment> selectByBno(@Param(value = "bno") int bno, @Param(value = "endRowNo") int endRowNo,@Param(value = "startRowNo")int startRowNo);

	public List<Comment> selectAll(Pager pager);

	public int insert(Comment comment);

	public int delete(Comment deleteComment);

}
