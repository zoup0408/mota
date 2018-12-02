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
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.zoup.game.mota.R;
import com.zoup.game.mota.bean.Direction;
import com.zoup.game.mota.bean.HeroInfo;
import com.zoup.game.mota.bean.MoveEvent;
import com.zoup.game.mota.rx.RxBus;
import com.zoup.game.mota.rx.RxDisposables;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


/**
 * Created by zoup on 2018/11/25
 * E-Mail：2479008771@qq.com
 */
public class InfoFragment extends Fragment {
    TextView floorText;
    TextView hpText;
    TextView attackText;
    TextView defenceText;
    TextView redKeyText;
    TextView blueKeyText;
    TextView yellowKeyText;
    TextView goldText;
    TextView expText;
    ImageView virtualController;


    public static InfoFragment getInstance() {
        return new InfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_info, container, false);
        findComponents(view);
        addListeners();
        return view;
    }

    private void findComponents(View view) {
        virtualController = view.findViewById(R.id.virtual_controller);
        floorText = view.findViewById(R.id.floor_text);
        hpText = view.findViewById(R.id.hp_text);
        attackText = view.findViewById(R.id.attack_text);
        defenceText = view.findViewById(R.id.defence_text);
        redKeyText = view.findViewById(R.id.red_key_text);
        blueKeyText = view.findViewById(R.id.blue_key_text);
        yellowKeyText = view.findViewById(R.id.yellow_key_text);
        goldText = view.findViewById(R.id.gold_text);
        expText = view.findViewById(R.id.exp_text);
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
//                                GameView.status = -1;
                                postMoveEvent(Direction.ACTION_DOWN);
                            } else {
                                Logger.d("up");
//                                GameView.status = 1;
                                postMoveEvent(Direction.ACTION_UP);
                            }
                        }
                        break;
                }
                return true;
            }
        });
        Disposable disposable = RxBus.getInstance().toObservableSticky(HeroInfo.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HeroInfo>() {
                    @Override
                    public void accept(HeroInfo heroInfo) {
                        if (heroInfo != null) {
                            setViews(heroInfo);
                        }
                    }
                });
        RxDisposables.add(disposable);
    }

    private void postMoveEvent(int action) {
        MoveEvent moveEvent = new MoveEvent(action);
        RxBus.getInstance().postSticky(moveEvent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        RxDisposables.clear();
    }

    @SuppressLint("SetTextI18n")
    private void setViews(HeroInfo heroInfo) {
        floorText.setText("第" + heroInfo.getCur_floor() + "层");
        hpText.setText(getString(R.string.hp_tip) + heroInfo.getHp());
        attackText.setText(getString(R.string.attack_tip) + heroInfo.getAttack());
        defenceText.setText(getString(R.string.defence_tip) + heroInfo.getDefence());
        redKeyText.setText(getString(R.string.red_key_tip) + heroInfo.getRed_key());
        blueKeyText.setText(getString(R.string.blue_key_tip) + heroInfo.getBlue_key());
        yellowKeyText.setText(getString(R.string.yellow_key_tip) + heroInfo.getYellow_key());
        goldText.setText(getString(R.string.gold) + heroInfo.getGold());
        expText.setText(getString(R.string.exp) + heroInfo.getExp());
    }
}
