package com.zoup.game.mota.draw;

import android.graphics.Canvas;
import android.graphics.RectF;

import com.zoup.game.mota.data.IndexConst;
import com.zoup.game.mota.utils.BitmapUtils;

public class NPC extends Element {

    public NPC(int i, int j, int typeIndex, int floor) {
        this.i = i;
        this.j = j;
        this.typeIndex = typeIndex;
        this.floor = floor;
        switch (typeIndex) {
            case IndexConst
                    .NPC1:
                NPCFrame = BitmapUtils.getBitmaps("npc.png", 1);
                break;
            case IndexConst
                    .NPC2:
                NPCFrame = BitmapUtils.getBitmaps("npc.png", 2);
                break;
            case IndexConst
                    .NPC3:
                NPCFrame = BitmapUtils.getBitmaps("npc.png", 3);
                break;
            case IndexConst
                    .NPC4:
                NPCFrame = BitmapUtils.getBitmaps("npc.png", 4);
                break;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        setAnimation();
        RectF rectF = new RectF(leftMargin + j * gridSize, topMargin + i * gridSize,
                leftMargin + (j + 1) * gridSize, topMargin + (i + 1) * gridSize);
        canvas.drawBitmap(NPCFrame[bitmapIndex], null, rectF, paint);
    }

}
