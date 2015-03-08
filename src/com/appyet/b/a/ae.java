// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.StartElementListener;
import com.appyet.data.FeedItem;
import org.xml.sax.Attributes;

// Referenced classes of package com.appyet.b.a:
//            w

final class ae
    implements StartElementListener
{

    final FeedItem a;
    final w b;

    ae(w w, FeedItem feeditem)
    {
        b = w;
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
            if (attributes.getValue("length") != null)
            {
                a.setEnclosureLength(Integer.valueOf(Integer.parseInt(attributes.getValue("length"))));
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
