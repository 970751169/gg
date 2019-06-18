package com.gg.www.client.backUser;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gg.www.client.backUser.vo.BackUserVo;
import com.gg.www.client.configCenter.ConfigCenterUtils;
import com.gg.www.client.utils.HttpUtils;
import com.gg.www.common.JsonResult;
import com.gg.www.config.Config;

@Component("backUserUtils")
public class BackUserUtils {

	private static final Log log = LogFactory.getLog("programLog");

	@Autowired
	protected HttpUtils httpUtils;

	@Autowired
	protected ConfigCenterUtils configCenterUtils;

	public BackUserVo getBackUserVo(String token) {
		BackUserVo backUserVo = new BackUserVo();
		if (token == null || token.length() == 0) {
			return backUserVo;
		}
		String getUserUrl = this.configCenterUtils.getUrl(Config.backUserServerName);
		if (getUserUrl == null || getUserUrl.length() == 0) {
			log.info("BackUserUtils|******error******|getBackUserVo|getUserUrl=" + getUserUrl);
			// return backUserVo;
			getUserUrl = Config.backUserServerURL;
		}
		getUserUrl = getUserUrl + "userApi/getUser";
		// headers
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("token", token);
		// body
		log.info("BackUserUtils|getUser|getUserUrl=" + getUserUrl);
		JsonResult jr = this.httpUtils.getUrlReturn(getUserUrl, headerMap, new HashMap<>());
		if(jr.getStatusCode() != 200) {
			return backUserVo;
		}
		log.info("BackUserUtils|getUser|jr.getData().toString()=" + jr.getData().toString());

		JSONObject userJson = JSON.parseObject(jr.getData().toString());
		if (userJson == null || userJson.getInteger("userId") == 0) {
			return backUserVo;
		}
		backUserVo.setUserId(userJson.getInteger("userId"));
		backUserVo.setToken(userJson.getString("token"));
		backUserVo.setUsername(userJson.getString("username"));
		backUserVo.setNickname(userJson.getString("nickname"));
		backUserVo.setRoleName(userJson.getString("roleName"));
		backUserVo.setTbStatus(userJson.getString("tbStatus"));
		backUserVo.urlPowerList = JSON.parseArray(userJson.getString("urlPowerList"), String.class);
		log.info("BackUserUtils|getUser|urlPowerList=" + JSON.toJSONString(backUserVo.urlPowerList));
		return backUserVo;
	}

}

