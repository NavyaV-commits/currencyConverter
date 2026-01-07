package com.example.jumpApp.service;

import java.util.List;
import java.util.Map;

import org.hibernate.boot.models.spi.ConversionRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.jumpApp.model.Conversion;
import com.example.jumpApp.repository.ConversionRepository;

@Service
public class ConversionService {

	@Autowired
	private ConversionRepository conversionRepository;
	private final RestTemplate restTemplate= new RestTemplate();
	
	public Double save(Double amount, String currency) {
		String url= "https://open.er-api.com/v6/latest/USD";
		
		Map response = restTemplate.getForObject(url, Map.class);
		
		Map<String, Double> rates = (Map<String, Double>)response.get("rates");
		
		
		Double rate = rates.get(currency);
		
		Double converted =  amount*rate;
		
		Conversion c= new Conversion();
		c.setUsdAmount(amount);
		c.setTargetCurrency(currency);
		c.setRate(rate);
		c.setConvertedAmount(converted);
		
		conversionRepository.save(c);
		
		return converted;
		
	}
	
	public List<Conversion> findAll(){
		return conversionRepository.findAll();
	}
}
