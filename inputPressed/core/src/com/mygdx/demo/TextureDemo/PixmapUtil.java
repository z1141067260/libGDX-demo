package com.mygdx.demo.TextureDemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author WangW
 * @date 2021/02/26 17:57
 * @description
 */
public class PixmapUtil {

    public static void getDemo(Pixmap pixmap, Texture texture2){
// 根据给定的图片创建一个 Pixmap 实例，创建后 图片“贴”在 pixmap 上， pixmap 宽高为图片的宽高
        pixmap = new Pixmap(Gdx.files.internal("texture/player.png"));

        // 设置 pixmap 绘图颜色
        pixmap.setColor(1, 1, 1, 1);
        // 在 Pixmap 的 (128, 128) 坐标位置填充一个半径为 64 的圆
        pixmap.fillCircle(128, 128, 64);

        // 设置绘图颜色为红色
        pixmap.setColor(1, 0, 0, 1);
        // 画一个空心圆
        pixmap.drawCircle(64, 64, 32);

        // 设置绘图颜色为绿色
        pixmap.setColor(Color.GREEN);
        // 画一条线段, 线段两点为 (0, 0) 到 (256, 128)
        pixmap.drawLine(0, 0, 256, 128);

        // 设置绘图颜色为蓝色
        pixmap.setColor(Color.BLUE);
        // 画一个矩形, 矩形左上角坐标(128, 128), 宽高均为64
        pixmap.drawRectangle(128, 128, 64, 64);

        // 设置绘图颜色为黄色
        pixmap.setColor(Color.YELLOW);
        // 填充一个三角形, 三点(0, 256), (0, 128), (128, 128)
        pixmap.fillTriangle(0, 256, 0, 128, 128, 128);

        // 需要将 pixmap 绘制到屏幕上，需要将 pixmap 加载为纹理
        texture2 = new Texture(pixmap);
        // pixmap 已不再需要用到, 释放资源
        pixmap.dispose();
    }
}
