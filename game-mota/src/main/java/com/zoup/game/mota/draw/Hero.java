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
 * E-Mail：2479008771@qq.com
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
//                execEvent(lastX, lastY);
                move(moveEvent.getAction());
            }
        });
        RxDisposables.add(disposable);
    }

    public void removeListeners() {
        if (disposable != null)
            RxDisposables.remove(disposable);
    }

    public void execEvent(int i, int j) {
        Log.i("position: ", "x=i" + i + ",j=" + j);
        for (Element e : Element.npcs) {
            if (e.i == i && e.j == j) {
                if (e.typeIndex >= IndexConst.DOOR1 && e.typeIndex <= IndexConst.DOOR4) {
                    openDoor(e);
                    return;
                } else if (e.typeIndex >= IndexConst.YELLOWKEY && e.typeIndex <= IndexConst.GOLD200) {
                    getItem(e);
                    return;
                } else if (e.typeIndex == IndexConst.STAIRUP) {
                    GameView.status = 1;
                    return;
                } else if (e.typeIndex == IndexConst.STAIRDOWN) {
                    GameView.status = -1;
                    return;
                } else if (e.typeIndex >= IndexConst.ENEMY1 && e.typeIndex <= IndexConst.ENEMY28) {
                    battle(e);
                    return;
                } else if (e.typeIndex >= IndexConst.NPC1 && e.typeIndex <= IndexConst.NPC4) {
                    npc(e);
                    return;
                }
            }
        }
        if (MapData.floorMap[i][j] == 6) {
            isStore = true;
        }
    }


    public void openDoor(Element e) {
//        switch (e.typeIndex) {
//            case IndexConst.DOOR1:
//                if (yellowKey <= 0) {
//                    infoStr = "没有钥匙,打不开!";
//                    break;
//                }
//                if (!e.isDead) {
//                    yellowKey--;
//                }
//                e.isDead = true;
//                return;
//            case IndexConst.DOOR2:
//                if (blueKey <= 0) {
//                    infoStr = "没有钥匙,打不开!";
//                    break;
//                }
//                if (!e.isDead) {
//                    blueKey--;
//                }
//                e.isDead = true;
//                return;
//            case IndexConst.DOOR3:
//                if (redKey <= 0) {
//                    infoStr = "没有钥匙,打不开!";
//                    break;
//                }
//                if (!e.isDead) {
//                    redKey--;
//                }
//                e.isDead = true;
//                return;
//            case IndexConst.DOOR4:
//                infoStr = "该门无法开启!";
//                break;
//        }
//        if (!e.isDead) {
//            isItem = true;
//            isDialog = true;
//        }
    }

    public void getItem(Element e) {
//        switch (e.typeIndex) {
//            case 150:
//                yellowKey++;
//                e.over();
//                infoStr = "获得黄钥匙";
//                break;
//            case IndexConst.BLUEKEY:
//                blueKey++;
//                e.over();
//                infoStr = "获得蓝钥匙";
//                break;
//            case IndexConst.REDKEY:
//                redKey++;
//                e.over();
//                infoStr = "获得红钥匙";
//                break;
//            case IndexConst.ATTACT:
//                attack += 3;
//                e.over();
//                infoStr = "获得攻击之石:攻击力+3";
//                break;
//            case IndexConst.DEFENCE:
//                defence += 3;
//                e.over();
//                infoStr = "获得防御之石:防御力+3";
//                break;
//            case IndexConst.HP200:
//                hp += 200;
//                e.over();
//                infoStr = "获得小血瓶:生命值增加200";
//                break;
//            case IndexConst.HP500:
//                hp += 500;
//                e.over();
//                infoStr = "获得大血瓶:生命值增加500";
//                break;
//            case IndexConst.HP1000:
//                hp += 1000;
//                e.over();
//                infoStr = "获得神之药水:生命值增加1000";
//                break;
//            case IndexConst.HP2000 /*158*/:
//                hp += 2000;
//                e.over();
//                infoStr = "获得圣之药水:生命值增加2000";
//                break;
//            case IndexConst.SWORD15:
//                attack += 15;
//                e.over();
//                infoStr = "获得铁剑,攻击力增加15";
//                break;
//            case IndexConst.SWORD30:
//                attack += 30;
//                e.over();
//                infoStr = "获得刚剑,攻击力增加30";
//                break;
//            case IndexConst.SWORD45:
//                attack += 45;
//                e.over();
//                infoStr = "获得青铜剑,攻击力增加45";
//                break;
//            case IndexConst.SWORD60:
//                attack += 60;
//                e.over();
//                infoStr = "获得玉石剑,攻击力增加60";
//                break;
//            case IndexConst.SWORD120:
//                attack += 120;
//                e.over();
//                infoStr = "获得玄铁剑,攻击力增加120";
//                break;
//            case IndexConst.SHIELD15:
//                defence += 15;
//                e.over();
//                infoStr = "获得铁盾,防御力增加15";
//                break;
//            case IndexConst.SHIELD30:
//                defence += 30;
//                e.over();
//                infoStr = "获得刚盾,防御力增加30";
//                break;
//            case IndexConst.SHIELD45:
//                defence += 45;
//                e.over();
//                infoStr = "获得青铜盾,防御力增加45";
//                break;
//            case IndexConst.SHIELD60:
//                defence += 60;
//                e.over();
//                infoStr = "获得玉石盾,防御力增加60";
//                break;
//            case IndexConst.SHIELD120:
//                defence += 120;
//                e.over();
//                infoStr = "获得玄铁盾,防御力增加120";
//                break;
//            case IndexConst.INFO:
//                isSearch = true;
//                e.over();
//                infoStr = "获得怪物图鉴";
//                break;
//            case IndexConst.FLY:
//                isFly = true;
//                e.over();
//                infoStr = "获得楼层飞行器";
//                break;
//            case IndexConst.GOLD200:
//                gold += 200;
//                e.over();
//                infoStr = "获得200金币";
//                break;
//        }
//        isItem = true;
//        isDialog = true;
    }

    public void battle(Element e) {
//        int heroDamage = attack - ((Enemy) e).defence;
//        int enemyDamage = ((Enemy) e).attack - defence;
//        if (heroDamage <= 0) {
//            infoStr = "你攻击太低，拒绝战斗!";
//            isDialog = true;
//            isItem = false;
//            tempImage = e.frameBitmaps[0];
//        } else if (enemyDamage <= 0) {
//            exp = ((Enemy) e).exp + exp;
//            gold = ((Enemy) e).gold + gold;
//            infoStr = "   战斗胜利            经验值 + " + ((Enemy) e).exp + ", 金币 + " + ((Enemy) e).gold;
//            isDialog = true;
//            isItem = false;
//            tempImage = this.heroFrame[1][0];
//            e.over();
//        } else {
//            int heroTimes;
//            if (((Enemy) e).hp % heroDamage == 0) {
//                heroTimes = ((Enemy) e).hp / heroDamage;
//            } else {
//                heroTimes = (((Enemy) e).hp / heroDamage) + 1;
//            }
//            if (heroTimes * enemyDamage >= hp) {
//                infoStr = "你打不过我的，回去吧!";
//                isDialog = true;
//                isItem = false;
//                tempImage = e.frameBitmaps[0];
//                return;
//            }
//            hp -= heroTimes * enemyDamage;
//            exp = ((Enemy) e).exp + exp;
//            gold = ((Enemy) e).gold + gold;
//            infoStr = "   战斗胜利            经验值 + " + ((Enemy) e).exp + ", 金币 + " + ((Enemy) e).gold;
//            isDialog = true;
//            isItem = false;
//            tempImage = this.heroFrame[1][0];
//            e.over();
//        }
    }

    public void npc(Element e) {
//        if (e.typeIndex == 53) {
//            infoStr = " 你来的正是时候,这几把钥匙你收好,去塔顶消灭大魔王吧!!!";
//            isDialog = true;
//            isItem = false;
//            tempImage = e.frameBitmaps[0];
//            yellowKey += 2;
//            blueKey += 2;
//            redKey += 2;
//            e.over();
//        } else if (e.typeIndex == 50) {
//            isExp = true;
//        } else if (e.typeIndex == 6) {
//            isStore = true;
//        } else if (e.typeIndex == 52) {
//            infoStr = "多谢勇士相救,我去帮你打开第一层的门!";
//            tempImage = e.frameBitmaps[0];
//            isItem = false;
//            isDialog = true;
//            Map.setMap(1, 4, 3);
//            Map.setMap(1, 4, 7);
//            e.over();
//        } else if (e.typeIndex == 51) {
//            infoStr = "你好年轻人,送你红黄蓝钥匙各一把!祝你早日通关!";
//            tempImage = e.frameBitmaps[0];
//            isItem = false;
//            isDialog = true;
//            yellowKey++;
//            blueKey++;
//            redKey++;
//            e.over();
//        }
    }

    public void move(int direction) {
        if (!isDialog) {
            isMove = false;
            if (lastDirection != direction) {
                if (distance == 0.0f) {
                    index = 0;
                    curDirection = direction;
                    isMove = false;
                } else {
                    curDirection = direction;
                    isMove = true;
                    moveOver();
                }
            }
            if (isMove) {
                int i;
                if (direction == 0) {
                    currentY -= speed;
                }
                if (direction == 1) {
                    currentY += speed;
                }
                if (direction == 2) {
                    currentX -= speed;
                }
                if (direction == 3) {
                    currentX += speed;
                }
                distance += speed;
                if (distance == distanceSum) {
                    distance = 0.0f;
                }
                if (index == 3) {
                    i = 0;
                } else {
                    i = index + 1;
                    index = i;
                }
                index = i;
            }
        }
    }

    public void moveOver() {
        if (distance != 0.0f) {
            int i;
            if (index == 3) {
                i = 0;
            } else {
                i = index + 1;
                index = i;
            }
            index = i;
            distance += speed;
            if (distance == distanceSum) {
                distance = 0.0f;
            }
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
        index = 0;
    }
}
