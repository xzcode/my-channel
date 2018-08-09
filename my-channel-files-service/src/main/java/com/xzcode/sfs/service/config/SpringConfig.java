package com.xzcode.sfs.service.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class SpringConfig implements ApplicationContextAware{

	@Value("${server.database.filePath}")
	private String dbFilePath;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		initDbFile();
		
	}
	
	
	private void initDbFile(){
		
		if(dbFilePath == null || dbFilePath.isEmpty()) {
			return;
		}
		
		File file = new File(dbFilePath);
		if (!file.exists()) {
			ClassPathResource fileResource = new ClassPathResource("files.db");			
			try (
					InputStream in = fileResource.getInputStream();
					FileOutputStream out = new FileOutputStream(file);
				){
				if (!fileResource.exists()) {
					throw new IOException("Sqlite db file not found!");
				}
				
				byte[] b = new byte[1024]; 
				int len = -1;
	            while((len = in.read(b)) != -1) {  
	                out.write(b, 0, len);  
	            }
	            
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	
	
}
