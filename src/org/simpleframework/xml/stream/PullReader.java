// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package org.simpleframework.xml.stream:
//            EventReader, EventNode

class PullReader
    implements EventReader
{

    private XmlPullParser parser;
    private EventNode peek;

    public PullReader(XmlPullParser xmlpullparser)
    {
        parser = xmlpullparser;
    }

    private Entry attribute(int i)
    {
        return new Entry(parser, i);
    }

    private Start build(Start start1)
    {
        int i = parser.getAttributeCount();
        for (int j = 0; j < i; j++)
        {
            Entry entry = attribute(j);
            if (!entry.isReserved())
            {
                start1.add(entry);
            }
        }

        return start1;
    }

    private End end()
    {
        return new End(null);
    }

    private EventNode read()
    {
        do
        {
            int i = parser.next();
            if (i != 1)
            {
                if (i == 2)
                {
                    return start();
                }
                if (i == 4)
                {
                    return text();
                }
                if (i == 3)
                {
                    return end();
                }
            } else
            {
                return null;
            }
        } while (true);
    }

    private Start start()
    {
        Start start1 = new Start(parser);
        if (start1.isEmpty())
        {
            start1 = build(start1);
        }
        return start1;
    }

    private Text text()
    {
        return new Text(parser);
    }

    public EventNode next()
    {
        EventNode eventnode = peek;
        if (eventnode == null)
        {
            return read();
        } else
        {
            peek = null;
            return eventnode;
        }
    }

    public EventNode peek()
    {
        if (peek == null)
        {
            peek = next();
        }
        return peek;
    }

    private class Entry extends EventAttribute
    {

        private final String name;
        private final String prefix;
        private final String reference;
        private final XmlPullParser source;
        private final String value;

        public String getName()
        {
            return name;
        }

        public String getPrefix()
        {
            return prefix;
        }

        public String getReference()
        {
            return reference;
        }

        public Object getSource()
        {
            return source;
        }

        public String getValue()
        {
            return value;
        }

        public boolean isReserved()
        {
            return false;
        }

        public Entry(XmlPullParser xmlpullparser, int i)
        {
            reference = xmlpullparser.getAttributeNamespace(i);
            prefix = xmlpullparser.getAttributePrefix(i);
            value = xmlpullparser.getAttributeValue(i);
            name = xmlpullparser.getAttributeName(i);
            source = xmlpullparser;
        }
    }


    private class Start extends EventElement
    {

        private final int line;
        private final String name;
        private final String prefix;
        private final String reference;
        private final XmlPullParser source;

        public int getLine()
        {
            return line;
        }

        public String getName()
        {
            return name;
        }

        public String getPrefix()
        {
            return prefix;
        }

        public String getReference()
        {
            return reference;
        }

        public Object getSource()
        {
            return source;
        }

        public Start(XmlPullParser xmlpullparser)
        {
            reference = xmlpullparser.getNamespace();
            line = xmlpullparser.getLineNumber();
            prefix = xmlpullparser.getPrefix();
            name = xmlpullparser.getName();
            source = xmlpullparser;
        }
    }


    private class End extends EventToken
    {

        public boolean isEnd()
        {
            return true;
        }

        private End()
        {
        }

        End(_cls1 _pcls1)
        {
            this();
        }
    }


    private class Text extends EventToken
    {

        private final XmlPullParser source;
        private final String text;

        public Object getSource()
        {
            return source;
        }

        public String getValue()
        {
            return text;
        }

        public boolean isText()
        {
            return true;
        }

        public Text(XmlPullParser xmlpullparser)
        {
            text = xmlpullparser.getText();
            source = xmlpullparser;
        }
    }

}
