// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            Criteria, Signature

interface Creator
{

    public abstract Object getInstance();

    public abstract Object getInstance(Criteria criteria);

    public abstract double getScore(Criteria criteria);

    public abstract Signature getSignature();

    public abstract Class getType();
}
