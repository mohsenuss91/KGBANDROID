// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            OutputNode, PrefixResolver, OutputNodeMap, Mode, 
//            NodeWriter, NamespaceMap, NodeMap, Node

class OutputElement
    implements OutputNode
{

    private String comment;
    private Mode mode;
    private String name;
    private OutputNode parent;
    private String reference;
    private NamespaceMap scope;
    private OutputNodeMap table;
    private String value;
    private NodeWriter writer;

    public OutputElement(OutputNode outputnode, NodeWriter nodewriter, String s)
    {
        scope = new PrefixResolver(outputnode);
        table = new OutputNodeMap(this);
        mode = Mode.INHERIT;
        writer = nodewriter;
        parent = outputnode;
        name = s;
    }

    public void commit()
    {
        writer.commit(this);
    }

    public volatile NodeMap getAttributes()
    {
        return getAttributes();
    }

    public OutputNodeMap getAttributes()
    {
        return table;
    }

    public OutputNode getChild(String s)
    {
        return writer.writeElement(this, s);
    }

    public String getComment()
    {
        return comment;
    }

    public Mode getMode()
    {
        return mode;
    }

    public String getName()
    {
        return name;
    }

    public NamespaceMap getNamespaces()
    {
        return scope;
    }

    public volatile Node getParent()
    {
        return getParent();
    }

    public OutputNode getParent()
    {
        return parent;
    }

    public String getPrefix()
    {
        return getPrefix(true);
    }

    public String getPrefix(boolean flag)
    {
        String s = scope.getPrefix(reference);
        if (flag && s == null)
        {
            s = parent.getPrefix();
        }
        return s;
    }

    public String getReference()
    {
        return reference;
    }

    public String getValue()
    {
        return value;
    }

    public boolean isCommitted()
    {
        return writer.isCommitted(this);
    }

    public boolean isRoot()
    {
        return writer.isRoot(this);
    }

    public void remove()
    {
        writer.remove(this);
    }

    public OutputNode setAttribute(String s, String s1)
    {
        return table.put(s, s1);
    }

    public void setComment(String s)
    {
        comment = s;
    }

    public void setData(boolean flag)
    {
        if (flag)
        {
            mode = Mode.DATA;
            return;
        } else
        {
            mode = Mode.ESCAPE;
            return;
        }
    }

    public void setMode(Mode mode1)
    {
        mode = mode1;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setReference(String s)
    {
        reference = s;
    }

    public void setValue(String s)
    {
        value = s;
    }

    public String toString()
    {
        Object aobj[] = new Object[1];
        aobj[0] = name;
        return String.format("element %s", aobj);
    }
}
