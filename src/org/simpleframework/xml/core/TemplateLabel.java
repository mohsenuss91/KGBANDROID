// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;

// Referenced classes of package org.simpleframework.xml.core:
//            Label, KeyBuilder

abstract class TemplateLabel
    implements Label
{

    private final KeyBuilder builder = new KeyBuilder(this);

    protected TemplateLabel()
    {
    }

    public Type getDependent()
    {
        return null;
    }

    public String getEntry()
    {
        return null;
    }

    public Object getKey()
    {
        return builder.getKey();
    }

    public Label getLabel(Class class1)
    {
        return this;
    }

    public String[] getNames()
    {
        return (new String[] {
            getPath(), getName()
        });
    }

    public String[] getPaths()
    {
        return (new String[] {
            getPath()
        });
    }

    public Type getType(Class class1)
    {
        return getContact();
    }

    public boolean isAttribute()
    {
        return false;
    }

    public boolean isCollection()
    {
        return false;
    }

    public boolean isInline()
    {
        return false;
    }

    public boolean isText()
    {
        return false;
    }

    public boolean isTextList()
    {
        return false;
    }

    public boolean isUnion()
    {
        return false;
    }
}
