// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.StartElementListener;
import com.appyet.data.FeedItem;
import org.xml.sax.Attributes;

// Referenced classes of package com.appyet.b.a:
//            a

final class r
    implements StartElementListener
{

    final FeedItem a;
    final a b;

    r(a a1, FeedItem feeditem)
    {
        b = a1;
        a = feeditem;
        super();
    }

    public final void start(Attributes attributes)
    {
        String s;
        if (attributes.getValue("href") == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        s = attributes.getValue("href");
_L4:
        if (attributes.getValue("rel") == null) goto _L2; else goto _L1
_L1:
        String s1 = attributes.getValue("rel");
_L3:
        String s2 = attributes.getValue("length");
        int i;
        i = 0;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        i = Integer.parseInt(attributes.getValue("length"));
        String s3 = attributes.getValue("type");
        String s4 = null;
        if (s3 != null)
        {
            try
            {
                s4 = attributes.getValue("type");
            }
            catch (Exception exception)
            {
                return;
            }
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        if (s1.equals("enclosure"))
        {
            a.setEnclosureLink(s);
            a.setEnclosureType(s4);
            a.setEnclosureLength(Integer.valueOf(i));
            return;
        }
        if (a.getLink() == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        if (!s1.equals("alternate"))
        {
            break MISSING_BLOCK_LABEL_192;
        }
        a.setLink(s);
        return;
_L2:
        s1 = null;
          goto _L3
        s = null;
          goto _L4
    }
}
