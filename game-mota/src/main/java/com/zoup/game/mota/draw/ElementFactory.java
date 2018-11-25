package com.zoup.game.mota.draw;

import com.zoup.game.mota.data.IndexConst;
import com.zoup.game.mota.data.MapData;

/**
 * Created by zoup on 2018/11/25
 * E-Mail：2479008771@qq.com
 */
public class ElementFactory {
    public static void setElement(int floor) {
        Element.npcs.clear();
        for (int i = 0; i < MapData.rows; i++) {
            for (int j = 0; j < MapData.columns; j++) {
                if (MapData.floorMap[i][j] >= IndexConst.ENEMY1 && MapData.floorMap[i][j] <= IndexConst.ENEMY28) {
                    new Enemy(i, j, MapData.floorMap[i][j], floor);
                }
            }
        }
    }
}
