package com.zoup.game.mota.draw;

/**
 * Created by zoup on 2018/11/24
 * E-Mail：2479008771@qq.com
 */

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

import com.zoup.game.mota.utils.BitmapUtils;

public class Map extends Element {
    private Bitmap[][] mapBitmaps = new Bitmap[2][3];

    public Map(int i, int j, int typeIndex, int floor) {
        this.i = i;
        this.j = j;
        this.typeIndex = typeIndex;
        this.floor = floor;
        setMapInfo();
    }

    public void draw(Canvas canvas) {
//        setAnimation();
        RectF rectF = new RectF(leftMargin + j * gridSize, topMargin + i * gridSize, leftMargin + (j + 1) * gridSize, topMargin + (i + 1) * gridSize);
        Bitmap target;
        if (typeIndex == 1) {
            target = mapBitmaps[0][1];
        } else if (typeIndex == 2) {
            target = mapBitmaps[0][0];
        } else if (typeIndex == 3) {
            target = mapBitmaps[1][0];
        } else if (typeIndex == 4) {
            target = mapBitmaps[1][1];
        } else {
            target = mapBitmaps[1][2];
        }
        canvas.drawBitmap(target, null, rectF, paint);
    }

    private void setMapInfo() {
        mapBitmaps = BitmapUtils.getMapBitmaps("map.png");
    }

}
