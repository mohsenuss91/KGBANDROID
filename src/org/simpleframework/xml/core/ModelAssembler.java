// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            Support, ExpressionBuilder, Expression, PathException, 
//            Model, Detail

class ModelAssembler
{

    private final ExpressionBuilder builder;
    private final Detail detail;
    private final Format format;

    public ModelAssembler(ExpressionBuilder expressionbuilder, Detail detail1, Support support)
    {
        format = support.getFormat();
        builder = expressionbuilder;
        detail = detail1;
    }

    private void assembleAttributes(Model model, Order order)
    {
        String as[] = order.attributes();
        int i = as.length;
        int j = 0;
        while (j < i) 
        {
            String s = as[j];
            Expression expression = builder.build(s);
            if (!expression.isAttribute() && expression.isPath())
            {
                Object aobj[] = new Object[2];
                aobj[0] = expression;
                aobj[1] = detail;
                throw new PathException("Ordered attribute '%s' references an element in %s", aobj);
            }
            if (!expression.isPath())
            {
                model.registerAttribute(format.getStyle().getAttribute(s));
            } else
            {
                registerAttributes(model, expression);
            }
            j++;
        }
    }

    private void assembleElements(Model model, Order order)
    {
        String as[] = order.elements();
        int i = as.length;
        for (int j = 0; j < i; j++)
        {
            String s = as[j];
            Expression expression = builder.build(s);
            if (expression.isAttribute())
            {
                Object aobj[] = new Object[2];
                aobj[0] = expression;
                aobj[1] = detail;
                throw new PathException("Ordered element '%s' references an attribute in %s", aobj);
            }
            registerElements(model, expression);
        }

    }

    private void registerAttribute(Model model, Expression expression)
    {
        String s = expression.getFirst();
        if (s != null)
        {
            model.registerAttribute(s);
        }
    }

    private void registerAttributes(Model model, Expression expression)
    {
        do
        {
            String s = expression.getPrefix();
            String s1 = expression.getFirst();
            int i = expression.getIndex();
            if (expression.isPath())
            {
                model = model.register(s1, s, i);
                expression = expression.getPath(1);
                if (model == null)
                {
                    Object aobj[] = new Object[2];
                    aobj[0] = s1;
                    aobj[1] = detail;
                    throw new PathException("Element '%s' does not exist in %s", aobj);
                }
            } else
            {
                registerAttribute(model, expression);
                return;
            }
        } while (true);
    }

    private void registerElement(Model model, Expression expression)
    {
        String s = expression.getPrefix();
        String s1 = expression.getFirst();
        int i = expression.getIndex();
        if (i > 1 && model.lookup(s1, i - 1) == null)
        {
            Object aobj[] = new Object[3];
            aobj[0] = s1;
            aobj[1] = expression;
            aobj[2] = detail;
            throw new PathException("Ordered element '%s' in path '%s' is out of sequence for %s", aobj);
        } else
        {
            model.register(s1, s, i);
            return;
        }
    }

    private void registerElements(Model model, Expression expression)
    {
        String s = expression.getPrefix();
        String s1 = expression.getFirst();
        int i = expression.getIndex();
        if (s1 != null)
        {
            Model model1 = model.register(s1, s, i);
            Expression expression1 = expression.getPath(1);
            if (expression.isPath())
            {
                registerElements(model1, expression1);
            }
        }
        registerElement(model, expression);
    }

    public void assemble(Model model, Order order)
    {
        assembleElements(model, order);
        assembleAttributes(model, order);
    }
}
