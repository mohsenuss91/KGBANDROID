.class public Landroid/support/v4/c/a;
.super Landroid/support/v4/c/l;

# interfaces
.implements Ljava/util/Map;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/support/v4/c/l",
        "<TK;TV;>;",
        "Ljava/util/Map",
        "<TK;TV;>;"
    }
.end annotation


# instance fields
.field a:Landroid/support/v4/c/f;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/c/f",
            "<TK;TV;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/c/l;-><init>()V

    return-void
.end method

.method private b()Landroid/support/v4/c/f;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/support/v4/c/f",
            "<TK;TV;>;"
        }
    .end annotation

    iget-object v0, p0, Landroid/support/v4/c/a;->a:Landroid/support/v4/c/f;

    if-nez v0, :cond_0

    new-instance v0, Landroid/support/v4/c/b;

    invoke-direct {v0, p0}, Landroid/support/v4/c/b;-><init>(Landroid/support/v4/c/a;)V

    iput-object v0, p0, Landroid/support/v4/c/a;->a:Landroid/support/v4/c/f;

    :cond_0
    iget-object v0, p0, Landroid/support/v4/c/a;->a:Landroid/support/v4/c/f;

    return-object v0
.end method


# virtual methods
.method public entrySet()Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;>;"
        }
    .end annotation

    invoke-direct {p0}, Landroid/support/v4/c/a;->b()Landroid/support/v4/c/f;

    move-result-object v0

    iget-object v1, v0, Landroid/support/v4/c/f;->b:Landroid/support/v4/c/h;

    if-nez v1, :cond_0

    new-instance v1, Landroid/support/v4/c/h;

    invoke-direct {v1, v0}, Landroid/support/v4/c/h;-><init>(Landroid/support/v4/c/f;)V

    iput-object v1, v0, Landroid/support/v4/c/f;->b:Landroid/support/v4/c/h;

    :cond_0
    iget-object v0, v0, Landroid/support/v4/c/f;->b:Landroid/support/v4/c/h;

    return-object v0
.end method

.method public keySet()Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<TK;>;"
        }
    .end annotation

    invoke-direct {p0}, Landroid/support/v4/c/a;->b()Landroid/support/v4/c/f;

    move-result-object v0

    iget-object v1, v0, Landroid/support/v4/c/f;->c:Landroid/support/v4/c/i;

    if-nez v1, :cond_0

    new-instance v1, Landroid/support/v4/c/i;

    invoke-direct {v1, v0}, Landroid/support/v4/c/i;-><init>(Landroid/support/v4/c/f;)V

    iput-object v1, v0, Landroid/support/v4/c/f;->c:Landroid/support/v4/c/i;

    :cond_0
    iget-object v0, v0, Landroid/support/v4/c/f;->c:Landroid/support/v4/c/i;

    return-object v0
.end method

.method public putAll(Ljava/util/Map;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<+TK;+TV;>;)V"
        }
    .end annotation

    const/4 v4, 0x0

    iget v0, p0, Landroid/support/v4/c/a;->h:I

    invoke-interface {p1}, Ljava/util/Map;->size()I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Landroid/support/v4/c/l;->f:[I

    array-length v1, v1

    if-ge v1, v0, :cond_1

    iget-object v1, p0, Landroid/support/v4/c/l;->f:[I

    iget-object v2, p0, Landroid/support/v4/c/l;->g:[Ljava/lang/Object;

    invoke-super {p0, v0}, Landroid/support/v4/c/l;->a(I)V

    iget v0, p0, Landroid/support/v4/c/l;->h:I

    if-lez v0, :cond_0

    iget-object v0, p0, Landroid/support/v4/c/l;->f:[I

    iget v3, p0, Landroid/support/v4/c/l;->h:I

    invoke-static {v1, v4, v0, v4, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v0, p0, Landroid/support/v4/c/l;->g:[Ljava/lang/Object;

    iget v3, p0, Landroid/support/v4/c/l;->h:I

    shl-int/lit8 v3, v3, 0x1

    invoke-static {v2, v4, v0, v4, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_0
    iget v0, p0, Landroid/support/v4/c/l;->h:I

    invoke-static {v1, v2, v0}, Landroid/support/v4/c/l;->a([I[Ljava/lang/Object;I)V

    :cond_1
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p0, v2, v0}, Landroid/support/v4/c/a;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_2
    return-void
.end method

.method public values()Ljava/util/Collection;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<TV;>;"
        }
    .end annotation

    invoke-direct {p0}, Landroid/support/v4/c/a;->b()Landroid/support/v4/c/f;

    move-result-object v0

    iget-object v1, v0, Landroid/support/v4/c/f;->d:Landroid/support/v4/c/k;

    if-nez v1, :cond_0

    new-instance v1, Landroid/support/v4/c/k;

    invoke-direct {v1, v0}, Landroid/support/v4/c/k;-><init>(Landroid/support/v4/c/f;)V

    iput-object v1, v0, Landroid/support/v4/c/f;->d:Landroid/support/v4/c/k;

    :cond_0
    iget-object v0, v0, Landroid/support/v4/c/f;->d:Landroid/support/v4/c/k;

    return-object v0
.end method
