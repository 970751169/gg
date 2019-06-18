package com.gg.www.client.configCenter;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gg.www.client.configCenter.vo.ServerVo;
import com.gg.www.client.utils.HttpUtils;
import com.gg.www.common.JsonResult;
import com.gg.www.config.Config;

@Component("configCenterUtils")
public class ConfigCenterUtils {

	private static Logger logger = LoggerFactory.getLogger("program");

	private static Map<String, ServerVo> serverInfoVoMap = new HashMap<>();

	@Autowired
	protected HttpUtils httpUtils;

	public String getUrl(String name) {
		if(serverInfoVoMap == null || serverInfoVoMap.size() == 0) {
			this.init();
		}
		String url = "";
		if(serverInfoVoMap.get(name) == null) {
			return url;
		}
		String useIp = Config.useNeiwang ? serverInfoVoMap.get(name).getNeiwangIp() : serverInfoVoMap.get(name).getWaiwangIp();
		url = useIp + "/" + serverInfoVoMap.get(name).getBasePath() + "/";
		return url;
	}
	
	public Map<String, ServerVo> reload() {
		this.init();
		return serverInfoVoMap;
	}

	private void init() {
		Map<String, String> headerMap = new HashMap<>();
		Map<String, String> paramsMap = new HashMap<>();
		paramsMap.put("gameName", Config.GAME_NAME);
		paramsMap.put("noticeUrl", "");
		paramsMap.put("checkUrl", "");
		paramsMap.put("", "");
		paramsMap.put("", "");
		JsonResult jr = this.httpUtils.getUrlReturn(Config.serverInfoUrl, headerMap, paramsMap);
		if (jr == null || jr.getStatusCode() != 200) {
			logger.error(jr == null ? "服务器通信错误！！！" : jr.getStatusMsg());
			return;
		}
		serverInfoVoMap = JSON.parseObject(jr.getData().toString(), new TypeReference<Map<String, ServerVo>>() {
		});
	}
}

