// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.StartElementListener;
import com.appyet.data.Feed;
import org.xml.sax.Attributes;

// Referenced classes of package com.appyet.b.a:
//            a

final class l
    implements StartElementListener
{

    final a a;

    l(a a1)
    {
        a = a1;
        super();
    }

    public final void start(Attributes attributes)
    {
        try
        {
            if (attributes.getValue("href") != null && (a.f.getWebLink() == null || attributes.getValue("rel") != null && attributes.getValue("rel").equals("alternate")))
            {
                a.f.setWebLink(attributes.getValue("href"));
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
