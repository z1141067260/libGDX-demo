package com.mygdx.demo.TextureDemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * @author WangW
 * @date 2021/02/26 18:06
 * @description
 */
public class SpriteUtil {

    public static void getDemo(Sprite sprite, Texture texture4){
        // 创建纹理, badlogic.jpg 图片的宽高为 256 * 256
        texture4 = new Texture(Gdx.files.internal("badlogic.jpg"));

        // 使用纹理创建精灵, 精灵宽高为该纹理的宽高
        sprite = new Sprite(texture4);

        // 设置精灵的位置（左下角绘制起点）
        sprite.setPosition(64, 128);

        // 设置 旋转 和 缩放 的 起点（参考点/旋转点/旋转中心）为图片的左下角, 默认为 Sprite（图片）宽高的一半, 即图片的中心点
        sprite.setOrigin(0, 0);

        // 设置精灵的旋转角度, 单位为度, 逆时针方向为正
        sprite.setRotation(15.0F);

        // 设置精灵的 X 和 Y 轴方向的缩放比, 均缩小为原来的 1/2
        sprite.setScale(0.5F, 0.5F);

        // 设置精灵在水平方向取镜像, 竖直方不取镜像
        sprite.flip(true, false);

    }
}
