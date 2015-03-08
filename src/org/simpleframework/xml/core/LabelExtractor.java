// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.core:
//            ElementLabel, ElementListLabel, ElementArrayLabel, ElementMapLabel, 
//            ElementUnionLabel, ElementListUnionLabel, ElementMapUnionLabel, AttributeLabel, 
//            VersionLabel, TextLabel, PersistenceException, LabelGroup, 
//            LabelKey, Label, CacheLabel, Contact

class LabelExtractor
{

    private final Cache cache = new ConcurrentCache();
    private final Format format;

    public LabelExtractor(Format format1)
    {
        format = format1;
    }

    private Annotation[] getAnnotations(Annotation annotation)
    {
        Method amethod[] = annotation.annotationType().getDeclaredMethods();
        if (amethod.length > 0)
        {
            return (Annotation[])(Annotation[])amethod[0].invoke(annotation, new Object[0]);
        } else
        {
            return new Annotation[0];
        }
    }

    private LabelBuilder getBuilder(Annotation annotation)
    {
        if (annotation instanceof Element)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementLabel, org/simpleframework/xml/Element);
        }
        if (annotation instanceof ElementList)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementListLabel, org/simpleframework/xml/ElementList);
        }
        if (annotation instanceof ElementArray)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementArrayLabel, org/simpleframework/xml/ElementArray);
        }
        if (annotation instanceof ElementMap)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementMapLabel, org/simpleframework/xml/ElementMap);
        }
        if (annotation instanceof ElementUnion)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementUnionLabel, org/simpleframework/xml/ElementUnion, org/simpleframework/xml/Element);
        }
        if (annotation instanceof ElementListUnion)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementListUnionLabel, org/simpleframework/xml/ElementListUnion, org/simpleframework/xml/ElementList);
        }
        if (annotation instanceof ElementMapUnion)
        {
            return new LabelBuilder(org/simpleframework/xml/core/ElementMapUnionLabel, org/simpleframework/xml/ElementMapUnion, org/simpleframework/xml/ElementMap);
        }
        if (annotation instanceof Attribute)
        {
            return new LabelBuilder(org/simpleframework/xml/core/AttributeLabel, org/simpleframework/xml/Attribute);
        }
        if (annotation instanceof Version)
        {
            return new LabelBuilder(org/simpleframework/xml/core/VersionLabel, org/simpleframework/xml/Version);
        }
        if (annotation instanceof Text)
        {
            return new LabelBuilder(org/simpleframework/xml/core/TextLabel, org/simpleframework/xml/Text);
        } else
        {
            throw new PersistenceException("Annotation %s not supported", new Object[] {
                annotation
            });
        }
    }

    private Constructor getConstructor(Annotation annotation)
    {
        Constructor constructor = getBuilder(annotation).getConstructor();
        if (!constructor.isAccessible())
        {
            constructor.setAccessible(true);
        }
        return constructor;
    }

    private LabelGroup getGroup(Contact contact, Annotation annotation, Object obj)
    {
        LabelGroup labelgroup = (LabelGroup)cache.fetch(obj);
        if (labelgroup == null)
        {
            labelgroup = getLabels(contact, annotation);
            if (labelgroup != null)
            {
                cache.cache(obj, labelgroup);
            }
        }
        return labelgroup;
    }

    private Object getKey(Contact contact, Annotation annotation)
    {
        return new LabelKey(contact, annotation);
    }

    private Label getLabel(Contact contact, Annotation annotation, Annotation annotation1)
    {
        Constructor constructor = getConstructor(annotation);
        if (annotation1 != null)
        {
            Object aobj1[] = new Object[4];
            aobj1[0] = contact;
            aobj1[1] = annotation;
            aobj1[2] = annotation1;
            aobj1[3] = format;
            return (Label)constructor.newInstance(aobj1);
        } else
        {
            Object aobj[] = new Object[3];
            aobj[0] = contact;
            aobj[1] = annotation;
            aobj[2] = format;
            return (Label)constructor.newInstance(aobj);
        }
    }

    private LabelGroup getLabels(Contact contact, Annotation annotation)
    {
        if (annotation instanceof ElementUnion)
        {
            return getUnion(contact, annotation);
        }
        if (annotation instanceof ElementListUnion)
        {
            return getUnion(contact, annotation);
        }
        if (annotation instanceof ElementMapUnion)
        {
            return getUnion(contact, annotation);
        } else
        {
            return getSingle(contact, annotation);
        }
    }

    private LabelGroup getSingle(Contact contact, Annotation annotation)
    {
        Label label = getLabel(contact, annotation, null);
        Object obj;
        if (label != null)
        {
            obj = new CacheLabel(label);
        } else
        {
            obj = label;
        }
        return new LabelGroup(((Label) (obj)));
    }

    private LabelGroup getUnion(Contact contact, Annotation annotation)
    {
        Annotation aannotation[] = getAnnotations(annotation);
        if (aannotation.length > 0)
        {
            LinkedList linkedlist = new LinkedList();
            int i = aannotation.length;
            int j = 0;
            while (j < i) 
            {
                Label label = getLabel(contact, annotation, aannotation[j]);
                Object obj;
                if (label != null)
                {
                    obj = new CacheLabel(label);
                } else
                {
                    obj = label;
                }
                linkedlist.add(obj);
                j++;
            }
            return new LabelGroup(linkedlist);
        } else
        {
            return null;
        }
    }

    public Label getLabel(Contact contact, Annotation annotation)
    {
        LabelGroup labelgroup = getGroup(contact, annotation, getKey(contact, annotation));
        if (labelgroup != null)
        {
            return labelgroup.getPrimary();
        } else
        {
            return null;
        }
    }

    public List getList(Contact contact, Annotation annotation)
    {
        LabelGroup labelgroup = getGroup(contact, annotation, getKey(contact, annotation));
        if (labelgroup != null)
        {
            return labelgroup.getList();
        } else
        {
            return Collections.emptyList();
        }
    }

    private class LabelBuilder
    {

        private final Class entry;
        private final Class label;
        private final Class type;

        private Constructor getConstructor(Class class1)
        {
            return type.getConstructor(new Class[] {
                org/simpleframework/xml/core/Contact, class1, org/simpleframework/xml/stream/Format
            });
        }

        private Constructor getConstructor(Class class1, Class class2)
        {
            return type.getConstructor(new Class[] {
                org/simpleframework/xml/core/Contact, class1, class2, org/simpleframework/xml/stream/Format
            });
        }

        public Constructor getConstructor()
        {
            if (entry != null)
            {
                return getConstructor(label, entry);
            } else
            {
                return getConstructor(label);
            }
        }

        public LabelBuilder(Class class1, Class class2)
        {
            this(class1, class2, null);
        }

        public LabelBuilder(Class class1, Class class2, Class class3)
        {
            entry = class3;
            label = class2;
            type = class1;
        }
    }

}
