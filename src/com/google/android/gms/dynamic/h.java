// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

// Referenced classes of package com.google.android.gms.dynamic:
//            e, d, c

public final class h extends c.a
{

    private Fragment FS;

    private h(Fragment fragment)
    {
        FS = fragment;
    }

    public static h a(Fragment fragment)
    {
        if (fragment != null)
        {
            return new h(fragment);
        } else
        {
            return null;
        }
    }

    public final void c(d d1)
    {
        View view = (View)e.e(d1);
        FS.registerForContextMenu(view);
    }

    public final void d(d d1)
    {
        View view = (View)e.e(d1);
        FS.unregisterForContextMenu(view);
    }

    public final d gD()
    {
        return e.h(FS.getActivity());
    }

    public final c gE()
    {
        return a(FS.getParentFragment());
    }

    public final d gF()
    {
        return e.h(FS.getResources());
    }

    public final c gG()
    {
        return a(FS.getTargetFragment());
    }

    public final Bundle getArguments()
    {
        return FS.getArguments();
    }

    public final int getId()
    {
        return FS.getId();
    }

    public final boolean getRetainInstance()
    {
        return FS.getRetainInstance();
    }

    public final String getTag()
    {
        return FS.getTag();
    }

    public final int getTargetRequestCode()
    {
        return FS.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint()
    {
        return FS.getUserVisibleHint();
    }

    public final d getView()
    {
        return e.h(FS.getView());
    }

    public final boolean isAdded()
    {
        return FS.isAdded();
    }

    public final boolean isDetached()
    {
        return FS.isDetached();
    }

    public final boolean isHidden()
    {
        return FS.isHidden();
    }

    public final boolean isInLayout()
    {
        return FS.isInLayout();
    }

    public final boolean isRemoving()
    {
        return FS.isRemoving();
    }

    public final boolean isResumed()
    {
        return FS.isResumed();
    }

    public final boolean isVisible()
    {
        return FS.isVisible();
    }

    public final void setHasOptionsMenu(boolean flag)
    {
        FS.setHasOptionsMenu(flag);
    }

    public final void setMenuVisibility(boolean flag)
    {
        FS.setMenuVisibility(flag);
    }

    public final void setRetainInstance(boolean flag)
    {
        FS.setRetainInstance(flag);
    }

    public final void setUserVisibleHint(boolean flag)
    {
        FS.setUserVisibleHint(flag);
    }

    public final void startActivity(Intent intent)
    {
        FS.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i)
    {
        FS.startActivityForResult(intent, i);
    }
}
