package com.mygdx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author WangW
 * @date 2021/02/25 14:00
 * @description
 */
public class Drop extends Game {

    public SpriteBatch batch;
    public BitmapFont font;

    /**
     * 创建应用程序时调用一次的方法。
     */
    @Override
    public void create() {
        batch = new SpriteBatch();

        font = new BitmapFont();
        this.setScreen(new MainMenuScreen(this));
    }

    /**
     * 每当执行渲染时，应用程序的游戏循环调用的方法。游戏逻辑更新通常也用这种方法执行。
     */
    @Override
    public void render() {
        //Java堆的内存消耗字节数
        long javaHeap = Gdx.app.getJavaHeap();
        //本机堆的内存消耗字节数
        long nativeHeap = Gdx.app.getNativeHeap();
        super.render();
    }

    /**
     * 在应用程序被销毁时调用。在此之前先调用pause()。
     */
    @Override
    public void dispose() {
        super.dispose();
    }


    /**
     * 在Android上，当按下主屏幕按钮或收到来电时，将调用此方法。在桌面上，这dispose()在退出应用程序之前被调用。
     * 保存游戏状态的好地方。
     */
    @Override
    public void pause() {
        super.pause();
    }

    /**
     * 当应用程序从暂停状态恢复时，仅在Android上调用此方法。
     */
    @Override
    public void resume() {
        super.resume();
    }

    /**
     * 每次调整游戏屏幕的大小并且游戏不处于暂停状态时，都会调用此方法。在create()方法之后也被调用一次。
     * 参数是屏幕已调整为像素的新的宽度和高度。
     */
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

}
