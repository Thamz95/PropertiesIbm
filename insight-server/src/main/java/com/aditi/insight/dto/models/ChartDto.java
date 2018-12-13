package com.aditi.insight.dto.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString()
@JsonInclude(Include.NON_NULL)
public class ChartDto implements Serializable {
	private static final long serialVersionUID = -4823194272130336699L;
	private String chartCategory;
	private String type;
	private String chartTitle;
	private List<String[]> labels;
	private List<List<String>> data;
	private List<DataSetOverride> dataSetToOveride;
	private ChartOptions options;
	private String[] colors;

	@Data

	@JsonInclude(Include.NON_NULL)
	public class DataSetOverride {
		private String label;
		private String borderWidth;
		private String type;
	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public class ChartOptions {
		private Map<String, List<Map<String, Object>>> scales;

		public ChartOptions() {
			super();
			this.scales = new LinkedHashMap<String, List<Map<String, Object>>>();
			Map<String, Object> xAxesOptions = new LinkedHashMap<String, Object>();
			Map<String, Object> yAxesOptions = new LinkedHashMap<String, Object>();
			xAxesOptions.put("scaleLabel", new ScaleLabel());
			yAxesOptions.put("scaleLabel", new ScaleLabel());
			xAxesOptions.put("ticks", new Ticks());
			yAxesOptions.put("ticks", new Ticks());
			List<Map<String, Object>> xAxesOptionsList = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> yAxesOptionsList = new ArrayList<Map<String, Object>>();
			xAxesOptionsList.add(xAxesOptions);
			yAxesOptionsList.add(yAxesOptions);
			scales.put("xAxes", xAxesOptionsList);
			scales.put("yAxes", yAxesOptionsList);
		}
	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public class ScaleLabel {
		private boolean display;
		private String labelString;
	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public class Ticks {
		private Integer min;
		private Integer max;
		private Integer stepSize;
		private String callBack;
		private Boolean beginAtZero;
		private Boolean autoSkip;

		public Ticks() {
			super();
			this.autoSkip = false;
		}

	}

	public void setXAxisName(String xAxisColumn) {
		List<Map<String, Object>> xAxesOptionsList = this.getOptions().getScales().get("xAxes");
		ScaleLabel scaleLabel = (ScaleLabel) xAxesOptionsList.get(0).get("scaleLabel");
		scaleLabel.setDisplay(true);
		scaleLabel.setLabelString(xAxisColumn);
	}

	public void setYAxisName(String yAxiscolumn) {
		List<Map<String, Object>> xAxesOptionsList = this.getOptions().getScales().get("yAxes");
		ScaleLabel scaleLabel = (ScaleLabel) xAxesOptionsList.get(0).get("scaleLabel");
		scaleLabel.setDisplay(true);
		scaleLabel.setLabelString(yAxiscolumn);
	}

}