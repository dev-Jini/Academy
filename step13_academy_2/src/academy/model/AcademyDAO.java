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
	public static boolean addAllAcademies(ArrayList<AcademyDTO> academies) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		AcademyDTO academy = null;
		try{
			academy = new AcademyDTO();
		    for (int i = 0; i < academies.size(); i++) { 	
		    	con = DBUtil.getConnection();
		    	
		    	academy = academies.get(i);
		    	
				pstmt = con.prepareStatement("insert into academy (academy_id, title, sitelink, contact, address, sb_name)"
						 + "values(academy_id.nextval, ?, ?, ?, ?, ?)");
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
					System.out.print( (i+1) + "  ");
					DBUtil.close(con, pstmt);					// 이렇게 해도 되나요?
//					return true;
				}
		    }
		    System.out.println();
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
	public static boolean updateAcademy(double academy_id, String title) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update academy set title=? where academy_id=?");
			pstmt.setString(1, title);
			pstmt.setDouble(2, academy_id);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 
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

	// 
	public static AcademyDTO getAcademy(double academy_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AcademyDTO academy = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from academy where academy_id=?");
			pstmt.setDouble(1, academy_id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				academy = new AcademyDTO(rset.getDouble(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6));	
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return academy;
	}

	public static ArrayList<AcademyDTO> getAllAcademies() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<AcademyDTO> academies = null;
		try{
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select * from academy");
			
			academies = new ArrayList<AcademyDTO>();
			while(rset.next()) {
				academies.add(new AcademyDTO(rset.getDouble(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6)));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return academies;
	}
	
	// 특정 과목
	public static ArrayList<AcademyDTO> getSpecificAcademies(String sb_name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AcademyDTO> academies = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from academy a where a.sb_no =  (select sb_no from subject where sb_name = ?)");
			pstmt.setString(1, sb_name);
			
			rset = pstmt.executeQuery();
			academies = new ArrayList<AcademyDTO>();
			while(rset.next()) {
				academies.add(new AcademyDTO(rset.getDouble(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return academies;
	}
	
	// 특정 과목 & 지역
	public static ArrayList<AcademyDTO> getSpecificAcademies2(String sb_name, String loc) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AcademyDTO> academies = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from academy a where a.sb_no =  (select sb_no from subject where sb_name = ?) and address like ?");
			pstmt.setString(1, sb_name);
			pstmt.setString(2, "%"+loc+"%");

			rset = pstmt.executeQuery();
			academies = new ArrayList<AcademyDTO>();
			while(rset.next()) {
				academies.add(new AcademyDTO(rset.getDouble(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getDouble(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return academies;
	}

}
	

