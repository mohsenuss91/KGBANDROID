// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class VideoData
    implements Serializable
{

    public static final int DELIVERY_PROGRESSIVE = 0;
    public static final int DELIVERY_STREAMING = 1;
    public static final int DISPLAY_FULLSCREEN = 0;
    public static final int DISPLAY_NORMAL = 1;
    public static final int OVERLAY_MARKUP = 1;
    public static final int OVERLAY_URL = 0;
    private static final long serialVersionUID = 0x2f38a3ba906eb8a2L;
    boolean allowTapNavigationBars;
    int bitrate;
    String bottomNavigationBarBackground;
    Vector completeEvents;
    int delivery;
    int display;
    int duration;
    int height;
    String htmlOverlayMarkup;
    int htmlOverlayType;
    String htmlOverlayUrl;
    Vector icons;
    Vector impressionEvents;
    Vector muteEvents;
    int orientation;
    String overlayClickThrough;
    String overlayClickTracking;
    int overlayHeight;
    int overlayWidth;
    String pauseButtonImage;
    Vector pauseEvents;
    String playButtonImage;
    String replayButtonImage;
    Vector replayEvents;
    Vector resumeEvents;
    private int sequence;
    boolean showBottomNavigationBar;
    boolean showHtmlOverlay;
    int showHtmlOverlayAfter;
    boolean showNavigationBars;
    boolean showPauseButton;
    boolean showReplayButton;
    boolean showSkipButton;
    int showSkipButtonAfter;
    boolean showTimer;
    boolean showTopNavigationBar;
    String skipButtonImage;
    Vector skipEvents;
    Vector startEvents;
    HashMap timeTrackingEvents;
    String topNavigationBarBackground;
    String type;
    Vector unmuteEvents;
    String videoClickThrough;
    List videoClickTracking;
    String videoUrl;
    int width;

    public VideoData()
    {
        icons = new Vector();
        timeTrackingEvents = new HashMap();
        startEvents = new Vector();
        impressionEvents = new Vector();
        completeEvents = new Vector();
        muteEvents = new Vector();
        unmuteEvents = new Vector();
        pauseEvents = new Vector();
        resumeEvents = new Vector();
        skipEvents = new Vector();
        replayEvents = new Vector();
        showHtmlOverlay = false;
    }

    public Vector getCompleteEvents()
    {
        return completeEvents;
    }

    public int getSequence()
    {
        return sequence;
    }

    public Vector getStartEvents()
    {
        return startEvents;
    }

    public void setCompleteEvents(Vector vector)
    {
        completeEvents = vector;
    }

    public void setSequence(int i)
    {
        sequence = i;
    }

    public void setStartEvents(Vector vector)
    {
        startEvents = vector;
    }

    public String toString()
    {
        return (new StringBuilder("VideoData \n[\norientation=")).append(orientation).append(",\ndisplay=").append(display).append(",\ndelivery=").append(delivery).append(",\ntype=").append(type).append(",\nbitrate=").append(bitrate).append(",\nwidth=").append(width).append(",\nheight=").append(height).append(",\nvideoUrl=").append(videoUrl).append(",\nduration=").append(duration).append(",\nshowSkipButton=").append(showSkipButton).append(",\nshowSkipButtonAfter=").append(showSkipButtonAfter).append(",\nskipButtonImage=").append(skipButtonImage).append(",\nshowNavigationBars=").append(showNavigationBars).append(",\nallowTapNavigationBars=").append(allowTapNavigationBars).append(",\nshowTopNavigationBar=").append(showTopNavigationBar).append(",\ntopNavigationBarBackground=").append(topNavigationBarBackground).append(",\nshowBottomNavigationBar=").append(showBottomNavigationBar).append(",\nbottomNavigationBarBackground=").append(bottomNavigationBarBackground).append(",\nshowPauseButton=").append(showPauseButton).append(",\npauseButtonImage=").append(pauseButtonImage).append(",\nplayButtonImage=").append(playButtonImage).append(",\nshowReplayButton=").append(showReplayButton).append(",\nreplayButtonImage=").append(replayButtonImage).append(",\nshowTimer=").append(showTimer).append(",\nicons=").append(icons).append(",\ntimeTrackingEvents=").append(timeTrackingEvents).append(",\nstartEvents=").append(getStartEvents()).append(",\ncompleteEvents=").append(getCompleteEvents()).append(",\nmuteEvents=").append(muteEvents).append(",\nunmuteEvents=").append(unmuteEvents).append(",\npauseEvents=").append(pauseEvents).append(",\nunpauseEvents=").append(resumeEvents).append(",\nskipEvents=").append(skipEvents).append(",\nreplayEvents=").append(replayEvents).append(",\nshowHtmlOverlay=").append(showHtmlOverlay).append(",\nshowHtmlOverlayAfter=").append(showHtmlOverlayAfter).append(",\nhtmlOverlayType=").append(htmlOverlayType).append(",\nhtmlOverlayUrl=").append(htmlOverlayUrl).append(",\nhtmlOverlayMarkup=").append(htmlOverlayMarkup).append("\n]").toString();
    }
}
