// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.millennialmedia.google.gson.Gson;
import java.util.HashMap;

class scaleFactor
{

    boolean autoPlay;
    int bodyHeight;
    int bodyWidth;
    String cachedVideoID;
    String cachedVideoURI;
    int currentPosition;
    boolean goingFullScreen;
    int height;
    boolean isCompleted;
    boolean isInitialPlayBack;
    boolean isPlayingStreaming;
    boolean isStopped;
    int originalOrientation;
    float scaleFactor;
    boolean showControls;
    String streamVideoURI;
    String touchCallBack;
    int width;
    int x;
    int y;

    static scaleFactor getInlineParams(String s)
    {
        return (scaleFactor)(new Gson()).fromJson(s, com/millennialmedia/android/InlineVideoView$InlineParams);
    }

    void inflateFromGson(String s)
    {
        scaleFactor scalefactor = (scaleFactor)(new Gson()).fromJson(s, com/millennialmedia/android/InlineVideoView$InlineParams);
        x = scalefactor.x;
        y = scalefactor.y;
        bodyWidth = scalefactor.bodyWidth;
        bodyHeight = scalefactor.bodyHeight;
        width = scalefactor.width;
        height = scalefactor.height;
        currentPosition = scalefactor.currentPosition;
        streamVideoURI = scalefactor.streamVideoURI;
        cachedVideoURI = scalefactor.cachedVideoURI;
        cachedVideoID = scalefactor.cachedVideoID;
        touchCallBack = scalefactor.touchCallBack;
        autoPlay = scalefactor.autoPlay;
        showControls = scalefactor.showControls;
        isInitialPlayBack = scalefactor.isInitialPlayBack;
        scaleFactor = scalefactor.scaleFactor;
        goingFullScreen = scalefactor.goingFullScreen;
        originalOrientation = scalefactor.originalOrientation;
        isCompleted = scalefactor.isCompleted;
        isCompleted((new StringBuilder("gson*****")).append(s).toString());
        isCompleted((new StringBuilder("PARAMS*****")).append(scalefactor).toString());
    }

    public String toString()
    {
        Object aobj[] = new Object[7];
        aobj[0] = cachedVideoID;
        aobj[1] = Integer.valueOf(x);
        aobj[2] = Integer.valueOf(y);
        aobj[3] = Integer.valueOf(bodyWidth);
        aobj[4] = Integer.valueOf(bodyHeight);
        aobj[5] = Integer.valueOf(currentPosition);
        aobj[6] = Boolean.valueOf(autoPlay);
        return String.format("%s id, %d x, %d y, %d bWidth, %d bHeight, %d pos, %b autoPlay", aobj);
    }

    (HashMap hashmap, Context context)
    {
        isInitialPlayBack = true;
        if (hashmap.get("x") != null)
        {
            x = (int)Float.parseFloat((String)hashmap.get("x"));
        }
        if (hashmap.get("y") != null)
        {
            y = (int)Float.parseFloat((String)hashmap.get("y"));
        }
        if (hashmap.get("width") != null)
        {
            width = (int)Float.parseFloat((String)hashmap.get("width"));
        }
        if (hashmap.get("height") != null)
        {
            height = (int)Float.parseFloat((String)hashmap.get("height"));
        }
        streamVideoURI = (String)hashmap.get("streamVideoURI");
        cachedVideoURI = (String)hashmap.get("cachedVideoURI");
        cachedVideoID = (String)hashmap.get("cachedVideoID");
        if (hashmap.get("autoPlay") != null)
        {
            autoPlay = Boolean.parseBoolean((String)hashmap.get("autoPlay"));
        }
        if (hashmap.get("showControls") != null)
        {
            showControls = Boolean.parseBoolean((String)hashmap.get("showControls"));
        }
        if (hashmap.get("bodyWidth") != null)
        {
            bodyWidth = (int)Float.parseFloat((String)hashmap.get("bodyWidth"));
        }
        if (hashmap.get("bodyHeight") != null)
        {
            bodyHeight = (int)Float.parseFloat((String)hashmap.get("bodyHeight"));
        }
        touchCallBack = (String)hashmap.get("touchCallback");
        scaleFactor = context.getResources().getDisplayMetrics().density;
    }
}
