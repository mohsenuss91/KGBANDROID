// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.media.AudioRecord;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            AudioTriggerCallback

public class AudioTriggerer
{

    static boolean a;
    public static AudioRecord audioRecorder = null;
    static boolean b;
    static Timer c;
    public static List callbacks = new ArrayList();
    static long d = 0L;
    static long e = 50L;
    private static int f[] = {
        8000, 11025, 22050, 44100
    };

    public AudioTriggerer()
    {
    }

    static void a()
    {
        d();
    }

    private static void a(double d1)
    {
        for (Iterator iterator = callbacks.iterator(); iterator.hasNext();)
        {
            AudioTriggerCallback audiotriggercallback = (AudioTriggerCallback)iterator.next();
            try
            {
                audiotriggercallback.audioLevel(d1);
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "AudioTriggerer: One of the mic listeners has a problem.");
            }
        }

    }

    public static void addEventListener(AudioTriggerCallback audiotriggercallback)
    {
        callbacks.add(audiotriggercallback);
        if (callbacks.size() == 1)
        {
            b();
        }
    }

    private static void b()
    {
        a = true;
        audioRecorder = h();
        Timer timer = new Timer();
        c = timer;
        timer.scheduleAtFixedRate(new a(), d, e);
    }

    private static void c()
    {
        a = false;
        if (audioRecorder == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (f())
        {
            b = false;
        }
        audioRecorder.stop();
        audioRecorder.release();
        c.cancel();
        c.purge();
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        illegalstateexception.printStackTrace();
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        runtimeexception.printStackTrace();
        return;
    }

    private static void d()
    {
        while (audioRecorder == null || audioRecorder.getState() != 1) 
        {
            return;
        }
        short aword0[] = new short[512];
        float af[] = new float[3];
        b = true;
        int i;
        float f2;
        try
        {
            audioRecorder.startRecording();
        }
        catch (Exception exception)
        {
            return;
        }
        for (; f(); a(f2 / (float)i / 32F))
        {
            i = audioRecorder.read(aword0, 0, aword0.length);
            int j = 0;
            float f1 = 0.0F;
            for (; j < i; j += 2)
            {
                short word0 = (short)(aword0[j] | aword0[j + 1]);
                if (word0 != 0)
                {
                    f1 += Math.abs(word0) / i;
                }
            }

            af[0] = f1;
            f2 = 0.0F;
            for (int k = 0; k < 3; k++)
            {
                f2 += af[k];
            }

        }

        e();
    }

    private static void e()
    {
        if (audioRecorder == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (f())
        {
            b = false;
        }
        audioRecorder.stop();
        audioRecorder.release();
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        illegalstateexception.printStackTrace();
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        runtimeexception.printStackTrace();
        return;
    }

    private static boolean f()
    {
        return b;
    }

    private static void g()
    {
        b = false;
    }

    private static AudioRecord h()
    {
        int ai[];
        int i;
        int j;
        ai = f;
        i = ai.length;
        j = 0;
_L8:
        if (j >= i) goto _L2; else goto _L1
_L1:
        int k;
        short aword0[];
        int l;
        int i1;
        k = ai[j];
        aword0 = (new short[] {
            3, 2
        });
        l = aword0.length;
        i1 = 0;
_L7:
        short word0;
        short aword1[];
        int j1;
        int k1;
        if (i1 >= l)
        {
            continue; /* Loop/switch isn't completed */
        }
        word0 = aword0[i1];
        aword1 = (new short[] {
            16, 12
        });
        j1 = aword1.length;
        k1 = 0;
_L5:
        if (k1 >= j1) goto _L4; else goto _L3
_L3:
        short word1 = aword1[k1];
        int l1 = AudioRecord.getMinBufferSize(k, word1, word0);
        if (l1 == -2)
        {
            continue; /* Loop/switch isn't completed */
        }
        AudioRecord audiorecord;
        int i2;
        audiorecord = new AudioRecord(0, k, word1, word0, l1);
        i2 = audiorecord.getState();
        if (i2 == 1)
        {
            return audiorecord;
        }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        k1++;
          goto _L5
_L4:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
        j++;
          goto _L8
_L2:
        return null;
    }

    public static void removeEventListener(AudioTriggerCallback audiotriggercallback)
    {
        callbacks.remove(audiotriggercallback);
        if (callbacks.size() == 0)
        {
            c();
        }
    }


    private class a extends TimerTask
    {

        public final void run()
        {
            AudioTriggerer.a();
        }

        a()
        {
        }
    }

}
