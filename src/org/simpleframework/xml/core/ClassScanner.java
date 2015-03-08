// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

// Referenced classes of package org.simpleframework.xml.core:
//            ConstructorScanner, NamespaceDecorator, Detail, Function, 
//            MethodDetail, Commit, Validate, Persist, 
//            Complete, Replace, Resolve, Support, 
//            Decorator, ParameterMap, Signature

class ClassScanner
{

    private Function commit;
    private Function complete;
    private NamespaceDecorator decorator;
    private Order order;
    private Function persist;
    private Function replace;
    private Function resolve;
    private Root root;
    private ConstructorScanner scanner;
    private Support support;
    private Function validate;

    public ClassScanner(Detail detail, Support support1)
    {
        scanner = new ConstructorScanner(detail, support1);
        decorator = new NamespaceDecorator();
        support = support1;
        scan(detail);
    }

    private void commit(Method method1)
    {
        if (commit == null)
        {
            commit = getFunction(method1);
        }
    }

    private void commit(Detail detail)
    {
        org.simpleframework.xml.Namespace namespace1 = detail.getNamespace();
        if (namespace1 != null)
        {
            decorator.set(namespace1);
        }
    }

    private void complete(Method method1)
    {
        if (complete == null)
        {
            complete = getFunction(method1);
        }
    }

    private void definition(Detail detail)
    {
        if (root == null)
        {
            root = detail.getRoot();
        }
        if (order == null)
        {
            order = detail.getOrder();
        }
    }

    private Function getFunction(Method method1)
    {
        boolean flag = isContextual(method1);
        if (!method1.isAccessible())
        {
            method1.setAccessible(true);
        }
        return new Function(method1, flag);
    }

    private boolean isContextual(Method method1)
    {
        Class aclass[] = method1.getParameterTypes();
        int i = aclass.length;
        boolean flag = false;
        if (i == 1)
        {
            flag = java/util/Map.equals(aclass[0]);
        }
        return flag;
    }

    private void method(Detail detail)
    {
        for (Iterator iterator = detail.getMethods().iterator(); iterator.hasNext(); method((MethodDetail)iterator.next())) { }
    }

    private void method(MethodDetail methoddetail)
    {
        java.lang.annotation.Annotation aannotation[] = methoddetail.getAnnotations();
        Method method1 = methoddetail.getMethod();
        int i = aannotation.length;
        for (int j = 0; j < i; j++)
        {
            java.lang.annotation.Annotation annotation = aannotation[j];
            if (annotation instanceof Commit)
            {
                commit(method1);
            }
            if (annotation instanceof Validate)
            {
                validate(method1);
            }
            if (annotation instanceof Persist)
            {
                persist(method1);
            }
            if (annotation instanceof Complete)
            {
                complete(method1);
            }
            if (annotation instanceof Replace)
            {
                replace(method1);
            }
            if (annotation instanceof Resolve)
            {
                resolve(method1);
            }
        }

    }

    private void namespace(Detail detail)
    {
        NamespaceList namespacelist = detail.getNamespaceList();
        org.simpleframework.xml.Namespace namespace1 = detail.getNamespace();
        if (namespace1 != null)
        {
            decorator.add(namespace1);
        }
        if (namespacelist != null)
        {
            org.simpleframework.xml.Namespace anamespace[] = namespacelist.value();
            int i = anamespace.length;
            for (int j = 0; j < i; j++)
            {
                org.simpleframework.xml.Namespace namespace2 = anamespace[j];
                decorator.add(namespace2);
            }

        }
    }

    private void persist(Method method1)
    {
        if (persist == null)
        {
            persist = getFunction(method1);
        }
    }

    private void replace(Method method1)
    {
        if (replace == null)
        {
            replace = getFunction(method1);
        }
    }

    private void resolve(Method method1)
    {
        if (resolve == null)
        {
            resolve = getFunction(method1);
        }
    }

    private void scan(Detail detail)
    {
        org.simpleframework.xml.DefaultType defaulttype = detail.getOverride();
        Detail detail1;
        for (Class class1 = detail.getType(); class1 != null; class1 = detail1.getSuper())
        {
            detail1 = support.getDetail(class1, defaulttype);
            namespace(detail1);
            method(detail1);
            definition(detail1);
        }

        commit(detail);
    }

    private void validate(Method method1)
    {
        if (validate == null)
        {
            validate = getFunction(method1);
        }
    }

    public Function getCommit()
    {
        return commit;
    }

    public Function getComplete()
    {
        return complete;
    }

    public Decorator getDecorator()
    {
        return decorator;
    }

    public Order getOrder()
    {
        return order;
    }

    public ParameterMap getParameters()
    {
        return scanner.getParameters();
    }

    public Function getPersist()
    {
        return persist;
    }

    public Function getReplace()
    {
        return replace;
    }

    public Function getResolve()
    {
        return resolve;
    }

    public Root getRoot()
    {
        return root;
    }

    public Signature getSignature()
    {
        return scanner.getSignature();
    }

    public List getSignatures()
    {
        return scanner.getSignatures();
    }

    public Function getValidate()
    {
        return validate;
    }
}
