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
        switch (typeIndex) {
            case IndexConst
                    .NPC1:
                bitmap = BitmapUtils.getBitmaps("npc.png", 1)[0];
                break;
            case IndexConst
                    .NPC2:
                bitmap = BitmapUtils.getBitmaps("npc.png", 1)[1];
                break;
            case IndexConst
                    .NPC3:
                bitmap = BitmapUtils.getBitmaps("npc.png", 1)[2];
                break;
            case IndexConst
                    .NPC4:
                bitmap = BitmapUtils.getBitmaps("npc.png", 1)[3];
                break;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(leftMargin + j * gridSize, topMargin + i * gridSize,
                leftMargin + (j + 1) * gridSize, topMargin + (i + 1) * gridSize);
        canvas.drawBitmap(bitmap, null, rectF, paint);
    }

}
