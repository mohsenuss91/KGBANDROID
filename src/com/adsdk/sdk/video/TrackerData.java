// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import java.io.Serializable;

public class TrackerData
    implements Serializable
{

    public static final int TYPE_COMPLETE = 1;
    public static final int TYPE_FIRSTQUARTILE = 3;
    public static final int TYPE_MIDPOINT = 2;
    public static final int TYPE_MUTE = 8;
    public static final int TYPE_PAUSE = 6;
    public static final int TYPE_REPLAY = 11;
    public static final int TYPE_SKIP = 10;
    public static final int TYPE_START = 0;
    public static final int TYPE_THIRDQUARTILE = 4;
    public static final int TYPE_TIME = 5;
    public static final int TYPE_UNMUTE = 9;
    public static final int TYPE_UNPAUSE = 7;
    private static final long serialVersionUID = 0x834a47c57e2245eaL;
    int time;
    int type;
    String url;

    public TrackerData()
    {
    }

    public void reset()
    {
        url = null;
        type = -1;
        time = -1;
    }
}
