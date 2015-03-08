// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.wrapper;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.os.Bundle;
import com.appyet.a.b;
import com.appyet.a.c;
import com.appyet.a.d;
import com.appyet.a.f;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.bl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class AccountManagerWrapper
{

    private AccountManager mAccountManager;
    private ApplicationContext mApplicationContext;

    public AccountManagerWrapper(ApplicationContext applicationcontext)
    {
        mApplicationContext = applicationcontext;
        mAccountManager = AccountManager.get(mApplicationContext);
    }

    public static void checkAvailable()
    {
    }

    public boolean Authenticate(Activity activity, String s, c c1)
    {
        int j;
        Account account;
        Account aaccount[];
        int i;
        Bundle bundle;
        d d1;
        BasicNameValuePair basicnamevaluepair;
        f f1;
        try
        {
            aaccount = mAccountManager.getAccountsByType("com.google");
            i = aaccount.length;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return false;
        }
        j = 0;
_L7:
        if (j >= i) goto _L2; else goto _L1
_L1:
        account = aaccount[j];
        if (account.type == null || !account.type.equals("com.google") || account.name == null || !account.name.equals(s)) goto _L4; else goto _L3
_L5:
        bundle = (Bundle)mAccountManager.getAuthToken(account, "reader", null, activity, null, null).getResult();
        c1.a = bundle.get("authtoken").toString();
        d1 = new d();
        basicnamevaluepair = new BasicNameValuePair("Authorization", (new StringBuilder("GoogleLogin auth=")).append((String)c1.a).toString());
        d1.g.add(basicnamevaluepair);
        d1.a = "http://www.google.com/reader/api/0/token";
        f1 = mApplicationContext.g.a(d1);
        bl.b(f1);
        if (f1.f == 401 || f1.f == 403)
        {
            mAccountManager.invalidateAuthToken("com.google", (String)c1.a);
            c1.a = bundle.get("authtoken").toString();
        }
        return true;
_L2:
        account = null;
_L3:
        if (account == null)
        {
            return false;
        }
        if (true) goto _L5; else goto _L4
_L4:
        j++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public List getGoogleAccounts()
    {
        AccountManager accountmanager = AccountManager.get(mApplicationContext);
        ArrayList arraylist = new ArrayList();
        Collections.addAll(arraylist, accountmanager.getAccounts());
        ArrayList arraylist1 = new ArrayList();
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Account account = (Account)iterator.next();
            if (account.type != null && account.type.equals("com.google") && account.name != null && (account.name.contains("@gmail.com") || account.name.contains("@googlemail.com")))
            {
                b b1 = new b();
                b1.a = account.name;
                arraylist1.add(b1);
            }
        } while (true);
        return arraylist1;
    }

    static 
    {
        try
        {
            Class.forName("android.accounts.AccountManager");
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
    }
}
