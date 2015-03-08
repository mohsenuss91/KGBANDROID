// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            Caller, Decorator, Instance, Schema, 
//            Session, Support

interface Context
{

    public abstract Object getAttribute(Object obj);

    public abstract Caller getCaller(Class class1);

    public abstract Decorator getDecorator(Class class1);

    public abstract Instance getInstance(Class class1);

    public abstract Instance getInstance(Value value);

    public abstract String getName(Class class1);

    public abstract Value getOverride(Type type, InputNode inputnode);

    public abstract String getProperty(String s);

    public abstract Schema getSchema(Class class1);

    public abstract Session getSession();

    public abstract Style getStyle();

    public abstract Support getSupport();

    public abstract Class getType(Type type, Object obj);

    public abstract Version getVersion(Class class1);

    public abstract boolean isFloat(Class class1);

    public abstract boolean isFloat(Type type);

    public abstract boolean isPrimitive(Class class1);

    public abstract boolean isPrimitive(Type type);

    public abstract boolean isStrict();

    public abstract boolean setOverride(Type type, Object obj, OutputNode outputnode);
}
