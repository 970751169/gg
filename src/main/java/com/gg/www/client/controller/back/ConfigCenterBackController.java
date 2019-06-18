package com.gg.www.client.controller.back;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gg.www.client.configCenter.ConfigCenterUtils;
import com.gg.www.client.configCenter.vo.ServerVo;
import com.gg.www.common.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "重新加载配置信息")
@RestController
@RequestMapping("/client/back/configCenterBack")
public class ConfigCenterBackController {
	private static Logger logger = LoggerFactory.getLogger("programLog");

	@Autowired
	protected JsonResult jsonResult;

	@Autowired
	protected ConfigCenterUtils configCenterUtils;

	@ApiOperation(value = "从新加载配置信息", notes = "从新加载配置信息", httpMethod = "POST")
	@RequestMapping(value = "/reload", produces = "application/json;charset=UTF-8")
	public String reload() {
		Map<String, ServerVo> map = this.configCenterUtils.reload();
		return this.jsonResult.ok(map);
	}
}

