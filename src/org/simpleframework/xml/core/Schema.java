// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

// Referenced classes of package org.simpleframework.xml.core:
//            Caller, Decorator, Instantiator, Section, 
//            Label

interface Schema
{

    public abstract Caller getCaller();

    public abstract Decorator getDecorator();

    public abstract Instantiator getInstantiator();

    public abstract Version getRevision();

    public abstract Section getSection();

    public abstract Label getText();

    public abstract Label getVersion();

    public abstract boolean isPrimitive();
}
