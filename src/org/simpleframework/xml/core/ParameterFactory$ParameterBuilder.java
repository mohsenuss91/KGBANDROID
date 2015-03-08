// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.stream.Format;

class type
{

    private final Class entry;
    private final Class label;
    private final Class type;

    private transient Constructor getConstructor(Class aclass[])
    {
        return type.getConstructor(aclass);
    }

    public Constructor getConstructor()
    {
        if (entry != null)
        {
            return getConstructor(label, entry);
        } else
        {
            return getConstructor(label);
        }
    }

    public Constructor getConstructor(Class class1)
    {
        Class aclass[] = new Class[4];
        aclass[0] = java/lang/reflect/Constructor;
        aclass[1] = class1;
        aclass[2] = org/simpleframework/xml/stream/Format;
        aclass[3] = Integer.TYPE;
        return getConstructor(aclass);
    }

    public Constructor getConstructor(Class class1, Class class2)
    {
        Class aclass[] = new Class[5];
        aclass[0] = java/lang/reflect/Constructor;
        aclass[1] = class1;
        aclass[2] = class2;
        aclass[3] = org/simpleframework/xml/stream/Format;
        aclass[4] = Integer.TYPE;
        return getConstructor(aclass);
    }

    public (Class class1, Class class2)
    {
        this(class1, class2, null);
    }

    public <init>(Class class1, Class class2, Class class3)
    {
        label = class2;
        entry = class3;
        type = class1;
    }
}
