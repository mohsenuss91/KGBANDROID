// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.annotations;

import java.lang.annotation.Annotation;

public interface Expose
    extends Annotation
{

    public abstract boolean deserialize();

    public abstract boolean serialize();
}
