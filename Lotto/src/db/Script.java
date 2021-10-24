package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Script {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	Count count = new Count();
	
	public Script() {
		conn = DBConnection.getConnection();
	}
	
	public boolean put(int count,int[] number) {
		String sql = "INSERT INTO LOTTO(LOTTOCOUNT, FIRSTNUM, SECONDNUM, THIRDNUM, FOURTHNUM,FIFTHNUM, SIXTHNUM, BONUSNUM)\r\n" + 
				"VALUES(?,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, count);
			for (int i = 1; i < number.length; i++) {
				pstm.setInt(i+1, number[i]);
			}
			result = pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result == 1;
		
	}
	
	
	// 각 숫자마다 언제 나왓는지 도출해주는 sql문
	public ArrayList<Integer> get(int firstnum) {
		ArrayList<Integer> result = new ArrayList<>();
		result.add(0, 0);
		// 가능한 연산을 위해 처음에 0을 대입
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE FIRSTNUM = ? ORDER BY LOTTOCOUNT ASC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, firstnum);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				result.add(rs.getInt("LOTTOCOUNT"));
			}
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		result.add(count.count());
		return result;
		
	}
	
	
} 
