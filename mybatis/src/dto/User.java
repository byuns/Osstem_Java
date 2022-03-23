package dto;

import java.util.List;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String userName;
	private String userPassword;
	private int userAge;
	private String userEmail;
	
	private List<Board> boards;
}
