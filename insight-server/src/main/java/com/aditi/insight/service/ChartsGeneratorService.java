package com.aditi.insight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditi.insight.dto.models.ChartDto;
import com.jobdiva.bi.GetBIDataResponse;

@Service
public class ChartsGeneratorService {

	@Autowired
	private BIDataResponseService biDataResService;

	public ChartDto getChartForAxes(GetBIDataResponse biDataResponse, String xAxisColumn, List<String> yAxiscolumns) {
		List<String[]> labels = biDataResService.getLabels(biDataResponse, xAxisColumn);
		List<List<String>> data = biDataResService.getColumn(biDataResponse, yAxiscolumns);
		ChartDto hiresCountByDivisionChartDto = null;
		if (labels != null && !labels.isEmpty() && data != null && !data.isEmpty()) {
			hiresCountByDivisionChartDto = new ChartDto();
			hiresCountByDivisionChartDto.setType("bar");
			hiresCountByDivisionChartDto.setLabels(labels);
			hiresCountByDivisionChartDto.setData(data);
		}
		return hiresCountByDivisionChartDto;
	}

	public ChartDto getChartForAxes(GetBIDataResponse biDataResponse, String xAxisColumn, String yAxiscolumn) {
		List<String[]> labels = biDataResService.getLabels(biDataResponse, xAxisColumn);
		List<List<String>> data = biDataResService.getColumn(biDataResponse, yAxiscolumn);
		ChartDto hiresCountByDivisionChartDto = null;
		if (labels != null && !labels.isEmpty() && data != null && !data.isEmpty()) {
			hiresCountByDivisionChartDto = new ChartDto();
			hiresCountByDivisionChartDto.setType("bar");
			hiresCountByDivisionChartDto.setLabels(labels);
			hiresCountByDivisionChartDto.setData(data);
			hiresCountByDivisionChartDto.setOptions(hiresCountByDivisionChartDto.new ChartOptions());
			hiresCountByDivisionChartDto.setXAxisName(xAxisColumn);
			hiresCountByDivisionChartDto.setYAxisName(yAxiscolumn);
		}
		return hiresCountByDivisionChartDto;
	}

}
