.class Lcom/google/android/gms/tagmanager/cs;
.super Ljava/lang/Object;


# static fields
.field private static final ahj:Lcom/google/android/gms/tagmanager/by;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/tagmanager/by",
            "<",
            "Lcom/google/android/gms/internal/d$a;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final aer:Lcom/google/android/gms/tagmanager/DataLayer;

.field private final ahk:Lcom/google/android/gms/tagmanager/cq$c;

.field private final ahl:Lcom/google/android/gms/tagmanager/ag;

.field private final ahm:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/tagmanager/aj;",
            ">;"
        }
    .end annotation
.end field

.field private final ahn:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/tagmanager/aj;",
            ">;"
        }
    .end annotation
.end field

.field private final aho:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/tagmanager/aj;",
            ">;"
        }
    .end annotation
.end field

.field private final ahp:Lcom/google/android/gms/tagmanager/k;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/tagmanager/k",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$a;",
            "Lcom/google/android/gms/tagmanager/by",
            "<",
            "Lcom/google/android/gms/internal/d$a;",
            ">;>;"
        }
    .end annotation
.end field

.field private final ahq:Lcom/google/android/gms/tagmanager/k;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/tagmanager/k",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/tagmanager/cs$b;",
            ">;"
        }
    .end annotation
.end field

.field private final ahr:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$e;",
            ">;"
        }
    .end annotation
.end field

.field private final ahs:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/tagmanager/cs$c;",
            ">;"
        }
    .end annotation
.end field

.field private volatile aht:Ljava/lang/String;

