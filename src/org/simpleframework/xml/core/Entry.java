// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.strategy.Type;

// Referenced classes of package org.simpleframework.xml.core:
//            Contact, Context, PrimitiveKey, CompositeKey, 
//            ClassType, PrimitiveValue, CompositeValue, Converter

class Entry
{

    private static final String DEFAULT_NAME = "entry";
    private boolean attribute;
    private Contact contact;
    private String entry;
    private String key;
    private Class keyType;
    private ElementMap label;
    private String value;
    private Class valueType;

    public Entry(Contact contact1, ElementMap elementmap)
    {
        attribute = elementmap.attribute();
        entry = elementmap.entry();
        value = elementmap.value();
        key = elementmap.key();
        contact = contact1;
        label = elementmap;
    }

    private Class getDependent(int i)
    {
        Class aclass[] = contact.getDependents();
        if (aclass.length < i)
        {
            return java/lang/Object;
        }
        if (aclass.length == 0)
        {
            return java/lang/Object;
        } else
        {
            return aclass[i];
        }
    }

    private boolean isEmpty(String s)
    {
        return s.length() == 0;
    }

    public Contact getContact()
    {
        return contact;
    }

    public String getEntry()
    {
        if (entry == null)
        {
            return entry;
        }
        if (isEmpty(entry))
        {
            entry = "entry";
        }
        return entry;
    }

    public String getKey()
    {
        if (key == null)
        {
            return key;
        }
        if (isEmpty(key))
        {
            key = null;
        }
        return key;
    }

    public Converter getKey(Context context)
    {
        Type type = getKeyType();
        if (context.isPrimitive(type))
        {
            return new PrimitiveKey(context, this, type);
        } else
        {
            return new CompositeKey(context, this, type);
        }
    }

    protected Type getKeyType()
    {
        if (keyType == null)
        {
            keyType = label.keyType();
            if (keyType == Void.TYPE)
            {
                keyType = getDependent(0);
            }
        }
        return new ClassType(keyType);
    }

    public String getValue()
    {
        if (value == null)
        {
            return value;
        }
        if (isEmpty(value))
        {
            value = null;
        }
        return value;
    }

    public Converter getValue(Context context)
    {
        Type type = getValueType();
        if (context.isPrimitive(type))
        {
            return new PrimitiveValue(context, this, type);
        } else
        {
            return new CompositeValue(context, this, type);
        }
    }

    protected Type getValueType()
    {
        if (valueType == null)
        {
            valueType = label.valueType();
            if (valueType == Void.TYPE)
            {
                valueType = getDependent(1);
            }
        }
        return new ClassType(valueType);
    }

    public boolean isAttribute()
    {
        return attribute;
    }

    public boolean isInline()
    {
        return isAttribute();
    }

    public String toString()
    {
        Object aobj[] = new Object[2];
        aobj[0] = label;
        aobj[1] = contact;
        return String.format("%s on %s", aobj);
    }
}
