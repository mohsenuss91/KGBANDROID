// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;
import org.simpleframework.xml.transform.Transformer;

// Referenced classes of package org.simpleframework.xml.core:
//            EmptyMatcher, DetailExtractor, ScannerFactory, LabelExtractor, 
//            InstanceFactory, Reflector, Scanner, Detail, 
//            ContactList, Instance, Contact, Label

class Support
    implements Filter
{

    private final DetailExtractor defaults;
    private final DetailExtractor details;
    private final Filter filter;
    private final Format format;
    private final InstanceFactory instances;
    private final LabelExtractor labels;
    private final Matcher matcher;
    private final ScannerFactory scanners;
    private final Transformer transform;

    public Support()
    {
        this(((Filter) (new PlatformFilter())));
    }

    public Support(Filter filter1)
    {
        this(filter1, ((Matcher) (new EmptyMatcher())));
    }

    public Support(Filter filter1, Matcher matcher1)
    {
        this(filter1, matcher1, new Format());
    }

    public Support(Filter filter1, Matcher matcher1, Format format1)
    {
        defaults = new DetailExtractor(this, DefaultType.FIELD);
        transform = new Transformer(matcher1);
        scanners = new ScannerFactory(this);
        details = new DetailExtractor(this);
        labels = new LabelExtractor(format1);
        instances = new InstanceFactory();
        matcher = matcher1;
        filter = filter1;
        format = format1;
    }

    private String getClassName(Class class1)
    {
        if (class1.isArray())
        {
            class1 = class1.getComponentType();
        }
        String s = class1.getSimpleName();
        if (class1.isPrimitive())
        {
            return s;
        } else
        {
            return Reflector.getName(s);
        }
    }

    public static Class getPrimitive(Class class1)
    {
        if (class1 == Double.TYPE)
        {
            class1 = java/lang/Double;
        } else
        {
            if (class1 == Float.TYPE)
            {
                return java/lang/Float;
            }
            if (class1 == Integer.TYPE)
            {
                return java/lang/Integer;
            }
            if (class1 == Long.TYPE)
            {
                return java/lang/Long;
            }
            if (class1 == Boolean.TYPE)
            {
                return java/lang/Boolean;
            }
            if (class1 == Character.TYPE)
            {
                return java/lang/Character;
            }
            if (class1 == Short.TYPE)
            {
                return java/lang/Short;
            }
            if (class1 == Byte.TYPE)
            {
                return java/lang/Byte;
            }
        }
        return class1;
    }

    public static boolean isAssignable(Class class1, Class class2)
    {
        if (class1.isPrimitive())
        {
            class1 = getPrimitive(class1);
        }
        if (class2.isPrimitive())
        {
            class2 = getPrimitive(class2);
        }
        return class2.isAssignableFrom(class1);
    }

    public static boolean isFloat(Class class1)
    {
        while (class1 == java/lang/Double || class1 == java/lang/Float || class1 == Float.TYPE || class1 == Double.TYPE) 
        {
            return true;
        }
        return false;
    }

    public Detail getDetail(Class class1)
    {
        return getDetail(class1, null);
    }

    public Detail getDetail(Class class1, DefaultType defaulttype)
    {
        if (defaulttype != null)
        {
            return defaults.getDetail(class1);
        } else
        {
            return details.getDetail(class1);
        }
    }

    public ContactList getFields(Class class1)
    {
        return getFields(class1, null);
    }

    public ContactList getFields(Class class1, DefaultType defaulttype)
    {
        if (defaulttype != null)
        {
            return defaults.getFields(class1);
        } else
        {
            return details.getFields(class1);
        }
    }

    public Format getFormat()
    {
        return format;
    }

    public Instance getInstance(Class class1)
    {
        return instances.getInstance(class1);
    }

    public Instance getInstance(Value value)
    {
        return instances.getInstance(value);
    }

    public Label getLabel(Contact contact, Annotation annotation)
    {
        return labels.getLabel(contact, annotation);
    }

    public List getLabels(Contact contact, Annotation annotation)
    {
        return labels.getList(contact, annotation);
    }

    public ContactList getMethods(Class class1)
    {
        return getMethods(class1, null);
    }

    public ContactList getMethods(Class class1, DefaultType defaulttype)
    {
        if (defaulttype != null)
        {
            return defaults.getMethods(class1);
        } else
        {
            return details.getMethods(class1);
        }
    }

    public String getName(Class class1)
    {
        String s = getScanner(class1).getName();
        if (s != null)
        {
            return s;
        } else
        {
            return getClassName(class1);
        }
    }

    public Scanner getScanner(Class class1)
    {
        return scanners.getInstance(class1);
    }

    public Style getStyle()
    {
        return format.getStyle();
    }

    public Transform getTransform(Class class1)
    {
        return matcher.match(class1);
    }

    public boolean isContainer(Class class1)
    {
        while (java/util/Collection.isAssignableFrom(class1) || java/util/Map.isAssignableFrom(class1)) 
        {
            return true;
        }
        return class1.isArray();
    }

    public boolean isPrimitive(Class class1)
    {
        while (class1 == java/lang/String || class1 == java/lang/Float || class1 == java/lang/Double || class1 == java/lang/Long || class1 == java/lang/Integer || class1 == java/lang/Boolean || class1.isEnum() || class1.isPrimitive()) 
        {
            return true;
        }
        return transform.valid(class1);
    }

    public Object read(String s, Class class1)
    {
        return transform.read(s, class1);
    }

    public String replace(String s)
    {
        return filter.replace(s);
    }

    public boolean valid(Class class1)
    {
        return transform.valid(class1);
    }

    public String write(Object obj, Class class1)
    {
        return transform.write(obj, class1);
    }
}