.field private ahu:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    new-instance v0, Lcom/google/android/gms/tagmanager/by;

    invoke-static {}, Lcom/google/android/gms/tagmanager/dh;->mY()Lcom/google/android/gms/internal/d$a;

    move-result-object v1

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    sput-object v0, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/tagmanager/cq$c;Lcom/google/android/gms/tagmanager/DataLayer;Lcom/google/android/gms/tagmanager/s$a;Lcom/google/android/gms/tagmanager/s$a;Lcom/google/android/gms/tagmanager/ag;)V
    .locals 8

    const/high16 v2, 0x10

    const/4 v4, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-nez p2, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "resource cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p2, p0, Lcom/google/android/gms/tagmanager/cs;->ahk:Lcom/google/android/gms/tagmanager/cq$c;

    new-instance v0, Ljava/util/HashSet;

    invoke-virtual {p2}, Lcom/google/android/gms/tagmanager/cq$c;->mn()Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahr:Ljava/util/Set;

    iput-object p3, p0, Lcom/google/android/gms/tagmanager/cs;->aer:Lcom/google/android/gms/tagmanager/DataLayer;

    iput-object p6, p0, Lcom/google/android/gms/tagmanager/cs;->ahl:Lcom/google/android/gms/tagmanager/ag;

    new-instance v0, Lcom/google/android/gms/tagmanager/cs$1;

    invoke-direct {v0, p0}, Lcom/google/android/gms/tagmanager/cs$1;-><init>(Lcom/google/android/gms/tagmanager/cs;)V

    new-instance v1, Lcom/google/android/gms/tagmanager/l;

    invoke-direct {v1}, Lcom/google/android/gms/tagmanager/l;-><init>()V

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gms/tagmanager/l;->a(ILcom/google/android/gms/tagmanager/l$a;)Lcom/google/android/gms/tagmanager/k;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahp:Lcom/google/android/gms/tagmanager/k;

    new-instance v0, Lcom/google/android/gms/tagmanager/cs$2;

    invoke-direct {v0, p0}, Lcom/google/android/gms/tagmanager/cs$2;-><init>(Lcom/google/android/gms/tagmanager/cs;)V

    new-instance v1, Lcom/google/android/gms/tagmanager/l;

    invoke-direct {v1}, Lcom/google/android/gms/tagmanager/l;-><init>()V

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gms/tagmanager/l;->a(ILcom/google/android/gms/tagmanager/l$a;)Lcom/google/android/gms/tagmanager/k;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahq:Lcom/google/android/gms/tagmanager/k;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahm:Ljava/util/Map;

    new-instance v0, Lcom/google/android/gms/tagmanager/i;

    invoke-direct {v0, p1}, Lcom/google/android/gms/tagmanager/i;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->b(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/s;

    invoke-direct {v0, p5}, Lcom/google/android/gms/tagmanager/s;-><init>(Lcom/google/android/gms/tagmanager/s$a;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->b(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/w;

    invoke-direct {v0, p3}, Lcom/google/android/gms/tagmanager/w;-><init>(Lcom/google/android/gms/tagmanager/DataLayer;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->b(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/di;

    invoke-direct {v0, p1, p3}, Lcom/google/android/gms/tagmanager/di;-><init>(Landroid/content/Context;Lcom/google/android/gms/tagmanager/DataLayer;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->b(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahn:Ljava/util/Map;

    new-instance v0, Lcom/google/android/gms/tagmanager/q;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/q;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->c(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/ad;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/ad;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->c(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/ae;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/ae;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->c(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/al;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/al;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->c(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/am;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/am;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->c(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/bd;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/bd;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->c(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/be;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/be;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->c(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/ch;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/ch;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->c(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/db;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/db;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->c(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->aho:Ljava/util/Map;

    new-instance v0, Lcom/google/android/gms/tagmanager/b;

    invoke-direct {v0, p1}, Lcom/google/android/gms/tagmanager/b;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/c;

    invoke-direct {v0, p1}, Lcom/google/android/gms/tagmanager/c;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/e;

    invoke-direct {v0, p1}, Lcom/google/android/gms/tagmanager/e;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/f;

    invoke-direct {v0, p1}, Lcom/google/android/gms/tagmanager/f;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/g;

    invoke-direct {v0, p1}, Lcom/google/android/gms/tagmanager/g;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/h;

    invoke-direct {v0, p1}, Lcom/google/android/gms/tagmanager/h;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/m;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/m;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/p;

    iget-object v1, p0, Lcom/google/android/gms/tagmanager/cs;->ahk:Lcom/google/android/gms/tagmanager/cq$c;

    invoke-virtual {v1}, Lcom/google/android/gms/tagmanager/cq$c;->getVersion()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/tagmanager/p;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/s;

    invoke-direct {v0, p4}, Lcom/google/android/gms/tagmanager/s;-><init>(Lcom/google/android/gms/tagmanager/s$a;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/u;

    invoke-direct {v0, p3}, Lcom/google/android/gms/tagmanager/u;-><init>(Lcom/google/android/gms/tagmanager/DataLayer;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/z;

    invoke-direct {v0, p1}, Lcom/google/android/gms/tagmanager/z;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/aa;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/aa;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/ac;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/ac;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/ah;

    invoke-direct {v0, p0}, Lcom/google/android/gms/tagmanager/ah;-><init>(Lcom/google/android/gms/tagmanager/cs;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/an;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/an;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/ao;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/ao;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/ax;

    invoke-direct {v0, p1}, Lcom/google/android/gms/tagmanager/ax;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/az;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/az;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/bc;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/bc;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/bk;

    invoke-direct {v0, p1}, Lcom/google/android/gms/tagmanager/bk;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/bz;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/bz;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/cb;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/cb;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/ce;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/ce;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/cg;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/cg;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/ci;

    invoke-direct {v0, p1}, Lcom/google/android/gms/tagmanager/ci;-><init>(Landroid/content/Context;)V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/ct;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/ct;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/cu;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/cu;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/dd;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/dd;-><init>()V

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/aj;)V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahs:Ljava/util/Map;

    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahr:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    move-object v2, v0

    check-cast v2, Lcom/google/android/gms/tagmanager/cq$e;

    invoke-interface {p6}, Lcom/google/android/gms/tagmanager/ag;->lF()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mv()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mw()Ljava/util/List;

    move-result-object v1

    const-string v3, "add macro"

    invoke-static {v0, v1, v3}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mA()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mx()Ljava/util/List;

    move-result-object v1

    const-string v3, "remove macro"

    invoke-static {v0, v1, v3}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mt()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->my()Ljava/util/List;

    move-result-object v1

    const-string v3, "add tag"

    invoke-static {v0, v1, v3}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mu()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mz()Ljava/util/List;

    move-result-object v1

    const-string v3, "remove tag"

    invoke-static {v0, v1, v3}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V

    :cond_2
    move v3, v4

    :goto_0
    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mv()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v3, v0, :cond_4

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mv()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Lcom/google/android/gms/tagmanager/cq$a;

    const-string v0, "Unknown"

    invoke-interface {p6}, Lcom/google/android/gms/tagmanager/ag;->lF()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mw()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    if-ge v3, v6, :cond_3

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mw()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    :cond_3
    iget-object v6, p0, Lcom/google/android/gms/tagmanager/cs;->ahs:Ljava/util/Map;

    invoke-static {v1}, Lcom/google/android/gms/tagmanager/cs;->h(Lcom/google/android/gms/tagmanager/cq$a;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/google/android/gms/tagmanager/cs;->d(Ljava/util/Map;Ljava/lang/String;)Lcom/google/android/gms/tagmanager/cs$c;

    move-result-object v6

    invoke-virtual {v6, v2}, Lcom/google/android/gms/tagmanager/cs$c;->b(Lcom/google/android/gms/tagmanager/cq$e;)V

    invoke-virtual {v6, v2, v1}, Lcom/google/android/gms/tagmanager/cs$c;->a(Lcom/google/android/gms/tagmanager/cq$e;Lcom/google/android/gms/tagmanager/cq$a;)V

    invoke-virtual {v6, v2, v0}, Lcom/google/android/gms/tagmanager/cs$c;->a(Lcom/google/android/gms/tagmanager/cq$e;Ljava/lang/String;)V

    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_0

    :cond_4
    move v3, v4

    :goto_1
    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mA()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v3, v0, :cond_1

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mA()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/tagmanager/cq$a;

    const-string v1, "Unknown"

    invoke-interface {p6}, Lcom/google/android/gms/tagmanager/ag;->lF()Z

    move-result v6

    if-eqz v6, :cond_5

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mx()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    if-ge v3, v6, :cond_5

    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$e;->mx()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    :cond_5
    iget-object v6, p0, Lcom/google/android/gms/tagmanager/cs;->ahs:Ljava/util/Map;

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/cs;->h(Lcom/google/android/gms/tagmanager/cq$a;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/google/android/gms/tagmanager/cs;->d(Ljava/util/Map;Ljava/lang/String;)Lcom/google/android/gms/tagmanager/cs$c;

    move-result-object v6

    invoke-virtual {v6, v2}, Lcom/google/android/gms/tagmanager/cs$c;->b(Lcom/google/android/gms/tagmanager/cq$e;)V

    invoke-virtual {v6, v2, v0}, Lcom/google/android/gms/tagmanager/cs$c;->b(Lcom/google/android/gms/tagmanager/cq$e;Lcom/google/android/gms/tagmanager/cq$a;)V

    invoke-virtual {v6, v2, v1}, Lcom/google/android/gms/tagmanager/cs$c;->b(Lcom/google/android/gms/tagmanager/cq$e;Ljava/lang/String;)V

    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_1

    :cond_6
    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahk:Lcom/google/android/gms/tagmanager/cq$c;

    invoke-virtual {v0}, Lcom/google/android/gms/tagmanager/cq$c;->mo()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_7
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_8
    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_7

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/tagmanager/cq$a;

    invoke-virtual {v1}, Lcom/google/android/gms/tagmanager/cq$a;->mj()Ljava/util/Map;

    move-result-object v2

    sget-object v5, Lcom/google/android/gms/internal/b;->dh:Lcom/google/android/gms/internal/b;

    invoke-virtual {v5}, Lcom/google/android/gms/internal/b;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/d$a;

    invoke-static {v2}, Lcom/google/android/gms/tagmanager/dh;->n(Lcom/google/android/gms/internal/d$a;)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_8

    iget-object v5, p0, Lcom/google/android/gms/tagmanager/cs;->ahs:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v5, v2}, Lcom/google/android/gms/tagmanager/cs;->d(Ljava/util/Map;Ljava/lang/String;)Lcom/google/android/gms/tagmanager/cs$c;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/google/android/gms/tagmanager/cs$c;->i(Lcom/google/android/gms/tagmanager/cq$a;)V

    goto :goto_2

    :cond_9
    return-void
.end method

.method private a(Lcom/google/android/gms/internal/d$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/dj;)Lcom/google/android/gms/tagmanager/by;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/d$a;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/google/android/gms/tagmanager/dj;",
            ")",
            "Lcom/google/android/gms/tagmanager/by",
            "<",
            "Lcom/google/android/gms/internal/d$a;",
            ">;"
        }
    .end annotation

    const/4 v2, 0x0

    iget-boolean v0, p1, Lcom/google/android/gms/internal/d$a;->fX:Z

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/tagmanager/by;

    const/4 v1, 0x1

    invoke-direct {v0, p1, v1}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    :goto_0
    return-object v0

    :cond_0
    iget v0, p1, Lcom/google/android/gms/internal/d$a;->type:I

    packed-switch v0, :pswitch_data_0

    :pswitch_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Unknown type: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p1, Lcom/google/android/gms/internal/d$a;->type:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->A(Ljava/lang/String;)V

    sget-object v0, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    goto :goto_0

    :pswitch_1
    invoke-static {p1}, Lcom/google/android/gms/tagmanager/cq;->g(Lcom/google/android/gms/internal/d$a;)Lcom/google/android/gms/internal/d$a;

    move-result-object v3

    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fO:[Lcom/google/android/gms/internal/d$a;

    array-length v0, v0

    new-array v0, v0, [Lcom/google/android/gms/internal/d$a;

    iput-object v0, v3, Lcom/google/android/gms/internal/d$a;->fO:[Lcom/google/android/gms/internal/d$a;

    move v1, v2

    :goto_1
    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fO:[Lcom/google/android/gms/internal/d$a;

    array-length v0, v0

    if-ge v1, v0, :cond_2

    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fO:[Lcom/google/android/gms/internal/d$a;

    aget-object v0, v0, v1

    invoke-interface {p3, v1}, Lcom/google/android/gms/tagmanager/dj;->dq(I)Lcom/google/android/gms/tagmanager/dj;

    move-result-object v4

    invoke-direct {p0, v0, p2, v4}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/internal/d$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/dj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v0

    sget-object v4, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    if-ne v0, v4, :cond_1

    sget-object v0, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    goto :goto_0

    :cond_1
    iget-object v4, v3, Lcom/google/android/gms/internal/d$a;->fO:[Lcom/google/android/gms/internal/d$a;

    invoke-virtual {v0}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/d$a;

    aput-object v0, v4, v1

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    :cond_2
    new-instance v0, Lcom/google/android/gms/tagmanager/by;

    invoke-direct {v0, v3, v2}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    goto :goto_0

    :pswitch_2
    invoke-static {p1}, Lcom/google/android/gms/tagmanager/cq;->g(Lcom/google/android/gms/internal/d$a;)Lcom/google/android/gms/internal/d$a;

    move-result-object v3

    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fP:[Lcom/google/android/gms/internal/d$a;

    array-length v0, v0

    iget-object v1, p1, Lcom/google/android/gms/internal/d$a;->fQ:[Lcom/google/android/gms/internal/d$a;

    array-length v1, v1

    if-eq v0, v1, :cond_3

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Invalid serving value: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/google/android/gms/internal/d$a;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->A(Ljava/lang/String;)V

    sget-object v0, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    goto :goto_0

    :cond_3
    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fP:[Lcom/google/android/gms/internal/d$a;

    array-length v0, v0

    new-array v0, v0, [Lcom/google/android/gms/internal/d$a;

    iput-object v0, v3, Lcom/google/android/gms/internal/d$a;->fP:[Lcom/google/android/gms/internal/d$a;

    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fP:[Lcom/google/android/gms/internal/d$a;

    array-length v0, v0

    new-array v0, v0, [Lcom/google/android/gms/internal/d$a;

    iput-object v0, v3, Lcom/google/android/gms/internal/d$a;->fQ:[Lcom/google/android/gms/internal/d$a;

    move v1, v2

    :goto_2
    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fP:[Lcom/google/android/gms/internal/d$a;

    array-length v0, v0

    if-ge v1, v0, :cond_6

    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fP:[Lcom/google/android/gms/internal/d$a;

    aget-object v0, v0, v1

    invoke-interface {p3, v1}, Lcom/google/android/gms/tagmanager/dj;->dr(I)Lcom/google/android/gms/tagmanager/dj;

    move-result-object v4

    invoke-direct {p0, v0, p2, v4}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/internal/d$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/dj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v0

    iget-object v4, p1, Lcom/google/android/gms/internal/d$a;->fQ:[Lcom/google/android/gms/internal/d$a;

    aget-object v4, v4, v1

    invoke-interface {p3, v1}, Lcom/google/android/gms/tagmanager/dj;->ds(I)Lcom/google/android/gms/tagmanager/dj;

    move-result-object v5

    invoke-direct {p0, v4, p2, v5}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/internal/d$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/dj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v4

    sget-object v5, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    if-eq v0, v5, :cond_4

    sget-object v5, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    if-ne v4, v5, :cond_5

    :cond_4
    sget-object v0, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    goto/16 :goto_0

    :cond_5
    iget-object v5, v3, Lcom/google/android/gms/internal/d$a;->fP:[Lcom/google/android/gms/internal/d$a;

    invoke-virtual {v0}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/d$a;

    aput-object v0, v5, v1

    iget-object v5, v3, Lcom/google/android/gms/internal/d$a;->fQ:[Lcom/google/android/gms/internal/d$a;

    invoke-virtual {v4}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/d$a;

    aput-object v0, v5, v1

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_2

    :cond_6
    new-instance v0, Lcom/google/android/gms/tagmanager/by;

    invoke-direct {v0, v3, v2}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    goto/16 :goto_0

    :pswitch_3
    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fR:Ljava/lang/String;

    invoke-interface {p2, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Macro cycle detected.  Current macro reference: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p1, Lcom/google/android/gms/internal/d$a;->fR:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".  Previous macro references: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->A(Ljava/lang/String;)V

    sget-object v0, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    goto/16 :goto_0

    :cond_7
    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fR:Ljava/lang/String;

    invoke-interface {p2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fR:Ljava/lang/String;

    invoke-interface {p3}, Lcom/google/android/gms/tagmanager/dj;->lU()Lcom/google/android/gms/tagmanager/bj;

    move-result-object v1

    invoke-direct {p0, v0, p2, v1}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/lang/String;Ljava/util/Set;Lcom/google/android/gms/tagmanager/bj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/d$a;->fW:[I

    invoke-static {v0, v1}, Lcom/google/android/gms/tagmanager/dk;->a(Lcom/google/android/gms/tagmanager/by;[I)Lcom/google/android/gms/tagmanager/by;

    move-result-object v0

    iget-object v1, p1, Lcom/google/android/gms/internal/d$a;->fR:Ljava/lang/String;

    invoke-interface {p2, v1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_4
    invoke-static {p1}, Lcom/google/android/gms/tagmanager/cq;->g(Lcom/google/android/gms/internal/d$a;)Lcom/google/android/gms/internal/d$a;

    move-result-object v3

    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fV:[Lcom/google/android/gms/internal/d$a;

    array-length v0, v0

    new-array v0, v0, [Lcom/google/android/gms/internal/d$a;

    iput-object v0, v3, Lcom/google/android/gms/internal/d$a;->fV:[Lcom/google/android/gms/internal/d$a;

    move v1, v2

    :goto_3
    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fV:[Lcom/google/android/gms/internal/d$a;

    array-length v0, v0

    if-ge v1, v0, :cond_9

    iget-object v0, p1, Lcom/google/android/gms/internal/d$a;->fV:[Lcom/google/android/gms/internal/d$a;

    aget-object v0, v0, v1

    invoke-interface {p3, v1}, Lcom/google/android/gms/tagmanager/dj;->dt(I)Lcom/google/android/gms/tagmanager/dj;

    move-result-object v4

    invoke-direct {p0, v0, p2, v4}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/internal/d$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/dj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v0

    sget-object v4, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    if-ne v0, v4, :cond_8

    sget-object v0, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    goto/16 :goto_0

    :cond_8
    iget-object v4, v3, Lcom/google/android/gms/internal/d$a;->fV:[Lcom/google/android/gms/internal/d$a;

    invoke-virtual {v0}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/d$a;

    aput-object v0, v4, v1

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    :cond_9
    new-instance v0, Lcom/google/android/gms/tagmanager/by;

    invoke-direct {v0, v3, v2}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    goto/16 :goto_0

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_4
    .end packed-switch
.end method

.method private a(Ljava/lang/String;Ljava/util/Set;Lcom/google/android/gms/tagmanager/bj;)Lcom/google/android/gms/tagmanager/by;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/google/android/gms/tagmanager/bj;",
            ")",
            "Lcom/google/android/gms/tagmanager/by",
            "<",
            "Lcom/google/android/gms/internal/d$a;",
            ">;"
        }
    .end annotation

    const/4 v10, 0x1

    iget v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahq:Lcom/google/android/gms/tagmanager/k;

    invoke-interface {v0, p1}, Lcom/google/android/gms/tagmanager/k;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/tagmanager/cs$b;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/google/android/gms/tagmanager/cs;->ahl:Lcom/google/android/gms/tagmanager/ag;

    invoke-interface {v1}, Lcom/google/android/gms/tagmanager/ag;->lF()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/google/android/gms/tagmanager/cs$b;->mk()Lcom/google/android/gms/internal/d$a;

    move-result-object v1

    invoke-direct {p0, v1, p2}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/internal/d$a;Ljava/util/Set;)V

    iget v1, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    invoke-virtual {v0}, Lcom/google/android/gms/tagmanager/cs$b;->mE()Lcom/google/android/gms/tagmanager/by;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahs:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    move-object v9, v0

    check-cast v9, Lcom/google/android/gms/tagmanager/cs$c;

    if-nez v9, :cond_1

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Lcom/google/android/gms/tagmanager/cs;->mD()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "Invalid macro: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->A(Ljava/lang/String;)V

    iget v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    sget-object v0, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    goto :goto_0

    :cond_1
    invoke-virtual {v9}, Lcom/google/android/gms/tagmanager/cs$c;->mF()Ljava/util/Set;

    move-result-object v2

    invoke-virtual {v9}, Lcom/google/android/gms/tagmanager/cs$c;->mG()Ljava/util/Map;

    move-result-object v3

    invoke-virtual {v9}, Lcom/google/android/gms/tagmanager/cs$c;->mH()Ljava/util/Map;

    move-result-object v4

    invoke-virtual {v9}, Lcom/google/android/gms/tagmanager/cs$c;->mJ()Ljava/util/Map;

    move-result-object v5

    invoke-virtual {v9}, Lcom/google/android/gms/tagmanager/cs$c;->mI()Ljava/util/Map;

    move-result-object v6

    invoke-interface {p3}, Lcom/google/android/gms/tagmanager/bj;->lw()Lcom/google/android/gms/tagmanager/cr;

    move-result-object v8

    move-object v0, p0

    move-object v1, p1

    move-object v7, p2

    invoke-virtual/range {v0 .. v8}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cr;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {v9}, Lcom/google/android/gms/tagmanager/cs$c;->mK()Lcom/google/android/gms/tagmanager/cq$a;

    move-result-object v0

    move-object v2, v0

    :goto_1
    if-nez v2, :cond_4

    iget v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    sget-object v0, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    goto :goto_0

    :cond_2
    invoke-virtual {v1}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    if-le v0, v10, :cond_3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0}, Lcom/google/android/gms/tagmanager/cs;->mD()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "Multiple macros active for macroName "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->D(Ljava/lang/String;)V

    :cond_3
    invoke-virtual {v1}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/tagmanager/cq$a;

    move-object v2, v0

    goto :goto_1

    :cond_4
    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->aho:Ljava/util/Map;

    invoke-interface {p3}, Lcom/google/android/gms/tagmanager/bj;->lL()Lcom/google/android/gms/tagmanager/cj;

    move-result-object v3

    invoke-direct {p0, v0, v2, p2, v3}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/Map;Lcom/google/android/gms/tagmanager/cq$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v3

    invoke-virtual {v1}, Lcom/google/android/gms/tagmanager/by;->lV()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-virtual {v3}, Lcom/google/android/gms/tagmanager/by;->lV()Z

    move-result v0

    if-eqz v0, :cond_6

    move v0, v10

    :goto_2
    sget-object v1, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    if-ne v3, v1, :cond_7

    sget-object v0, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    :goto_3
    invoke-virtual {v2}, Lcom/google/android/gms/tagmanager/cq$a;->mk()Lcom/google/android/gms/internal/d$a;

    move-result-object v1

    invoke-virtual {v0}, Lcom/google/android/gms/tagmanager/by;->lV()Z

    move-result v2

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/google/android/gms/tagmanager/cs;->ahq:Lcom/google/android/gms/tagmanager/k;

    new-instance v3, Lcom/google/android/gms/tagmanager/cs$b;

    invoke-direct {v3, v0, v1}, Lcom/google/android/gms/tagmanager/cs$b;-><init>(Lcom/google/android/gms/tagmanager/by;Lcom/google/android/gms/internal/d$a;)V

    invoke-interface {v2, p1, v3}, Lcom/google/android/gms/tagmanager/k;->e(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_5
    invoke-direct {p0, v1, p2}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/internal/d$a;Ljava/util/Set;)V

    iget v1, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    goto/16 :goto_0

    :cond_6
    const/4 v0, 0x0

    goto :goto_2

    :cond_7
    new-instance v1, Lcom/google/android/gms/tagmanager/by;

    invoke-virtual {v3}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v3

    invoke-direct {v1, v3, v0}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    move-object v0, v1

    goto :goto_3
.end method

.method private a(Ljava/util/Map;Lcom/google/android/gms/tagmanager/cq$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cj;)Lcom/google/android/gms/tagmanager/by;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/tagmanager/aj;",
            ">;",
            "Lcom/google/android/gms/tagmanager/cq$a;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/google/android/gms/tagmanager/cj;",
            ")",
            "Lcom/google/android/gms/tagmanager/by",
            "<",
            "Lcom/google/android/gms/internal/d$a;",
            ">;"
        }
    .end annotation

    const/4 v5, 0x1

    const/4 v6, 0x0

    invoke-virtual {p2}, Lcom/google/android/gms/tagmanager/cq$a;->mj()Ljava/util/Map;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/b;->cx:Lcom/google/android/gms/internal/b;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/b;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/d$a;

    if-nez v0, :cond_1

    const-string v0, "No function id in properties"

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->A(Ljava/lang/String;)V

    sget-object v1, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    :cond_0
    :goto_0
    return-object v1

    :cond_1
    iget-object v7, v0, Lcom/google/android/gms/internal/d$a;->fS:Ljava/lang/String;

    invoke-interface {p1, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/tagmanager/aj;

    if-nez v0, :cond_2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " has no backing implementation."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->A(Ljava/lang/String;)V

    sget-object v1, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    goto :goto_0

    :cond_2
    iget-object v1, p0, Lcom/google/android/gms/tagmanager/cs;->ahp:Lcom/google/android/gms/tagmanager/k;

    invoke-interface {v1, p2}, Lcom/google/android/gms/tagmanager/k;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/tagmanager/by;

    if-eqz v1, :cond_3

    iget-object v2, p0, Lcom/google/android/gms/tagmanager/cs;->ahl:Lcom/google/android/gms/tagmanager/ag;

    invoke-interface {v2}, Lcom/google/android/gms/tagmanager/ag;->lF()Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_3
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {p2}, Lcom/google/android/gms/tagmanager/cq$a;->mj()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    move v4, v5

    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_6

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {p4, v2}, Lcom/google/android/gms/tagmanager/cj;->bZ(Ljava/lang/String;)Lcom/google/android/gms/tagmanager/cl;

    move-result-object v10

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/internal/d$a;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/d$a;

    invoke-interface {v10, v3}, Lcom/google/android/gms/tagmanager/cl;->e(Lcom/google/android/gms/internal/d$a;)Lcom/google/android/gms/tagmanager/dj;

    move-result-object v3

    invoke-direct {p0, v2, p3, v3}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/internal/d$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/dj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v10

    sget-object v2, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    if-ne v10, v2, :cond_4

    sget-object v1, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    goto :goto_0

    :cond_4
    invoke-virtual {v10}, Lcom/google/android/gms/tagmanager/by;->lV()Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v10}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/internal/d$a;

    invoke-virtual {p2, v2, v3}, Lcom/google/android/gms/tagmanager/cq$a;->a(Ljava/lang/String;Lcom/google/android/gms/internal/d$a;)V

    move v2, v4

    :goto_2
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v10}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v8, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move v4, v2

    goto :goto_1

    :cond_5
    move v2, v6

    goto :goto_2

    :cond_6
    invoke-interface {v8}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gms/tagmanager/aj;->a(Ljava/util/Set;)Z

    move-result v1

    if-nez v1, :cond_7

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Incorrect keys for function "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " required "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/google/android/gms/tagmanager/aj;->lH()Ljava/util/Set;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " had "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-interface {v8}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->A(Ljava/lang/String;)V

    sget-object v1, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    goto/16 :goto_0

    :cond_7
    if-eqz v4, :cond_9

    invoke-virtual {v0}, Lcom/google/android/gms/tagmanager/aj;->lc()Z

    move-result v1

    if-eqz v1, :cond_9

    :goto_3
    new-instance v1, Lcom/google/android/gms/tagmanager/by;

    invoke-virtual {v0, v8}, Lcom/google/android/gms/tagmanager/aj;->w(Ljava/util/Map;)Lcom/google/android/gms/internal/d$a;

    move-result-object v0

    invoke-direct {v1, v0, v5}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    if-eqz v5, :cond_8

    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahp:Lcom/google/android/gms/tagmanager/k;

    invoke-interface {v0, p2, v1}, Lcom/google/android/gms/tagmanager/k;->e(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_8
    invoke-virtual {v1}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/d$a;

    invoke-interface {p4, v0}, Lcom/google/android/gms/tagmanager/cj;->d(Lcom/google/android/gms/internal/d$a;)V

    goto/16 :goto_0

    :cond_9
    move v5, v6

    goto :goto_3
.end method

.method private a(Ljava/util/Set;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cs$a;Lcom/google/android/gms/tagmanager/cr;)Lcom/google/android/gms/tagmanager/by;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$e;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/google/android/gms/tagmanager/cs$a;",
            "Lcom/google/android/gms/tagmanager/cr;",
            ")",
            "Lcom/google/android/gms/tagmanager/by",
            "<",
            "Ljava/util/Set",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$a;",
            ">;>;"
        }
    .end annotation

    const/4 v3, 0x1

    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    new-instance v5, Ljava/util/HashSet;

    invoke-direct {v5}, Ljava/util/HashSet;-><init>()V

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    move v2, v3

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/tagmanager/cq$e;

    invoke-interface {p4}, Lcom/google/android/gms/tagmanager/cr;->lT()Lcom/google/android/gms/tagmanager/cm;

    move-result-object v7

    invoke-virtual {p0, v0, p2, v7}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/cq$e;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cm;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v8

    invoke-virtual {v8}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {p3, v0, v4, v5, v7}, Lcom/google/android/gms/tagmanager/cs$a;->a(Lcom/google/android/gms/tagmanager/cq$e;Ljava/util/Set;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cm;)V

    :cond_0
    if-eqz v2, :cond_1

    invoke-virtual {v8}, Lcom/google/android/gms/tagmanager/by;->lV()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v3

    :goto_1
    move v2, v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_1

    :cond_2
    invoke-interface {v4, v5}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    invoke-interface {p4, v4}, Lcom/google/android/gms/tagmanager/cr;->b(Ljava/util/Set;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/by;

    invoke-direct {v0, v4, v2}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    return-object v0
.end method

.method private a(Lcom/google/android/gms/internal/d$a;Ljava/util/Set;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/d$a;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    new-instance v0, Lcom/google/android/gms/tagmanager/bw;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/bw;-><init>()V

    invoke-direct {p0, p1, p2, v0}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/internal/d$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/dj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/tagmanager/cs;->ahj:Lcom/google/android/gms/tagmanager/by;

    if-eq v0, v1, :cond_0

    invoke-virtual {v0}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/d$a;

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/dh;->o(Lcom/google/android/gms/internal/d$a;)Ljava/lang/Object;

    move-result-object v0

    instance-of v1, v0, Ljava/util/Map;

    if-eqz v1, :cond_2

    check-cast v0, Ljava/util/Map;

    iget-object v1, p0, Lcom/google/android/gms/tagmanager/cs;->aer:Lcom/google/android/gms/tagmanager/DataLayer;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/tagmanager/DataLayer;->push(Ljava/util/Map;)V

    goto :goto_0

    :cond_2
    instance-of v1, v0, Ljava/util/List;

    if-eqz v1, :cond_4

    check-cast v0, Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    instance-of v2, v0, Ljava/util/Map;

    if-eqz v2, :cond_3

    check-cast v0, Ljava/util/Map;

    iget-object v2, p0, Lcom/google/android/gms/tagmanager/cs;->aer:Lcom/google/android/gms/tagmanager/DataLayer;

    invoke-virtual {v2, v0}, Lcom/google/android/gms/tagmanager/DataLayer;->push(Ljava/util/Map;)V

    goto :goto_1

    :cond_3
    const-string v0, "pushAfterEvaluate: value not a Map"

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->D(Ljava/lang/String;)V

    goto :goto_1

    :cond_4
    const-string v0, "pushAfterEvaluate: value not a Map or List"

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->D(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private static a(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$a;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    if-eq v0, v1, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Invalid resource: imbalance of rule names of functions for "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " operation. Using default rule name instead"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->B(Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method private static a(Ljava/util/Map;Lcom/google/android/gms/tagmanager/aj;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/tagmanager/aj;",
            ">;",
            "Lcom/google/android/gms/tagmanager/aj;",
            ")V"
        }
    .end annotation

    invoke-virtual {p1}, Lcom/google/android/gms/tagmanager/aj;->lG()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p0, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Duplicate function type name: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/google/android/gms/tagmanager/aj;->lG()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {p1}, Lcom/google/android/gms/tagmanager/aj;->lG()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p0, v0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private static d(Ljava/util/Map;Ljava/lang/String;)Lcom/google/android/gms/tagmanager/cs$c;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/tagmanager/cs$c;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tagmanager/cs$c;"
        }
    .end annotation

    invoke-interface {p0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/tagmanager/cs$c;

    if-nez v0, :cond_0

    new-instance v0, Lcom/google/android/gms/tagmanager/cs$c;

    invoke-direct {v0}, Lcom/google/android/gms/tagmanager/cs$c;-><init>()V

    invoke-interface {p0, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    return-object v0
.end method

.method private static h(Lcom/google/android/gms/tagmanager/cq$a;)Ljava/lang/String;
    .locals 2

    invoke-virtual {p0}, Lcom/google/android/gms/tagmanager/cq$a;->mj()Ljava/util/Map;

    move-result-object v0

    sget-object v1, Lcom/google/android/gms/internal/b;->cI:Lcom/google/android/gms/internal/b;

    invoke-virtual {v1}, Lcom/google/android/gms/internal/b;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/d$a;

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/dh;->j(Lcom/google/android/gms/internal/d$a;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private mD()Ljava/lang/String;
    .locals 3

    iget v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    const/4 v1, 0x1

    if-gt v0, v1, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v0, 0x2

    :goto_1
    iget v2, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    if-ge v0, v2, :cond_1

    const/16 v2, 0x20

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_1
    const-string v0, ": "

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method a(Lcom/google/android/gms/tagmanager/cq$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cj;)Lcom/google/android/gms/tagmanager/by;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/tagmanager/cq$a;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/google/android/gms/tagmanager/cj;",
            ")",
            "Lcom/google/android/gms/tagmanager/by",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahn:Ljava/util/Map;

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/Map;Lcom/google/android/gms/tagmanager/cq$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/d$a;

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/dh;->n(Lcom/google/android/gms/internal/d$a;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/dh;->r(Ljava/lang/Object;)Lcom/google/android/gms/internal/d$a;

    move-result-object v2

    invoke-interface {p3, v2}, Lcom/google/android/gms/tagmanager/cj;->d(Lcom/google/android/gms/internal/d$a;)V

    new-instance v2, Lcom/google/android/gms/tagmanager/by;

    invoke-virtual {v1}, Lcom/google/android/gms/tagmanager/by;->lV()Z

    move-result v1

    invoke-direct {v2, v0, v1}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    return-object v2
.end method

.method a(Lcom/google/android/gms/tagmanager/cq$e;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cm;)Lcom/google/android/gms/tagmanager/by;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/tagmanager/cq$e;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/google/android/gms/tagmanager/cm;",
            ")",
            "Lcom/google/android/gms/tagmanager/by",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-virtual {p1}, Lcom/google/android/gms/tagmanager/cq$e;->ms()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    move v1, v2

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/tagmanager/cq$a;

    invoke-interface {p3}, Lcom/google/android/gms/tagmanager/cm;->lN()Lcom/google/android/gms/tagmanager/cj;

    move-result-object v5

    invoke-virtual {p0, v0, p2, v5}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/cq$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/dh;->r(Ljava/lang/Object;)Lcom/google/android/gms/internal/d$a;

    move-result-object v0

    invoke-interface {p3, v0}, Lcom/google/android/gms/tagmanager/cm;->f(Lcom/google/android/gms/internal/d$a;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/by;

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v5}, Lcom/google/android/gms/tagmanager/by;->lV()Z

    move-result v2

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    :goto_1
    return-object v0

    :cond_0
    if-eqz v1, :cond_1

    invoke-virtual {v5}, Lcom/google/android/gms/tagmanager/by;->lV()Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v2

    :goto_2
    move v1, v0

    goto :goto_0

    :cond_1
    move v0, v3

    goto :goto_2

    :cond_2
    invoke-virtual {p1}, Lcom/google/android/gms/tagmanager/cq$e;->mr()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/tagmanager/cq$a;

    invoke-interface {p3}, Lcom/google/android/gms/tagmanager/cm;->lO()Lcom/google/android/gms/tagmanager/cj;

    move-result-object v5

    invoke-virtual {p0, v0, p2, v5}, Lcom/google/android/gms/tagmanager/cs;->a(Lcom/google/android/gms/tagmanager/cq$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/dh;->r(Ljava/lang/Object;)Lcom/google/android/gms/internal/d$a;

    move-result-object v0

    invoke-interface {p3, v0}, Lcom/google/android/gms/tagmanager/cm;->f(Lcom/google/android/gms/internal/d$a;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/by;

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v5}, Lcom/google/android/gms/tagmanager/by;->lV()Z

    move-result v2

    invoke-direct {v0, v1, v2}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    goto :goto_1

    :cond_3
    if-eqz v1, :cond_4

    invoke-virtual {v5}, Lcom/google/android/gms/tagmanager/by;->lV()Z

    move-result v0

    if-eqz v0, :cond_4

    move v1, v2

    goto :goto_3

    :cond_4
    move v1, v3

    goto :goto_3

    :cond_5
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/dh;->r(Ljava/lang/Object;)Lcom/google/android/gms/internal/d$a;

    move-result-object v0

    invoke-interface {p3, v0}, Lcom/google/android/gms/tagmanager/cm;->f(Lcom/google/android/gms/internal/d$a;)V

    new-instance v0, Lcom/google/android/gms/tagmanager/by;

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-direct {v0, v2, v1}, Lcom/google/android/gms/tagmanager/by;-><init>(Ljava/lang/Object;Z)V

    goto :goto_1
.end method

.method a(Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cr;)Lcom/google/android/gms/tagmanager/by;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$e;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$e;",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$a;",
            ">;>;",
            "Ljava/util/Map",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$e;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/util/Map",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$e;",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$a;",
            ">;>;",
            "Ljava/util/Map",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$e;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/google/android/gms/tagmanager/cr;",
            ")",
            "Lcom/google/android/gms/tagmanager/by",
            "<",
            "Ljava/util/Set",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$a;",
            ">;>;"
        }
    .end annotation

    new-instance v0, Lcom/google/android/gms/tagmanager/cs$3;

    move-object v1, p0

    move-object v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/tagmanager/cs$3;-><init>(Lcom/google/android/gms/tagmanager/cs;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V

    invoke-direct {p0, p2, p7, v0, p8}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/Set;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cs$a;Lcom/google/android/gms/tagmanager/cr;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v0

    return-object v0
.end method

.method a(Ljava/util/Set;Lcom/google/android/gms/tagmanager/cr;)Lcom/google/android/gms/tagmanager/by;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$e;",
            ">;",
            "Lcom/google/android/gms/tagmanager/cr;",
            ")",
            "Lcom/google/android/gms/tagmanager/by",
            "<",
            "Ljava/util/Set",
            "<",
            "Lcom/google/android/gms/tagmanager/cq$a;",
            ">;>;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    new-instance v1, Lcom/google/android/gms/tagmanager/cs$4;

    invoke-direct {v1, p0}, Lcom/google/android/gms/tagmanager/cs$4;-><init>(Lcom/google/android/gms/tagmanager/cs;)V

    invoke-direct {p0, p1, v0, v1, p2}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/Set;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cs$a;Lcom/google/android/gms/tagmanager/cr;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v0

    return-object v0
.end method

.method a(Lcom/google/android/gms/tagmanager/aj;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->aho:Ljava/util/Map;

    invoke-static {v0, p1}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/Map;Lcom/google/android/gms/tagmanager/aj;)V

    return-void
.end method

.method b(Lcom/google/android/gms/tagmanager/aj;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahm:Ljava/util/Map;

    invoke-static {v0, p1}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/Map;Lcom/google/android/gms/tagmanager/aj;)V

    return-void
.end method

.method public declared-synchronized bH(Ljava/lang/String;)V
    .locals 7

    monitor-enter p0

    :try_start_0
    invoke-virtual {p0, p1}, Lcom/google/android/gms/tagmanager/cs;->ck(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahl:Lcom/google/android/gms/tagmanager/ag;

    invoke-interface {v0, p1}, Lcom/google/android/gms/tagmanager/ag;->bT(Ljava/lang/String;)Lcom/google/android/gms/tagmanager/af;

    move-result-object v1

    invoke-interface {v1}, Lcom/google/android/gms/tagmanager/af;->lD()Lcom/google/android/gms/tagmanager/t;

    move-result-object v2

    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahr:Ljava/util/Set;

    invoke-interface {v2}, Lcom/google/android/gms/tagmanager/t;->lw()Lcom/google/android/gms/tagmanager/cr;

    move-result-object v3

    invoke-virtual {p0, v0, v3}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/Set;Lcom/google/android/gms/tagmanager/cr;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/tagmanager/by;->getObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/tagmanager/cq$a;

    iget-object v4, p0, Lcom/google/android/gms/tagmanager/cs;->ahm:Ljava/util/Map;

    new-instance v5, Ljava/util/HashSet;

    invoke-direct {v5}, Ljava/util/HashSet;-><init>()V

    invoke-interface {v2}, Lcom/google/android/gms/tagmanager/t;->lv()Lcom/google/android/gms/tagmanager/cj;

    move-result-object v6

    invoke-direct {p0, v4, v0, v5, v6}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/Map;Lcom/google/android/gms/tagmanager/cq$a;Ljava/util/Set;Lcom/google/android/gms/tagmanager/cj;)Lcom/google/android/gms/tagmanager/by;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_0
    :try_start_1
    invoke-interface {v1}, Lcom/google/android/gms/tagmanager/af;->lE()V

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gms/tagmanager/cs;->ck(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-void
.end method

.method c(Lcom/google/android/gms/tagmanager/aj;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahn:Ljava/util/Map;

    invoke-static {v0, p1}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/util/Map;Lcom/google/android/gms/tagmanager/aj;)V

    return-void
.end method

.method public cj(Ljava/lang/String;)Lcom/google/android/gms/tagmanager/by;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/android/gms/tagmanager/by",
            "<",
            "Lcom/google/android/gms/internal/d$a;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahu:I

    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->ahl:Lcom/google/android/gms/tagmanager/ag;

    invoke-interface {v0, p1}, Lcom/google/android/gms/tagmanager/ag;->bS(Ljava/lang/String;)Lcom/google/android/gms/tagmanager/af;

    move-result-object v0

    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    invoke-interface {v0}, Lcom/google/android/gms/tagmanager/af;->lC()Lcom/google/android/gms/tagmanager/bj;

    move-result-object v2

    invoke-direct {p0, p1, v1, v2}, Lcom/google/android/gms/tagmanager/cs;->a(Ljava/lang/String;Ljava/util/Set;Lcom/google/android/gms/tagmanager/bj;)Lcom/google/android/gms/tagmanager/by;

    move-result-object v1

    invoke-interface {v0}, Lcom/google/android/gms/tagmanager/af;->lE()V

    return-object v1
.end method

.method declared-synchronized ck(Ljava/lang/String;)V
    .locals 1

    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/google/android/gms/tagmanager/cs;->aht:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized h(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/internal/c$i;",
            ">;)V"
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/c$i;

    iget-object v2, v0, Lcom/google/android/gms/internal/c$i;->name:Ljava/lang/String;

    if-eqz v2, :cond_0

    iget-object v2, v0, Lcom/google/android/gms/internal/c$i;->name:Ljava/lang/String;

    const-string v3, "gaExperiment:"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Ignored supplemental: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/tagmanager/bh;->C(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_1
    :try_start_1
    iget-object v2, p0, Lcom/google/android/gms/tagmanager/cs;->aer:Lcom/google/android/gms/tagmanager/DataLayer;

    invoke-static {v2, v0}, Lcom/google/android/gms/tagmanager/ai;->a(Lcom/google/android/gms/tagmanager/DataLayer;Lcom/google/android/gms/internal/c$i;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :cond_2
    monitor-exit p0

    return-void
.end method

.method declared-synchronized mC()Ljava/lang/String;
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/tagmanager/cs;->aht:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
