package com.lcodecore.twinklingrefreshlayout;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.os.StrictMode;

/**
 * Created by lcodecore on 16/3/2.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Some OEM system components (MIUI/Mediatek modules) may perform disk reads
        // during layout inflation which can trigger StrictMode DiskReadViolation on
        // devices with strict policies. Temporarily allow disk reads for setContentView
        // and restore the previous policy immediately after.
        StrictMode.ThreadPolicy _oldPolicy = StrictMode.allowThreadDiskReads();
        try {
            setContentView(setInflateId());
        } finally {
            StrictMode.setThreadPolicy(_oldPolicy);
        }

        init();
        initAcition();
    }

    //设置布局id
    public abstract int setInflateId();

    //视图，组件,数据的初始化
    public abstract void init();

    //事件监听
    public void initAcition(){}

    //Activity设置带返回按钮的Toolbar
    public void setupBackToolbar(String title){
        setupBackToolbar(R.id.toolbar,title);
    }

    public void setupBackToolbar(int toolbarId,String title){
        Toolbar mToolbar = (Toolbar) findViewById(toolbarId);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //显示小箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setTitle(title);
    }
}
