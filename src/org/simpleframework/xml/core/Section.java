// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            LabelMap, Label

interface Section
    extends Iterable
{

    public abstract String getAttribute(String s);

    public abstract LabelMap getAttributes();

    public abstract Label getElement(String s);

    public abstract LabelMap getElements();

    public abstract String getName();

    public abstract String getPath(String s);

    public abstract String getPrefix();

    public abstract Section getSection(String s);

    public abstract Label getText();

    public abstract boolean isSection(String s);
}
