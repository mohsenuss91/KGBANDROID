// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.io.BufferedWriter;
import java.io.Writer;

// Referenced classes of package org.simpleframework.xml.stream:
//            Indenter, OutputBuffer, Format, NodeException, 
//            Mode

class Formatter
{

    private static final char AND[] = {
        '&', 'a', 'm', 'p', ';'
    };
    private static final char CLOSE[] = {
        ' ', '-', '-', '>'
    };
    private static final char DOUBLE[] = {
        '&', 'q', 'u', 'o', 't', ';'
    };
    private static final char GREATER[] = {
        '&', 'g', 't', ';'
    };
    private static final char LESS[] = {
        '&', 'l', 't', ';'
    };
    private static final char NAMESPACE[] = {
        'x', 'm', 'l', 'n', 's'
    };
    private static final char OPEN[] = {
        '<', '!', '-', '-', ' '
    };
    private static final char SINGLE[] = {
        '&', 'a', 'p', 'o', 's', ';'
    };
    private OutputBuffer buffer;
    private Indenter indenter;
    private Tag last;
    private String prolog;
    private Writer result;

    public Formatter(Writer writer, Format format)
    {
        result = new BufferedWriter(writer, 1024);
        indenter = new Indenter(format);
        buffer = new OutputBuffer();
        prolog = format.getProlog();
    }

    private void append(char c)
    {
        buffer.append(c);
    }

    private void append(String s)
    {
        buffer.append(s);
    }

    private void append(char ac[])
    {
        buffer.append(ac);
    }

    private void data(String s)
    {
        write("<![CDATA[");
        write(s);
        write("]]>");
    }

    private void escape(char c)
    {
        char ac[] = symbol(c);
        if (ac != null)
        {
            write(ac);
            return;
        } else
        {
            write(c);
            return;
        }
    }

    private void escape(String s)
    {
        int i = s.length();
        for (int j = 0; j < i; j++)
        {
            escape(s.charAt(j));
        }

    }

    private boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    private boolean isText(char c)
    {
label0:
        {
            switch (c)
            {
            default:
                if (c <= ' ' || c > '~')
                {
                    break label0;
                }
                if (c == '\367')
                {
                    break;
                }
                // fall through

            case 9: // '\t'
            case 10: // '\n'
            case 13: // '\r'
            case 32: // ' '
                return true;
            }
            return false;
        }
        return false;
    }

    private char[] symbol(char c)
    {
        switch (c)
        {
        default:
            return null;

        case 60: // '<'
            return LESS;

        case 62: // '>'
            return GREATER;

        case 34: // '"'
            return DOUBLE;

        case 39: // '\''
            return SINGLE;

        case 38: // '&'
            return AND;
        }
    }

    private String unicode(char c)
    {
        return Integer.toString(c);
    }

    private void write(char c)
    {
        buffer.write(result);
        buffer.clear();
        result.write(c);
    }

    private void write(String s)
    {
        buffer.write(result);
        buffer.clear();
        result.write(s);
    }

    private void write(String s, String s1)
    {
        buffer.write(result);
        buffer.clear();
        if (!isEmpty(s1))
        {
            result.write(s1);
            result.write(58);
        }
        result.write(s);
    }

    private void write(char ac[])
    {
        buffer.write(result);
        buffer.clear();
        result.write(ac);
    }

    public void flush()
    {
        buffer.write(result);
        buffer.clear();
        result.flush();
    }

    public void writeAttribute(String s, String s1, String s2)
    {
        if (last != Tag.START)
        {
            throw new NodeException("Start element required");
        } else
        {
            write(' ');
            write(s, s2);
            write('=');
            write('"');
            escape(s1);
            write('"');
            return;
        }
    }

    public void writeComment(String s)
    {
        String s1 = indenter.top();
        if (last == Tag.START)
        {
            append('>');
        }
        if (s1 != null)
        {
            append(s1);
            append(OPEN);
            append(s);
            append(CLOSE);
        }
        last = Tag.COMMENT;
    }

    public void writeEnd(String s, String s1)
    {
        String s2 = indenter.pop();
        if (last != Tag.START) goto _L2; else goto _L1
_L1:
        write('/');
        write('>');
_L4:
        last = Tag.END;
        return;
_L2:
        if (last != Tag.TEXT)
        {
            write(s2);
        }
        if (last != Tag.START)
        {
            write('<');
            write('/');
            write(s, s1);
            write('>');
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void writeNamespace(String s, String s1)
    {
        if (last != Tag.START)
        {
            throw new NodeException("Start element required");
        }
        write(' ');
        write(NAMESPACE);
        if (!isEmpty(s1))
        {
            write(':');
            write(s1);
        }
        write('=');
        write('"');
        escape(s);
        write('"');
    }

    public void writeProlog()
    {
        if (prolog != null)
        {
            write(prolog);
            write("\n");
        }
    }

    public void writeStart(String s, String s1)
    {
        String s2 = indenter.push();
        if (last == Tag.START)
        {
            append('>');
        }
        flush();
        append(s2);
        append('<');
        if (!isEmpty(s1))
        {
            append(s1);
            append(':');
        }
        append(s);
        last = Tag.START;
    }

    public void writeText(String s)
    {
        writeText(s, Mode.ESCAPE);
    }

    public void writeText(String s, Mode mode)
    {
        if (last == Tag.START)
        {
            write('>');
        }
        if (mode == Mode.DATA)
        {
            data(s);
        } else
        {
            escape(s);
        }
        last = Tag.TEXT;
    }


    private class Tag extends Enum
    {

        private static final Tag $VALUES[];
        public static final Tag COMMENT;
        public static final Tag END;
        public static final Tag START;
        public static final Tag TEXT;

        public static Tag valueOf(String s)
        {
            return (Tag)Enum.valueOf(org/simpleframework/xml/stream/Formatter$Tag, s);
        }

        public static Tag[] values()
        {
            return (Tag[])$VALUES.clone();
        }

        static 
        {
            COMMENT = new Tag("COMMENT", 0);
            START = new Tag("START", 1);
            TEXT = new Tag("TEXT", 2);
            END = new Tag("END", 3);
            Tag atag[] = new Tag[4];
            atag[0] = COMMENT;
            atag[1] = START;
            atag[2] = TEXT;
            atag[3] = END;
            $VALUES = atag;
        }

        private Tag(String s, int i)
        {
            super(s, i);
        }
    }

}
