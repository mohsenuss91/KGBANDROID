// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Section, LabelMap, Scanner, Label

class scanner
    implements Section
{

    private final List list = new LinkedList();
    private final Scanner scanner;

    public String getAttribute(String s)
    {
        return null;
    }

    public LabelMap getAttributes()
    {
        return new LabelMap(scanner);
    }

    public Label getElement(String s)
    {
        return null;
    }

    public LabelMap getElements()
    {
        return new LabelMap(scanner);
    }

    public String getName()
    {
        return null;
    }

    public String getPath(String s)
    {
        return null;
    }

    public String getPrefix()
    {
        return null;
    }

    public Section getSection(String s)
    {
        return null;
    }

    public Label getText()
    {
        return null;
    }

    public boolean isSection(String s)
    {
        return false;
    }

    public Iterator iterator()
    {
        return list.iterator();
    }

    public (Scanner scanner1)
    {
        scanner = scanner1;
    }
}
