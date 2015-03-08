// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;


public interface YouTubeThumbnailLoader
{

    public abstract void first();

    public abstract boolean hasNext();

    public abstract boolean hasPrevious();

    public abstract void next();

    public abstract void previous();

    public abstract void release();

    public abstract void setOnThumbnailLoadedListener(OnThumbnailLoadedListener onthumbnailloadedlistener);

    public abstract void setPlaylist(String s);

    public abstract void setPlaylist(String s, int i);

    public abstract void setVideo(String s);
}
