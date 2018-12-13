package com.aditi.insight.config;

import javax.annotation.PostConstruct;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.aditi.insight.ApplicationGobalData;

@Configuration
public class WSClientConfig {

  @Value("${client.ws.bi.url}")
  private String wsUrl;

  @Value("${client.ws.user.name}")
  private String userName;

  @Value("${client.ws.user.password}")
  private String userPassword;
  
  @Value("${client.ws.package}")
  private String wsPackage;
  
  @Value("${client.ws.client.id}")
  private String clientId;
  
  @PostConstruct
  private void postInit() {
	  ApplicationGobalData.setClientId(clientId); 
	  ApplicationGobalData.setWsUrl(wsUrl);
	  ApplicationGobalData.setUserName(userName);
	  ApplicationGobalData.setUserPassword(userPassword);
  }

  @Bean
  Jaxb2Marshaller jaxb2Marshaller() {
    Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
    jaxb2Marshaller.setContextPath(wsPackage);
    return jaxb2Marshaller;
  }

  @Bean
  public WebServiceTemplate webServiceTemplate() {
    WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
    webServiceTemplate.setMarshaller(jaxb2Marshaller());
    webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
    webServiceTemplate.setDefaultUri(wsUrl);
    // set a HttpComponentsMessageSender which provides support for basic authentication
    webServiceTemplate.setMessageSender(httpComponentsMessageSender());
    return webServiceTemplate;
  }

  @Bean
  public HttpComponentsMessageSender httpComponentsMessageSender() {
    HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
    // set the basic authorization credentials
    httpComponentsMessageSender.setCredentials(usernamePasswordCredentials());

    return httpComponentsMessageSender;
  }

  @Bean
  public UsernamePasswordCredentials usernamePasswordCredentials() {
    // pass the user name and password to be used
    return new UsernamePasswordCredentials(userName, userPassword);
  }
}