package com.mygdx.demo.TextureDemo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author WangW
 * @date 2021/02/26 17:27
 * @description libGDX的基础开发库
 */
public class TextureDemo extends Game {

    /**
     * 纹理画布
     * SpriteBatch类，英文直译则为“精灵批处理”，它主要用于将纹理绘制到屏幕上
     * SpriteBatch 将对所有绘制的纹理进行批处理并经过优化后发送到 GPU。
     * 坐标原点为屏幕左下角
     */
    private SpriteBatch batch;

    /**
     * 纹理
     * 负责解码一个图片文件并加载到 GPU 内存，可以看做代表的是一张图片,
     * 需要手动调用释放资源的方法 texture.dispose() 进行资源释放。
     */
    private Texture texture;

    /**
     * 内存中的图片
     * 一个 Pixmap 代表内存中的一张图片，它支持加载现有的图片，有以像素为单位表示的宽高，并且每一个像素点有指定的颜色值。
     * Pixmap 支持点、线、圆、矩形、三角形，以及将另一 Pixmap 绘制到当前 Pixmap 等基本图形图像的绘制操作，
     * 最后 Pixmap 需要加载为 Texture （纹理）才能绘制到屏幕上。
     * Pixmap 的数据存储在本地堆内存中，一个 Pixmap 对象不再需要使用到时需要调用其 dispose() 方法释放资源的占用。
     * 坐标原点为左上角
     */
    private Pixmap pixmap;
    private Texture texture2;

    /**
     * 纹理区域
     * TextureRegion（纹理区域） 表示 Texture（纹理）的一部分矩形区域（当然也可以表示整个 Texture 区域），
     * 可以用来绘制纹理中的一部分显示在屏幕上。
     * TextureRegion 可以通过记录 Texture 中的一个 坐标起点 和 从这个起点开始截取的宽高 来表示 Texture 的一部分。
     * 坐标原点为左上角
     */
    private TextureRegion region;
    private Texture texture3;

    /**
     * 精灵
     * Sprite（精灵）继承自 TextureRegion（纹理区域），本质上可以看作是一个 TextureRegion，
     * 但它比 TextureRegion 要强大的多，封装得更完善，除了表示一张图片外，还附加拥有许多属性，
     * 例如 在屏幕中的位置/坐标（绘制起点），缩放比，旋转角度，透明度/颜色 等。
     * Sprite 更加具体地描述了游戏中的一个元素（游戏人物，道具，背景图片等），可以看做是一张图片加上绘制这张图片时附加的各种变换属性的封装。
     *
     * Sprite = Texture/TextrueRegion + 属性（坐标，缩放比，旋转角度，是否X / Y轴方向取镜像，透明度/颜色 等）
     */
    private Sprite sprite;
    private Texture texture4;

    @Override
    public void create() {

        //创建精灵，加入到纹理中
        SpriteUtil.getDemo(sprite, texture4);

        //创建纹理区域，加入到纹理中
        TextureRegionUtil.getDemo(region, texture3);

        //创建纹理+内存中的图片
        PixmapUtil.getDemo(pixmap, texture2);

        //创建纹理
        TextureUtil.getDemo(texture);

        // 创建 SpriteBatch
        batch = new SpriteBatch();

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // 绘制开始
        batch.begin();


        // 将纹理绘制到屏幕左下角
        batch.draw(texture, 0, 0);

        // 在屏幕左下角绘制纹理
        batch.draw(texture2, 400, 400);

        /*
         * 这次在屏幕左上角绘制纹理区域,
         * SpriteBatch 绘制时参考屏幕左下角为原点, Texture 左下角为绘制起点,
         * 所以让 region 刚好出现在左上角, 则 batch 绘制开始坐标为 (0, 屏幕高度 - region 高度),
         * Gdx.graphics.getHeight()表示屏幕的原始像素高度。
         */
        batch.draw(region, 0, Gdx.graphics.getHeight() - region.getRegionHeight());

        /*
         * 绘制精灵, 因为精灵自身拥有 坐标值, 缩放比, 旋转角度, 透明度/颜色 等属性,
         * 所以只需要将 SpriteBatch 传给 Sprite, 它就可以根据它表示的图片结合各种属性 将结果主动绘制到屏幕上
         */
        sprite.draw(batch);


        // 绘制结束
        batch.end();
    }

    @Override
    public void dispose() {
        //释放纹理画布
        if(batch != null){
            batch.dispose();
        }
        // 当应用退出时释放资源
        if (texture != null) {
            texture.dispose();
        }
    }
}
