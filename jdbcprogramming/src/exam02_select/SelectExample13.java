package exam02_select;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import common.dto.Board;
import exam01_connect.ConnectionManager;


public class SelectExample13 {

	public static void main(String[] args) {
		Connection conn = null;
		ConnectionManager.init();
		Scanner sc = new Scanner(System.in);
		System.out.print("게시물 번호 : ");
		int bno = Integer.parseInt(sc.nextLine());
		try {
			//연결하기
			conn = ConnectionManager.getConnection02();
			//실행해야할 SQL 작성
			String sql = "Select bno,btitle,bcontent,bwriter,bdate,bfilename,bfiledata from boards where bno = ?";
			// SQL를 실행할 PrepareStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			// SQL을 실행해서 결과 얻기
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				Board board = new Board(); 
				
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));
				
				System.out.println(board);
				
				if(board.getBfilename() != null) {
					try {
						InputStream is = board.getBfiledata().getBinaryStream();
						OutputStream os = new FileOutputStream("C:/Temp/"+ board.getBfilename());
					
						byte[] data = new byte[1000];
						while(true) {
							int num = is.read(data);
							if(num == -1) break;
							os.write(data,0,num);  // 실제 읽은 수만큼 
						}
						os.flush();
						is.close();
						os.close();
						System.out.println("첨부 파일을 저장했습니다.");
					}catch(IOException e) {
						
						e.printStackTrace();
					}
				}
			}
			//위에서 사용한 메모리 해제
			rs.close();
			pstmt.close();
			
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//연결 끊기
				try {
					conn.close();
					System.out.println("연결 끊김");
				} catch (SQLException e) {
				}
			}
		
	}

}
