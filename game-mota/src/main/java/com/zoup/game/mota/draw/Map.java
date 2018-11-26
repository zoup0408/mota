package com.zoup.game.mota.draw;

/**
 * Created by zoup on 2018/11/24
 * E-Mail：2479008771@qq.com
 */

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.zoup.game.mota.data.DataProvider;
import com.zoup.game.mota.data.GameConfig;
import com.zoup.game.mota.data.IndexConst;
import com.zoup.game.mota.data.MapData;
import com.zoup.game.mota.utils.BitmapUtils;

public class Map {
    private int gridSize = GameConfig.GRID_SIZE;
    private int leftMargin = GameConfig.LEFT_MARGIN;
    private int topMargin = GameConfig.TOP_MARGIN;
    private Bitmap[][] mapBitmaps = new Bitmap[2][3];
    private Paint paint = new Paint();

    public Map() {
        paint.setAntiAlias(true);
        setMapBitmap();
    }

    public void draw(Canvas canvas, int floor) {
        DataProvider.loadMap(floor);
        Bitmap target = null;
        for (int i = 0; i < MapData.floorMap.length; i++) {
            for (int j = 0; j < MapData.floorMap[i].length; j++) {
                int typeIndex = MapData.floorMap[i][j];
                if (typeIndex == IndexConst.MAPITEM1) {
                    target = mapBitmaps[0][1];
                } else if (typeIndex == IndexConst.MAPITEM2) {
                    target = mapBitmaps[0][0];
                } else if (typeIndex == IndexConst.MAPITEM3) {
                    target = mapBitmaps[1][0];
                } else if (typeIndex == IndexConst.MAPITEM4) {
                    target = mapBitmaps[1][1];
                } else {
                    target = mapBitmaps[1][2];
                }
                RectF rectF = new RectF(leftMargin + j * gridSize, topMargin + i * gridSize,
                        leftMargin + (j + 1) * gridSize, topMargin + (i + 1) * gridSize);
                canvas.drawBitmap(target, null, rectF, paint);
            }
        }

    }

    private void setMapBitmap() {
        mapBitmaps = BitmapUtils.getMapBitmaps("map.png");
    }

}
