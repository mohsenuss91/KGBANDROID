// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NamespaceMap;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter, ObjectFactory, Primitive, Collector, 
//            Revision, Context, Schema, Caller, 
//            Instance, Instantiator, Section, LabelMap, 
//            AttributeException, Criteria, ElementException, Label, 
//            ValueRequiredException, Variable, Contact, PersistenceException, 
//            Decorator, TextException

class Composite
    implements Converter
{

    private final Context context;
    private final Criteria criteria;
    private final ObjectFactory factory;
    private final Primitive primitive;
    private final Revision revision;
    private final Type type;

    public Composite(Context context1, Type type1)
    {
        this(context1, type1, null);
    }

    public Composite(Context context1, Type type1, Class class1)
    {
        factory = new ObjectFactory(context1, type1, class1);
        primitive = new Primitive(context1, type1);
        criteria = new Collector();
        revision = new Revision();
        context = context1;
        type = type1;
    }

    private boolean isOverridden(OutputNode outputnode, Object obj, Type type1)
    {
        return factory.setOverride(type1, obj, outputnode);
    }

    private Object read(InputNode inputnode, Instance instance, Class class1)
    {
        Schema schema = context.getSchema(class1);
        Caller caller = schema.getCaller();
        Object obj = read(schema, instance).read(inputnode);
        caller.validate(obj);
        caller.commit(obj);
        instance.setInstance(obj);
        return readResolve(inputnode, obj, caller);
    }

    private Builder read(Schema schema, Instance instance)
    {
        if (schema.getInstantiator().isDefault())
        {
            return new Builder(criteria, schema, instance);
        } else
        {
            return new Injector(this, criteria, schema, instance, null);
        }
    }

    private void read(InputNode inputnode, Object obj, Schema schema)
    {
        Section section = schema.getSection();
        readVersion(inputnode, obj, schema);
        readSection(inputnode, obj, section);
    }

    private void readAttribute(InputNode inputnode, Object obj, Section section, LabelMap labelmap)
    {
        String s = section.getAttribute(inputnode.getName());
        Label label = labelmap.getLabel(s);
        if (label == null)
        {
            org.simpleframework.xml.stream.Position position = inputnode.getPosition();
            Class class1 = context.getType(type, obj);
            if (labelmap.isStrict(context) && revision.isEqual())
            {
                throw new AttributeException("Attribute '%s' does not have a match in %s at %s", new Object[] {
                    s, class1, position
                });
            }
        } else
        {
            readInstance(inputnode, obj, label);
        }
    }

    private void readAttributes(InputNode inputnode, Object obj, Section section)
    {
        NodeMap nodemap = inputnode.getAttributes();
        LabelMap labelmap = section.getAttributes();
        Iterator iterator = nodemap.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            InputNode inputnode1 = inputnode.getAttribute((String)iterator.next());
            if (inputnode1 != null)
            {
                readAttribute(inputnode1, obj, section, labelmap);
            }
        } while (true);
        validate(inputnode, labelmap, obj);
    }

    private void readElement(InputNode inputnode, Object obj, Section section, LabelMap labelmap)
    {
        String s = section.getPath(inputnode.getName());
        Object obj1 = labelmap.getLabel(s);
        if (obj1 == null)
        {
            obj1 = criteria.resolve(s);
        }
        if (obj1 == null)
        {
            org.simpleframework.xml.stream.Position position = inputnode.getPosition();
            Class class1 = context.getType(type, obj);
            if (labelmap.isStrict(context) && revision.isEqual())
            {
                throw new ElementException("Element '%s' does not have a match in %s at %s", new Object[] {
                    s, class1, position
                });
            } else
            {
                inputnode.skip();
                return;
            }
        } else
        {
            readUnion(inputnode, obj, labelmap, ((Label) (obj1)));
            return;
        }
    }

    private void readElements(InputNode inputnode, Object obj, Section section)
    {
        LabelMap labelmap = section.getElements();
        InputNode inputnode1 = inputnode.getNext();
        while (inputnode1 != null) 
        {
            Section section1 = section.getSection(inputnode1.getName());
            if (section1 != null)
            {
                readSection(inputnode1, obj, section1);
            } else
            {
                readElement(inputnode1, obj, section, labelmap);
            }
            inputnode1 = inputnode.getNext();
        }
        validate(inputnode, labelmap, obj);
    }

    private Object readInstance(InputNode inputnode, Object obj, Label label)
    {
        Object obj1 = readVariable(inputnode, obj, label);
        if (obj1 == null)
        {
            org.simpleframework.xml.stream.Position position = inputnode.getPosition();
            Class class1 = context.getType(type, obj);
            if (label.isRequired() && revision.isEqual())
            {
                throw new ValueRequiredException("Empty value for %s in %s at %s", new Object[] {
                    label, class1, position
                });
            }
        } else
        if (obj1 != label.getEmpty(context))
        {
            criteria.set(label, obj1);
        }
        return obj1;
    }

    private Object readPrimitive(InputNode inputnode, Instance instance)
    {
        Class class1 = instance.getType();
        Object obj = primitive.read(inputnode, class1);
        if (class1 != null)
        {
            instance.setInstance(obj);
        }
        return obj;
    }

    private Object readResolve(InputNode inputnode, Object obj, Caller caller)
    {
        if (obj != null)
        {
            org.simpleframework.xml.stream.Position position = inputnode.getPosition();
            obj = caller.resolve(obj);
            Class class1 = type.getType();
            Class class2 = obj.getClass();
            if (!class1.isAssignableFrom(class2))
            {
                throw new ElementException("Type %s does not match %s at %s", new Object[] {
                    class2, class1, position
                });
            }
        }
        return obj;
    }

    private void readSection(InputNode inputnode, Object obj, Section section)
    {
        readText(inputnode, obj, section);
        readAttributes(inputnode, obj, section);
        readElements(inputnode, obj, section);
    }

    private void readText(InputNode inputnode, Object obj, Section section)
    {
        Label label = section.getText();
        if (label != null)
        {
            readInstance(inputnode, obj, label);
        }
    }

    private void readUnion(InputNode inputnode, Object obj, LabelMap labelmap, Label label)
    {
        Object obj1 = readInstance(inputnode, obj, label);
        String as[] = label.getPaths();
        int i = as.length;
        for (int j = 0; j < i; j++)
        {
            labelmap.getLabel(as[j]);
        }

        if (label.isInline())
        {
            criteria.set(label, obj1);
        }
    }

    private Object readVariable(InputNode inputnode, Object obj, Label label)
    {
        Converter converter = label.getConverter(context);
        if (label.isCollection())
        {
            Variable variable = criteria.get(label);
            Contact contact = label.getContact();
            if (variable != null)
            {
                return converter.read(inputnode, variable.getValue());
            }
            if (obj != null)
            {
                Object obj1 = contact.get(obj);
                if (obj1 != null)
                {
                    return converter.read(inputnode, obj1);
                }
            }
        }
        return converter.read(inputnode);
    }

    private void readVersion(InputNode inputnode, Object obj, Label label)
    {
        Object obj1 = readInstance(inputnode, obj, label);
        Class class1 = type.getType();
        if (obj1 != null)
        {
            Double double1 = Double.valueOf(context.getVersion(class1).revision());
            if (!obj1.equals(revision))
            {
                revision.compare(double1, obj1);
            }
        }
    }

    private void readVersion(InputNode inputnode, Object obj, Schema schema)
    {
        Label label;
        Class class1;
label0:
        {
            label = schema.getVersion();
            class1 = type.getType();
            if (label != null)
            {
                String s = label.getName();
                InputNode inputnode1 = (InputNode)inputnode.getAttributes().remove(s);
                if (inputnode1 == null)
                {
                    break label0;
                }
                readVersion(inputnode1, obj, label);
            }
            return;
        }
        Version version = context.getVersion(class1);
        Double double1 = Double.valueOf(revision.getDefault());
        Double double2 = Double.valueOf(version.revision());
        criteria.set(label, double1);
        revision.compare(double2, double1);
    }

    private void validate(InputNode inputnode, Label label)
    {
        Converter converter = label.getConverter(context);
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        Class class1 = type.getType();
        if (!converter.validate(inputnode))
        {
            throw new PersistenceException("Invalid value for %s in %s at %s", new Object[] {
                label, class1, position
            });
        } else
        {
            criteria.set(label, null);
            return;
        }
    }

    private void validate(InputNode inputnode, LabelMap labelmap)
    {
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        for (Iterator iterator = labelmap.iterator(); iterator.hasNext();)
        {
            Label label = (Label)iterator.next();
            Class class1 = type.getType();
            if (label.isRequired() && revision.isEqual())
            {
                throw new ValueRequiredException("Unable to satisfy %s for %s at %s", new Object[] {
                    label, class1, position
                });
            }
        }

    }

    private void validate(InputNode inputnode, LabelMap labelmap, Object obj)
    {
        Class class1 = context.getType(type, obj);
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        Iterator iterator = labelmap.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Label label = (Label)iterator.next();
            if (label.isRequired() && revision.isEqual())
            {
                throw new ValueRequiredException("Unable to satisfy %s for %s at %s", new Object[] {
                    label, class1, position
                });
            }
            Object obj1 = label.getEmpty(context);
            if (obj1 != null)
            {
                criteria.set(label, obj1);
            }
        } while (true);
    }

    private boolean validate(InputNode inputnode, Class class1)
    {
        Schema schema = context.getSchema(class1);
        Section section = schema.getSection();
        validateText(inputnode, schema);
        validateSection(inputnode, section);
        return inputnode.isElement();
    }

    private void validateAttribute(InputNode inputnode, Section section, LabelMap labelmap)
    {
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        String s = section.getAttribute(inputnode.getName());
        Label label = labelmap.getLabel(s);
        if (label == null)
        {
            Class class1 = type.getType();
            if (labelmap.isStrict(context) && revision.isEqual())
            {
                throw new AttributeException("Attribute '%s' does not exist for %s at %s", new Object[] {
                    s, class1, position
                });
            }
        } else
        {
            validate(inputnode, label);
        }
    }

    private void validateAttributes(InputNode inputnode, Section section)
    {
        NodeMap nodemap = inputnode.getAttributes();
        LabelMap labelmap = section.getAttributes();
        Iterator iterator = nodemap.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            InputNode inputnode1 = inputnode.getAttribute((String)iterator.next());
            if (inputnode1 != null)
            {
                validateAttribute(inputnode1, section, labelmap);
            }
        } while (true);
        validate(inputnode, labelmap);
    }

    private void validateElement(InputNode inputnode, Section section, LabelMap labelmap)
    {
        String s = section.getPath(inputnode.getName());
        Object obj = labelmap.getLabel(s);
        if (obj == null)
        {
            obj = criteria.resolve(s);
        }
        if (obj == null)
        {
            org.simpleframework.xml.stream.Position position = inputnode.getPosition();
            Class class1 = type.getType();
            if (labelmap.isStrict(context) && revision.isEqual())
            {
                throw new ElementException("Element '%s' does not exist for %s at %s", new Object[] {
                    s, class1, position
                });
            } else
            {
                inputnode.skip();
                return;
            }
        } else
        {
            validateUnion(inputnode, labelmap, ((Label) (obj)));
            return;
        }
    }

    private void validateElements(InputNode inputnode, Section section)
    {
        LabelMap labelmap = section.getElements();
        InputNode inputnode1 = inputnode.getNext();
        while (inputnode1 != null) 
        {
            Section section1 = section.getSection(inputnode1.getName());
            if (section1 != null)
            {
                validateSection(inputnode1, section1);
            } else
            {
                validateElement(inputnode1, section, labelmap);
            }
            inputnode1 = inputnode.getNext();
        }
        validate(inputnode, labelmap);
    }

    private void validateSection(InputNode inputnode, Section section)
    {
        validateAttributes(inputnode, section);
        validateElements(inputnode, section);
    }

    private void validateText(InputNode inputnode, Schema schema)
    {
        Label label = schema.getText();
        if (label != null)
        {
            validate(inputnode, label);
        }
    }

    private void validateUnion(InputNode inputnode, LabelMap labelmap, Label label)
    {
        String as[] = label.getPaths();
        int i = as.length;
        for (int j = 0; j < i; j++)
        {
            labelmap.getLabel(as[j]);
        }

        if (label.isInline())
        {
            criteria.set(label, null);
        }
        validate(inputnode, label);
    }

    private void write(OutputNode outputnode, Object obj, Schema schema)
    {
        Section section = schema.getSection();
        writeVersion(outputnode, obj, schema);
        writeSection(outputnode, obj, section);
    }

    private void writeAttribute(OutputNode outputnode, Object obj, Label label)
    {
        if (obj != null)
        {
            label.getDecorator().decorate(outputnode.setAttribute(label.getName(), factory.getText(obj)));
        }
    }

    private void writeAttributes(OutputNode outputnode, Object obj, Section section)
    {
        Label label;
        Object obj1;
        for (Iterator iterator = section.getAttributes().iterator(); iterator.hasNext(); writeAttribute(outputnode, obj1, label))
        {
            label = (Label)iterator.next();
            obj1 = label.getContact().get(obj);
            Class class1 = context.getType(type, obj);
            if (obj1 == null)
            {
                obj1 = label.getEmpty(context);
            }
            if (obj1 == null && label.isRequired())
            {
                throw new AttributeException("Value for %s is null in %s", new Object[] {
                    label, class1
                });
            }
        }

    }

    private void writeElement(OutputNode outputnode, Object obj, Converter converter)
    {
        converter.write(outputnode, obj);
    }

    private void writeElement(OutputNode outputnode, Object obj, Label label)
    {
        if (obj != null)
        {
            Class class1 = obj.getClass();
            Label label1 = label.getLabel(class1);
            String s = label1.getName();
            Type type1 = label.getType(class1);
            OutputNode outputnode1 = outputnode.getChild(s);
            if (!label1.isInline())
            {
                writeNamespaces(outputnode1, type1, label1);
            }
            if (label1.isInline() || !isOverridden(outputnode1, obj, type1))
            {
                Converter converter = label1.getConverter(context);
                outputnode1.setData(label1.isData());
                writeElement(outputnode1, obj, converter);
            }
        }
    }

    private void writeElements(OutputNode outputnode, Object obj, Section section)
    {
        Iterator iterator = section.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Section section1 = section.getSection(s);
            if (section1 != null)
            {
                writeSection(outputnode.getChild(s), obj, section1);
            } else
            {
                Label label = section.getElement(section.getPath(s));
                Class class1 = context.getType(type, obj);
                if (criteria.get(label) == null)
                {
                    if (label == null)
                    {
                        throw new ElementException("Element '%s' not defined in %s", new Object[] {
                            s, class1
                        });
                    }
                    writeUnion(outputnode, obj, section, label);
                }
            }
        } while (true);
    }

    private void writeNamespaces(OutputNode outputnode, Type type1, Label label)
    {
        Class class1 = type1.getType();
        Decorator decorator = context.getDecorator(class1);
        label.getDecorator().decorate(outputnode, decorator);
    }

    private Object writeReplace(Object obj)
    {
        if (obj != null)
        {
            Class class1 = obj.getClass();
            obj = context.getCaller(class1).replace(obj);
        }
        return obj;
    }

    private void writeSection(OutputNode outputnode, Object obj, Section section)
    {
        NamespaceMap namespacemap = outputnode.getNamespaces();
        String s = section.getPrefix();
        if (s != null)
        {
            String s1 = namespacemap.getReference(s);
            if (s1 == null)
            {
                Object aobj[] = new Object[2];
                aobj[0] = s;
                aobj[1] = type;
                throw new ElementException("Namespace prefix '%s' in %s is not in scope", aobj);
            }
            outputnode.setReference(s1);
        }
        writeAttributes(outputnode, obj, section);
        writeElements(outputnode, obj, section);
        writeText(outputnode, obj, section);
    }

    private void writeText(OutputNode outputnode, Object obj, Label label)
    {
        if (obj != null && !label.isTextList())
        {
            String s = factory.getText(obj);
            outputnode.setData(label.isData());
            outputnode.setValue(s);
        }
    }

    private void writeText(OutputNode outputnode, Object obj, Section section)
    {
        Label label = section.getText();
        if (label != null)
        {
            Object obj1 = label.getContact().get(obj);
            Class class1 = context.getType(type, obj);
            if (obj1 == null)
            {
                obj1 = label.getEmpty(context);
            }
            if (obj1 == null && label.isRequired())
            {
                throw new TextException("Value for %s is null in %s", new Object[] {
                    label, class1
                });
            }
            writeText(outputnode, obj1, label);
        }
    }

    private void writeUnion(OutputNode outputnode, Object obj, Section section, Label label)
    {
        Object obj1 = label.getContact().get(obj);
        Class class1 = context.getType(type, obj);
        if (obj1 == null && label.isRequired())
        {
            throw new ElementException("Value for %s is null in %s", new Object[] {
                label, class1
            });
        }
        Object obj2 = writeReplace(obj1);
        if (obj2 != null)
        {
            writeElement(outputnode, obj2, label);
        }
        criteria.set(label, obj2);
    }

    private void writeVersion(OutputNode outputnode, Object obj, Schema schema)
    {
        Version version = schema.getRevision();
        Label label = schema.getVersion();
        if (version != null)
        {
            Double double1 = Double.valueOf(revision.getDefault());
            Double double2 = Double.valueOf(version.revision());
            if (!revision.compare(double2, double1) || label.isRequired())
            {
                writeAttribute(outputnode, double2, label);
            }
        }
    }

    public Object read(InputNode inputnode)
    {
        Instance instance = factory.getInstance(inputnode);
        Class class1 = instance.getType();
        if (instance.isReference())
        {
            return instance.getInstance();
        }
        if (context.isPrimitive(class1))
        {
            return readPrimitive(inputnode, instance);
        } else
        {
            return read(inputnode, instance, class1);
        }
    }

    public Object read(InputNode inputnode, Object obj)
    {
        Class class1 = obj.getClass();
        Schema schema = context.getSchema(class1);
        Caller caller = schema.getCaller();
        read(inputnode, obj, schema);
        criteria.commit(obj);
        caller.validate(obj);
        caller.commit(obj);
        return readResolve(inputnode, obj, caller);
    }

    public boolean validate(InputNode inputnode)
    {
        Instance instance = factory.getInstance(inputnode);
        if (!instance.isReference())
        {
            instance.setInstance(null);
            return validate(inputnode, instance.getType());
        } else
        {
            return true;
        }
    }

    public void write(OutputNode outputnode, Object obj)
    {
        Schema schema;
        Caller caller;
        Class class1 = obj.getClass();
        schema = context.getSchema(class1);
        caller = schema.getCaller();
        if (!schema.isPrimitive()) goto _L2; else goto _L1
_L1:
        primitive.write(outputnode, obj);
_L4:
        caller.complete(obj);
        return;
_L2:
        caller.persist(obj);
        write(outputnode, obj, schema);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        caller.complete(obj);
        throw exception;
    }





    private class Builder
    {

        protected final Composite composite;
        protected final Criteria criteria;
        protected final Schema schema;
        protected final Instance value;

        public Object read(InputNode inputnode)
        {
            Object obj = value.getInstance();
            Section section = schema.getSection();
            value.setInstance(obj);
            composite.readVersion(inputnode, obj, schema);
            composite.readText(inputnode, obj, section);
            composite.readAttributes(inputnode, obj, section);
            composite.readElements(inputnode, obj, section);
            criteria.commit(obj);
            return obj;
        }

        public Builder(Criteria criteria1, Schema schema1, Instance instance)
        {
            composite = Composite.this;
            criteria = criteria1;
            schema = schema1;
            value = instance;
        }
    }


    private class Injector extends Builder
    {

        final Composite this$0;

        private Object readInject(InputNode inputnode)
        {
            Object obj = schema.getInstantiator().getInstance(criteria);
            value.setInstance(obj);
            criteria.commit(obj);
            return obj;
        }

        public Object read(InputNode inputnode)
        {
            Section section = schema.getSection();
            composite.readVersion(inputnode, null, schema);
            composite.readText(inputnode, null, section);
            composite.readAttributes(inputnode, null, section);
            composite.readElements(inputnode, null, section);
            return readInject(inputnode);
        }

        private Injector(Composite composite1, Criteria criteria1, Schema schema, Instance instance)
        {
            this$0 = Composite.this;
            composite1. super(criteria1, schema, instance);
        }

        Injector(Composite composite1, Criteria criteria1, Schema schema, Instance instance, _cls1 _pcls1)
        {
            this(composite1, criteria1, schema, instance);
        }
    }

}
