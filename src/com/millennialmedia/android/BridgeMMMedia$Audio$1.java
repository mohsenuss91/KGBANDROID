// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.MediaPlayer;

class this._cls0
    implements android.media.onListener
{

    final this._cls0 this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        this;
        JVM INSTR monitorenter ;
        if (cess._mth100(this._cls0.this) != null)
        {
            cess._mth100(this._cls0.this).release();
            cess._mth102(this._cls0.this, null);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
