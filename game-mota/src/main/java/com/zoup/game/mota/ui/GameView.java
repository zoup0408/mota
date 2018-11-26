package com.zoup.game.mota.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.zoup.game.mota.data.DataProvider;
import com.zoup.game.mota.data.MapData;
import com.zoup.game.mota.draw.Element;
import com.zoup.game.mota.draw.ElementFactory;
import com.zoup.game.mota.draw.Map;

import java.util.Iterator;

/**
 * Created by zoup on 2018/11/25
 * E-Mail：2479008771@qq.com
 */
public class GameView extends SurfaceView implements Runnable, SurfaceHolder.Callback2 {
    private Context context;
    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private volatile boolean flag;
    public static int floor = 1;
    public static int status = 0;
    private Map map;

    public GameView(Context context) {
        super(context);
        init(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public void surfaceRedrawNeeded(SurfaceHolder holder) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        DataProvider.loadMap(floor);
        map = new Map();
        ElementFactory.setElement(floor);
        Thread thread = new Thread(this);
        flag = true;
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = false;
        surfaceHolder.removeCallback(this);
    }

    @Override
    public void run() {
        while (flag) {
            try {
                draw();
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void init(Context context) {
        this.context = context;
        surfaceHolder = getHolder();
        setZOrderOnTop(true);
        setZOrderMediaOverlay(true);
        surfaceHolder.setFormat(PixelFormat.TRANSLUCENT);
        surfaceHolder.addCallback(this);
        setFocusable(true);

    }

    private void draw() {
        try {
            canvas = surfaceHolder.lockCanvas();
            if (status == 0) {
                if (canvas != null) {
                    map.draw(canvas, floor);
                    Iterator iterator = Element.npcs.iterator();
                    while (iterator.hasNext()) {
                        ((Element) iterator.next()).draw(canvas);
                    }
                    Element.npcs.removeAll(Element.tempNpcs);
                    Element.tempNpcs.clear();
                }
            } else {
                setFloor();
            }
        } catch (Exception e) {

        } finally {
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public void setFloor() {
        floor += status;
    }
}
