// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;


public interface 
{

    public abstract void onAdStarted();

    public abstract void onError( );

    public abstract void onLoaded(String s);

    public abstract void onLoading();

    public abstract void onVideoEnded();

    public abstract void onVideoStarted();
}
