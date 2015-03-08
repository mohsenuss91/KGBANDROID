// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            Context, RootException, Composite, ClassType, 
//            Decorator

class Traverser
{

    private final Context context;
    private final Style style;

    public Traverser(Context context1)
    {
        style = context1.getStyle();
        context = context1;
    }

    private Composite getComposite(Class class1)
    {
        Type type = getType(class1);
        if (class1 == null)
        {
            throw new RootException("Can not instantiate null class", new Object[0]);
        } else
        {
            return new Composite(context, type);
        }
    }

    private Decorator getDecorator(Class class1)
    {
        return context.getDecorator(class1);
    }

    private Type getType(Class class1)
    {
        return new ClassType(class1);
    }

    private Object read(InputNode inputnode, Class class1, Object obj)
    {
        if (getName(class1) == null)
        {
            throw new RootException("Root annotation required for %s", new Object[] {
                class1
            });
        } else
        {
            return obj;
        }
    }

    protected String getName(Class class1)
    {
        String s = context.getName(class1);
        return style.getElement(s);
    }

    public Object read(InputNode inputnode, Class class1)
    {
        Object obj = getComposite(class1).read(inputnode);
        if (obj != null)
        {
            return read(inputnode, obj.getClass(), obj);
        } else
        {
            return null;
        }
    }

    public Object read(InputNode inputnode, Object obj)
    {
        Class class1 = obj.getClass();
        return read(inputnode, class1, getComposite(class1).read(inputnode, obj));
    }

    public boolean validate(InputNode inputnode, Class class1)
    {
        Composite composite = getComposite(class1);
        if (getName(class1) == null)
        {
            throw new RootException("Root annotation required for %s", new Object[] {
                class1
            });
        } else
        {
            return composite.validate(inputnode);
        }
    }

    public void write(OutputNode outputnode, Object obj)
    {
        write(outputnode, obj, obj.getClass());
    }

    public void write(OutputNode outputnode, Object obj, Class class1)
    {
        Class class2 = obj.getClass();
        String s = getName(class2);
        if (s == null)
        {
            throw new RootException("Root annotation required for %s", new Object[] {
                class2
            });
        } else
        {
            write(outputnode, obj, class1, s);
            return;
        }
    }

    public void write(OutputNode outputnode, Object obj, Class class1, String s)
    {
        OutputNode outputnode1 = outputnode.getChild(s);
        Type type = getType(class1);
        if (obj != null)
        {
            Class class2 = obj.getClass();
            Decorator decorator = getDecorator(class2);
            if (decorator != null)
            {
                decorator.decorate(outputnode1);
            }
            if (!context.setOverride(type, obj, outputnode1))
            {
                getComposite(class2).write(outputnode1, obj);
            }
        }
        outputnode1.commit();
    }
}
