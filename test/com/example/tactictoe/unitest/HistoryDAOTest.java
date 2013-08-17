package com.example.tactictoe.unitest;

import java.util.List;

import android.test.AndroidTestCase;

import com.example.tactictoe.data.dao.HistoryDAO;
import com.example.tactictoe.model.History;

public class HistoryDAOTest extends AndroidTestCase {
	private HistoryDAO historyDAO;

	protected void setUp() throws Exception {
		super.setUp();
		historyDAO = new HistoryDAO(getContext(), null);
	}

	public void testInsertNewHistory() {
		History history = new History();
		history.setFirstSign("x");
		history.setWinSign("");
		history.setSequenceStep("0");
		long historyId = historyDAO.insert(history);
		assertEquals(1, historyId);

	}

	public void testGetAllHistoryFromDB() {
		History history = new History();
		history.setFirstSign("x");
		history.setWinSign("");
		history.setSequenceStep("0");
		historyDAO.insert(history);
		List<History> hisList = historyDAO.get();
		assertEquals(1, hisList.size());
	}
}
