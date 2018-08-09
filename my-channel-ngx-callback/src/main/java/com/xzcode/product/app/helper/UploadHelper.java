package com.xzcode.product.app.helper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="upload")
public class UploadHelper {
	
	private String host;
	
	private String uploadUrl;
	
	private String deleteUrl;
	
	
	public String getMini(String imageUrl) {
		return imageUrl == null ? imageUrl :imageUrl.replaceAll("_normal", "_mini");
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	public String getDeleteUrl() {
		return deleteUrl;
	}

	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}
	
	
}
