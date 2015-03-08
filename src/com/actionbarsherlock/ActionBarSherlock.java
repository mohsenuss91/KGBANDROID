// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.ActionBarSherlockCompat;
import com.actionbarsherlock.internal.ActionBarSherlockNative;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public abstract class ActionBarSherlock
{

    private static final Class CONSTRUCTOR_ARGS[];
    public static final boolean DEBUG = false;
    public static final int FLAG_DELEGATE = 1;
    private static final HashMap IMPLEMENTATIONS = new HashMap();
    protected static final String TAG = "ActionBarSherlock";
    protected final Activity mActivity;
    protected final boolean mIsDelegate;
    protected MenuInflater mMenuInflater;

    public ActionBarSherlock(Activity activity, int i)
    {
        mActivity = activity;
        boolean flag;
        if ((i & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDelegate = flag;
    }

    public static void registerImplementation(Class class1)
    {
        if (!class1.isAnnotationPresent(com/actionbarsherlock/ActionBarSherlock$Implementation))
        {
            throw new IllegalArgumentException((new StringBuilder("Class ")).append(class1.getSimpleName()).append(" is not annotated with @Implementation").toString());
        }
        if (IMPLEMENTATIONS.containsValue(class1))
        {
            return;
        } else
        {
            Implementation implementation = (Implementation)class1.getAnnotation(com/actionbarsherlock/ActionBarSherlock$Implementation);
            IMPLEMENTATIONS.put(implementation, class1);
            return;
        }
    }

    public static boolean unregisterImplementation(Class class1)
    {
        return IMPLEMENTATIONS.values().remove(class1);
    }

    public static ActionBarSherlock wrap(Activity activity)
    {
        return wrap(activity, 0);
    }

    public static ActionBarSherlock wrap(Activity activity, int i)
    {
        int j;
        HashMap hashmap;
        Iterator iterator;
        j = 0;
        hashmap = new HashMap(IMPLEMENTATIONS);
        iterator = hashmap.keySet().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (((Implementation)iterator.next()).dpi() != 213) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L11:
        Iterator iterator1;
        if (flag)
        {
            boolean flag2;
            Iterator iterator4;
            if (activity.getResources().getDisplayMetrics().densityDpi == 213)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            iterator4 = hashmap.keySet().iterator();
            do
            {
                if (!iterator4.hasNext())
                {
                    break;
                }
                int i1 = ((Implementation)iterator4.next()).dpi();
                if (flag2 && i1 != 213 || !flag2 && i1 == 213)
                {
                    iterator4.remove();
                }
            } while (true);
        }
        iterator1 = hashmap.keySet().iterator();
_L8:
        if (!iterator1.hasNext()) goto _L6; else goto _L5
_L5:
        if (((Implementation)iterator1.next()).api() == -1) goto _L8; else goto _L7
_L7:
        boolean flag1 = true;
_L9:
        if (flag1)
        {
            int k = android.os.Build.VERSION.SDK_INT;
            Iterator iterator2 = hashmap.keySet().iterator();
            do
            {
                if (!iterator2.hasNext())
                {
                    break;
                }
                int l = ((Implementation)iterator2.next()).api();
                if (l > k)
                {
                    iterator2.remove();
                } else
                if (l > j)
                {
                    j = l;
                }
            } while (true);
            Iterator iterator3 = hashmap.keySet().iterator();
            do
            {
                if (!iterator3.hasNext())
                {
                    break;
                }
                if (((Implementation)iterator3.next()).api() != j)
                {
                    iterator3.remove();
                }
            } while (true);
        }
        if (hashmap.size() > 1)
        {
            throw new IllegalStateException("More than one implementation matches configuration.");
        }
        if (hashmap.isEmpty())
        {
            throw new IllegalStateException("No implementations match configuration.");
        }
        Class class1 = (Class)hashmap.values().iterator().next();
        ActionBarSherlock actionbarsherlock;
        try
        {
            Constructor constructor = class1.getConstructor(CONSTRUCTOR_ARGS);
            Object aobj[] = new Object[2];
            aobj[0] = activity;
            aobj[1] = Integer.valueOf(i);
            actionbarsherlock = (ActionBarSherlock)constructor.newInstance(aobj);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            throw new RuntimeException(nosuchmethodexception);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new RuntimeException(illegalargumentexception);
        }
        catch (InstantiationException instantiationexception)
        {
            throw new RuntimeException(instantiationexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RuntimeException(illegalaccessexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new RuntimeException(invocationtargetexception);
        }
        return actionbarsherlock;
_L6:
        flag1 = false;
        if (true) goto _L9; else goto _L2
_L2:
        flag = false;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public abstract void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams);

    protected final boolean callbackCreateOptionsMenu(Menu menu)
    {
        boolean flag = true;
        if (mActivity instanceof OnCreatePanelMenuListener)
        {
            flag = ((OnCreatePanelMenuListener)mActivity).onCreatePanelMenu(0, menu);
        } else
        if (mActivity instanceof OnCreateOptionsMenuListener)
        {
            return ((OnCreateOptionsMenuListener)mActivity).onCreateOptionsMenu(menu);
        }
        return flag;
    }

    protected final boolean callbackOptionsItemSelected(MenuItem menuitem)
    {
        if (mActivity instanceof OnMenuItemSelectedListener)
        {
            return ((OnMenuItemSelectedListener)mActivity).onMenuItemSelected(0, menuitem);
        }
        if (mActivity instanceof OnOptionsItemSelectedListener)
        {
            return ((OnOptionsItemSelectedListener)mActivity).onOptionsItemSelected(menuitem);
        } else
        {
            return false;
        }
    }

    protected final boolean callbackPrepareOptionsMenu(Menu menu)
    {
        boolean flag = true;
        if (mActivity instanceof OnPreparePanelListener)
        {
            flag = ((OnPreparePanelListener)mActivity).onPreparePanel(0, null, menu);
        } else
        if (mActivity instanceof OnPrepareOptionsMenuListener)
        {
            return ((OnPrepareOptionsMenuListener)mActivity).onPrepareOptionsMenu(menu);
        }
        return flag;
    }

    public boolean dispatchCloseOptionsMenu()
    {
        return false;
    }

    public void dispatchConfigurationChanged(Configuration configuration)
    {
    }

    public abstract boolean dispatchCreateOptionsMenu(android.view.Menu menu);

    public void dispatchDestroy()
    {
    }

    public abstract void dispatchInvalidateOptionsMenu();

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return false;
    }

    public boolean dispatchMenuOpened(int i, android.view.Menu menu)
    {
        return false;
    }

    public boolean dispatchOpenOptionsMenu()
    {
        return false;
    }

    public abstract boolean dispatchOptionsItemSelected(android.view.MenuItem menuitem);

    public void dispatchPanelClosed(int i, android.view.Menu menu)
    {
    }

    public void dispatchPause()
    {
    }

    public void dispatchPostCreate(Bundle bundle)
    {
    }

    public void dispatchPostResume()
    {
    }

    public abstract boolean dispatchPrepareOptionsMenu(android.view.Menu menu);

    public void dispatchRestoreInstanceState(Bundle bundle)
    {
    }

    public void dispatchSaveInstanceState(Bundle bundle)
    {
    }

    public void dispatchStop()
    {
    }

    public void dispatchTitleChanged(CharSequence charsequence, int i)
    {
    }

    public void ensureActionBar()
    {
    }

    public abstract ActionBar getActionBar();

    public MenuInflater getMenuInflater()
    {
        if (mMenuInflater == null)
        {
            if (getActionBar() != null)
            {
                mMenuInflater = new MenuInflater(getThemedContext(), mActivity);
            } else
            {
                mMenuInflater = new MenuInflater(mActivity);
            }
        }
        return mMenuInflater;
    }

    protected abstract Context getThemedContext();

    public abstract boolean hasFeature(int i);

    public abstract boolean requestFeature(int i);

    public abstract void setContentView(int i);

    public void setContentView(View view)
    {
        setContentView(view, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public abstract void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract void setProgress(int i);

    public abstract void setProgressBarIndeterminate(boolean flag);

    public abstract void setProgressBarIndeterminateVisibility(boolean flag);

    public abstract void setProgressBarVisibility(boolean flag);

    public abstract void setSecondaryProgress(int i);

    public void setTitle(int i)
    {
        setTitle(((CharSequence) (mActivity.getString(i))));
    }

    public abstract void setTitle(CharSequence charsequence);

    public abstract void setUiOptions(int i);

    public abstract void setUiOptions(int i, int j);

    public abstract ActionMode startActionMode(com.actionbarsherlock.view.ActionMode.Callback callback);

    static 
    {
        Class aclass[] = new Class[2];
        aclass[0] = android/app/Activity;
        aclass[1] = Integer.TYPE;
        CONSTRUCTOR_ARGS = aclass;
        registerImplementation(com/actionbarsherlock/internal/ActionBarSherlockCompat);
        registerImplementation(com/actionbarsherlock/internal/ActionBarSherlockNative);
    }

    private class Implementation
        implements Annotation
    {

        public static final int DEFAULT_API = -1;
        public static final int DEFAULT_DPI = -1;

        public abstract int api();

        public abstract int dpi();
    }


    private class OnCreatePanelMenuListener
    {

        public abstract boolean onCreatePanelMenu(int i, Menu menu);
    }


    private class OnCreateOptionsMenuListener
    {

        public abstract boolean onCreateOptionsMenu(Menu menu);
    }


    private class OnMenuItemSelectedListener
    {

        public abstract boolean onMenuItemSelected(int i, MenuItem menuitem);
    }


    private class OnOptionsItemSelectedListener
    {

        public abstract boolean onOptionsItemSelected(MenuItem menuitem);
    }


    private class OnPreparePanelListener
    {

        public abstract boolean onPreparePanel(int i, View view, Menu menu);
    }


    private class OnPrepareOptionsMenuListener
    {

        public abstract boolean onPrepareOptionsMenu(Menu menu);
    }

}
