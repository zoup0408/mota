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

//    private void setProperty() {
//        switch (typeIndex) {
//            case IndexConst.ENEMY1:
//                this.hp = 100;
//                this.attack = 15;
//                this.defence = 5;
//                this.exp = 4;
//                this.gold = 2;
//                return;
//            case IndexConst.ENEMY2:
//                this.hp = 120;
//                this.attack = 20;
//                this.defence = 5;
//                this.exp = 4;
//                this.gold = 3;
//                return;
//            case IndexConst.ENEMY3:
//                this.hp = 150;
//                this.attack = 25;
//                this.defence = 10;
//                this.exp = 5;
//                this.gold = 4;
//                return;
//            case IndexConst.ENEMY4:
//                this.hp = 360;
//                this.attack = 70;
//                this.defence = 40;
//                this.exp = 10;
//                this.gold = 9;
//                return;
//            case IndexConst.ENEMY5:
//                this.hp = 195;
//                this.attack = 30;
//                this.defence = 15;
//                this.exp = 6;
//                this.gold = 5;
//                return;
//            case IndexConst.ENEMY6:
//                this.hp = 320;
//                this.attack = 55;
//                this.defence = 35;
//                this.exp = 9;
//                this.gold = 8;
//                return;
//            case IndexConst.ENEMY7:
//                this.hp = 550;
//                this.attack = 99;
//                this.defence = 65;
//                this.exp = 13;
//                this.gold = 11;
//                return;
//            case IndexConst.ENEMY8:
//                this.hp = 5000;
//                this.attack = 999;
//                this.defence = 800;
//                this.exp = 99;
//                this.gold = 99;
//                return;
//            case IndexConst.ENEMY9:
//                this.hp = 220;
//                this.attack = 35;
//                this.defence = 20;
//                this.exp = 7;
//                this.gold = 6;
//                return;
//            case IndexConst.ENEMY10:
//                this.hp = 240;
//                this.attack = 45;
//                this.defence = 25;
//                this.exp = 8;
//                this.gold = 7;
//                return;
//            case IndexConst.ENEMY11:
//                this.hp = 600;
//                this.attack = 120;
//                this.defence = 75;
//                this.exp = 14;
//                this.gold = 12;
//                return;
//            case IndexConst.ENEMY12:
//                this.hp = 2400;
//                this.attack = 470;
//                this.defence = 455;
//                this.exp = 24;
//                this.gold = 22;
//                return;
//            case IndexConst.ENEMY13:
//                this.hp = 500;
//                this.attack = 90;
//                this.defence = 55;
//                this.exp = 12;
//                this.gold = 11;
//                return;
//            case IndexConst.ENEMY14:
//                this.hp = 650;
//                this.attack = 130;
//                this.defence = 90;
//                this.exp = 15;
//                this.gold = 14;
//                return;
//            case IndexConst.ENEMY15:
//                this.hp = 700;
//                this.attack = 135;
//                this.defence = 100;
//                this.exp = 16;
//                this.gold = 15;
//                return;
//            case IndexConst.ENEMY16:
//                this.hp = 1700;
//                this.attack = 470;
//                this.defence = 440;
//                this.exp = 22;
//                this.gold = 20;
//                return;
//            case IndexConst.ENEMY17:
//                this.hp = 450;
//                this.attack = 85;
//                this.defence = 50;
//                this.exp = 11;
//                this.gold = 10;
//                return;
//            case IndexConst.ENEMY18:
//                this.hp = 900;
//                this.attack = 160;
//                this.defence = 135;
//                this.exp = 18;
//                this.gold = 18;
//                return;
//            case IndexConst.ENEMY19:
//                this.hp = 800;
//                this.attack = 145;
//                this.defence = 115;
//                this.exp = 17;
//                this.gold = 16;
//                return;
//            case IndexConst.ENEMY20:
//                this.hp = 1000;
//                this.attack = 200;
//                this.defence = 160;
//                this.exp = 19;
//                this.gold = 17;
//                return;
//            case IndexConst.ENEMY21:
//                this.hp = 1100;
//                this.attack = 245;
//                this.defence = 200;
//                this.exp = 20;
//                this.gold = 18;
//                return;
//            case IndexConst.ENEMY22:
//                this.hp = 1300;
//                this.attack = 270;
//                this.defence = 230;
//                this.exp = 20;
//                this.gold = 19;
//                return;
//            case IndexConst.ENEMY23:
//                this.hp = 1500;
//                this.attack = 380;
//                this.defence = 350;
//                this.exp = 21;
//                this.gold = 19;
//                return;
//            case IndexConst.ENEMY24:
//                this.hp = 2000;
//                this.attack = 475;
//                this.defence = 450;
//                this.exp = 23;
//                this.gold = 21;
//                return;
//            case IndexConst.ENEMY25:
//                this.hp = 2800;
//                this.attack = 540;
//                this.defence = 530;
//                this.exp = 24;
//                this.gold = 22;
//                return;
//            case IndexConst.ENEMY26:
//                this.hp = 3200;
//                this.attack = 550;
//                this.defence = 540;
//                this.exp = 25;
//                this.gold = 23;
//                return;
//            case IndexConst.ENEMY27:
//                this.hp = 4500;
//                this.attack = 750;
//                this.defence = 720;
//                this.exp = 99;
//                this.gold = 99;
//                return;
//            case IndexConst.ENEMY28:
//                this.hp = 4000;
//                this.attack = 580;
//                this.defence = 575;
//                this.exp = 25;
//                this.gold = 24;
//                return;
//            default:
//                return;
//        }
//    }
}
