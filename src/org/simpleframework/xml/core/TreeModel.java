// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package org.simpleframework.xml.core:
//            Model, LabelMap, ModelMap, Label, 
//            AttributeException, Expression, ModelList, ElementException, 
//            PathException, TextException, Detail, Policy

class TreeModel
    implements Model
{

    private LabelMap attributes;
    private Detail detail;
    private LabelMap elements;
    private Expression expression;
    private int index;
    private Label list;
    private ModelMap models;
    private String name;
    private OrderList order;
    private Policy policy;
    private String prefix;
    private Label text;

    public TreeModel(Policy policy1, Detail detail1)
    {
        this(policy1, detail1, null, null, 1);
    }

    public TreeModel(Policy policy1, Detail detail1, String s, String s1, int i)
    {
        attributes = new LabelMap(policy1);
        elements = new LabelMap(policy1);
        models = new ModelMap(detail1);
        order = new OrderList();
        detail = detail1;
        policy = policy1;
        prefix = s1;
        index = i;
        name = s;
    }

    private Model create(String s, String s1, int i)
    {
        TreeModel treemodel = new TreeModel(policy, detail, s, s1, i);
        if (s != null)
        {
            models.register(s, treemodel);
            order.add(s);
        }
        return treemodel;
    }

    private void validateAttributes(Class class1)
    {
        Iterator iterator1 = attributes.keySet().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            String s = (String)iterator1.next();
            if ((Label)attributes.get(s) == null)
            {
                throw new AttributeException("Ordered attribute '%s' does not exist in %s", new Object[] {
                    s, class1
                });
            }
            if (expression != null)
            {
                expression.getAttribute(s);
            }
        } while (true);
    }

    private void validateElements(Class class1)
    {
        Iterator iterator1 = elements.keySet().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            String s = (String)iterator1.next();
            ModelList modellist = (ModelList)models.get(s);
            Label label = (Label)elements.get(s);
            if (modellist == null && label == null)
            {
                throw new ElementException("Ordered element '%s' does not exist in %s", new Object[] {
                    s, class1
                });
            }
            if (modellist != null && label != null && !modellist.isEmpty())
            {
                throw new ElementException("Element '%s' is also a path name in %s", new Object[] {
                    s, class1
                });
            }
            if (expression != null)
            {
                expression.getElement(s);
            }
        } while (true);
    }

    private void validateExpression(Label label)
    {
        Expression expression1 = label.getExpression();
        if (expression != null)
        {
            String s = expression.getPath();
            String s1 = expression1.getPath();
            if (!s.equals(s1))
            {
                Object aobj[] = new Object[3];
                aobj[0] = s;
                aobj[1] = s1;
                aobj[2] = detail;
                throw new PathException("Path '%s' does not match '%s' in %s", aobj);
            }
        } else
        {
            expression = expression1;
        }
    }

    private void validateExpressions(Class class1)
    {
        Iterator iterator1 = elements.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Label label1 = (Label)iterator1.next();
            if (label1 != null)
            {
                validateExpression(label1);
            }
        } while (true);
        Iterator iterator2 = attributes.iterator();
        do
        {
            if (!iterator2.hasNext())
            {
                break;
            }
            Label label = (Label)iterator2.next();
            if (label != null)
            {
                validateExpression(label);
            }
        } while (true);
        if (text != null)
        {
            validateExpression(text);
        }
    }

    private void validateModels(Class class1)
    {
        for (Iterator iterator1 = models.iterator(); iterator1.hasNext();)
        {
            Iterator iterator2 = ((ModelList)iterator1.next()).iterator();
            int i = 1;
            while (iterator2.hasNext()) 
            {
                Model model = (Model)iterator2.next();
                int j;
                if (model != null)
                {
                    String s = model.getName();
                    int k = model.getIndex();
                    int l = i + 1;
                    if (k != i)
                    {
                        Object aobj[] = new Object[3];
                        aobj[0] = s;
                        aobj[1] = Integer.valueOf(k);
                        aobj[2] = class1;
                        throw new ElementException("Path section '%s[%s]' is out of sequence in %s", aobj);
                    }
                    model.validate(class1);
                    j = l;
                } else
                {
                    j = i;
                }
                i = j;
            }
        }

    }

    private void validateText(Class class1)
    {
        if (text != null)
        {
            if (!elements.isEmpty())
            {
                Object aobj1[] = new Object[2];
                aobj1[0] = text;
                aobj1[1] = class1;
                throw new TextException("Text annotation %s used with elements in %s", aobj1);
            }
            if (isComposite())
            {
                Object aobj[] = new Object[2];
                aobj[0] = text;
                aobj[1] = class1;
                throw new TextException("Text annotation %s can not be used with paths in %s", aobj);
            }
        }
    }

    public LabelMap getAttributes()
    {
        return attributes.getLabels();
    }

    public LabelMap getElements()
    {
        return elements.getLabels();
    }

    public Expression getExpression()
    {
        return expression;
    }

    public int getIndex()
    {
        return index;
    }

    public ModelMap getModels()
    {
        return models.getModels();
    }

    public String getName()
    {
        return name;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public Label getText()
    {
        if (list != null)
        {
            return list;
        } else
        {
            return text;
        }
    }

    public boolean isAttribute(String s)
    {
        return attributes.containsKey(s);
    }

    public boolean isComposite()
    {
        Iterator iterator1 = models.iterator();
label0:
        do
        {
            if (iterator1.hasNext())
            {
                Iterator iterator2 = ((ModelList)iterator1.next()).iterator();
                Model model;
                do
                {
                    if (!iterator2.hasNext())
                    {
                        continue label0;
                    }
                    model = (Model)iterator2.next();
                } while (model == null || model.isEmpty());
                break;
            } else
            {
                return !models.isEmpty();
            }
        } while (true);
        return true;
    }

    public boolean isElement(String s)
    {
        return elements.containsKey(s);
    }

    public boolean isEmpty()
    {
        while (text != null || !elements.isEmpty() || !attributes.isEmpty() || isComposite()) 
        {
            return false;
        }
        return true;
    }

    public boolean isModel(String s)
    {
        return models.containsKey(s);
    }

    public Iterator iterator()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator1 = order.iterator(); iterator1.hasNext(); arraylist.add((String)iterator1.next())) { }
        return arraylist.iterator();
    }

    public Model lookup(String s, int i)
    {
        return models.lookup(s, i);
    }

    public Model lookup(Expression expression1)
    {
        Model model = lookup(expression1.getFirst(), expression1.getIndex());
        if (expression1.isPath())
        {
            Expression expression2 = expression1.getPath(1, 0);
            if (model != null)
            {
                model = model.lookup(expression2);
            }
        }
        return model;
    }

    public Model register(String s, String s1, int i)
    {
        Model model = models.lookup(s, i);
        if (model == null)
        {
            model = create(s, s1, i);
        }
        return model;
    }

    public void register(Label label)
    {
        if (label.isAttribute())
        {
            registerAttribute(label);
            return;
        }
        if (label.isText())
        {
            registerText(label);
            return;
        } else
        {
            registerElement(label);
            return;
        }
    }

    public void registerAttribute(String s)
    {
        attributes.put(s, null);
    }

    public void registerAttribute(Label label)
    {
        String s = label.getName();
        if (attributes.get(s) != null)
        {
            throw new AttributeException("Duplicate annotation of name '%s' on %s", new Object[] {
                s, label
            });
        } else
        {
            attributes.put(s, label);
            return;
        }
    }

    public void registerElement(String s)
    {
        if (!order.contains(s))
        {
            order.add(s);
        }
        elements.put(s, null);
    }

    public void registerElement(Label label)
    {
        String s = label.getName();
        if (elements.get(s) != null)
        {
            throw new ElementException("Duplicate annotation of name '%s' on %s", new Object[] {
                s, label
            });
        }
        if (!order.contains(s))
        {
            order.add(s);
        }
        if (label.isTextList())
        {
            list = label;
        }
        elements.put(s, label);
    }

    public void registerText(Label label)
    {
        if (text != null)
        {
            throw new TextException("Duplicate text annotation on %s", new Object[] {
                label
            });
        } else
        {
            text = label;
            return;
        }
    }

    public String toString()
    {
        Object aobj[] = new Object[2];
        aobj[0] = name;
        aobj[1] = Integer.valueOf(index);
        return String.format("model '%s[%s]'", aobj);
    }

    public void validate(Class class1)
    {
        validateExpressions(class1);
        validateAttributes(class1);
        validateElements(class1);
        validateModels(class1);
        validateText(class1);
    }

    private class OrderList extends ArrayList
    {

        public OrderList()
        {
        }
    }

}
