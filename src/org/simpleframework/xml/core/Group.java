// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            LabelMap, Label

interface Group
{

    public abstract LabelMap getElements();

    public abstract Label getLabel(Class class1);

    public abstract Label getText();

    public abstract boolean isInline();

    public abstract boolean isTextList();

    public abstract String toString();
}
