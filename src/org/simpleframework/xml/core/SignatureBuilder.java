// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Parameter, Signature, ConstructorException

class SignatureBuilder
{

    private final Constructor factory;
    private final ParameterTable table = new ParameterTable();

    public SignatureBuilder(Constructor constructor)
    {
        factory = constructor;
    }

    private List build(ParameterTable parametertable)
    {
        if (table.isEmpty())
        {
            return create();
        } else
        {
            build(parametertable, 0);
            return create(parametertable);
        }
    }

    private void build(ParameterTable parametertable, int i)
    {
        build(parametertable, new ParameterList(), i);
    }

    private void build(ParameterTable parametertable, ParameterList parameterlist, int i)
    {
        ParameterList parameterlist1 = table.get(i);
        int j = parameterlist1.size();
        if (-1 + table.width() > i)
        {
            for (int k = 0; k < j; k++)
            {
                ParameterList parameterlist2 = new ParameterList(parameterlist);
                if (parameterlist != null)
                {
                    parameterlist2.add((Parameter)parameterlist1.get(k));
                    build(parametertable, parameterlist2, i + 1);
                }
            }

        } else
        {
            populate(parametertable, parameterlist, i);
        }
    }

    private List create()
    {
        ArrayList arraylist = new ArrayList();
        Signature signature = new Signature(factory);
        if (isValid())
        {
            arraylist.add(signature);
        }
        return arraylist;
    }

    private List create(ParameterTable parametertable)
    {
        ArrayList arraylist = new ArrayList();
        int i = parametertable.height();
        int j = parametertable.width();
        for (int k = 0; k < i; k++)
        {
            Signature signature = new Signature(factory);
            for (int l = 0; l < j; l++)
            {
                Parameter parameter = parametertable.get(l, k);
                String s = parameter.getPath();
                if (signature.contains(parameter.getKey()))
                {
                    Object aobj[] = new Object[2];
                    aobj[0] = s;
                    aobj[1] = factory;
                    throw new ConstructorException("Parameter '%s' is a duplicate in %s", aobj);
                }
                signature.add(parameter);
            }

            arraylist.add(signature);
        }

        return arraylist;
    }

    private void populate(ParameterTable parametertable, ParameterList parameterlist, int i)
    {
        ParameterList parameterlist1 = table.get(i);
        int j = parameterlist.size();
        int k = parameterlist1.size();
        for (int l = 0; l < k; l++)
        {
            for (int i1 = 0; i1 < j; i1++)
            {
                parametertable.get(i1).add((Parameter)parameterlist.get(i1));
            }

            parametertable.get(i).add((Parameter)parameterlist1.get(l));
        }

    }

    public List build()
    {
        return build(new ParameterTable());
    }

    public void insert(Parameter parameter, int i)
    {
        table.insert(parameter, i);
    }

    public boolean isValid()
    {
        Class aclass[] = factory.getParameterTypes();
        int i = table.width();
        return aclass.length == i;
    }

    private class ParameterTable extends ArrayList
    {

        private int height()
        {
            int i = width();
            int j = 0;
            if (i > 0)
            {
                j = get(0).size();
            }
            return j;
        }

        private int width()
        {
            return size();
        }

        public volatile Object get(int i)
        {
            return get(i);
        }

        public Parameter get(int i, int j)
        {
            return (Parameter)get(i).get(j);
        }

        public ParameterList get(int i)
        {
            for (int j = size(); j <= i; j++)
            {
                add(new ParameterList());
            }

            return (ParameterList)super.get(i);
        }

        public void insert(Parameter parameter, int i)
        {
            ParameterList parameterlist = get(i);
            if (parameterlist != null)
            {
                parameterlist.add(parameter);
            }
        }



        public ParameterTable()
        {
        }
    }


    private class ParameterList extends ArrayList
    {

        public ParameterList()
        {
        }

        public ParameterList(ParameterList parameterlist)
        {
            super(parameterlist);
        }
    }

}
