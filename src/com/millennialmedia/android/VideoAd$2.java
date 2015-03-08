// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.millennialmedia.android:
//            VideoAd

class this._cls0
    implements FilenameFilter
{

    final VideoAd this$0;

    public boolean accept(File file, String s)
    {
        if (getId() == null)
        {
            return false;
        } else
        {
            return s.startsWith(getId());
        }
    }

    ()
    {
        this$0 = VideoAd.this;
        super();
    }
}
