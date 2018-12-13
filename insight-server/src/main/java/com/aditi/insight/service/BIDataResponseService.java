package com.aditi.insight.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aditi.insight.ws.client.BIDataClient;
import com.jobdiva.bi.GetBIDataResponse;
import com.jobdiva.bi.Pair;
import com.jobdiva.bi.RowData;

@Service
public class BIDataResponseService {

	private static final Logger log = LoggerFactory.getLogger(BIDataResponseService.class);

	public List<List<String>> getColumn(GetBIDataResponse res, List<String> yAxiscolumns) {
		List<List<String>> colItems2D = new ArrayList<List<String>>();
		List<RowData> rowDataList = res.getData().getRow();
		Map<String, List<String>> colMap = new LinkedHashMap<>();
		for (String yAxis : yAxiscolumns) {
			colMap.put(yAxis, new ArrayList<String>());
		}
		for (RowData rowData : rowDataList) {
			Pair pair = rowData.getRowData().get(0);
			colMap.get(pair.getName()).add(pair.getValue());
		}
		colItems2D.addAll(colMap.values());
		return colItems2D;
	}

	public List<String> getColumnValue(GetBIDataResponse res, String columnName) {
		List<String> colItems = new ArrayList<String>();
		List<RowData> rowDataList = res.getData().getRow();
		for (RowData rowData : rowDataList) {
			for (Pair pair : rowData.getRowData()) {
				if (pair.getName().equals(columnName))
					colItems.add(pair.getValue());
			}
		}
		return colItems;
	}

	public List<List<String>> getColumn(GetBIDataResponse res, String yAxiscolumn) {
		List<List<String>> colItems2D = new ArrayList<List<String>>();
		List<String> colItems = new ArrayList<String>();
		if (res != null && res.getData() != null) {
			List<RowData> rowDataList = res.getData().getRow();
			for (RowData rowData : rowDataList) {
				for (Pair pair : rowData.getRowData()) {
					if (pair.getName().equals(yAxiscolumn))
						colItems.add(pair.getValue());
				}
			}
		}
		colItems2D.add(colItems);
		return colItems2D;
	}

	public List<String[]> getLabels(GetBIDataResponse res, String xAxisColumn) {
		List<String[]> colItems = new ArrayList<String[]>();
		if (res != null && res.getData() != null) {
			List<RowData> rowDataList = res.getData().getRow();
			int dataSize = rowDataList.size();
			for (RowData rowData : rowDataList) {
				for (Pair pair : rowData.getRowData()) {
					if (pair.getName().equals(xAxisColumn)) {
						String label = pair.getValue() != null && !pair.getValue().isEmpty() ? pair.getValue()
								: "NO " + xAxisColumn;
						String[] labelArr=new String[]{ label };
						if (label.length() > 20 && dataSize<20) {
							labelArr = label.split(" ");
						} 
						colItems.add(labelArr);
					}
				}
			}
		}

		return colItems;
	}
}
