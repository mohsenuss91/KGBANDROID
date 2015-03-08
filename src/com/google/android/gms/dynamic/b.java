// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package com.google.android.gms.dynamic:
//            e, d, c

public final class b extends c.a
{

    private Fragment Mg;

    private b(Fragment fragment)
    {
        Mg = fragment;
    }

    public static b a(Fragment fragment)
    {
        if (fragment != null)
        {
            return new b(fragment);
        } else
        {
            return null;
        }
    }

    public final void c(d d1)
    {
        View view = (View)e.e(d1);
        Mg.registerForContextMenu(view);
    }

    public final void d(d d1)
    {
        View view = (View)e.e(d1);
        Mg.unregisterForContextMenu(view);
    }

    public final d gD()
    {
        return e.h(Mg.getActivity());
    }

    public final c gE()
    {
        return a(Mg.getParentFragment());
    }

    public final d gF()
    {
        return e.h(Mg.getResources());
    }

    public final c gG()
    {
        return a(Mg.getTargetFragment());
    }

    public final Bundle getArguments()
    {
        return Mg.getArguments();
    }

    public final int getId()
    {
        return Mg.getId();
    }

    public final boolean getRetainInstance()
    {
        return Mg.getRetainInstance();
    }

    public final String getTag()
    {
        return Mg.getTag();
    }

    public final int getTargetRequestCode()
    {
        return Mg.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint()
    {
        return Mg.getUserVisibleHint();
    }

    public final d getView()
    {
        return e.h(Mg.getView());
    }

    public final boolean isAdded()
    {
        return Mg.isAdded();
    }

    public final boolean isDetached()
    {
        return Mg.isDetached();
    }

    public final boolean isHidden()
    {
        return Mg.isHidden();
    }

    public final boolean isInLayout()
    {
        return Mg.isInLayout();
    }

    public final boolean isRemoving()
    {
        return Mg.isRemoving();
    }

    public final boolean isResumed()
    {
        return Mg.isResumed();
    }

    public final boolean isVisible()
    {
        return Mg.isVisible();
    }

    public final void setHasOptionsMenu(boolean flag)
    {
        Mg.setHasOptionsMenu(flag);
    }

    public final void setMenuVisibility(boolean flag)
    {
        Mg.setMenuVisibility(flag);
    }

    public final void setRetainInstance(boolean flag)
    {
        Mg.setRetainInstance(flag);
    }

    public final void setUserVisibleHint(boolean flag)
    {
        Mg.setUserVisibleHint(flag);
    }

    public final void startActivity(Intent intent)
    {
        Mg.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i)
    {
        Mg.startActivityForResult(intent, i);
    }
}
