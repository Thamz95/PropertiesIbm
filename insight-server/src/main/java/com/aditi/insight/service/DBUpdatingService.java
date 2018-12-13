package com.aditi.insight.service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.aditi.insight.domain.CountsByDivision;
import com.aditi.insight.domain.CountsByPrimarySales;
import com.aditi.insight.domain.Division;
import com.aditi.insight.domain.PrimarySales;
import com.aditi.insight.enums.BIMetrices;
import com.jobdiva.bi.GetBIDataResponse;

@Service
public class DBUpdatingService {

	@Autowired
	BIDataService biDataService;

	@Autowired
	DivisionService divisionService;

	@Autowired
	BIDataResponseService biDataResService;

	@Autowired
	CountsByDivisionService countsByDivService;

	@Autowired
	PrimarySalesService primarySalesService;

	@Autowired
	CountsByPSService countsByPService;

	@Scheduled(cron = "0 0 0 * * ?")
	public void updateDbWithWebserviceData() throws Exception {
		Date from = Date.from(Instant.now().minus(Duration.ofDays(1)));
		Date to = Date.from(Instant.now());
		updateCountsByDivision(from, to);
		updateCountsByPrimarySales(from, to);
	}

	private void updateCountsByDivision(Date from, Date to) throws Exception {
		Map<Division, Map<String, Integer>> divisionCountsMap = new LinkedHashMap<Division, Map<String, Integer>>();
		List<CountsByDivision> countsByDivList = new ArrayList<CountsByDivision>();
		updateOpenPosCountByDiv(divisionCountsMap, from, to);
		updateHiresCountByDiv(divisionCountsMap, from, to);
		updateNewPosCountByDiv(divisionCountsMap, from, to);
		for (Division division : divisionCountsMap.keySet()) {
			Map<String, Integer> countsMap = divisionCountsMap.get(division);
			CountsByDivision countsByDiv = new CountsByDivision(division,
					countsMap.get(BIMetrices.NEW_POS_COUNT_BY_DIV), countsMap.get(BIMetrices.HIRES_COUNT_BY_DIV),
					countsMap.get(BIMetrices.OPEN_POS_COUNT_BY_DIV), 0, 0, 0, 0);
			countsByDivList.add(countsByDiv);

		}
		countsByDivService.save(countsByDivList);
	}

	private void updateCountsByPrimarySales(Date from, Date to) throws Exception {
		Map<PrimarySales, Map<String, Integer>> primarySalesCountsMap = new LinkedHashMap<PrimarySales, Map<String, Integer>>();
		List<CountsByPrimarySales> countsByPSList = new ArrayList<CountsByPrimarySales>();
		updateOpenPosCountByPS(primarySalesCountsMap, from, to);
		updateHiresCountByPS(primarySalesCountsMap, from, to);
		updateNewPosCountByPS(primarySalesCountsMap, from, to);
		for (PrimarySales division : primarySalesCountsMap.keySet()) {
			Map<String, Integer> countsMap = primarySalesCountsMap.get(division);
			CountsByPrimarySales countsByDiv = new CountsByPrimarySales(division,
					countsMap.get(BIMetrices.NEW_POS_COUNT_BY_DIV), countsMap.get(BIMetrices.HIRES_COUNT_BY_DIV),
					countsMap.get(BIMetrices.OPEN_POS_COUNT_BY_DIV), 0, 0, 0, 0);
			countsByPSList.add(countsByDiv);

		}
		countsByPService.save(countsByPSList);
	}

	private void updateNewPosCountByPS(Map<PrimarySales, Map<String, Integer>> primarySalesCountsMap, Date from,
			Date to) throws Exception {
		GetBIDataResponse openPosCountDataResponse = biDataService.newPositionsCountByPrimarySales(from, to);
		String psId = getColumnValue(openPosCountDataResponse, "USERID");
		String count = getColumnValue(openPosCountDataResponse, "VALUE");
		if (psId != null) {
			PrimarySales primarySales = getPrimarySales(Long.valueOf(psId), openPosCountDataResponse);
			addCountToPrimarySalesMap(primarySalesCountsMap, primarySales, count, BIMetrices.NEW_POS_COUNT_BY_PS);
		}
	}

	private void updateHiresCountByPS(Map<PrimarySales, Map<String, Integer>> primarySalesCountsMap, Date from, Date to)
			throws Exception {
		GetBIDataResponse hiresCountDataResponse = biDataService.hiresCountByPrimarySales(from, to);
		String psId = getColumnValue(hiresCountDataResponse, "ID");
		String count = getColumnValue(hiresCountDataResponse, "VALUE");
		if (psId != null) {
			PrimarySales primarySales = getPrimarySales(Long.valueOf(psId), hiresCountDataResponse);
			addCountToPrimarySalesMap(primarySalesCountsMap, primarySales, count, BIMetrices.HIRES_COUNT_BY_PS);
		}
	}

