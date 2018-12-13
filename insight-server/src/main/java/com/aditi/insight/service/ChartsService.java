package com.aditi.insight.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditi.insight.dto.models.ChartDto;
import com.jobdiva.bi.GetBIDataResponse;

@Service
public class ChartsService {

	@Autowired
	BIDataService biDataService;

	@Autowired
	ChartsGeneratorService chartGenSerivce;

	@Autowired
	CountsByDivisionService countsByDivisionService;

	private static final Logger log = LoggerFactory.getLogger(ChartsService.class);

	public Map<String, ChartDto> getCharts(Date from, Date to) {
		Map<String, ChartDto> chartsMap = new LinkedHashMap<String, ChartDto>();
		try {
			ChartDto hiresCountByDivisionChart = getHiresCountByDivisionChart(from, to);
			if (hiresCountByDivisionChart != null) {
				System.out.println("hiresCountByDivisionChart chart is not null");
				chartsMap.put(hiresCountByDivisionChart.getChartCategory(), hiresCountByDivisionChart);
			} else
				System.out.println("hiresCountByDivisionChart chart is null");

			ChartDto hiresCountByPrimarySalesChart = getHiresCountByPrimarySalesChart(from, to);
			if (hiresCountByPrimarySalesChart != null) {
				System.out.println("hiresCountByPrimarySalesChart chart is not null");
				chartsMap.put(hiresCountByPrimarySalesChart.getChartCategory(), hiresCountByPrimarySalesChart);
			} else
				System.out.println("hiresCountByPrimarySalesChart chart is null");

			ChartDto filledPositionsCountByDivisionChart = getFilledPositionsCountByDivisionChart(from, to);
			if (filledPositionsCountByDivisionChart != null) {
				System.out.println("filledPositionsCountByDivisionChart chart is not null");
				chartsMap.put(filledPositionsCountByDivisionChart.getChartCategory(),
						filledPositionsCountByDivisionChart);
			} else
				System.out.println("filledPositionsCountByDivisionChart chart is null");

			ChartDto newPositionsCountByDivisionChart = getNewPositionsCountByDivisionChart(from, to);
			if (newPositionsCountByDivisionChart != null) {
				System.out.println("newPositionsCountByDivisionChart chart is not null");
				chartsMap.put(newPositionsCountByDivisionChart.getChartCategory(), newPositionsCountByDivisionChart);
			} else
				System.out.println("newPositionsCountByDivisionChart chart is null");

			ChartDto newPositionsCountByPrimarySalesChart = getNewPositionsCountByPrimarySalesChart(from, to);
			if (newPositionsCountByPrimarySalesChart != null) {
				System.out.println("newPositionsCountByPrimarySalesChart chart is not null");
				chartsMap.put(newPositionsCountByPrimarySalesChart.getChartCategory(),
						newPositionsCountByPrimarySalesChart);
			} else
				System.out.println("newPositionsCountByPrimarySalesChart chart is null");

			ChartDto openPositionsCountByDivisionChart = getOpenPositionsCountByDivisionChart(from, to);
			if (openPositionsCountByDivisionChart != null) {
				System.out.println("openPositionsCountByDivisionChart chart is not null");
				chartsMap.put(openPositionsCountByDivisionChart.getChartCategory(), openPositionsCountByDivisionChart);
			} else
				System.out.println("openPositionsCountByDivisionChart chart is null");

			ChartDto openPositionsCountbyJobTypeChart = getOpenPositionsCountbyJobTypeChart(from, to);
			if (openPositionsCountbyJobTypeChart != null) {
				System.out.println("openPositionsCountbyJobTypeChart chart is not null");
				chartsMap.put(openPositionsCountbyJobTypeChart.getChartCategory(), openPositionsCountbyJobTypeChart);
			} else
				System.out.println("openPositionsCountbyJobTypeChart chart is null");

			ChartDto openPositionsCountByPrimarySalesChart = getOpenPositionsCountByPrimarySalesChart(from, to);
			if (openPositionsCountByPrimarySalesChart != null) {
				System.out.println("openPositionsCountByPrimarySalesChart chart is not null");
				chartsMap.put(openPositionsCountByPrimarySalesChart.getChartCategory(),
						openPositionsCountByPrimarySalesChart);
			} else
				System.out.println("openPositionsCountByPrimarySalesChart chart is null");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Number of charts :" + chartsMap.size());
		return chartsMap;
	}

	private ChartDto getOpenPositionsCountByPrimarySalesChart(Date from, Date to) throws Exception {
		GetBIDataResponse biDataResponse = biDataService.openPositionsCountByPrimarySales(from, to);
		ChartDto chart = null;
		if (biDataResponse != null) {
			if (biDataResponse.getData() == null) {
				System.out.println(biDataResponse.getMessage());
			}
			String xAxisColumn = "NAME";
			String yAxiscolumn = "VALUE";
			chart = chartGenSerivce.getChartForAxes(biDataResponse, xAxisColumn, yAxiscolumn);
			if (chart != null) {
				chart.setChartCategory("openPositionsCountByPrimarySales");
				chart.setChartTitle("Open Positions Count By PrimarySales");
				chart.setColors(new String[]{"#666699","#ff6384","#ff8e72"});
			}
		} else {
			System.out.println("Response null for Open Positions Count By PrimarySales");
		}
		return chart;
	}

	private ChartDto getOpenPositionsCountByDivisionChart(Date from, Date to) throws Exception {
		GetBIDataResponse biDataResponse = biDataService.openPositionCountByDivision(from, to);
		ChartDto chart = null;
		if (biDataResponse != null) {
			if (biDataResponse.getData() == null) {
				System.out.println(biDataResponse.getMessage());
			}
			String xAxisColumn = "DIVISIONNAME";
			String yAxiscolumn = "VALUE";
			chart = chartGenSerivce.getChartForAxes(biDataResponse, xAxisColumn, yAxiscolumn);
			if (chart != null) {
				chart.setChartCategory("openPositionsCountByDivision");
				chart.setChartTitle("Open Positions Count By Division");
				chart.setColors(new String[]{"#339966","#fe6394","#ef8e62"});
			}
		} else {
			System.out.println("Response null for Open Open Positions Count By Division");
		}
		return chart;

	}

	private ChartDto getOpenPositionsCountbyJobTypeChart(Date from, Date to) throws Exception {
		GetBIDataResponse biDataResponse = biDataService.openPositionsCountbyJobType(from, to);
		ChartDto chart = null;
		if (biDataResponse != null) {
			if (biDataResponse.getData() == null) {
				System.out.println(biDataResponse.getMessage());
			}
			String xAxisColumn = "JOBTYPE";
			String yAxiscolumn = "VALUE";
			chart = chartGenSerivce.getChartForAxes(biDataResponse, xAxisColumn, yAxiscolumn);
			if (chart != null) {
				chart.setChartCategory("openPositionsCountbyJobType");
				chart.setChartTitle("Open Positions Count By Jobtype");
				chart.setColors(new String[]{"#333300","#ff6154","#ab8e72"});
			}
		} else {
			System.out.println("Response null for Open Positions Count By Jobtype");
		}
		return chart;

	}

	private ChartDto getNewPositionsCountByPrimarySalesChart(Date from, Date to) throws Exception {
		GetBIDataResponse biDataResponse = biDataService.newPositionsCountByPrimarySales(from, to);
		ChartDto chart = null;
		if (biDataResponse != null) {
			if (biDataResponse.getData() == null) {
				System.out.println(biDataResponse.getMessage());
			}
			String xAxisColumn = "NAME";
			String yAxiscolumn = "VALUE";
			chart = chartGenSerivce.getChartForAxes(biDataResponse, xAxisColumn, yAxiscolumn);
			if (chart != null) {
				chart.setChartCategory("newPositionsCountByPrimarySales");
				chart.setChartTitle("New Positions Count By PrimarySales");
				chart.setColors(new String[]{"#996600","#ff5584","#ff8e88"});
			}
		} else {
			System.out.println("Response null for New Positions Count By PrimarySales");
		}
		return chart;

	}

	private ChartDto getNewPositionsCountByDivisionChart(Date from, Date to) throws Exception {
		GetBIDataResponse biDataResponse = biDataService.newPositionsCountByDivision(from, to);
		ChartDto chart = null;
		if (biDataResponse != null) {
			if (biDataResponse.getData() == null) {
				System.out.println(biDataResponse.getMessage());
			}
			String xAxisColumn = "DIVISIONNAME";
			String yAxiscolumn = "VALUE";
			chart = chartGenSerivce.getChartForAxes(biDataResponse, xAxisColumn, yAxiscolumn);
			if (chart != null) {
				chart.setChartCategory("newPositionsCountByDivision");
				chart.setChartTitle("Open Positions Count By Division");
				chart.setColors(new String[]{"#990033","#ff6454","#ff8e33"});
			}
		} else {
			System.out.println("Response null forOpen Positions Count By Division");
		}
		return chart;
	}

	private ChartDto getHiresCountByDivisionChart(Date from, Date to) throws Exception {
		ChartDto chart = null;
		GetBIDataResponse biDataResponse = biDataService.hiresCountByDivision(from, to);
		if (biDataResponse != null) {
			if (biDataResponse.getData() == null) {
				System.out.println(biDataResponse.getMessage());
			}
			String xAxisColumn = "DIVISIONNAME";
			String yAxiscolumn = "VALUE";
			chart = chartGenSerivce.getChartForAxes(biDataResponse, xAxisColumn, yAxiscolumn);
			if (chart != null) {
				chart.setChartCategory("hiresCountByDivision");
				chart.setChartTitle("Hires Count By Division");
				chart.setColors(new String[]{"#ff0066","#fd3484","#f2ef72"});
			}
		} else {
			System.out.println("Response null for Hires Count By Division");
		}
		return chart;
	}

	private ChartDto getHiresCountByPrimarySalesChart(Date from, Date to) throws Exception {
		GetBIDataResponse biDataResponse = biDataService.hiresCountByPrimarySales(from, to);
		ChartDto chart = null;
		if (biDataResponse != null) {
			if (biDataResponse.getData() == null) {
				System.out.println(biDataResponse.getMessage());
			}
			String xAxisColumn = "PRIMARYSALESNAME";
			String yAxiscolumn = "VALUE";
			chart = chartGenSerivce.getChartForAxes(biDataResponse, xAxisColumn, yAxiscolumn);
			if (chart != null) {
				chart.setChartCategory("hiresCountByPrimarySales");
				chart.setChartTitle("Hires Count By PrimarySales");
				chart.setColors(new String[]{"#9900cc","#fd3482","#f2df72"});
			}
		} else {
			System.out.println("Response null for Hires Count By PrimarySales");
		}
		return chart;

	}

	private ChartDto getFilledPositionsCountByDivisionChart(Date from, Date to) throws Exception {
		GetBIDataResponse biDataResponse = biDataService.filledPositionsCountbyDivision(from, to);
		ChartDto chart = null;
		if (biDataResponse != null) {
			if (biDataResponse.getData() == null) {
				System.out.println(biDataResponse.getMessage());
			}
			String xAxisColumn = "DIVISIONNAME";
			String yAxiscolumn = "VALUE";
			chart = chartGenSerivce.getChartForAxes(biDataResponse, xAxisColumn, yAxiscolumn);
			if (chart != null) {
				chart.setChartCategory("filledPositionsCountByDivision");
				chart.setChartTitle("Filled Positions Count By Division");
				chart.setColors(new String[]{"#ff9933","#fd4484","#f2ef10"});
			}
		} else {
			System.out.println("Response null for Filled Positions Count By Division");
		}
		return chart;
	}

	public List<ChartDto> getChartsForRole(String rolename, String globalTimePeriod) {
		Date[] dates = getStartAndEndDates(globalTimePeriod);
		List<ChartDto> charts;
//		if (globalTimePeriod.equals("Bi-Weekly") || globalTimePeriod.equals("Monthly")) {
//			charts = getChartsForRoleAndTimeRangeFromDB(rolename, dates[0], dates[1]);
//		} else
			charts = getChartsForRoleAndTimeRange(rolename, dates[0], dates[1]);
		return charts;
	}

//	private List<ChartDto> getChartsForRoleAndTimeRangeFromDB(String rolename, Date from, Date to) {
//		List<ChartDto> charts = new ArrayList<ChartDto>();
//		countsByDivisionService.findByCreationsDateBetween(from, to);
//		try {
//			if (rolename.equalsIgnoreCase("all")) {
//				charts.addAll(getCharts(from, to).values());
//			} else if (rolename.equalsIgnoreCase("admin")) {
//				charts.add(getHiresCountByDivisionChart(from, to));
//				charts.add(getHiresCountByPrimarySalesChart(from, to));
//				charts.add(getFilledPositionsCountByDivisionChart(from, to));
//			} else if (rolename.equalsIgnoreCase("manager")) {
//				charts.add(getNewPositionsCountByPrimarySalesChart(from, to));
//				charts.add(getNewPositionsCountByDivisionChart(from, to));
//			} else if (rolename.equalsIgnoreCase("recruiter")) {
//				charts.add(getOpenPositionsCountByDivisionChart(from, to));
//				charts.add(getOpenPositionsCountByPrimarySalesChart(from, to));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		charts.removeIf(Objects::isNull);
//		return charts;
//	}

	public List<ChartDto> getChartsForRoleAndTimeRange(String rolename, Date from, Date to) {
		List<ChartDto> charts = new ArrayList<ChartDto>();
		try {
			if (rolename.equalsIgnoreCase("all")) {
				charts.addAll(getCharts(from, to).values());
			} else if (rolename.equalsIgnoreCase("admin")) {
				charts.add(getHiresCountByDivisionChart(from, to));
				charts.add(getHiresCountByPrimarySalesChart(from, to));
				charts.add(getFilledPositionsCountByDivisionChart(from, to));
			} else if (rolename.equalsIgnoreCase("manager")) {
				charts.add(getNewPositionsCountByPrimarySalesChart(from, to));
				charts.add(getNewPositionsCountByDivisionChart(from, to));
			} else if (rolename.equalsIgnoreCase("recruiter")) {
				charts.add(getOpenPositionsCountByDivisionChart(from, to));
				charts.add(getOpenPositionsCountByPrimarySalesChart(from, to));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		charts.removeIf(Objects::isNull);
		return charts;
	}

	public List<ChartDto> getChartsForSelectedTimeperiod(String selectedTimePeriod, String role) {
		Date[] dates = getStartAndEndDates(selectedTimePeriod);
		List<ChartDto> charts = getChartsForRoleAndTimeRange(role, dates[0], dates[1]);
		return charts;
	}

	private Date[] getStartAndEndDates(String selectedTimePeriod) {
		DateTime to = new DateTime();
		DateTime from = to.minusDays(7);
		if (selectedTimePeriod.equalsIgnoreCase("Previous Day"))
			from = to.minusDays(1);
		if (selectedTimePeriod.equalsIgnoreCase("Weekly"))
			from = to.minusDays(7);
		if (selectedTimePeriod.equalsIgnoreCase("Bi-Weekly"))
			from = to.minusDays(14);
		if (selectedTimePeriod.equalsIgnoreCase("Monthly"))
			from = to.minusDays(30);
		Date dates[] = new Date[] { from.toDate(), to.toDate() };
		return dates;
	}

	public ChartDto getChartForSelectedTimeperiod(String selectedTimePeriod, String chartCategory) {
		Date[] selectedDates = getStartAndEndDates(selectedTimePeriod);
		ChartDto chart = null;
		try {
			if (chartCategory.equalsIgnoreCase("hiresCountByDivision"))
				chart = getHiresCountByDivisionChart(selectedDates[0], selectedDates[1]);
			else if (chartCategory.equalsIgnoreCase("hiresCountByPrimarySales"))
				chart = getHiresCountByPrimarySalesChart(selectedDates[0], selectedDates[1]);
			else if (chartCategory.equalsIgnoreCase("filledPositionsCountByDivision"))
				chart = getFilledPositionsCountByDivisionChart(selectedDates[0], selectedDates[1]);
			else if (chartCategory.equalsIgnoreCase("newPositionsCountByDivision"))
				chart = getNewPositionsCountByDivisionChart(selectedDates[0], selectedDates[1]);
			else if (chartCategory.equalsIgnoreCase("newPositionsCountByPrimarySales"))
				chart = getNewPositionsCountByPrimarySalesChart(selectedDates[0], selectedDates[1]);
			else if (chartCategory.equalsIgnoreCase("openPositionsCountByDivision"))
				chart = getOpenPositionsCountByDivisionChart(selectedDates[0], selectedDates[1]);
			else if (chartCategory.equalsIgnoreCase("openPositionsCountByPrimarySales"))
				chart = getOpenPositionsCountByPrimarySalesChart(selectedDates[0], selectedDates[1]);
			else if (chartCategory.equalsIgnoreCase("openPositionsCountbyJobType"))
				chart = getOpenPositionsCountbyJobTypeChart(selectedDates[0], selectedDates[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chart;
	}

}
