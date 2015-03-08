// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.commons.uid.UIDHelper;
import com.inmobi.re.container.IMWebView;

// Referenced classes of package com.inmobi.re.controller.util:
//            AVPlayerListener

public class AVPlayer extends VideoView
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{

    public static final int MINIMAL_LAYOUT_PARAM = 1;
    private static String f = "play";
    private static String g = "pause";
    private static String h = "ended";
    private static int i = -1;
    private static int j = 2;
    private static String k = "Loading. Please Wait..";
    private com.inmobi.re.controller.JSController.PlayerProperties a;
    private AVPlayerListener b;
    private String c;
    private int d;
    private RelativeLayout e;
    private boolean l;
    private boolean m;
    private IMWebView n;
    private Bitmap o;
    private int p;
    public boolean pseudoPause;
    private int q;
    private playerState r;
    private MediaPlayer s;
    private boolean t;
    private ViewGroup u;
    private com.inmobi.re.controller.JSController.Dimensions v;
    private b w;

    private AVPlayer(Context context)
    {
        super(context);
        pseudoPause = false;
        d = 0;
        l = false;
        m = false;
        o = null;
        q = -1;
        w = new b();
    }

    public AVPlayer(Context context, IMWebView imwebview)
    {
        this(context);
        setZOrderOnTop(true);
        r = playerState.INIT;
        setDrawingCacheEnabled(true);
        n = imwebview;
        setFocusable(true);
        setFocusableInTouchMode(true);
        p = 100;
    }

    static int a(AVPlayer avplayer, int i1)
    {
        avplayer.q = i1;
        return i1;
    }

    private static String a(String s1)
    {
        byte abyte0[];
        StringBuffer stringbuffer;
        int i1;
        String s2;
        try
        {
            abyte0 = s1.getBytes();
            stringbuffer = new StringBuffer();
        }
        catch (Exception exception)
        {
            return null;
        }
        i1 = 0;
        if (i1 >= abyte0.length)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if ((0x80 & abyte0[i1]) > 0)
        {
            stringbuffer.append((new StringBuilder("%")).append(UIDHelper.byteToHex(abyte0[i1])).toString());
            break MISSING_BLOCK_LABEL_98;
        }
        stringbuffer.append((char)abyte0[i1]);
        break MISSING_BLOCK_LABEL_98;
        s2 = new String(stringbuffer.toString().getBytes(), "ISO-8859-1");
        return s2;
        for (i1++; false; i1++)
        {
        }

        break MISSING_BLOCK_LABEL_16;
    }

    private void a()
    {
        if (a.showControl())
        {
            MediaController mediacontroller = new MediaController(getContext());
            setMediaController(mediacontroller);
            mediacontroller.setAnchorView(this);
        }
    }

    private void a(int i1)
    {
        if (n != null)
        {
            n.injectJavaScript((new StringBuilder("window.mraidview.fireMediaErrorEvent('")).append(a.id).append("',").append(i1).append(");").toString());
        }
    }

    private void a(int i1, int j1)
    {
        if (n != null)
        {
            n.injectJavaScript((new StringBuilder("window.mraidview.fireMediaTimeUpdateEvent('")).append(a.id).append("',").append(i1).append(",").append(j1).append(");").toString());
        }
    }

    static void a(AVPlayer avplayer, int i1, int j1)
    {
        avplayer.a(i1, j1);
    }

    private void a(boolean flag, int i1)
    {
        if (n != null)
        {
            n.injectJavaScript((new StringBuilder("window.mraidview.fireMediaCloseEvent('")).append(a.id).append("',").append(flag).append(",").append(i1).append(");").toString());
            n.mediaPlayerReleased(this);
        }
    }

    static boolean a(AVPlayer avplayer)
    {
        return avplayer.l();
    }

    static int b(AVPlayer avplayer)
    {
        return avplayer.q;
    }

    static int b(AVPlayer avplayer, int i1)
    {
        avplayer.d = i1;
        return i1;
    }

    private void b()
    {
        r = playerState.INIT;
        e();
        setVideoPath(c);
        a();
        setOnCompletionListener(this);
        setOnErrorListener(this);
        setOnPreparedListener(this);
    }

    private void b(int i1)
    {
        if (s != null && t)
        {
            t = false;
        }
        p = i1;
        float f1 = 1.0F - (float)(Math.log(101 - i1) / Math.log(101D));
        try
        {
            s.setVolume(f1, f1);
        }
        catch (Exception exception)
        {
            n.raiseError("Player has been released. Cannot set the volume.", "setVolume");
        }
        g();
    }

    private void b(String s1)
    {
        if (n != null)
        {
            n.injectJavaScript((new StringBuilder("window.mraidview.fireMediaTrackingEvent('")).append(s1).append("','").append(a.id).append("');").toString());
        }
    }

    private void c()
    {
        if (r == playerState.SHOWING)
        {
            playerState playerstate;
            if (m)
            {
                playerstate = playerState.COMPLETED;
            } else
            {
                playerstate = playerState.PAUSED;
            }
            r = playerstate;
        } else
        if (a.isAutoPlay() && r == playerState.INIT)
        {
            if (a.doMute())
            {
                mute();
            }
            start();
            return;
        }
    }

    private void d()
    {
        ViewGroup viewgroup;
        ViewGroup viewgroup1;
        try
        {
            viewgroup = (ViewGroup)getParent();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "IMAVPlayer: unable to remove view");
            return;
        }
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        viewgroup.removeView(this);
        viewgroup1 = (ViewGroup)u.getParent();
        if (viewgroup1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        viewgroup1.removeView(u);
        setBackgroundColor(0);
        setBackgroundDrawable(null);
        setBackGroundLayout(null);
        return;
    }

    private void e()
    {
        e = new RelativeLayout(getContext());
        e.setLayoutParams(getLayoutParams());
        e.setBackgroundColor(0xff000000);
        TextView textview = new TextView(getContext());
        textview.setText(k);
        textview.setTextColor(-1);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        e.addView(textview, layoutparams);
        ((ViewGroup)getParent()).addView(e);
    }

    private void f()
    {
        if (e != null)
        {
            ((ViewGroup)getParent()).removeView(e);
        }
    }

    private void g()
    {
        if (n != null)
        {
            n.injectJavaScript((new StringBuilder("window.mraidview.fireMediaVolumeChangeEvent('")).append(a.id).append("',").append(getVolume()).append(",").append(isMediaMuted()).append(");").toString());
        }
    }

    private void h()
    {
        w.sendEmptyMessage(1001);
    }

    private void i()
    {
        w.removeMessages(1001);
    }

    private boolean j()
    {
        return r == playerState.PAUSED || r == playerState.HIDDEN;
    }

    private boolean k()
    {
        return r == playerState.RELEASED;
    }

    private boolean l()
    {
        return r == playerState.PLAYING;
    }

    private boolean m()
    {
        return getLayoutParams().width == 1 && getLayoutParams().height == 1;
    }

    public boolean getAutoPlay()
    {
        if (a != null)
        {
            return a.autoPlay;
        } else
        {
            return false;
        }
    }

    public ViewGroup getBackGroundLayout()
    {
        return u;
    }

    public String getMediaURL()
    {
        return c;
    }

    public com.inmobi.re.controller.JSController.Dimensions getPlayDimensions()
    {
        return v;
    }

    public com.inmobi.re.controller.JSController.PlayerProperties getPlayProperties()
    {
        return a;
    }

    public com.inmobi.re.controller.JSController.PlayerProperties getProperties()
    {
        return a;
    }

    public String getPropertyID()
    {
        return a.id;
    }

    public playerState getState()
    {
        return r;
    }

    public int getVolume()
    {
        return p;
    }

    public void hide()
    {
        try
        {
            setVisibility(4);
            u.setVisibility(4);
            r = playerState.HIDDEN;
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "IMAVPlayer: unable to hide video");
        }
    }

    public boolean isInlineVideo()
    {
        return !a.isFullScreen();
    }

    public boolean isMediaMuted()
    {
        return t;
    }

    public boolean isPrepared()
    {
        return l;
    }

    public void mute()
    {
        if (s != null && !t)
        {
            t = true;
            try
            {
                s.setVolume(0.0F, 0.0F);
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "IMAVPlayer: unable to set volume (mute)");
            }
            g();
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", "AVPlayer-> onCompletion");
        r = playerState.COMPLETED;
        m = true;
        b(h);
        i();
        if (!a.doLoop()) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (!j())
        {
            d = 0;
            start();
        }
        this;
        JVM INSTR monitorexit ;
_L4:
        return;
        Exception exception1;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[RE]-4.4.1", "IMAvplayer onCompletion exception ", exception);
        return;
_L2:
        if (!a.exitOnComplete()) goto _L4; else goto _L3
_L3:
        releasePlayer(false);
        return;
    }

    public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("AVPlayer-> Player error : ")).append(i1).toString());
        f();
        releasePlayer(false);
        if (b != null)
        {
            b.onError(this);
        }
        int k1 = i;
        if (i1 == 100)
        {
            k1 = j;
        }
        a(k1);
        return false;
    }

    public void onIMVisibilityChanged(boolean flag)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("AVPlayer-> onIMVisibilityChanged: ")).append(flag).toString());
        if (flag && !pseudoPause)
        {
            setBackgroundDrawable(new BitmapDrawable(o));
        }
        if (flag && pseudoPause)
        {
            pseudoPause = false;
            play();
        }
        if (!flag && r == playerState.PLAYING)
        {
            pseudoPause = true;
            pause();
        }
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        s = mediaplayer;
        super.seekTo(1000 * d);
        if (t)
        {
            try
            {
                s.setVolume(0.0F, 0.0F);
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "IMAVPlayer: unable to set volume");
            }
        }
        Log.debug("[InMobi]-[RE]-4.4.1", "AVPlayer-> onPrepared");
        f();
        if (b != null)
        {
            b.onPrepared(this);
        }
        l = true;
        c();
    }

    protected void onVisibilityChanged(View view, int i1)
    {
        boolean flag;
        if (i1 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        onIMVisibilityChanged(flag);
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        boolean flag;
        try
        {
            super.onWindowVisibilityChanged(i1);
            if (android.os.Build.VERSION.SDK_INT >= 8)
            {
                break MISSING_BLOCK_LABEL_24;
            }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "IMAVPlayer: onWindowVisibilityChanged: Something went wrong");
            return;
        }
        if (i1 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        onIMVisibilityChanged(flag);
    }

    public void pause()
    {
        this;
        JVM INSTR monitorenter ;
        if (r == null) goto _L2; else goto _L1
_L1:
        playerState playerstate;
        playerState playerstate1;
        playerstate = r;
        playerstate1 = playerState.PAUSED;
        if (playerstate != playerstate1) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        super.pause();
        r = playerState.PAUSED;
        i();
        Log.debug("[InMobi]-[RE]-4.4.1", "AVPlayer-> pause");
        b(g);
        if (true) goto _L3; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void play()
    {
        b();
    }

    public void releasePlayer(boolean flag)
    {
        if (n != null)
        {
            n.setOnTouchListener(new a());
        }
        this;
        JVM INSTR monitorenter ;
        if (!k()) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
_L4:
        return;
_L2:
        this;
        JVM INSTR monitorexit ;
        r = playerState.RELEASED;
        Exception exception;
        int i1;
        if (q != -1)
        {
            i1 = q;
        } else
        {
            i1 = Math.round(getCurrentPosition() / 1000);
        }
        a(flag, i1);
        i();
        stopPlayback();
        super.setMediaController(null);
        d();
        if (b == null) goto _L4; else goto _L3
_L3:
        b.onComplete(this);
        b = null;
        return;
        exception;
        throw exception;
    }

    public void seekPlayer(int i1)
    {
        if (i1 <= getDuration())
        {
            seekTo(i1);
        }
    }

    public void setAutoPlay(boolean flag)
    {
        if (a != null)
        {
            a.autoPlay = flag;
        }
    }

    public void setBackGroundLayout(ViewGroup viewgroup)
    {
        u = viewgroup;
    }

    public void setListener(AVPlayerListener avplayerlistener)
    {
        b = avplayerlistener;
    }

    public void setPlayData(com.inmobi.re.controller.JSController.PlayerProperties playerproperties, String s1)
    {
        a = playerproperties;
        c = s1;
        if (playerproperties.audioMuted)
        {
            t = true;
        }
        c = c.trim();
        c = a(c);
        if (o == null)
        {
            o = Bitmap.createBitmap(10, 10, android.graphics.Bitmap.Config.ARGB_8888);
            if (android.os.Build.VERSION.SDK_INT >= 8)
            {
                try
                {
                    o = WrapperFunctions.getVideoBitmap(c);
                    return;
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-[RE]-4.4.1", "IMAVPlayer: unable to get video bitmap");
                }
                return;
            }
        }
    }

    public void setPlayDimensions(com.inmobi.re.controller.JSController.Dimensions dimensions)
    {
        v = dimensions;
    }

    public void setVolume(int i1)
    {
        if (i1 != p && r != playerState.RELEASED)
        {
            b(i1);
        }
    }

    public void show()
    {
        r = playerState.SHOWING;
        setVisibility(0);
    }

    public void start()
    {
        this;
        JVM INSTR monitorenter ;
        if (n != null && !m())
        {
            n.setOnTouchListener(new c());
        }
        if (r == null) goto _L2; else goto _L1
_L1:
        playerState playerstate;
        playerState playerstate1;
        playerstate = r;
        playerstate1 = playerState.PLAYING;
        if (playerstate != playerstate1) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        seekPlayer(1000 * d);
        super.start();
        r = playerState.PLAYING;
        m = false;
        h();
        Log.debug("[InMobi]-[RE]-4.4.1", "AVPlayer-> start playing");
        if (l)
        {
            b(f);
        }
        if (true) goto _L3; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void unMute()
    {
        if (s != null && t)
        {
            b(p);
        }
    }


    private class b extends Handler
    {

        private final WeakReference a;

        public void handleMessage(Message message)
        {
            AVPlayer avplayer = (AVPlayer)a.get();
            if (avplayer == null) goto _L2; else goto _L1
_L1:
            message.what;
            JVM INSTR tableswitch 1001 1001: default 36
        //                       1001 42;
               goto _L2 _L3
_L2:
            super.handleMessage(message);
_L5:
            return;
_L3:
            if (!AVPlayer.a(avplayer)) goto _L5; else goto _L4
_L4:
            int i1 = Math.round(avplayer.getCurrentPosition() / 1000);
            int j1 = Math.round(avplayer.getDuration() / 1000);
            if (AVPlayer.b(avplayer) != i1)
            {
                AVPlayer.a(avplayer, i1, j1);
                AVPlayer.a(avplayer, i1);
                AVPlayer.b(avplayer, i1);
            }
            sendEmptyMessageDelayed(1001, 1000L);
            if (true) goto _L2; else goto _L6
_L6:
        }

        public b()
        {
            a = new WeakReference(AVPlayer.this);
        }
    }


    private class playerState extends Enum
    {

        public static final playerState COMPLETED;
        public static final playerState HIDDEN;
        public static final playerState INIT;
        public static final playerState PAUSED;
        public static final playerState PLAYING;
        public static final playerState RELEASED;
        public static final playerState SHOWING;
        private static final playerState a[];

        public static playerState valueOf(String s1)
        {
            return (playerState)Enum.valueOf(com/inmobi/re/controller/util/AVPlayer$playerState, s1);
        }

        public static playerState[] values()
        {
            return (playerState[])a.clone();
        }

        static 
        {
            INIT = new playerState("INIT", 0);
            PLAYING = new playerState("PLAYING", 1);
            PAUSED = new playerState("PAUSED", 2);
            HIDDEN = new playerState("HIDDEN", 3);
            SHOWING = new playerState("SHOWING", 4);
            COMPLETED = new playerState("COMPLETED", 5);
            RELEASED = new playerState("RELEASED", 6);
            playerState aplayerstate[] = new playerState[7];
            aplayerstate[0] = INIT;
            aplayerstate[1] = PLAYING;
            aplayerstate[2] = PAUSED;
            aplayerstate[3] = HIDDEN;
            aplayerstate[4] = SHOWING;
            aplayerstate[5] = COMPLETED;
            aplayerstate[6] = RELEASED;
            a = aplayerstate;
        }

        private playerState(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class a
        implements android.view.View.OnTouchListener
    {

        final AVPlayer a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return false;
        }

        a()
        {
            a = AVPlayer.this;
            super();
        }
    }


    private class c
        implements android.view.View.OnTouchListener
    {

        final AVPlayer a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return motionevent.getAction() == 2;
        }

        c()
        {
            a = AVPlayer.this;
            super();
        }
    }

}
