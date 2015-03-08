// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

// Referenced classes of package com.google.android.youtube.player.internal:
//            ab, p, o, z, 
//            b, w, d

public final class ad extends ab
{

    public ad()
    {
    }

    public final YouTubeThumbnailLoader a(b b1, YouTubeThumbnailView youtubethumbnailview)
    {
        return new p(b1, youtubethumbnailview);
    }

    public final b a(Context context, String s, t.a a1, t.b b1)
    {
        return new o(context, s, context.getPackageName(), z.d(context), a1, b1);
    }

    public final d a(Activity activity, b b1)
    {
        return w.a(activity, b1.a());
    }
}
