// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.a.g;
import android.support.v4.c.d;
import android.support.v4.c.m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package android.support.v4.app:
//            LoaderManager, FragmentActivity, FragmentManagerImpl

class LoaderManagerImpl extends LoaderManager
{

    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    FragmentActivity mActivity;
    boolean mCreatingLoader;
    final m mInactiveLoaders = new m();
    final m mLoaders = new m();
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final String mWho;

    LoaderManagerImpl(String s, FragmentActivity fragmentactivity, boolean flag)
    {
        mWho = s;
        mActivity = fragmentactivity;
        mStarted = flag;
    }

    private LoaderInfo createAndInstallLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks)
    {
        LoaderInfo loaderinfo;
        mCreatingLoader = true;
        loaderinfo = createLoader(i, bundle, loadercallbacks);
        installLoader(loaderinfo);
        mCreatingLoader = false;
        return loaderinfo;
        Exception exception;
        exception;
        mCreatingLoader = false;
        throw exception;
    }

    private LoaderInfo createLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks)
    {
        LoaderInfo loaderinfo = new LoaderInfo(i, bundle, loadercallbacks);
        loaderinfo.mLoader = loadercallbacks.onCreateLoader(i, bundle);
        return loaderinfo;
    }

    public void destroyLoader(int i)
    {
        if (mCreatingLoader)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("destroyLoader in ")).append(this).append(" of ").append(i).toString());
        }
        int j = mLoaders.f(i);
        if (j >= 0)
        {
            LoaderInfo loaderinfo1 = (LoaderInfo)mLoaders.e(j);
            mLoaders.c(j);
            loaderinfo1.destroy();
        }
        int k = mInactiveLoaders.f(i);
        if (k >= 0)
        {
            LoaderInfo loaderinfo = (LoaderInfo)mInactiveLoaders.e(k);
            mInactiveLoaders.c(k);
            loaderinfo.destroy();
        }
        if (mActivity != null && !hasRunningLoaders())
        {
            mActivity.mFragments.startPendingDeferredFragments();
        }
    }

    void doDestroy()
    {
        if (!mRetaining)
        {
            if (DEBUG)
            {
                Log.v("LoaderManager", (new StringBuilder("Destroying Active in ")).append(this).toString());
            }
            for (int j = -1 + mLoaders.a(); j >= 0; j--)
            {
                ((LoaderInfo)mLoaders.e(j)).destroy();
            }

            mLoaders.b();
        }
        if (DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("Destroying Inactive in ")).append(this).toString());
        }
        for (int i = -1 + mInactiveLoaders.a(); i >= 0; i--)
        {
            ((LoaderInfo)mInactiveLoaders.e(i)).destroy();
        }

        mInactiveLoaders.b();
    }

    void doReportNextStart()
    {
        for (int i = -1 + mLoaders.a(); i >= 0; i--)
        {
            ((LoaderInfo)mLoaders.e(i)).mReportNextStart = true;
        }

    }

    void doReportStart()
    {
        for (int i = -1 + mLoaders.a(); i >= 0; i--)
        {
            ((LoaderInfo)mLoaders.e(i)).reportStart();
        }

    }

    void doRetain()
    {
        if (DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("Retaining in ")).append(this).toString());
        }
        if (!mStarted)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder("Called doRetain when not started: ")).append(this).toString(), runtimeexception);
        } else
        {
            mRetaining = true;
            mStarted = false;
            int i = -1 + mLoaders.a();
            while (i >= 0) 
            {
                ((LoaderInfo)mLoaders.e(i)).retain();
                i--;
            }
        }
    }

    void doStart()
    {
        if (DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("Starting in ")).append(this).toString());
        }
        if (mStarted)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder("Called doStart when already started: ")).append(this).toString(), runtimeexception);
        } else
        {
            mStarted = true;
            int i = -1 + mLoaders.a();
            while (i >= 0) 
            {
                ((LoaderInfo)mLoaders.e(i)).start();
                i--;
            }
        }
    }

    void doStop()
    {
        if (DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("Stopping in ")).append(this).toString());
        }
        if (!mStarted)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder("Called doStop when not started: ")).append(this).toString(), runtimeexception);
            return;
        }
        for (int i = -1 + mLoaders.a(); i >= 0; i--)
        {
            ((LoaderInfo)mLoaders.e(i)).stop();
        }

        mStarted = false;
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        int i = 0;
        if (mLoaders.a() > 0)
        {
            printwriter.print(s);
            printwriter.println("Active Loaders:");
            String s2 = (new StringBuilder()).append(s).append("    ").toString();
            for (int j = 0; j < mLoaders.a(); j++)
            {
                LoaderInfo loaderinfo1 = (LoaderInfo)mLoaders.e(j);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(mLoaders.d(j));
                printwriter.print(": ");
                printwriter.println(loaderinfo1.toString());
                loaderinfo1.dump(s2, filedescriptor, printwriter, as);
            }

        }
        if (mInactiveLoaders.a() > 0)
        {
            printwriter.print(s);
            printwriter.println("Inactive Loaders:");
            String s1 = (new StringBuilder()).append(s).append("    ").toString();
            for (; i < mInactiveLoaders.a(); i++)
            {
                LoaderInfo loaderinfo = (LoaderInfo)mInactiveLoaders.e(i);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(mInactiveLoaders.d(i));
                printwriter.print(": ");
                printwriter.println(loaderinfo.toString());
                loaderinfo.dump(s1, filedescriptor, printwriter, as);
            }

        }
    }

    void finishRetain()
    {
        if (mRetaining)
        {
            if (DEBUG)
            {
                Log.v("LoaderManager", (new StringBuilder("Finished Retaining in ")).append(this).toString());
            }
            mRetaining = false;
            for (int i = -1 + mLoaders.a(); i >= 0; i--)
            {
                ((LoaderInfo)mLoaders.e(i)).finishRetain();
            }

        }
    }

    public g getLoader(int i)
    {
        if (mCreatingLoader)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderinfo = (LoaderInfo)mLoaders.a(i);
        if (loaderinfo != null)
        {
            if (loaderinfo.mPendingLoader != null)
            {
                return loaderinfo.mPendingLoader.mLoader;
            } else
            {
                return loaderinfo.mLoader;
            }
        } else
        {
            return null;
        }
    }

    public boolean hasRunningLoaders()
    {
        int i = mLoaders.a();
        int j = 0;
        boolean flag = false;
        while (j < i) 
        {
            LoaderInfo loaderinfo = (LoaderInfo)mLoaders.e(j);
            boolean flag1;
            if (loaderinfo.mStarted && !loaderinfo.mDeliveredData)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag |= flag1;
            j++;
        }
        return flag;
    }

    public g initLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks)
    {
        if (mCreatingLoader)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderinfo = (LoaderInfo)mLoaders.a(i);
        if (DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("initLoader in ")).append(this).append(": args=").append(bundle).toString());
        }
        if (loaderinfo == null)
        {
            loaderinfo = createAndInstallLoader(i, bundle, loadercallbacks);
            if (DEBUG)
            {
                Log.v("LoaderManager", (new StringBuilder("  Created new loader ")).append(loaderinfo).toString());
            }
        } else
        {
            if (DEBUG)
            {
                Log.v("LoaderManager", (new StringBuilder("  Re-using existing loader ")).append(loaderinfo).toString());
            }
            loaderinfo.mCallbacks = loadercallbacks;
        }
        if (loaderinfo.mHaveData && mStarted)
        {
            loaderinfo.callOnLoadFinished(loaderinfo.mLoader, loaderinfo.mData);
        }
        return loaderinfo.mLoader;
    }

    void installLoader(LoaderInfo loaderinfo)
    {
        mLoaders.a(loaderinfo.mId, loaderinfo);
        if (mStarted)
        {
            loaderinfo.start();
        }
    }

    public g restartLoader(int i, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks)
    {
        LoaderInfo loaderinfo;
        if (mCreatingLoader)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        loaderinfo = (LoaderInfo)mLoaders.a(i);
        if (DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("restartLoader in ")).append(this).append(": args=").append(bundle).toString());
        }
        if (loaderinfo == null) goto _L2; else goto _L1
