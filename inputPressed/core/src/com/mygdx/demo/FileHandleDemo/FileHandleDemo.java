package com.mygdx.demo.FileHandleDemo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author WangW
 * @date 2021/02/26 17:01
 * @description
 */
public class FileHandleDemo extends Game {


    Texture texture;

    /**
     * 当应用被创建时调用一次。
     */
    @Override
    public void create() {
        //检验外部文件（可读写）是否能够读取
        Gdx.files.isExternalStorageAvailable();
        //检验本地文件（可读写）是否能够读取
        Gdx.files.isLocalStorageAvailable();

        //读取内部文件
        texture = new Texture(Gdx.files.internal("texture/player.png"));
        //读取本地文件
        FileHandle fileHandle = Gdx.files.local("texture/player.png");
        //读取外部文件
        fileHandle = Gdx.files.external("texture/player.png");
        //判断文件夹或文件是否存在
        boolean exists = Gdx.files.internal("texture/player.png").exists();
        //判断文件夹是否存在(推荐)
        boolean isDirectory = Gdx.files.internal("texture/").isDirectory();
        //获取该文件夹下所有的FileHandle
        FileHandle[] files = Gdx.files.internal("texture/").list();
        for(FileHandle file : files) {
            // do something interesting here
        }
        //读文件且转换成文本状态 or 字节状态
        FileHandle file = Gdx.files.internal("text/myfile.txt");
        String text = file.readString();
        byte[] bytes = file.readBytes();

        //写入字符串 or 字节
        file.writeString("My god, it's full of stars", false);
        file.writeBytes(new byte[] { 20, 3, -2, 10 }, false);


        /**
         * 键值对存储: Preferences
         * Preferences 的值支持 String，long，int，float，boolean 类型。
         *
         * 该文件存储位置
         *  Windows： %UserProfile%/.prefs/MyPreferences;
         *  Linux 和 OS X： ~/.prefs/MyPreferences;
         *  Android：应用私有目录，使用 Android 的 SharedPreferences 进行存储。
         */
        //读取该文件名，如没有则创建文件
        Preferences prefs = Gdx.app.getPreferences("MyPreferences");
        prefs.putString("name", "Donald Duck");
        String name = prefs.getString("name", "No name stored");
        prefs.putBoolean("soundOn", true);
        prefs.putInteger("highscore", 10);
        prefs.flush();
    }

    /**
     * ApplicationListener 中的游戏循环渲染方法，每时每刻都在被调用。游戏逻辑的更新通常也是在这个方法中被执行。
     */
    @Override
    public void render() {

        // 输出 debug 级别 log
        Gdx.app.debug("DEBUG", "debug message");

        // 输出 info 级别 log
        Gdx.app.log("INFO", "informative message");

        // 输出 error 级别 log
        Gdx.app.error("ERROR", "error message");
    }

    /**
     * 游戏屏幕尺寸改变并且不处于暂停状态将被调用，在 create() 方法之后也会被调用一次。
     * @param width
     * @param height
     */
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    /**
     * 当应用被销毁时调用。
     */
    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * 当游戏界面被新的一个界面覆盖时（例如按下 Home 键回到主界面时被主界面覆盖，
     * 来电时被来电界面覆盖），该方法将被调用。通常在这里保存暂停时的游戏状态。
     */
    @Override
    public void pause() {
        super.pause();
    }

    /**
     * 被其他界面覆盖后（pause 状态后），重新回到游戏界面时，该方法被调用。
     */
    @Override
    public void resume() {
        super.resume();
    }




}
