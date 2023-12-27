package com.gpg.swarna.kalakar.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	String resourceFieldName;
	long fieldValue;
	String fieldName;
	public ResourceNotFoundException(String resourceName, String resourceFieldName, long fieldValue) {
		super(String.format("%s not found with %s : %l", resourceName, resourceFieldName, fieldValue));
		this.resourceName = resourceName;
		this.resourceFieldName = resourceFieldName;
		this.fieldValue = fieldValue;
	}
	public ResourceNotFoundException(String resourceName, String resourceFieldName, String fieldName) {
		super(String.format("%s not found with %s : %s", resourceName, resourceFieldName, fieldName));
		this.resourceName = resourceName;
		this.resourceFieldName = resourceFieldName;
		this.fieldName = fieldName;
	}
	public ResourceNotFoundException() {
		super();
	}
	
	

}
