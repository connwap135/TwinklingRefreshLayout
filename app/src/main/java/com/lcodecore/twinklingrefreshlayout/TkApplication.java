package com.lcodecore.twinklingrefreshlayout;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

// removed BlockCanary and LeakCanary imports; these debug tools are optional

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

/**
 * Created by lcodecore on 2016/12/4.
 */

public class TkApplication extends Application {

    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;

        // Enable StrictMode in debug builds but avoid crashing the process (penaltyDeath)
        // because some OEM/system components on certain devices perform disk I/O
        // on the main thread (MIUI/Mediatek) which would otherwise kill the app.
        // Use penaltyLog so violations are reported but do not crash the app.
        // Use penaltyLog so violations are reported but the process isn't killed.
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());

//        TwinklingRefreshLayout.setDefaultHeader(SinaRefreshView.class.getName());
//        TwinklingRefreshLayout.setDefaultFooter(BallPulseView.class.getName());
    }

    // BlockCanary context removed

    private void enabledStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                .detectAll() //
                .penaltyLog() //
                .penaltyDeath() //
                .build());
    }
}
