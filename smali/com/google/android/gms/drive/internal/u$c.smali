.class abstract Lcom/google/android/gms/drive/internal/u$c;
.super Lcom/google/android/gms/drive/internal/q;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/drive/internal/q",
        "<",
        "Lcom/google/android/gms/drive/DriveFolder$DriveFolderResult;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic Jf:Lcom/google/android/gms/drive/internal/u;


# direct methods
.method private constructor <init>(Lcom/google/android/gms/drive/internal/u;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/drive/internal/u$c;->Jf:Lcom/google/android/gms/drive/internal/u;

    invoke-direct {p0}, Lcom/google/android/gms/drive/internal/q;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gms/drive/internal/u;Lcom/google/android/gms/drive/internal/u$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/google/android/gms/drive/internal/u$c;-><init>(Lcom/google/android/gms/drive/internal/u;)V

    return-void
.end method


# virtual methods
.method public synthetic c(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/common/api/Result;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/google/android/gms/drive/internal/u$c;->t(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/drive/DriveFolder$DriveFolderResult;

    move-result-object v0

    return-object v0
.end method

.method public t(Lcom/google/android/gms/common/api/Status;)Lcom/google/android/gms/drive/DriveFolder$DriveFolderResult;
    .locals 2

    new-instance v0, Lcom/google/android/gms/drive/internal/u$e;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/google/android/gms/drive/internal/u$e;-><init>(Lcom/google/android/gms/common/api/Status;Lcom/google/android/gms/drive/DriveFolder;)V

    return-object v0
.end method
