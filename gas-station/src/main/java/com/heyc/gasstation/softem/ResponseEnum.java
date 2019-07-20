package com.heyc.gasstation.softem;

public enum ResponseEnum {

	RESPONSE_STATUS_SUCCESS("success", "操作成功"),
	RESPONSE_STATUS_FAIL("fail", "操作失败");	
    private final String status; 
	private final String message;
    
    private ResponseEnum(String status, String message) { 
           this.status = status; 
           this.message = message;
    }

	public String getKey() {
		return status;
	}

	public String getValue() {
		return message;
	} 
    
}
