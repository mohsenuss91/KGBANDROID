// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import com.actionbarsherlock.internal.widget.IcsListPopupWindow;
import com.actionbarsherlock.view.MenuItem;

// Referenced classes of package com.actionbarsherlock.internal.view.menu:
//            MenuPresenter, MenuBuilder, SubMenuBuilder, MenuItemImpl, 
//            MenuView

public class MenuPopupHelper
    implements android.view.View.OnKeyListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, android.widget.AdapterView.OnItemClickListener, android.widget.PopupWindow.OnDismissListener, View_OnAttachStateChangeListener, MenuPresenter
{

    static final int ITEM_LAYOUT;
    private MenuAdapter mAdapter;
    private View mAnchorView;
    private Context mContext;
    boolean mForceShowIcon;
    private LayoutInflater mInflater;
    private ViewGroup mMeasureParent;
    private MenuBuilder mMenu;
    private boolean mOverflowOnly;
    private IcsListPopupWindow mPopup;
    private int mPopupMaxWidth;
    private MenuPresenter.Callback mPresenterCallback;
    private ViewTreeObserver mTreeObserver;

    public MenuPopupHelper(Context context, MenuBuilder menubuilder)
    {
        this(context, menubuilder, null, false);
    }

    public MenuPopupHelper(Context context, MenuBuilder menubuilder, View view)
    {
        this(context, menubuilder, view, false);
    }

    public MenuPopupHelper(Context context, MenuBuilder menubuilder, View view, boolean flag)
    {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mMenu = menubuilder;
        mOverflowOnly = flag;
        Resources resources = context.getResources();
        mPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(com.actionbarsherlock.R.dimen.abs__config_prefDialogWidth));
        mAnchorView = view;
        menubuilder.addMenuPresenter(this);
    }

    private int measureContentWidth(ListAdapter listadapter)
    {
        int i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int j = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int k = listadapter.getCount();
        int l = 0;
        int i1 = 0;
        View view = null;
        int j1 = 0;
        while (l < k) 
        {
            int k1 = listadapter.getItemViewType(l);
            View view1;
            if (k1 != i1)
            {
                view1 = null;
            } else
            {
                k1 = i1;
                view1 = view;
            }
            if (mMeasureParent == null)
            {
                mMeasureParent = new FrameLayout(mContext);
            }
            view = listadapter.getView(l, view1, mMeasureParent);
            view.measure(i, j);
            j1 = Math.max(j1, view.getMeasuredWidth());
            l++;
            i1 = k1;
        }
        return j1;
    }

    public boolean collapseItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }

    public void dismiss()
    {
        if (isShowing())
        {
            mPopup.dismiss();
        }
    }

    public boolean expandItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl)
    {
        return false;
    }

    public boolean flagActionItems()
    {
        return false;
    }

    public int getId()
    {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewgroup)
    {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    public void initForMenu(Context context, MenuBuilder menubuilder)
    {
    }

    public boolean isShowing()
    {
        return mPopup != null && mPopup.isShowing();
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag)
    {
        if (menubuilder == mMenu)
        {
            dismiss();
            if (mPresenterCallback != null)
            {
                mPresenterCallback.onCloseMenu(menubuilder, flag);
                return;
            }
        }
    }

    public void onDismiss()
    {
        mPopup = null;
        mMenu.close();
        if (mTreeObserver != null)
        {
            if (mTreeObserver.isAlive())
            {
                mTreeObserver.removeGlobalOnLayoutListener(this);
            }
            mTreeObserver = null;
        } else
        if (mAnchorView instanceof View_HasStateListenerSupport)
        {
            ((View_HasStateListenerSupport)mAnchorView).removeOnAttachStateChangeListener(this);
            return;
        }
    }

    public void onGlobalLayout()
    {
        if (isShowing())
        {
            View view = mAnchorView;
            if (view == null || !view.isShown())
            {
                dismiss();
            } else
            if (isShowing())
            {
                mPopup.show();
                return;
            }
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        MenuAdapter menuadapter = mAdapter;
        menuadapter.mAdapterMenu.performItemAction(menuadapter.getItem(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (keyevent.getAction() == 1 && i == 82)
        {
            dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
    }

    public Parcelable onSaveInstanceState()
    {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder submenubuilder)
    {
        if (!submenubuilder.hasVisibleItems()) goto _L2; else goto _L1
_L1:
        MenuPopupHelper menupopuphelper;
        int i;
        int j;
        menupopuphelper = new MenuPopupHelper(mContext, submenubuilder, mAnchorView, false);
        menupopuphelper.setCallback(mPresenterCallback);
        i = submenubuilder.size();
        j = 0;
_L5:
        MenuItem menuitem;
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        menuitem = submenubuilder.getItem(j);
        if (!menuitem.isVisible() || menuitem.getIcon() == null) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        menupopuphelper.setForceShowIcon(flag);
        if (menupopuphelper.tryShow())
        {
            if (mPresenterCallback != null)
            {
                mPresenterCallback.onOpenSubMenu(submenubuilder);
            }
            return true;
        }
          goto _L2
_L4:
        j++;
          goto _L5
_L2:
        return false;
        flag = false;
          goto _L6
    }

    public void onViewAttachedToWindow(View view)
    {
        ((View_HasStateListenerSupport)view).removeOnAttachStateChangeListener(this);
        if (mPopup != null && mTreeObserver == null)
        {
            ViewTreeObserver viewtreeobserver = view.getViewTreeObserver();
            mTreeObserver = viewtreeobserver;
            viewtreeobserver.addOnGlobalLayoutListener(this);
        }
    }

    public void onViewDetachedFromWindow(View view)
    {
    }

    public void setAnchorView(View view)
    {
        mAnchorView = view;
    }

    public void setCallback(MenuPresenter.Callback callback)
    {
        mPresenterCallback = callback;
    }

    public void setForceShowIcon(boolean flag)
    {
        mForceShowIcon = flag;
    }

    public void show()
    {
        if (!tryShow())
        {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        } else
        {
            return;
        }
    }

    public boolean tryShow()
    {
        View view;
        mPopup = new IcsListPopupWindow(mContext, null, com.actionbarsherlock.R.attr.popupMenuStyle);
        mPopup.setOnDismissListener(this);
        mPopup.setOnItemClickListener(this);
        mAdapter = new MenuAdapter(mMenu);
        mPopup.setAdapter(mAdapter);
        mPopup.setModal(true);
        view = mAnchorView;
        if (view == null) goto _L2; else goto _L1
_L1:
        if (view.getWindowToken() == null) goto _L4; else goto _L3
_L3:
        ViewTreeObserver viewtreeobserver = view.getViewTreeObserver();
        if (viewtreeobserver != mTreeObserver)
        {
            if (mTreeObserver != null && mTreeObserver.isAlive())
            {
                mTreeObserver.removeGlobalOnLayoutListener(this);
            }
            mTreeObserver = viewtreeobserver;
            if (viewtreeobserver != null)
            {
                viewtreeobserver.addOnGlobalLayoutListener(this);
            }
        }
_L5:
        mPopup.setAnchorView(view);
        mPopup.setContentWidth(Math.min(measureContentWidth(mAdapter), mPopupMaxWidth));
        mPopup.setInputMethodMode(2);
        mPopup.show();
        mPopup.getListView().setOnKeyListener(this);
        return true;
_L4:
        if (view instanceof View_HasStateListenerSupport)
        {
            ((View_HasStateListenerSupport)view).addOnAttachStateChangeListener(this);
        }
        if (true) goto _L5; else goto _L2
_L2:
        return false;
    }

    public void updateMenuView(boolean flag)
    {
        if (mAdapter != null)
        {
            mAdapter.notifyDataSetChanged();
        }
    }

    static 
    {
        ITEM_LAYOUT = com.actionbarsherlock.R.layout.abs__popup_menu_item_layout;
    }





    private class MenuAdapter extends BaseAdapter
    {
        private class ExpandedIndexObserver extends DataSetObserver
        {

            final MenuPopupHelper this$0;

            public void onChanged()
            {
                mAdapter.findExpandedIndex();
            }

            private ExpandedIndexObserver()
            {
                this$0 = MenuPopupHelper.this;
                super();
            }

            ExpandedIndexObserver(_cls1 _pcls1)
            {
                this();
            }
        }


        private MenuBuilder mAdapterMenu;
        private int mExpandedIndex;
        final MenuPopupHelper this$0;

        void findExpandedIndex()
        {
            MenuItemImpl menuitemimpl = mMenu.getExpandedItem();
            if (menuitemimpl != null)
            {
                ArrayList arraylist = mMenu.getNonActionItems();
                int i = arraylist.size();
                for (int j = 0; j < i; j++)
                {
                    if ((MenuItemImpl)arraylist.get(j) == menuitemimpl)
                    {
                        mExpandedIndex = j;
                        return;
                    }
                }

            }
            mExpandedIndex = -1;
        }

        public int getCount()
        {
            ArrayList arraylist;
            if (mOverflowOnly)
            {
                arraylist = mAdapterMenu.getNonActionItems();
            } else
            {
                arraylist = mAdapterMenu.getVisibleItems();
            }
            if (mExpandedIndex < 0)
            {
                return arraylist.size();
            } else
            {
                return -1 + arraylist.size();
            }
        }

        public MenuItemImpl getItem(int i)
        {
            ArrayList arraylist;
            if (mOverflowOnly)
            {
                arraylist = mAdapterMenu.getNonActionItems();
            } else
            {
                arraylist = mAdapterMenu.getVisibleItems();
            }
            if (mExpandedIndex >= 0 && i >= mExpandedIndex)
            {
                i++;
            }
            return (MenuItemImpl)arraylist.get(i);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            View view1;
            MenuView.ItemView itemview;
            if (view == null)
            {
                view1 = mInflater.inflate(MenuPopupHelper.ITEM_LAYOUT, viewgroup, false);
            } else
            {
                view1 = view;
            }
            itemview = (MenuView.ItemView)view1;
            if (mForceShowIcon)
            {
                ((ListMenuItemView)view1).setForceShowIcon(true);
            }
            itemview.initialize(getItem(i), 0);
            return view1;
        }


        public MenuAdapter(MenuBuilder menubuilder)
        {
            this$0 = MenuPopupHelper.this;
            super();
            mExpandedIndex = -1;
            mAdapterMenu = menubuilder;
            registerDataSetObserver(new ExpandedIndexObserver(null));
            findExpandedIndex();
        }
    }

}
