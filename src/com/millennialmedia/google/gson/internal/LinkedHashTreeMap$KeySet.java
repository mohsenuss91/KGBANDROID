// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.millennialmedia.google.gson.internal:
//            LinkedHashTreeMap

class this._cls0 extends AbstractSet
{

    final LinkedHashTreeMap this$0;

    public void clear()
    {
        LinkedHashTreeMap.this.clear();
    }

    public boolean contains(Object obj)
    {
        return containsKey(obj);
    }

    public Iterator iterator()
    {
        class _cls1 extends LinkedHashTreeMap.LinkedTreeMapIterator
        {

            final LinkedHashTreeMap.KeySet this$1;

            public Object next()
            {
                return nextNode().key;
            }

            _cls1()
            {
                this$1 = LinkedHashTreeMap.KeySet.this;
                super(this$0, null);
            }
        }

        return new _cls1();
    }

    public boolean remove(Object obj)
    {
        return removeInternalByKey(obj) != null;
    }

    public int size()
    {
        return LinkedHashTreeMap.this.size;
    }

    _cls1()
    {
        this$0 = LinkedHashTreeMap.this;
        super();
    }
}
