// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

// Referenced classes of package org.simpleframework.xml.core:
//            Expression

interface Parameter
{

    public abstract Annotation getAnnotation();

    public abstract Expression getExpression();

    public abstract int getIndex();

    public abstract Object getKey();

    public abstract String getName();

    public abstract String getPath();

    public abstract Class getType();

    public abstract boolean isAttribute();

    public abstract boolean isPrimitive();

    public abstract boolean isRequired();

    public abstract boolean isText();

    public abstract String toString();
}