	private void updateOpenPosCountByPS(Map<PrimarySales, Map<String, Integer>> primarySalesCountsMap, Date from,
			Date to) throws Exception {
		GetBIDataResponse openPosCountDataResponse = biDataService.openPositionsCountByPrimarySales(from, to);
		String psId = getColumnValue(openPosCountDataResponse, "USERID");
		String count = getColumnValue(openPosCountDataResponse, "VALUE");
		if (psId != null) {
			PrimarySales primarySales = getPrimarySales(Long.valueOf(psId), openPosCountDataResponse);
			addCountToPrimarySalesMap(primarySalesCountsMap, primarySales, count, BIMetrices.OPEN_POS_COUNT_BY_PS);
		}
	}

	private PrimarySales getPrimarySales(Long psId, GetBIDataResponse openPosCountDataResponse) {
		PrimarySales ps = primarySalesService.findByPrimarySalesId(psId);
		String psName = null;
		if (ps == null) {
			String psNameColumnValue = getColumnValue(openPosCountDataResponse, "PRIMARYSALESNAME");
			psName = psNameColumnValue != null && !psNameColumnValue.isEmpty() ? psNameColumnValue : "No PS";
			ps = new PrimarySales(Long.valueOf(psId), psName);
			ps = primarySalesService.save(ps);
		}
		return ps;

	}

	private void updateOpenPosCountByDiv(Map<Division, Map<String, Integer>> divisionCountsMap, Date from, Date to)
			throws Exception {
		GetBIDataResponse openPosCountDataResponse = biDataService.openPositionCountByDivision(from, to);
		String divId = getColumnValue(openPosCountDataResponse, "DIVISIONID");
		String count = getColumnValue(openPosCountDataResponse, "VALUE");
		Division division = getDivision(divId, openPosCountDataResponse);
		addCountToDivMap(divisionCountsMap, division, count, BIMetrices.OPEN_POS_COUNT_BY_DIV);
	}

	private void updateHiresCountByDiv(Map<Division, Map<String, Integer>> divisionCountsMap, Date from, Date to)
			throws Exception {
		GetBIDataResponse hiresCountDataResponse = biDataService.hiresCountByDivision(from, to);
		String divId = getColumnValue(hiresCountDataResponse, "DIVISIONID");
		String count = getColumnValue(hiresCountDataResponse, "VALUE");
		Division division = getDivision(divId, hiresCountDataResponse);
		addCountToDivMap(divisionCountsMap, division, count, BIMetrices.HIRES_COUNT_BY_DIV);
	}

	private void updateNewPosCountByDiv(Map<Division, Map<String, Integer>> divisionCountsMap, Date from, Date to)
			throws Exception {
		GetBIDataResponse hiresCountDataResponse = biDataService.newPositionsCountByDivision(from, to);
		String divId = getColumnValue(hiresCountDataResponse, "DIVISIONID");
		String count = getColumnValue(hiresCountDataResponse, "VALUE");
		Division division = getDivision(divId, hiresCountDataResponse);
		addCountToDivMap(divisionCountsMap, division, count, BIMetrices.NEW_POS_COUNT_BY_DIV);
	}

	private Division getDivision(String divId, GetBIDataResponse hiresCountDataResponse) {
		Division div = divisionService.findByDivId(Long.valueOf(divId));
		String divName = null;
		if (div == null) {
			String divNameColumnValue = getColumnValue(hiresCountDataResponse, "DIVISIONNAME");
			divName = divNameColumnValue != null && !divNameColumnValue.isEmpty() ? divNameColumnValue : "No Division";
			div = new Division(Long.valueOf(divId), divName);
			div = divisionService.save(div);
		}
		return div;
	}

	private void addCountToDivMap(Map<Division, Map<String, Integer>> divisionCountsMap, Division division,
			String count, String metrics) {
		Map<String, Integer> countMap = divisionCountsMap.get(division);
		if (countMap == null)
			countMap = new LinkedHashMap<String, Integer>();
		countMap.put(metrics, Integer.valueOf(count));
		divisionCountsMap.put(division, countMap);
	}

	private void addCountToPrimarySalesMap(Map<PrimarySales, Map<String, Integer>> psCountsMap, PrimarySales ps,
			String count, String metrics) {
		Map<String, Integer> countMap = psCountsMap.get(ps);
		if (countMap == null)
			countMap = new LinkedHashMap<String, Integer>();
		countMap.put(metrics, Integer.valueOf(count));
		psCountsMap.put(ps, countMap);
	}

	private String getColumnValue(GetBIDataResponse hiresCountDataResponse, String colName) {
		List<String> valColumnData = biDataResService.getColumnValue(hiresCountDataResponse, colName);
		String count = null;
		if (valColumnData != null && !valColumnData.isEmpty()) {
			count = valColumnData.get(0);
		}
		return count;
	}
}
