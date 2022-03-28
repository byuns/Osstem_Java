package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import dto.User;

@Mapper
public interface UserDao {

	public User loginVerifying(@Param(value = "uId") String uId,@Param(value = "uPassword") String uPassword);

	public User getUser(String uId);

	public User isIdExist(String userId);

	public User isUserExist(@Param(value = "uId") String uId,@Param(value = "uPassword") String uPassword);

	public User signout(String uId);

	public int signin(User user);

}
