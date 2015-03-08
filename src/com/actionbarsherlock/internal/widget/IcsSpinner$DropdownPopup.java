// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;

// Referenced classes of package com.actionbarsherlock.internal.widget:
//            IcsListPopupWindow, IcsSpinner

class _cls1 extends IcsListPopupWindow
    implements _cls1
{

    private ListAdapter mAdapter;
    private CharSequence mHintText;
    final IcsSpinner this$0;

    public CharSequence getHintText()
    {
        return mHintText;
    }

    public void setAdapter(ListAdapter listadapter)
    {
        super.setAdapter(listadapter);
        mAdapter = listadapter;
    }

    public void setPromptText(CharSequence charsequence)
    {
        mHintText = charsequence;
    }

    public void show()
    {
        int i = getPaddingLeft();
        Drawable drawable;
        int j;
        if (mDropDownWidth == -2)
        {
            int i1 = getWidth();
            int j1 = getPaddingRight();
            setContentWidth(Math.max(measureContentWidth((SpinnerAdapter)mAdapter, getBackground()), i1 - i - j1));
        } else
        if (mDropDownWidth == -1)
        {
            int k = getWidth();
            int l = getPaddingRight();
            setContentWidth(k - i - l);
        } else
        {
            setContentWidth(mDropDownWidth);
        }
        drawable = getBackground();
        j = 0;
        if (drawable != null)
        {
            drawable.getPadding(IcsSpinner.access$000(IcsSpinner.this));
            j = -IcsSpinner.access$000(IcsSpinner.this).left;
        }
        setHorizontalOffset(j + i);
        setInputMethodMode(2);
        super.show();
        getListView().setChoiceMode(1);
        setSelection(getSelectedItemPosition());
    }

    public _cls1.val.this._cls0(Context context, AttributeSet attributeset, int i)
    {
        this.this$0 = IcsSpinner.this;
        super(context, attributeset, 0, i);
        setAnchorView(IcsSpinner.this);
        setModal(true);
        setPromptPosition(0);
        class _cls1
            implements android.widget.AdapterView.OnItemClickListener
        {

            final IcsSpinner.DropdownPopup this$1;
            final IcsSpinner val$this$0;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                setSelection(j);
                dismiss();
            }

            _cls1()
            {
                this$1 = IcsSpinner.DropdownPopup.this;
                this$0 = icsspinner;
                super();
            }
        }

        setOnItemClickListener(new _cls1());
    }
}
