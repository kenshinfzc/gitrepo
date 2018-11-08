package com.czf.weixin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.czf.weixin.message.token.AccessToken;
import com.czf.weixin.message.menu.Button;
import com.czf.weixin.message.menu.CombineButton;
import com.czf.weixin.message.menu.Menu;
import com.czf.weixin.message.menu.SimpleButton;
import com.czf.weixin.util.WeiXinUtil;

/**
 * �˵������޸Ĳ˵��ṹ��Ҫ����ִ�и��ļ�
 * @author FENGZHI
 * @date 2016��8��31��
 */
public class MenuManager {  
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);  
    
    /**
     * �˵�����������
     * @param args
     */
    public static void main(String[] args) {  
        // ���ýӿڻ�ȡaccess_token  
        AccessToken at = WeiXinUtil.getAccessToken();  
        
        log.info("�˵�����{}",at.getAccess_token());
  
        if (null != at) {  
            // ���ýӿڴ����˵�  
            String result = WeiXinUtil.createMenu(getMenu(), at.getAccess_token());  
  
            // �жϲ˵��������  
            if ("0".equals(result))  
                log.info("�˵������ɹ���");  
            else  
                log.info("�˵�����ʧ�ܣ������룺" + result);  
        }  
    }  
  
    /** 
     * ��װ�˵����� 
     *  
     * @return 
     */  
    private static Menu getMenu() {  
        SimpleButton btn11 = new SimpleButton();  
        btn11.setName("����Ԥ��");  
        btn11.setType("click");  
        btn11.setKey("11");  
  
        SimpleButton btn12 = new SimpleButton();  
        btn12.setName("������ѯ");  
        btn12.setType("click");  
        btn12.setKey("12");  
  
        SimpleButton btn13 = new SimpleButton();  
        btn13.setName("�ܱ�����");  
        btn13.setType("click");  
        btn13.setKey("13");  
  
        SimpleButton btn14 = new SimpleButton();  
        btn14.setName("��ʷ�ϵĽ���");  
        btn14.setType("click");  
        btn14.setKey("14");  
  
        SimpleButton btn21 = new SimpleButton();  
        btn21.setName("�����㲥");  
        btn21.setType("click");  
        btn21.setKey("21");  
  
        SimpleButton btn22 = new SimpleButton();  
        btn22.setName("������Ϸ");  
        btn22.setType("click");  
        btn22.setKey("22");  
  
        SimpleButton btn23 = new SimpleButton();  
        btn23.setName("��Ů��̨");  
        btn23.setType("click");  
        btn23.setKey("23");  
  
        SimpleButton btn24 = new SimpleButton();  
        btn24.setName("����ʶ��");  
        btn24.setType("click");  
        btn24.setKey("24");  
  
        SimpleButton btn25 = new SimpleButton();  
        btn25.setName("�������");  
        btn25.setType("click");  
        btn25.setKey("25");  
  
        SimpleButton btn31 = new SimpleButton();  
        btn31.setName("Q��Ȧ");  
        btn31.setType("click");  
        btn31.setKey("31");  
  
        SimpleButton btn32 = new SimpleButton();  
        btn32.setName("��Ӱ���а�");  
        btn32.setType("click");  
        btn32.setKey("32");  
  
        SimpleButton btn33 = new SimpleButton();  
        btn33.setName("��ĬЦ��");  
        btn33.setType("click");  
        btn33.setKey("33");  
  
        CombineButton mainBtn1 = new CombineButton();  
        mainBtn1.setName("��������");  
        mainBtn1.setSub_button(new SimpleButton[] { btn11, btn12, btn13, btn14 });  
  
        CombineButton mainBtn2 = new CombineButton();  
        mainBtn2.setName("������վ");  
        mainBtn2.setSub_button(new SimpleButton[] { btn21, btn22, btn23, btn24, btn25 });  
  
//        CombineButton mainBtn3 = new CombineButton();  
//        mainBtn3.setName("��������");  
//        mainBtn3.setSub_button(new SimpleButton[] { btn31, btn32, btn33 });  
        
        SimpleButton sbtn = new SimpleButton();
        sbtn.setName("userinfo");
        sbtn.setType("view");
        String url = "http://1ab49a37.ngrok.io/kenshin/oauth";
        url = WeiXinUtil.getOAuth2Url(url,"snsapi_userinfo");
        sbtn.setUrl(url);
        
        SimpleButton sbtn1 = new SimpleButton();
        sbtn1.setName("base");
        sbtn1.setType("view");
        String url1 = "http://1ab49a37.ngrok.io/kenshin/oauth";
        url1 = WeiXinUtil.getOAuth2Url(url1,"snsapi_base");
        sbtn1.setUrl(url1);
        
        CombineButton mainBtn3 = new CombineButton();
        mainBtn3.setName("SB����1");
        mainBtn3.setSub_button(new SimpleButton[]{sbtn,sbtn1});
  
        /** 
         * ���ǹ��ں�xiaoqrobotĿǰ�Ĳ˵��ṹ��ÿ��һ���˵����ж����˵���<br> 
         *  
         * ��ĳ��һ���˵���û�ж����˵��������menu����ζ����أ�<br> 
         * ���磬������һ���˵���ǡ��������顱����ֱ���ǡ���ĬЦ��������ômenuӦ���������壺<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu();  
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });  
  
        return menu;  
    }  
} 
