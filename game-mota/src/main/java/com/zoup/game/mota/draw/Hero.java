package com.zoup.game.mota.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.zoup.game.mota.bean.HeroInfo;
import com.zoup.game.mota.data.GameConfig;

/**
 * Created by zoup on 2018/11/26
 * E-Mail：2479008771@qq.com
 */
public class Hero {
    private HeroInfo heroInfo;
    private Paint paint;
    public Bitmap[][] NPCFrame = new Bitmap[4][4];
    private int gridSize = GameConfig.GRID_SIZE;
    private int leftMargin = GameConfig.LEFT_MARGIN;
    private int topMargin = GameConfig.TOP_MARGIN;

    public Hero() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public void draw(Canvas canvas) {
        RectF rectF = new RectF(leftMargin + heroInfo.getLeft() * gridSize,
                topMargin + heroInfo.getTop() * gridSize, leftMargin + (heroInfo.getLeft() + 1) * gridSize,
                topMargin + (heroInfo.getTop() + 1) * gridSize);
        canvas.drawBitmap(NPCFrame[0][0],null,rectF,paint);
    }
}