_L1:
        LoaderInfo loaderinfo1 = (LoaderInfo)mInactiveLoaders.a(i);
        if (loaderinfo1 == null) goto _L4; else goto _L3
_L3:
        if (!loaderinfo.mHaveData) goto _L6; else goto _L5
_L5:
        if (DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("  Removing last inactive loader: ")).append(loaderinfo).toString());
        }
        loaderinfo1.mDeliveredData = false;
        loaderinfo1.destroy();
_L9:
        loaderinfo.mLoader.d = true;
        mInactiveLoaders.a(i, loaderinfo);
_L2:
        return createAndInstallLoader(i, bundle, loadercallbacks).mLoader;
_L6:
        if (loaderinfo.mStarted)
        {
            break; /* Loop/switch isn't completed */
        }
        if (DEBUG)
        {
            Log.v("LoaderManager", "  Current loader is stopped; replacing");
        }
        mLoaders.a(i, null);
        loaderinfo.destroy();
        if (true) goto _L2; else goto _L7
_L7:
        if (loaderinfo.mPendingLoader != null)
        {
            if (DEBUG)
            {
                Log.v("LoaderManager", (new StringBuilder("  Removing pending loader: ")).append(loaderinfo.mPendingLoader).toString());
            }
            loaderinfo.mPendingLoader.destroy();
            loaderinfo.mPendingLoader = null;
        }
        if (DEBUG)
        {
            Log.v("LoaderManager", "  Enqueuing as new pending loader");
        }
        loaderinfo.mPendingLoader = createLoader(i, bundle, loadercallbacks);
        return loaderinfo.mPendingLoader.mLoader;
_L4:
        if (DEBUG)
        {
            Log.v("LoaderManager", (new StringBuilder("  Making last loader inactive: ")).append(loaderinfo).toString());
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("LoaderManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        d.a(mActivity, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

    void updateActivity(FragmentActivity fragmentactivity)
    {
        mActivity = fragmentactivity;
    }

    static 
    {
        DEBUG = false;
    }

    private class LoaderInfo
        implements h
    {

        final Bundle mArgs;
        LoaderManager.LoaderCallbacks mCallbacks;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        boolean mHaveData;
        final int mId;
        boolean mListenerRegistered;
        g mLoader;
        LoaderInfo mPendingLoader;
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
            LoaderInfo loaderinfo = mPendingLoader;
            if (loaderinfo != null)
            {
                if (LoaderManagerImpl.DEBUG)
                {
                    Log.v("LoaderManager", (new StringBuilder("  Switching to pending loader: ")).append(loaderinfo).toString());
                }
                mPendingLoader = null;
                mLoaders.a(mId, null);
                destroy();
                installLoader(loaderinfo);
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
            LoaderInfo loaderinfo1 = (LoaderInfo)mInactiveLoaders.a(mId);
            if (loaderinfo1 != null && loaderinfo1 != this)
            {
                loaderinfo1.mDeliveredData = false;
                loaderinfo1.destroy();
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

        public LoaderInfo(int i, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks)
        {
            this$0 = LoaderManagerImpl.this;
            super();
            mId = i;
            mArgs = bundle;
            mCallbacks = loadercallbacks;
        }
    }

}
