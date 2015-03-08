// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;

public class y extends Activity
{

    private Activity a;

    public y(Activity activity)
    {
        a = activity;
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        a.addContentView(view, layoutparams);
    }

    public boolean bindService(Intent intent, ServiceConnection serviceconnection, int i)
    {
        return a.bindService(intent, serviceconnection, i);
    }

    public int checkCallingOrSelfPermission(String s)
    {
        return a.checkCallingOrSelfPermission(s);
    }

    public int checkCallingOrSelfUriPermission(Uri uri, int i)
    {
        return a.checkCallingOrSelfUriPermission(uri, i);
    }

    public int checkCallingPermission(String s)
    {
        return a.checkCallingPermission(s);
    }

    public int checkCallingUriPermission(Uri uri, int i)
    {
        return a.checkCallingUriPermission(uri, i);
    }

    public int checkPermission(String s, int i, int j)
    {
        return a.checkPermission(s, i, j);
    }

    public int checkUriPermission(Uri uri, int i, int j, int k)
    {
        return a.checkUriPermission(uri, i, j, k);
    }

    public int checkUriPermission(Uri uri, String s, String s1, int i, int j, int k)
    {
        return a.checkUriPermission(uri, s, s1, i, j, k);
    }

    public void clearWallpaper()
    {
        a.clearWallpaper();
    }

    public void closeContextMenu()
    {
        a.closeContextMenu();
    }

    public void closeOptionsMenu()
    {
        a.closeOptionsMenu();
    }

    public Context createPackageContext(String s, int i)
    {
        return a.createPackageContext(s, i);
    }

    public PendingIntent createPendingResult(int i, Intent intent, int j)
    {
        return a.createPendingResult(i, intent, j);
    }

    public String[] databaseList()
    {
        return a.databaseList();
    }

    public boolean deleteDatabase(String s)
    {
        return a.deleteDatabase(s);
    }

