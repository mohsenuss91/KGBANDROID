// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.IMWebView;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            ResizeDimensions, MRAIDAudioVideoController

public class MRAIDResizeController
{

    protected static final int PLACEHOLDER_ID = 437;
    protected static final int RELATIVELAYOUT_ID = 438;
    private IMWebView a;
    private ResizeDimensions b;
    public com.inmobi.re.controller.JSController.ResizeProperties resizeProperties;

    public MRAIDResizeController(IMWebView imwebview, Activity activity)
    {
        b = null;
        a = imwebview;
    }

    private FrameLayout a(com.inmobi.re.controller.JSController.ResizeProperties resizeproperties)
    {
        FrameLayout framelayout = (FrameLayout)((ViewGroup)a.getOriginalParent()).getRootView().findViewById(0x1020002);
        a();
        FrameLayout framelayout1 = new FrameLayout(a.getContext());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        framelayout1.setId(435);
        android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(resizeproperties.width, resizeproperties.height);
        RelativeLayout relativelayout = new RelativeLayout(a.getContext());
        relativelayout.setId(438);
        android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(resizeproperties.width, resizeproperties.height);
        relativelayout.addView(a, layoutparams2);
        a(((ViewGroup) (relativelayout)), resizeproperties.customClosePosition);
        framelayout1.addView(relativelayout, layoutparams1);
        a(framelayout, framelayout1, a, resizeproperties);
        framelayout.addView(framelayout1, layoutparams);
        a.setFocusable(true);
        a.setFocusableInTouchMode(true);
        a.requestFocus();
        return framelayout1;
    }

