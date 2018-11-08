package com.czf.weixin.service;

import com.alibaba.fastjson.JSONObject;
import com.czf.weixin.message.qrcode.BaseQRReq;
import com.czf.weixin.message.qrcode.QRResp;
import com.czf.weixin.message.qrcode.QRScene;
import com.czf.weixin.message.qrcode.TempQRReq;
import com.czf.weixin.message.token.AccessToken;
import com.czf.weixin.util.WeiXinUtil;

/**
 * 微信二维码生成管理类
 * @author FENGZHI
 * @date 2016年10月5日
 */
public class QRCodeManager {

	public QRCodeManager() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		AccessToken at = WeiXinUtil.getAccessToken();
		
		QRResp resp = WeiXinUtil.getTicket(getBaseQRCodeByCodeId(),at);

		QRResp resp1 = WeiXinUtil.getTicket(getBaseQRCodeByCodeStr(),at);
		
		QRResp resp2 = WeiXinUtil.getTicket(getTempQRCode(),at);
	}
	
	public static BaseQRReq getBaseQRCodeByCodeId(){
		BaseQRReq baseQRMsg = new BaseQRReq();
		QRScene scene = new QRScene();
		scene.setSceneId("111");
		baseQRMsg.setAction_name("QR_LIMIT_SCENE");
		baseQRMsg.setAction_info(scene);
		
		return baseQRMsg;
	}
	
	public static BaseQRReq getBaseQRCodeByCodeStr(){
		BaseQRReq baseQRMsg = new BaseQRReq();
		QRScene scene = new QRScene();
		scene.setSceneStr("222");
		baseQRMsg.setAction_name("QR_LIMIT_STR_SCENE");
		baseQRMsg.setAction_info(scene);
		
		return baseQRMsg;
	}
	
	public static TempQRReq getTempQRCode(){
		TempQRReq tempQRMsg = new TempQRReq();
		QRScene scene = new QRScene();
		scene.setSceneId("333");
		tempQRMsg.setExpire_seconds(604800L);
		tempQRMsg.setAction_name("QR_SCENE");
		tempQRMsg.setAction_info(scene);
		
		return tempQRMsg;
	}

}