    public boolean deleteFile(String s)
    {
        return a.deleteFile(s);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionevent)
    {
        return a.dispatchGenericMotionEvent(motionevent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return a.dispatchKeyEvent(keyevent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyevent)
    {
        return a.dispatchKeyShortcutEvent(keyevent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        return a.dispatchPopulateAccessibilityEvent(accessibilityevent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        return a.dispatchTouchEvent(motionevent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionevent)
    {
        return a.dispatchTrackballEvent(motionevent);
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        a.dump(s, filedescriptor, printwriter, as);
    }

    public void enforceCallingOrSelfPermission(String s, String s1)
    {
        a.enforceCallingOrSelfPermission(s, s1);
    }

    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String s)
    {
        a.enforceCallingOrSelfUriPermission(uri, i, s);
    }

    public void enforceCallingPermission(String s, String s1)
    {
        a.enforceCallingPermission(s, s1);
    }

    public void enforceCallingUriPermission(Uri uri, int i, String s)
    {
        a.enforceCallingUriPermission(uri, i, s);
    }

    public void enforcePermission(String s, int i, int j, String s1)
    {
        a.enforcePermission(s, i, j, s1);
    }

    public void enforceUriPermission(Uri uri, int i, int j, int k, String s)
    {
        a.enforceUriPermission(uri, i, j, k, s);
    }

    public void enforceUriPermission(Uri uri, String s, String s1, int i, int j, int k, String s2)
    {
        a.enforceUriPermission(uri, s, s1, i, j, k, s2);
    }

    public boolean equals(Object obj)
    {
        return a.equals(obj);
    }

    public String[] fileList()
    {
        return a.fileList();
    }

    public View findViewById(int i)
    {
        return a.findViewById(i);
    }

    public void finish()
    {
        a.finish();
    }

    public void finishActivity(int i)
    {
        a.finishActivity(i);
    }

    public void finishActivityFromChild(Activity activity, int i)
    {
        a.finishActivityFromChild(activity, i);
    }

    public void finishAffinity()
    {
        a.finishAffinity();
    }

    public void finishFromChild(Activity activity)
    {
        a.finishFromChild(activity);
    }

    public ActionBar getActionBar()
    {
        return a.getActionBar();
    }

    public Context getApplicationContext()
    {
        return a.getApplicationContext();
    }

    public ApplicationInfo getApplicationInfo()
    {
        return a.getApplicationInfo();
    }

    public AssetManager getAssets()
    {
        return a.getAssets();
    }

    public Context getBaseContext()
    {
        return a.getBaseContext();
    }

    public File getCacheDir()
    {
        return a.getCacheDir();
    }

    public ComponentName getCallingActivity()
    {
        return a.getCallingActivity();
    }

    public String getCallingPackage()
    {
        return a.getCallingPackage();
    }

    public int getChangingConfigurations()
    {
        return a.getChangingConfigurations();
    }

    public ClassLoader getClassLoader()
    {
        return a.getClassLoader();
    }

    public ComponentName getComponentName()
    {
        return a.getComponentName();
    }

    public ContentResolver getContentResolver()
    {
        return a.getContentResolver();
    }

    public View getCurrentFocus()
    {
        return a.getCurrentFocus();
    }

    public File getDatabasePath(String s)
    {
        return a.getDatabasePath(s);
    }

    public File getDir(String s, int i)
    {
        return a.getDir(s, i);
    }

    public File getExternalCacheDir()
    {
        return a.getExternalCacheDir();
    }

    public File getExternalFilesDir(String s)
    {
        return a.getExternalFilesDir(s);
    }

    public File getFileStreamPath(String s)
    {
        return a.getFileStreamPath(s);
    }

    public File getFilesDir()
    {
        return a.getFilesDir();
    }

    public FragmentManager getFragmentManager()
    {
        return a.getFragmentManager();
    }

    public Intent getIntent()
    {
        return a.getIntent();
    }

    public Object getLastNonConfigurationInstance()
    {
        return a.getLastNonConfigurationInstance();
    }

    public LayoutInflater getLayoutInflater()
    {
        return a.getLayoutInflater();
    }

    public LoaderManager getLoaderManager()
    {
        return a.getLoaderManager();
    }

    public String getLocalClassName()
    {
        return a.getLocalClassName();
    }

    public Looper getMainLooper()
    {
        return a.getMainLooper();
    }

    public MenuInflater getMenuInflater()
    {
        return a.getMenuInflater();
    }

    public File getObbDir()
    {
        return a.getObbDir();
    }

    public String getPackageCodePath()
    {
        return a.getPackageCodePath();
    }

    public PackageManager getPackageManager()
    {
        return a.getPackageManager();
    }

    public String getPackageName()
    {
        return a.getPackageName();
    }

    public String getPackageResourcePath()
    {
        return a.getPackageResourcePath();
    }

    public Intent getParentActivityIntent()
    {
        return a.getParentActivityIntent();
    }

    public SharedPreferences getPreferences(int i)
    {
        return a.getPreferences(i);
    }

    public int getRequestedOrientation()
    {
        return a.getRequestedOrientation();
    }

    public Resources getResources()
    {
        return a.getResources();
    }

    public SharedPreferences getSharedPreferences(String s, int i)
    {
        return a.getSharedPreferences(s, i);
    }

    public Object getSystemService(String s)
    {
        return a.getSystemService(s);
    }

    public int getTaskId()
    {
        return a.getTaskId();
    }

    public android.content.res.Resources.Theme getTheme()
    {
        return a.getTheme();
    }

    public Drawable getWallpaper()
    {
        return a.getWallpaper();
    }

    public int getWallpaperDesiredMinimumHeight()
    {
        return a.getWallpaperDesiredMinimumHeight();
    }

    public int getWallpaperDesiredMinimumWidth()
    {
        return a.getWallpaperDesiredMinimumWidth();
    }

    public Window getWindow()
    {
        return a.getWindow();
    }

    public WindowManager getWindowManager()
    {
        return a.getWindowManager();
    }

    public void grantUriPermission(String s, Uri uri, int i)
    {
        a.grantUriPermission(s, uri, i);
    }

    public boolean hasWindowFocus()
    {
        return a.hasWindowFocus();
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public void invalidateOptionsMenu()
    {
        a.invalidateOptionsMenu();
    }

    public boolean isChangingConfigurations()
    {
        return a.isChangingConfigurations();
    }

    public boolean isFinishing()
    {
        return a.isFinishing();
    }

    public boolean isRestricted()
    {
        return a.isRestricted();
    }

    public boolean isTaskRoot()
    {
        return a.isTaskRoot();
    }

    public boolean moveTaskToBack(boolean flag)
    {
        return a.moveTaskToBack(flag);
    }

    public boolean navigateUpTo(Intent intent)
    {
        return a.navigateUpTo(intent);
    }

    public boolean navigateUpToFromChild(Activity activity, Intent intent)
    {
        return a.navigateUpToFromChild(activity, intent);
    }

    public void onActionModeFinished(ActionMode actionmode)
    {
        a.onActionModeFinished(actionmode);
    }

    public void onActionModeStarted(ActionMode actionmode)
    {
        a.onActionModeStarted(actionmode);
    }

    public void onAttachFragment(Fragment fragment)
    {
        a.onAttachFragment(fragment);
    }

    public void onAttachedToWindow()
    {
        a.onAttachedToWindow();
    }

    public void onBackPressed()
    {
        a.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        a.onConfigurationChanged(configuration);
    }

    public void onContentChanged()
    {
        a.onContentChanged();
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        return a.onContextItemSelected(menuitem);
    }

    public void onContextMenuClosed(Menu menu)
    {
        a.onContextMenuClosed(menu);
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        a.onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public CharSequence onCreateDescription()
    {
        return a.onCreateDescription();
    }

    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskstackbuilder)
    {
        a.onCreateNavigateUpTaskStack(taskstackbuilder);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return a.onCreateOptionsMenu(menu);
    }

    public boolean onCreatePanelMenu(int i, Menu menu)
    {
        return a.onCreatePanelMenu(i, menu);
    }

    public View onCreatePanelView(int i)
    {
        return a.onCreatePanelView(i);
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas)
    {
        return a.onCreateThumbnail(bitmap, canvas);
    }

    public View onCreateView(View view, String s, Context context, AttributeSet attributeset)
    {
        return a.onCreateView(view, s, context, attributeset);
    }

    public View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        return a.onCreateView(s, context, attributeset);
    }

    public void onDetachedFromWindow()
    {
        a.onDetachedFromWindow();
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent)
    {
        return a.onGenericMotionEvent(motionevent);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return a.onKeyDown(i, keyevent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyevent)
    {
        return a.onKeyLongPress(i, keyevent);
    }

    public boolean onKeyMultiple(int i, int j, KeyEvent keyevent)
    {
        return a.onKeyMultiple(i, j, keyevent);
    }

    public boolean onKeyShortcut(int i, KeyEvent keyevent)
    {
        return a.onKeyShortcut(i, keyevent);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        return a.onKeyUp(i, keyevent);
    }

    public void onLowMemory()
    {
        a.onLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        return a.onMenuItemSelected(i, menuitem);
    }

    public boolean onMenuOpened(int i, Menu menu)
    {
        return a.onMenuOpened(i, menu);
    }

    public boolean onNavigateUp()
    {
        return a.onNavigateUp();
    }

    public boolean onNavigateUpFromChild(Activity activity)
    {
        return a.onNavigateUpFromChild(activity);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return a.onOptionsItemSelected(menuitem);
    }

    public void onOptionsMenuClosed(Menu menu)
    {
        a.onOptionsMenuClosed(menu);
    }

    public void onPanelClosed(int i, Menu menu)
    {
        a.onPanelClosed(i, menu);
    }

    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskstackbuilder)
    {
        a.onPrepareNavigateUpTaskStack(taskstackbuilder);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return a.onPrepareOptionsMenu(menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu)
    {
        return a.onPreparePanel(i, view, menu);
    }

    public Object onRetainNonConfigurationInstance()
    {
        return a.onRetainNonConfigurationInstance();
    }

    public boolean onSearchRequested()
    {
        return a.onSearchRequested();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return a.onTouchEvent(motionevent);
    }

    public boolean onTrackballEvent(MotionEvent motionevent)
    {
        return a.onTrackballEvent(motionevent);
    }

    public void onTrimMemory(int i)
    {
        a.onTrimMemory(i);
    }

    public void onUserInteraction()
    {
        a.onUserInteraction();
    }

    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams layoutparams)
    {
        a.onWindowAttributesChanged(layoutparams);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        a.onWindowFocusChanged(flag);
    }

    public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback)
    {
        return a.onWindowStartingActionMode(callback);
    }

    public void openContextMenu(View view)
    {
        a.openContextMenu(view);
    }

    public FileInputStream openFileInput(String s)
    {
        return a.openFileInput(s);
    }

    public FileOutputStream openFileOutput(String s, int i)
    {
        return a.openFileOutput(s, i);
    }

    public void openOptionsMenu()
    {
        a.openOptionsMenu();
    }

    public SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory)
    {
        return a.openOrCreateDatabase(s, i, cursorfactory);
    }

    public SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, DatabaseErrorHandler databaseerrorhandler)
    {
        return a.openOrCreateDatabase(s, i, cursorfactory, databaseerrorhandler);
    }

    public void overridePendingTransition(int i, int j)
    {
        a.overridePendingTransition(i, j);
    }

    public Drawable peekWallpaper()
    {
        return a.peekWallpaper();
    }

    public void recreate()
    {
        a.recreate();
    }

    public void registerComponentCallbacks(ComponentCallbacks componentcallbacks)
    {
        a.registerComponentCallbacks(componentcallbacks);
    }

    public void registerForContextMenu(View view)
    {
        a.registerForContextMenu(view);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        return a.registerReceiver(broadcastreceiver, intentfilter);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter, String s, Handler handler)
    {
        return a.registerReceiver(broadcastreceiver, intentfilter, s, handler);
    }

    public void removeStickyBroadcast(Intent intent)
    {
        a.removeStickyBroadcast(intent);
    }

    public void revokeUriPermission(Uri uri, int i)
    {
        a.revokeUriPermission(uri, i);
    }

    public void sendBroadcast(Intent intent)
    {
        a.sendBroadcast(intent);
    }

    public void sendBroadcast(Intent intent, String s)
    {
        a.sendBroadcast(intent, s);
    }

    public void sendOrderedBroadcast(Intent intent, String s)
    {
        a.sendOrderedBroadcast(intent, s);
    }

    public void sendOrderedBroadcast(Intent intent, String s, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s1, Bundle bundle)
    {
        a.sendOrderedBroadcast(intent, s, broadcastreceiver, handler, i, s1, bundle);
    }

    public void sendStickyBroadcast(Intent intent)
    {
        a.sendStickyBroadcast(intent);
    }

    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s, Bundle bundle)
    {
        a.sendStickyOrderedBroadcast(intent, broadcastreceiver, handler, i, s, bundle);
    }

