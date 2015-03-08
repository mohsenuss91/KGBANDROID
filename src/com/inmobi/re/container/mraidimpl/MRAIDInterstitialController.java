// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Message;
import android.view.Display;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.IMWebView;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDAudioVideoController

public class MRAIDInterstitialController
{

    protected static final int INT_BACKGROUND_ID = 224;
    public static final int INT_CLOSE_BUTTON = 225;
    public static AtomicBoolean isInterstitialDisplayed = new AtomicBoolean();
    private IMWebView a;
    private Activity b;
    private long c;
    private int d;
    public boolean lockOrientationValueForInterstitial;
    public Message mMsgOnInterstitialClosed;
    public Message mMsgOnInterstitialShown;
    public Display mSensorDisplay;
    public String orientationValueForInterstitial;

    public MRAIDInterstitialController(IMWebView imwebview, Activity activity)
    {
        lockOrientationValueForInterstitial = true;
        c = 0L;
        a = imwebview;
    }

    static IMWebView a(MRAIDInterstitialController mraidinterstitialcontroller)
    {
        return mraidinterstitialcontroller.a;
    }

    static long b(MRAIDInterstitialController mraidinterstitialcontroller)
    {
        return mraidinterstitialcontroller.c;
    }

    public void animateAndDismissWebview()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setInterpolator(new AccelerateInterpolator());
        alphaanimation.setStartOffset(0L);
        alphaanimation.setDuration(c);
        alphaanimation.setAnimationListener(new c());
        a.startAnimation(alphaanimation);
    }

    public void changeContentAreaForInterstitials(long l)
    {
        int i;
        FrameLayout framelayout;
        RelativeLayout relativelayout;
        android.widget.RelativeLayout.LayoutParams layoutparams1;
        CustomView customview;
        c = l;
        i = Initializer.getConfigParams().getWebviewBgColor();
        d = b.getRequestedOrientation();
        handleOrientationForInterstitial();
        framelayout = (FrameLayout)b.findViewById(0x1020002);
        relativelayout = new RelativeLayout(a.getContext());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        layoutparams.addRule(10);
        a.setFocusable(true);
        a.setFocusableInTouchMode(true);
        relativelayout.addView(a, layoutparams);
        layoutparams1 = new android.widget.RelativeLayout.LayoutParams((int)(50F * a.getDensity()), (int)(50F * a.getDensity()));
        if (a.getCustomClose())
        {
            break MISSING_BLOCK_LABEL_311;
        }
        customview = new CustomView(a.getContext(), a.getDensity(), com.inmobi.re.container.CustomView.SwitchIconType.CLOSE_BUTTON);
_L2:
        layoutparams1.addRule(11);
        customview.setId(225);
        relativelayout.addView(customview, layoutparams1);
        android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        relativelayout.setId(224);
        relativelayout.setBackgroundColor(i);
        framelayout.addView(relativelayout, layoutparams2);
        a.setBackgroundColor(i);
        a.requestFocus();
        a.setOnKeyListener(new b());
        a.setOnTouchListener(new a());
        isInterstitialDisplayed.set(true);
        if (mMsgOnInterstitialShown != null)
        {
            mMsgOnInterstitialShown.sendToTarget();
            mMsgOnInterstitialShown = null;
            return;
        }
        break MISSING_BLOCK_LABEL_349;
        customview = new CustomView(a.getContext(), a.getDensity(), com.inmobi.re.container.CustomView.SwitchIconType.CLOSE_TRANSPARENT);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        Log.debug("[InMobi]-[RE]-4.4.1", "Failed showing interstitial ad", exception);
    }

    public void dismissWebview()
    {
        FrameLayout framelayout = (FrameLayout)b.findViewById(0x1020002);
        RelativeLayout relativelayout = (RelativeLayout)framelayout.findViewById(224);
        b.runOnUiThread(new d(relativelayout, framelayout));
    }

    public void handleInterstitialClose()
    {
        IMWebView.userInitiatedClose = true;
        isInterstitialDisplayed.set(false);
        a.close();
    }

    public void handleOrientationForInterstitial()
    {
        a.lockExpandOrientation(b, lockOrientationValueForInterstitial, orientationValueForInterstitial);
    }

    public void resetContentsForInterstitials()
    {
        try
        {
            if (a.getParent() == null)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Failed to close the interstitial ad", exception);
            return;
        }
        b.setRequestedOrientation(d);
        a.mAudioVideoController.releaseAllPlayers();
        if ((RelativeLayout)((FrameLayout)b.findViewById(0x1020002)).findViewById(224) != null)
        {
            if (c <= 0L)
            {
                break MISSING_BLOCK_LABEL_120;
            }
            animateAndDismissWebview();
        }
_L1:
        if (mMsgOnInterstitialClosed != null)
        {
            mMsgOnInterstitialClosed.sendToTarget();
            mMsgOnInterstitialClosed = null;
        }
        a.injectJavaScript("window.mraidview.unRegisterOrientationListener()");
        a.setState(com.inmobi.re.container.IMWebView.ViewState.HIDDEN);
        return;
        dismissWebview();
          goto _L1
    }

    public void setActivity(Activity activity)
    {
        if (activity != null)
        {
            b = activity;
        }
    }


    private class c
        implements android.view.animation.Animation.AnimationListener
    {

        final MRAIDInterstitialController a;

        public void onAnimationEnd(Animation animation)
        {
            a.dismissWebview();
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

        c()
        {
            a = MRAIDInterstitialController.this;
            super();
        }
    }


    private class b
        implements android.view.View.OnKeyListener
    {

        final MRAIDInterstitialController a;

        public boolean onKey(View view, int i, KeyEvent keyevent)
        {
            int j = keyevent.getKeyCode();
            boolean flag = false;
            if (4 == j)
            {
                int k = keyevent.getAction();
                flag = false;
                if (k == 0)
                {
                    Log.debug("[InMobi]-[RE]-4.4.1", "Back Button pressed while Interstitial ad is in active state ");
                    a.handleInterstitialClose();
                    int l = MRAIDInterstitialController.b(a) != 0L;
                    flag = false;
                    if (l > 0)
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        b()
        {
            a = MRAIDInterstitialController.this;
            super();
        }
    }


    private class a
        implements android.view.View.OnTouchListener
    {

        final MRAIDInterstitialController a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            motionevent.getAction();
            JVM INSTR tableswitch 0 1: default 28
        //                       0 30
        //                       1 38;
               goto _L1 _L2 _L3
_L1:
            return false;
_L2:
            view.requestFocus();
            continue; /* Loop/switch isn't completed */
_L3:
            view.requestFocus();
            if (true) goto _L1; else goto _L4
_L4:
        }

        a()
        {
            a = MRAIDInterstitialController.this;
            super();
        }
    }


    private class d
        implements Runnable
    {

        final RelativeLayout a;
        final FrameLayout b;
        final MRAIDInterstitialController c;

        public void run()
        {
            a.removeView(MRAIDInterstitialController.a(c));
            b.removeView(a);
        }

        d(RelativeLayout relativelayout, FrameLayout framelayout)
        {
            c = MRAIDInterstitialController.this;
            a = relativelayout;
            b = framelayout;
            super();
        }
    }

}
