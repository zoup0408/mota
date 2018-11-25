package com.zoup.game.mota.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;
import com.zoup.game.mota.R;
import com.zoup.game.mota.bean.Direction;
import com.zoup.game.mota.bean.MoveEvent;
import com.zoup.game.mota.rx.RxBus;


/**
 * Created by zoup on 2018/11/25
 * E-Mail：2479008771@qq.com
 */
public class InfoFragment extends Fragment {
    private ImageView virtualController;

    public static InfoFragment getInstance() {
        return new InfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_info, container, false);
        initViews(view);
        addListeners();
        return view;
    }

    private void initViews(View parent) {
        virtualController = parent.findViewById(R.id.virtual_controller);

    }

    @SuppressLint("ClickableViewAccessibility")
    private void addListeners() {
        virtualController.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        float xPos = event.getX();
                        float yPos = event.getY();
                        int width = virtualController.getWidth();
                        int height = virtualController.getHeight();
                        int centerX = width / 2;
                        int centerY = height / 2;

                        if (Math.abs(xPos - centerX) > Math.abs(yPos - centerY)) {
                            if (xPos > centerX) {
                                Logger.d("right");
                                postMoveEvent(Direction.ACTION_RIGHT);
                            } else {
                                Logger.d("left");
                                postMoveEvent(Direction.ACTION_LEFT);
                            }
                        } else {
                            if (yPos > centerY) {
                                Logger.d("down");
                                postMoveEvent(Direction.ACTION_DOWN);
                            } else {
                                Logger.d("up");
                                postMoveEvent(Direction.ACTION_UP);
                            }
                        }
                        break;
                }
                return true;
            }
        });
    }

    private void postMoveEvent(int action) {
        MoveEvent moveEvent = new MoveEvent(action);
        RxBus.getInstance().postSticky(moveEvent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
