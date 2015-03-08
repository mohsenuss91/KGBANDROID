// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.Attribute;

// Referenced classes of package org.simpleframework.xml.core:
//            ParameterContact

class  extends ParameterContact
{

    public String getName()
    {
        return ((Attribute)label).name();
    }

    public (Attribute attribute, Constructor constructor, int i)
    {
        super(attribute, constructor, i);
    }
}
