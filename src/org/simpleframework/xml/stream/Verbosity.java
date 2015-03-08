// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


public final class Verbosity extends Enum
{

    private static final Verbosity $VALUES[];
    public static final Verbosity HIGH;
    public static final Verbosity LOW;

    private Verbosity(String s, int i)
    {
        super(s, i);
    }

    public static Verbosity valueOf(String s)
    {
        return (Verbosity)Enum.valueOf(org/simpleframework/xml/stream/Verbosity, s);
    }

    public static Verbosity[] values()
    {
        return (Verbosity[])$VALUES.clone();
    }

    static 
    {
        HIGH = new Verbosity("HIGH", 0);
        LOW = new Verbosity("LOW", 1);
        Verbosity averbosity[] = new Verbosity[2];
        averbosity[0] = HIGH;
        averbosity[1] = LOW;
        $VALUES = averbosity;
    }
}
