.class final Lcom/google/a/b/t;
.super Lcom/google/a/ak;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/a/ak",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Z

.field final synthetic b:Z

.field final synthetic c:Lcom/google/a/k;

.field final synthetic d:Lcom/google/a/c/a;

.field final synthetic e:Lcom/google/a/b/s;

.field private f:Lcom/google/a/ak;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/a/ak",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/google/a/b/s;ZZLcom/google/a/k;Lcom/google/a/c/a;)V
    .locals 0

    iput-object p1, p0, Lcom/google/a/b/t;->e:Lcom/google/a/b/s;

    iput-boolean p2, p0, Lcom/google/a/b/t;->a:Z

    iput-boolean p3, p0, Lcom/google/a/b/t;->b:Z

    iput-object p4, p0, Lcom/google/a/b/t;->c:Lcom/google/a/k;

    iput-object p5, p0, Lcom/google/a/b/t;->d:Lcom/google/a/c/a;

    invoke-direct {p0}, Lcom/google/a/ak;-><init>()V

    return-void
.end method

.method private a()Lcom/google/a/ak;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/a/ak",
            "<TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/a/b/t;->f:Lcom/google/a/ak;

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/a/b/t;->c:Lcom/google/a/k;

    iget-object v1, p0, Lcom/google/a/b/t;->e:Lcom/google/a/b/s;

    iget-object v2, p0, Lcom/google/a/b/t;->d:Lcom/google/a/c/a;

    invoke-virtual {v0, v1, v2}, Lcom/google/a/k;->a(Lcom/google/a/al;Lcom/google/a/c/a;)Lcom/google/a/ak;

    move-result-object v0

    iput-object v0, p0, Lcom/google/a/b/t;->f:Lcom/google/a/ak;

    goto :goto_0
.end method


# virtual methods
.method public final a(Lcom/google/a/d/a;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/a/d/a;",
            ")TT;"
        }
    .end annotation

    iget-boolean v0, p0, Lcom/google/a/b/t;->a:Z

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/google/a/d/a;->n()V

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/google/a/b/t;->a()Lcom/google/a/ak;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/a/ak;->a(Lcom/google/a/d/a;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public final a(Lcom/google/a/d/d;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/a/d/d;",
            "TT;)V"
        }
    .end annotation

    iget-boolean v0, p0, Lcom/google/a/b/t;->b:Z

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/google/a/d/d;->f()Lcom/google/a/d/d;

    :goto_0
    return-void

    :cond_0
    invoke-direct {p0}, Lcom/google/a/b/t;->a()Lcom/google/a/ak;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/google/a/ak;->a(Lcom/google/a/d/d;Ljava/lang/Object;)V

    goto :goto_0
.end method
