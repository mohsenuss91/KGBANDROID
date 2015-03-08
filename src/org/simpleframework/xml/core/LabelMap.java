// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package org.simpleframework.xml.core:
//            Label, Context, Policy

class LabelMap extends LinkedHashMap
    implements Iterable
{

    private final Policy policy;

    public LabelMap()
    {
        this(null);
    }

    public LabelMap(Policy policy1)
    {
        policy = policy1;
    }

    private String[] getArray(Set set)
    {
        return (String[])set.toArray(new String[0]);
    }

    public String[] getKeys()
    {
        HashSet hashset = new HashSet();
        Iterator iterator1 = iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Label label = (Label)iterator1.next();
            if (label != null)
            {
                String s = label.getPath();
                String s1 = label.getName();
                hashset.add(s);
                hashset.add(s1);
            }
        } while (true);
        return getArray(hashset);
    }

    public Label getLabel(String s)
    {
        return (Label)remove(s);
    }

    public LabelMap getLabels()
    {
        LabelMap labelmap = new LabelMap(policy);
        Iterator iterator1 = iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Label label = (Label)iterator1.next();
            if (label != null)
            {
                labelmap.put(label.getPath(), label);
            }
        } while (true);
        return labelmap;
    }

    public String[] getPaths()
    {
        HashSet hashset = new HashSet();
        Iterator iterator1 = iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Label label = (Label)iterator1.next();
            if (label != null)
            {
                hashset.add(label.getPath());
            }
        } while (true);
        return getArray(hashset);
    }

    public boolean isStrict(Context context)
    {
        if (policy == null)
        {
            return context.isStrict();
        }
        return context.isStrict() && policy.isStrict();
    }

    public Iterator iterator()
    {
        return values().iterator();
    }
}
