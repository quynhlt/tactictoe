/**
 * 
 */
package com.example.tactictoe.business;

import java.util.List;

import android.content.Context;

import com.example.tactictoe.data.dao.HistoryDAO;
import com.example.tactictoe.model.History;

/**
 * @author quynhlt
 * 
 */
public class HistoryBusiness {

	private HistoryDAO historyDAO;

	public HistoryBusiness(Context context, String dbName) {
		historyDAO = new HistoryDAO(context, dbName);
	}

	public List<History> getListHistories() {
		return historyDAO.get();
	}

	public void setHistoryDAO(HistoryDAO mockHistoryDAO) {
		this.historyDAO = mockHistoryDAO;
	}

	public long insert(History history) {
		return historyDAO.insert(history);
	}

}
