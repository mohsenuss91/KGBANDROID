// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;

// Referenced classes of package org.simpleframework.xml.stream:
//            Provider, DocumentReader, EventReader

class DocumentProvider
    implements Provider
{

    private final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public DocumentProvider()
    {
        factory.setNamespaceAware(true);
    }

    private EventReader provide(InputSource inputsource)
    {
        return new DocumentReader(factory.newDocumentBuilder().parse(inputsource));
    }

    public EventReader provide(InputStream inputstream)
    {
        return provide(new InputSource(inputstream));
    }

    public EventReader provide(Reader reader)
    {
        return provide(new InputSource(reader));
    }
}
