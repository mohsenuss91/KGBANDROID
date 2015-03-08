// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.view.MotionEvent;
import android.view.View;

public class AdAlertGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
{

    private static int $SWITCH_TABLE$com$adsdk$sdk$mraid$AdAlertGestureListener$ZigZagState[];
    private static final float MAXIMUM_THRESHOLD_X_IN_DIPS = 100F;
    private static final float MAXIMUM_THRESHOLD_Y_IN_DIPS = 50F;
    private static final int MINIMUM_NUMBER_OF_ZIGZAGS_TO_FLAG = 4;
    private float mCurrentThresholdInDips;
    private ZigZagState mCurrentZigZagState;
    private boolean mHasCrossedLeftThreshold;
    private boolean mHasCrossedRightThreshold;
    private int mNumberOfZigZags;
    private float mPivotPositionX;
    private float mPreviousPositionX;

    static int[] $SWITCH_TABLE$com$adsdk$sdk$mraid$AdAlertGestureListener$ZigZagState()
    {
        int ai[] = $SWITCH_TABLE$com$adsdk$sdk$mraid$AdAlertGestureListener$ZigZagState;
        if (ai != null)
        {
            return ai;
        }
        int ai1[] = new int[ZigZagState.values().length];
        try
        {
            ai1[ZigZagState.FAILED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            ai1[ZigZagState.FINISHED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai1[ZigZagState.GOING_LEFT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai1[ZigZagState.GOING_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai1[ZigZagState.UNSET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        $SWITCH_TABLE$com$adsdk$sdk$mraid$AdAlertGestureListener$ZigZagState = ai1;
        return ai1;
    }

    AdAlertGestureListener(View view)
    {
        mCurrentThresholdInDips = 100F;
        mCurrentZigZagState = ZigZagState.UNSET;
        if (view != null && view.getWidth() > 0)
        {
            mCurrentThresholdInDips = Math.min(100F, (float)view.getWidth() / 3F);
        }
    }

    private void incrementNumberOfZigZags()
    {
        mNumberOfZigZags = 1 + mNumberOfZigZags;
        if (mNumberOfZigZags >= 4)
        {
            mCurrentZigZagState = ZigZagState.FINISHED;
        }
    }

    private boolean isMovingLeft(float f)
    {
        return f < mPreviousPositionX;
    }

    private boolean isMovingRight(float f)
    {
        return f > mPreviousPositionX;
    }

    private boolean isTouchOutOfBoundsOnYAxis(float f, float f1)
    {
        return Math.abs(f1 - f) > 50F;
    }

    private boolean leftThresholdReached(float f)
    {
        if (mHasCrossedLeftThreshold)
        {
            return true;
        }
        if (f <= mPivotPositionX - mCurrentThresholdInDips)
        {
            mHasCrossedRightThreshold = false;
            mHasCrossedLeftThreshold = true;
            incrementNumberOfZigZags();
            return true;
        } else
        {
            return false;
        }
    }

    private boolean rightThresholdReached(float f)
    {
        if (mHasCrossedRightThreshold)
        {
            return true;
        }
        if (f >= mPivotPositionX + mCurrentThresholdInDips)
        {
            mHasCrossedLeftThreshold = false;
            mHasCrossedRightThreshold = true;
            return true;
        } else
        {
            return false;
        }
    }

    private void updateInitialState(float f)
    {
        if (f > mPivotPositionX)
        {
            mCurrentZigZagState = ZigZagState.GOING_RIGHT;
        }
    }

    private void updateZag(float f)
    {
        if (leftThresholdReached(f) && isMovingRight(f))
        {
            mCurrentZigZagState = ZigZagState.GOING_RIGHT;
            mPivotPositionX = f;
        }
    }

    private void updateZig(float f)
    {
        if (rightThresholdReached(f) && isMovingLeft(f))
        {
            mCurrentZigZagState = ZigZagState.GOING_LEFT;
            mPivotPositionX = f;
        }
    }

    void finishGestureDetection()
    {
        reset();
    }

    ZigZagState getCurrentZigZagState()
    {
        return mCurrentZigZagState;
    }

    float getMinimumDipsInZigZag()
    {
        return mCurrentThresholdInDips;
    }

    int getNumberOfZigzags()
    {
        return mNumberOfZigZags;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (mCurrentZigZagState == ZigZagState.FINISHED)
        {
            return super.onScroll(motionevent, motionevent1, f, f1);
        }
        if (isTouchOutOfBoundsOnYAxis(motionevent.getY(), motionevent1.getY()))
        {
            mCurrentZigZagState = ZigZagState.FAILED;
            return super.onScroll(motionevent, motionevent1, f, f1);
        }
        $SWITCH_TABLE$com$adsdk$sdk$mraid$AdAlertGestureListener$ZigZagState()[mCurrentZigZagState.ordinal()];
        JVM INSTR tableswitch 1 3: default 88
    //                   1 106
    //                   2 125
    //                   3 136;
           goto _L1 _L2 _L3 _L4
_L1:
        mPreviousPositionX = motionevent1.getX();
        return super.onScroll(motionevent, motionevent1, f, f1);
_L2:
        mPivotPositionX = motionevent.getX();
        updateInitialState(motionevent1.getX());
        continue; /* Loop/switch isn't completed */
_L3:
        updateZig(motionevent1.getX());
        continue; /* Loop/switch isn't completed */
_L4:
        updateZag(motionevent1.getX());
        if (true) goto _L1; else goto _L5
_L5:
    }

    void reset()
    {
        mNumberOfZigZags = 0;
        mCurrentZigZagState = ZigZagState.UNSET;
    }

    private class ZigZagState extends Enum
    {

        private static final ZigZagState ENUM$VALUES[];
        public static final ZigZagState FAILED;
        public static final ZigZagState FINISHED;
        public static final ZigZagState GOING_LEFT;
        public static final ZigZagState GOING_RIGHT;
        public static final ZigZagState UNSET;

        public static ZigZagState valueOf(String s)
        {
            return (ZigZagState)Enum.valueOf(com/adsdk/sdk/mraid/AdAlertGestureListener$ZigZagState, s);
        }

        public static ZigZagState[] values()
        {
            ZigZagState azigzagstate[] = ENUM$VALUES;
            int i = azigzagstate.length;
            ZigZagState azigzagstate1[] = new ZigZagState[i];
            System.arraycopy(azigzagstate, 0, azigzagstate1, 0, i);
            return azigzagstate1;
        }

        static 
        {
            UNSET = new ZigZagState("UNSET", 0);
            GOING_RIGHT = new ZigZagState("GOING_RIGHT", 1);
            GOING_LEFT = new ZigZagState("GOING_LEFT", 2);
            FINISHED = new ZigZagState("FINISHED", 3);
            FAILED = new ZigZagState("FAILED", 4);
            ZigZagState azigzagstate[] = new ZigZagState[5];
            azigzagstate[0] = UNSET;
            azigzagstate[1] = GOING_RIGHT;
            azigzagstate[2] = GOING_LEFT;
            azigzagstate[3] = FINISHED;
            azigzagstate[4] = FAILED;
            ENUM$VALUES = azigzagstate;
        }

        private ZigZagState(String s, int i)
        {
            super(s, i);
        }
    }

}
