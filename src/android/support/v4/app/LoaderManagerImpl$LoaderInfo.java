// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.g;
import android.support.v4.a.h;
import android.support.v4.c.d;
import android.support.v4.c.m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

// Referenced classes of package android.support.v4.app:
//            LoaderManagerImpl, FragmentActivity, FragmentManagerImpl

final class mCallbacks
    implements h
{

    final Bundle mArgs;
     mCallbacks;
    Object mData;
    boolean mDeliveredData;
    boolean mDestroyed;
    boolean mHaveData;
    final int mId;
    boolean mListenerRegistered;
    g mLoader;
     mPendingLoader;
    boolean mReportNextStart;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final LoaderManagerImpl this$0;

    final void callOnLoadFinished(g g1, Object obj)
    {
        if (mCallbacks == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        String s;
        Exception exception;
        StringBuilder stringbuilder;
        StringBuilder stringbuilder1;
        if (mActivity != null)
        {
            String s1 = mActivity.mFragments.mNoTransactionsBecause;
            mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
            s = s1;
        } else
        {
            s = null;
        }
        if (LoaderManagerImpl.DEBUG)
        {
            stringbuilder = (new StringBuilder("  onLoadFinished in ")).append(g1).append(": ");
            stringbuilder1 = new StringBuilder(64);
            d.a(obj, stringbuilder1);
            stringbuilder1.append("}");
            Log.v("LoaderManager", stringbuilder.append(stringbuilder1.toString()).toString());
        }
        mCallbacks.onLoadFinished(g1, obj);
        if (mActivity != null)
        {
            mActivity.mFragments.mNoTransactionsBecause = s;
        }
        mDeliveredData = true;
        return;
        exception;
        if (mActivity != null)
        {
            mActivity.mFragments.mNoTransactionsBecause = s;
        }
        throw exception;
    }

    final void destroy()
    {
_L2:
        if (LoaderManagerImpl.DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("  Destroying: ")).append(this).toString());
        }
        mDestroyed = true;
        boolean flag = mDeliveredData;
        mDeliveredData = false;
        if (mCallbacks == null || mLoader == null || !mHaveData || !flag)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        if (LoaderManagerImpl.DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("  Reseting: ")).append(this).toString());
        }
        g g1;
        String s;
        Exception exception;
        if (mActivity != null)
        {
            String s1 = mActivity.mFragments.mNoTransactionsBecause;
            mActivity.mFragments.mNoTransactionsBecause = "onLoaderReset";
            s = s1;
        } else
        {
            s = null;
        }
        mCallbacks.onLoaderReset(mLoader);
        if (mActivity != null)
        {
            mActivity.mFragments.mNoTransactionsBecause = s;
        }
        mCallbacks = null;
        mData = null;
        mHaveData = false;
        if (mLoader != null)
        {
            if (mListenerRegistered)
            {
                mListenerRegistered = false;
                mLoader.a(this);
            }
            g1 = mLoader;
            g1.e = true;
            g1.c = false;
            g1.d = false;
            g1.f = false;
            g1.g = false;
        }
        if (mPendingLoader != null)
        {
            this = mPendingLoader;
        } else
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        if (mActivity != null)
        {
            mActivity.mFragments.mNoTransactionsBecause = s;
        }
        throw exception;
    }

    public final void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        do
        {
            printwriter.print(s);
            printwriter.print("mId=");
            printwriter.print(mId);
            printwriter.print(" mArgs=");
            printwriter.println(mArgs);
            printwriter.print(s);
            printwriter.print("mCallbacks=");
            printwriter.println(mCallbacks);
            printwriter.print(s);
            printwriter.print("mLoader=");
            printwriter.println(mLoader);
            if (mLoader != null)
            {
                g g1 = mLoader;
                String s1 = (new StringBuilder()).append(s).append("  ").toString();
                printwriter.print(s1);
                printwriter.print("mId=");
                printwriter.print(g1.a);
                printwriter.print(" mListener=");
                printwriter.println(g1.b);
                if (g1.c || g1.f || g1.g)
                {
                    printwriter.print(s1);
                    printwriter.print("mStarted=");
                    printwriter.print(g1.c);
                    printwriter.print(" mContentChanged=");
                    printwriter.print(g1.f);
                    printwriter.print(" mProcessingChange=");
                    printwriter.println(g1.g);
                }
                if (g1.d || g1.e)
                {
                    printwriter.print(s1);
                    printwriter.print("mAbandoned=");
                    printwriter.print(g1.d);
                    printwriter.print(" mReset=");
                    printwriter.println(g1.e);
                }
            }
            if (mHaveData || mDeliveredData)
            {
                printwriter.print(s);
                printwriter.print("mHaveData=");
                printwriter.print(mHaveData);
                printwriter.print("  mDeliveredData=");
                printwriter.println(mDeliveredData);
                printwriter.print(s);
                printwriter.print("mData=");
                printwriter.println(mData);
            }
            printwriter.print(s);
            printwriter.print("mStarted=");
            printwriter.print(mStarted);
            printwriter.print(" mReportNextStart=");
            printwriter.print(mReportNextStart);
            printwriter.print(" mDestroyed=");
            printwriter.println(mDestroyed);
            printwriter.print(s);
            printwriter.print("mRetaining=");
            printwriter.print(mRetaining);
            printwriter.print(" mRetainingStarted=");
            printwriter.print(mRetainingStarted);
            printwriter.print(" mListenerRegistered=");
            printwriter.println(mListenerRegistered);
            if (mPendingLoader != null)
            {
                printwriter.print(s);
                printwriter.println("Pending Loader ");
                printwriter.print(mPendingLoader);
                printwriter.println(":");
                this = mPendingLoader;
                s = (new StringBuilder()).append(s).append("  ").toString();
            } else
            {
                return;
            }
        } while (true);
    }

    final void finishRetain()
    {
        if (mRetaining)
        {
            if (LoaderManagerImpl.DEBUG)
            {
                Log.v("LoaderManager", (new StringBuilder("  Finished Retaining: ")).append(this).toString());
            }
            mRetaining = false;
            if (mStarted != mRetainingStarted && !mStarted)
            {
                stop();
            }
        }
        if (mStarted && mHaveData && !mReportNextStart)
        {
            callOnLoadFinished(mLoader, mData);
        }
    }

    public final void onLoadComplete(g g1, Object obj)
    {
        if (LoaderManagerImpl.DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("onLoadComplete: ")).append(this).toString());
        }
        if (!mDestroyed) goto _L2; else goto _L1
