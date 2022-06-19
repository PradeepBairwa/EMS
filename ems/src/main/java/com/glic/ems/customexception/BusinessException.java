package com.glic.ems.customexception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
    private String errorMessage;
    
    
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BusinessException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		System.out.println(errorCode+":"+errorMessage);
	}
	
    public BusinessException() {
    	
    }
	@Override
	public String toString() {
		return "BusinessException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
    
    
}
