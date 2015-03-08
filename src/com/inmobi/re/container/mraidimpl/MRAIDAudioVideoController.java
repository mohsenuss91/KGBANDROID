// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.AVPlayer;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDExpandController

public class MRAIDAudioVideoController
{

    private IMWebView a;
    public Hashtable audioPlayerList;
    public AVPlayer audioplayer;
    public AVPlayer videoPlayer;
    public Hashtable videoPlayerList;
    public int videoValidateWidth;

    public MRAIDAudioVideoController(IMWebView imwebview)
    {
        videoPlayerList = new Hashtable();
        audioPlayerList = new Hashtable();
        a = imwebview;
    }

    static IMWebView a(MRAIDAudioVideoController mraidaudiovideocontroller)
    {
        return mraidaudiovideocontroller.a;
    }

    private AVPlayer a(String s)
    {
        if (!videoPlayerList.isEmpty())
        {
            return (AVPlayer)videoPlayerList.get(s);
        } else
        {
            return null;
        }
    }

    private void a(AVPlayer avplayer, com.inmobi.re.controller.JSController.Dimensions dimensions)
    {
        int i = (int)(-99999F * a.getDensity());
        if (avplayer.isInlineVideo())
        {
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(dimensions.width, dimensions.height);
            android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)avplayer.getLayoutParams();
            if (dimensions.x == i && dimensions.y == i)
            {
                layoutparams.leftMargin = layoutparams1.leftMargin;
                layoutparams.topMargin = layoutparams1.topMargin;
            } else
            {
                layoutparams.leftMargin = dimensions.x;
                layoutparams.topMargin = dimensions.y;
            }
            layoutparams.gravity = 3;
            avplayer.setLayoutParams(layoutparams);
        }
    }

    private boolean a(String s, String s1, Activity activity)
    {
        if (!audioPlayerList.isEmpty())
        {
            audioplayer = (AVPlayer)audioPlayerList.get(s);
            if (audioplayer == null)
            {
                if (audioPlayerList.size() > 4)
                {
                    a.raiseError("Too many audio players", "playAudio");
                    return false;
                }
                audioplayer = new AVPlayer(activity, a);
            } else
            if (audioplayer.getMediaURL().equals(s1) || s1.length() == 0)
            {
                if (audioplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.PLAYING)
                {
                    return false;
                }
                if (audioplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT)
                {
                    if (audioplayer.isPrepared())
                    {
                        audioplayer.start();
                    } else
                    {
                        audioplayer.setAutoPlay(true);
                    }
                    return false;
                }
                if (audioplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.PAUSED)
                {
                    audioplayer.start();
                    return false;
                }
                com.inmobi.re.controller.JSController.PlayerProperties playerproperties = audioplayer.getProperties();
                String s2 = audioplayer.getMediaURL();
                audioplayer.releasePlayer(false);
                audioPlayerList.remove(s);
                audioplayer = new AVPlayer(activity, a);
                audioplayer.setPlayData(playerproperties, s2);
            } else
            {
                audioplayer.releasePlayer(false);
                audioPlayerList.remove(s);
                audioplayer = new AVPlayer(activity, a);
            }
        } else
        {
            audioplayer = new AVPlayer(activity, a);
        }
        return true;
    }

    private boolean a(String s, String s1, Activity activity, com.inmobi.re.controller.JSController.Dimensions dimensions)
    {
        com.inmobi.re.controller.util.AVPlayer.playerState playerstate;
        String s2;
        if (videoPlayer == null || !s.equalsIgnoreCase(videoPlayer.getPropertyID()))
        {
            return b(s, s1, activity);
        }
        playerstate = videoPlayer.getState();
        if (!s.equalsIgnoreCase(videoPlayer.getPropertyID()))
        {
            break MISSING_BLOCK_LABEL_256;
        }
        s2 = videoPlayer.getMediaURL();
        if (s1.length() != 0 && !s1.equalsIgnoreCase(s2)) goto _L2; else goto _L1
_L1:
        d.a[playerstate.ordinal()];
        JVM INSTR tableswitch 1 4: default 116
    //                   1 118
    //                   2 137
    //                   3 149
    //                   4 181;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        return false;
_L4:
        videoPlayer.start();
_L8:
        a(videoPlayer, dimensions);
        return false;
_L5:
        a(videoPlayer, dimensions);
        return false;
_L6:
        if (!videoPlayer.getProperties().doLoop())
        {
            videoPlayer.start();
        }
        a(videoPlayer, dimensions);
        return false;
_L7:
        if (videoPlayer.isPrepared())
        {
            videoPlayer.start();
        } else
        {
            videoPlayer.setAutoPlay(true);
        }
        if (true) goto _L8; else goto _L2
_L2:
        if (!URLUtil.isValidUrl(s1))
        {
            a.raiseError("Request must specify a valid URL", "playVideo");
            return false;
        }
        videoPlayer.releasePlayer(false);
        videoPlayer = new AVPlayer(activity, a);
        return true;
    }

    private boolean a(Hashtable hashtable, AVPlayer avplayer)
    {
        Iterator iterator = hashtable.entrySet().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        if (entry.getValue() != avplayer) goto _L4; else goto _L3
_L3:
        String s = (String)entry.getKey();
_L6:
        if (s != null)
        {
            audioPlayerList.remove(s);
            return true;
        } else
        {
            return false;
        }
_L2:
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean b(String s, String s1, Activity activity)
    {
        if (s1.length() != 0 && !URLUtil.isValidUrl(s1) || s1.length() == 0 && !videoPlayerList.containsKey(s))
        {
            a.raiseError("Request must specify a valid URL", "playVideo");
            return false;
        }
        if (videoPlayer != null)
        {
            videoPlayer.hide();
            videoPlayerList.put(videoPlayer.getPropertyID(), videoPlayer);
        }
        AVPlayer avplayer = a(s);
        if (avplayer == null)
        {
            videoPlayer = new AVPlayer(activity, a);
        } else
        {
            videoPlayer = avplayer;
        }
        if (s1.length() == 0)
        {
            videoPlayer.setPlayData(avplayer.getProperties(), avplayer.getMediaURL());
            videoPlayer.setPlayDimensions(avplayer.getPlayDimensions());
        }
        videoPlayerList.remove(s);
        return true;
    }

    public AVPlayer getCurrentAudioPlayer(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (audioplayer == null || !audioplayer.getPropertyID().equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        AVPlayer avplayer = audioplayer;
_L4:
        this;
        JVM INSTR monitorexit ;
        return avplayer;
_L2:
        boolean flag = audioPlayerList.isEmpty();
        avplayer = null;
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean flag1 = audioPlayerList.containsKey(s);
        avplayer = null;
        if (!flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        avplayer = (AVPlayer)audioPlayerList.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public AVPlayer getVideoPlayer(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (videoPlayer == null || !videoPlayer.getPropertyID().equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        AVPlayer avplayer = videoPlayer;
_L4:
        this;
        JVM INSTR monitorexit ;
        return avplayer;
_L2:
        boolean flag = videoPlayerList.isEmpty();
        avplayer = null;
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean flag1 = videoPlayerList.containsKey(s);
        avplayer = null;
        if (!flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        avplayer = (AVPlayer)videoPlayerList.get(s);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void hidePlayers()
    {
        Log.debug("[InMobi]-[RE]-4.4.1", "MRAIDAudioVideoController: hiding all players");
        if (videoPlayer != null && videoPlayer.getState() != com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            videoPlayerList.put(videoPlayer.getPropertyID(), videoPlayer);
            videoPlayer.hide();
        }
        Iterator iterator = audioPlayerList.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            AVPlayer avplayer = (AVPlayer)entry.getValue();
            switch (d.a[avplayer.getState().ordinal()])
            {
            case 2: // '\002'
                avplayer.pause();
                break;

            case 4: // '\004'
                avplayer.releasePlayer(false);
                audioPlayerList.remove(entry.getKey());
                break;
            }
        } while (true);
    }

    public void mediaPlayerReleased(AVPlayer avplayer)
    {
        if (avplayer == audioplayer)
        {
            audioplayer = null;
        }
        if (avplayer == videoPlayer)
        {
            videoPlayer = null;
        }
        if (a(audioPlayerList, avplayer))
        {
            return;
        } else
        {
            a(videoPlayerList, avplayer);
            return;
        }
    }

    public void playAudioImpl(Bundle bundle, Activity activity)
    {
        com.inmobi.re.controller.JSController.PlayerProperties playerproperties = (com.inmobi.re.controller.JSController.PlayerProperties)bundle.getParcelable("player_properties");
        String s = bundle.getString("expand_url");
        if (s == null)
        {
            s = "";
        }
        if (a(playerproperties.id, s, activity))
        {
            if (s.length() != 0 && !URLUtil.isValidUrl(s) || s.length() == 0 && !audioPlayerList.containsKey(playerproperties.id))
            {
                a.raiseError("Request must specify a valid URL", "playAudio");
                return;
            }
            if (audioplayer != null)
            {
                if (s.length() != 0)
                {
                    audioplayer.setPlayData(playerproperties, s);
                }
                audioPlayerList.put(playerproperties.id, audioplayer);
                FrameLayout framelayout = (FrameLayout)activity.findViewById(0x1020002);
                if (playerproperties.isFullScreen())
                {
                    android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
                    layoutparams.addRule(13);
                    audioplayer.setLayoutParams(layoutparams);
                    RelativeLayout relativelayout = new RelativeLayout(activity);
                    relativelayout.setOnTouchListener(new g());
                    relativelayout.setBackgroundColor(0xff000000);
                    framelayout.addView(relativelayout, new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
                    relativelayout.addView(audioplayer);
                    audioplayer.setBackGroundLayout(relativelayout);
                    audioplayer.requestFocus();
                    audioplayer.setOnKeyListener(new c());
                } else
                {
                    audioplayer.setLayoutParams(new android.view.ViewGroup.LayoutParams(1, 1));
                    framelayout.addView(audioplayer);
                }
                audioplayer.setListener(new a(playerproperties));
                audioplayer.play();
                return;
            }
        }
    }

    public void playVideoImpl(Bundle bundle, Activity activity)
    {
        com.inmobi.re.controller.JSController.PlayerProperties playerproperties = (com.inmobi.re.controller.JSController.PlayerProperties)bundle.getParcelable("player_properties");
        com.inmobi.re.controller.JSController.Dimensions dimensions = (com.inmobi.re.controller.JSController.Dimensions)bundle.getParcelable("expand_dimensions");
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Final dimensions: ")).append(dimensions).toString());
        String s = bundle.getString("expand_url");
        if (!a(playerproperties.id, s, activity, dimensions))
        {
            return;
        }
        a.setBusy(true);
        com.inmobi.re.controller.JSController.PlayerProperties playerproperties1;
        if (s.length() == 0)
        {
            com.inmobi.re.controller.JSController.PlayerProperties playerproperties2 = videoPlayer.getProperties();
            dimensions = videoPlayer.getPlayDimensions();
            videoPlayer.getMediaURL();
            playerproperties1 = playerproperties2;
        } else
        {
            videoPlayer.setPlayData(playerproperties, s);
            videoPlayer.setPlayDimensions(dimensions);
            playerproperties1 = playerproperties;
        }
        if (videoPlayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.HIDDEN)
        {
            videoPlayer.pseudoPause = true;
            videoPlayer.show();
            return;
        }
        FrameLayout framelayout = (FrameLayout)activity.findViewById(0x1020002);
        if (playerproperties1.isFullScreen())
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
            layoutparams.addRule(13);
            videoPlayer.setLayoutParams(layoutparams);
            RelativeLayout relativelayout = new RelativeLayout(activity);
            relativelayout.setOnTouchListener(new b());
            relativelayout.setBackgroundColor(0xff000000);
            framelayout.addView(relativelayout, new android.widget.FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
            relativelayout.addView(videoPlayer);
            videoPlayer.setBackGroundLayout(relativelayout);
            videoPlayer.requestFocus();
            videoPlayer.setOnKeyListener(new e());
        } else
        {
            android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(dimensions.width, dimensions.height);
            FrameLayout framelayout1 = new FrameLayout(activity);
            if (a.mExpandController.expandProperties == null)
            {
                layoutparams1.leftMargin = dimensions.x;
                layoutparams1.topMargin = dimensions.y;
            } else
            {
                layoutparams1.leftMargin = dimensions.x + a.mExpandController.expandProperties.currentX;
                layoutparams1.topMargin = dimensions.y + a.mExpandController.expandProperties.currentY;
            }
            layoutparams1.gravity = 3;
            videoPlayer.setLayoutParams(layoutparams1);
            framelayout.addView(framelayout1, new android.widget.FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
            videoPlayer.setBackGroundLayout(framelayout1);
            framelayout1.addView(videoPlayer);
        }
        videoPlayer.setListener(new f());
        videoPlayer.play();
    }

    public void releaseAllPlayers()
    {
        if (videoPlayer != null)
        {
            videoPlayerList.put(videoPlayer.getPropertyID(), videoPlayer);
        }
        Object aobj1[];
        int k;
        aobj1 = videoPlayerList.values().toArray();
        k = aobj1.length;
        int l = 0;
_L2:
        if (l >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1 = aobj1[l];
        ((AVPlayer)obj1).releasePlayer(IMWebView.userInitiatedClose);
_L3:
        l++;
        if (true) goto _L2; else goto _L1
        Exception exception3;
        exception3;
        Log.internal("[InMobi]-[RE]-4.4.1", "Unable to release player");
          goto _L3
        Exception exception;
        exception;
        Log.internal("[InMobi]-[RE]-4.4.1", "IMwebview release all players ", exception);
_L1:
        videoPlayerList.clear();
        videoPlayer = null;
        Object aobj[];
        int i;
        aobj = audioPlayerList.values().toArray();
        i = aobj.length;
        int j = 0;
_L5:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = aobj[j];
        ((AVPlayer)obj).releasePlayer(IMWebView.userInitiatedClose);
_L6:
        j++;
        if (true) goto _L5; else goto _L4
        Exception exception2;
        exception2;
        Log.internal("[InMobi]-[RE]-4.4.1", "Unable to release player");
          goto _L6
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[RE]-4.4.1", "IMwebview release all players ", exception1);
_L4:
        IMWebView.userInitiatedClose = false;
        audioPlayerList.clear();
        audioplayer = null;
        return;
    }

    public void validateVideoDimensions(com.inmobi.re.controller.JSController.Dimensions dimensions)
    {
        dimensions.width = (int)((float)dimensions.width * a.getDensity());
        dimensions.height = (int)((float)dimensions.height * a.getDensity());
        dimensions.x = (int)((float)dimensions.x * a.getDensity());
        dimensions.y = (int)((float)dimensions.y * a.getDensity());
    }

    private class d
    {

        static final int a[];

        static 
        {
            a = new int[com.inmobi.re.controller.util.AVPlayer.playerState.values().length];
            try
            {
                a[com.inmobi.re.controller.util.AVPlayer.playerState.PAUSED.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                a[com.inmobi.re.controller.util.AVPlayer.playerState.PLAYING.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[com.inmobi.re.controller.util.AVPlayer.playerState.COMPLETED.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[com.inmobi.re.controller.util.AVPlayer.playerState.INIT.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3)
            {
                return;
            }
        }
    }


    private class g
        implements android.view.View.OnTouchListener
    {

        final MRAIDAudioVideoController a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return true;
        }

        g()
        {
            a = MRAIDAudioVideoController.this;
            super();
        }
    }


    private class c
        implements android.view.View.OnKeyListener
    {

        final MRAIDAudioVideoController a;

        public boolean onKey(View view, int i, KeyEvent keyevent)
        {
            if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
            {
                Log.debug("[InMobi]-[RE]-4.4.1", "Back button pressed while fullscreen audio was playing");
                a.audioplayer.releasePlayer(true);
            }
            return false;
        }

        c()
        {
            a = MRAIDAudioVideoController.this;
            super();
        }
    }


    private class a
        implements AVPlayerListener
    {

        final com.inmobi.re.controller.JSController.PlayerProperties a;
        final MRAIDAudioVideoController b;

        public void onComplete(AVPlayer avplayer)
        {
            ViewGroup viewgroup1;
            if (!a.isFullScreen())
            {
                break MISSING_BLOCK_LABEL_37;
            }
            viewgroup1 = (ViewGroup)avplayer.getBackGroundLayout().getParent();
            ViewGroup viewgroup;
            if (viewgroup1 != null)
            {
                try
                {
                    viewgroup1.removeView(avplayer.getBackGroundLayout());
                    return;
                }
                catch (Exception exception)
                {
                    Log.debug("[InMobi]-[RE]-4.4.1", "Problem removing the audio relativelayout", exception);
                }
            }
            break MISSING_BLOCK_LABEL_64;
            viewgroup = (ViewGroup)avplayer.getParent();
            if (viewgroup == null)
            {
                break MISSING_BLOCK_LABEL_64;
            }
            viewgroup.removeView(avplayer);
            return;
        }

        public void onError(AVPlayer avplayer)
        {
            onComplete(avplayer);
        }

        public void onPrepared(AVPlayer avplayer)
        {
        }

        a(com.inmobi.re.controller.JSController.PlayerProperties playerproperties)
        {
            b = MRAIDAudioVideoController.this;
            a = playerproperties;
            super();
        }
    }


    private class b
        implements android.view.View.OnTouchListener
    {

        final MRAIDAudioVideoController a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return true;
        }

        b()
        {
            a = MRAIDAudioVideoController.this;
            super();
        }
    }


    private class e
        implements android.view.View.OnKeyListener
    {

        final MRAIDAudioVideoController a;

        public boolean onKey(View view, int i, KeyEvent keyevent)
        {
            if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
            {
                Log.debug("[InMobi]-[RE]-4.4.1", "Back pressed while fullscreen video is playing");
                a.videoPlayer.releasePlayer(true);
            }
            return false;
        }

        e()
        {
            a = MRAIDAudioVideoController.this;
            super();
        }
    }


    private class f
        implements AVPlayerListener
    {

        final MRAIDAudioVideoController a;

        public void onComplete(AVPlayer avplayer)
        {
            MRAIDAudioVideoController.a(a).setBusy(false);
            ViewGroup viewgroup = avplayer.getBackGroundLayout();
            if (viewgroup == null)
            {
                break MISSING_BLOCK_LABEL_37;
            }
            ((ViewGroup)viewgroup.getParent()).removeView(avplayer.getBackGroundLayout());
            avplayer.setBackGroundLayout(null);
_L2:
            this;
            JVM INSTR monitorenter ;
            if (a.videoPlayer != null && avplayer.getPropertyID().equalsIgnoreCase(a.videoPlayer.getPropertyID()))
            {
                a.videoPlayer = null;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            Log.debug("[InMobi]-[RE]-4.4.1", "Problem removing the video framelayout or relativelayout depending on video startstyle", exception);
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception1;
            exception1;
            throw exception1;
        }

        public void onError(AVPlayer avplayer)
        {
            onComplete(avplayer);
        }

        public void onPrepared(AVPlayer avplayer)
        {
        }

        f()
        {
            a = MRAIDAudioVideoController.this;
            super();
        }
    }

}
