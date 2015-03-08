// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.simpleframework.xml.Text;

// Referenced classes of package org.simpleframework.xml.core:
//            Label, LabelMap, Contact, TextListLabel, 
//            CacheLabel

class elements extends LinkedHashMap
    implements Iterable
{

    private LabelMap elements;
    private Label text;

    private void registerElement(Class class1, Label label)
    {
        String s = label.getName();
        if (!elements.containsKey(s))
        {
            elements.put(s, label);
        }
        if (!containsKey(class1))
        {
            put(class1, label);
        }
    }

    private void registerText(Label label)
    {
        Text text1 = (Text)label.getContact().getAnnotation(org/simpleframework/xml/Text);
        if (text1 != null)
        {
            text = new TextListLabel(label, text1);
        }
    }

    private Label resolveElement(Class class1)
    {
        for (; class1 != null; class1 = class1.getSuperclass())
        {
            Label label = (Label)get(class1);
            if (label != null)
            {
                return label;
            }
        }

        return null;
    }

    private Label resolveText(Class class1)
    {
        if (text != null && class1 == java/lang/String)
        {
            return text;
        } else
        {
            return null;
        }
    }

    public boolean isText()
    {
        return text != null;
    }

    public Iterator iterator()
    {
        return values().iterator();
    }

    public void register(Class class1, Label label)
    {
        CacheLabel cachelabel = new CacheLabel(label);
        registerElement(class1, cachelabel);
        registerText(cachelabel);
    }

    public Label resolve(Class class1)
    {
        Label label = resolveText(class1);
        if (label == null)
        {
            label = resolveElement(class1);
        }
        return label;
    }

    public Label resolveText()
    {
        return resolveText(java/lang/String);
    }

    public (LabelMap labelmap)
    {
        elements = labelmap;
    }
}
