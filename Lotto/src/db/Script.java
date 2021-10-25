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

	public boolean put(int count, int[] number) {
		String sql = "INSERT INTO LOTTO(LOTTOCOUNT, FIRSTNUM, SECONDNUM, THIRDNUM, FOURTHNUM,FIFTHNUM, SIXTHNUM, BONUSNUM)\r\n"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, count);
			for (int i = 1; i < number.length; i++) {
				pstm.setInt(i + 1, number[i]);
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
		// 가능한 연산을 위해 처음에 0을 대입
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE FIRSTNUM = ? ORDER BY LOTTOCOUNT ASC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, firstnum);

			rs = pstm.executeQuery();
			while (rs.next()) {
				result.add(rs.getInt("LOTTOCOUNT"));
			}
			pstm.close();
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;

	}

	public int getlast(int firstnum) {
		int result = 0;
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE FIRSTNUM = ? ORDER BY LOTTOCOUNT DESC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, firstnum);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				result = rs.getInt("LOTTOCOUNT");
			}		
			pstm.close();
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;
	}
	
	public ArrayList<Integer> get2(int secondnum) {
		ArrayList<Integer> result = new ArrayList<>();
		// 가능한 연산을 위해 처음에 0을 대입
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE SECONDNUM = ? ORDER BY LOTTOCOUNT ASC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, secondnum);

			rs = pstm.executeQuery();
			while (rs.next()) {
				result.add(rs.getInt("LOTTOCOUNT"));
			}
			pstm.close();
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;

	}

	public int getlast2(int secondnum) {
		int result = 0;
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE SECONDNUM = ? ORDER BY LOTTOCOUNT DESC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, secondnum);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				result = rs.getInt("LOTTOCOUNT");
			}
			pstm.close();
			
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;
	}
	
	public ArrayList<Integer> get3(int thirdnum) {
		ArrayList<Integer> result = new ArrayList<>();
		// 가능한 연산을 위해 처음에 0을 대입
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE THIRDNUM = ? ORDER BY LOTTOCOUNT ASC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, thirdnum);

			rs = pstm.executeQuery();
			while (rs.next()) {
				result.add(rs.getInt("LOTTOCOUNT"));
			}
			pstm.close();
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;

	}

	public int getlast3(int thirdnum) {
		int result = 0;
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE THIRDNUM = ? ORDER BY LOTTOCOUNT DESC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, thirdnum);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				result = rs.getInt("LOTTOCOUNT");
			}
			pstm.close();
			
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;
	}
	
	
	public ArrayList<Integer> get4(int fourthnum) {
		ArrayList<Integer> result = new ArrayList<>();
		// 가능한 연산을 위해 처음에 0을 대입
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE FOURTHNUM = ? ORDER BY LOTTOCOUNT ASC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, fourthnum);

			rs = pstm.executeQuery();
			while (rs.next()) {
				result.add(rs.getInt("LOTTOCOUNT"));
			}
			pstm.close();
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;

	}

	public int getlast4(int fourthnum) {
		int result = 0;
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE FOURTHNUM = ? ORDER BY LOTTOCOUNT DESC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, fourthnum);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				result = rs.getInt("LOTTOCOUNT");
			}
			pstm.close();
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;
	}
	
	public ArrayList<Integer> get5(int fifthnum) {
		ArrayList<Integer> result = new ArrayList<>();
		// 가능한 연산을 위해 처음에 0을 대입
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE FIFTHNUM = ? ORDER BY LOTTOCOUNT ASC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, fifthnum);

			rs = pstm.executeQuery();
			while (rs.next()) {
				result.add(rs.getInt("LOTTOCOUNT"));
			}
			pstm.close();
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;

	}

	public int getlast5(int fifthnum) {
		int result = 0;
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE FIFTHNUM = ? ORDER BY LOTTOCOUNT DESC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, fifthnum);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				result = rs.getInt("LOTTOCOUNT");
			}
			pstm.close();
			
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;
	}
	
	public ArrayList<Integer> get6(int sixthnum) {
		ArrayList<Integer> result = new ArrayList<>();
		// 가능한 연산을 위해 처음에 0을 대입
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE SIXTHNUM = ? ORDER BY LOTTOCOUNT ASC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, sixthnum);

			rs = pstm.executeQuery();
			while (rs.next()) {
				result.add(rs.getInt("LOTTOCOUNT"));
			}
			pstm.close();
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;

	}

	public int getlast6(int sixthnum) {
		int result = 0;
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE SIXTHNUM = ? ORDER BY LOTTOCOUNT DESC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, sixthnum);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				result = rs.getInt("LOTTOCOUNT");
			}
			pstm.close();
			
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;
	}

	public ArrayList<Integer> getB(int bonusnum) {
		ArrayList<Integer> result = new ArrayList<>();
		// 가능한 연산을 위해 처음에 0을 대입
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE BONUSNUM = ? ORDER BY LOTTOCOUNT ASC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, bonusnum);

			rs = pstm.executeQuery();
			while (rs.next()) {
				result.add(rs.getInt("LOTTOCOUNT"));
			}
			pstm.close();
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;

	}

	public int getlastB(int bonusnum) {
		int result = 0;
		String sql = "SELECT LOTTOCOUNT FROM LOTTO WHERE BONUSNUM = ? ORDER BY LOTTOCOUNT DESC";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, bonusnum);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				result = rs.getInt("LOTTOCOUNT");
			}
			pstm.close();
			
		} catch (SQLException e) {
			System.out.println("오류 : " + e);
		}
		return result;
	}
	
	
	
	
	

}
