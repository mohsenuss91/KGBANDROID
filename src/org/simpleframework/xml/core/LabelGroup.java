// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Arrays;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Label

class LabelGroup
{

    private final List list;
    private final int size;

    public LabelGroup(List list1)
    {
        size = list1.size();
        list = list1;
    }

    public LabelGroup(Label label)
    {
        this(Arrays.asList(new Label[] {
            label
        }));
    }

    public List getList()
    {
        return list;
    }

    public Label getPrimary()
    {
        if (size > 0)
        {
            return (Label)list.get(0);
        } else
        {
            return null;
        }
    }
}
