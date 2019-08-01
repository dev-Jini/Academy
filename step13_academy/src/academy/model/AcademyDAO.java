package academy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import academy.model.dto.AcademyDTO;
import academy.model.util.DBUtil;

public class AcademyDAO {
	
	// 네이버 API 데이터 전체 저장
	public static boolean addAllAcademy(ArrayList<AcademyDTO> academies) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		AcademyDTO academy = null;
		try{
			academy = new AcademyDTO();
		    for (int i = 0; i < academies.size(); i++) { 	
		    	con = DBUtil.getConnection();
		    	
		    	academy = academies.get(i);
		    	
				pstmt = con.prepareStatement("insert into academy values(academy_id.nextval, ?, ?, ?, ?, ?)");
				pstmt.setString(1, academy.getTitle());
				pstmt.setString(2, academy.getSitelink());
				pstmt.setString(3, academy.getContact());
				pstmt.setString(4, academy.getAddress());
				pstmt.setString(5, academy.getSb_name());
				try {						
					Thread.sleep(50);							// 오류 방지
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int result = pstmt.executeUpdate();
				
				if(result == 1){
					System.out.println(i + "  ");
					DBUtil.close(con, pstmt);					// 이렇게 해도 되나요?
//					return true;
				}
		    }
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 저장
	public static boolean addAcademy(AcademyDTO academy) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into academy values(academy_id.nextval, ?, ?, ?, ?, ?)");
			pstmt.setString(1, academy.getTitle());
			pstmt.setString(2, academy.getSitelink());
			pstmt.setString(3, academy.getContact());
			pstmt.setString(4, academy.getAddress());
			pstmt.setString(5, academy.getSb_name());
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				return true;
			}
		} 
		finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 수정
	// contact, sitelink, address 추가 구현
	public static boolean updateAcademy(String academy_id, String title) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update academy set title=? where academy_id=?");
			pstmt.setString(1, title);
			pstmt.setString(2, academy_id);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// sql - delete from activist where activist_id=?
	public static boolean deleteAcademy(double academy_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from academy where academy_id=?");
			pstmt.setDouble(1, academy_id);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// id로 해당 기부자의 모든 정보 반환
	public static AcademyDTO getAcademy(String academy_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AcademyDTO academy = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from academy where academy_id=?");
			pstmt.setString(1, academy_id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				academy = new AcademyDTO(rset.getDouble(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6));	
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return academy;
	}

	// ???모든 기부자 검색해서 반환
	// sql - select * from activist
	public static ArrayList<AcademyDTO> getAllAcademies() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<AcademyDTO> list = null;
		try{
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select * from academy");
			
			list = new ArrayList<AcademyDTO>();
			while(rset.next()) {
				list.add(new AcademyDTO(rset.getDouble(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6)));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return list;
	}
}
	

