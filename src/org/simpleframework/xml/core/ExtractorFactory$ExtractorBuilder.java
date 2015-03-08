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

    private final Class label;
    private final Class type;

    private Constructor getConstructor()
    {
        Class class1 = type;
        Class aclass[] = new Class[3];
        aclass[0] = org/simpleframework/xml/core/Contact;
        aclass[1] = label;
        aclass[2] = org/simpleframework/xml/stream/Format;
        return class1.getConstructor(aclass);
    }


    public (Class class1, Class class2)
    {
        label = class1;
        type = class2;
    }
}