    public void setContentView(int i)
    {
        a.setContentView(i);
    }

    public void setContentView(View view)
    {
        a.setContentView(view);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        a.setContentView(view, layoutparams);
    }

    public void setFinishOnTouchOutside(boolean flag)
    {
        a.setFinishOnTouchOutside(flag);
    }

    public void setIntent(Intent intent)
    {
        a.setIntent(intent);
    }

    public void setRequestedOrientation(int i)
    {
        a.setRequestedOrientation(i);
    }

    public void setTheme(int i)
    {
        a.setTheme(i);
    }

    public void setTitle(int i)
    {
        a.setTitle(i);
    }

    public void setTitle(CharSequence charsequence)
    {
        a.setTitle(charsequence);
    }

    public void setTitleColor(int i)
    {
        a.setTitleColor(i);
    }

    public void setVisible(boolean flag)
    {
        a.setVisible(flag);
    }

    public void setWallpaper(Bitmap bitmap)
    {
        a.setWallpaper(bitmap);
    }

    public void setWallpaper(InputStream inputstream)
    {
        a.setWallpaper(inputstream);
    }

    public boolean shouldUpRecreateTask(Intent intent)
    {
        return a.shouldUpRecreateTask(intent);
    }

    public ActionMode startActionMode(android.view.ActionMode.Callback callback)
    {
        return a.startActionMode(callback);
    }

