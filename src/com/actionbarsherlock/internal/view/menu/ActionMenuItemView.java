// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import com.actionbarsherlock.internal.widget.CapitalizingButton;
import com.actionbarsherlock.internal.widget.IcsToast;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.actionbarsherlock.internal.view.menu:
//            MenuItemImpl

public class ActionMenuItemView extends LinearLayout
    implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, View_HasStateListenerSupport, ActionMenuView.ActionMenuChildView, MenuView.ItemView
{

    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ImageButton mImageButton;
    private MenuItemImpl mItemData;
    private MenuBuilder.ItemInvoker mItemInvoker;
    private final Set mListeners;
    private int mMinWidth;
    private CapitalizingButton mTextButton;
    private CharSequence mTitle;

    public ActionMenuItemView(Context context)
    {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset);
        mListeners = new HashSet();
        mAllowTextWithIcon = ResourcesCompat.getResources_getBoolean(context, com.actionbarsherlock.R.bool.abs__config_allowActionMenuItemTextWithIcon);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.actionbarsherlock.R.styleable.SherlockActionMenuItemView, 0, 0);
        mMinWidth = typedarray.getDimensionPixelSize(0, 0);
        typedarray.recycle();
    }

    private void updateTextButtonVisibility()
    {
        boolean flag = true;
        boolean flag1;
        boolean flag2;
        CapitalizingButton capitalizingbutton;
        int i;
        if (!TextUtils.isEmpty(mTextButton.getText()))
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        if (mImageButton.getDrawable() != null && (!mItemData.showsTextAsAction() || !mAllowTextWithIcon && !mExpandedFormat))
        {
            flag = false;
        }
        flag2 = flag1 & flag;
        capitalizingbutton = mTextButton;
        i = 0;
        if (!flag2)
        {
            i = 8;
        }
        capitalizingbutton.setVisibility(i);
    }

    public void addOnAttachStateChangeListener(View_OnAttachStateChangeListener view_onattachstatechangelistener)
    {
        mListeners.add(view_onattachstatechangelistener);
    }

    public boolean dispatchHoverEvent(MotionEvent motionevent)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return onHoverEvent(motionevent);
        } else
        {
            return false;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        onPopulateAccessibilityEvent(accessibilityevent);
        return true;
    }

    public MenuItemImpl getItemData()
    {
        return mItemData;
    }

    public boolean hasText()
    {
        return mTextButton.getVisibility() != 8;
    }

    public void initialize(MenuItemImpl menuitemimpl, int i)
    {
        mItemData = menuitemimpl;
        setIcon(menuitemimpl.getIcon());
        setTitle(menuitemimpl.getTitleForItemView(this));
        setId(menuitemimpl.getItemId());
        int j;
        if (menuitemimpl.isVisible())
        {
            j = 0;
        } else
        {
            j = 8;
        }
        setVisibility(j);
        setEnabled(menuitemimpl.isEnabled());
    }

    public boolean needsDividerAfter()
    {
        return hasText();
    }

    public boolean needsDividerBefore()
    {
        return hasText() && mItemData.getIcon() == null;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((View_OnAttachStateChangeListener)iterator.next()).onViewAttachedToWindow(this)) { }
    }

    public void onClick(View view)
    {
        if (mItemInvoker != null)
        {
            mItemInvoker.invokeItem(mItemData);
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((View_OnAttachStateChangeListener)iterator.next()).onViewDetachedFromWindow(this)) { }
    }

    public void onFinishInflate()
    {
        mImageButton = (ImageButton)findViewById(com.actionbarsherlock.R.id.abs__imageButton);
        mTextButton = (CapitalizingButton)findViewById(com.actionbarsherlock.R.id.abs__textButton);
        mImageButton.setOnClickListener(this);
        mTextButton.setOnClickListener(this);
        mImageButton.setOnLongClickListener(this);
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    public boolean onLongClick(View view)
    {
        if (hasText())
        {
            return false;
        }
        int ai[] = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(ai);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int i = getWidth();
        int j = getHeight();
        int k = ai[1] + j / 2;
        int l = context.getResources().getDisplayMetrics().widthPixels;
        Toast toast = IcsToast.makeText(context, mItemData.getTitle(), 0);
        if (k < rect.height())
        {
            toast.setGravity(53, l - ai[0] - i / 2, j);
        } else
        {
            toast.setGravity(81, 0, j);
        }
        toast.show();
        return true;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        int k = android.view.View.MeasureSpec.getMode(i);
        int l = android.view.View.MeasureSpec.getSize(i);
        int i1 = getMeasuredWidth();
        int j1;
        if (k == 0x80000000)
        {
            j1 = Math.min(l, mMinWidth);
        } else
        {
            j1 = mMinWidth;
        }
        if (k != 0x40000000 && mMinWidth > 0 && i1 < j1)
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000), j);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            super.onPopulateAccessibilityEvent(accessibilityevent);
        }
        CharSequence charsequence = getContentDescription();
        if (!TextUtils.isEmpty(charsequence))
        {
            accessibilityevent.getText().add(charsequence);
        }
    }

    public boolean prefersCondensedTitle()
    {
        return true;
    }

    public void removeOnAttachStateChangeListener(View_OnAttachStateChangeListener view_onattachstatechangelistener)
    {
        mListeners.remove(view_onattachstatechangelistener);
    }

    public void setCheckable(boolean flag)
    {
    }

    public void setChecked(boolean flag)
    {
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        mImageButton.setEnabled(flag);
        mTextButton.setEnabled(flag);
    }

    public void setExpandedFormat(boolean flag)
    {
        if (mExpandedFormat != flag)
        {
            mExpandedFormat = flag;
            if (mItemData != null)
            {
                mItemData.actionFormatChanged();
            }
        }
    }

    public void setIcon(Drawable drawable)
    {
        mImageButton.setImageDrawable(drawable);
        if (drawable != null)
        {
            mImageButton.setVisibility(0);
        } else
        {
            mImageButton.setVisibility(8);
        }
        updateTextButtonVisibility();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker iteminvoker)
    {
        mItemInvoker = iteminvoker;
    }

    public void setShortcut(boolean flag, char c)
    {
    }

    public void setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        mTextButton.setTextCompat(mTitle);
        setContentDescription(mTitle);
        updateTextButtonVisibility();
    }

    public boolean showsIcon()
    {
        return true;
    }
}