    private android.widget.RelativeLayout.LayoutParams a(String s)
    {
        String s1 = b(s);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(50F * a.getDensity()), (int)(50F * a.getDensity()));
        if (s1.equals("top-right") || s1.equals("bottom-right"))
        {
            layoutparams.addRule(11);
        }
        if (s1.equals("bottom-right") || s1.equals("bottom-left") || s1.equals("bottom-center"))
        {
            layoutparams.addRule(12);
            layoutparams.addRule(4);
        }
        if (s1.equals("bottom-center") || s1.equals("top-center") || s1.equals("center"))
        {
            layoutparams.addRule(13);
        }
        if (s1.equals("top-center"))
        {
            layoutparams.addRule(10);
        }
        return layoutparams;
    }

    static IMWebView a(MRAIDResizeController mraidresizecontroller)
    {
        return mraidresizecontroller.a;
    }

    private void a()
    {
        try
        {
            FrameLayout framelayout = new FrameLayout(a.getContext());
            framelayout.setId(437);
            android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(a.getWidth(), a.getHeight());
            ((ViewGroup)a.getOriginalParent()).addView(framelayout, a.getOriginalIndex(), layoutparams);
            ((ViewGroup)a.getParent()).removeView(a);
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Exception in replaceByPlaceHolder ", exception);
        }
    }

    private void a(ViewGroup viewgroup, String s)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = a(s);
        CustomView customview = new CustomView(a.getContext(), a.getDensity(), com.inmobi.re.container.CustomView.SwitchIconType.CLOSE_TRANSPARENT);
        viewgroup.addView(customview, layoutparams);
        customview.setOnClickListener(new a());
    }

    private void a(FrameLayout framelayout, FrameLayout framelayout1, IMWebView imwebview, com.inmobi.re.controller.JSController.ResizeProperties resizeproperties)
    {
        int ai[] = new int[2];
        int ai1[] = new int[2];
        ((View)imwebview.getOriginalParent()).getLocationOnScreen(ai);
        framelayout.getLocationOnScreen(ai1);
        ai[1] = ai[1] - ai1[1];
        ai[0] = ai[0] - ai1[0];
        ai[0] = ai[0] + resizeproperties.offsetX;
        ai[1] = ai[1] + resizeproperties.offsetY;
        if (!resizeproperties.allowOffscreen)
        {
            if (resizeproperties.width > framelayout.getWidth() - ai[0])
            {
                ai[0] = framelayout.getWidth() - resizeproperties.width;
            }
            if (resizeproperties.height > framelayout.getHeight() - ai[1])
            {
                ai[1] = framelayout.getHeight() - resizeproperties.height;
            }
            if (ai[0] < 0)
            {
                ai[0] = 0;
            }
            if (ai[1] < 0)
            {
                ai[1] = 0;
            }
        }
        b = new ResizeDimensions(ai[0], ai[1], resizeproperties.width, resizeproperties.height);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(resizeproperties.width, resizeproperties.height);
        layoutparams.leftMargin = ai[0];
        layoutparams.topMargin = ai[1];
        layoutparams.gravity = 3;
        ((View)imwebview.getParent()).setLayoutParams(layoutparams);
    }

    static ResizeDimensions b(MRAIDResizeController mraidresizecontroller)
    {
        return mraidresizecontroller.b;
    }

    private String b(String s)
    {
        if (!s.equals("top-left") && !s.equals("top-right") && !s.equals("bottom-left") && !s.equals("bottom-right") && !s.equals("top-center") && !s.equals("bottom-center") && !s.equals("center"))
        {
            s = "top-right";
        }
        return s;
    }

    private void b()
    {
        ((ViewGroup)a.getParent().getParent().getParent()).removeView((View)a.getParent().getParent());
        ((ViewGroup)a.getParent()).removeView(a);
        View view = ((View)a.getOriginalParent()).findViewById(437);
        ((ViewGroup)view.getParent()).removeView(view);
        ((ViewGroup)a.getOriginalParent()).addView(a, a.getOriginalIndex());
        a.resetLayout();
    }

    public void closeResized()
    {
        if (a.getViewState().compareTo(com.inmobi.re.container.IMWebView.ViewState.DEFAULT) == 0)
        {
            return;
        }
        synchronized (a.mutex)
        {
            a.isMutexAquired.set(false);
            a.mutex.notifyAll();
        }
        a.doNotFireVisibilityChanged.set(true);
        b();
        a.closeResized();
        a.setVisibility(0);
        a.setState(com.inmobi.re.container.IMWebView.ViewState.DEFAULT);
        a.doNotFireVisibilityChanged.set(false);
    }

    public void doResize(Bundle bundle)
    {
        a.doNotFireVisibilityChanged.set(true);
        if (a.getOriginalParent() == null)
        {
            a.saveOriginalViewParent();
        }
        if (((FrameLayout)a.getParent().getParent()).getId() != 435)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        a((FrameLayout)a.getParent().getParent().getParent(), (FrameLayout)a.getParent().getParent(), a, resizeProperties);
        android.widget.RelativeLayout.LayoutParams layoutparams = a(resizeProperties.customClosePosition);
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(resizeProperties.width, resizeProperties.height);
        a.setLayoutParams(layoutparams1);
        ((ViewGroup)a.getParent()).getChildAt(1).setLayoutParams(layoutparams);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        a.setState(com.inmobi.re.container.IMWebView.ViewState.RESIZED);
        a.requestLayout();
        a.invalidate();
        a.postInHandler(new b());
        a.doNotFireVisibilityChanged.set(false);
        return;
        Exception exception;
        exception;
        a(resizeProperties).setBackgroundColor(0);
        a.mAudioVideoController.videoValidateWidth = resizeProperties.width;
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        a.setState(com.inmobi.re.container.IMWebView.ViewState.RESIZED);
        synchronized (a.mutex)
        {
            a.isMutexAquired.set(false);
            a.mutex.notifyAll();
        }
        try
        {
            a.requestLayout();
            a.invalidate();
            a.postInHandler(new c());
        }
        catch (Exception exception1)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Exception in doresize ", exception1);
            a.setState(com.inmobi.re.container.IMWebView.ViewState.DEFAULT);
            synchronized (a.mutex)
            {
                a.isMutexAquired.set(false);
                a.mutex.notifyAll();
            }
        }
        a.doNotFireVisibilityChanged.set(false);
        return;
        exception3;
        obj1;
        JVM INSTR monitorexit ;
        throw exception3;
    }

    public void onOrientationChange()
    {
        if (a.getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.RESIZED && !resizeProperties.allowOffscreen)
        {
            doResize(null);
        }
    }

    public void reset()
    {
        resizeProperties = new com.inmobi.re.controller.JSController.ResizeProperties();
    }

    private class a
        implements android.view.View.OnClickListener
    {

        final MRAIDResizeController a;

        public void onClick(View view)
        {
            IMWebView.userInitiatedClose = true;
            MRAIDResizeController.a(a).close();
        }

        a()
        {
            a = MRAIDResizeController.this;
            super();
        }
    }


    private class b
        implements Runnable
    {

        final MRAIDResizeController a;

        public void run()
        {
            if (MRAIDResizeController.a(a).mListener != null)
            {
                MRAIDResizeController.a(a).mListener.onResize(MRAIDResizeController.b(a));
            }
        }

        b()
        {
            a = MRAIDResizeController.this;
            super();
        }
    }


    private class c
        implements Runnable
    {

        final MRAIDResizeController a;

        public void run()
        {
            if (MRAIDResizeController.a(a).mListener != null)
            {
                MRAIDResizeController.a(a).mListener.onResize(MRAIDResizeController.b(a));
            }
        }

        c()
        {
            a = MRAIDResizeController.this;
            super();
        }
    }

}
