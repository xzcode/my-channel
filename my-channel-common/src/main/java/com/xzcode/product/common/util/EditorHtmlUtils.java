package com.xzcode.product.common.util;

public class EditorHtmlUtils {
	
	public static final String HTML_HEADER = "<!DOCTYPE html>\n" +
			"<html>\n" +
			"<head>\n" +
			"<meta charset=\"utf-8\">\n" +
			"<meta name=\"viewport\" content=\"width=device-width,target-densitydpi=high-dpi,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n" +
			"<title>Banner</title>\n" +
			"<style>\n" +
			"p, span, div{ word-wrap: break-word;}\n" +
			"img { -ms-interpolation-mode: bicubic; }\n" +
			"img { width: 100%; }\n" +
			"</style>\n" +
			"</head>\n" +
			"<body>";
	
	
	public static final String HTML_FOOTER = "</body></html>";
	
	public static String getHtml(String content){
		
		StringBuilder sb = new StringBuilder(HTML_HEADER);
		sb.append(content);
		sb.append(HTML_FOOTER);
		return sb.toString();
		
	}

}
