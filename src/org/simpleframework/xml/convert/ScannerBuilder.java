// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.convert:
//            Scanner

class ScannerBuilder extends ConcurrentCache
{

    public ScannerBuilder()
    {
    }

    public Scanner build(Class class1)
    {
        Object obj = (Scanner)get(class1);
        if (obj == null)
        {
            obj = new Entry(class1);
            put(class1, obj);
        }
        return ((Scanner) (obj));
    }

    private class Entry extends ConcurrentCache
        implements Scanner
    {

        private final Class root;

        private Annotation find(Class class1)
        {
            for (Class class2 = root; class2 != null; class2 = class2.getSuperclass())
            {
                Annotation annotation = class2.getAnnotation(class1);
                if (annotation != null)
                {
                    return annotation;
                }
            }

            return null;
        }

        public Annotation scan(Class class1)
        {
            if (!contains(class1))
            {
                Annotation annotation = find(class1);
                if (class1 != null && annotation != null)
                {
                    put(class1, annotation);
                }
            }
            return (Annotation)get(class1);
        }

        public Entry(Class class1)
        {
            root = class1;
        }
    }

}
