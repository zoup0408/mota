package com.zoup.game.mota.bean;

public class MoveEvent {

    private int action;

    public MoveEvent() {
    }

    public MoveEvent(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
