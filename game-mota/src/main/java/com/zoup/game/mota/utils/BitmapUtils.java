package com.zoup.game.mota.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.zoup.game.mota.GameApplication;

import java.io.IOException;


/**
 * Created by zoup on 2018/11/25
 * E-Mail：2479008771@qq.com
 */
public class BitmapUtils {

    public static final int indexCount = 4;

    public static Bitmap[] getBitmaps(String fileName, int index) {
        Bitmap[] result = new Bitmap[indexCount];
        Bitmap originBitmap;
        try {
            originBitmap = BitmapFactory.decodeStream(GameApplication.instance.getResources().getAssets().open(fileName));
            for (int i = 0; i < indexCount; i++) {
                result[i] = Bitmap.createBitmap(originBitmap, originBitmap.getWidth() * i / 4, (index - 1) * originBitmap.getHeight() / 4, originBitmap.getWidth() / 4, originBitmap.getHeight() / 4);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
