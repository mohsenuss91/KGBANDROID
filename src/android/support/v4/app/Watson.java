// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.view.View;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            FragmentActivity, FragmentManagerImpl, Fragment

public abstract class Watson extends FragmentActivity
    implements com.actionbarsherlock.ActionBarSherlock.OnCreatePanelMenuListener, com.actionbarsherlock.ActionBarSherlock.OnMenuItemSelectedListener, com.actionbarsherlock.ActionBarSherlock.OnPreparePanelListener
{

    private static final String TAG = "Watson";
    private ArrayList mCreatedMenus;

    public Watson()
    {
    }

    public abstract MenuInflater getSupportMenuInflater();

    public abstract boolean onCreateOptionsMenu(Menu menu);

    public boolean onCreatePanelMenu(int i, Menu menu)
    {
        boolean flag = false;
        if (i == 0)
        {
            boolean flag1 = onCreateOptionsMenu(menu);
            MenuInflater menuinflater = getSupportMenuInflater();
            ArrayList arraylist = null;
            if (mFragments.mAdded != null)
            {
                int k = 0;
                boolean flag2 = false;
                while (k < mFragments.mAdded.size()) 
                {
                    Fragment fragment1 = (Fragment)mFragments.mAdded.get(k);
                    boolean flag3;
                    if (fragment1 != null && !fragment1.mHidden && fragment1.mHasMenu && fragment1.mMenuVisible && (fragment1 instanceof OnCreateOptionsMenuListener))
                    {
                        ((OnCreateOptionsMenuListener)fragment1).onCreateOptionsMenu(menu, menuinflater);
                        ArrayList arraylist1;
                        int j;
                        Fragment fragment;
                        ArrayList arraylist2;
                        if (arraylist == null)
                        {
                            arraylist2 = new ArrayList();
                        } else
                        {
                            arraylist2 = arraylist;
                        }
                        arraylist2.add(fragment1);
                        arraylist = arraylist2;
                        flag3 = true;
                    } else
                    {
                        flag3 = flag2;
                    }
                    k++;
                    flag2 = flag3;
                }
            } else
            {
                flag2 = false;
            }
            arraylist1 = mCreatedMenus;
            j = 0;
            if (arraylist1 != null)
            {
                for (; j < mCreatedMenus.size(); j++)
                {
                    fragment = (Fragment)mCreatedMenus.get(j);
                    if (arraylist == null || !arraylist.contains(fragment))
                    {
                        fragment.onDestroyOptionsMenu();
                    }
                }

            }
            mCreatedMenus = arraylist;
            flag = flag1 | flag2;
        }
        return flag;
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        boolean flag = false;
        if (i != 0) goto _L2; else goto _L1
_L1:
        if (!onOptionsItemSelected(menuitem)) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        return flag;
_L4:
        ArrayList arraylist = mFragments.mAdded;
        flag = false;
        if (arraylist == null)
        {
            continue;
        }
        int j = 0;
        do
        {
            int k = mFragments.mAdded.size();
            flag = false;
            if (j >= k)
            {
                continue;
            }
            Fragment fragment = (Fragment)mFragments.mAdded.get(j);
            if (fragment != null && !fragment.mHidden && fragment.mHasMenu && fragment.mMenuVisible && (fragment instanceof OnOptionsItemSelectedListener) && ((OnOptionsItemSelectedListener)fragment).onOptionsItemSelected(menuitem))
            {
                return true;
            }
            j++;
        } while (true);
        if (true) goto _L2; else goto _L5
_L5:
    }

    public abstract boolean onOptionsItemSelected(MenuItem menuitem);

    public abstract boolean onPrepareOptionsMenu(Menu menu);

    public boolean onPreparePanel(int i, View view, Menu menu)
    {
        boolean flag = false;
        if (i == 0)
        {
            boolean flag1 = onPrepareOptionsMenu(menu);
            boolean flag2;
            if (mFragments.mAdded != null)
            {
                int j = 0;
                flag2 = false;
                for (; j < mFragments.mAdded.size(); j++)
                {
                    Fragment fragment = (Fragment)mFragments.mAdded.get(j);
                    if (fragment != null && !fragment.mHidden && fragment.mHasMenu && fragment.mMenuVisible && (fragment instanceof OnPrepareOptionsMenuListener))
                    {
                        flag2 = true;
                        ((OnPrepareOptionsMenuListener)fragment).onPrepareOptionsMenu(menu);
                    }
                }

            } else
            {
                flag2 = false;
            }
            flag = (flag1 | flag2) & menu.hasVisibleItems();
        }
        return flag;
    }

    private class OnCreateOptionsMenuListener
    {

        public abstract void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater);
    }


    private class OnOptionsItemSelectedListener
    {

        public abstract boolean onOptionsItemSelected(MenuItem menuitem);
    }


    private class OnPrepareOptionsMenuListener
    {

        public abstract void onPrepareOptionsMenu(Menu menu);
    }

}
