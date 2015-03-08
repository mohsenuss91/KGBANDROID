// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g;

import android.util.Xml;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.appyet.g:
//            o, d, m, p, 
//            l

final class e
{

    protected XmlSerializer a;
    protected d b;

    e()
    {
        a = Xml.newSerializer();
        b = new o();
    }

    public final Object a(InputStream inputstream)
    {
        String s;
        try
        {
            XmlPullParser xmlpullparser = XmlPullParserFactory.newInstance().newPullParser();
            xmlpullparser.setInput(new InputStreamReader(new BufferedInputStream(inputstream)));
            xmlpullparser.nextTag();
            xmlpullparser.require(2, null, "methodResponse");
            xmlpullparser.nextTag();
            s = xmlpullparser.getName();
            if (s.equals("params"))
            {
                xmlpullparser.nextTag();
                xmlpullparser.require(2, null, "param");
                xmlpullparser.nextTag();
                return b.a(xmlpullparser);
            }
            if (s.equals("fault"))
            {
                xmlpullparser.nextTag();
                Map map = (Map)b.a(xmlpullparser);
                throw new m((String)map.get("faultString"), ((Integer)map.get("faultCode")).intValue());
            }
        }
        catch (Exception exception)
        {
            if (exception instanceof p)
            {
                throw (p)exception;
            } else
            {
                throw new l("Error getting result from server.", exception);
            }
        }
        throw new l((new StringBuilder("Bad tag <")).append(s).append("> in XMLRPC response - neither <params> nor <fault>").toString());
    }
}
