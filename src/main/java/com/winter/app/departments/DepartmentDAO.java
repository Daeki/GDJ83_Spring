package com.winter.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.DBConnection;

@Repository
public class DepartmentDAO {

	// DI, IOC
	@Autowired
	private DBConnection dbConnection;

	public List<DepartmentDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();

		// SQL(Query)문 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

		// 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// ? 값 세팅

		// 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();

		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();

		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");

			departmentDTO.setDepartment_id(id);
			departmentDTO.setDepartment_name(name);
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));

			ar.add(departmentDTO);
		}

		// 자원 해제
		rs.close();
		st.close();
		con.close();

		return ar;
	}

	// detail
	public DepartmentDTO getDetail(int num) throws Exception {
		// 1. DB접속
		Connection con = dbConnection.getConnection();

		// 2. Sql문작성
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";

		// 3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setInt(1, num);

		// 5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		DepartmentDTO departmentDTO = null;
		if (rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt(1));
			departmentDTO.setLocation_id(rs.getInt(4));
			departmentDTO.setDepartment_name(rs.getString(2));
			departmentDTO.setManager_id(rs.getLong(3));
		}

		// 6. 자원 해제
		rs.close();
		st.close();
		con.close();

		return departmentDTO;
	}

	// add
	public int add(DepartmentDTO departmentDTO) throws Exception {
		// 1. DB 연결
		Connection con = dbConnection.getConnection();

		// 2. Sql 생성
		String sql = "INSERT INTO DEPARTMENTS " + " (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)"
				+ " values (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";

		// 3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());

		// 5. 최종 전송 및 결과 처리
		int result = st.executeUpdate();

		// 6. 자원 해제
		st.close();
		con.close();

		return result;
	}

	// 삭제
	// delete
	public int delete(DepartmentDTO departmentDTO) throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID=?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, departmentDTO.getDepartment_id());

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	// update
	public int update(DepartmentDTO departmentDTO) throws Exception {
		int result = 0;

		Connection con = dbConnection.getConnection();

		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? "
				+ " WHERE DEPARTMENT_ID=?";

		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

}
