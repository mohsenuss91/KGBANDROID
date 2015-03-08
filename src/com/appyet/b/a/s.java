// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.StartElementListener;
import com.appyet.data.FeedItem;
import org.xml.sax.Attributes;

// Referenced classes of package com.appyet.b.a:
//            a

final class s
    implements StartElementListener
{

    final FeedItem a;
    final a b;

    s(a a1, FeedItem feeditem)
    {
        b = a1;
        a = feeditem;
        super();
    }

    public final void start(Attributes attributes)
    {
        try
        {
            if (attributes.getValue("url") != null)
            {
                a.setEnclosureLink(attributes.getValue("url"));
            }
            if (attributes.getValue("type") != null)
            {
                a.setEnclosureType(attributes.getValue("type"));
            }
            if (attributes.getValue("fileSize") != null)
            {
                a.setEnclosureLength(Integer.valueOf(Integer.parseInt(attributes.getValue("fileSize"))));
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
