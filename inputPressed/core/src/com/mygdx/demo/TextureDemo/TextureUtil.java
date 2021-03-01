package com.mygdx.demo.TextureDemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author WangW
 * @date 2021/02/26 17:55
 * @description 纹理生成工具类
 */
public class TextureUtil {

    public static void getDemo(Texture texture){
        // 加载 assets 文件夹下的 texture/player.png 文件，创建纹理
        texture = new Texture(Gdx.files.internal("texture/player.png"));
        // 获取纹理（图片）的原始像素宽高
        int width = texture.getWidth();
        int height = texture.getHeight();
    }
}
