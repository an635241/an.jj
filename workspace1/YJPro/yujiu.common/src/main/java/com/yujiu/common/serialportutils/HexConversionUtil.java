package com.yujiu.common.serialportutils;

import java.math.BigInteger;

public class HexConversionUtil {
	//十进制转十六进制
	public static String  tenToSixteen(int data){
		return Integer.toHexString(data);
	}
	//十六进制转十进制(0xAA)
	public static int  sixteenToTen(String data){
		return Integer.parseInt(data,16);
	}
	//十进制转二进制
	public static String tenToTwo(int data){
		return Integer.toBinaryString(data);
	}
	//二进制转十进制
	public static int twoToTen(String data){
		BigInteger srcb= new BigInteger(data,2);
		return srcb.intValue();
	}
	//十六进制转二进制
	public static String sixteenToTwo(String data){
		return Integer.toBinaryString(Integer.parseInt(data,16));
	}
	//二进制转十六进制
	public static String twoToSixteen(String data){
		BigInteger srcb= new BigInteger(data,2);
		return Integer.toHexString(Integer.parseInt(srcb.toString()));
	}
	//字节数组转 16进制字符串
	public static String BinaryToHexString(byte[] bytes){
        String hexStr =  "0123456789ABCDEF";
        String result = "";  
        String hex = "";  
        for(int i=0;i<bytes.length;i++){  
           //字节高4位  
           hex = String.valueOf(hexStr.charAt((bytes[i]&0xF0)>>4));  
           //字节低4位  
           hex += String.valueOf(hexStr.charAt(bytes[i]&0x0F));  
           result +=hex+" ";  //这里可以去掉空格，或者添加0x标识符。
         }  
         return result;  
    }
	//16进制字符串转 字节数组
	public static byte[] HexStrToBytes(String str){
        //如果字符串长度不为偶数，则追加0
        if(str.length() % 2 !=0){
            str = "0"+str;
        }
        
        byte[] b = new byte[str.length() / 2];
        byte c1, c2;
        for (int y = 0, x = 0; x < str.length(); ++y, ++x)
        {
            c1 = (byte)str.charAt(x);
            if (c1 > 0x60) c1 -= 0x57;
            else if (c1 > 0x40) c1 -= 0x37;
            else c1 -= 0x30;
            c2 = (byte)str.charAt(++x);
            if (c2 > 0x60) c2 -= 0x57;
            else if (c2 > 0x40) c2 -= 0x37;
            else c2 -= 0x30;
            b[y] = (byte)((c1 << 4) + c2);
        }
        return b;
    }
	//十六进制字符转byte(data = "9D")
	public static byte sixteenTobyte(String data){
		return Byte.parseByte(data, 16);
	}

}
