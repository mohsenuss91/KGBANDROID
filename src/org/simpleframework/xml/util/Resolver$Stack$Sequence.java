// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.util;

import java.util.Iterator;

// Referenced classes of package org.simpleframework.xml.util:
//            Match

class cursor
    implements Iterator
{

    private int cursor;
    final cursor this$1;

    public boolean hasNext()
    {
        return cursor > 0;
    }

    public volatile Object next()
    {
        return next();
    }

    public Match next()
    {
        if (hasNext())
        {
            next next1 = this._cls1.this;
            int i = -1 + cursor;
            cursor = i;
            return (Match)next1.cursor(i);
        } else
        {
            return null;
        }
    }

    public void remove()
    {
        cursor.this.cursor(cursor);
    }

    public ()
    {
        this$1 = this._cls1.this;
        super();
        cursor = cursor.this.cursor();
    }
}
