// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            Variable, Label

interface Criteria
    extends Iterable
{

    public abstract void commit(Object obj);

    public abstract Variable get(Object obj);

    public abstract Variable get(Label label);

    public abstract Variable remove(Object obj);

    public abstract Variable resolve(String s);

    public abstract void set(Label label, Object obj);
}
