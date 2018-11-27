package com.zoup.game.mota.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by zoup on 2018/11/26
 * E-Mail：2479008771@qq.com
 */
@Setter
@Getter
@Builder
public class GameInfo {
    private int floor;
    private int hp;
    private int attack;
    private int defence;
    private int gold;
    private int exp;
    private int redKey;
    private int blueKey;
    private int yellowKey;
}
