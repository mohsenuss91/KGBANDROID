// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

// Referenced classes of package com.millennialmedia.android:
//            MMBaseActivity

public class MMActivity extends Activity
{

    long creatorAdImplInternalId;
    private MMBaseActivity mmBaseActivity;

    public MMActivity()
    {
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (mmBaseActivity != null)
        {
            return mmBaseActivity.dispatchTouchEvent(motionevent);
        } else
        {
            return super.dispatchTouchEvent(motionevent);
        }
    }

    boolean dispatchTouchEventSuper(MotionEvent motionevent)
    {
        return super.dispatchTouchEvent(motionevent);
    }

    public void finish()
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.finish();
            return;
        } else
        {
            MMSDK.Event.overlayClosed(this, creatorAdImplInternalId);
            super.finish();
            return;
        }
    }

    public void finishSuper()
    {
        MMSDK.Event.overlayClosed(this, creatorAdImplInternalId);
        super.finish();
    }

    protected MMBaseActivity getWrappedActivity()
    {
        return mmBaseActivity;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.onActivityResult(i, j, intent);
            return;
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    void onActivityResultSuper(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.onConfigurationChanged(configuration);
            return;
        } else
        {
            super.onConfigurationChanged(configuration);
            return;
        }
    }

    void onConfigurationChangedSuper(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        String s = null;
        creatorAdImplInternalId = getIntent().getLongExtra("internalId", -4L);
        try
        {
            s = getIntent().getStringExtra("class");
            mmBaseActivity = (MMBaseActivity)Class.forName(s).newInstance();
            mmBaseActivity.activity = this;
            mmBaseActivity.onCreate(bundle);
            return;
        }
        catch (Exception exception)
        {
            Object aobj[] = new Object[2];
            aobj[0] = s;
            aobj[1] = exception.getMessage();
            MMSDK.Log.e("Could not start activity for %s. %s", aobj);
            exception.printStackTrace();
            finish();
            return;
        }
    }

    void onCreateSuper(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    protected void onDestroy()
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.onDestroy();
            return;
        } else
        {
            super.onDestroy();
            return;
        }
    }

    void onDestroySuper()
    {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (mmBaseActivity != null)
        {
            return mmBaseActivity.onKeyDown(i, keyevent);
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    boolean onKeyDownSuper(int i, KeyEvent keyevent)
    {
        return super.onKeyDown(i, keyevent);
    }

    protected void onPause()
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.onPause();
            return;
        } else
        {
            super.onPause();
            return;
        }
    }

    void onPauseSuper()
    {
        super.onPause();
    }

    protected void onRestart()
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.onRestart();
            return;
        } else
        {
            super.onRestart();
            return;
        }
    }

    void onRestartSuper()
    {
        super.onRestart();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.onRestoreInstanceState(bundle);
            return;
        } else
        {
            super.onRestoreInstanceState(bundle);
            return;
        }
    }

    void onRestoreInstanceStateSuper(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.onResume();
            return;
        } else
        {
            super.onResume();
            return;
        }
    }

    void onResumeSuper()
    {
        super.onResume();
    }

    public Object onRetainNonConfigurationInstance()
    {
        if (mmBaseActivity != null)
        {
            return mmBaseActivity.onRetainNonConfigurationInstance();
        } else
        {
            return super.onRetainNonConfigurationInstance();
        }
    }

    Object onRetainNonConfigurationInstanceSuper()
    {
        return super.onRetainNonConfigurationInstance();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.onSaveInstanceState(bundle);
            return;
        } else
        {
            super.onSaveInstanceState(bundle);
            return;
        }
    }

    void onSaveInstanceStateSuper(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.onStart();
            return;
        } else
        {
            super.onStart();
            return;
        }
    }

    void onStartSuper()
    {
        super.onStart();
    }

    protected void onStop()
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.onStop();
            return;
        } else
        {
            super.onStop();
            return;
        }
    }

    void onStopSuper()
    {
        super.onStop();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        if (mmBaseActivity != null)
        {
            mmBaseActivity.onWindowFocusChanged(flag);
            return;
        } else
        {
            super.onWindowFocusChanged(flag);
            return;
        }
    }

    void onWindowFocusChangedSuper(boolean flag)
    {
        super.onWindowFocusChanged(flag);
    }
}
