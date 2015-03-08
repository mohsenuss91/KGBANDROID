// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            Session

class session
{

    private int count;
    private Session session;

    public int clear()
    {
        int i = -1 + count;
        count = i;
        return i;
    }

    public Session get()
    {
        if (count >= 0)
        {
            count = 1 + count;
        }
        return session;
    }

    public (boolean flag)
    {
        session = new Session(flag);
    }
}
