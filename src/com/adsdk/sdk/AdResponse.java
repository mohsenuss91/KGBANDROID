// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;

import com.adsdk.sdk.data.ClickType;
import com.adsdk.sdk.video.VideoData;
import java.util.List;

// Referenced classes of package com.adsdk.sdk:
//            Ad

public class AdResponse
    implements Ad
{

    public static final String OTHER = "other";
    public static final String WEB = "web";
    private static final long serialVersionUID = 0x2d684300784e9155L;
    private int bannerHeight;
    private int bannerWidth;
    private ClickType clickType;
    private String clickUrl;
    private List customEvents;
    private boolean horizontalOrientationRequested;
    private String imageUrl;
    private int refresh;
    private boolean scale;
    private int skipOverlay;
    private boolean skipPreflight;
    private String text;
    private long timestamp;
    private int type;
    private String urlType;
    private VideoData videoData;

    public AdResponse()
    {
        skipOverlay = 0;
    }

    public int getBannerHeight()
    {
        return bannerHeight;
    }

    public int getBannerWidth()
    {
        return bannerWidth;
    }

    public ClickType getClickType()
    {
        return clickType;
    }

    public String getClickUrl()
    {
        return clickUrl;
    }

    public List getCustomEvents()
    {
        return customEvents;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public int getRefresh()
    {
        return refresh;
    }

    public int getSkipOverlay()
    {
        return skipOverlay;
    }

    public String getText()
    {
        return text;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public int getType()
    {
        return type;
    }

    public String getUrlType()
    {
        return urlType;
    }

    public VideoData getVideoData()
    {
        return videoData;
    }

    public boolean isHorizontalOrientationRequested()
    {
        return horizontalOrientationRequested;
    }

    public boolean isScale()
    {
        return scale;
    }

    public boolean isSkipPreflight()
    {
        return skipPreflight;
    }

    public void setBannerHeight(int i)
    {
        bannerHeight = i;
    }

    public void setBannerWidth(int i)
    {
        bannerWidth = i;
    }

    public void setClickType(ClickType clicktype)
    {
        clickType = clicktype;
    }

    public void setClickUrl(String s)
    {
        clickUrl = s;
    }

    public void setCustomEvents(List list)
    {
        customEvents = list;
    }

    public void setHorizontalOrientationRequested(boolean flag)
    {
        horizontalOrientationRequested = flag;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setRefresh(int i)
    {
        refresh = i;
    }

    public void setScale(boolean flag)
    {
        scale = flag;
    }

    public void setSkipOverlay(int i)
    {
        skipOverlay = i;
    }

    public void setSkipPreflight(boolean flag)
    {
        skipPreflight = flag;
    }

    public void setText(String s)
    {
        text = s;
    }

    public void setTimestamp(long l)
    {
        timestamp = l;
    }

    public void setType(int i)
    {
        type = i;
    }

    public void setUrlType(String s)
    {
        urlType = s;
    }

    public void setVideoData(VideoData videodata)
    {
        videoData = videodata;
    }

    public String toString()
    {
        return (new StringBuilder("Response [refresh=")).append(refresh).append(", type=").append(type).append(", bannerWidth=").append(bannerWidth).append(", bannerHeight=").append(bannerHeight).append(", text=").append(text).append(", imageUrl=").append(imageUrl).append(", clickType=").append(clickType).append(", clickUrl=").append(clickUrl).append(", urlType=").append(urlType).append(", scale=").append(scale).append(", skipPreflight=").append(skipPreflight).append("]").toString();
    }
}
