package com.zoup.game.mota.data;

import com.zoup.game.mota.bean.EnemyInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zoup on 2018/11/25
 * E-Mail：2479008771@qq.com
 */
public class EnemyData {
    public static List<EnemyInfo> enemyInfoList = new ArrayList<EnemyInfo>() {
        {
            add(EnemyInfo.builder().index(IndexConst.ENEMY1).image_name("enemy01.png").image_index(1)
                    .enemyName("绿史莱姆").type(2).hp(100).attack(15)
                    .defence(5).exp(4).gold(2)
                    .build());
            add(EnemyInfo.builder().index(IndexConst.ENEMY2).image_name("enemy01.png").image_index(2)
                    .enemyName("红史莱姆").type(2).hp(120).attack(20)
                    .defence(5).exp(4).gold(3)
                    .build());
            add(EnemyInfo.builder().index(IndexConst.ENEMY3).image_name("enemy01.png").image_index(3)
                    .enemyName("大史莱姆").type(2).hp(150).attack(25)
                    .defence(10).exp(5).gold(4)
                    .build());
            add(EnemyInfo.builder().index(IndexConst.ENEMY4).image_name("enemy01.png").image_index(4)
                    .enemyName("史莱姆王").type(2).hp(360).attack(70)
                    .defence(40).exp(10).gold(9)
                    .build());
        }
    };
    public static Map<Integer, EnemyInfo> enemyInfoMap = new HashMap<Integer, EnemyInfo>() {
        {
            put(IndexConst.ENEMY1, EnemyInfo.builder().index(IndexConst.ENEMY1).image_name("enemy01.png").image_index(1)
                    .enemyName("绿史莱姆").type(2).hp(100).attack(15)
                    .defence(5).exp(4).gold(2)
                    .build());
            put(IndexConst.ENEMY2, EnemyInfo.builder().index(IndexConst.ENEMY2).image_name("enemy01.png").image_index(2)
                    .enemyName("红史莱姆").type(2).hp(120).attack(20)
                    .defence(5).exp(4).gold(3)
                    .build());
            put(IndexConst.ENEMY3, EnemyInfo.builder().index(IndexConst.ENEMY3).image_name("enemy01.png").image_index(3)
                    .enemyName("大史莱姆").type(2).hp(150).attack(25)
                    .defence(10).exp(5).gold(4)
                    .build());
            put(IndexConst.ENEMY4, EnemyInfo.builder().index(IndexConst.ENEMY4).image_name("enemy01.png").image_index(4)
                    .enemyName("史莱姆王").type(2).hp(360).attack(70)
                    .defence(40).exp(10).gold(9)
                    .build());

            put(IndexConst.ENEMY5, EnemyInfo.builder().index(IndexConst.ENEMY15).image_name("enemy02.png").image_index(1)
                    .enemyName("小蝙蝠").type(2).hp(100).attack(15)
                    .defence(5).exp(4).gold(2)
                    .build());
            put(IndexConst.ENEMY6, EnemyInfo.builder().index(IndexConst.ENEMY6).image_name("enemy02.png").image_index(2)
                    .enemyName("大蝙蝠").type(2).hp(120).attack(20)
                    .defence(5).exp(4).gold(3)
                    .build());
            put(IndexConst.ENEMY7, EnemyInfo.builder().index(IndexConst.ENEMY7).image_name("enemy02.png").image_index(3)
                    .enemyName("吸血蝙蝠").type(2).hp(150).attack(25)
                    .defence(10).exp(5).gold(4)
                    .build());
            put(IndexConst.ENEMY8, EnemyInfo.builder().index(IndexConst.ENEMY8).image_name("enemy02.png").image_index(4)
                    .enemyName("吸血鬼").type(2).hp(360).attack(70)
                    .defence(40).exp(10).gold(9)
                    .build());

            put(IndexConst.ENEMY9, EnemyInfo.builder().index(IndexConst.ENEMY9).image_name("enemy03.png").image_index(1)
                    .enemyName("骷髅人").type(2).hp(100).attack(15)
                    .defence(5).exp(4).gold(2)
                    .build());
            put(IndexConst.ENEMY10, EnemyInfo.builder().index(IndexConst.ENEMY10).image_name("enemy03.png").image_index(2)
                    .enemyName("骷髅士兵").type(2).hp(120).attack(20)
                    .defence(5).exp(4).gold(3)
                    .build());
            put(IndexConst.ENEMY11, EnemyInfo.builder().index(IndexConst.ENEMY11).image_name("enemy03.png").image_index(3)
                    .enemyName("骷髅队长").type(2).hp(150).attack(25)
                    .defence(10).exp(5).gold(4)
                    .build());
            put(IndexConst.ENEMY12, EnemyInfo.builder().index(IndexConst.ENEMY12).image_name("enemy03.png").image_index(4)
                    .enemyName("鬼战士").type(2).hp(360).attack(70)
                    .defence(40).exp(10).gold(9)
                    .build());

            put(IndexConst.ENEMY13, EnemyInfo.builder().index(IndexConst.ENEMY13).image_name("enemy04.png").image_index(1)
                    .enemyName("兽人").type(2).hp(100).attack(15)
                    .defence(5).exp(4).gold(2)
                    .build());
            put(IndexConst.ENEMY14, EnemyInfo.builder().index(IndexConst.ENEMY14).image_name("enemy04.png").image_index(2)
                    .enemyName("兽人武士").type(2).hp(120).attack(20)
                    .defence(5).exp(4).gold(3)
                    .build());
            put(IndexConst.ENEMY15, EnemyInfo.builder().index(IndexConst.ENEMY15).image_name("enemy04.png").image_index(3)
                    .enemyName("石头人").type(2).hp(150).attack(25)
                    .defence(10).exp(5).gold(4)
                    .build());
            put(IndexConst.ENEMY16, EnemyInfo.builder().index(IndexConst.ENEMY16).image_name("enemy04.png").image_index(4)
                    .enemyName("幽灵").type(2).hp(360).attack(70)
                    .defence(40).exp(10).gold(9)
                    .build());

            put(IndexConst.ENEMY17, EnemyInfo.builder().index(IndexConst.ENEMY17).image_name("enemy05.png").image_index(1)
                    .enemyName("绿史莱姆").type(2).hp(100).attack(15)
                    .defence(5).exp(4).gold(2)
                    .build());
            put(IndexConst.ENEMY18, EnemyInfo.builder().index(IndexConst.ENEMY18).image_name("enemy05.png").image_index(2)
                    .enemyName("红史莱姆").type(2).hp(120).attack(20)
                    .defence(5).exp(4).gold(3)
                    .build());
            put(IndexConst.ENEMY19, EnemyInfo.builder().index(IndexConst.ENEMY19).image_name("enemy05.png").image_index(3)
                    .enemyName("大史莱姆").type(2).hp(150).attack(25)
                    .defence(10).exp(5).gold(4)
                    .build());
            put(IndexConst.ENEMY20, EnemyInfo.builder().index(IndexConst.ENEMY20).image_name("enemy05.png").image_index(4)
                    .enemyName("史莱姆王").type(2).hp(360).attack(70)
                    .defence(40).exp(10).gold(9)
                    .build());

            put(IndexConst.ENEMY21, EnemyInfo.builder().index(IndexConst.ENEMY21).image_name("enemy06.png").image_index(1)
                    .enemyName("绿史莱姆").type(2).hp(100).attack(15)
                    .defence(5).exp(4).gold(2)
                    .build());
            put(IndexConst.ENEMY22, EnemyInfo.builder().index(IndexConst.ENEMY22).image_name("enemy06.png").image_index(2)
                    .enemyName("红史莱姆").type(2).hp(120).attack(20)
                    .defence(5).exp(4).gold(3)
                    .build());
            put(IndexConst.ENEMY23, EnemyInfo.builder().index(IndexConst.ENEMY23).image_name("enemy06.png").image_index(3)
                    .enemyName("大史莱姆").type(2).hp(150).attack(25)
                    .defence(10).exp(5).gold(4)
                    .build());
            put(IndexConst.ENEMY24, EnemyInfo.builder().index(IndexConst.ENEMY24).image_name("enemy06.png").image_index(4)
                    .enemyName("史莱姆王").type(2).hp(360).attack(70)
                    .defence(40).exp(10).gold(9)
                    .build());

            put(IndexConst.ENEMY25, EnemyInfo.builder().index(IndexConst.ENEMY25).image_name("enemy07.png").image_index(1)
                    .enemyName("绿史莱姆").type(2).hp(100).attack(15)
                    .defence(5).exp(4).gold(2)
                    .build());
            put(IndexConst.ENEMY26, EnemyInfo.builder().index(IndexConst.ENEMY26).image_name("enemy07.png").image_index(2)
                    .enemyName("红史莱姆").type(2).hp(120).attack(20)
                    .defence(5).exp(4).gold(3)
                    .build());
            put(IndexConst.ENEMY27, EnemyInfo.builder().index(IndexConst.ENEMY27).image_name("enemy07.png").image_index(3)
                    .enemyName("大史莱姆").type(2).hp(150).attack(25)
                    .defence(10).exp(5).gold(4)
                    .build());
            put(IndexConst.ENEMY28, EnemyInfo.builder().index(IndexConst.ENEMY28).image_name("enemy07.png").image_index(4)
                    .enemyName("史莱姆王").type(2).hp(360).attack(70)
                    .defence(40).exp(10).gold(9)
                    .build());
        }
    };
}
