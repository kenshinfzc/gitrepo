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
 * 菜单管理，修改菜单结构需要单独执行该文件
 * @author FENGZHI
 * @date 2016年8月31日
 */
public class MenuManager {  
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);  
    
    /**
     * 菜单管理主函数
     * @param args
     */
    public static void main(String[] args) {  
        // 调用接口获取access_token  
        AccessToken at = WeiXinUtil.getAccessToken();  
        
        log.info("菜单管理：{}",at.getAccess_token());
  
        if (null != at) {  
            // 调用接口创建菜单  
            String result = WeiXinUtil.createMenu(getMenu(), at.getAccess_token());  
  
            // 判断菜单创建结果  
            if ("0".equals(result))  
                log.info("菜单创建成功！");  
            else  
                log.info("菜单创建失败，错误码：" + result);  
        }  
    }  
  
    /** 
     * 组装菜单数据 
     *  
     * @return 
     */  
    private static Menu getMenu() {  
        SimpleButton btn11 = new SimpleButton();  
        btn11.setName("天气预报");  
        btn11.setType("click");  
        btn11.setKey("11");  
  
        SimpleButton btn12 = new SimpleButton();  
        btn12.setName("公交查询");  
        btn12.setType("click");  
        btn12.setKey("12");  
  
        SimpleButton btn13 = new SimpleButton();  
        btn13.setName("周边搜索");  
        btn13.setType("click");  
        btn13.setKey("13");  
  
        SimpleButton btn14 = new SimpleButton();  
        btn14.setName("历史上的今天");  
        btn14.setType("click");  
        btn14.setKey("14");  
  
        SimpleButton btn21 = new SimpleButton();  
        btn21.setName("歌曲点播");  
        btn21.setType("click");  
        btn21.setKey("21");  
  
        SimpleButton btn22 = new SimpleButton();  
        btn22.setName("经典游戏");  
        btn22.setType("click");  
        btn22.setKey("22");  
  
        SimpleButton btn23 = new SimpleButton();  
        btn23.setName("美女电台");  
        btn23.setType("click");  
        btn23.setKey("23");  
  
        SimpleButton btn24 = new SimpleButton();  
        btn24.setName("人脸识别");  
        btn24.setType("click");  
        btn24.setKey("24");  
  
        SimpleButton btn25 = new SimpleButton();  
        btn25.setName("聊天唠嗑");  
        btn25.setType("click");  
        btn25.setKey("25");  
  
        SimpleButton btn31 = new SimpleButton();  
        btn31.setName("Q友圈");  
        btn31.setType("click");  
        btn31.setKey("31");  
  
        SimpleButton btn32 = new SimpleButton();  
        btn32.setName("电影排行榜");  
        btn32.setType("click");  
        btn32.setKey("32");  
  
        SimpleButton btn33 = new SimpleButton();  
        btn33.setName("幽默笑话");  
        btn33.setType("click");  
        btn33.setKey("33");  
  
        CombineButton mainBtn1 = new CombineButton();  
        mainBtn1.setName("生活助手");  
        mainBtn1.setSub_button(new SimpleButton[] { btn11, btn12, btn13, btn14 });  
  
        CombineButton mainBtn2 = new CombineButton();  
        mainBtn2.setName("休闲驿站");  
        mainBtn2.setSub_button(new SimpleButton[] { btn21, btn22, btn23, btn24, btn25 });  
  
//        CombineButton mainBtn3 = new CombineButton();  
//        mainBtn3.setName("更多体验");  
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
        mainBtn3.setName("SB天堂1");
        mainBtn3.setSub_button(new SimpleButton[]{sbtn,sbtn1});
  
        /** 
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br> 
         *  
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br> 
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br> 
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 }); 
         */  
        Menu menu = new Menu();  
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });  
  
        return menu;  
    }  
} 
