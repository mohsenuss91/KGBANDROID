.class Lcom/google/android/gms/games/internal/api/SnapshotsImpl$5;
.super Lcom/google/android/gms/games/internal/api/SnapshotsImpl$OpenImpl;


# instance fields
.field final synthetic IJ:Lcom/google/android/gms/drive/Contents;

.field final synthetic QF:Lcom/google/android/gms/games/internal/api/SnapshotsImpl;

.field final synthetic QJ:Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange;

.field final synthetic QL:Ljava/lang/String;

.field final synthetic QM:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/google/android/gms/games/internal/api/SnapshotsImpl;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange;Lcom/google/android/gms/drive/Contents;)V
    .locals 1

    iput-object p1, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$5;->QF:Lcom/google/android/gms/games/internal/api/SnapshotsImpl;

    iput-object p2, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$5;->QL:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$5;->QM:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$5;->QJ:Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange;

    iput-object p5, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$5;->IJ:Lcom/google/android/gms/drive/Contents;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$OpenImpl;-><init>(Lcom/google/android/gms/games/internal/api/SnapshotsImpl$1;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic a(Lcom/google/android/gms/common/api/Api$a;)V
    .locals 0

    check-cast p1, Lcom/google/android/gms/games/internal/GamesClientImpl;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$5;->a(Lcom/google/android/gms/games/internal/GamesClientImpl;)V

    return-void
.end method

.method protected a(Lcom/google/android/gms/games/internal/GamesClientImpl;)V
    .locals 6

    iget-object v2, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$5;->QL:Ljava/lang/String;

    iget-object v3, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$5;->QM:Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$5;->QJ:Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange;

    iget-object v5, p0, Lcom/google/android/gms/games/internal/api/SnapshotsImpl$5;->IJ:Lcom/google/android/gms/drive/Contents;

    move-object v0, p1

    move-object v1, p0

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gms/games/internal/GamesClientImpl;->a(Lcom/google/android/gms/common/api/a$d;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/games/snapshot/SnapshotMetadataChange;Lcom/google/android/gms/drive/Contents;)V

    return-void
.end method
