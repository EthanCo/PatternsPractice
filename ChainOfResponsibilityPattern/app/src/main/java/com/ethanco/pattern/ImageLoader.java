package com.ethanco.pattern;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.ethanco.pattern.chain_of_responsibility.FromDiskImageHandler;
import com.ethanco.pattern.chain_of_responsibility.FromMemoryImageHandler;
import com.ethanco.pattern.chain_of_responsibility.FromNetImageHandler;

/**
 * Created by EthanCo on 2016/1/16.
 */
public class ImageLoader {

    private static final int LOAD_BITMAP_SUCCESS = 457;
    private static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LOAD_BITMAP_SUCCESS:
                    ImageBox imageBox = (ImageBox) msg.obj;
                    if (imageBox.bitmap != null && imageBox.imageView != null) {
                        imageBox.imageView.setImageBitmap(imageBox.bitmap);
                    }
                    break;
            }
        }
    };

    private final FromMemoryImageHandler headHandler;
    private final FromDiskImageHandler diskHandler;
    private final FromNetImageHandler netHandler;

    public ImageLoader() {
        headHandler = new FromMemoryImageHandler();
        diskHandler = new FromDiskImageHandler();
        netHandler = new FromNetImageHandler();

        headHandler.setNextHandler(diskHandler);
        diskHandler.setNextHandler(netHandler);
    }

    public void display(final ImageView imageView) {
        //同步加载
//        Bitmap bitmap = ImageHelper.loadBitmapFromMemory();
//        if (bitmap != null) {
//            imageView.setImageBitmap(bitmap);
//            return;
//        }

        //异步加载
        new Thread() {
            @Override
            public void run() {
                Bitmap bitmap = headHandler.handler();
                Message msg = Message.obtain();
                msg.what = LOAD_BITMAP_SUCCESS;
                msg.obj = new ImageBox(bitmap, imageView);
                mHandler.sendMessage(msg);
            }
        }.start();
    }

    private class ImageBox {
        public ImageBox(Bitmap bitmap, ImageView imageView) {
            this.bitmap = bitmap;
            this.imageView = imageView;
        }

        Bitmap bitmap;
        ImageView imageView;
    }
}
