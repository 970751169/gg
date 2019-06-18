package com.gg.www.client.controller.back;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gg.www.common.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "预警接口")
@RestController
@RequestMapping("/client/back/alertBack")
public class AlertBackController {

	private static Logger logger = LoggerFactory.getLogger("programLog");

	@Autowired
	protected JsonResult jsonResult;

	@ApiOperation(value = "预警接口", notes = "检测服务是否正常", httpMethod = "POST")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header"), })
	@RequestMapping(value = "/isOK", produces = "application/json;charset=UTF-8")
	public String isOK() {

		return this.jsonResult.ok("OK");
	}

}


