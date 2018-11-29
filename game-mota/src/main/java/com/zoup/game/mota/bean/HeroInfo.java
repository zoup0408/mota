package com.zoup.game.mota.bean;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by zoup on 2018/11/21
 * E-Mail：2479008771@qq.com
 */
@Getter
@Setter
@Builder
public class HeroInfo extends LitePalSupport {
    @Column(unique = true)
    public int hero_id;
    public int left;
    public int top;
    public int direction;
    public int attack;
    public int defence;
    public int hp;
    public int exp;
    public int gold;
    public int yellow_key;
    public int blue_key;
    public int red_key;
    public boolean is_search;
    public boolean is_fly;
    public int max_floor;
    public int cur_floor;
    public Date create_time;
    public Date update_time;

}
