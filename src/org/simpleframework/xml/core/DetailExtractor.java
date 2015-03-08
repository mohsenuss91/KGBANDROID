// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.core:
//            FieldScanner, MethodScanner, Detail, DetailScanner, 
//            ContactList, Support

class DetailExtractor
{

    private final Cache details;
    private final Cache fields;
    private final Cache methods;
    private final DefaultType override;
    private final Support support;

    public DetailExtractor(Support support1)
    {
        this(support1, null);
    }

    public DetailExtractor(Support support1, DefaultType defaulttype)
    {
        methods = new ConcurrentCache();
        fields = new ConcurrentCache();
        details = new ConcurrentCache();
        override = defaulttype;
        support = support1;
    }

    private ContactList getFields(Class class1, Detail detail)
    {
        FieldScanner fieldscanner = new FieldScanner(detail, support);
        if (detail != null)
        {
            fields.cache(class1, fieldscanner);
        }
        return fieldscanner;
    }

    private ContactList getMethods(Class class1, Detail detail)
    {
        MethodScanner methodscanner = new MethodScanner(detail, support);
        if (detail != null)
        {
            methods.cache(class1, methodscanner);
        }
        return methodscanner;
    }

    public Detail getDetail(Class class1)
    {
        Object obj = (Detail)details.fetch(class1);
        if (obj == null)
        {
            obj = new DetailScanner(class1, override);
            details.cache(class1, obj);
        }
        return ((Detail) (obj));
    }

    public ContactList getFields(Class class1)
    {
        ContactList contactlist = (ContactList)fields.fetch(class1);
        if (contactlist == null)
        {
            Detail detail = getDetail(class1);
            if (detail != null)
            {
                contactlist = getFields(class1, detail);
            }
        }
        return contactlist;
    }

    public ContactList getMethods(Class class1)
    {
        ContactList contactlist = (ContactList)methods.fetch(class1);
        if (contactlist == null)
        {
            Detail detail = getDetail(class1);
            if (detail != null)
            {
                contactlist = getMethods(class1, detail);
            }
        }
        return contactlist;
    }
}
