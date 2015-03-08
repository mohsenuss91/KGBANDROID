// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            Position, EventNode

class InputPosition
    implements Position
{

    private EventNode source;

    public InputPosition(EventNode eventnode)
    {
        source = eventnode;
    }

    public int getLine()
    {
        return source.getLine();
    }

    public String toString()
    {
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(getLine());
        return String.format("line %s", aobj);
    }
}
