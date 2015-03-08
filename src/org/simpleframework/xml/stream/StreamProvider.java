// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

// Referenced classes of package org.simpleframework.xml.stream:
//            Provider, StreamReader, EventReader

class StreamProvider
    implements Provider
{

    private final XMLInputFactory factory = XMLInputFactory.newInstance();

    public StreamProvider()
    {
    }

    private EventReader provide(XMLEventReader xmleventreader)
    {
        return new StreamReader(xmleventreader);
    }

    public EventReader provide(InputStream inputstream)
    {
        return provide(factory.createXMLEventReader(inputstream));
    }

    public EventReader provide(Reader reader)
    {
        return provide(factory.createXMLEventReader(reader));
    }
}
