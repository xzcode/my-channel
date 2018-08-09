package com.xzcode.product.app.service.impl.feedback;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.dao.feedback.FeedbackMapper;
import com.xzcode.product.app.service.facade.feedback.IFeedbackService;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.common.entity.feedback.Feedback;




/**
 * 用户反馈信息表 service
 * 
 * @author zai & code generator
 * 2018-04-16 16:59:02
 */
@Service
public class FeedbackService extends BaseService<Feedback> implements IFeedbackService{
	
	@Autowired
	private FeedbackMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

}

	


