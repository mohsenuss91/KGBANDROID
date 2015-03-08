// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

// Referenced classes of package org.simpleframework.xml.core:
//            Label, Contact, ModelSection, Instantiator, 
//            Model, Section

class Structure
{

    private final Instantiator factory;
    private final Model model;
    private final boolean primitive;
    private final Label text;
    private final Label version;

    public Structure(Instantiator instantiator, Model model1, Label label, Label label1, boolean flag)
    {
        primitive = flag;
        factory = instantiator;
        version = label;
        model = model1;
        text = label1;
    }

    public Instantiator getInstantiator()
    {
        return factory;
    }

    public Version getRevision()
    {
        if (version != null)
        {
            return (Version)version.getContact().getAnnotation(org/simpleframework/xml/Version);
        } else
        {
            return null;
        }
    }

    public Section getSection()
    {
        return new ModelSection(model);
    }

    public Label getText()
    {
        return text;
    }

    public Label getVersion()
    {
        return version;
    }

    public boolean isPrimitive()
    {
        return primitive;
    }
}
