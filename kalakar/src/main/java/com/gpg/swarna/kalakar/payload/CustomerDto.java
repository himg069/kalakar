package com.gpg.swarna.kalakar.payload;

import java.util.List;

import lombok.Data;

@Data
public class CustomerDto {
	
	private String customerName;
	
	private String custVillageName;
	
	private String referenceName;
	
	private Double amountLend;
	
	private Double rateOfInterest;
	
	private List<String> itemDetails;
	
}
