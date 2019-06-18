package com.gg.www.client.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.gg.www.common.JsonResult;

@Component("httpUtils")
public class HttpUtils {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	protected JsonResult jsonResult;

	private static Logger logger = LoggerFactory.getLogger("programLog");

	public JsonResult getUrlReturn(String url) {
		return this.getUrlReturn(url, new HashMap<>(), new HashMap<>());
	}

	public JsonResult getUrlReturn(String url, Map<String, String> headerMap, Map<String, String> paramsMap) {
		HttpHeaders requestHeaders = new HttpHeaders();
		for (String headerName : headerMap.keySet()) {
			requestHeaders.add(headerName, headerMap.get(headerName));
		}
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
		for (String params : paramsMap.keySet()) {
			requestBody.add(params, paramsMap.get(params));
		}
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, requestHeaders);
		JsonResult jr = new JsonResult();
		try {
			String returnStr = this.restTemplate.postForObject(url, requestEntity, String.class);
			logger.info("HttpUtils|getUrlReturn|url= + " + url + "|returnStr=" + returnStr);
			jr = JSON.parseObject(returnStr, JsonResult.class);
			logger.info("HttpUtils|getUrlReturn|JsonResult= " + jr.getStatusCode());
			return jr;
		} catch (Exception e) {
			logger.info("HttpUtils|getUrlReturn|Exception=" + e.getMessage());
			jr.setStatusMsg("服务器通信错误！！！|" + e.getMessage());
		}
		jr.setStatusCode(0000);
		return jr;
	}

	@Async
	public void notice(String url, Map<String, String> headerMap, Map<String, String> paramsMap) {
		HttpHeaders requestHeaders = new HttpHeaders();
		for (String headerName : headerMap.keySet()) {
			requestHeaders.add(headerName, headerMap.get(headerName));
		}
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
		for (String params : paramsMap.keySet()) {
			requestBody.add(params, paramsMap.get(params));
		}
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, requestHeaders);
		try {
			String returnStr = this.restTemplate.postForObject(url, requestEntity, String.class);
			logger.info("HttpUtils|@Async|notice|url= + " + url + "|returnStr=" + returnStr);
		} catch (Exception e) {
			logger.info("HttpUtils|@Async|notice|Exception=" + e.getMessage());
		}
	}

}

