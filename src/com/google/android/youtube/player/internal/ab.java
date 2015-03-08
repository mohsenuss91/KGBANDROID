// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

// Referenced classes of package com.google.android.youtube.player.internal:
//            ad, b, d

public abstract class ab
{

    private static final ab a = b();

    public ab()
    {
    }

    public static ab a()
    {
        return a;
    }

    private static ab b()
    {
        Class class1 = Class.forName("com.google.android.youtube.api.locallylinked.LocallyLinkedFactory").asSubclass(com/google/android/youtube/player/internal/ab);
        ab ab1 = (ab)class1.newInstance();
        return ab1;
        InstantiationException instantiationexception;
        instantiationexception;
        try
        {
            throw new IllegalStateException(instantiationexception);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return new ad();
        }
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        throw new IllegalStateException(illegalaccessexception);
    }

    public abstract YouTubeThumbnailLoader a(b b1, YouTubeThumbnailView youtubethumbnailview);

    public abstract b a(Context context, String s, t.a a1, t.b b1);

    public abstract d a(Activity activity, b b1);

}
