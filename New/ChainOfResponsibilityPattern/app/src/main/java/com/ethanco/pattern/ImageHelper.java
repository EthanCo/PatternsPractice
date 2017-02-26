package com.ethanco.pattern;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;

import java.util.Random;

/**
 * Created by EthanCo on 2016/1/16.
 */
public class ImageHelper {
    public static Bitmap loadBitmapFromNet() {
        //模拟从网络加载
        SystemClock.sleep(2000);
        if (new Random().nextBoolean()) { //模拟是否能正常加载的情况
            Log.i("zhk-ImageHelper", "loadBitmapFromNet: ");
            Drawable drawable = MyApplication.getInstance().getResources().getDrawable(R.mipmap.img_from_net);
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    public static Bitmap loadBitmapFromDisk() {
        //模拟从本地存储加载
        SystemClock.sleep(200);
        if (new Random().nextBoolean()) { //模拟是否能正常加载的情况
            Log.i("zhk-ImageHelper", "loadBitmapFromDisk: ");
            Drawable drawable = MyApplication.getInstance().getResources().getDrawable(R.mipmap.img_from_disk);
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    public static Bitmap loadBitmapFromMemory() {
        //模拟从内存加载
        if (new Random().nextInt(10) > 7) { //模拟是否能正常加载的情况
            Log.i("zhk-ImageHelper", "loadBitmapFromMemory: ");
            Drawable drawable = MyApplication.getInstance().getResources().getDrawable(R.mipmap.img_from_memory);
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    //加载默认图片
    public static Bitmap loadDefaultBitmap() {
        Log.i("zhk-ImageHelper", "loadDefaultBitmap: ");
        Drawable drawable = MyApplication.getInstance().getResources().getDrawable(R.mipmap.ic_launcher);
        return ((BitmapDrawable) drawable).getBitmap();
    }
}
