// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import java.util.List;

public interface YouTubePlayer
{

    public static final int FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE = 4;
    public static final int FULLSCREEN_FLAG_CONTROL_ORIENTATION = 1;
    public static final int FULLSCREEN_FLAG_CONTROL_SYSTEM_UI = 2;
    public static final int FULLSCREEN_FLAG_CUSTOM_LAYOUT = 8;

    public abstract void addFullscreenControlFlag(int i);

    public abstract void cuePlaylist(String s);

    public abstract void cuePlaylist(String s, int i, int j);

    public abstract void cueVideo(String s);

    public abstract void cueVideo(String s, int i);

    public abstract void cueVideos(List list);

    public abstract void cueVideos(List list, int i, int j);

    public abstract int getCurrentTimeMillis();

    public abstract int getDurationMillis();

    public abstract int getFullscreenControlFlags();

    public abstract boolean hasNext();

    public abstract boolean hasPrevious();

    public abstract boolean isPlaying();

    public abstract void loadPlaylist(String s);

    public abstract void loadPlaylist(String s, int i, int j);

    public abstract void loadVideo(String s);

    public abstract void loadVideo(String s, int i);

    public abstract void loadVideos(List list);

    public abstract void loadVideos(List list, int i, int j);

    public abstract void next();

    public abstract void pause();

    public abstract void play();

    public abstract void previous();

    public abstract void release();

    public abstract void seekRelativeMillis(int i);

    public abstract void seekToMillis(int i);

    public abstract void setFullscreen(boolean flag);

    public abstract void setFullscreenControlFlags(int i);

    public abstract void setManageAudioFocus(boolean flag);

    public abstract void setOnFullscreenListener(OnFullscreenListener onfullscreenlistener);

    public abstract void setPlaybackEventListener(PlaybackEventListener playbackeventlistener);

    public abstract void setPlayerStateChangeListener(PlayerStateChangeListener playerstatechangelistener);

    public abstract void setPlayerStyle(PlayerStyle playerstyle);

    public abstract void setPlaylistEventListener(PlaylistEventListener playlisteventlistener);

    public abstract void setShowFullscreenButton(boolean flag);
}
