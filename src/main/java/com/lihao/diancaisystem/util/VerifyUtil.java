package com.lihao.diancaisystem.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyUtil {

    //字符集
    private static final char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    //字符数量
    private static  final  int SIZE = 4;
    //干扰线数量
    private static  final  int LINES = 5;
    //宽度
    private static  final  int WIDTH = 80;
    //高度
    private static  final  int HEIGHT = 40;
    //字体大小
    private static  final  int FOUT_SIZE = 30;

    //生成随机验证码及图片
    public static Object[] createImage(){
        StringBuffer sb = new StringBuffer();
        //创建空白图片
        BufferedImage image = new BufferedImage(WIDTH ,HEIGHT,BufferedImage.TYPE_INT_RGB);
        //获取图片笔画
        Graphics graphics = image.getGraphics();
        //设置笔画颜色
        graphics.setColor(Color.LIGHT_GRAY);
        //绘制矩形背景
        graphics.fillRect(0,0,WIDTH,HEIGHT);
        //画随机字符
        Random random = new Random();
        for(int i = 0 ; i < SIZE ; i++){
            //取随机字符索引
            int index = random.nextInt(chars.length);
            //设置随机颜色
            graphics.setColor(getRandomColor());
            //设置字体大小
            graphics.setFont(new Font(null ,Font.BOLD+Font.ITALIC , FOUT_SIZE));
            //笔画符
            graphics.drawString(chars[index]+"",i*WIDTH/SIZE ,HEIGHT*2/3);
            //记录字符
            sb.append(chars[index]);
        }
        //干扰线
        for(int i = 0; i < LINES; i++){
            graphics.setColor(getRandomColor());
            graphics.drawLine(random.nextInt(WIDTH),random.nextInt(HEIGHT),random.nextInt(WIDTH),random.nextInt(HEIGHT));
        }
        //返回验证码和图片
        return new Object[]{sb.toString(),image};
    }

    //随机取色
    public static  Color getRandomColor(){
        Random random = new Random();
        Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        return  color;
    }

}
