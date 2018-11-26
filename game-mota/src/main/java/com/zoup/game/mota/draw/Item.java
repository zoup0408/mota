package com.zoup.game.mota.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

import com.zoup.game.mota.data.IndexConst;
import com.zoup.game.mota.utils.BitmapUtils;

public class Item extends Element {
    private Bitmap bitmap;

    public Item(int i, int j, int typeIndex, int floor) {
        this.i = i;
        this.j = j;
        this.typeIndex = typeIndex;
        this.floor = floor;
        if (typeIndex >= IndexConst.ATTACT && typeIndex <= IndexConst.HP2000) {
            bitmap = BitmapUtils.getStoneAndHPBitmap(typeIndex);
        } else if (typeIndex >= IndexConst.SWORD15 && typeIndex <= IndexConst.SHIELD120) {
            bitmap = BitmapUtils.getSwordAndShieldBitmap(typeIndex);
        } else if ((typeIndex >= IndexConst.YELLOWKEY && typeIndex <= IndexConst.REDKEY) ||
                (typeIndex >= IndexConst.INFO && typeIndex <= IndexConst.GOLD200)) {
            bitmap = BitmapUtils.getKeyAndBookBitmap(typeIndex);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(leftMargin + j * gridSize, topMargin + i * gridSize,
                leftMargin + (j + 1) * gridSize, topMargin + (i + 1) * gridSize);
        canvas.drawBitmap(bitmap, null, rectF, paint);
    }

}
