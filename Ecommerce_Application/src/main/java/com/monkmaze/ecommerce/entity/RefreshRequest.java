package com.monkmaze.ecommerce.entity;

public class RefreshRequest {

	  private String refresh_token;
	  
	   public RefreshRequest() {}

	public String getRefreshToken() {
		return refresh_token;
	}

	public void setRefreshToken(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	   
}
