// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            OutputNode, OutputNodeMap, Mode, OutputStack, 
//            NodeException, NodeWriter, NodeMap, NamespaceMap, 
//            Node

class OutputDocument
    implements OutputNode
{

    private String comment;
    private Mode mode;
    private String name;
    private String reference;
    private OutputStack stack;
    private OutputNodeMap table;
    private String value;
    private NodeWriter writer;

    public OutputDocument(NodeWriter nodewriter, OutputStack outputstack)
    {
        table = new OutputNodeMap(this);
        mode = Mode.INHERIT;
        writer = nodewriter;
        stack = outputstack;
    }

    public void commit()
    {
        if (stack.isEmpty())
        {
            throw new NodeException("No root node");
        } else
        {
            stack.bottom().commit();
            return;
        }
    }

    public NodeMap getAttributes()
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
        return null;
    }

    public NamespaceMap getNamespaces()
    {
        return null;
    }

    public volatile Node getParent()
    {
        return getParent();
    }

    public OutputNode getParent()
    {
        return null;
    }

    public String getPrefix()
    {
        return null;
    }

    public String getPrefix(boolean flag)
    {
        return null;
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
        return stack.isEmpty();
    }

    public boolean isRoot()
    {
        return true;
    }

    public void remove()
    {
        if (stack.isEmpty())
        {
            throw new NodeException("No root node");
        } else
        {
            stack.bottom().remove();
            return;
        }
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
}
