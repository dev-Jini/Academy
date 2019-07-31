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

	public static boolean addAcademy(JSONArray jsonitems_array) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
		    for (int i = 0; i < jsonitems_array.size(); i++) { 	
				JSONObject jsonobjectitems = ((JSONObject)jsonitems_array.get(i));
				pstmt = con.prepareStatement("insert into academy values(academy_id.nextval, ?, ?, ?, ?)");
				pstmt.setString(1, jsonobjectitems.get("title").toString());
				pstmt.setString(2, jsonobjectitems.get("link").toString());
				pstmt.setString(3, jsonobjectitems.get("telephone").toString());
				pstmt.setString(4, jsonobjectitems.get("address").toString());
				try {						
					Thread.sleep(50);							// 오류 방지
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int result = pstmt.executeUpdate();
				
				if(result == 1){
//					return true;
				}
		    }
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
//	// 수정
//	// contact, sitelink, address 추가 구현
//	public static boolean updateAcademy(String academy_id, String major) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//
//			pstmt = con.prepareStatement("update academy set title=? where academy_id=?");
//			pstmt.setString(1, major);
//			pstmt.setString(2, academy_id);
//
//			int result = pstmt.executeUpdate();
//			if (result == 1) {
//				return true;
//			}
//		} finally {
//			DBUtil.close(con, pstmt);
//		}
//		return false;
//	}
//
//	// sql - delete from activist where activist_id=?
//	public static boolean deleteAcademy(String academy_id) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("delete from academy where academy_id=?");
//			pstmt.setString(1, academy_id);
//			int result = pstmt.executeUpdate();
//			if (result == 1) {
//				return true;
//			}
//		} finally {
//			DBUtil.close(con, pstmt);
//		}
//		return false;
//	}
//
//	// id로 해당 기부자의 모든 정보 반환
//	public static AcademyDTO getAcademy(String academy_id) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		AcademyDTO activist = null;
//
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("select * from academy where academy_id=?");
//			pstmt.setString(1, academy_id);
//			rset = pstmt.executeQuery();
//			if (rset.next()) {
//				activist = new AcademyDTO(rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));	// 1?
//			}
//		} finally {
//			DBUtil.close(con, pstmt, rset);
//		}
//		return activist;
//	}
//
//	// ???모든 기부자 검색해서 반환
//	// sql - select * from activist
//	public static ArrayList<AcademyDTO> getAllActivists() throws SQLException {
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rset = null;
//		ArrayList<AcademyDTO> list = null;
//		try{
//			con = DBUtil.getConnection();
//			stmt = con.createStatement();
//			rset = stmt.executeQuery("select * from activist");
//			
//			list = new ArrayList<AcademyDTO>();
//			while(rset.next()) {
//				list.add(new AcademyDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
//			}
//		} finally {
//			DBUtil.close(con, stmt, rset);
//		}
//		return list;
//	}
}
	