_L1:
        if (LoaderManagerImpl.DEBUG)
        {
            Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
        }
_L4:
        return;
_L2:
        if (mLoaders.a(mId) == this)
        {
            break; /* Loop/switch isn't completed */
        }
        if (LoaderManagerImpl.DEBUG)
        {
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        mData mdata = mPendingLoader;
        if (mdata != null)
        {
            if (LoaderManagerImpl.DEBUG)
            {
                Log.v("LoaderManager", (new StringBuilder("  Switching to pending loader: ")).append(mdata).toString());
            }
            mPendingLoader = null;
            mLoaders.a(mId, null);
            destroy();
            installLoader(mdata);
            return;
        }
        if (mData != obj || !mHaveData)
        {
            mData = obj;
            mHaveData = true;
            if (mStarted)
            {
                callOnLoadFinished(g1, obj);
            }
        }
        mData mdata1 = (callOnLoadFinished)mInactiveLoaders.a(mId);
        if (mdata1 != null && mdata1 != this)
        {
            mdata1.mDeliveredData = false;
            mdata1.destroy();
            mInactiveLoaders.b(mId);
        }
        if (mActivity != null && !hasRunningLoaders())
        {
            mActivity.mFragments.startPendingDeferredFragments();
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    final void reportStart()
    {
        if (mStarted && mReportNextStart)
        {
            mReportNextStart = false;
            if (mHaveData)
            {
                callOnLoadFinished(mLoader, mData);
            }
        }
    }

    final void retain()
    {
        if (LoaderManagerImpl.DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("  Retaining: ")).append(this).toString());
        }
        mRetaining = true;
        mRetainingStarted = mStarted;
        mStarted = false;
        mCallbacks = null;
    }

    final void start()
    {
        if (mRetaining && mRetainingStarted)
        {
            mStarted = true;
        } else
        if (!mStarted)
        {
            mStarted = true;
            if (LoaderManagerImpl.DEBUG)
            {
                Log.v("LoaderManager", (new StringBuilder("  Starting: ")).append(this).toString());
            }
            if (mLoader == null && mCallbacks != null)
            {
                mLoader = mCallbacks.onCreateLoader(mId, mArgs);
            }
            if (mLoader != null)
            {
                if (mLoader.getClass().isMemberClass() && !Modifier.isStatic(mLoader.getClass().getModifiers()))
                {
                    throw new IllegalArgumentException((new StringBuilder("Object returned from onCreateLoader must not be a non-static inner member class: ")).append(mLoader).toString());
                }
                if (!mListenerRegistered)
                {
                    g g2 = mLoader;
                    int i = mId;
                    if (g2.b != null)
                    {
                        throw new IllegalStateException("There is already a listener registered");
                    }
                    g2.b = this;
                    g2.a = i;
                    mListenerRegistered = true;
                }
                g g1 = mLoader;
                g1.c = true;
                g1.e = false;
                g1.d = false;
                return;
            }
        }
    }

    final void stop()
    {
        if (LoaderManagerImpl.DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("  Stopping: ")).append(this).toString());
        }
        mStarted = false;
        if (!mRetaining && mLoader != null && mListenerRegistered)
        {
            mListenerRegistered = false;
            mLoader.a(this);
            mLoader.c = false;
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append("LoaderInfo{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" #");
        stringbuilder.append(mId);
        stringbuilder.append(" : ");
        d.a(mLoader, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

    public (int i, Bundle bundle,  )
    {
        this$0 = LoaderManagerImpl.this;
        super();
        mId = i;
        mArgs = bundle;
        mCallbacks = ;
    }
}
