package com.huzco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImporterTest {
	

	@Test
	public void test() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yahoo_finance?" + "user=root&password=");
		StockHistory xom = Importer.loadStockHistory(conn, "XOM");
		HistoryItem item = xom.getItems().get(0);
		assertEquals("XOM", item.getSymbol());
	}

}
