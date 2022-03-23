package dao;

import org.apache.ibatis.annotations.Mapper;

import dto.User;

@Mapper
public interface UserDao {
	public User selectUser(String userid);
	public User selectUserWithBoards(String userid);
}
