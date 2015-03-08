// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Section, Model, Expression, LabelMap, 
//            ModelMap, ModelList, Label

class ModelSection
    implements Section
{

    private LabelMap attributes;
    private LabelMap elements;
    private Model model;
    private ModelMap models;

    public ModelSection(Model model1)
    {
        model = model1;
    }

    public String getAttribute(String s)
    {
        Expression expression = model.getExpression();
        if (expression == null)
        {
            return s;
        } else
        {
            return expression.getAttribute(s);
        }
    }

    public LabelMap getAttributes()
    {
        if (attributes == null)
        {
            attributes = model.getAttributes();
        }
        return attributes;
    }

    public Label getElement(String s)
    {
        return getElements().getLabel(s);
    }

    public LabelMap getElements()
    {
        if (elements == null)
        {
            elements = model.getElements();
        }
        return elements;
    }

    public ModelMap getModels()
    {
        if (models == null)
        {
            models = model.getModels();
        }
        return models;
    }

    public String getName()
    {
        return model.getName();
    }

    public String getPath(String s)
    {
        Expression expression = model.getExpression();
        if (expression == null)
        {
            return s;
        } else
        {
            return expression.getElement(s);
        }
    }

    public String getPrefix()
    {
        return model.getPrefix();
    }

    public Section getSection(String s)
    {
        ModelList modellist = (ModelList)getModels().get(s);
        if (modellist != null)
        {
            Model model1 = modellist.take();
            if (model1 != null)
            {
                return new ModelSection(model1);
            }
        }
        return null;
    }

    public Label getText()
    {
        return model.getText();
    }

    public boolean isSection(String s)
    {
        return getModels().get(s) != null;
    }

    public Iterator iterator()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator1 = model.iterator(); iterator1.hasNext(); arraylist.add((String)iterator1.next())) { }
        return arraylist.iterator();
    }
}
