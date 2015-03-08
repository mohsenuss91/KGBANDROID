// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.wrapper;

import android.media.AudioManager;
import com.appyet.context.ApplicationContext;

// Referenced classes of package com.appyet.wrapper:
//            AudioFocusChangeListener

public class AudioFocusChangeListenerWrapper
{

    private ApplicationContext mApplicationContext;
    private AudioFocusChangeListener mAudioFocusChangeListener;

    public AudioFocusChangeListenerWrapper(ApplicationContext applicationcontext)
    {
        mApplicationContext = applicationcontext;
        mAudioFocusChangeListener = new AudioFocusChangeListener(mApplicationContext);
    }

    public static void checkAvailable()
    {
    }

    public boolean abandonFocus(AudioManager audiomanager)
    {
        int i;
        try
        {
            i = audiomanager.abandonAudioFocus(mAudioFocusChangeListener);
        }
        catch (Exception exception)
        {
            return false;
        }
        catch (Error error)
        {
            return false;
        }
        return 1 == i;
    }

    public boolean requestFocus(AudioManager audiomanager)
    {
        int i;
        try
        {
            i = audiomanager.requestAudioFocus(mAudioFocusChangeListener, 3, 1);
        }
        catch (Exception exception)
        {
            return false;
        }
        catch (Error error)
        {
            return false;
        }
        return 1 == i;
    }

    static 
    {
        try
        {
            Class.forName("com.appyet.wrapper.AudioFocusChangeListener");
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
    }
}
