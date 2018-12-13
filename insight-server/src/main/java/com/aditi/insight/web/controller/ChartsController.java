package com.aditi.insight.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aditi.insight.dto.models.ChartDto;
import com.aditi.insight.dto.models.RestResponse;
import com.aditi.insight.exception.InsightException;
import com.aditi.insight.service.ChartsService;
import com.aditi.insight.utils.SuccessHandler;

/**
 * Charts Controller
 *
 */
@RestController
public class ChartsController {

	@Autowired
	ChartsService chartsService;

	@RequestMapping(value = "/api/v1/charts", method = RequestMethod.GET)
	public RestResponse getCharts() throws InsightException {
		DateTime to = new DateTime();
		DateTime from = to.minusDays(7);
		Map<String, ChartDto> chartsMap = chartsService.getCharts(from.toDate(), to.toDate());
		List<ChartDto> charts = new ArrayList<ChartDto>();
		charts.addAll(chartsMap.values());
		charts.removeAll(Collections.singleton(null));
		return new RestResponse(true, charts, SuccessHandler.GET_SUCCESS);
	}

	@RequestMapping(value = "api/v1/charts/role/{rolename}", method = RequestMethod.GET)
	public RestResponse getChartsForRole(@PathVariable String rolename,
			@RequestParam(value = "globalTImePeriod", required = true) String globalTimePeriod)
			throws InsightException {
		List<ChartDto> charts = chartsService.getChartsForRole(rolename, globalTimePeriod);
		return new RestResponse(true, charts, SuccessHandler.GET_SUCCESS);
	}

	@RequestMapping(value = "api/v1/charts/timeperiod/{selectedTimePeriod}", method = RequestMethod.GET)
	public RestResponse getChartsForSelectedTimeperiod(@PathVariable String selectedTimePeriod,
			@RequestParam(value = "role", required = true) String role,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "startDate", required = false) String startDate) throws InsightException {
		List<ChartDto> charts = null;
		if (selectedTimePeriod.equals("Custom")) {
			if(startDate==null || startDate.isEmpty()||endDate==null || endDate.isEmpty()){
				return new RestResponse(false, "Dates cannot be null", SuccessHandler.GET_SUCCESS);
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date startDateObj = null;
			Date endDateObj = null;
			try {
				startDateObj = dateFormat.parse(startDate);
				endDateObj = dateFormat.parse(endDate);
			} catch (ParseException e) {
			}
			if(startDateObj.after(endDateObj)){
				return new RestResponse(false, "Start date cannot be greater than end date", SuccessHandler.GET_SUCCESS);
			}
			charts = chartsService.getChartsForRoleAndTimeRange(role, startDateObj, endDateObj);
		} else
			charts = chartsService.getChartsForSelectedTimeperiod(selectedTimePeriod, role);
		return new RestResponse(true, charts, SuccessHandler.GET_SUCCESS);
	}

	@RequestMapping(value = "api/v1/charts/timeperiod/{selectedTimePeriod}/{chartCategory}", method = RequestMethod.GET)
	public RestResponse getChartForSelectedTimeperiod(@PathVariable String selectedTimePeriod,
			@PathVariable String chartCategory) throws InsightException {
		ChartDto chart = chartsService.getChartForSelectedTimeperiod(selectedTimePeriod, chartCategory);
		return new RestResponse(true, chart, SuccessHandler.GET_SUCCESS);
	}

}
