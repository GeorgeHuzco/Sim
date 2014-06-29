package com.huzco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	static private Connection conn = null;
	static private String symbol = "XOM";

	public static void main(String[] args) {

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yahoo_finance?" + "user=root&password=");
			StockHistory history = Importer.loadStockHistory(conn, symbol);
			for (HistoryItem item : history.getItems()) {
				System.out.println(item.getSymbol() + ", " + item.getDate().toString() + ", " + item.getClose());
			}
			System.out.println(history.getItems().size() + " items.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
