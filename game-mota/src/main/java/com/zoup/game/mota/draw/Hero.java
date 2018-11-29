package com.zoup.game.mota.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

import com.zoup.game.mota.bean.Direction;
import com.zoup.game.mota.bean.MoveEvent;
import com.zoup.game.mota.data.GameConfig;
import com.zoup.game.mota.data.HeroData;
import com.zoup.game.mota.data.IndexConst;
import com.zoup.game.mota.data.MapData;
import com.zoup.game.mota.rx.RxBus;
import com.zoup.game.mota.rx.RxDisposables;
import com.zoup.game.mota.ui.GameView;
import com.zoup.game.mota.utils.BitmapUtils;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by zoup on 2018/11/26
 * element-Mail：2479008771@qq.com
 */
public class Hero {
    private Paint paint;
    public Bitmap[][] NPCFrame;
    private int gridSize = GameConfig.GRID_SIZE;
    private int leftMargin = GameConfig.LEFT_MARGIN;
    private int topMargin = GameConfig.TOP_MARGIN;
    private int times = 0;
    private int bitmapIndex = 0;
    private Disposable disposable;
    private String infoStr;
    private boolean isItem = false;
    private boolean isDialog = false;
    private boolean isStore = false;
    private int currentX;
    private int currentY;
    private int lastX;
    private int lastY;
    private int curDirection;
    private int lastDirection;
    private float distance = 0.0f;
    private float distanceSum = 0.0f;
    private boolean isMove = false;
    private int index = 0;
    private int speed = 1;

    public Hero() {
        paint = new Paint();
        paint.setAntiAlias(true);
        NPCFrame = BitmapUtils.getHeroBitmaps();
        addListeners();
    }

    public void draw(Canvas canvas) {
        currentX = HeroData.heroInstance.getLeft();
        currentY = HeroData.heroInstance.getTop();
        RectF rectF = new RectF(leftMargin + currentX * gridSize,
                topMargin + currentY * gridSize, leftMargin + (currentX + 1) * gridSize,
                topMargin + (currentY + 1) * gridSize);
        canvas.drawBitmap(NPCFrame[HeroData.heroInstance.getDirection()][index], null, rectF, paint);
        lastDirection = curDirection;
        lastX = currentX;
        lastY = currentY;
    }

    private void setAnimation() {
        times++;
        if (times == 5) {
            bitmapIndex++;
            times = 0;
            if (bitmapIndex == 4) {
                bitmapIndex = 0;
            }
        }
    }

    public void addListeners() {
        disposable = RxBus.getInstance().toObservableSticky(MoveEvent.class).subscribe(new Consumer<MoveEvent>() {
            @Override
            public void accept(MoveEvent moveEvent) {
                switch (moveEvent.getAction()) {
                    case Direction.ACTION_UP:
                        lastY--;
                        break;
                    case Direction.ACTION_DOWN:
                        lastY++;
                        break;
                    case Direction.ACTION_LEFT:
                        lastX--;
                        break;
                    case Direction.ACTION_RIGHT:
                        lastX++;
                        break;
                }
                for (Element element : Element.npcs) {
                    if (element.i == lastX && element.j == lastY) {
                        execEvent(element);
                    }
                }
                move(moveEvent.getAction());
            }
        });
        RxDisposables.add(disposable);
    }

    public void execEvent(Element element) {
        if (element.typeIndex >= IndexConst.DOOR1 && element.typeIndex <= IndexConst.DOOR4) {
            openDoor(element);
            return;
        } else if (element.typeIndex >= IndexConst.YELLOWKEY && element.typeIndex <= IndexConst.GOLD200) {
            getItem(element);
            return;
        } else if (element.typeIndex == IndexConst.STAIRUP) {
            GameView.status = 1;
            return;
        } else if (element.typeIndex == IndexConst.STAIRDOWN) {
            GameView.status = -1;
            return;
        } else if (element.typeIndex >= IndexConst.ENEMY1 && element.typeIndex <= IndexConst.ENEMY28) {
            battle(element);
            return;
        } else if (element.typeIndex >= IndexConst.NPC1 && element.typeIndex <= IndexConst.NPC4) {
            npc(element);
            return;
        }
    }

