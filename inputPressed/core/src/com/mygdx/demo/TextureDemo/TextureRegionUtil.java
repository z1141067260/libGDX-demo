package com.mygdx.demo.TextureDemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author WangW
 * @date 2021/02/26 18:01
 * @description 纹理区域生成工具
 */
public class TextureRegionUtil {


    public static void getDemo(TextureRegion region, Texture texture3){
        // 创建纹理, badlogic.jpg 图片的宽高为 256 * 256
        texture3 = new Texture(Gdx.files.internal("badlogic.jpg"));

        // 创建纹理区域, region 表示在 texture 中 坐标 (0, 0) 为起点, 宽高均为 128 的矩形区域（即为图片 1/4 的左上角部分）
        region = new TextureRegion(texture3, 0, 0, 128, 128);

    }
}
