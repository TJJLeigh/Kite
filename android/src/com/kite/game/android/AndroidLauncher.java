package com.kite.game.android;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.*;
import com.kite.game.ActionResolver;
import com.kite.game.Kite;


public class AndroidLauncher extends AndroidApplication implements ActionResolver {
    private static final String AD_UID = "ca-app-pub-4281456435917779/5785331041";
    private final int SHOW_ADS = 1;
    private final int HIDE_ADS = 0;

    @Override
    public void showAds(boolean show){
        AdVisibilityHandler.sendEmptyMessage(show ? SHOW_ADS : HIDE_ADS);
    }

    protected Handler AdVisibilityHandler = new Handler(){
      @Override
        public  void handleMessage(Message msg){
          switch (msg.what){
          case SHOW_ADS:{
              adView.setVisibility(View.VISIBLE);
              break;
      }
          case HIDE_ADS:{
              adView.setVisibility(View.GONE);
              break;
          }
      }}
    };


    //ca-app-pub-4281456435917779/5785331041
    AdView adView;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;

        // Create the layout
        RelativeLayout layout = new RelativeLayout(this);

        // Do the stuff that initialize() would do for you
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        // Create the libgdx View
        View gameView = initializeForView(new Kite(this),config);

        // Create and setup the AdMob view
        adView = new AdView(this);
        adView.setAdUnitId(AD_UID);

        adView.setAdSize(AdSize.SMART_BANNER);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                Log.d("Admob", "Error code: " + errorCode);
                adView.loadAd(new AdRequest.Builder().build());
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        // Add the libgdx view
        layout.addView(gameView);

        // Add the AdMob view
        RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        layout.addView(adView, adParams);
        adView.setVisibility(View.VISIBLE);
        // Hook it all up
        setContentView(layout);
		//initialize(new Kite(), config);
	}

    private void StartAd(AdView adView){
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
