// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

// Referenced classes of package org.simpleframework.xml.core:
//            Schema, Scanner, Caller, Decorator, 
//            Instantiator, Section, Label, Context

class ClassSchema
    implements Schema
{

    private final Caller caller;
    private final Decorator decorator;
    private final Instantiator factory;
    private final boolean primitive;
    private final Version revision;
    private final Section section;
    private final Label text;
    private final Class type;
    private final Label version;

    public ClassSchema(Scanner scanner, Context context)
    {
        caller = scanner.getCaller(context);
        factory = scanner.getInstantiator();
        revision = scanner.getRevision();
        decorator = scanner.getDecorator();
        primitive = scanner.isPrimitive();
        version = scanner.getVersion();
        section = scanner.getSection();
        text = scanner.getText();
        type = scanner.getType();
    }

    public Caller getCaller()
    {
        return caller;
    }

    public Decorator getDecorator()
    {
        return decorator;
    }

    public Instantiator getInstantiator()
    {
        return factory;
    }

    public Version getRevision()
    {
        return revision;
    }

    public Section getSection()
    {
        return section;
    }

    public Label getText()
    {
        return text;
    }

    public Label getVersion()
    {
        return version;
    }

    public boolean isPrimitive()
    {
        return primitive;
    }

    public String toString()
    {
        Object aobj[] = new Object[1];
        aobj[0] = type;
        return String.format("schema for %s", aobj);
    }
}
