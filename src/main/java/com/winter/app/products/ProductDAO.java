package com.winter.app.products;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.members.MemberDTO;
import com.winter.app.util.Pager;
import com.winter.app.util.ProductCommentPager;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.winter.app.products.ProductDAO.";

	public Long commentTotalCount(ProductCommentPager commentPager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "commentTotalCount", commentPager);
	}

	public List<ProductCommentDTO> commentList(ProductCommentPager commentPager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "commentList", commentPager);
	}

	public int commentAdd(ProductCommentDTO productCommentDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "commentAdd", productCommentDTO);
	}

	public int deleteWishList(Map<String, Object> map) throws Exception {
		return sqlSession.delete(NAMESPACE + "deleteWishList", map);
	}

	public List<ProductDTO> wishList(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "wishList", memberDTO);
	}

	public int addWish(Map<String, Object> map) throws Exception {
		return sqlSession.insert(NAMESPACE + "addWish", map);
	}

	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	public List<ProductDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}

	public Long getNum() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getNum");
	}

	public int add(ProductDTO productDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "add", productDTO);
	}

	public int addFile(ProductFileDTO productFileDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "addFile", productFileDTO);
	}

	public int delete(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", productDTO);
	}

	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "update", productDTO);
	}

}
