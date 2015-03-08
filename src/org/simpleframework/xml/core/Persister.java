// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeBuilder;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.transform.Matcher;

// Referenced classes of package org.simpleframework.xml.core:
//            EmptyMatcher, Support, SessionManager, Traverser, 
//            Source, Context, Session

public class Persister
    implements Serializer
{

    private final Format format;
    private final SessionManager manager;
    private final Strategy strategy;
    private final Support support;

    public Persister()
    {
        this(((Map) (new HashMap())));
    }

    public Persister(Map map)
    {
        this(((Filter) (new PlatformFilter(map))));
    }

    public Persister(Map map, Format format1)
    {
        this(((Filter) (new PlatformFilter(map))));
    }

    public Persister(Filter filter)
    {
        this(((Strategy) (new TreeStrategy())), filter);
    }

    public Persister(Filter filter, Format format1)
    {
        this(((Strategy) (new TreeStrategy())), filter, format1);
    }

    public Persister(Filter filter, Matcher matcher)
    {
        this(((Strategy) (new TreeStrategy())), filter, matcher);
    }

    public Persister(Filter filter, Matcher matcher, Format format1)
    {
        this(((Strategy) (new TreeStrategy())), filter, matcher, format1);
    }

    public Persister(Strategy strategy1)
    {
        this(strategy1, ((Map) (new HashMap())));
    }

    public Persister(Strategy strategy1, Map map)
    {
        this(strategy1, ((Filter) (new PlatformFilter(map))));
    }

    public Persister(Strategy strategy1, Map map, Format format1)
    {
        this(strategy1, ((Filter) (new PlatformFilter(map))), format1);
    }

    public Persister(Strategy strategy1, Filter filter)
    {
        this(strategy1, filter, new Format());
    }

    public Persister(Strategy strategy1, Filter filter, Format format1)
    {
        this(strategy1, filter, ((Matcher) (new EmptyMatcher())), format1);
    }

    public Persister(Strategy strategy1, Filter filter, Matcher matcher)
    {
        this(strategy1, filter, matcher, new Format());
    }

    public Persister(Strategy strategy1, Filter filter, Matcher matcher, Format format1)
    {
        support = new Support(filter, matcher, format1);
        manager = new SessionManager();
        strategy = strategy1;
        format = format1;
    }

    public Persister(Strategy strategy1, Format format1)
    {
        this(strategy1, ((Map) (new HashMap())), format1);
    }

    public Persister(Strategy strategy1, Matcher matcher)
    {
        this(strategy1, ((Filter) (new PlatformFilter())), matcher);
    }

    public Persister(Strategy strategy1, Matcher matcher, Format format1)
    {
        this(strategy1, ((Filter) (new PlatformFilter())), matcher, format1);
    }

    public Persister(Format format1)
    {
        this(((Strategy) (new TreeStrategy())), format1);
    }

    public Persister(Matcher matcher)
    {
        this(((Strategy) (new TreeStrategy())), matcher);
    }

    public Persister(Matcher matcher, Format format1)
    {
        this(((Strategy) (new TreeStrategy())), matcher, format1);
    }

    private Object read(Class class1, InputNode inputnode, Context context)
    {
        return (new Traverser(context)).read(inputnode, class1);
    }

    private Object read(Class class1, InputNode inputnode, Session session)
    {
        return read(class1, inputnode, ((Context) (new Source(strategy, support, session))));
    }

    private Object read(Object obj, InputNode inputnode, Context context)
    {
        return (new Traverser(context)).read(inputnode, obj);
    }

    private Object read(Object obj, InputNode inputnode, Session session)
    {
        return read(obj, inputnode, ((Context) (new Source(strategy, support, session))));
    }

    private boolean validate(Class class1, InputNode inputnode, Context context)
    {
        return (new Traverser(context)).validate(inputnode, class1);
    }

    private boolean validate(Class class1, InputNode inputnode, Session session)
    {
        return validate(class1, inputnode, ((Context) (new Source(strategy, support, session))));
    }

    private void write(Object obj, OutputNode outputnode, Context context)
    {
        (new Traverser(context)).write(outputnode, obj);
    }

    private void write(Object obj, OutputNode outputnode, Session session)
    {
        write(obj, outputnode, ((Context) (new Source(strategy, support, session))));
    }

    public Object read(Class class1, File file)
    {
        return read(class1, file, true);
    }

    public Object read(Class class1, File file, boolean flag)
    {
        FileInputStream fileinputstream = new FileInputStream(file);
        Object obj = read(class1, ((InputStream) (fileinputstream)), flag);
        fileinputstream.close();
        return obj;
        Exception exception;
        exception;
        fileinputstream.close();
        throw exception;
    }

    public Object read(Class class1, InputStream inputstream)
    {
        return read(class1, inputstream, true);
    }

    public Object read(Class class1, InputStream inputstream, boolean flag)
    {
        return read(class1, NodeBuilder.read(inputstream), flag);
    }

    public Object read(Class class1, Reader reader)
    {
        return read(class1, reader, true);
    }

    public Object read(Class class1, Reader reader, boolean flag)
    {
        return read(class1, NodeBuilder.read(reader), flag);
    }

    public Object read(Class class1, String s)
    {
        return read(class1, s, true);
    }

    public Object read(Class class1, String s, boolean flag)
    {
        return read(class1, ((Reader) (new StringReader(s))), flag);
    }

    public Object read(Class class1, InputNode inputnode)
    {
        return read(class1, inputnode, true);
    }

    public Object read(Class class1, InputNode inputnode, boolean flag)
    {
        Session session = manager.open(flag);
        Object obj = read(class1, inputnode, session);
        manager.close();
        return obj;
        Exception exception;
        exception;
        manager.close();
        throw exception;
    }

    public Object read(Object obj, File file)
    {
        return read(obj, file, true);
    }

    public Object read(Object obj, File file, boolean flag)
    {
        FileInputStream fileinputstream = new FileInputStream(file);
        Object obj1 = read(obj, ((InputStream) (fileinputstream)), flag);
        fileinputstream.close();
        return obj1;
        Exception exception;
        exception;
        fileinputstream.close();
        throw exception;
    }

    public Object read(Object obj, InputStream inputstream)
    {
        return read(obj, inputstream, true);
    }

    public Object read(Object obj, InputStream inputstream, boolean flag)
    {
        return read(obj, NodeBuilder.read(inputstream), flag);
    }

    public Object read(Object obj, Reader reader)
    {
        return read(obj, reader, true);
    }

    public Object read(Object obj, Reader reader, boolean flag)
    {
        return read(obj, NodeBuilder.read(reader), flag);
    }

    public Object read(Object obj, String s)
    {
        return read(obj, s, true);
    }

    public Object read(Object obj, String s, boolean flag)
    {
        return read(obj, ((Reader) (new StringReader(s))), flag);
    }

    public Object read(Object obj, InputNode inputnode)
    {
        return read(obj, inputnode, true);
    }

    public Object read(Object obj, InputNode inputnode, boolean flag)
    {
        Session session = manager.open(flag);
        Object obj1 = read(obj, inputnode, session);
        manager.close();
        return obj1;
        Exception exception;
        exception;
        manager.close();
        throw exception;
    }

    public boolean validate(Class class1, File file)
    {
        return validate(class1, file, true);
    }

    public boolean validate(Class class1, File file, boolean flag)
    {
        FileInputStream fileinputstream = new FileInputStream(file);
        boolean flag1 = validate(class1, ((InputStream) (fileinputstream)), flag);
        fileinputstream.close();
        return flag1;
        Exception exception;
        exception;
        fileinputstream.close();
        throw exception;
    }

    public boolean validate(Class class1, InputStream inputstream)
    {
        return validate(class1, inputstream, true);
    }

    public boolean validate(Class class1, InputStream inputstream, boolean flag)
    {
        return validate(class1, NodeBuilder.read(inputstream), flag);
    }

    public boolean validate(Class class1, Reader reader)
    {
        return validate(class1, reader, true);
    }

    public boolean validate(Class class1, Reader reader, boolean flag)
    {
        return validate(class1, NodeBuilder.read(reader), flag);
    }

    public boolean validate(Class class1, String s)
    {
        return validate(class1, s, true);
    }

    public boolean validate(Class class1, String s, boolean flag)
    {
        return validate(class1, ((Reader) (new StringReader(s))), flag);
    }

    public boolean validate(Class class1, InputNode inputnode)
    {
        return validate(class1, inputnode, true);
    }

    public boolean validate(Class class1, InputNode inputnode, boolean flag)
    {
        Session session = manager.open(flag);
        boolean flag1 = validate(class1, inputnode, session);
        manager.close();
        return flag1;
        Exception exception;
        exception;
        manager.close();
        throw exception;
    }

    public void write(Object obj, File file)
    {
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        write(obj, ((OutputStream) (fileoutputstream)));
        fileoutputstream.close();
        return;
        Exception exception;
        exception;
        fileoutputstream.close();
        throw exception;
    }

    public void write(Object obj, OutputStream outputstream)
    {
        write(obj, outputstream, "utf-8");
    }

    public void write(Object obj, OutputStream outputstream, String s)
    {
        write(obj, ((Writer) (new OutputStreamWriter(outputstream, s))));
    }

    public void write(Object obj, Writer writer)
    {
        write(obj, NodeBuilder.write(writer, format));
    }

    public void write(Object obj, OutputNode outputnode)
    {
        Session session = manager.open();
        write(obj, outputnode, session);
        manager.close();
        return;
        Exception exception;
        exception;
        manager.close();
        throw exception;
    }
}
