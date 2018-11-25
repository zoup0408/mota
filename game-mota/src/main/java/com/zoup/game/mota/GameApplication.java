package com.zoup.game.mota;

import android.app.Application;

import com.hjq.toast.ToastUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

import org.litepal.LitePal;

/**
 * Created by zoup on 2018/11/24
 * E-Mail：2479008771@qq.com
 */
public class GameApplication extends Application {
    public static GameApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        CrashReport.initCrashReport(this, "16a9ca43b7", true);
        LitePal.initialize(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        ToastUtils.init(this);
//        initLeakCanary();
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
