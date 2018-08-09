package com.xzcode.product.app.controller.message;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.helper.ThHelper;
import com.xzcode.product.app.service.facade.message.IMessageService;
import com.xzcode.product.common.entity.message.Message;
import com.xzcode.product.common.util.AjaxResponse;


@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@Autowired
	private IMessageService messageService;
	
	String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
	
	/**
	 * 提交留言
	 * @param message
	 * @return
	 * 
	 * @author zai
	 * 2018-07-05 17:12:23
	 */
	@RequestMapping("/submit")
	@ResponseBody
	public AjaxResponse submit(
			Message message
			) {
		
		
		String username = message.getUsername();
		if (StringUtils.isEmpty(username)) {
			return AjaxResponse.fail("姓名不能为空");
		}
		if (username.length() < 2) {
			return AjaxResponse.fail("姓名太短");
		}
		
		String mobile = message.getMobile();
		if (StringUtils.isEmpty(mobile)) {
			return AjaxResponse.fail("手机号码不能为空");
		}
		
		if (!mobile.matches(PHONE_NUMBER_REG)) {
			return AjaxResponse.fail("手机号码格式不正确");
		}
		
		String content = message.getContent();
		if (StringUtils.isEmpty(content)) {
			return AjaxResponse.fail("留言内容不能为空");
		}
		
		message.setCreateDate(new Date());
		
		String dateStr = ThHelper.dateFormat(message.getCreateDate());
		
		
		Message oldMsg = this.jdbcLink.select(Message.class)
				.orderByDesc(Message.CREATE_DATE)
				.where()
					.and().eq(Message.MOBILE, message.getMobile())
					.and().like(Message.CREATE_DATE, dateStr + "%")
				.limit(1)
				.queryEntity()
				;
		if (oldMsg != null) {
			return AjaxResponse.fail("每个手机号码每天只能留言一次!");
		}
		
		
		this.jdbcLink.insert(message);
		
		return AjaxResponse.success();
	}
	
	
	
    
}
