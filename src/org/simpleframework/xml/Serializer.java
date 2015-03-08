// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public interface Serializer
{

    public abstract Object read(Class class1, File file);

    public abstract Object read(Class class1, File file, boolean flag);

    public abstract Object read(Class class1, InputStream inputstream);

    public abstract Object read(Class class1, InputStream inputstream, boolean flag);

    public abstract Object read(Class class1, Reader reader);

    public abstract Object read(Class class1, Reader reader, boolean flag);

    public abstract Object read(Class class1, String s);

    public abstract Object read(Class class1, String s, boolean flag);

    public abstract Object read(Class class1, InputNode inputnode);

    public abstract Object read(Class class1, InputNode inputnode, boolean flag);

    public abstract Object read(Object obj, File file);

    public abstract Object read(Object obj, File file, boolean flag);

    public abstract Object read(Object obj, InputStream inputstream);

    public abstract Object read(Object obj, InputStream inputstream, boolean flag);

    public abstract Object read(Object obj, Reader reader);

    public abstract Object read(Object obj, Reader reader, boolean flag);

    public abstract Object read(Object obj, String s);

    public abstract Object read(Object obj, String s, boolean flag);

    public abstract Object read(Object obj, InputNode inputnode);

    public abstract Object read(Object obj, InputNode inputnode, boolean flag);

    public abstract boolean validate(Class class1, File file);

    public abstract boolean validate(Class class1, File file, boolean flag);

    public abstract boolean validate(Class class1, InputStream inputstream);

    public abstract boolean validate(Class class1, InputStream inputstream, boolean flag);

    public abstract boolean validate(Class class1, Reader reader);

    public abstract boolean validate(Class class1, Reader reader, boolean flag);

    public abstract boolean validate(Class class1, String s);

    public abstract boolean validate(Class class1, String s, boolean flag);

    public abstract boolean validate(Class class1, InputNode inputnode);

    public abstract boolean validate(Class class1, InputNode inputnode, boolean flag);

    public abstract void write(Object obj, File file);

    public abstract void write(Object obj, OutputStream outputstream);

    public abstract void write(Object obj, Writer writer);

    public abstract void write(Object obj, OutputNode outputnode);
}
