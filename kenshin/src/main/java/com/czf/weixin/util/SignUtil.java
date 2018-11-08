package com.czf.weixin.util;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 请求验证工具类
 * @author FENGZHI
 * @date 2016-08-28
 */
public class SignUtil {
	//接口配置的token
	private static String token = "czfSecondMaven";

	/** 
     * 验证签名 
     *  
     * @param signature 
     * @param timestamp 
     * @param nonce 
     * @return 
     */  
	public static boolean checkSignature(String signature ,String timestamp, String nonce){
		String[] arr = new String[] {token, timestamp, nonce};
		Arrays.sort(arr);
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]);
		}
		
		MessageDigest md = null;
		String tempSignature = null;
		
		try {
			md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(sb.toString().getBytes());
			tempSignature = byteToStr(digest);
			
			System.out.println(tempSignature);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tempSignature !=null ?tempSignature.equals(signature.toUpperCase()) : false;
	}
	
	/** 
     * 将字节数组转换为十六进制字符串 
     *  
     * @param byteArray 
     * @return 
     */  
    private static String byteToStr(byte[] byteArray) {  
        String strDigest = "";  
        for (int i = 0; i < byteArray.length; i++) {  
            strDigest += byteToHexStr(byteArray[i]);  
        }  
        return strDigest;  
    }  
  
    /** 
     * 将字节转换为十六进制字符串 
     *  
     * @param mByte 
     * @return 
     */  
    private static String byteToHexStr(byte mByte) {  
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
        char[] tempArr = new char[2];  
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
        tempArr[1] = Digit[mByte & 0X0F];  
  
        String s = new String(tempArr);  
        return s;  
    }  

}
