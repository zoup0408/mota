package com.zoup.game.mota.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

import com.zoup.game.mota.utils.BitmapUtils;

public class Stairs extends Element {
    private Bitmap bitmap;

    public Stairs(int i, int j, int typeIndex, int floor) {
        this.i = i;
        this.j = j;
        this.typeIndex = typeIndex;
        this.floor = floor;
        bitmap = BitmapUtils.getStairs(typeIndex);
    }

    @Override
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(leftMargin + j * gridSize, topMargin + i * gridSize,
                leftMargin + (j + 1) * gridSize, topMargin + (i + 1) * gridSize);
        canvas.drawBitmap(bitmap, null, rectF, paint);
    }

}
