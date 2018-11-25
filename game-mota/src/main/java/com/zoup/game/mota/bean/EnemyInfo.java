package com.zoup.game.mota.bean;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by zoup on 2018/11/24
 * E-Mail：2479008771@qq.com
 */
@Setter
@Getter
@Builder
public class EnemyInfo extends LitePalSupport {
    @Column(unique = true)
    private int index;
    private String enemyName;
    private int attack;
    private int defence;
    private int hp;
    private int exp;
    private int gold;
    private int type;
    private String image_name;
    private int image_index;
}
