package com.gg.www.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年01月19日 16:05:04  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/ 

@Configuration
public class Config {
	public static String VERSION = "V1.0.0";


	public static String GAME_NAME = "";

	public static String GAME_CODE = "";
	
	//  是否使用内网
	public static boolean useNeiwang = true;

	public static String frontUserServerName = "玩家用户";
	public static String walletServerName = "钱包";
	public static String statisticsServerName = "统计";
	public static String operationServerName = "操作";
	public static String scoketServerName = "推送";
	public static String backUserServerName = "后台用户";
	public static String kongtouServerName = "空投";

	public static String backUserServerURL = "http://192.168.0.42/user/";
	public static String serverInfoUrl = "http://192.168.0.42/configCenter/configCenter/api/serverInfoApi/getServerInfoMap";

	@Bean
    //@LoadBalanced   // 用于 ribbon 负载
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

