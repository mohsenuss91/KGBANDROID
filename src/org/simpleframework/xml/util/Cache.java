// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.util;


public interface Cache
{

    public abstract void cache(Object obj, Object obj1);

    public abstract boolean contains(Object obj);

    public abstract Object fetch(Object obj);

    public abstract boolean isEmpty();

    public abstract Object take(Object obj);
}
