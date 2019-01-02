package com.huanyu.huanyuofficial.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
public class Base64ImageUtil
{  

    //图片转化成base64字符串  
    public static String GetImageStr()  
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        String imgFile = "D:\\tupian\\a.jpg";//待处理的图片  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }  
      
    //base64字符串转化成图片  
    public static String GenerateImage(String imgStr,String imageName)
    {   //对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            return "";
        imgStr = imgStr.split(",")[1];
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成jpeg图片  D:\\tupian\\new.jpg
            String imageDir = System.getProperty("user.dir")+File.separator+"image";
            System.out.println("图片路径:"+imageDir);
            String imgFilePath =  imageDir +File.separator+imageName;//新生成的图片

            File dir = new File(imageDir);
            if (!dir.exists()){
                dir.mkdirs();
            }

            File file = new File(imgFilePath);
            if (file.exists()){
                file.delete();
            }else {
                file.createNewFile();
            }
            OutputStream out = new FileOutputStream(imgFilePath);      
            out.write(b);  
            out.flush();  
            out.close();  
            return imgFilePath;
        }   
        catch (Exception e)   
        {  
            return "";
        }  
    }  
}