// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.a.i;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

// Referenced classes of package com.adsdk.sdk.mraid:
//            Drawables, Dips

abstract class BaseInterstitialActivity extends Activity
{

    public static final String ACTION_INTERSTITIAL_CLICK = "com.mopub.action.interstitial.click";
    public static final String ACTION_INTERSTITIAL_DISMISS = "com.mopub.action.interstitial.dismiss";
    public static final String ACTION_INTERSTITIAL_FAIL = "com.mopub.action.interstitial.fail";
    public static final String ACTION_INTERSTITIAL_SHOW = "com.mopub.action.interstitial.show";
    private static final float CLOSE_BUTTON_PADDING = 8F;
    private static final float CLOSE_BUTTON_SIZE = 50F;
    public static final IntentFilter HTML_INTERSTITIAL_INTENT_FILTER = createHtmlInterstitialIntentFilter();
    private int mButtonPadding;
    private int mButtonSize;
    private ImageView mCloseButton;
    private RelativeLayout mLayout;

    BaseInterstitialActivity()
    {
    }

    private static IntentFilter createHtmlInterstitialIntentFilter()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("com.mopub.action.interstitial.fail");
        intentfilter.addAction("com.mopub.action.interstitial.show");
        intentfilter.addAction("com.mopub.action.interstitial.dismiss");
        intentfilter.addAction("com.mopub.action.interstitial.click");
        return intentfilter;
    }

    private void createInterstitialCloseButton()
    {
        mCloseButton = new ImageButton(this);
        StateListDrawable statelistdrawable = new StateListDrawable();
        statelistdrawable.addState(new int[] {
            0xfefeff59
        }, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(this));
        statelistdrawable.addState(new int[] {
            0x10100a7
        }, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(this));
        mCloseButton.setImageDrawable(statelistdrawable);
        mCloseButton.setBackgroundDrawable(null);
        mCloseButton.setOnClickListener(new _cls1());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(mButtonSize, mButtonSize);
        layoutparams.addRule(11);
        layoutparams.setMargins(mButtonPadding, 0, mButtonPadding, 0);
        mLayout.addView(mCloseButton, layoutparams);
    }

    protected void broadcastInterstitialAction(String s)
    {
        Intent intent = new Intent(s);
        i.a(this).a(intent);
    }

    public abstract View getAdView();

    protected void hideInterstitialCloseButton()
    {
        mCloseButton.setVisibility(4);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        mButtonSize = Dips.asIntPixels(50F, this);
        mButtonPadding = Dips.asIntPixels(8F, this);
        mLayout = new RelativeLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutparams.addRule(13);
        mLayout.addView(getAdView(), layoutparams);
        setContentView(mLayout);
        createInterstitialCloseButton();
    }

    protected void onDestroy()
    {
        mLayout.removeAllViews();
        super.onDestroy();
    }

    protected void showInterstitialCloseButton()
    {
        mCloseButton.setVisibility(0);
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final BaseInterstitialActivity this$0;

        public void onClick(View view)
        {
            finish();
        }

        _cls1()
        {
            this$0 = BaseInterstitialActivity.this;
            super();
        }
    }

}
