// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

// Referenced classes of package org.simpleframework.xml.core:
//            AnnotationFactory, MethodType, Reflector, MethodException, 
//            MethodName, SetPart, GetPart, Detail, 
//            Support, MethodPart

class MethodPartFactory
{

    private final AnnotationFactory factory;

    public MethodPartFactory(Detail detail, Support support)
    {
        factory = new AnnotationFactory(detail, support);
    }

    private Annotation getAnnotation(Method method)
    {
        Class aclass[] = getDependents(method);
        Class class1 = getType(method);
        if (class1 != null)
        {
            return factory.getInstance(class1, aclass);
        } else
        {
            return null;
        }
    }

    private Class[] getDependents(Method method)
    {
        MethodType methodtype = getMethodType(method);
        if (methodtype == MethodType.SET)
        {
            return Reflector.getParameterDependents(method, 0);
        }
        if (methodtype == MethodType.GET)
        {
            return Reflector.getReturnDependents(method);
        }
        if (methodtype == MethodType.IS)
        {
            return Reflector.getReturnDependents(method);
        } else
        {
            return null;
        }
    }

    private MethodType getMethodType(Method method)
    {
        String s = method.getName();
        if (s.startsWith("get"))
        {
            return MethodType.GET;
        }
        if (s.startsWith("is"))
        {
            return MethodType.IS;
        }
        if (s.startsWith("set"))
        {
            return MethodType.SET;
        } else
        {
            return MethodType.NONE;
        }
    }

    private MethodName getName(Method method, Annotation annotation)
    {
        MethodType methodtype = getMethodType(method);
        if (methodtype == MethodType.GET)
        {
            return getRead(method, methodtype);
        }
        if (methodtype == MethodType.IS)
        {
            return getRead(method, methodtype);
        }
        if (methodtype == MethodType.SET)
        {
            return getWrite(method, methodtype);
        } else
        {
            throw new MethodException("Annotation %s must mark a set or get method", new Object[] {
                annotation
            });
        }
    }

    private Class getParameterType(Method method)
    {
        if (method.getParameterTypes().length == 1)
        {
            return method.getParameterTypes()[0];
        } else
        {
            return null;
        }
    }

    private MethodName getRead(Method method, MethodType methodtype)
    {
        Class aclass[] = method.getParameterTypes();
        String s = method.getName();
        if (aclass.length != 0)
        {
            throw new MethodException("Get method %s is not a valid property", new Object[] {
                method
            });
        }
        String s1 = getTypeName(s, methodtype);
        if (s1 == null)
        {
            throw new MethodException("Could not get name for %s", new Object[] {
                method
            });
        } else
        {
            return new MethodName(method, methodtype, s1);
        }
    }

    private Class getReturnType(Method method)
    {
        if (method.getParameterTypes().length == 0)
        {
            return method.getReturnType();
        } else
        {
            return null;
        }
    }

    private String getTypeName(String s, MethodType methodtype)
    {
        int i = methodtype.getPrefix();
        int j = s.length();
        if (j > i)
        {
            s = s.substring(i, j);
        }
        return Reflector.getName(s);
    }

    private MethodName getWrite(Method method, MethodType methodtype)
    {
        Class aclass[] = method.getParameterTypes();
        String s = method.getName();
        if (aclass.length != 1)
        {
            throw new MethodException("Set method %s is not a valid property", new Object[] {
                method
            });
        }
        String s1 = getTypeName(s, methodtype);
        if (s1 == null)
        {
            throw new MethodException("Could not get name for %s", new Object[] {
                method
            });
        } else
        {
            return new MethodName(method, methodtype, s1);
        }
    }

    public MethodPart getInstance(Method method, Annotation annotation, Annotation aannotation[])
    {
        MethodName methodname = getName(method, annotation);
        if (methodname.getType() == MethodType.SET)
        {
            return new SetPart(methodname, annotation, aannotation);
        } else
        {
            return new GetPart(methodname, annotation, aannotation);
        }
    }

    public MethodPart getInstance(Method method, Annotation aannotation[])
    {
        Annotation annotation = getAnnotation(method);
        if (annotation != null)
        {
            return getInstance(method, annotation, aannotation);
        } else
        {
            return null;
        }
    }

    public Class getType(Method method)
    {
        MethodType methodtype = getMethodType(method);
        if (methodtype == MethodType.SET)
        {
            return getParameterType(method);
        }
        if (methodtype == MethodType.GET)
        {
            return getReturnType(method);
        }
        if (methodtype == MethodType.IS)
        {
            return getReturnType(method);
        } else
        {
            return null;
        }
    }
}