    private void openDoor(Element element) {
        switch (element.typeIndex) {
            case IndexConst.DOOR1:
                if (HeroData.heroInstance.yellow_key <= 0) {
                    infoStr = "没有钥匙,打不开!";
                    break;
                }
                if (!element.isDead) {
                    HeroData.heroInstance.yellow_key--;
                }
                element.isDead = true;
                return;
            case IndexConst.DOOR2:
                if (HeroData.heroInstance.blue_key <= 0) {
                    infoStr = "没有钥匙,打不开!";
                    break;
                }
                if (!element.isDead) {
                    HeroData.heroInstance.blue_key--;
                }
                element.isDead = true;
                return;
            case IndexConst.DOOR3:
                if (HeroData.heroInstance.red_key <= 0) {
                    infoStr = "没有钥匙,打不开!";
                    break;
                }
                if (!element.isDead) {
                    HeroData.heroInstance.red_key--;
                }
                element.isDead = true;
                return;
            case IndexConst.DOOR4:
                infoStr = "该门无法开启!";
                break;
        }
        postHeroInfo();
//        if (!element.isDead) {
//            isItem = true;
//            isDialog = true;
//        }
    }

    private void getItem(Element element) {
        switch (element.typeIndex) {
            case IndexConst.YELLOWKEY:
                HeroData.heroInstance.yellow_key++;
                element.over();
                infoStr = "获得黄钥匙";
                break;
            case IndexConst.BLUEKEY:
                HeroData.heroInstance.blue_key++;
                element.over();
                infoStr = "获得蓝钥匙";
                break;
            case IndexConst.REDKEY:
                HeroData.heroInstance.red_key++;
                element.over();
                infoStr = "获得红钥匙";
                break;
            case IndexConst.ATTACT:
                HeroData.heroInstance.attack += 3;
                element.over();
                infoStr = "获得攻击之石:攻击力+3";
                break;
            case IndexConst.DEFENCE:
                HeroData.heroInstance.defence += 3;
                element.over();
                infoStr = "获得防御之石:防御力+3";
                break;
            case IndexConst.HP200:
                HeroData.heroInstance.hp += 200;
                element.over();
                infoStr = "获得小血瓶:生命值增加200";
                break;
            case IndexConst.HP500:
                HeroData.heroInstance.hp += 500;
                element.over();
                infoStr = "获得大血瓶:生命值增加500";
                break;
            case IndexConst.HP1000:
                HeroData.heroInstance.hp += 1000;
                element.over();
                infoStr = "获得神之药水:生命值增加1000";
                break;
            case IndexConst.HP2000:
                HeroData.heroInstance.hp += 2000;
                element.over();
                infoStr = "获得圣之药水:生命值增加2000";
                break;
            case IndexConst.SWORD15:
                HeroData.heroInstance.attack += 15;
                element.over();
                infoStr = "获得铁剑,攻击力增加15";
                break;
            case IndexConst.SWORD30:
                HeroData.heroInstance.attack += 30;
                element.over();
                infoStr = "获得刚剑,攻击力增加30";
                break;
            case IndexConst.SWORD45:
                HeroData.heroInstance.attack += 45;
                element.over();
                infoStr = "获得青铜剑,攻击力增加45";
                break;
            case IndexConst.SWORD60:
                HeroData.heroInstance.attack += 60;
                element.over();
                infoStr = "获得玉石剑,攻击力增加60";
                break;
            case IndexConst.SWORD120:
                HeroData.heroInstance.attack += 120;
                element.over();
                infoStr = "获得玄铁剑,攻击力增加120";
                break;
            case IndexConst.SHIELD15:
                HeroData.heroInstance.defence += 15;
                element.over();
                infoStr = "获得铁盾,防御力增加15";
                break;
            case IndexConst.SHIELD30:
                HeroData.heroInstance.defence += 30;
                element.over();
                infoStr = "获得刚盾,防御力增加30";
                break;
            case IndexConst.SHIELD45:
                HeroData.heroInstance.defence += 45;
                element.over();
                infoStr = "获得青铜盾,防御力增加45";
                break;
            case IndexConst.SHIELD60:
                HeroData.heroInstance.defence += 60;
                element.over();
                infoStr = "获得玉石盾,防御力增加60";
                break;
            case IndexConst.SHIELD120:
                HeroData.heroInstance.defence += 120;
                element.over();
                infoStr = "获得玄铁盾,防御力增加120";
                break;
            case IndexConst.INFO:
                HeroData.heroInstance.is_search = true;
                element.over();
                infoStr = "获得怪物图鉴";
                break;
            case IndexConst.FLY:
                HeroData.heroInstance.is_fly = true;
                element.over();
                infoStr = "获得楼层飞行器";
                break;
            case IndexConst.GOLD200:
                HeroData.heroInstance.gold += 200;
                element.over();
                infoStr = "获得200金币";
                break;
        }
        postHeroInfo();
//        isItem = true;
//        isDialog = true;
    }

