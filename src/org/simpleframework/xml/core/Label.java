// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

// Referenced classes of package org.simpleframework.xml.core:
//            Contact, Context, Converter, Decorator, 
//            Expression

interface Label
{

    public abstract Annotation getAnnotation();

    public abstract Contact getContact();

    public abstract Converter getConverter(Context context);

    public abstract Decorator getDecorator();

    public abstract Type getDependent();

    public abstract Object getEmpty(Context context);

    public abstract String getEntry();

    public abstract Expression getExpression();

    public abstract Object getKey();

    public abstract Label getLabel(Class class1);

    public abstract String getName();

    public abstract String[] getNames();

    public abstract String getOverride();

    public abstract String getPath();

    public abstract String[] getPaths();

    public abstract Class getType();

    public abstract Type getType(Class class1);

    public abstract boolean isAttribute();

    public abstract boolean isCollection();

    public abstract boolean isData();

    public abstract boolean isInline();

    public abstract boolean isRequired();

    public abstract boolean isText();

    public abstract boolean isTextList();

    public abstract boolean isUnion();

    public abstract String toString();
}
