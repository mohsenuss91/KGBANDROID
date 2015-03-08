// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            InputStack, EventReader, EventNode, InputElement, 
//            InputNode, NodeException

class NodeReader
{

    private final EventReader reader;
    private final InputStack stack = new InputStack();
    private final StringBuilder text = new StringBuilder();

    public NodeReader(EventReader eventreader)
    {
        reader = eventreader;
    }

    private void fillText(InputNode inputnode)
    {
        EventNode eventnode = reader.peek();
        if (eventnode.isText())
        {
            String s = eventnode.getValue();
            text.append(s);
        }
    }

    private boolean isName(EventNode eventnode, String s)
    {
        String s1 = eventnode.getName();
        if (s1 == null)
        {
            return false;
        } else
        {
            return s1.equals(s);
        }
    }

    private String readBuffer(InputNode inputnode)
    {
        if (text.length() > 0)
        {
            String s = text.toString();
            text.setLength(0);
            return s;
        } else
        {
            return null;
        }
    }

    private InputNode readStart(InputNode inputnode, EventNode eventnode)
    {
        Object obj = new InputElement(inputnode, this, eventnode);
        if (text.length() > 0)
        {
            text.setLength(0);
        }
        if (eventnode.isStart())
        {
            obj = (InputNode)stack.push(obj);
        }
        return ((InputNode) (obj));
    }

    private String readText(InputNode inputnode)
    {
        for (EventNode eventnode = reader.peek(); stack.top() == inputnode && eventnode.isText(); eventnode = reader.peek())
        {
            fillText(inputnode);
            reader.next();
        }

        return readBuffer(inputnode);
    }

    public boolean isEmpty(InputNode inputnode)
    {
        return stack.top() == inputnode && reader.peek().isEnd();
    }

    public boolean isRoot(InputNode inputnode)
    {
        return stack.bottom() == inputnode;
    }

    public InputNode readElement(InputNode inputnode)
    {
        if (stack.isRelevant(inputnode)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        EventNode eventnode = reader.next();
_L5:
        if (eventnode == null) goto _L1; else goto _L3
_L3:
        if (!eventnode.isEnd())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (stack.pop() == inputnode) goto _L1; else goto _L4
_L4:
        eventnode = reader.next();
          goto _L5
        if (eventnode.isStart())
        {
            return readStart(inputnode, eventnode);
        }
          goto _L4
    }

    public InputNode readElement(InputNode inputnode, String s)
    {
        if (stack.isRelevant(inputnode)) goto _L2; else goto _L1
_L1:
        EventNode eventnode;
        return null;
_L2:
        if ((eventnode = reader.peek()) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!eventnode.isText())
        {
            break; /* Loop/switch isn't completed */
        }
        fillText(inputnode);
_L4:
        reader.next();
        if (true) goto _L2; else goto _L3
_L3:
        if (!eventnode.isEnd())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (stack.top() == inputnode)
        {
            continue; /* Loop/switch isn't completed */
        }
        stack.pop();
          goto _L4
          goto _L2
        if (!eventnode.isStart()) goto _L4; else goto _L5
_L5:
        if (isName(eventnode, s))
        {
            return readElement(inputnode);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public InputNode readRoot()
    {
        boolean flag = stack.isEmpty();
        InputNode inputnode = null;
        if (flag)
        {
            inputnode = readElement(null);
            if (inputnode == null)
            {
                throw new NodeException("Document has no root element");
            }
        }
        return inputnode;
    }

    public String readValue(InputNode inputnode)
    {
        if (stack.isRelevant(inputnode)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if (text.length() > 0 || !reader.peek().isEnd())
        {
            break; /* Loop/switch isn't completed */
        }
        if (stack.top() == inputnode)
        {
            continue; /* Loop/switch isn't completed */
        }
        stack.pop();
        reader.next();
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return readText(inputnode);
    }

    public void skipElement(InputNode inputnode)
    {
        while (readElement(inputnode) != null) ;
    }
}
