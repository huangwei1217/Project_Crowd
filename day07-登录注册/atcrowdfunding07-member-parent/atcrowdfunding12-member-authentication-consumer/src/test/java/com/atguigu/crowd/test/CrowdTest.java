package com.atguigu.crowd.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aliyun.api.gateway.demo.util.HttpUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrowdTest {

	private Logger logger = LoggerFactory.getLogger(CrowdTest.class);

	@Test
	public void testSendMessage() {
		String host = "https://gyytz.market.alicloudapi.com";
		String path = "/sms/smsSend";
		String method = "POST";
		String appcode = "8ac732670c5c4565b1965deca9401ffc";
		Map<String, String> headers = new HashMap<String, String>();
		//最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("mobile", "17816076061");
		querys.put("param", "**验证码**:157751");
		querys.put("smsSignId", "a5ac237f6d1a4672b9ba46b432716c5d");
		querys.put("templateId", "f5e68c3ad6b6474faa8cd178b21d3377");
		Map<String, String> bodys = new HashMap<String, String>();


		try {
			/**
			 * 重要提示如下:
			 * HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
			 * 下载
			 *
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
			 */
			HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);

			StatusLine statusLine = response.getStatusLine();

			// 状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
			int statusCode = statusLine.getStatusCode();
			logger.info("code="+statusCode);

			String reasonPhrase = statusLine.getReasonPhrase();
			logger.info("reason="+reasonPhrase);

			// System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
			// 获取response的body
			logger.info(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
