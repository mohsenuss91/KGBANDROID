// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g;

import com.appyet.f.m;
import com.appyet.g.a.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.appyet.g:
//            d

public final class o
    implements d
{

    static SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss");

    public o()
    {
    }

    public final Object a(XmlPullParser xmlpullparser)
    {
        boolean flag;
        xmlpullparser.require(2, null, "value");
        if (xmlpullparser.isEmptyElementTag())
        {
            return "";
        }
        flag = true;
        String s5;
        xmlpullparser.nextTag();
        s5 = xmlpullparser.getName();
        String s = s5;
        if (s.equals("value") && xmlpullparser.getEventType() == 3)
        {
            return "";
        }
          goto _L1
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        s = null;
_L9:
        flag = false;
_L1:
        if (!flag) goto _L3; else goto _L2
_L2:
        if (!s.equals("int") && !s.equals("i4")) goto _L5; else goto _L4
_L4:
        Object obj = Integer.valueOf(Integer.parseInt(xmlpullparser.nextText()));
_L7:
        xmlpullparser.nextTag();
        xmlpullparser.require(3, null, "value");
        return obj;
_L5:
        if (s.equals("i8"))
        {
            obj = Long.valueOf(Long.parseLong(xmlpullparser.nextText()));
            continue; /* Loop/switch isn't completed */
        }
        if (s.equals("double"))
        {
            obj = Double.valueOf(Double.parseDouble(xmlpullparser.nextText()));
            continue; /* Loop/switch isn't completed */
        }
        if (s.equals("boolean"))
        {
            if (xmlpullparser.nextText().equals("1"))
            {
                obj = Boolean.TRUE;
            } else
            {
                obj = Boolean.FALSE;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (s.equals("string"))
        {
            obj = xmlpullparser.nextText();
            continue; /* Loop/switch isn't completed */
        }
        if (s.equals("dateTime.iso8601"))
        {
            String s4 = xmlpullparser.nextText();
            Object obj2;
            try
            {
                obj2 = a.parseObject(s4);
            }
            catch (ParseException parseexception)
            {
                java.util.Date date;
                try
                {
                    date = m.a(s4);
                }
                catch (Exception exception)
                {
                    throw new IOException((new StringBuilder("Cannot deserialize dateTime ")).append(s4).toString());
                }
                obj = date;
                continue; /* Loop/switch isn't completed */
            }
            obj = obj2;
            continue; /* Loop/switch isn't completed */
        }
        if (s.equals("base64"))
        {
            BufferedReader bufferedreader = new BufferedReader(new StringReader(xmlpullparser.nextText()));
            StringBuffer stringbuffer = new StringBuffer();
            do
            {
                String s1 = bufferedreader.readLine();
                if (s1 == null)
                {
                    break;
                }
                stringbuffer.append(s1);
            } while (true);
            obj = com.appyet.g.a.a.a(stringbuffer.toString());
        } else
        if (s.equals("array"))
        {
            xmlpullparser.nextTag();
            xmlpullparser.require(2, null, "data");
            xmlpullparser.nextTag();
            ArrayList arraylist = new ArrayList();
            for (; xmlpullparser.getName().equals("value"); xmlpullparser.nextTag())
            {
                arraylist.add(a(xmlpullparser));
            }

            xmlpullparser.require(3, null, "data");
            xmlpullparser.nextTag();
            xmlpullparser.require(3, null, "array");
            obj = ((Object) (arraylist.toArray()));
        } else
        if (s.equals("struct"))
        {
            xmlpullparser.nextTag();
            HashMap hashmap = new HashMap();
            for (; xmlpullparser.getName().equals("member"); xmlpullparser.nextTag())
            {
                Object obj1 = null;
                String s2 = null;
                do
                {
                    xmlpullparser.nextTag();
                    String s3 = xmlpullparser.getName();
                    if (s3.equals("name"))
                    {
                        s2 = xmlpullparser.nextText();
                        continue;
                    }
                    if (!s3.equals("value"))
                    {
                        break;
                    }
                    obj1 = a(xmlpullparser);
                } while (true);
                if (s2 != null && obj1 != null)
                {
                    hashmap.put(s2, obj1);
                }
                xmlpullparser.require(3, null, "member");
            }

            xmlpullparser.require(3, null, "struct");
            obj = hashmap;
        } else
        {
            throw new IOException((new StringBuilder("Cannot deserialize ")).append(xmlpullparser.getName()).toString());
        }
        continue; /* Loop/switch isn't completed */
_L3:
        obj = xmlpullparser.getText();
        if (true) goto _L7; else goto _L6
_L6:
        XmlPullParserException xmlpullparserexception1;
        xmlpullparserexception1;
        if (true) goto _L9; else goto _L8
_L8:
    }

}
