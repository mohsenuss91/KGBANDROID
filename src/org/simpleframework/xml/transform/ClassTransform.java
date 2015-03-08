// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;


// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class ClassTransform
    implements Transform
{

    private static final String BOOLEAN = "boolean";
    private static final String BYTE = "byte";
    private static final String CHARACTER = "char";
    private static final String DOUBLE = "double";
    private static final String FLOAT = "float";
    private static final String INTEGER = "int";
    private static final String LONG = "long";
    private static final String SHORT = "short";
    private static final String VOID = "void";

    ClassTransform()
    {
    }

    private ClassLoader getCallerClassLoader()
    {
        return getClass().getClassLoader();
    }

    private static ClassLoader getClassLoader()
    {
        return Thread.currentThread().getContextClassLoader();
    }

    private Class readPrimitive(String s)
    {
        if (s.equals("byte"))
        {
            return Byte.TYPE;
        }
        if (s.equals("short"))
        {
            return Short.TYPE;
        }
        if (s.equals("int"))
        {
            return Integer.TYPE;
        }
        if (s.equals("long"))
        {
            return Long.TYPE;
        }
        if (s.equals("char"))
        {
            return Character.TYPE;
        }
        if (s.equals("float"))
        {
            return Float.TYPE;
        }
        if (s.equals("double"))
        {
            return Double.TYPE;
        }
        if (s.equals("boolean"))
        {
            return Boolean.TYPE;
        }
        if (s.equals("void"))
        {
            return Void.TYPE;
        } else
        {
            return null;
        }
    }

    public Class read(String s)
    {
        Class class1 = readPrimitive(s);
        if (class1 == null)
        {
            ClassLoader classloader = getClassLoader();
            if (classloader == null)
            {
                classloader = getCallerClassLoader();
            }
            class1 = classloader.loadClass(s);
        }
        return class1;
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public String write(Class class1)
    {
        return class1.getName();
    }

    public volatile String write(Object obj)
    {
        return write((Class)obj);
    }
}
