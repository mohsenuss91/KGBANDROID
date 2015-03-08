// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.util.Iterator;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;

// Referenced classes of package org.simpleframework.xml.stream:
//            EventReader, EventNode

class StreamReader
    implements EventReader
{

    private EventNode peek;
    private XMLEventReader reader;

    public StreamReader(XMLEventReader xmleventreader)
    {
        reader = xmleventreader;
    }

    private Entry attribute(Attribute attribute1)
    {
        return new Entry(attribute1);
    }

    private Start build(Start start1)
    {
        Iterator iterator = start1.getAttributes();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Entry entry = attribute((Attribute)iterator.next());
            if (!entry.isReserved())
            {
                start1.add(entry);
            }
        } while (true);
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
            XMLEvent xmlevent = reader.nextEvent();
            if (!xmlevent.isEndDocument())
            {
                if (xmlevent.isStartElement())
                {
                    return start(xmlevent);
                }
                if (xmlevent.isCharacters())
                {
                    return text(xmlevent);
                }
                if (xmlevent.isEndElement())
                {
                    return end();
                }
            } else
            {
                return null;
            }
        } while (true);
    }

    private Start start(XMLEvent xmlevent)
    {
        Start start1 = new Start(xmlevent);
        if (start1.isEmpty())
        {
            start1 = build(start1);
        }
        return start1;
    }

    private Text text(XMLEvent xmlevent)
    {
        return new Text(xmlevent);
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

        private final Attribute entry;

        public String getName()
        {
            return entry.getName().getLocalPart();
        }

        public String getPrefix()
        {
            return entry.getName().getPrefix();
        }

        public String getReference()
        {
            return entry.getName().getNamespaceURI();
        }

        public Object getSource()
        {
            return entry;
        }

        public String getValue()
        {
            return entry.getValue();
        }

        public boolean isReserved()
        {
            return false;
        }

        public Entry(Attribute attribute1)
        {
            entry = attribute1;
        }
    }


    private class Start extends EventElement
    {

        private final StartElement element;
        private final Location location;

        public Iterator getAttributes()
        {
            return element.getAttributes();
        }

        public int getLine()
        {
            return location.getLineNumber();
        }

        public String getName()
        {
            return element.getName().getLocalPart();
        }

        public String getPrefix()
        {
            return element.getName().getPrefix();
        }

        public String getReference()
        {
            return element.getName().getNamespaceURI();
        }

        public Object getSource()
        {
            return element;
        }

        public Start(XMLEvent xmlevent)
        {
            element = xmlevent.asStartElement();
            location = xmlevent.getLocation();
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

        private final Characters text;

        public Object getSource()
        {
            return text;
        }

        public String getValue()
        {
            return text.getData();
        }

        public boolean isText()
        {
            return true;
        }

        public Text(XMLEvent xmlevent)
        {
            text = xmlevent.asCharacters();
        }
    }

}
