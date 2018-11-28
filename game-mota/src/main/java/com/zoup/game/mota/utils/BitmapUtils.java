package com.zoup.game.mota.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.zoup.game.mota.GameApplication;
import com.zoup.game.mota.data.IndexConst;

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

    public static Bitmap[][] getMapBitmaps(String fileName) {
        Bitmap[][] result = new Bitmap[2][3];
        Bitmap originBitmap;
        try {
            originBitmap = BitmapFactory.decodeStream(GameApplication.instance.getResources().getAssets().open(fileName));
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    result[i][j] = Bitmap.createBitmap(originBitmap, originBitmap.getWidth() * j / 3, originBitmap.getHeight() * i / 2, originBitmap.getWidth() / 3, originBitmap.getHeight() / 2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Bitmap[] getDoorBitmaps(String fileName, int index) {
        Bitmap[] result = new Bitmap[indexCount];
        Bitmap originBitmap;
        try {
            originBitmap = BitmapFactory.decodeStream(GameApplication.instance.getResources().getAssets().open(fileName));
            for (int i = 0; i < indexCount; i++) {
                result[i] = Bitmap.createBitmap(originBitmap, originBitmap.getWidth() * (index - 1) / 4, i * originBitmap.getHeight() / 4, originBitmap.getWidth() / 4, originBitmap.getHeight() / 4);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Bitmap getStairs(int typeIndex) {
        Bitmap bitmap = null;
        try {
            if (typeIndex == IndexConst.STAIRUP)
                bitmap = BitmapFactory.decodeStream(GameApplication.instance.getResources().getAssets().open("up.png"));
            else {
                bitmap = BitmapFactory.decodeStream(GameApplication.instance.getResources().getAssets().open("down.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static Bitmap getStoneAndHPBitmap(int typeIndex) {
        Bitmap bitmap = null;
        int x = 0;
        int y = 0;
        switch (typeIndex) {
            case IndexConst.ATTACT:
                x = 0;
                y = 0;
                break;
            case IndexConst.DEFENCE:
                x = 1;
                y = 0;
                break;
            case IndexConst.HP200:
                x = 0;
                y = 1;
                break;
            case IndexConst.HP500:
                x = 1;
                y = 1;
                break;
            case IndexConst.HP1000:
                x = 0;
                y = 2;
                break;
            case IndexConst.HP2000:
                x = 1;
                y = 2;
                break;
        }
        try {
            Bitmap origin = BitmapFactory.decodeStream(GameApplication.instance.getResources()
                    .getAssets().open("item1.png"));
            bitmap = Bitmap.createBitmap(origin, x * origin.getWidth() / 2,
                    y * origin.getHeight() / 3, origin.getWidth() / 2,
                    origin.getHeight() / 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static Bitmap getSwordAndShieldBitmap(int typeIndex) {
        Bitmap bitmap = null;
        int x = 0;
        int y = 0;
        switch (typeIndex) {
            case IndexConst.SWORD15:
                x = 0;
                y = 0;
                break;
            case IndexConst.SWORD30:
                x = 1;
                y = 0;
                break;
            case IndexConst.SWORD45:
                x = 2;
                y = 0;
                break;
            case IndexConst.SWORD60:
                x = 3;
                y = 0;
                break;
            case IndexConst.SWORD120:
                x = 0;
                y = 1;
                break;
            case IndexConst.SHIELD15:
                x = 0;
                y = 2;
                break;
            case IndexConst.SHIELD30:
                x = 1;
                y = 2;
                break;
            case IndexConst.SHIELD45:
                x = 2;
                y = 2;
                break;
            case IndexConst.SHIELD60:
                x = 3;
                y = 2;
                break;
            case IndexConst.SHIELD120:
                x = 0;
                y = 3;
                break;
        }
        try {
            Bitmap origin = BitmapFactory.decodeStream(GameApplication.instance.getResources()
                    .getAssets().open("item2.png"));
            bitmap = Bitmap.createBitmap(origin, x * origin.getWidth() / 4,
                    y * origin.getHeight() / 4, origin.getWidth() / 4,
                    origin.getHeight() / 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static Bitmap getKeyAndBookBitmap(int typeIndex) {
        Bitmap bitmap = null;
        int x = 0;
        int y = 0;
        switch (typeIndex) {
            case IndexConst.YELLOWKEY:
                x = 0;
                y = 0;
                break;
            case IndexConst.BLUEKEY:
                x = 1;
                y = 0;
                break;
            case IndexConst.REDKEY:
                x = 2;
                y = 0;
                break;
            case IndexConst.INFO:
                x = 0;
                y = 1;
                break;
            case IndexConst.FLY:
                x = 2;
                y = 1;
                break;
            case IndexConst.GOLD200:
                x = 3;
                y = 1;
                break;
        }
        try {
            Bitmap origin = BitmapFactory.decodeStream(GameApplication.instance.getResources()
                    .getAssets().open("info.png"));
            bitmap = Bitmap.createBitmap(origin, x * origin.getWidth() / 4,
                    y * origin.getHeight() / 2, origin.getWidth() / 4,
                    origin.getHeight() / 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static Bitmap[][] getHeroBitmaps() {
        Bitmap[][] result = new Bitmap[4][4];
        Bitmap originBitmap;
        try {
            originBitmap = BitmapFactory.decodeStream(GameApplication.instance.getResources().getAssets().open("hero.png"));
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    result[i][j] = Bitmap.createBitmap(originBitmap, originBitmap.getWidth() * j / 4, originBitmap.getHeight() * i / 4, originBitmap.getWidth() / 4, originBitmap.getHeight() / 4);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
