package com.aditi.insight;

public class ApplicationGobalData {

	private static String wsUrl = null;

	private static String userName = null;

	private static String userPassword = null;

	private static String clientId = null;

	public static String getWsUrl() {
		return wsUrl;
	}

	public static void setWsUrl(String wsUrl) {
		ApplicationGobalData.wsUrl = wsUrl;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		ApplicationGobalData.userName = userName;
	}

	public static String getUserPassword() {
		return userPassword;
	}

	public static void setUserPassword(String userPassword) {
		ApplicationGobalData.userPassword = userPassword;
	}

	public static String getClientId() {
		return clientId;
	}

	public static void setClientId(String clientId) {
		ApplicationGobalData.clientId = clientId;
	}

}
