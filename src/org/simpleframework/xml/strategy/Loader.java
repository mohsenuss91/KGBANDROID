// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.strategy;


class Loader
{

    Loader()
    {
    }

    private static ClassLoader getCallerClassLoader()
    {
        return org/simpleframework/xml/strategy/Loader.getClassLoader();
    }

    private static ClassLoader getClassLoader()
    {
        return Thread.currentThread().getContextClassLoader();
    }

    public Class load(String s)
    {
        ClassLoader classloader = getClassLoader();
        if (classloader == null)
        {
            classloader = getCallerClassLoader();
        }
        return classloader.loadClass(s);
    }
}
