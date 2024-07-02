package com.winter.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.DBConnection;

@Repository
public class ProductDAO {

	@Autowired
	private DBConnection dbConnection;

	public List<ProductDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();

		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUMBER DESC";

		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();
		List<ProductDTO> ar = new ArrayList<ProductDTO>();
		while (rs.next()) {
			ProductDTO productDTO = new ProductDTO();

			productDTO.setBookName(rs.getString("BOOKNAME"));
			productDTO.setBookNumber(rs.getLong("BOOKNUMBER"));
			productDTO.setBookRate(rs.getDouble("BOOKRATE"));
			ar.add(productDTO);
		}

		rs.close();
		st.close();
		con.close();

		return ar;
	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {

		Connection con = dbConnection.getConnection();

		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUMBER =?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, productDTO.getBookNumber());

		ResultSet rs = st.executeQuery();

		if (rs.next()) {

			productDTO.setBookName(rs.getString("BOOKNAME"));
			productDTO.setBookNumber(rs.getLong("BOOKNUMBER"));
			productDTO.setBookRate(rs.getDouble("BOOKRATE"));
			productDTO.setBookDetail(rs.getString("BOOKDETAIL"));
		} else {
			productDTO = null;
		}

		rs.close();
		st.close();
		con.close();

		return productDTO;
	}

}
