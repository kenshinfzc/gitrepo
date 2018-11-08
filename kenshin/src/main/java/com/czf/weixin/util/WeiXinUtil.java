package com.czf.weixin.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.czf.weixin.message.qrcode.BaseQRReq;
import com.czf.weixin.message.qrcode.QRResp;
import com.czf.weixin.message.token.AccessToken;
import com.czf.weixin.message.token.OAuthAccessToken;
import com.czf.weixin.message.userinfo.UserInfo;
import com.czf.weixin.message.menu.Menu;

/**
 * 微信接口工具类
 * @author FENGZHI
 * @date 2016年8月30日
 */
public class WeiXinUtil {
	private static Logger log = LoggerFactory.getLogger(WeiXinUtil.class);
	
	//第三方用户唯一凭证
	private static final String appid = "wx5ca861548951f121";
	//第三方用户唯一凭证密钥，即appsecret 
	private static final String secret = "56e5fd99cbb85a5cf986675b6ee12e65";
	//获取access_token的接口地址（GET） 限200（次/天）
	private static final String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//菜单创建（POST） 限100（次/天）
	private static final String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  
	
	//OAuth2授权相关接口地址
	//用户同意授权，获取code
	private static final String auth_code_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	//通过code换取网页授权access_token     获取code后，请求以下链接获取access_token： 
	private static final String auth_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	//刷新access_token（如果需要）      获取第二步的refresh_token后，请求以下链接获取access_token： 
	private static final String auth_refresh_token_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	//拉取用户信息(需scope为 snsapi_userinfo)   http：GET（请使用https协议）
	private static final String auth_uesrinfo_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	//微信二维码
	//创建二维码ticket
	private static final String qr_code_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
	//通过ticket换取二维码
	private static final String qr_ticket_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	
	
	/** 
     * 发起https请求并获取结果 
     *  
     * @param requestUrl 请求地址 
     * @param requestMethod 请求方式（GET、POST） 
     * @param outputStr 提交的数据 
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值) 
     */  
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {  
        JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();  
        try {  
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            URL url = new URL(requestUrl);  
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
            httpUrlConn.setSSLSocketFactory(ssf);  
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            // 设置请求方式（GET/POST）  
            httpUrlConn.setRequestMethod(requestMethod);  
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            // 当有数据需要提交时  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码  
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.close();  
            }  
  
            // 将返回的输入流转换成字符串  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
            jsonObject = JSONObject.parseObject(buffer.toString());
//            jsonObject = JSONObject.fromObject(buffer.toString());  
        } catch (ConnectException ce) {  
            log.error("Weixin server connection timed out.");  
        } catch (Exception e) {  
            log.error("https request error:{}", e);  
        }  
        return jsonObject;  
    }  
	
    /**
     * 获取接入凭据 AccessToken
     * @return
     */
	public static AccessToken getAccessToken(){
		AccessToken accessToken = new AccessToken();
		String url = access_token_url.replace("APPID", appid).replace("APPSECRET", secret);
		
		JSONObject jsonObject = httpRequest(url, "GET", "");
		if(null != jsonObject){
			try {
				accessToken.setAccess_token(jsonObject.getString("access_token")); 
				accessToken.setExpires_in(jsonObject.getString("expires_in"));
			} catch (Exception e) {
				log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getString("errcode"), jsonObject.getString("errmsg"));
				return null;
			}
		}
		
		return accessToken;
	}
	
	/**
	 * 创建菜单
	 * @param menu
	 * @param access_token
	 * @return
	 */
	public static String createMenu(Menu menu,String access_token){
		String result = "0";
		String url = menu_create_url.replace("ACCESS_TOKEN", access_token);
		
		String menuStr = JSON.toJSONString(menu);
		JSONObject jsonObject = httpRequest(url, "POST", menuStr);
		if(null != jsonObject){
			if (!"0".equals(jsonObject.getString("errcode"))) {  
	            result = jsonObject.getString("errcode");  
	            log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getString("errcode"), jsonObject.getString("errmsg"));  
	        } 
		}
		return result;
	}
	
	/**
	 * OAuth2网页授权地址封装
	 * @param url
	 * @return
	 */
	public static String getOAuth2Url(String url,String scope){
		url = auth_code_url.replace("APPID", appid).replace("REDIRECT_URI", url)
				.replace("SCOPE", scope).replace("STATE", "123");
		return url;
	}
	
	/**
	 * 获取授权access_token，OAuthAccessToken
	 * @param code
	 * @return
	 */
	public static OAuthAccessToken getOAuthAccessToken(String code){
		OAuthAccessToken oAuthAccessToken = new OAuthAccessToken();
		String url = auth_access_token_url.replace("APPID", appid).replace("SECRET",secret).replace("CODE", code);
		
		JSONObject jsonObject = httpRequest(url, "POST", "");
		if(null != jsonObject){
			try {
				oAuthAccessToken.setAccess_token(jsonObject.getString("access_token"));
				oAuthAccessToken.setExpires_in(jsonObject.getString("expires_in"));
				oAuthAccessToken.setRefresh_token(jsonObject.getString("refresh_token"));
				oAuthAccessToken.setOpenid(jsonObject.getString("openid"));
				oAuthAccessToken.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				log.error("获取授权token失败: errcode:{},errmsg:{}",jsonObject.getString("errcode"),jsonObject.getString("errmsg"));
				return null;
			}
		}
		
		return oAuthAccessToken;
	}
	
	/**
	 * 获取用户信息
	 * @param oAuthAccessToken
	 * @return
	 */
	public static UserInfo getUserInfo(OAuthAccessToken oAuthAccessToken){
		UserInfo userInfo = new UserInfo();
		String url = auth_uesrinfo_url.replace("ACCESS_TOKEN", oAuthAccessToken.getAccess_token()).replace("OPENID", oAuthAccessToken.getOpenid());
		JSONObject jsonObject = httpRequest(url, "GET", "");
		if(null != jsonObject){
			try {
				userInfo.setOpenid(jsonObject.getString("openid"));
				userInfo.setNickname(jsonObject.getString("nickname"));
				userInfo.setSex(jsonObject.getString("sex"));
				userInfo.setProvince(jsonObject.getString("province"));
				userInfo.setCity(jsonObject.getString("city"));
				userInfo.setHeadimgurl(jsonObject.getString("headimgurl"));
				userInfo.setUnionid(jsonObject.getString("unionid"));
				userInfo.setPrivilege(jsonObject.getJSONArray("unionid"));
			} catch (Exception e) {
				log.error("获取用户信息失败: errcode:{},errmsg:{}",jsonObject.getString("errcode"),jsonObject.getString("errmsg"));
				return null;
			}
		}
		
		return userInfo;
		
	}

	public static QRResp getTicket(BaseQRReq qr,
			AccessToken at) {
		QRResp resp = new QRResp();
		String url = qr_code_url.replace("TOKEN", at.getAccess_token());
		String qrStr = JSON.toJSONString(qr);
		JSONObject jo = httpRequest(url, "POST", qrStr);
		if(jo != null){
			try {
				resp.setExpire_seconds(jo.getLong("expire_seconds"));
				resp.setTicket(jo.getString("ticket"));
				resp.setUrl(jo.getString("url"));
			} catch (Exception e) {
				log.error("获取二维码ticket失败: errcode:{},errmsg:{}",jo.getString("errcode"),jo.getString("errmsg"));
				return null;
			}
		}
		log.error("获取二维码ticket返回：\n expire_seconds:{},\n ticket:{},\n url:{}\n",jo.getLong("expire_seconds"),jo.getString("ticket"),jo.getString("url"));
		return resp;
	}
	
}