    public void startActivities(Intent aintent[])
    {
        a.startActivities(aintent);
    }

    public void startActivities(Intent aintent[], Bundle bundle)
    {
        a.startActivities(aintent, bundle);
    }

    public void startActivity(Intent intent)
    {
        a.startActivity(intent);
    }

    public void startActivity(Intent intent, Bundle bundle)
    {
        a.startActivity(intent, bundle);
    }

    public void startActivityForResult(Intent intent, int i)
    {
        a.startActivityForResult(intent, i);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle)
    {
        a.startActivityForResult(intent, i, bundle);
    }

    public void startActivityFromChild(Activity activity, Intent intent, int i)
    {
        a.startActivityFromChild(activity, intent, i);
    }

    public void startActivityFromChild(Activity activity, Intent intent, int i, Bundle bundle)
    {
        a.startActivityFromChild(activity, intent, i, bundle);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i)
    {
        a.startActivityFromFragment(fragment, intent, i);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle)
    {
        a.startActivityFromFragment(fragment, intent, i, bundle);
    }

    public boolean startActivityIfNeeded(Intent intent, int i)
    {
        return a.startActivityIfNeeded(intent, i);
    }

    public boolean startActivityIfNeeded(Intent intent, int i, Bundle bundle)
    {
        return a.startActivityIfNeeded(intent, i, bundle);
    }

