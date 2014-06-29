package com.huzco;

import java.util.ArrayList;
import java.util.List;

public class StockHistory {
	
	private List<HistoryItem> items = new ArrayList<HistoryItem>();

	public List<HistoryItem> getItems() {
		return items;
	}

	public void setItems(List<HistoryItem> items) {
		this.items = items;
	}

}
