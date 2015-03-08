// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

// Referenced classes of package org.simpleframework.xml.core:
//            Detail, FieldDetail, MethodDetail, Reflector

class DetailScanner
    implements Detail
{

    private DefaultType access;
    private NamespaceList declaration;
    private List fields;
    private Annotation labels[];
    private List methods;
    private String name;
    private Namespace namespace;
    private Order order;
    private DefaultType override;
    private boolean required;
    private Root root;
    private boolean strict;
    private Class type;

    public DetailScanner(Class class1)
    {
        this(class1, null);
    }

    public DetailScanner(Class class1, DefaultType defaulttype)
    {
        methods = new LinkedList();
        fields = new LinkedList();
        labels = class1.getDeclaredAnnotations();
        override = defaulttype;
        strict = true;
        type = class1;
        scan(class1);
    }

    private void access(Annotation annotation)
    {
        if (annotation != null)
        {
            Default default1 = (Default)annotation;
            required = default1.required();
            access = default1.value();
        }
    }

    private void extract(Class class1)
    {
        Annotation aannotation[] = labels;
        int i = aannotation.length;
        for (int j = 0; j < i; j++)
        {
            Annotation annotation = aannotation[j];
            if (annotation instanceof Namespace)
            {
                namespace(annotation);
            }
            if (annotation instanceof NamespaceList)
            {
                scope(annotation);
            }
            if (annotation instanceof Root)
            {
                root(annotation);
            }
            if (annotation instanceof Order)
            {
                order(annotation);
            }
            if (annotation instanceof Default)
            {
                access(annotation);
            }
        }

    }

    private void fields(Class class1)
    {
        java.lang.reflect.Field afield[] = class1.getDeclaredFields();
        int i = afield.length;
        for (int j = 0; j < i; j++)
        {
            FieldDetail fielddetail = new FieldDetail(afield[j]);
            fields.add(fielddetail);
        }

    }

    private boolean isEmpty(String s)
    {
        return s.length() == 0;
    }

    private void methods(Class class1)
    {
        java.lang.reflect.Method amethod[] = class1.getDeclaredMethods();
        int i = amethod.length;
        for (int j = 0; j < i; j++)
        {
            MethodDetail methoddetail = new MethodDetail(amethod[j]);
            methods.add(methoddetail);
        }

    }

    private void namespace(Annotation annotation)
    {
        if (annotation != null)
        {
            namespace = (Namespace)annotation;
        }
    }

    private void order(Annotation annotation)
    {
        if (annotation != null)
        {
            order = (Order)annotation;
        }
    }

    private void root(Annotation annotation)
    {
        if (annotation != null)
        {
            Root root1 = (Root)annotation;
            String s = type.getSimpleName();
            if (root1 != null)
            {
                String s1 = root1.name();
                if (isEmpty(s1))
                {
                    s1 = Reflector.getName(s);
                }
                strict = root1.strict();
                root = root1;
                name = s1;
            }
        }
    }

    private void scan(Class class1)
    {
        methods(class1);
        fields(class1);
        extract(class1);
    }

    private void scope(Annotation annotation)
    {
        if (annotation != null)
        {
            declaration = (NamespaceList)annotation;
        }
    }

    public DefaultType getAccess()
    {
        if (override != null)
        {
            return override;
        } else
        {
            return access;
        }
    }

    public Annotation[] getAnnotations()
    {
        return labels;
    }

    public Constructor[] getConstructors()
    {
        return type.getDeclaredConstructors();
    }

    public List getFields()
    {
        return fields;
    }

    public List getMethods()
    {
        return methods;
    }

    public String getName()
    {
        return name;
    }

    public Namespace getNamespace()
    {
        return namespace;
    }

    public NamespaceList getNamespaceList()
    {
        return declaration;
    }

    public Order getOrder()
    {
        return order;
    }

    public DefaultType getOverride()
    {
        return override;
    }

    public Root getRoot()
    {
        return root;
    }

    public Class getSuper()
    {
        Class class1 = type.getSuperclass();
        if (class1 == java/lang/Object)
        {
            class1 = null;
        }
        return class1;
    }

    public Class getType()
    {
        return type;
    }

    public boolean isInstantiable()
    {
        while (Modifier.isStatic(type.getModifiers()) || !type.isMemberClass()) 
        {
            return true;
        }
        return false;
    }

    public boolean isPrimitive()
    {
        return type.isPrimitive();
    }

    public boolean isRequired()
    {
        return required;
    }

    public boolean isStrict()
    {
        return strict;
    }

    public String toString()
    {
        return type.toString();
    }
}
