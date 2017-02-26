package com.ethanco.pattern.chain_of_responsibility;

import android.graphics.Bitmap;

import com.ethanco.pattern.ImageHelper;

/**
 * Created by EthanCo on 2016/1/16.
 */
public abstract class ImageHandler {
    private ImageHandler nextHandler;

    public final Bitmap handler() {
        Bitmap bitmap = loadBitmap();
        if (bitmap != null) {
            //如果bitmap!=null，自己处理
            return bitmap;
        } else {
            if (nextHandler != null) {
                //让下一个Hanlder处理
                return this.nextHandler.handler();
            } else {
                //没有下一个Handler，返回默认图片
                return ImageHelper.loadDefaultBitmap();
            }
        }
    }

    public void setNextHandler(ImageHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract Bitmap loadBitmap();
}
