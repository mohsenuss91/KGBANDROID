// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.widget.ImageButton;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.actionbarsherlock.internal.view.menu:
//            ActionMenuPresenter

class setEnabled extends ImageButton
    implements View_HasStateListenerSupport, setEnabled
{

    private final Set mListeners = new HashSet();
    final ActionMenuPresenter this$0;

    public void addOnAttachStateChangeListener(View_OnAttachStateChangeListener view_onattachstatechangelistener)
    {
        mListeners.add(view_onattachstatechangelistener);
    }

    public boolean needsDividerAfter()
    {
        return false;
    }

    public boolean needsDividerBefore()
    {
        return false;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((View_OnAttachStateChangeListener)iterator.next()).onViewAttachedToWindow(this)) { }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((View_OnAttachStateChangeListener)iterator.next()).onViewDetachedFromWindow(this)) { }
        if (ActionMenuPresenter.access$100(ActionMenuPresenter.this) != null)
        {
            ActionMenuPresenter.access$100(ActionMenuPresenter.this).ss();
        }
    }

    public boolean performClick()
    {
        if (super.performClick())
        {
            return true;
        } else
        {
            playSoundEffect(0);
            showOverflowMenu();
            return true;
        }
    }

    public void removeOnAttachStateChangeListener(View_OnAttachStateChangeListener view_onattachstatechangelistener)
    {
        mListeners.remove(view_onattachstatechangelistener);
    }

    public (Context context)
    {
        this$0 = ActionMenuPresenter.this;
        super(context, null, com.actionbarsherlock.OverflowMenuButton.this._fld0);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
    }
}
