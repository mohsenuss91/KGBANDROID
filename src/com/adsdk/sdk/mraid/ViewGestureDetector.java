// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.adsdk.sdk.mraid:
//            AdAlertGestureListener

public class ViewGestureDetector extends GestureDetector
{

    private AdAlertGestureListener mAdAlertGestureListener;
    private UserClickListener mUserClickListener;
    private final View mView;

    public ViewGestureDetector(Context context, View view)
    {
        this(context, view, new AdAlertGestureListener(view));
    }

    private ViewGestureDetector(Context context, View view, AdAlertGestureListener adalertgesturelistener)
    {
        super(context, adalertgesturelistener);
        mAdAlertGestureListener = adalertgesturelistener;
        mView = view;
        setIsLongpressEnabled(false);
    }

    private boolean isMotionEventInView(MotionEvent motionevent, View view)
    {
        if (motionevent != null && view != null)
        {
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            if (f >= 0.0F && f <= (float)view.getWidth() && f1 >= 0.0F && f1 <= (float)view.getHeight())
            {
                return true;
            }
        }
        return false;
    }

    void resetAdFlaggingGesture()
    {
        mAdAlertGestureListener.reset();
    }

    void sendTouchEvent(MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return;

        case 1: // '\001'
            if (mUserClickListener != null)
            {
                mUserClickListener.onUserClick();
            } else
            {
                Log.d("MoPub", "View's onUserClick() is not registered.");
            }
            mAdAlertGestureListener.finishGestureDetection();
            return;

        case 0: // '\0'
            onTouchEvent(motionevent);
            return;

        case 2: // '\002'
            break;
        }
        if (isMotionEventInView(motionevent, mView))
        {
            onTouchEvent(motionevent);
            return;
        } else
        {
            resetAdFlaggingGesture();
            return;
        }
    }

    void setAdAlertGestureListener(AdAlertGestureListener adalertgesturelistener)
    {
        mAdAlertGestureListener = adalertgesturelistener;
    }

    void setUserClickListener(UserClickListener userclicklistener)
    {
        mUserClickListener = userclicklistener;
    }

    private class UserClickListener
    {

        public abstract void onResetUserClick();

        public abstract void onUserClick();

        public abstract boolean wasClicked();
    }

}
