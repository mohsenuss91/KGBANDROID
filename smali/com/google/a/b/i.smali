.class final Lcom/google/a/b/i;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/a/b/ae;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/a/b/ae",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/google/a/b/f;


# direct methods
.method constructor <init>(Lcom/google/a/b/f;)V
    .locals 0

    iput-object p1, p0, Lcom/google/a/b/i;->a:Lcom/google/a/b/f;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    new-instance v0, Lcom/google/a/b/w;

    invoke-direct {v0}, Lcom/google/a/b/w;-><init>()V

    return-object v0
.end method
