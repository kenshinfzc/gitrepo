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
 * ΢�Žӿڹ�����
 * @author FENGZHI
 * @date 2016��8��30��
 */
public class WeiXinUtil {
	private static Logger log = LoggerFactory.getLogger(WeiXinUtil.class);
	
	//�������û�Ψһƾ֤
	private static final String appid = "wx5ca861548951f121";
	//�������û�Ψһƾ֤��Կ����appsecret 
	private static final String secret = "56e5fd99cbb85a5cf986675b6ee12e65";
	//��ȡaccess_token�Ľӿڵ�ַ��GET�� ��200����/�죩
	private static final String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//�˵�������POST�� ��100����/�죩
	private static final String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";  
	
	//OAuth2��Ȩ��ؽӿڵ�ַ
	//�û�ͬ����Ȩ����ȡcode
	private static final String auth_code_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	//ͨ��code��ȡ��ҳ��Ȩaccess_token     ��ȡcode�������������ӻ�ȡaccess_token�� 
	private static final String auth_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	//ˢ��access_token�������Ҫ��      ��ȡ�ڶ�����refresh_token�������������ӻ�ȡaccess_token�� 
	private static final String auth_refresh_token_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	//��ȡ�û���Ϣ(��scopeΪ snsapi_userinfo)   http��GET����ʹ��httpsЭ�飩
	private static final String auth_uesrinfo_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	//΢�Ŷ�ά��
	//������ά��ticket
	private static final String qr_code_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
	//ͨ��ticket��ȡ��ά��
	private static final String qr_ticket_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	
	
	/** 
     * ����https���󲢻�ȡ��� 
     *  
     * @param requestUrl �����ַ 
     * @param requestMethod ����ʽ��GET��POST�� 
     * @param outputStr �ύ������ 
     * @return JSONObject(ͨ��JSONObject.get(key)�ķ�ʽ��ȡjson���������ֵ) 
     */  
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {  
        JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();  
        try {  
            // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��  
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            // ������SSLContext�����еõ�SSLSocketFactory����  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            URL url = new URL(requestUrl);  
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
            httpUrlConn.setSSLSocketFactory(ssf);  
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            // ��������ʽ��GET/POST��  
            httpUrlConn.setRequestMethod(requestMethod);  
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            // ����������Ҫ�ύʱ  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // ע������ʽ����ֹ��������  
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.close();  
            }  
  
            // �����ص�������ת�����ַ���  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // �ͷ���Դ  
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
     * ��ȡ����ƾ�� AccessToken
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
				log.error("��ȡtokenʧ�� errcode:{} errmsg:{}", jsonObject.getString("errcode"), jsonObject.getString("errmsg"));
				return null;
			}
		}
		
		return accessToken;
	}
	
	/**
	 * �����˵�
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
	            log.error("�����˵�ʧ�� errcode:{} errmsg:{}", jsonObject.getString("errcode"), jsonObject.getString("errmsg"));  
	        } 
		}
		return result;
	}
	
	/**
	 * OAuth2��ҳ��Ȩ��ַ��װ
	 * @param url
	 * @return
	 */
	public static String getOAuth2Url(String url,String scope){
		url = auth_code_url.replace("APPID", appid).replace("REDIRECT_URI", url)
				.replace("SCOPE", scope).replace("STATE", "123");
		return url;
	}
	
	/**
	 * ��ȡ��Ȩaccess_token��OAuthAccessToken
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
				log.error("��ȡ��Ȩtokenʧ��: errcode:{},errmsg:{}",jsonObject.getString("errcode"),jsonObject.getString("errmsg"));
				return null;
			}
		}
		
		return oAuthAccessToken;
	}
	
	/**
	 * ��ȡ�û���Ϣ
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
				log.error("��ȡ�û���Ϣʧ��: errcode:{},errmsg:{}",jsonObject.getString("errcode"),jsonObject.getString("errmsg"));
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
				log.error("��ȡ��ά��ticketʧ��: errcode:{},errmsg:{}",jo.getString("errcode"),jo.getString("errmsg"));
				return null;
			}
		}
		log.error("��ȡ��ά��ticket���أ�\n expire_seconds:{},\n ticket:{},\n url:{}\n",jo.getLong("expire_seconds"),jo.getString("ticket"),jo.getString("url"));
		return resp;
	}
	
}
