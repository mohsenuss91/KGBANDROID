// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            Scanner, Function, Context

class Caller
{

    private final Function commit;
    private final Function complete;
    private final Context context;
    private final Function persist;
    private final Function replace;
    private final Function resolve;
    private final Function validate;

    public Caller(Scanner scanner, Context context1)
    {
        validate = scanner.getValidate();
        complete = scanner.getComplete();
        replace = scanner.getReplace();
        resolve = scanner.getResolve();
        persist = scanner.getPersist();
        commit = scanner.getCommit();
        context = context1;
    }

    public void commit(Object obj)
    {
        if (commit != null)
        {
            commit.call(context, obj);
        }
    }

    public void complete(Object obj)
    {
        if (complete != null)
        {
            complete.call(context, obj);
        }
    }

    public void persist(Object obj)
    {
        if (persist != null)
        {
            persist.call(context, obj);
        }
    }

    public Object replace(Object obj)
    {
        if (replace != null)
        {
            obj = replace.call(context, obj);
        }
        return obj;
    }

    public Object resolve(Object obj)
    {
        if (resolve != null)
        {
            obj = resolve.call(context, obj);
        }
        return obj;
    }

    public void validate(Object obj)
    {
        if (validate != null)
        {
            validate.call(context, obj);
        }
    }
}
