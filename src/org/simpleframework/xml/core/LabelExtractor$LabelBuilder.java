// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            Contact

class type
{

    private final Class entry;
    private final Class label;
    private final Class type;

    private Constructor getConstructor(Class class1)
    {
        return type.getConstructor(new Class[] {
            org/simpleframework/xml/core/Contact, class1, org/simpleframework/xml/stream/Format
        });
    }

    private Constructor getConstructor(Class class1, Class class2)
    {
        return type.getConstructor(new Class[] {
            org/simpleframework/xml/core/Contact, class1, class2, org/simpleframework/xml/stream/Format
        });
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

    public (Class class1, Class class2)
    {
        this(class1, class2, null);
    }

    public <init>(Class class1, Class class2, Class class3)
    {
        entry = class3;
        label = class2;
        type = class1;
    }
}
