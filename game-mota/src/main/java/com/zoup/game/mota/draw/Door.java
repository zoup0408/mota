package com.zoup.game.mota.draw;

/**
 * Created by zoup on 2018/11/24
 * E-Mail：2479008771@qq.com
 */

import android.graphics.Canvas;
import android.graphics.RectF;

import com.zoup.game.mota.data.IndexConst;
import com.zoup.game.mota.utils.BitmapUtils;

public class Door extends Element {

    public Door(int i, int j, int typeIndex, int floor) {
        this.i = i;
        this.j = j;
        this.typeIndex = typeIndex;
        this.floor = floor;
        setDoorInfo();
    }

    public void draw(Canvas canvas) {
        setAnimation();
        RectF rectF = new RectF(leftMargin + j * gridSize, topMargin + i * gridSize, leftMargin + (j + 1) * gridSize, topMargin + (i + 1) * gridSize);
        canvas.drawBitmap(NPCFrame[0], null, rectF, paint);

    }

    private void setDoorInfo() {
        switch (typeIndex) {
            case IndexConst
                    .DOOR1:
                NPCFrame = BitmapUtils.getDoorBitmaps("door.png", 1);
                break;
            case IndexConst
                    .DOOR2:
                NPCFrame = BitmapUtils.getDoorBitmaps("door.png", 2);
                break;
            case IndexConst
                    .DOOR3:
                NPCFrame = BitmapUtils.getDoorBitmaps("door.png", 3);
                break;
            case IndexConst
                    .DOOR4:
                NPCFrame = BitmapUtils.getDoorBitmaps("door.png", 4);
                break;
        }

    }

}
