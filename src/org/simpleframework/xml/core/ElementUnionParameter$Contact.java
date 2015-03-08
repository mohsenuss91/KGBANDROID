// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.Element;

// Referenced classes of package org.simpleframework.xml.core:
//            ParameterContact

class  extends ParameterContact
{

    public String getName()
    {
        return ((Element)label).name();
    }

    public (Element element, Constructor constructor, int i)
    {
        super(element, constructor, i);
    }
}
