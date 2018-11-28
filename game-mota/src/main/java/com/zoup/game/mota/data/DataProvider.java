package com.zoup.game.mota.data;

import com.zoup.game.mota.bean.EnemyInfo;
import com.zoup.game.mota.bean.HeroInfo;
import com.zoup.game.mota.bean.MapInfo;
import com.zoup.game.mota.draw.Hero;

import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zoup on 2018/11/24
 * E-Mail：2479008771@qq.com
 */
public class DataProvider {
    public static void initGameData() {
        initMapData();
        initHeroData();
    }

    /**
     * 初始化地图数据
     */
    private static void initMapData() {
        if (LitePal.count(MapInfo.class) == 0) {
            List<MapInfo> mapInfoList = new ArrayList<>();
            for (int i = 0; i < MapData.mapArray.length; i++) {
                MapInfo mapInfo = new MapInfo();
                mapInfo.setFloor(i + 1);
                mapInfo.setData(getJsonFloor(i + 1).toString());
                mapInfoList.add(mapInfo);
            }
            LitePal.saveAll(mapInfoList);
        }
    }

    /**
     * 初始化英雄数据
     */

    private static void initHeroData() {
        if (LitePal.count(HeroInfo.class) == 0) {
            LitePal.deleteAll(HeroInfo.class);
            HeroInfo heroInfo = HeroInfo.builder()
                    .hero_id(IndexConst.HEROID)
                    .attack(15)
                    .defence(10)
                    .hp(1000)
                    .yellow_key(0)
                    .blue_key(0)
                    .red_key(0)
                    .exp(0)
                    .gold(0)
                    .cur_floor(1)
                    .max_floor(MapData.mapArray.length)
                    .is_fly(false)
                    .is_search(false)
                    .create_time(new Date())
                    .build();
            heroInfo.save();
        }
    }

    private static JSONObject getJsonFloor(int floor) {
        JSONObject json = new JSONObject();
        int[][] map = MapData.mapArray[floor - 1];
        if (map.length == 0) {
            return null;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                try {
                    json.put(String.valueOf(i * map[i].length + j), String.valueOf(map[i][j]));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }

    public static void loadMap(int floor) {
        List<MapInfo> mapInfoList = LitePal.where("floor=?", String.valueOf(floor)).find(MapInfo.class);
        if (mapInfoList == null || mapInfoList.size() == 0) {
            return;
        }
        MapInfo mapInfo = mapInfoList.get(0);
        JSONObject json = null;
        try {
            json = new JSONObject(mapInfo.getData());
            for (int i = 0; i < MapData.rows; i++) {
                for (int j = 0; j < MapData.columns; j++) {
//                    Log.i(String.valueOf(i * 11 + j), json.getInt(String.valueOf(i * 10 + j)) + "");
                    MapData.floorMap[i][j] = json.getInt(String.valueOf(i * MapData.columns + j));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void loadHero() {
        List<HeroInfo> heroInfoList = LitePal.where("hero_id=?", String.valueOf(IndexConst.HEROID)).find(HeroInfo.class);
        if (heroInfoList != null && heroInfoList.size() > 0) {
            HeroData.heroInstance = heroInfoList.get(0);
        }
    }

    public static void initHeroPos(int floor) {
        int[] posInfo = HeroData.heroInitPos[floor - 1];
        HeroData.heroInstance.setLeft(posInfo[0] - 1);
        HeroData.heroInstance.setTop(posInfo[1] - 1);
        HeroData.heroInstance.setDirection(posInfo[2]);
    }

}
