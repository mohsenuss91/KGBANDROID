.class final Lcom/millennialmedia/android/MMSDK$2;
.super Lcom/millennialmedia/android/AdCache$Iterator;


# instance fields
.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 0

    iput-object p1, p0, Lcom/millennialmedia/android/MMSDK$2;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Lcom/millennialmedia/android/AdCache$Iterator;-><init>()V

    return-void
.end method


# virtual methods
.method final callback(Lcom/millennialmedia/android/CachedAd;)Z
    .locals 5

    const/4 v4, 0x1

    const-string v1, "%s %s is %son disk. Is %sexpired."

    const/4 v0, 0x4

    new-array v2, v0, [Ljava/lang/Object;

    const/4 v0, 0x0

    invoke-virtual {p1}, Lcom/millennialmedia/android/CachedAd;->getTypeString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v0

    invoke-virtual {p1}, Lcom/millennialmedia/android/CachedAd;->getId()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v4

    const/4 v3, 0x2

    iget-object v0, p0, Lcom/millennialmedia/android/MMSDK$2;->val$context:Landroid/content/Context;

    invoke-virtual {p1, v0}, Lcom/millennialmedia/android/CachedAd;->isOnDisk(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, ""

    :goto_0
    aput-object v0, v2, v3

    const/4 v3, 0x3

    invoke-virtual {p1}, Lcom/millennialmedia/android/CachedAd;->isExpired()Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, ""

    :goto_1
    aput-object v0, v2, v3

    invoke-static {v1, v2}, Lcom/millennialmedia/android/MMSDK$Log;->i(Ljava/lang/String;[Ljava/lang/Object;)V

    return v4

    :cond_0
    const-string v0, "not "

    goto :goto_0

    :cond_1
    const-string v0, "not "

    goto :goto_1
.end method
