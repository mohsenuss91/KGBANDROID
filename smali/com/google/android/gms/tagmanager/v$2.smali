.class Lcom/google/android/gms/tagmanager/v$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic afm:Lcom/google/android/gms/tagmanager/v;

.field final synthetic afn:Lcom/google/android/gms/tagmanager/DataLayer$c$a;


# direct methods
.method constructor <init>(Lcom/google/android/gms/tagmanager/v;Lcom/google/android/gms/tagmanager/DataLayer$c$a;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/tagmanager/v$2;->afm:Lcom/google/android/gms/tagmanager/v;

    iput-object p2, p0, Lcom/google/android/gms/tagmanager/v$2;->afn:Lcom/google/android/gms/tagmanager/DataLayer$c$a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/tagmanager/v$2;->afn:Lcom/google/android/gms/tagmanager/DataLayer$c$a;

    iget-object v1, p0, Lcom/google/android/gms/tagmanager/v$2;->afm:Lcom/google/android/gms/tagmanager/v;

    invoke-static {v1}, Lcom/google/android/gms/tagmanager/v;->a(Lcom/google/android/gms/tagmanager/v;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/google/android/gms/tagmanager/DataLayer$c$a;->d(Ljava/util/List;)V

    return-void
.end method
