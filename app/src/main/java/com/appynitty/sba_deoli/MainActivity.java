package com.appynitty.sba_deoli;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.appynitty.swachbharatabhiyanlibrary.activity.SplashScreenActivity;
import com.appynitty.swachbharatabhiyanlibrary.utils.AUtils;
import com.pixplicity.easyprefs.library.Prefs;
import leakcanary.LeakCanary;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(BuildConfig.DEBUG)
          createLeakConfig();
        Prefs.putString(AUtils.APP_ID, "1");
        Prefs.putInt(AUtils.VERSION_CODE, BuildConfig.VERSION_CODE);
        startActivity(new Intent(MainActivity.this, SplashScreenActivity.class));

    }

        private void createLeakConfig() {
        LeakCanary.Config config = LeakCanary.getConfig().newBuilder()
                .dumpHeap(true)
                .dumpHeapWhenDebugging(true)
                .computeRetainedHeapSize(true)
                .build();
        LeakCanary.setConfig(config);


    }



    @Override
    protected void onPause() {
        super.onPause();
        finish();

    }



}
