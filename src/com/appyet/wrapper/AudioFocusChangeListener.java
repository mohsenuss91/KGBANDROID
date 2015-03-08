// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.wrapper;

import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.as;

public class AudioFocusChangeListener
    implements android.media.AudioManager.OnAudioFocusChangeListener
{

    private ApplicationContext mApplicationContext;
    private boolean mWasPaused;

    public AudioFocusChangeListener(ApplicationContext applicationcontext)
    {
        mWasPaused = false;
        mApplicationContext = applicationcontext;
    }

    public void AudioFocus(int i)
    {
        i;
        JVM INSTR tableswitch -3 1: default 36
    //                   -3 179
    //                   -2 144
    //                   -1 107
    //                   0 36
    //                   1 37;
           goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
        return;
_L5:
        try
        {
            if (mWasPaused && !mApplicationContext.c.g() && mApplicationContext.c.m() && mApplicationContext.c.f() != null)
            {
                mApplicationContext.c.j();
            }
            mWasPaused = false;
            return;
        }
        catch (Exception exception3)
        {
            d.a(exception3);
        }
        return;
_L4:
        if (!mApplicationContext.c.g()) goto _L1; else goto _L6
_L6:
        mApplicationContext.c.h();
        mWasPaused = true;
        return;
        Exception exception2;
        exception2;
        d.a(exception2);
        return;
_L3:
        if (!mApplicationContext.c.g()) goto _L1; else goto _L7
_L7:
        mApplicationContext.c.h();
        mWasPaused = true;
        return;
        Exception exception1;
        exception1;
        d.a(exception1);
        return;
_L2:
        if (!mApplicationContext.c.g()) goto _L1; else goto _L8
_L8:
        mApplicationContext.c.h();
        mWasPaused = true;
        return;
        Exception exception;
        exception;
        d.a(exception);
        return;
    }

    public void onAudioFocusChange(int i)
    {
        AudioFocus(i);
    }
}
