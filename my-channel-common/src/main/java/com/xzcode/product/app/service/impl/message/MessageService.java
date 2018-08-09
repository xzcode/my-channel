package com.xzcode.product.app.service.impl.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xzcode.jdbclink.core.JdbcLink;
import javax.annotation.PostConstruct;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.app.dao.message.MessageMapper;
import com.xzcode.product.common.entity.message.Message;
import com.xzcode.product.app.service.facade.message.IMessageService;




/**
 * 留言信息表 service
 * 
 * @author jdbclink code generator & code generator
 * 2018-06-28 00:21:20
 */
@Service
public class MessageService extends BaseService<Message> implements IMessageService{
	
	@Autowired
	private MessageMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

}

	