    public void battle(Element element) {
//        int heroDamage = HeroData.heroInstance.attack - ((Enemy) element).defence;
//        int enemyDamage = ((Enemy) element).attack - defence;
//        if (heroDamage <= 0) {
//            infoStr = "你攻击太低，拒绝战斗!";
//            isDialog = true;
//            isItem = false;
//            tempImage = element.frameBitmaps[0];
//        } else if (enemyDamage <= 0) {
//            exp = ((Enemy) element).exp + exp;
//            gold = ((Enemy) element).gold + gold;
//            infoStr = "   战斗胜利            经验值 + " + ((Enemy) element).exp + ", 金币 + " + ((Enemy) element).gold;
//            isDialog = true;
//            isItem = false;
//            tempImage = this.heroFrame[1][0];
//            element.over();
//        } else {
//            int heroTimes;
//            if (((Enemy) element).hp % heroDamage == 0) {
//                heroTimes = ((Enemy) element).hp / heroDamage;
//            } else {
//                heroTimes = (((Enemy) element).hp / heroDamage) + 1;
//            }
//            if (heroTimes * enemyDamage >= hp) {
//                infoStr = "你打不过我的，回去吧!";
//                isDialog = true;
//                isItem = false;
//                tempImage = element.frameBitmaps[0];
//                return;
//            }
//            hp -= heroTimes * enemyDamage;
//            exp = ((Enemy) element).exp + exp;
//            gold = ((Enemy) element).gold + gold;
//            infoStr = "   战斗胜利            经验值 + " + ((Enemy) element).exp + ", 金币 + " + ((Enemy) element).gold;
//            isDialog = true;
//            isItem = false;
//            tempImage = this.heroFrame[1][0];

//            element.over();
//        }
        element.over();
    }

    public void npc(Element element) {
        if (element.typeIndex == IndexConst.NPC4) {
            infoStr = " 你来的正是时候,这几把钥匙你收好,去塔顶消灭大魔王吧!!!";
            isDialog = true;
            isItem = false;
            HeroData.heroInstance.yellow_key += 2;
            HeroData.heroInstance.blue_key += 2;
            HeroData.heroInstance.red_key += 2;
            element.over();
        } else if (element.typeIndex == IndexConst.NPC1) {

        } else if (element.typeIndex == IndexConst.NPC3) {
            infoStr = "多谢勇士相救,我去帮你打开第一层的门!";
            isItem = false;
            isDialog = true;
            MapData.mapArray[1][3][4] = 0;
            MapData.mapArray[1][7][4] = 0;
            element.over();
        } else if (element.typeIndex == IndexConst.NPC2) {
            infoStr = "你好年轻人,送你红黄蓝钥匙各一把!祝你早日通关!";
            isItem = false;
            isDialog = true;
            HeroData.heroInstance.yellow_key += 1;
            HeroData.heroInstance.blue_key += 1;
            HeroData.heroInstance.red_key += 1;
            element.over();
        }
    }

    public void move(int direction) {
        if (!isDialog) {
            if (lastDirection != direction) {
                curDirection = direction;
                lastDirection = curDirection;
                index = 0;
                isMove = false;
            } else {
                isMove = true;
                moveOver();
            }
        }
    }

    public void moveOver() {
        int i;
        if (index == 3) {
            i = 0;
        } else {
            i = index + 1;
        }
        index = i;
        if (curDirection == 0) {
            currentY -= speed;
        }
        if (curDirection == 1) {
            currentY += speed;
        }
        if (curDirection == 2) {
            currentX -= speed;
        }
        if (curDirection == 3) {
            currentX += speed;
        }
        HeroData.heroInstance.setDirection(curDirection);
        HeroData.heroInstance.setLeft(currentX);
        HeroData.heroInstance.setTop(currentY);
    }

    private void postHeroInfo() {
        RxBus.getInstance().postSticky(HeroData.heroInstance);
    }

    public void removeListeners() {
        if (disposable != null)
            RxDisposables.remove(disposable);
    }
}
