// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import java.math.BigInteger;

// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class BigIntegerTransform
    implements Transform
{

    BigIntegerTransform()
    {
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public BigInteger read(String s)
    {
        return new BigInteger(s);
    }

    public volatile String write(Object obj)
    {
        return write((BigInteger)obj);
    }

    public String write(BigInteger biginteger)
    {
        return biginteger.toString();
    }
}
