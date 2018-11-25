package com.zoup.game.mota.draw;

/**
 * Created by zoup on 2018/11/24
 * E-Mail：2479008771@qq.com
 */

import android.graphics.Canvas;
import android.graphics.RectF;

import com.zoup.game.mota.bean.EnemyInfo;
import com.zoup.game.mota.data.EnemyData;
import com.zoup.game.mota.utils.BitmapUtils;

public class Enemy extends Element {
    private EnemyInfo enemyInfo;

    public Enemy(int i, int j, int typeIndex, int floor) {
        this.i = i;
        this.j = j;
        this.typeIndex = typeIndex;
        this.floor = floor;
        setEnemyInfo();
    }

    public void draw(Canvas canvas) {
        setAnimation();
        RectF rectF=new RectF(leftMargin+j*gridSize,topMargin+i*gridSize,leftMargin+(j+1)*gridSize,topMargin+(i+1)*gridSize);
        canvas.drawBitmap(NPCFrame[bitmapIndex],null,rectF,paint);

    }

    private void setEnemyInfo(){
        enemyInfo=EnemyData.enemyInfoMap.get(typeIndex);
        NPCFrame=BitmapUtils.getBitmaps(enemyInfo.getImage_name(),enemyInfo.getImage_index());
    }

}
