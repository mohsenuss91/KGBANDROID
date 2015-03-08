// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            ey

public final class ck extends FrameLayout
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{

    private final ey lL;
    private final MediaController oG;
    private final a oH = new a();
    private final VideoView oI;
    private long oJ;
    private String oK;

    public ck(Context context, ey ey1)
    {
        super(context);
        lL = ey1;
        oI = new VideoView(context);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
        addView(oI, layoutparams);
        oG = new MediaController(context);
        oH.aX();
        oI.setOnCompletionListener(this);
        oI.setOnPreparedListener(this);
        oI.setOnErrorListener(this);
    }

    private static void a(ey ey1, String s)
    {
        a(ey1, s, ((Map) (new HashMap(1))));
    }

    public static void a(ey ey1, String s, String s1)
    {
        boolean flag;
        byte byte0;
        HashMap hashmap;
        if (s1 == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 3;
        }
        hashmap = new HashMap(byte0);
        hashmap.put("what", s);
        if (!flag)
        {
            hashmap.put("extra", s1);
        }
        a(ey1, "error", ((Map) (hashmap)));
    }

    private static void a(ey ey1, String s, String s1, String s2)
    {
        HashMap hashmap = new HashMap(2);
        hashmap.put(s1, s2);
        a(ey1, s, ((Map) (hashmap)));
    }

    private static void a(ey ey1, String s, Map map)
    {
        map.put("event", s);
        ey1.a("onVideoEvent", map);
    }

    public final void aV()
    {
        if (!TextUtils.isEmpty(oK))
        {
            oI.setVideoPath(oK);
            return;
        } else
        {
            a(lL, "no_src", ((String) (null)));
            return;
        }
    }

    public final void aW()
    {
        long l1 = oI.getCurrentPosition();
        if (oJ != l1)
        {
            float f = (float)l1 / 1000F;
            a(lL, "timeupdate", "time", String.valueOf(f));
            oJ = l1;
        }
    }

    public final void b(MotionEvent motionevent)
    {
        oI.dispatchTouchEvent(motionevent);
    }

    public final void destroy()
    {
        oH.cancel();
        oI.stopPlayback();
    }

    public final void l(boolean flag)
    {
        if (flag)
        {
            oI.setMediaController(oG);
            return;
        } else
        {
            oG.hide();
            oI.setMediaController(null);
            return;
        }
    }

    public final void o(String s)
    {
        oK = s;
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        a(lL, "ended");
    }

    public final boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        a(lL, String.valueOf(i), String.valueOf(j));
        return true;
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        float f = (float)oI.getDuration() / 1000F;
        a(lL, "canplaythrough", "duration", String.valueOf(f));
    }

    public final void pause()
    {
        oI.pause();
    }

    public final void play()
    {
        oI.start();
    }

    public final void seekTo(int i)
    {
        oI.seekTo(i);
    }

    private class a
    {

        private final Runnable le;
        private volatile boolean oL;

        static boolean a(a a1)
        {
            return a1.oL;
        }

        public final void aX()
        {
            eu.ss.postDelayed(le, 250L);
        }

        public final void cancel()
        {
            oL = true;
            eu.ss.removeCallbacks(le);
        }

        public a()
        {
            oL = false;
            class _cls1
                implements Runnable
            {

                private final WeakReference oM;
                final ck oN;
                final a oO;

                public void run()
                {
                    ck ck2 = (ck)oM.get();
                    if (!a.a(oO) && ck2 != null)
                    {
                        ck2.aW();
                        oO.aX();
                    }
                }

                _cls1()
                {
                    oO = a.this;
                    oN = ck.this;
                    super();
                    oM = new WeakReference(oN);
                }
            }

            le = new _cls1();
        }
    }

}
