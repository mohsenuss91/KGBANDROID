// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.net.Uri;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.people.Person;
import java.util.Collection;

public class PlusClient
    implements GooglePlayServicesClient
{

    final e abq;

    PlusClient(e e1)
    {
        abq = e1;
    }

    public void clearDefaultAccount()
    {
        abq.clearDefaultAccount();
    }

    public void connect()
    {
        abq.connect();
    }

    public void disconnect()
    {
        abq.disconnect();
    }

    public String getAccountName()
    {
        return abq.getAccountName();
    }

    public Person getCurrentPerson()
    {
        return abq.getCurrentPerson();
    }

    public boolean isConnected()
    {
        return abq.isConnected();
    }

    public boolean isConnecting()
    {
        return abq.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        return abq.isConnectionCallbacksRegistered(connectioncallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return abq.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    e jN()
    {
        return abq;
    }

    public void loadMoments(OnMomentsLoadedListener onmomentsloadedlistener)
    {
        abq.k(new _cls1(onmomentsloadedlistener));
    }

    public void loadMoments(OnMomentsLoadedListener onmomentsloadedlistener, int i, String s, Uri uri, String s1, String s2)
    {
        abq.a(new _cls2(onmomentsloadedlistener), i, s, uri, s1, s2);
    }

    public void loadPeople(OnPeopleLoadedListener onpeopleloadedlistener, Collection collection)
    {
        abq.a(new _cls5(onpeopleloadedlistener), collection);
    }

    public transient void loadPeople(OnPeopleLoadedListener onpeopleloadedlistener, String as[])
    {
        abq.d(new _cls6(onpeopleloadedlistener), as);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener onpeopleloadedlistener, int i, String s)
    {
        abq.a(new _cls3(onpeopleloadedlistener), i, s);
    }

    public void loadVisiblePeople(OnPeopleLoadedListener onpeopleloadedlistener, String s)
    {
        abq.r(new _cls4(onpeopleloadedlistener), s);
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        abq.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        abq.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void removeMoment(String s)
    {
        abq.removeMoment(s);
    }

    public void revokeAccessAndDisconnect(OnAccessRevokedListener onaccessrevokedlistener)
    {
        abq.m(new _cls7(onaccessrevokedlistener));
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        abq.unregisterConnectionCallbacks(connectioncallbacks);
    }

    public void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        abq.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }

    public void writeMoment(Moment moment)
    {
        abq.a(null, moment);
    }

    private class _cls1
        implements com.google.android.gms.common.api.a.d
    {

        final OnMomentsLoadedListener abr;
        final PlusClient abs;

        public void a(Moments.LoadMomentsResult loadmomentsresult)
        {
            abr.onMomentsLoaded(loadmomentsresult.getStatus().eM(), loadmomentsresult.getMomentBuffer(), loadmomentsresult.getNextPageToken(), loadmomentsresult.getUpdated());
        }

        public volatile void a(Object obj)
        {
            a((Moments.LoadMomentsResult)obj);
        }

        _cls1(OnMomentsLoadedListener onmomentsloadedlistener)
        {
            abs = PlusClient.this;
            abr = onmomentsloadedlistener;
            super();
        }

        private class OnMomentsLoadedListener
        {

            public abstract void onMomentsLoaded(ConnectionResult connectionresult, MomentBuffer momentbuffer, String s, String s1);
        }

    }


    private class _cls2
        implements com.google.android.gms.common.api.a.d
    {

        final OnMomentsLoadedListener abr;
        final PlusClient abs;

        public void a(Moments.LoadMomentsResult loadmomentsresult)
        {
            abr.onMomentsLoaded(loadmomentsresult.getStatus().eM(), loadmomentsresult.getMomentBuffer(), loadmomentsresult.getNextPageToken(), loadmomentsresult.getUpdated());
        }

        public volatile void a(Object obj)
        {
            a((Moments.LoadMomentsResult)obj);
        }

        _cls2(OnMomentsLoadedListener onmomentsloadedlistener)
        {
            abs = PlusClient.this;
            abr = onmomentsloadedlistener;
            super();
        }
    }


    private class _cls5
        implements com.google.android.gms.common.api.a.d
    {

        final PlusClient abs;
        final OnPeopleLoadedListener abt;

        public void a(People.LoadPeopleResult loadpeopleresult)
        {
            abt.onPeopleLoaded(loadpeopleresult.getStatus().eM(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
        }

        public volatile void a(Object obj)
        {
            a((People.LoadPeopleResult)obj);
        }

        _cls5(OnPeopleLoadedListener onpeopleloadedlistener)
        {
            abs = PlusClient.this;
            abt = onpeopleloadedlistener;
            super();
        }

        private class OnPeopleLoadedListener
        {

            public abstract void onPeopleLoaded(ConnectionResult connectionresult, PersonBuffer personbuffer, String s);
        }

    }


    private class _cls6
        implements com.google.android.gms.common.api.a.d
    {

        final PlusClient abs;
        final OnPeopleLoadedListener abt;

        public void a(People.LoadPeopleResult loadpeopleresult)
        {
            abt.onPeopleLoaded(loadpeopleresult.getStatus().eM(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
        }

        public volatile void a(Object obj)
        {
            a((People.LoadPeopleResult)obj);
        }

        _cls6(OnPeopleLoadedListener onpeopleloadedlistener)
        {
            abs = PlusClient.this;
            abt = onpeopleloadedlistener;
            super();
        }
    }


    private class _cls3
        implements com.google.android.gms.common.api.a.d
    {

        final PlusClient abs;
        final OnPeopleLoadedListener abt;

        public void a(People.LoadPeopleResult loadpeopleresult)
        {
            abt.onPeopleLoaded(loadpeopleresult.getStatus().eM(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
        }

        public volatile void a(Object obj)
        {
            a((People.LoadPeopleResult)obj);
        }

        _cls3(OnPeopleLoadedListener onpeopleloadedlistener)
        {
            abs = PlusClient.this;
            abt = onpeopleloadedlistener;
            super();
        }
    }


    private class _cls4
        implements com.google.android.gms.common.api.a.d
    {

        final PlusClient abs;
        final OnPeopleLoadedListener abt;

        public void a(People.LoadPeopleResult loadpeopleresult)
        {
            abt.onPeopleLoaded(loadpeopleresult.getStatus().eM(), loadpeopleresult.getPersonBuffer(), loadpeopleresult.getNextPageToken());
        }

        public volatile void a(Object obj)
        {
            a((People.LoadPeopleResult)obj);
        }

        _cls4(OnPeopleLoadedListener onpeopleloadedlistener)
        {
            abs = PlusClient.this;
            abt = onpeopleloadedlistener;
            super();
        }
    }


    private class _cls7
        implements com.google.android.gms.common.api.a.d
    {

        final PlusClient abs;
        final OnAccessRevokedListener abu;

        public void a(Object obj)
        {
            al((Status)obj);
        }

        public void al(Status status)
        {
            abu.onAccessRevoked(status.getStatus().eM());
        }

        _cls7(OnAccessRevokedListener onaccessrevokedlistener)
        {
            abs = PlusClient.this;
            abu = onaccessrevokedlistener;
            super();
        }

        private class OnAccessRevokedListener
        {

            public abstract void onAccessRevoked(ConnectionResult connectionresult);
        }

    }

}
