// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

final class Reflector
{

    Reflector()
    {
    }

    private static Class getArrayClass(Type type)
    {
        Class class1 = getClass(((GenericArrayType)type).getGenericComponentType());
        if (class1 != null)
        {
            return Array.newInstance(class1, 0).getClass();
        } else
        {
            return null;
        }
    }

    private static Class getClass(ParameterizedType parameterizedtype)
    {
        Type atype[] = parameterizedtype.getActualTypeArguments();
        if (atype.length > 0)
        {
            return getClass(atype[0]);
        } else
        {
            return null;
        }
    }

    private static Class getClass(Type type)
    {
        if (type instanceof Class)
        {
            return (Class)type;
        } else
        {
            return getGenericClass(type);
        }
    }

    private static Class[] getClasses(ParameterizedType parameterizedtype)
    {
        Type atype[] = parameterizedtype.getActualTypeArguments();
        Class aclass[] = new Class[atype.length];
        for (int i = 0; i < atype.length; i++)
        {
            aclass[i] = getClass(atype[i]);
        }

        return aclass;
    }

    public static Class getDependent(Field field)
    {
        ParameterizedType parameterizedtype = getType(field);
        if (parameterizedtype != null)
        {
            return getClass(parameterizedtype);
        } else
        {
            return java/lang/Object;
        }
    }

    public static Class[] getDependents(Field field)
    {
        ParameterizedType parameterizedtype = getType(field);
        if (parameterizedtype != null)
        {
            return getClasses(parameterizedtype);
        } else
        {
            return new Class[0];
        }
    }

    private static Class getGenericClass(Type type)
    {
        if (type instanceof GenericArrayType)
        {
            return getArrayClass(type);
        } else
        {
            return java/lang/Object;
        }
    }

    public static String getName(String s)
    {
        if (s.length() > 0)
        {
            char ac[] = s.toCharArray();
            char c = ac[0];
            if (!isAcronym(ac))
            {
                ac[0] = toLowerCase(c);
            }
            s = new String(ac);
        }
        return s;
    }

    public static Class getParameterDependent(Constructor constructor, int i)
    {
        ParameterizedType parameterizedtype = getParameterType(constructor, i);
        if (parameterizedtype != null)
        {
            return getClass(parameterizedtype);
        } else
        {
            return java/lang/Object;
        }
    }

    public static Class getParameterDependent(Method method, int i)
    {
        ParameterizedType parameterizedtype = getParameterType(method, i);
        if (parameterizedtype != null)
        {
            return getClass(parameterizedtype);
        } else
        {
            return java/lang/Object;
        }
    }

    public static Class[] getParameterDependents(Constructor constructor, int i)
    {
        ParameterizedType parameterizedtype = getParameterType(constructor, i);
        if (parameterizedtype != null)
        {
            return getClasses(parameterizedtype);
        } else
        {
            return new Class[0];
        }
    }

    public static Class[] getParameterDependents(Method method, int i)
    {
        ParameterizedType parameterizedtype = getParameterType(method, i);
        if (parameterizedtype != null)
        {
            return getClasses(parameterizedtype);
        } else
        {
            return new Class[0];
        }
    }

    private static ParameterizedType getParameterType(Constructor constructor, int i)
    {
        Type atype[] = constructor.getGenericParameterTypes();
        if (atype.length > i)
        {
            Type type = atype[i];
            if (type instanceof ParameterizedType)
            {
                return (ParameterizedType)type;
            }
        }
        return null;
    }

    private static ParameterizedType getParameterType(Method method, int i)
    {
        Type atype[] = method.getGenericParameterTypes();
        if (atype.length > i)
        {
            Type type = atype[i];
            if (type instanceof ParameterizedType)
            {
                return (ParameterizedType)type;
            }
        }
        return null;
    }

    public static Class getReturnDependent(Method method)
    {
        ParameterizedType parameterizedtype = getReturnType(method);
        if (parameterizedtype != null)
        {
            return getClass(parameterizedtype);
        } else
        {
            return java/lang/Object;
        }
    }

    public static Class[] getReturnDependents(Method method)
    {
        ParameterizedType parameterizedtype = getReturnType(method);
        if (parameterizedtype != null)
        {
            return getClasses(parameterizedtype);
        } else
        {
            return new Class[0];
        }
    }

    private static ParameterizedType getReturnType(Method method)
    {
        Type type = method.getGenericReturnType();
        if (type instanceof ParameterizedType)
        {
            return (ParameterizedType)type;
        } else
        {
            return null;
        }
    }

    private static ParameterizedType getType(Field field)
    {
        Type type = field.getGenericType();
        if (type instanceof ParameterizedType)
        {
            return (ParameterizedType)type;
        } else
        {
            return null;
        }
    }

    private static boolean isAcronym(char ac[])
    {
        while (ac.length < 2 || !isUpperCase(ac[0])) 
        {
            return false;
        }
        return isUpperCase(ac[1]);
    }

    private static boolean isUpperCase(char c)
    {
        return Character.isUpperCase(c);
    }

    private static char toLowerCase(char c)
    {
        return Character.toLowerCase(c);
    }
}
