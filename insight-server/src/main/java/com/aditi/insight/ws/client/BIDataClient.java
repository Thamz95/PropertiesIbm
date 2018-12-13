package com.aditi.insight.ws.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.aditi.insight.ApplicationGobalData;
import com.jobdiva.bi.GetBIData;
import com.jobdiva.bi.GetBIDataResponse;

@Component
public class BIDataClient {

	private static final Logger log = LoggerFactory.getLogger(BIDataClient.class);

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	public GetBIDataResponse getData(GetBIData getBIData) {
		log.info("Requesting bi data for " + getBIData);
		GetBIDataResponse response = (GetBIDataResponse) webServiceTemplate.marshalSendAndReceive(getBIData);
		log.info("Response bi data  " + response);
		return response;
	}

	public static GetBIData initBIDataRequest() {
		GetBIData getBIData = new GetBIData();
		getBIData.setClientID(ApplicationGobalData.getClientId());
		getBIData.setUsername(ApplicationGobalData.getUserName());
		getBIData.setPassword(ApplicationGobalData.getUserPassword());
		return getBIData;
	}

}