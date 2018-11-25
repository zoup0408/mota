package com.zoup.game.mota.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.zoup.game.mota.data.GameConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoup on 2018/11/24
 * E-Mail：2479008771@qq.com
 */
public abstract class Element {
    protected int floor = 0;
    protected int i;
    protected int j;
    protected int typeIndex;
    public Bitmap[] NPCFrame = new Bitmap[4];
    protected int bitmapIndex = 0;
    protected int times = 0;
    protected Paint paint = new Paint();
    public static List<Element> npcs = new ArrayList<>();
    public static List<Element> tempNpcs = new ArrayList<>();
    protected boolean isDead = false;
    protected boolean isOver = false;
    protected int gridSize = GameConfig.GRID_SIZE;
    protected int leftMargin = GameConfig.LEFT_MARGIN;
    protected int topMargin = GameConfig.TOP_MARGIN;

    protected Element() {
        paint.setAntiAlias(true);
        npcs.add(this);
    }

    public abstract void draw(Canvas canvas);

    protected void setAnimation() {
        if (!isDead) {
            times++;
            if (times == 5) {
                bitmapIndex++;
                times = 0;
                if (bitmapIndex == 4) {
                    bitmapIndex = 0;
                }
            }
        }
    }

    protected void over() {
        isDead = true;
        Element.tempNpcs.add(this);
    }
}
