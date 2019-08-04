package academy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import academy.model.dto.AcademyStudentDTO;
import academy.model.util.DBUtil;

public class AcademyStudentDAO {

	// 학원에 소속된 학생 리스트 전체 출력 (학원 정보, 학생 정보 모두 출력)
	public static ArrayList<AcademyStudentDTO> getAllAcademyStudents() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AcademyStudentDTO> list = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select st_id, st_name, gender, a.academy_id, title, sitelink, contact, address, sb_no "
					+ "from academy a, student s where a.academy_id = s.academy_id order by st_id asc");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AcademyStudentDTO>();
			while(rset.next()){
				list.add( new AcademyStudentDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getString(5), 
						rset.getString(6), rset.getString(7), rset.getString(8),rset.getDouble(9)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	// 특정 학원에 소속된 학생 리스트 전체 출력
	public static ArrayList<AcademyStudentDTO> getAcademyStudents(double academy_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AcademyStudentDTO> list = null;

		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select st_id, st_name, gender, a.academy_id, title, sitelink, contact, address, sb_no "
					+ "from academy a, student s where a.academy_id = s.academy_id and a.academy_id = ? order by st_id asc");
			pstmt.setDouble(1, academy_id);
			rset = pstmt.executeQuery();
			         
			list = new ArrayList<AcademyStudentDTO>();
			while(rset.next()){
				list.add( new AcademyStudentDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getString(5), 
						rset.getString(6), rset.getString(7), rset.getString(8),rset.getDouble(9)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
		           
		      
	      
}

