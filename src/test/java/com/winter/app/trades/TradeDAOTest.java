package com.winter.app.trades;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.DefaultTest;

public class TradeDAOTest extends DefaultTest {

	@Autowired
	private TradeDAO tradeDAO;

	private TradeDTO tradeDTO;

	@BeforeClass
	public static void beforeClass() {

	}

	@Before
	public void before() {
		this.tradeDTO = new TradeDTO();
		tradeDTO.setAccountNumber(1720399116921L);
		tradeDTO.setTradeAmount(5000L * -1);
		tradeDTO.setTradeIO(1);
	}

	@Test
	public void addTest() throws Exception {
		int result = tradeDAO.add(tradeDTO);
		assertEquals(1, result);
	}

	@After
	public void after() {
		tradeDTO = null;
	}

}
