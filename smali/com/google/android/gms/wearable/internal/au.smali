.class public Lcom/google/android/gms/wearable/internal/au;
.super Lcom/google/android/gms/internal/hc;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/hc",
        "<",
        "Lcom/google/android/gms/wearable/internal/ad;",
        ">;"
    }
.end annotation


# instance fields
.field private final agR:Ljava/util/concurrent/ExecutorService;

.field private final amb:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lcom/google/android/gms/wearable/DataApi$DataListener;",
            "Lcom/google/android/gms/wearable/internal/av;",
            ">;"
        }
    .end annotation
.end field

.field private final amc:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lcom/google/android/gms/wearable/MessageApi$MessageListener;",
            "Lcom/google/android/gms/wearable/internal/av;",
            ">;"
        }
    .end annotation
.end field

.field private final amd:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lcom/google/android/gms/wearable/NodeApi$NodeListener;",
            "Lcom/google/android/gms/wearable/internal/av;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;)V
    .locals 6

    const/4 v0, 0x0

    new-array v5, v0, [Ljava/lang/String;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/hc;-><init>(Landroid/content/Context;Landroid/os/Looper;Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;[Ljava/lang/String;)V

    invoke-static {}, Ljava/util/concurrent/Executors;->newCachedThreadPool()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->agR:Ljava/util/concurrent/ExecutorService;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amb:Ljava/util/HashMap;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amc:Ljava/util/HashMap;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amd:Ljava/util/HashMap;

    return-void
.end method

.method private a(Landroid/os/ParcelFileDescriptor;[B)Ljava/util/concurrent/FutureTask;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/ParcelFileDescriptor;",
            "[B)",
            "Ljava/util/concurrent/FutureTask",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/concurrent/FutureTask;

    new-instance v1, Lcom/google/android/gms/wearable/internal/au$11;

    invoke-direct {v1, p0, p1, p2}, Lcom/google/android/gms/wearable/internal/au$11;-><init>(Lcom/google/android/gms/wearable/internal/au;Landroid/os/ParcelFileDescriptor;[B)V

    invoke-direct {v0, v1}, Ljava/util/concurrent/FutureTask;-><init>(Ljava/util/concurrent/Callable;)V

    return-object v0
.end method

.method static synthetic b(Lcom/google/android/gms/wearable/internal/au;)Ljava/util/HashMap;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amb:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic c(Lcom/google/android/gms/wearable/internal/au;)Ljava/util/HashMap;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amc:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic d(Lcom/google/android/gms/wearable/internal/au;)Ljava/util/HashMap;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amd:Ljava/util/HashMap;

    return-object v0
.end method


# virtual methods
.method protected a(ILandroid/os/IBinder;Landroid/os/Bundle;)V
    .locals 7

    const/4 v1, 0x2

    const-string v0, "WearableClient"

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "WearableClient"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "onPostInitHandler: statusCode "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    if-nez p1, :cond_3

    :try_start_0
    new-instance v1, Lcom/google/android/gms/wearable/internal/au$1;

    invoke-direct {v1, p0}, Lcom/google/android/gms/wearable/internal/au$1;-><init>(Lcom/google/android/gms/wearable/internal/au;)V

    const-string v0, "WearableClient"

    const/4 v2, 0x2

    invoke-static {v0, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "WearableClient"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "onPostInitHandler: service "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1
    invoke-static {p2}, Lcom/google/android/gms/wearable/internal/ad$a;->by(Landroid/os/IBinder;)Lcom/google/android/gms/wearable/internal/ad;

    move-result-object v2

    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amb:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    const-string v4, "WearableClient"

    const/4 v5, 0x2

    invoke-static {v4, v5}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v4

    if-eqz v4, :cond_2

    const-string v4, "WearableClient"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "onPostInitHandler: adding Data listener "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_2
    new-instance v4, Lcom/google/android/gms/wearable/internal/b;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/av;

    invoke-direct {v4, v0}, Lcom/google/android/gms/wearable/internal/b;-><init>(Lcom/google/android/gms/wearable/internal/av;)V

    invoke-interface {v2, v1, v4}, Lcom/google/android/gms/wearable/internal/ad;->a(Lcom/google/android/gms/wearable/internal/ab;Lcom/google/android/gms/wearable/internal/b;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "WearableClient"

    const-string v2, "WearableClientImpl.onPostInitHandler: error while adding listener"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_3
    const-string v0, "WearableClient"

    const-string v1, "WearableClientImpl.onPostInitHandler: done"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-super {p0, p1, p2, p3}, Lcom/google/android/gms/internal/hc;->a(ILandroid/os/IBinder;Landroid/os/Bundle;)V

    return-void

    :cond_4
    :try_start_1
    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amc:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    const-string v4, "WearableClient"

    const/4 v5, 0x2

    invoke-static {v4, v5}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v4

    if-eqz v4, :cond_5

    const-string v4, "WearableClient"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "onPostInitHandler: adding Message listener "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_5
    new-instance v4, Lcom/google/android/gms/wearable/internal/b;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/av;

    invoke-direct {v4, v0}, Lcom/google/android/gms/wearable/internal/b;-><init>(Lcom/google/android/gms/wearable/internal/av;)V

    invoke-interface {v2, v1, v4}, Lcom/google/android/gms/wearable/internal/ad;->a(Lcom/google/android/gms/wearable/internal/ab;Lcom/google/android/gms/wearable/internal/b;)V

    goto :goto_1

    :cond_6
    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amd:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    const-string v4, "WearableClient"

    const/4 v5, 0x2

    invoke-static {v4, v5}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v4

    if-eqz v4, :cond_7

    const-string v4, "WearableClient"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "onPostInitHandler: adding Node listener "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_7
    new-instance v4, Lcom/google/android/gms/wearable/internal/b;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/av;

    invoke-direct {v4, v0}, Lcom/google/android/gms/wearable/internal/b;-><init>(Lcom/google/android/gms/wearable/internal/av;)V

    invoke-interface {v2, v1, v4}, Lcom/google/android/gms/wearable/internal/ad;->a(Lcom/google/android/gms/wearable/internal/ab;Lcom/google/android/gms/wearable/internal/b;)V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2
.end method

.method public a(Lcom/google/android/gms/common/api/a$d;Landroid/net/Uri;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/wearable/DataApi$DataItemResult;",
            ">;",
            "Landroid/net/Uri;",
            ")V"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v1, Lcom/google/android/gms/wearable/internal/au$12;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/wearable/internal/au$12;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/common/api/a$d;)V

    invoke-interface {v0, v1, p2}, Lcom/google/android/gms/wearable/internal/ad;->a(Lcom/google/android/gms/wearable/internal/ab;Landroid/net/Uri;)V

    return-void
.end method

.method public a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/Asset;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/wearable/DataApi$GetFdForAssetResult;",
            ">;",
            "Lcom/google/android/gms/wearable/Asset;",
            ")V"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v1, Lcom/google/android/gms/wearable/internal/au$4;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/wearable/internal/au$4;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/common/api/a$d;)V

    invoke-interface {v0, v1, p2}, Lcom/google/android/gms/wearable/internal/ad;->a(Lcom/google/android/gms/wearable/internal/ab;Lcom/google/android/gms/wearable/Asset;)V

    return-void
.end method

.method public a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/DataApi$DataListener;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;",
            "Lcom/google/android/gms/wearable/DataApi$DataListener;",
            ")V"
        }
    .end annotation

    iget-object v1, p0, Lcom/google/android/gms/wearable/internal/au;->amb:Ljava/util/HashMap;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amb:Ljava/util/HashMap;

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ac;

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const/16 v1, 0xfa2

    invoke-direct {v0, v1}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    invoke-interface {p1, v0}, Lcom/google/android/gms/common/api/a$d;->a(Ljava/lang/Object;)V

    :goto_0
    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    :cond_0
    invoke-virtual {p0, p1, v0}, Lcom/google/android/gms/wearable/internal/au;->a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/internal/ac;)V

    goto :goto_0
.end method

.method public a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/DataApi$DataListener;[Landroid/content/IntentFilter;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;",
            "Lcom/google/android/gms/wearable/DataApi$DataListener;",
            "[",
            "Landroid/content/IntentFilter;",
            ")V"
        }
    .end annotation

    invoke-static {p2, p3}, Lcom/google/android/gms/wearable/internal/av;->a(Lcom/google/android/gms/wearable/DataApi$DataListener;[Landroid/content/IntentFilter;)Lcom/google/android/gms/wearable/internal/av;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/wearable/internal/au;->amb:Ljava/util/HashMap;

    monitor-enter v2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amb:Ljava/util/HashMap;

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const/16 v1, 0xfa1

    invoke-direct {v0, v1}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    invoke-interface {p1, v0}, Lcom/google/android/gms/common/api/a$d;->a(Ljava/lang/Object;)V

    monitor-exit v2

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amb:Ljava/util/HashMap;

    invoke-virtual {v0, p2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v2, Lcom/google/android/gms/wearable/internal/au$7;

    invoke-direct {v2, p0, p2, p1}, Lcom/google/android/gms/wearable/internal/au$7;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/wearable/DataApi$DataListener;Lcom/google/android/gms/common/api/a$d;)V

    new-instance v3, Lcom/google/android/gms/wearable/internal/b;

    invoke-direct {v3, v1}, Lcom/google/android/gms/wearable/internal/b;-><init>(Lcom/google/android/gms/wearable/internal/av;)V

    invoke-interface {v0, v2, v3}, Lcom/google/android/gms/wearable/internal/ad;->a(Lcom/google/android/gms/wearable/internal/ab;Lcom/google/android/gms/wearable/internal/b;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2

    throw v0
.end method

.method public a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/DataItemAsset;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/wearable/DataApi$GetFdForAssetResult;",
            ">;",
            "Lcom/google/android/gms/wearable/DataItemAsset;",
            ")V"
        }
    .end annotation

    invoke-interface {p2}, Lcom/google/android/gms/wearable/DataItemAsset;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/wearable/Asset;->createFromRef(Ljava/lang/String;)Lcom/google/android/gms/wearable/Asset;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/google/android/gms/wearable/internal/au;->a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/Asset;)V

    return-void
.end method

.method public a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/MessageApi$MessageListener;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;",
            "Lcom/google/android/gms/wearable/MessageApi$MessageListener;",
            ")V"
        }
    .end annotation

    iget-object v1, p0, Lcom/google/android/gms/wearable/internal/au;->amc:Ljava/util/HashMap;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amc:Ljava/util/HashMap;

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ac;

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const/16 v2, 0xfa2

    invoke-direct {v0, v2}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    invoke-interface {p1, v0}, Lcom/google/android/gms/common/api/a$d;->a(Ljava/lang/Object;)V

    :goto_0
    monitor-exit v1

    return-void

    :cond_0
    invoke-virtual {p0, p1, v0}, Lcom/google/android/gms/wearable/internal/au;->a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/internal/ac;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/MessageApi$MessageListener;[Landroid/content/IntentFilter;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;",
            "Lcom/google/android/gms/wearable/MessageApi$MessageListener;",
            "[",
            "Landroid/content/IntentFilter;",
            ")V"
        }
    .end annotation

    invoke-static {p2, p3}, Lcom/google/android/gms/wearable/internal/av;->a(Lcom/google/android/gms/wearable/MessageApi$MessageListener;[Landroid/content/IntentFilter;)Lcom/google/android/gms/wearable/internal/av;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/wearable/internal/au;->amc:Ljava/util/HashMap;

    monitor-enter v2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amc:Ljava/util/HashMap;

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const/16 v1, 0xfa1

    invoke-direct {v0, v1}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    invoke-interface {p1, v0}, Lcom/google/android/gms/common/api/a$d;->a(Ljava/lang/Object;)V

    monitor-exit v2

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amc:Ljava/util/HashMap;

    invoke-virtual {v0, p2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v2, Lcom/google/android/gms/wearable/internal/au$8;

    invoke-direct {v2, p0, p2, p1}, Lcom/google/android/gms/wearable/internal/au$8;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/wearable/MessageApi$MessageListener;Lcom/google/android/gms/common/api/a$d;)V

    new-instance v3, Lcom/google/android/gms/wearable/internal/b;

    invoke-direct {v3, v1}, Lcom/google/android/gms/wearable/internal/b;-><init>(Lcom/google/android/gms/wearable/internal/av;)V

    invoke-interface {v0, v2, v3}, Lcom/google/android/gms/wearable/internal/ad;->a(Lcom/google/android/gms/wearable/internal/ab;Lcom/google/android/gms/wearable/internal/b;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2

    throw v0
.end method

.method public a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/NodeApi$NodeListener;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;",
            "Lcom/google/android/gms/wearable/NodeApi$NodeListener;",
            ")V"
        }
    .end annotation

    invoke-static {p2}, Lcom/google/android/gms/wearable/internal/av;->a(Lcom/google/android/gms/wearable/NodeApi$NodeListener;)Lcom/google/android/gms/wearable/internal/av;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/wearable/internal/au;->amd:Ljava/util/HashMap;

    monitor-enter v2

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amd:Ljava/util/HashMap;

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const/16 v1, 0xfa1

    invoke-direct {v0, v1}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    invoke-interface {p1, v0}, Lcom/google/android/gms/common/api/a$d;->a(Ljava/lang/Object;)V

    monitor-exit v2

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amd:Ljava/util/HashMap;

    invoke-virtual {v0, p2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v2, Lcom/google/android/gms/wearable/internal/au$9;

    invoke-direct {v2, p0, p2, p1}, Lcom/google/android/gms/wearable/internal/au$9;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/wearable/NodeApi$NodeListener;Lcom/google/android/gms/common/api/a$d;)V

    new-instance v3, Lcom/google/android/gms/wearable/internal/b;

    invoke-direct {v3, v1}, Lcom/google/android/gms/wearable/internal/b;-><init>(Lcom/google/android/gms/wearable/internal/av;)V

    invoke-interface {v0, v2, v3}, Lcom/google/android/gms/wearable/internal/ad;->a(Lcom/google/android/gms/wearable/internal/ab;Lcom/google/android/gms/wearable/internal/b;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2

    throw v0
.end method

.method public a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/PutDataRequest;)V
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/wearable/DataApi$DataItemResult;",
            ">;",
            "Lcom/google/android/gms/wearable/PutDataRequest;",
            ")V"
        }
    .end annotation

    const/4 v10, 0x1

    const/4 v9, 0x0

    invoke-virtual {p2}, Lcom/google/android/gms/wearable/PutDataRequest;->getAssets()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/Asset;

    invoke-virtual {v0}, Lcom/google/android/gms/wearable/Asset;->getData()[B

    move-result-object v2

    if-nez v2, :cond_0

    invoke-virtual {v0}, Lcom/google/android/gms/wearable/Asset;->getDigest()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_0

    invoke-virtual {v0}, Lcom/google/android/gms/wearable/Asset;->getFd()Landroid/os/ParcelFileDescriptor;

    move-result-object v2

    if-nez v2, :cond_0

    invoke-virtual {v0}, Lcom/google/android/gms/wearable/Asset;->getUri()Landroid/net/Uri;

    move-result-object v2

    if-nez v2, :cond_0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Put for "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2}, Lcom/google/android/gms/wearable/PutDataRequest;->getUri()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " contains invalid asset: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1
    invoke-virtual {p2}, Lcom/google/android/gms/wearable/PutDataRequest;->getUri()Landroid/net/Uri;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/wearable/PutDataRequest;->j(Landroid/net/Uri;)Lcom/google/android/gms/wearable/PutDataRequest;

    move-result-object v2

    invoke-virtual {p2}, Lcom/google/android/gms/wearable/PutDataRequest;->getData()[B

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/google/android/gms/wearable/PutDataRequest;->setData([B)Lcom/google/android/gms/wearable/PutDataRequest;

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p2}, Lcom/google/android/gms/wearable/PutDataRequest;->getAssets()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/wearable/Asset;

    invoke-virtual {v1}, Lcom/google/android/gms/wearable/Asset;->getData()[B

    move-result-object v5

    if-nez v5, :cond_2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/Asset;

    invoke-virtual {v2, v1, v0}, Lcom/google/android/gms/wearable/PutDataRequest;->putAsset(Ljava/lang/String;Lcom/google/android/gms/wearable/Asset;)Lcom/google/android/gms/wearable/PutDataRequest;

    goto :goto_0

    :cond_2
    :try_start_0
    invoke-static {}, Landroid/os/ParcelFileDescriptor;->createPipe()[Landroid/os/ParcelFileDescriptor;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    const-string v6, "WearableClient"

    const/4 v7, 0x3

    invoke-static {v6, v7}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v6

    if-eqz v6, :cond_3

    const-string v6, "WearableClient"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "processAssets: replacing data with FD in asset: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " read:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    aget-object v8, v5, v9

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " write:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    aget-object v8, v5, v10

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_3
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    aget-object v6, v5, v9

    invoke-static {v6}, Lcom/google/android/gms/wearable/Asset;->createFromFd(Landroid/os/ParcelFileDescriptor;)Lcom/google/android/gms/wearable/Asset;

    move-result-object v6

    invoke-virtual {v2, v0, v6}, Lcom/google/android/gms/wearable/PutDataRequest;->putAsset(Ljava/lang/String;Lcom/google/android/gms/wearable/Asset;)Lcom/google/android/gms/wearable/PutDataRequest;

    aget-object v0, v5, v10

    invoke-virtual {v1}, Lcom/google/android/gms/wearable/Asset;->getData()[B

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/google/android/gms/wearable/internal/au;->a(Landroid/os/ParcelFileDescriptor;[B)Ljava/util/concurrent/FutureTask;

    move-result-object v0

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v1, p0, Lcom/google/android/gms/wearable/internal/au;->agR:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v1, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    goto/16 :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Unable to create ParcelFileDescriptor for asset in request: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    :cond_4
    :try_start_1
    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v1, Lcom/google/android/gms/wearable/internal/au$a;

    invoke-direct {v1, p1, v3}, Lcom/google/android/gms/wearable/internal/au$a;-><init>(Lcom/google/android/gms/common/api/a$d;Ljava/util/List;)V

    invoke-interface {v0, v1, v2}, Lcom/google/android/gms/wearable/internal/ad;->a(Lcom/google/android/gms/wearable/internal/ab;Lcom/google/android/gms/wearable/PutDataRequest;)V
    :try_end_1
    .catch Ljava/lang/NullPointerException; {:try_start_1 .. :try_end_1} :catch_1

    return-void

    :catch_1
    move-exception v0

    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Unable to putDataItem: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/internal/ac;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;",
            "Lcom/google/android/gms/wearable/internal/ac;",
            ")V"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v1, Lcom/google/android/gms/wearable/internal/au$10;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/wearable/internal/au$10;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/common/api/a$d;)V

    new-instance v2, Lcom/google/android/gms/wearable/internal/ao;

    invoke-direct {v2, p2}, Lcom/google/android/gms/wearable/internal/ao;-><init>(Lcom/google/android/gms/wearable/internal/ac;)V

    invoke-interface {v0, v1, v2}, Lcom/google/android/gms/wearable/internal/ad;->a(Lcom/google/android/gms/wearable/internal/ab;Lcom/google/android/gms/wearable/internal/ao;)V

    return-void
.end method

.method public a(Lcom/google/android/gms/common/api/a$d;Ljava/lang/String;Ljava/lang/String;[B)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/wearable/MessageApi$SendMessageResult;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "[B)V"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v1, Lcom/google/android/gms/wearable/internal/au$3;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/wearable/internal/au$3;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/common/api/a$d;)V

    invoke-interface {v0, v1, p2, p3, p4}, Lcom/google/android/gms/wearable/internal/ad;->a(Lcom/google/android/gms/wearable/internal/ab;Ljava/lang/String;Ljava/lang/String;[B)V

    return-void
.end method

.method protected a(Lcom/google/android/gms/internal/hj;Lcom/google/android/gms/internal/hc$e;)V
    .locals 2

    const v0, 0x4d7808

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, p2, v0, v1}, Lcom/google/android/gms/internal/hj;->e(Lcom/google/android/gms/internal/hi;ILjava/lang/String;)V

    return-void
.end method

.method public b(Lcom/google/android/gms/common/api/a$d;Landroid/net/Uri;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/wearable/DataItemBuffer;",
            ">;",
            "Landroid/net/Uri;",
            ")V"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v1, Lcom/google/android/gms/wearable/internal/au$14;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/wearable/internal/au$14;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/common/api/a$d;)V

    invoke-interface {v0, v1, p2}, Lcom/google/android/gms/wearable/internal/ad;->b(Lcom/google/android/gms/wearable/internal/ab;Landroid/net/Uri;)V

    return-void
.end method

.method public b(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/NodeApi$NodeListener;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/common/api/Status;",
            ">;",
            "Lcom/google/android/gms/wearable/NodeApi$NodeListener;",
            ")V"
        }
    .end annotation

    iget-object v1, p0, Lcom/google/android/gms/wearable/internal/au;->amd:Ljava/util/HashMap;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amd:Ljava/util/HashMap;

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ac;

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const/16 v2, 0xfa2

    invoke-direct {v0, v2}, Lcom/google/android/gms/common/api/Status;-><init>(I)V

    invoke-interface {p1, v0}, Lcom/google/android/gms/common/api/a$d;->a(Ljava/lang/Object;)V

    :goto_0
    monitor-exit v1

    return-void

    :cond_0
    invoke-virtual {p0, p1, v0}, Lcom/google/android/gms/wearable/internal/au;->a(Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/wearable/internal/ac;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method protected bp()Ljava/lang/String;
    .locals 1

    const-string v0, "com.google.android.gms.wearable.BIND"

    return-object v0
.end method

.method protected bq()Ljava/lang/String;
    .locals 1

    const-string v0, "com.google.android.gms.wearable.internal.IWearableService"

    return-object v0
.end method

.method protected bz(Landroid/os/IBinder;)Lcom/google/android/gms/wearable/internal/ad;
    .locals 1

    invoke-static {p1}, Lcom/google/android/gms/wearable/internal/ad$a;->by(Landroid/os/IBinder;)Lcom/google/android/gms/wearable/internal/ad;

    move-result-object v0

    return-object v0
.end method

.method public c(Lcom/google/android/gms/common/api/a$d;Landroid/net/Uri;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/wearable/DataApi$DeleteDataItemsResult;",
            ">;",
            "Landroid/net/Uri;",
            ")V"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v1, Lcom/google/android/gms/wearable/internal/au$2;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/wearable/internal/au$2;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/common/api/a$d;)V

    invoke-interface {v0, v1, p2}, Lcom/google/android/gms/wearable/internal/ad;->c(Lcom/google/android/gms/wearable/internal/ab;Landroid/net/Uri;)V

    return-void
.end method

.method public disconnect()V
    .locals 1

    invoke-super {p0}, Lcom/google/android/gms/internal/hc;->disconnect()V

    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amb:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amc:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    iget-object v0, p0, Lcom/google/android/gms/wearable/internal/au;->amd:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    return-void
.end method

.method public o(Lcom/google/android/gms/common/api/a$d;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/wearable/DataItemBuffer;",
            ">;)V"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v1, Lcom/google/android/gms/wearable/internal/au$13;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/wearable/internal/au$13;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/common/api/a$d;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/wearable/internal/ad;->d(Lcom/google/android/gms/wearable/internal/ab;)V

    return-void
.end method

.method public p(Lcom/google/android/gms/common/api/a$d;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/wearable/NodeApi$GetLocalNodeResult;",
            ">;)V"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v1, Lcom/google/android/gms/wearable/internal/au$5;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/wearable/internal/au$5;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/common/api/a$d;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/wearable/internal/ad;->e(Lcom/google/android/gms/wearable/internal/ab;)V

    return-void
.end method

.method public q(Lcom/google/android/gms/common/api/a$d;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/a$d",
            "<",
            "Lcom/google/android/gms/wearable/NodeApi$GetConnectedNodesResult;",
            ">;)V"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/google/android/gms/wearable/internal/au;->fo()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/wearable/internal/ad;

    new-instance v1, Lcom/google/android/gms/wearable/internal/au$6;

    invoke-direct {v1, p0, p1}, Lcom/google/android/gms/wearable/internal/au$6;-><init>(Lcom/google/android/gms/wearable/internal/au;Lcom/google/android/gms/common/api/a$d;)V

    invoke-interface {v0, v1}, Lcom/google/android/gms/wearable/internal/ad;->f(Lcom/google/android/gms/wearable/internal/ab;)V

    return-void
.end method

.method protected synthetic x(Landroid/os/IBinder;)Landroid/os/IInterface;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/wearable/internal/au;->bz(Landroid/os/IBinder;)Lcom/google/android/gms/wearable/internal/ad;

    move-result-object v0

    return-object v0
.end method
