package com.huzco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Importer {

	static StockHistory loadStockHistory(Connection conn, String symbol) throws SQLException {
		StockHistory history = new StockHistory();
		PreparedStatement statement = conn.prepareStatement("select * from history where symbol = ?");
		statement.setString(1, symbol);
		ResultSet results = statement.executeQuery();
		while (results.next()) {
			Date date = results.getDate("date");
			Double open = results.getDouble("open");
			Double close = results.getDouble("close");
			Double adjClose = results.getDouble("adj_close");
			Double high = results.getDouble("high");
			Double low = results.getDouble("low");
			Integer volume = results.getInt("volume");
			String company = results.getString("company");
			HistoryItem item = new HistoryItem();
			item.setAdjClose(adjClose);
			item.setClose(close);
			item.setCompany(company);
			item.setDate(date);
			item.setHigh(high);
			item.setLow(low);
			item.setOpen(open);
			item.setSymbol(symbol);
			item.setVolume(volume);
			history.getItems().add(item);
		}
		return history;
	}
}
