.class public abstract Lcom/google/a/ak;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/Object;)Lcom/google/a/w;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Lcom/google/a/w;"
        }
    .end annotation

    :try_start_0
    new-instance v0, Lcom/google/a/b/a/i;

    invoke-direct {v0}, Lcom/google/a/b/a/i;-><init>()V

    invoke-virtual {p0, v0, p1}, Lcom/google/a/ak;->a(Lcom/google/a/d/d;Ljava/lang/Object;)V

    invoke-virtual {v0}, Lcom/google/a/b/a/i;->a()Lcom/google/a/w;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/google/a/x;

    invoke-direct {v1, v0}, Lcom/google/a/x;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public abstract a(Lcom/google/a/d/a;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/a/d/a;",
            ")TT;"
        }
    .end annotation
.end method

.method public abstract a(Lcom/google/a/d/d;Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/a/d/d;",
            "TT;)V"
        }
    .end annotation
.end method
