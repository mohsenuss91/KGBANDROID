// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import java.lang.ref.WeakReference;

class LoadCompleteListener extends LoadCompleteListener
{

    final this._cls0 this$0;

    public void onLoadComplete(SoundPool soundpool, int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (soundpool == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        AudioManager audiomanager = (AudioManager)((Context)cess._mth200(this._cls0.this).get()).getSystemService("audio");
        float f = (0.0F + (float)audiomanager.getStreamVolume(3)) / (float)audiomanager.getStreamMaxVolume(3);
        soundpool.play(i, f, f, 1, 0, 1.0F);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    LoadCompleteListener(SoundPool soundpool)
    {
        this$0 = this._cls0.this;
        super(LoadCompleteListener.this, soundpool);
    }
}
