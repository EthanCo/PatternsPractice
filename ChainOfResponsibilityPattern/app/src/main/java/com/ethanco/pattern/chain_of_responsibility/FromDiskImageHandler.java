package com.ethanco.pattern.chain_of_responsibility;

import android.graphics.Bitmap;

import com.ethanco.pattern.ImageHelper;

/**
 * Created by EthanCo on 2016/1/16.
 */
public class FromDiskImageHandler extends ImageHandler {
    @Override
    public Bitmap loadBitmap() {
        return ImageHelper.loadBitmapFromDisk();
    }
}
