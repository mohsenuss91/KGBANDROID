// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.io.Writer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package org.simpleframework.xml.stream:
//            Format, Formatter, OutputStack, OutputNode, 
//            NodeMap, NamespaceMap, OutputElement, NodeException, 
//            Mode, OutputDocument

class NodeWriter
{

    private final Set active;
    private final OutputStack stack;
    private final boolean verbose;
    private final Formatter writer;

    public NodeWriter(Writer writer1)
    {
        this(writer1, new Format());
    }

    public NodeWriter(Writer writer1, Format format)
    {
        this(writer1, format, false);
    }

    private NodeWriter(Writer writer1, Format format, boolean flag)
    {
        writer = new Formatter(writer1, format);
        active = new HashSet();
        stack = new OutputStack(active);
        verbose = flag;
    }

    private void writeAttributes(OutputNode outputnode)
    {
        NodeMap nodemap = outputnode.getAttributes();
        String s;
        String s1;
        String s2;
        for (Iterator iterator = nodemap.iterator(); iterator.hasNext(); writer.writeAttribute(s, s1, s2))
        {
            s = (String)iterator.next();
            OutputNode outputnode1 = (OutputNode)nodemap.get(s);
            s1 = outputnode1.getValue();
            s2 = outputnode1.getPrefix(verbose);
        }

        active.remove(outputnode);
    }

    private void writeComment(OutputNode outputnode)
    {
        String s = outputnode.getComment();
        if (s != null)
        {
            writer.writeComment(s);
        }
    }

    private void writeEnd(OutputNode outputnode)
    {
        String s = outputnode.getName();
        String s1 = outputnode.getPrefix(verbose);
        if (outputnode.getValue() != null)
        {
            writeValue(outputnode);
        }
        if (s != null)
        {
            writer.writeEnd(s, s1);
            writer.flush();
        }
    }

    private void writeName(OutputNode outputnode)
    {
        String s = outputnode.getPrefix(verbose);
        String s1 = outputnode.getName();
        if (s1 != null)
        {
            writer.writeStart(s1, s);
        }
    }

    private void writeNamespaces(OutputNode outputnode)
    {
        NamespaceMap namespacemap = outputnode.getNamespaces();
        String s;
        String s1;
        for (Iterator iterator = namespacemap.iterator(); iterator.hasNext(); writer.writeNamespace(s, s1))
        {
            s = (String)iterator.next();
            s1 = namespacemap.getPrefix(s);
        }

    }

    private OutputNode writeStart(OutputNode outputnode, String s)
    {
        OutputElement outputelement = new OutputElement(outputnode, this, s);
        if (s == null)
        {
            throw new NodeException("Can not have a null name");
        } else
        {
            return stack.push(outputelement);
        }
    }

    private void writeStart(OutputNode outputnode)
    {
        writeComment(outputnode);
        writeName(outputnode);
        writeAttributes(outputnode);
        writeNamespaces(outputnode);
    }

    private void writeValue(OutputNode outputnode)
    {
        Mode mode = outputnode.getMode();
        String s = outputnode.getValue();
        if (s != null)
        {
            Iterator iterator = stack.iterator();
            Mode mode1 = mode;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                OutputNode outputnode1 = (OutputNode)iterator.next();
                if (mode1 != Mode.INHERIT)
                {
                    break;
                }
                mode1 = outputnode1.getMode();
            } while (true);
            writer.writeText(s, mode1);
        }
        outputnode.setValue(null);
    }

    public void commit(OutputNode outputnode)
    {
        if (stack.contains(outputnode))
        {
            OutputNode outputnode1 = stack.top();
            if (!isCommitted(outputnode1))
            {
                writeStart(outputnode1);
            }
            for (; stack.top() != outputnode; writeEnd(stack.pop())) { }
            writeEnd(outputnode);
            stack.pop();
        }
    }

    public boolean isCommitted(OutputNode outputnode)
    {
        return !active.contains(outputnode);
    }

    public boolean isRoot(OutputNode outputnode)
    {
        return stack.bottom() == outputnode;
    }

    public void remove(OutputNode outputnode)
    {
        if (stack.top() != outputnode)
        {
            throw new NodeException("Cannot remove node");
        } else
        {
            stack.pop();
            return;
        }
    }

    public OutputNode writeElement(OutputNode outputnode, String s)
    {
        if (stack.isEmpty())
        {
            return writeStart(outputnode, s);
        }
        if (stack.contains(outputnode))
        {
            OutputNode outputnode1 = stack.top();
            if (!isCommitted(outputnode1))
            {
                writeStart(outputnode1);
            }
            for (; stack.top() != outputnode; writeEnd(stack.pop())) { }
            if (!stack.isEmpty())
            {
                writeValue(outputnode);
            }
            return writeStart(outputnode, s);
        } else
        {
            return null;
        }
    }

    public OutputNode writeRoot()
    {
        OutputDocument outputdocument = new OutputDocument(this, stack);
        if (stack.isEmpty())
        {
            writer.writeProlog();
        }
        return outputdocument;
    }
}
