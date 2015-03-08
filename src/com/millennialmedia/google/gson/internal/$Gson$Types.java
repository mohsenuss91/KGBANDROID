// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class ditions
{

    static final Type EMPTY_TYPE_ARRAY[] = new Type[0];

    public static GenericArrayType arrayOf(Type type)
    {
        class GenericArrayTypeImpl
            implements Serializable, GenericArrayType
        {

            private static final long serialVersionUID;
            private final Type componentType;

            public final boolean equals(Object obj)
            {
                return (obj instanceof GenericArrayType) && .Gson.Types.equals(this, (GenericArrayType)obj);
            }

            public final Type getGenericComponentType()
            {
                return componentType;
            }

            public final int hashCode()
            {
                return componentType.hashCode();
            }

            public final String toString()
            {
                return (new StringBuilder()).append(.Gson.Types.typeToString(componentType)).append("[]").toString();
            }

            public GenericArrayTypeImpl(Type type)
            {
                componentType = .Gson.Types.canonicalize(type);
            }
        }

        return new GenericArrayTypeImpl(type);
    }

    public static Type canonicalize(Type type)
    {
        if (type instanceof Class)
        {
            Class class1 = (Class)type;
            Object obj;
            if (class1.isArray())
            {
                obj = new GenericArrayTypeImpl(canonicalize(((Type) (class1.getComponentType()))));
            } else
            {
                obj = class1;
            }
            return (Type)obj;
        }
        if (type instanceof ParameterizedType)
        {
            ParameterizedType parameterizedtype = (ParameterizedType)type;
            class ParameterizedTypeImpl
                implements Serializable, ParameterizedType
            {

                private static final long serialVersionUID;
                private final Type ownerType;
                private final Type rawType;
                private final Type typeArguments[];

                public final boolean equals(Object obj1)
                {
                    return (obj1 instanceof ParameterizedType) && .Gson.Types.equals(this, (ParameterizedType)obj1);
                }

                public final Type[] getActualTypeArguments()
                {
                    return (Type[])typeArguments.clone();
                }

                public final Type getOwnerType()
                {
                    return ownerType;
                }

                public final Type getRawType()
                {
                    return rawType;
                }

                public final int hashCode()
                {
                    return Arrays.hashCode(typeArguments) ^ rawType.hashCode() ^ .Gson.Types.hashCodeOrZero(ownerType);
                }

                public final String toString()
                {
                    StringBuilder stringbuilder = new StringBuilder(30 * (1 + typeArguments.length));
                    stringbuilder.append(.Gson.Types.typeToString(rawType));
                    if (typeArguments.length == 0)
                    {
                        return stringbuilder.toString();
                    }
                    stringbuilder.append("<").append(.Gson.Types.typeToString(typeArguments[0]));
                    for (int i = 1; i < typeArguments.length; i++)
                    {
                        stringbuilder.append(", ").append(.Gson.Types.typeToString(typeArguments[i]));
                    }

                    return stringbuilder.append(">").toString();
                }

            public transient ParameterizedTypeImpl(Type type, Type type1, Type atype[])
            {
                boolean flag = true;
                int i = 0;
                super();
                Type type2;
                if (type1 instanceof Class)
                {
                    Class class1 = (Class)type1;
                    boolean flag1;
                    if (type != null || class1.getEnclosingClass() == null)
                    {
                        flag1 = flag;
                    } else
                    {
                        flag1 = false;
                    }
                    .Gson.Preconditions.checkArgument(flag1);
                    if (type != null && class1.getEnclosingClass() == null)
                    {
                        flag = false;
                    }
                    .Gson.Preconditions.checkArgument(flag);
                }
                if (type == null)
                {
                    type2 = null;
                } else
                {
                    type2 = .Gson.Types.canonicalize(type);
                }
                ownerType = type2;
                rawType = .Gson.Types.canonicalize(type1);
                for (typeArguments = (Type[])atype.clone(); i < typeArguments.length; i++)
                {
                    .Gson.Preconditions.checkNotNull(typeArguments[i]);
                    .Gson.Types.checkNotPrimitive(typeArguments[i]);
                    typeArguments[i] = .Gson.Types.canonicalize(typeArguments[i]);
                }

            }
            }

            return new ParameterizedTypeImpl(parameterizedtype.getOwnerType(), parameterizedtype.getRawType(), parameterizedtype.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType)
        {
            return new GenericArrayTypeImpl(((GenericArrayType)type).getGenericComponentType());
        }
        if (type instanceof WildcardType)
        {
            WildcardType wildcardtype = (WildcardType)type;
            class WildcardTypeImpl
                implements Serializable, WildcardType
            {

                private static final long serialVersionUID;
                private final Type lowerBound;
                private final Type upperBound;

                public final boolean equals(Object obj1)
                {
                    return (obj1 instanceof WildcardType) && .Gson.Types.equals(this, (WildcardType)obj1);
                }

                public final Type[] getLowerBounds()
                {
                    if (lowerBound != null)
                    {
                        Type atype[] = new Type[1];
                        atype[0] = lowerBound;
                        return atype;
                    } else
                    {
                        return .Gson.Types.EMPTY_TYPE_ARRAY;
                    }
                }

                public final Type[] getUpperBounds()
                {
                    Type atype[] = new Type[1];
                    atype[0] = upperBound;
                    return atype;
                }

                public final int hashCode()
                {
                    int i;
                    if (lowerBound != null)
                    {
                        i = 31 + lowerBound.hashCode();
                    } else
                    {
                        i = 1;
                    }
                    return i ^ 31 + upperBound.hashCode();
                }

                public final String toString()
                {
                    if (lowerBound != null)
                    {
                        return (new StringBuilder("? super ")).append(.Gson.Types.typeToString(lowerBound)).toString();
                    }
                    if (upperBound == java/lang/Object)
                    {
                        return "?";
                    } else
                    {
                        return (new StringBuilder("? extends ")).append(.Gson.Types.typeToString(upperBound)).toString();
                    }
                }

            public WildcardTypeImpl(Type atype[], Type atype1[])
            {
                boolean flag = true;
                super();
                boolean flag1;
                boolean flag2;
                if (atype1.length <= flag)
                {
                    flag1 = flag;
                } else
                {
                    flag1 = false;
                }
                .Gson.Preconditions.checkArgument(flag1);
                if (atype.length == flag)
                {
                    flag2 = flag;
                } else
                {
                    flag2 = false;
                }
                .Gson.Preconditions.checkArgument(flag2);
                if (atype1.length == flag)
                {
                    .Gson.Preconditions.checkNotNull(atype1[0]);
                    .Gson.Types.checkNotPrimitive(atype1[0]);
                    if (atype[0] != java/lang/Object)
                    {
                        flag = false;
                    }
                    .Gson.Preconditions.checkArgument(flag);
                    lowerBound = .Gson.Types.canonicalize(atype1[0]);
                    upperBound = java/lang/Object;
                    return;
                } else
                {
                    .Gson.Preconditions.checkNotNull(atype[0]);
                    .Gson.Types.checkNotPrimitive(atype[0]);
                    lowerBound = null;
                    upperBound = .Gson.Types.canonicalize(atype[0]);
                    return;
                }
            }
            }

            return new WildcardTypeImpl(wildcardtype.getUpperBounds(), wildcardtype.getLowerBounds());
        } else
        {
            return type;
        }
    }

    private static void checkNotPrimitive(Type type)
    {
        boolean flag;
        if (!(type instanceof Class) || !((Class)type).isPrimitive())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ditions.checkArgument(flag);
    }

    private static Class declaringClassOf(TypeVariable typevariable)
    {
        java.lang.reflect.GenericDeclaration genericdeclaration = typevariable.getGenericDeclaration();
        if (genericdeclaration instanceof Class)
        {
            return (Class)genericdeclaration;
        } else
        {
            return null;
        }
    }

    static boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static boolean equals(Type type, Type type1)
    {
        Type type2 = type1;
        Type type3 = type;
        do
        {
            if (type3 == type2)
            {
                return true;
            }
            if (type3 instanceof Class)
            {
                return type3.equals(type2);
            }
            if (type3 instanceof ParameterizedType)
            {
                if (!(type2 instanceof ParameterizedType))
                {
                    return false;
                }
                ParameterizedType parameterizedtype = (ParameterizedType)type3;
                ParameterizedType parameterizedtype1 = (ParameterizedType)type2;
                return equal(parameterizedtype.getOwnerType(), parameterizedtype1.getOwnerType()) && parameterizedtype.getRawType().equals(parameterizedtype1.getRawType()) && Arrays.equals(parameterizedtype.getActualTypeArguments(), parameterizedtype1.getActualTypeArguments());
            }
            if (!(type3 instanceof GenericArrayType))
            {
                break;
            }
            if (!(type2 instanceof GenericArrayType))
            {
                return false;
            }
            GenericArrayType genericarraytype = (GenericArrayType)type3;
            GenericArrayType genericarraytype1 = (GenericArrayType)type2;
            type3 = genericarraytype.getGenericComponentType();
            type2 = genericarraytype1.getGenericComponentType();
        } while (true);
        if (type3 instanceof WildcardType)
        {
            if (!(type2 instanceof WildcardType))
            {
                return false;
            }
            WildcardType wildcardtype = (WildcardType)type3;
            WildcardType wildcardtype1 = (WildcardType)type2;
            return Arrays.equals(wildcardtype.getUpperBounds(), wildcardtype1.getUpperBounds()) && Arrays.equals(wildcardtype.getLowerBounds(), wildcardtype1.getLowerBounds());
        }
        if (type3 instanceof TypeVariable)
        {
            if (!(type2 instanceof TypeVariable))
            {
                return false;
            }
            TypeVariable typevariable = (TypeVariable)type3;
            TypeVariable typevariable1 = (TypeVariable)type2;
            return typevariable.getGenericDeclaration() == typevariable1.getGenericDeclaration() && typevariable.getName().equals(typevariable1.getName());
        } else
        {
            return false;
        }
    }

    public static Type getArrayComponentType(Type type)
    {
        if (type instanceof GenericArrayType)
        {
            return ((GenericArrayType)type).getGenericComponentType();
        } else
        {
            return ((Class)type).getComponentType();
        }
    }

    public static Type getCollectionElementType(Type type, Class class1)
    {
        Type type1 = getSupertype(type, class1, java/util/Collection);
        if (type1 instanceof WildcardType)
        {
            type1 = ((WildcardType)type1).getUpperBounds()[0];
        }
        if (type1 instanceof ParameterizedType)
        {
            return ((ParameterizedType)type1).getActualTypeArguments()[0];
        } else
        {
            return java/lang/Object;
        }
    }

    static Type getGenericSupertype(Type type, Class class1, Class class2)
    {
        Class class3;
        Type type1;
        class3 = class1;
        type1 = type;
_L3:
        if (class2 != class3) goto _L2; else goto _L1
_L1:
        class2 = type1;
_L6:
        return class2;
_L2:
        Class aclass[];
        int i;
        int j;
        if (!class2.isInterface())
        {
            continue; /* Loop/switch isn't completed */
        }
        aclass = class3.getInterfaces();
        i = 0;
        j = aclass.length;
_L4:
label0:
        {
            if (i >= j)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (aclass[i] == class2)
            {
                return class3.getGenericInterfaces()[i];
            }
            if (!class2.isAssignableFrom(aclass[i]))
            {
                break label0;
            }
            Type type3 = class3.getGenericInterfaces()[i];
            class3 = aclass[i];
            type1 = type3;
        }
          goto _L3
        i++;
          goto _L4
        if (class3.isInterface()) goto _L6; else goto _L5
_L5:
        if (class3 == java/lang/Object) goto _L6; else goto _L7
_L7:
        Class class4;
label1:
        {
            class4 = class3.getSuperclass();
            if (class4 == class2)
            {
                return class3.getGenericSuperclass();
            }
            if (!class2.isAssignableFrom(class4))
            {
                break label1;
            }
            Type type2 = class3.getGenericSuperclass();
            class3 = class4;
            type1 = type2;
        }
          goto _L3
        class3 = class4;
          goto _L5
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class class1)
    {
        if (type == java/util/Properties)
        {
            return (new Type[] {
                java/lang/String, java/lang/String
            });
        }
        Type type1 = getSupertype(type, class1, java/util/Map);
        if (type1 instanceof ParameterizedType)
        {
            return ((ParameterizedType)type1).getActualTypeArguments();
        } else
        {
            return (new Type[] {
                java/lang/Object, java/lang/Object
            });
        }
    }

    public static Class getRawType(Type type)
    {
        Type type1 = type;
        do
        {
            if (type1 instanceof Class)
            {
                return (Class)type1;
            }
            if (type1 instanceof ParameterizedType)
            {
                Type type2 = ((ParameterizedType)type1).getRawType();
                ditions.checkArgument(type2 instanceof Class);
                return (Class)type2;
            }
            if (type1 instanceof GenericArrayType)
            {
                return Array.newInstance(getRawType(((GenericArrayType)type1).getGenericComponentType()), 0).getClass();
            }
            if (type1 instanceof TypeVariable)
            {
                return java/lang/Object;
            }
            if (!(type1 instanceof WildcardType))
            {
                break;
            }
            type1 = ((WildcardType)type1).getUpperBounds()[0];
        } while (true);
        String s;
        if (type1 == null)
        {
            s = "null";
        } else
        {
            s = type1.getClass().getName();
        }
        throw new IllegalArgumentException((new StringBuilder("Expected a Class, ParameterizedType, or GenericArrayType, but <")).append(type1).append("> is of type ").append(s).toString());
    }

    static Type getSupertype(Type type, Class class1, Class class2)
    {
        ditions.checkArgument(class2.isAssignableFrom(class1));
        return resolve(type, class1, getGenericSupertype(type, class1, class2));
    }

    private static int hashCodeOrZero(Object obj)
    {
        if (obj != null)
        {
            return obj.hashCode();
        } else
        {
            return 0;
        }
    }

    private static int indexOf(Object aobj[], Object obj)
    {
        for (int i = 0; i < aobj.length; i++)
        {
            if (obj.equals(aobj[i]))
            {
                return i;
            }
        }

        throw new NoSuchElementException();
    }

    public static transient ParameterizedType newParameterizedTypeWithOwner(Type type, Type type1, Type atype[])
    {
        return new ParameterizedTypeImpl(type, type1, atype);
    }

    public static Type resolve(Type type, Class class1, Type type1)
    {
        Object obj = type1;
_L14:
        if (!(obj instanceof TypeVariable)) goto _L2; else goto _L1
_L1:
        TypeVariable typevariable;
        Type type10;
        typevariable = (TypeVariable)obj;
        type10 = resolveTypeVariable(type, class1, typevariable);
        if (type10 != typevariable) goto _L4; else goto _L3
_L3:
        obj = type10;
_L6:
        return ((Type) (obj));
_L4:
        obj = type10;
        continue; /* Loop/switch isn't completed */
_L2:
        if (!(obj instanceof Class) || !((Class)obj).isArray())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Class)obj;
        Class class2 = ((Class) (obj)).getComponentType();
        Type type9 = resolve(type, class1, ((Type) (class2)));
        if (class2 != type9)
        {
            return arrayOf(type9);
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (!(obj instanceof GenericArrayType))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (GenericArrayType)obj;
        Type type7 = ((GenericArrayType) (obj)).getGenericComponentType();
        Type type8 = resolve(type, class1, type7);
        if (type7 != type8)
        {
            return arrayOf(type8);
        }
        if (true) goto _L6; else goto _L7
_L7:
        Type type5;
        boolean flag;
        Type atype3[];
        if (!(obj instanceof ParameterizedType))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (ParameterizedType)obj;
        Type type4 = ((ParameterizedType) (obj)).getOwnerType();
        type5 = resolve(type, class1, type4);
        Type atype2[];
        int i;
        if (type5 != type4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        atype2 = ((ParameterizedType) (obj)).getActualTypeArguments();
        i = atype2.length;
        atype3 = atype2;
        for (int j = 0; j < i; j++)
        {
            Type type6 = resolve(type, class1, atype3[j]);
            if (type6 == atype3[j])
            {
                continue;
            }
            if (!flag)
            {
                atype3 = (Type[])atype3.clone();
                flag = true;
            }
            atype3[j] = type6;
        }

        if (!flag) goto _L6; else goto _L8
_L8:
        return newParameterizedTypeWithOwner(type5, ((ParameterizedType) (obj)).getRawType(), atype3);
        if (!(obj instanceof WildcardType)) goto _L6; else goto _L9
_L9:
        Type atype[];
        Type atype1[];
        Type type3;
        obj = (WildcardType)obj;
        atype = ((WildcardType) (obj)).getLowerBounds();
        atype1 = ((WildcardType) (obj)).getUpperBounds();
        if (atype.length != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        type3 = resolve(type, class1, atype[0]);
        if (type3 == atype[0]) goto _L6; else goto _L10
_L10:
        return supertypeOf(type3);
        if (atype1.length != 1) goto _L6; else goto _L11
_L11:
        Type type2 = resolve(type, class1, atype1[0]);
        if (type2 == atype1[0]) goto _L6; else goto _L12
_L12:
        return subtypeOf(type2);
        if (true) goto _L14; else goto _L13
_L13:
    }

    static Type resolveTypeVariable(Type type, Class class1, TypeVariable typevariable)
    {
        Class class2 = declaringClassOf(typevariable);
        Type type1;
        if (class2 != null)
        {
            if ((type1 = getGenericSupertype(type, class1, class2)) instanceof ParameterizedType)
            {
                int i = indexOf(class2.getTypeParameters(), typevariable);
                return ((ParameterizedType)type1).getActualTypeArguments()[i];
            }
        }
        return typevariable;
    }

    public static WildcardType subtypeOf(Type type)
    {
        return new WildcardTypeImpl(new Type[] {
            type
        }, EMPTY_TYPE_ARRAY);
    }

    public static WildcardType supertypeOf(Type type)
    {
        return new WildcardTypeImpl(new Type[] {
            java/lang/Object
        }, new Type[] {
            type
        });
    }

    public static String typeToString(Type type)
    {
        if (type instanceof Class)
        {
            return ((Class)type).getName();
        } else
        {
            return type.toString();
        }
    }




    private ditions()
    {
    }
}