    public boolean startInstrumentation(ComponentName componentname, String s, Bundle bundle)
    {
        return a.startInstrumentation(componentname, s, bundle);
    }

    public void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k)
    {
        a.startIntentSender(intentsender, intent, i, j, k);
    }

    public void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k, Bundle bundle)
    {
        a.startIntentSender(intentsender, intent, i, j, k, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentsender, int i, Intent intent, int j, int k, int l)
    {
        a.startIntentSenderForResult(intentsender, i, intent, j, k, l);
    }

    public void startIntentSenderForResult(IntentSender intentsender, int i, Intent intent, int j, int k, int l, Bundle bundle)
    {
        a.startIntentSenderForResult(intentsender, i, intent, j, k, l, bundle);
    }

    public void startIntentSenderFromChild(Activity activity, IntentSender intentsender, int i, Intent intent, int j, int k, int l)
    {
        a.startIntentSenderFromChild(activity, intentsender, i, intent, j, k, l);
    }

    public void startIntentSenderFromChild(Activity activity, IntentSender intentsender, int i, Intent intent, int j, int k, int l, 
            Bundle bundle)
    {
        a.startIntentSenderFromChild(activity, intentsender, i, intent, j, k, l, bundle);
    }

    public void startManagingCursor(Cursor cursor)
    {
        a.startManagingCursor(cursor);
    }

    public boolean startNextMatchingActivity(Intent intent)
    {
        return a.startNextMatchingActivity(intent);
    }

    public boolean startNextMatchingActivity(Intent intent, Bundle bundle)
    {
        return a.startNextMatchingActivity(intent, bundle);
    }

    public void startSearch(String s, boolean flag, Bundle bundle, boolean flag1)
    {
        a.startSearch(s, flag, bundle, flag1);
    }

    public ComponentName startService(Intent intent)
    {
        return a.startService(intent);
    }

    public void stopManagingCursor(Cursor cursor)
    {
        a.stopManagingCursor(cursor);
    }

    public boolean stopService(Intent intent)
    {
        return a.stopService(intent);
    }

    public void takeKeyEvents(boolean flag)
    {
        a.takeKeyEvents(flag);
    }

    public String toString()
    {
        return a.toString();
    }

    public void triggerSearch(String s, Bundle bundle)
    {
        a.triggerSearch(s, bundle);
    }

    public void unbindService(ServiceConnection serviceconnection)
    {
        a.unbindService(serviceconnection);
    }

    public void unregisterComponentCallbacks(ComponentCallbacks componentcallbacks)
    {
        a.unregisterComponentCallbacks(componentcallbacks);
    }

    public void unregisterForContextMenu(View view)
    {
        a.unregisterForContextMenu(view);
    }

    public void unregisterReceiver(BroadcastReceiver broadcastreceiver)
    {
        a.unregisterReceiver(broadcastreceiver);
    }
}
