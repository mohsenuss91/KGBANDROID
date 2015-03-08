// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;


// Referenced classes of package org.simpleframework.xml.transform:
//            Matcher, ArrayTransform, CharacterArrayTransform, StringArrayTransform, 
//            Transform

class ArrayMatcher
    implements Matcher
{

    private final Matcher primary;

    public ArrayMatcher(Matcher matcher)
    {
        primary = matcher;
    }

    private Transform matchArray(Class class1)
    {
        Transform transform = primary.match(class1);
        if (transform == null)
        {
            return null;
        } else
        {
            return new ArrayTransform(transform, class1);
        }
    }

    public Transform match(Class class1)
    {
        Class class2 = class1.getComponentType();
        if (class2 == Character.TYPE)
        {
            return new CharacterArrayTransform(class2);
        }
        if (class2 == java/lang/Character)
        {
            return new CharacterArrayTransform(class2);
        }
        if (class2 == java/lang/String)
        {
            return new StringArrayTransform();
        } else
        {
            return matchArray(class2);
        }
    }
}
