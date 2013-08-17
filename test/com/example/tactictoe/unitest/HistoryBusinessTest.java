package com.example.tactictoe.unitest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.ArgumentCaptor;

import android.test.AndroidTestCase;

import com.example.tactictoe.business.HistoryBusiness;
import com.example.tactictoe.data.dao.HistoryDAO;
import com.example.tactictoe.model.History;

public class HistoryBusinessTest extends AndroidTestCase {
	private HistoryDAO mockHistoryDAO;
	private HistoryBusiness historyBusiness;

	protected void setUp() throws Exception {
		mockHistoryDAO = mock(HistoryDAO.class);
		reset(mockHistoryDAO);
		historyBusiness = new HistoryBusiness(getContext(), null);
		historyBusiness.setHistoryDAO(mockHistoryDAO);
	}

	public void testCanGetAllHistory() {
		List<History> listHistoriesExpected = new ArrayList<History>();
		History history = new History();
		history.setFirstSign("x");
		history.setWinSign("");
		history.setSequenceStep("0");
		listHistoriesExpected.add(history);

		when(mockHistoryDAO.get()).thenReturn(listHistoriesExpected);
		List<History> listHistoriesActual = historyBusiness.getListHistories();
		verify(mockHistoryDAO, times(1)).get();

		assertEquals(listHistoriesExpected.size(), listHistoriesActual.size());
	}

	public void testCanSaveHistoryAfterGameEnd() {
		History history = new History();
		history.setFirstSign("x");
		history.setWinSign("");
		history.setSequenceStep("0");

		historyBusiness.insert(history);
		ArgumentCaptor<History> saveHistory = ArgumentCaptor
				.forClass(History.class);
		verify(mockHistoryDAO, times(1)).insert(saveHistory.capture());

		assertEquals(history.getFirstSign(), saveHistory.getValue()
				.getFirstSign());
		assertEquals(history.getSequenceStep(), saveHistory.getValue()
				.getSequenceStep());
		assertEquals(history.getWinSign(), saveHistory.getValue().getWinSign());
	}
}
