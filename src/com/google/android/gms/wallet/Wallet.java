// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.lg;
import com.google.android.gms.internal.lr;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.lv;
import com.google.android.gms.wallet.wobs.r;

// Referenced classes of package com.google.android.gms.wallet:
//            Payments, FullWalletRequest, MaskedWalletRequest, NotifyTransactionStatusRequest

public final class Wallet
{

    public static final Api API;
    public static final Payments Payments = new lr();
    public static final r ajW = new lv();
    public static final lg ajX = new lu();
    private static final com.google.android.gms.common.api.Api.c yE;
    private static final com.google.android.gms.common.api.Api.b yF;

    private Wallet()
    {
    }

    public static void changeMaskedWallet(GoogleApiClient googleapiclient, String s, String s1, int i)
    {
        Payments.changeMaskedWallet(googleapiclient, s, s1, i);
    }

    public static void checkForPreAuthorization(GoogleApiClient googleapiclient, int i)
    {
        Payments.checkForPreAuthorization(googleapiclient, i);
    }

    public static void loadFullWallet(GoogleApiClient googleapiclient, FullWalletRequest fullwalletrequest, int i)
    {
        Payments.loadFullWallet(googleapiclient, fullwalletrequest, i);
    }

    public static void loadMaskedWallet(GoogleApiClient googleapiclient, MaskedWalletRequest maskedwalletrequest, int i)
    {
        Payments.loadMaskedWallet(googleapiclient, maskedwalletrequest, i);
    }

    static com.google.android.gms.common.api.Api.c nc()
    {
        return yE;
    }

    public static void notifyTransactionStatus(GoogleApiClient googleapiclient, NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        Payments.notifyTransactionStatus(googleapiclient, notifytransactionstatusrequest);
    }

    static 
    {
        yE = new com.google.android.gms.common.api.Api.c();
        yF = new _cls1();
        API = new Api(yF, yE, new Scope[0]);
    }

    private class _cls1
        implements com.google.android.gms.common.api.Api.b
    {

        public final volatile com.google.android.gms.common.api.Api.a a(Context context, Looper looper, gz gz1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return a(context, looper, gz1, (WalletOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final ls a(Context context, Looper looper, gz gz1, WalletOptions walletoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            hn.b(context instanceof Activity, "An Activity must be used for Wallet APIs");
            Activity activity = (Activity)context;
            if (walletoptions == null)
            {
                walletoptions = new WalletOptions(null);
            }
            return new ls(activity, looper, connectioncallbacks, onconnectionfailedlistener, walletoptions.environment, gz1.getAccountName(), walletoptions.theme);
        }

        public final int getPriority()
        {
            return 0x7fffffff;
        }

        _cls1()
        {
        }

        private class WalletOptions
            implements com.google.android.gms.common.api.Api.ApiOptions.HasOptions
        {

            public final int environment;
            public final int theme;

            private WalletOptions()
            {
                class Builder
                {

                    private int ajY;
                    private int mTheme;

                    static int a(Builder builder)
                    {
                        return builder.ajY;
                    }

                    static int b(Builder builder)
                    {
                        return builder.mTheme;
                    }

                    public final WalletOptions build()
                    {
                        return new WalletOptions(this, null);
                    }

                    public final Builder setEnvironment(int i)
                    {
                        if (i == 0 || i == 2 || i == 1)
                        {
                            ajY = i;
                            return this;
                        } else
                        {
                            Locale locale = Locale.US;
                            Object aobj[] = new Object[1];
                            aobj[0] = Integer.valueOf(i);
                            throw new IllegalArgumentException(String.format(locale, "Invalid environment value %d", aobj));
                        }
                    }

                    public final Builder setTheme(int i)
                    {
                        if (i == 0 || i == 1)
                        {
                            mTheme = i;
                            return this;
                        } else
                        {
                            Locale locale = Locale.US;
                            Object aobj[] = new Object[1];
                            aobj[0] = Integer.valueOf(i);
                            throw new IllegalArgumentException(String.format(locale, "Invalid theme value %d", aobj));
                        }
                    }

                    public Builder()
                    {
                        ajY = 0;
                        mTheme = 0;
                    }
                }

                this(new Builder());
            }

            WalletOptions(_cls1 _pcls1)
            {
                this();
            }

            private WalletOptions(Builder builder)
            {
                environment = Builder.a(builder);
                theme = Builder.b(builder);
            }

            WalletOptions(Builder builder, _cls1 _pcls1)
            {
                this(builder);
            }
        }

    }

}
