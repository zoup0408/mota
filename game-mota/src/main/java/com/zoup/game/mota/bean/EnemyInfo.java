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
    public int index;
    public String enemyName;
    public int attack;
    public int defence;
    public int hp;
    public int exp;
    public int gold;
    public int type;
    public String image_name;
    public int image_index;
}
