package com.stocks.stockService.resource;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;


@RestController
@RequestMapping("/rest/stock")
public class StockResourceController {
	
	 @Autowired
	 RestTemplate restTemplate;

	    @GetMapping("/{username}")
	    public List<Quote> getStock(@PathVariable("username") final String userName) {//"http://localhost:8300/rest/db/"

	    	System.out.println("in user--"+userName);
	        ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://db-service/rest/db/" + userName, HttpMethod.GET,
	                null, new ParameterizedTypeReference<List<String>>() {
	                });

	        System.out.println("in user--"+userName);
	        List<String> quotes = quoteResponse.getBody(); //Arrays.asList("INTC", "BABA", "TSLA", "AIR.PA", "YHOO");//
	        return quotes
	                .stream()
	                .map(quote -> {
	                    Stock stock = getStockPrice(quote);
	                    return new Quote(userName,quote, stock.getQuote().getPrice());
	                })
	                .collect(Collectors.toList());
	    }
	    
	    

	    private Stock getStockPrice(String quote) {
	        try {
	            return YahooFinance.get(quote);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return new Stock(quote);
	        }
	    }

	    private class Quote {
	    	private String userName;
	    	
	        private String quote;
	        private BigDecimal price;

	        public Quote(String userName ,String quote, BigDecimal price) {
	        	this.userName = userName;
	            this.quote = quote;
	            this.price = price;
	        }

	        public String getQuote() {
	            return quote;
	        }

	        public void setQuote(String quote) {
	            this.quote = quote;
	        }

	        public BigDecimal getPrice() {
	            return price;
	        }

	        public void setPrice(BigDecimal price) {
	            this.price = price;
	        }
	        
	        public String getUserName() {
				return userName;
			}

			public void setUserName(String userName) {
				this.userName = userName;
			}
	    }


}
