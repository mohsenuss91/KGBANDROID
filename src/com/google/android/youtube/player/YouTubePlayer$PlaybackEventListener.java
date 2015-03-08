// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;


public interface 
{

    public abstract void onBuffering(boolean flag);

    public abstract void onPaused();

    public abstract void onPlaying();

    public abstract void onSeekTo(int i);

    public abstract void onStopped();
}
