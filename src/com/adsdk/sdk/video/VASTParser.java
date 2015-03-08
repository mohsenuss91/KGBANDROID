// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import com.adsdk.sdk.Log;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

// Referenced classes of package com.adsdk.sdk.video:
//            VAST, VideoData

public class VASTParser
{

    private static final Pattern DURATION_PATTERN = Pattern.compile("^([0-5]?\\d):([0-5]?\\d):([0-5]?\\d)(?:\\.(\\d?\\d?\\d))?$");
    private static final Pattern PERCENT_PATTERN = Pattern.compile("^(\\d?\\d?)%$");

    public VASTParser()
    {
    }

    public static VAST createVastFromStream(InputStream inputstream)
    {
        Persister persister = new Persister();
        VAST vast;
        try
        {
            vast = (VAST)persister.read(com/adsdk/sdk/video/VAST, inputstream);
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            notfoundexception.printStackTrace();
            return null;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return vast;
    }

    public static VAST createVastFromString(String s)
    {
        Persister persister = new Persister();
        VAST vast;
        try
        {
            vast = (VAST)persister.read(com/adsdk/sdk/video/VAST, s);
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            notfoundexception.printStackTrace();
            return null;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return vast;
    }

    public static VideoData fillVideoDataFromVast(VAST vast)
    {
        VAST.Ad.Creative.NonLinearAds nonlinearads = null;
        if (vast != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        VideoData videodata;
        Iterator iterator;
        Object obj;
        Object obj1;
        Object obj2;
        videodata = new VideoData();
        iterator = vast.ads.iterator();
        obj = null;
        obj1 = null;
        obj2 = null;
_L16:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        VAST.Ad.Creative creative1;
        VAST.Ad ad1;
        VAST.Ad.Creative.Linear.MediaFile mediafile1;
        mediafile1 = obj;
        ad1 = obj1;
        creative1 = obj2;
_L20:
        if (mediafile1 == null) goto _L1; else goto _L5
_L5:
        Iterator iterator2;
        Iterator iterator3;
        VAST.Ad.Creative.NonLinearAds.NonLinear nonlinear;
        Iterator iterator4;
        videodata.setSequence(creative1.sequence);
        videodata.orientation = 4;
        VAST.Ad ad;
        Iterator iterator1;
        VAST.Ad.Creative creative;
        VAST.Ad.Creative.Linear.MediaFile mediafile;
        Object aobj[];
        String s;
        if (mediafile1.delivery != null && mediafile1.delivery.contains("streaming"))
        {
            videodata.delivery = 1;
        } else
        {
            videodata.delivery = 0;
        }
        videodata.display = 0;
        videodata.type = mediafile1.type;
        if (mediafile1.bitrate != null)
        {
            videodata.bitrate = Integer.parseInt(mediafile1.bitrate);
        }
        videodata.width = mediafile1.width;
        videodata.height = mediafile1.height;
        videodata.videoUrl = mediafile1.url;
        if (creative1.linear.duration != null)
        {
            videodata.duration = getDurationFromString(creative1.linear.duration);
        }
        videodata.showSkipButton = true;
        if (creative1.linear.skipoffset != null)
        {
            videodata.showSkipButtonAfter = getSkipoffsetFromString(creative1.linear.skipoffset, videodata.duration);
        }
        getTrackingEvents(videodata, creative1.linear.trackingEvents);
        iterator2 = ad1.inLine.impressions.iterator();
_L24:
        if (iterator2.hasNext()) goto _L7; else goto _L6
_L6:
        if (creative1.linear.videoClicks == null || creative1.linear.videoClicks.clickThrough == null) goto _L9; else goto _L8
_L8:
        if (creative1.linear.videoClicks.clickTracking == null) goto _L11; else goto _L10
_L10:
        videodata.videoClickTracking = new ArrayList();
        iterator4 = creative1.linear.videoClicks.clickTracking.iterator();
_L25:
        if (iterator4.hasNext()) goto _L12; else goto _L11
_L11:
        videodata.videoClickThrough = creative1.linear.videoClicks.clickThrough;
_L9:
        iterator3 = ad1.inLine.creatives.iterator();
_L27:
        if (iterator3.hasNext()) goto _L14; else goto _L13
_L13:
        nonlinear = null;
_L28:
        if (nonlinear != null)
        {
            videodata.overlayClickThrough = nonlinear.nonLinearClickThrough;
            videodata.overlayClickTracking = nonlinear.nonLinearClickTracking.trim();
            videodata.overlayHeight = nonlinear.height;
            videodata.overlayWidth = nonlinear.width;
            videodata.showHtmlOverlayAfter = 0;
            videodata.showHtmlOverlay = true;
            if (nonlinear.staticResource != null)
            {
                videodata.htmlOverlayType = 1;
                VAST.Ad.Impression impression;
                VAST.Ad.Creative creative2;
                VAST.Ad.Creative.Linear.ClickTracking clicktracking;
                if (nonlinear.staticResource.type.contains("image"))
                {
                    aobj = new Object[3];
                    aobj[0] = nonlinear.staticResource.url.trim();
                    aobj[1] = Integer.valueOf(nonlinear.width);
                    aobj[2] = Integer.valueOf(nonlinear.height);
                    s = MessageFormat.format("<body style='\"'margin: 0px; padding: 0px; text-align:center;'\"'><img src='\"'{0}'\"' width='\"'{1}'dp\"' height='\"'{2}'dp\"'/></body>", aobj);
                    videodata.htmlOverlayMarkup = (new StringBuilder("<style>* { -webkit-tap-highlight-color: rgba(0,0,0,0);} img {width:100%;height:100%}</style>")).append(s).toString();
                } else
                if (nonlinear.staticResource.type.contains("x-javascript"))
                {
                    videodata.htmlOverlayMarkup = (new StringBuilder("<script src=\"")).append(nonlinear.staticResource.url.trim()).append("\"></script>").toString();
                }
            } else
            if (nonlinear.iframeResource != null)
            {
                videodata.htmlOverlayType = 0;
                videodata.htmlOverlayUrl = nonlinear.iframeResource;
            } else
            if (nonlinear.htmlResource != null)
            {
                videodata.htmlOverlayType = 1;
                videodata.htmlOverlayMarkup = nonlinear.htmlResource;
            }
            getTrackingEvents(videodata, nonlinearads.trackingEvents);
        }
        return videodata;
_L4:
        ad = (VAST.Ad)iterator.next();
        if (ad.inLine == null) goto _L16; else goto _L15
_L15:
        iterator1 = ad.inLine.creatives.iterator();
_L22:
        if (iterator1.hasNext()) goto _L18; else goto _L17
_L17:
        mediafile1 = obj;
        ad1 = obj1;
        creative1 = obj2;
_L23:
        if (creative1 != null) goto _L20; else goto _L19
_L19:
        obj1 = ad1;
        obj2 = creative1;
        obj = mediafile1;
          goto _L16
_L18:
        creative = (VAST.Ad.Creative)iterator1.next();
        if (creative.linear == null || creative.linear.mediaFiles == null || creative.linear.mediaFiles.isEmpty()) goto _L22; else goto _L21
_L21:
        mediafile = (VAST.Ad.Creative.Linear.MediaFile)creative.linear.mediaFiles.get(0);
        creative1 = creative;
        ad1 = ad;
        mediafile1 = mediafile;
          goto _L23
_L7:
        impression = (VAST.Ad.Impression)iterator2.next();
        videodata.impressionEvents.add(impression.url);
          goto _L24
_L12:
        clicktracking = (VAST.Ad.Creative.Linear.ClickTracking)iterator4.next();
        videodata.videoClickTracking.add(clicktracking.url);
          goto _L25
_L14:
        creative2 = (VAST.Ad.Creative)iterator3.next();
        if (creative2.nonLinearAds == null || creative2.nonLinearAds.nonLinears == null || creative2.nonLinearAds.nonLinears.isEmpty()) goto _L27; else goto _L26
_L26:
        nonlinear = (VAST.Ad.Creative.NonLinearAds.NonLinear)creative2.nonLinearAds.nonLinears.get(0);
        nonlinearads = creative2.nonLinearAds;
          goto _L28
    }

    public static int getDurationFromString(String s)
    {
        Matcher matcher = DURATION_PATTERN.matcher(s);
        if (matcher.find() && matcher.groupCount() == 4)
        {
            int i;
            int j;
            int k;
            try
            {
                i = Integer.parseInt(matcher.group(1));
                j = Integer.parseInt(matcher.group(2));
                k = Integer.parseInt(matcher.group(3));
            }
            catch (NumberFormatException numberformatexception)
            {
                Log.e((new StringBuilder("Failed to parse duration: ")).append(s).toString());
                return 0;
            }
            return k + j * 60 + i * 3600;
        } else
        {
            Log.e((new StringBuilder("Failed to parse duration: ")).append(s).toString());
            return 0;
        }
    }

    private static int getSkipoffsetFromString(String s, int i)
    {
        int j = 0;
        if (s != null)
        {
            Matcher matcher = DURATION_PATTERN.matcher(s);
            Matcher matcher1 = PERCENT_PATTERN.matcher(s);
            if (matcher.find() && matcher.groupCount() == 4)
            {
                int i1;
                int j1;
                int k1;
                try
                {
                    i1 = Integer.parseInt(matcher.group(1));
                    j1 = Integer.parseInt(matcher.group(2));
                    k1 = Integer.parseInt(matcher.group(3));
                }
                catch (NumberFormatException numberformatexception1)
                {
                    Log.e((new StringBuilder("Failed to parse skipoffset: ")).append(s).toString());
                    return 0;
                }
                j = k1 + j1 * 60 + i1 * 3600;
            } else
            {
                boolean flag = matcher1.find();
                j = 0;
                if (flag)
                {
                    int k = matcher1.groupCount();
                    j = 0;
                    if (k == 1)
                    {
                        long l;
                        try
                        {
                            l = ((long)Integer.parseInt(matcher1.group(1)) * (long)i) / 100L;
                        }
                        catch (NumberFormatException numberformatexception)
                        {
                            Log.e((new StringBuilder("Failed to parse skipoffset: ")).append(s).toString());
                            return 0;
                        }
                        return (int)l;
                    }
                }
            }
        }
        return j;
    }

    public static void getTrackingEvents(VideoData videodata, List list)
    {
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            VAST.Ad.Creative.Tracking tracking = (VAST.Ad.Creative.Tracking)iterator.next();
            String s = tracking.event;
            if (s.equals("start") || s.equals("creativeView"))
            {
                videodata.startEvents.add(tracking.url);
            } else
            if (s.equals("complete"))
            {
                videodata.completeEvents.add(tracking.url);
            } else
            if (s.equals("mute"))
            {
                videodata.muteEvents.add(tracking.url);
            } else
            if (s.equals("unmute"))
            {
                videodata.unmuteEvents.add(tracking.url);
            } else
            if (s.equals("pause"))
            {
                videodata.pauseEvents.add(tracking.url);
            } else
            if (s.equals("resume"))
            {
                videodata.resumeEvents.add(tracking.url);
            } else
            if (s.equals("skip") || s.equals("close"))
            {
                videodata.skipEvents.add(tracking.url);
            } else
            if (s.equals("firstQuartile"))
            {
                int k = videodata.duration / 4;
                Vector vector2 = (Vector)videodata.timeTrackingEvents.get(Integer.valueOf(k));
                if (vector2 == null)
                {
                    vector2 = new Vector();
                    videodata.timeTrackingEvents.put(Integer.valueOf(k), vector2);
                }
                vector2.add(tracking.url);
            } else
            if (s.equals("midpoint"))
            {
                int j = videodata.duration / 2;
                Vector vector1 = (Vector)videodata.timeTrackingEvents.get(Integer.valueOf(j));
                if (vector1 == null)
                {
                    vector1 = new Vector();
                    videodata.timeTrackingEvents.put(Integer.valueOf(j), vector1);
                }
                vector1.add(tracking.url);
            } else
            if (s.equals("thirdQuartile"))
            {
                int i = (3 * videodata.duration) / 4;
                Vector vector = (Vector)videodata.timeTrackingEvents.get(Integer.valueOf(i));
                if (vector == null)
                {
                    vector = new Vector();
                    videodata.timeTrackingEvents.put(Integer.valueOf(i), vector);
                }
                vector.add(tracking.url);
            }
        } while (true);
    }

}
