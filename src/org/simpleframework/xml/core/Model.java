// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            LabelMap, Expression, ModelMap, Label

interface Model
    extends Iterable
{

    public abstract LabelMap getAttributes();

    public abstract LabelMap getElements();

    public abstract Expression getExpression();

    public abstract int getIndex();

    public abstract ModelMap getModels();

    public abstract String getName();

    public abstract String getPrefix();

    public abstract Label getText();

    public abstract boolean isAttribute(String s);

    public abstract boolean isComposite();

    public abstract boolean isElement(String s);

    public abstract boolean isEmpty();

    public abstract boolean isModel(String s);

    public abstract Model lookup(String s, int i);

    public abstract Model lookup(Expression expression);

    public abstract Model register(String s, String s1, int i);

    public abstract void register(Label label);

    public abstract void registerAttribute(String s);

    public abstract void registerAttribute(Label label);

    public abstract void registerElement(String s);

    public abstract void registerElement(Label label);

    public abstract void registerText(Label label);

    public abstract void validate(Class class1);
}
