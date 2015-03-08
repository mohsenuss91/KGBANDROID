// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.os.Parcel;

// Referenced classes of package com.inmobi.re.controller:
//            b

public class le extends le
{

    public static final android.os.yerProperties.showControl CREATOR = new b();
    public boolean audioMuted;
    public boolean autoPlay;
    public boolean doLoop;
    public String id;
    public boolean showControl;
    public String startStyle;
    public String stopStyle;

    public boolean doLoop()
    {
        return doLoop;
    }

    public boolean doMute()
    {
        return audioMuted;
    }

    public boolean exitOnComplete()
    {
        return stopStyle.equalsIgnoreCase("exit");
    }

    public boolean isAutoPlay()
    {
        return autoPlay;
    }

    public boolean isFullScreen()
    {
        return startStyle.equalsIgnoreCase("fullscreen");
    }

    public void setFullScreen()
    {
        startStyle = "fullscreen";
    }

    public void setProperties(boolean flag, boolean flag1, boolean flag2, boolean flag3, String s, String s1, String s2)
    {
        autoPlay = flag1;
        showControl = flag2;
        doLoop = flag3;
        audioMuted = flag;
        startStyle = s;
        stopStyle = s1;
        id = s2;
    }

    public void setStopStyle(String s)
    {
        stopStyle = s;
    }

    public boolean showControl()
    {
        return showControl;
    }


    public le()
    {
        showControl = true;
        autoPlay = true;
        audioMuted = false;
        doLoop = false;
        stopStyle = "normal";
        startStyle = "normal";
        id = "";
    }

    public id(Parcel parcel)
    {
        super(parcel);
    }
}
