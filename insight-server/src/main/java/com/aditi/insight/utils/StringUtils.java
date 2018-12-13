package com.aditi.insight.utils;

import java.util.LinkedList;
import java.util.List;

import com.jobdiva.bi.GetBIDataResponse;
import com.jobdiva.bi.Pair;
import com.jobdiva.bi.RowData;

public class StringUtils {

	public static String toString(GetBIDataResponse dataResponse) {

		String message = dataResponse.getMessage() + "\n";
		if (dataResponse.getData() != null) {
			String columnNameString = String.join("  ", dataResponse.getData().getColumns().getColumn()) + "\n";
			StringBuilder rowDataString = new StringBuilder("");
			List<String> rowDataValues = new LinkedList<>();
			for (RowData rowData : dataResponse.getData().getRow()) {
				for (Pair pair : rowData.getRowData()) {
					rowDataValues.add(pair.getValue());
				}
				rowDataString.append(String.join(" | ", rowDataValues) + "\n");
				rowDataValues.clear();
			}

			return message + columnNameString + rowDataString.toString();
		}

		return message;
	}
}
