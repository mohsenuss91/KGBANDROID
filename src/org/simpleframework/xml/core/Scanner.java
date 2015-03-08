// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.List;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Version;

// Referenced classes of package org.simpleframework.xml.core:
//            Policy, Context, Caller, Function, 
//            Decorator, Instantiator, ParameterMap, Section, 
//            Signature, Label

interface Scanner
    extends Policy
{

    public abstract Caller getCaller(Context context);

    public abstract Function getCommit();

    public abstract Function getComplete();

    public abstract Decorator getDecorator();

    public abstract Instantiator getInstantiator();

    public abstract String getName();

    public abstract Order getOrder();

    public abstract ParameterMap getParameters();

    public abstract Function getPersist();

    public abstract Function getReplace();

    public abstract Function getResolve();

    public abstract Version getRevision();

    public abstract Section getSection();

    public abstract Signature getSignature();

    public abstract List getSignatures();

    public abstract Label getText();

    public abstract Class getType();

    public abstract Function getValidate();

    public abstract Label getVersion();

    public abstract boolean isEmpty();

    public abstract boolean isPrimitive();

    public abstract boolean isStrict();
}
