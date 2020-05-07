package liuxuan.education.patch;

import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class UpLoadPicture {
    //base64字符串转化成图片
    public static boolean GenerateImage(String imgStr,String newPath)
    {
        if (imgStr == null) //图像数据为空
            return false;
        imgStr = imgStr.replace(' ','+');
        String s = "";
        for(int i = 0;i<imgStr.length();i++){
            s += imgStr.charAt(i);
            if((i+1)%76==0)
                s += "\r\n";
        }
        System.out.println("解码中");

        //对字节数组字符串进行Base64解码并生成图片
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(s);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(newPath);
            System.out.println("解码完毕");
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
