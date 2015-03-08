// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

// Referenced classes of package org.simpleframework.xml.stream:
//            ProviderFactory, Provider, NodeReader, Format, 
//            NodeWriter, InputNode, EventReader, OutputNode

public final class NodeBuilder
{

    private static Provider PROVIDER = ProviderFactory.getInstance();

    public NodeBuilder()
    {
    }

    public static InputNode read(InputStream inputstream)
    {
        return read(PROVIDER.provide(inputstream));
    }

    public static InputNode read(Reader reader)
    {
        return read(PROVIDER.provide(reader));
    }

    private static InputNode read(EventReader eventreader)
    {
        return (new NodeReader(eventreader)).readRoot();
    }

    public static OutputNode write(Writer writer)
    {
        return write(writer, new Format());
    }

    public static OutputNode write(Writer writer, Format format)
    {
        return (new NodeWriter(writer, format)).writeRoot();
    }

}
