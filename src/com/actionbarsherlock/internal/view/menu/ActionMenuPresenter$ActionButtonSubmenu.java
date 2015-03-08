// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.view.View;
import com.actionbarsherlock.view.MenuItem;

// Referenced classes of package com.actionbarsherlock.internal.view.menu:
//            MenuPopupHelper, SubMenuBuilder, MenuItemImpl, ActionMenuPresenter

class setForceShowIcon extends MenuPopupHelper
{

    final ActionMenuPresenter this$0;

    public void onDismiss()
    {
        super.onDismiss();
        ActionMenuPresenter.access$302(ActionMenuPresenter.this, null);
        mOpenSubMenuId = 0;
    }

    public (Context context, SubMenuBuilder submenubuilder)
    {
        int j;
        boolean flag;
        this$0 = ActionMenuPresenter.this;
        super(context, submenubuilder);
        if (!((MenuItemImpl)submenubuilder.getItem()).isActionButton())
        {
            int i;
            MenuItem menuitem;
            View view;
            if (ActionMenuPresenter.access$200(ActionMenuPresenter.this) == null)
            {
                view = (View)mMenuView;
            } else
            {
                view = ActionMenuPresenter.access$200(ActionMenuPresenter.this);
            }
            setAnchorView(view);
        }
        setCallback(mPopupPresenterCallback);
        i = submenubuilder.size();
        j = 0;
_L3:
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        menuitem = submenubuilder.getItem(j);
        if (!menuitem.isVisible() || menuitem.getIcon() == null) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        setForceShowIcon(flag);
        return;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }
}
