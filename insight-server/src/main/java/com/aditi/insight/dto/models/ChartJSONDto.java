package com.aditi.insight.dto.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString()

public class ChartJSONDto implements Serializable {
	private static final long serialVersionUID = -5050510583481559448L;
	private String type;
	private Data data;

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Data getData() {
		return this.data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public class Dataset {
		private String label;
		
		private List<String> data;

		private Integer borderWidth;

		public String getLabel() {
			return this.label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public List<String> getData() {
			return this.data;
		}

		public void setData(List<String> list) {
			this.data = list;
		}

		public Integer getBorderWidth() {
			return this.borderWidth;
		}

		public void setBorderWidth(Integer borderWidth) {
			this.borderWidth = borderWidth;
		}
	}

	public class Data {
		private List<String> labels;
		
		private List<Dataset> datasets;

		public List<String> getLabels() {
			return this.labels;
		}

		public void setLabels(List<String> list) {
			this.labels = list;
		}

		public List<Dataset> getDatasets() {
			return this.datasets;
		}

		public void setDatasets(List<Dataset> dataSets) {
			this.datasets = dataSets;
		}
	}

}