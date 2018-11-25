package com.zoup.game.mota.ui;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.zoup.game.mota.R;
import com.zoup.game.mota.data.DataProvider;
import com.zoup.game.mota.data.GameConfig;
import com.zoup.game.mota.utils.ScreenUtils;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        DataProvider.initGameData();
        setContentView(R.layout.activity_main);
        setGameLayout();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, InfoFragment.getInstance()).commitNow();
    }

    private void setGameLayout() {
        GameConfig.GRID_SIZE = ScreenUtils.getScreenH(this) / GameConfig.GRID_COUNT;
        GameConfig.LEFT_MARGIN = (GameConfig.GRID_COUNT - GameConfig.MAP_COLUMNS) * GameConfig.GRID_SIZE / 2;
        GameConfig.TOP_MARGIN = (GameConfig.GRID_COUNT - GameConfig.MAP_ROWS) * GameConfig.GRID_SIZE / 2;
        GameView GameView = new GameView(this);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ScreenUtils.getScreenH(this), ScreenUtils.getScreenH(this));
        GameView.setLayoutParams(lp);
        LinearLayout rootView = findViewById(R.id.root_view);
        rootView.addView(GameView, 0);

    }
}
