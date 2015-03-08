// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            Group, ExtractorFactory, LabelMap, Extractor, 
//            Label, Contact

class GroupExtractor
    implements Group
{

    private final LabelMap elements = new LabelMap();
    private final ExtractorFactory factory;
    private final Annotation label;
    private final Registry registry;

    public GroupExtractor(Contact contact, Annotation annotation, Format format)
    {
        factory = new ExtractorFactory(contact, annotation, format);
        registry = new Registry(elements);
        label = annotation;
        extract();
    }

    private void extract()
    {
        Extractor extractor = factory.getInstance();
        if (extractor != null)
        {
            extract(extractor);
        }
    }

    private void extract(Extractor extractor)
    {
        Annotation aannotation[] = extractor.getAnnotations();
        int i = aannotation.length;
        for (int j = 0; j < i; j++)
        {
            extract(extractor, aannotation[j]);
        }

    }

    private void extract(Extractor extractor, Annotation annotation)
    {
        Label label1 = extractor.getLabel(annotation);
        Class class1 = extractor.getType(annotation);
        if (registry != null)
        {
            registry.register(class1, label1);
        }
    }

    public LabelMap getElements()
    {
        return elements.getLabels();
    }

    public Label getLabel(Class class1)
    {
        return registry.resolve(class1);
    }

    public String[] getNames()
    {
        return elements.getKeys();
    }

    public String[] getPaths()
    {
        return elements.getPaths();
    }

    public Label getText()
    {
        return registry.resolveText();
    }

    public boolean isDeclared(Class class1)
    {
        return registry.containsKey(class1);
    }

    public boolean isInline()
    {
        for (Iterator iterator = registry.iterator(); iterator.hasNext();)
        {
            if (!((Label)iterator.next()).isInline())
            {
                return false;
            }
        }

        return !registry.isEmpty();
    }

    public boolean isTextList()
    {
        return registry.isText();
    }

    public boolean isValid(Class class1)
    {
        return registry.resolve(class1) != null;
    }

    public String toString()
    {
        return label.toString();
    }

    private class Registry extends LinkedHashMap
        implements Iterable
    {

        private LabelMap elements;
        private Label text;

        private void registerElement(Class class1, Label label1)
        {
            String s = label1.getName();
            if (!elements.containsKey(s))
            {
                elements.put(s, label1);
            }
            if (!containsKey(class1))
            {
                put(class1, label1);
            }
        }

        private void registerText(Label label1)
        {
            Text text1 = (Text)label1.getContact().getAnnotation(org/simpleframework/xml/Text);
            if (text1 != null)
            {
                text = new TextListLabel(label1, text1);
            }
        }

        private Label resolveElement(Class class1)
        {
            for (; class1 != null; class1 = class1.getSuperclass())
            {
                Label label1 = (Label)get(class1);
                if (label1 != null)
                {
                    return label1;
                }
            }

            return null;
        }

        private Label resolveText(Class class1)
        {
            if (text != null && class1 == java/lang/String)
            {
                return text;
            } else
            {
                return null;
            }
        }

        public boolean isText()
        {
            return text != null;
        }

        public Iterator iterator()
        {
            return values().iterator();
        }

        public void register(Class class1, Label label1)
        {
            CacheLabel cachelabel = new CacheLabel(label1);
            registerElement(class1, cachelabel);
            registerText(cachelabel);
        }

        public Label resolve(Class class1)
        {
            Label label1 = resolveText(class1);
            if (label1 == null)
            {
                label1 = resolveElement(class1);
            }
            return label1;
        }

        public Label resolveText()
        {
            return resolveText(java/lang/String);
        }

        public Registry(LabelMap labelmap)
        {
            elements = labelmap;
        }
    }

}
