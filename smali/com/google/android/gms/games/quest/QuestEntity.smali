.class public final Lcom/google/android/gms/games/quest/QuestEntity;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;
.implements Lcom/google/android/gms/games/quest/Quest;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/games/quest/QuestEntityCreator;


# instance fields
.field private final AQ:I

.field private final Mm:Ljava/lang/String;

.field private final Rq:Lcom/google/android/gms/games/GameEntity;

.field private final TM:Ljava/lang/String;

.field private final TN:J

.field private final TO:Landroid/net/Uri;

.field private final TP:Ljava/lang/String;

.field private final TQ:J

.field private final TR:Landroid/net/Uri;

.field private final TS:Ljava/lang/String;

.field private final TT:J

.field private final TU:J

.field private final TV:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/games/quest/MilestoneEntity;",
            ">;"
        }
    .end annotation
.end field

.field private final Ty:J

.field private final mName:Ljava/lang/String;

.field private final mState:I

.field private final xJ:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/games/quest/QuestEntityCreator;

    invoke-direct {v0}, Lcom/google/android/gms/games/quest/QuestEntityCreator;-><init>()V

    sput-object v0, Lcom/google/android/gms/games/quest/QuestEntity;->CREATOR:Lcom/google/android/gms/games/quest/QuestEntityCreator;

    return-void
.end method

.method constructor <init>(ILcom/google/android/gms/games/GameEntity;Ljava/lang/String;JLandroid/net/Uri;Ljava/lang/String;Ljava/lang/String;JJLandroid/net/Uri;Ljava/lang/String;Ljava/lang/String;JJIILjava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/google/android/gms/games/GameEntity;",
            "Ljava/lang/String;",
            "J",
            "Landroid/net/Uri;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "JJ",
            "Landroid/net/Uri;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "JJII",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/games/quest/MilestoneEntity;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/games/quest/QuestEntity;->xJ:I

    iput-object p2, p0, Lcom/google/android/gms/games/quest/QuestEntity;->Rq:Lcom/google/android/gms/games/GameEntity;

    iput-object p3, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TM:Ljava/lang/String;

    iput-wide p4, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TN:J

    iput-object p6, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TO:Landroid/net/Uri;

    iput-object p7, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TP:Ljava/lang/String;

    iput-object p8, p0, Lcom/google/android/gms/games/quest/QuestEntity;->Mm:Ljava/lang/String;

    iput-wide p9, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TQ:J

    iput-wide p11, p0, Lcom/google/android/gms/games/quest/QuestEntity;->Ty:J

    iput-object p13, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TR:Landroid/net/Uri;

    move-object/from16 v0, p14

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TS:Ljava/lang/String;

    move-object/from16 v0, p15

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->mName:Ljava/lang/String;

    move-wide/from16 v0, p16

    iput-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TT:J

    move-wide/from16 v0, p18

    iput-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TU:J

    move/from16 v0, p20

    iput v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->mState:I

    move/from16 v0, p21

    iput v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->AQ:I

    move-object/from16 v0, p22

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TV:Ljava/util/ArrayList;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/games/quest/Quest;)V
    .locals 5

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x2

    iput v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->xJ:I

    new-instance v0, Lcom/google/android/gms/games/GameEntity;

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getGame()Lcom/google/android/gms/games/Game;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/android/gms/games/GameEntity;-><init>(Lcom/google/android/gms/games/Game;)V

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->Rq:Lcom/google/android/gms/games/GameEntity;

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getQuestId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TM:Ljava/lang/String;

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getAcceptedTimestamp()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TN:J

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getDescription()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->Mm:Ljava/lang/String;

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getBannerImageUri()Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TO:Landroid/net/Uri;

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getBannerImageUrl()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TP:Ljava/lang/String;

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getEndTimestamp()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TQ:J

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getIconImageUri()Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TR:Landroid/net/Uri;

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getIconImageUrl()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TS:Ljava/lang/String;

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getLastUpdatedTimestamp()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->Ty:J

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->mName:Ljava/lang/String;

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->iF()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TT:J

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getStartTimestamp()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TU:J

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getState()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->mState:I

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getType()I

    move-result v0

    iput v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->AQ:I

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->iE()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v3}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TV:Ljava/util/ArrayList;

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_0

    iget-object v4, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TV:Ljava/util/ArrayList;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/games/quest/Milestone;

    invoke-interface {v0}, Lcom/google/android/gms/games/quest/Milestone;->freeze()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/games/quest/MilestoneEntity;

    check-cast v0, Lcom/google/android/gms/games/quest/MilestoneEntity;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_0
    return-void
.end method

.method static a(Lcom/google/android/gms/games/quest/Quest;)I
    .locals 4

    const/16 v0, 0xd

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getGame()Lcom/google/android/gms/games/Game;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getQuestId()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getAcceptedTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x3

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getBannerImageUri()Landroid/net/Uri;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x4

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getDescription()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x5

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getEndTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x6

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getIconImageUri()Landroid/net/Uri;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x7

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getLastUpdatedTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/16 v1, 0x8

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->iE()Ljava/util/List;

    move-result-object v2

    aput-object v2, v0, v1

    const/16 v1, 0x9

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getName()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    const/16 v1, 0xa

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->iF()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/16 v1, 0xb

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getStartTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/16 v1, 0xc

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getState()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/android/gms/internal/hl;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method static a(Lcom/google/android/gms/games/quest/Quest;Ljava/lang/Object;)Z
    .locals 5

    const/4 v1, 0x1

    const/4 v0, 0x0

    instance-of v2, p1, Lcom/google/android/gms/games/quest/Quest;

    if-nez v2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    if-ne p0, p1, :cond_2

    move v0, v1

    goto :goto_0

    :cond_2
    check-cast p1, Lcom/google/android/gms/games/quest/Quest;

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getGame()Lcom/google/android/gms/games/Game;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getGame()Lcom/google/android/gms/games/Game;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getQuestId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getQuestId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getAcceptedTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getAcceptedTimestamp()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getBannerImageUri()Landroid/net/Uri;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getBannerImageUri()Landroid/net/Uri;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getDescription()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getDescription()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getEndTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getEndTimestamp()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getIconImageUri()Landroid/net/Uri;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getIconImageUri()Landroid/net/Uri;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getLastUpdatedTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getLastUpdatedTimestamp()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->iE()Ljava/util/List;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->iE()Ljava/util/List;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->iF()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->iF()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getStartTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getStartTimestamp()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {p1}, Lcom/google/android/gms/games/quest/Quest;->getState()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getState()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/android/gms/internal/hl;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    move v0, v1

    goto/16 :goto_0
.end method

.method static b(Lcom/google/android/gms/games/quest/Quest;)Ljava/lang/String;
    .locals 4

    invoke-static {p0}, Lcom/google/android/gms/internal/hl;->e(Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "Game"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getGame()Lcom/google/android/gms/games/Game;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "QuestId"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getQuestId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "AcceptedTimestamp"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getAcceptedTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "BannerImageUri"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getBannerImageUri()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "BannerImageUrl"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getBannerImageUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "Description"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "EndTimestamp"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getEndTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "IconImageUri"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getIconImageUri()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "IconImageUrl"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getIconImageUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "LastUpdatedTimestamp"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getLastUpdatedTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "Milestones"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->iE()Ljava/util/List;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "Name"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "NotifyTimestamp"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->iF()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "StartTimestamp"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getStartTimestamp()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    const-string v1, "State"

    invoke-interface {p0}, Lcom/google/android/gms/games/quest/Quest;->getState()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/internal/hl$a;->a(Ljava/lang/String;Ljava/lang/Object;)Lcom/google/android/gms/internal/hl$a;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/internal/hl$a;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public final describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 1

    invoke-static {p0, p1}, Lcom/google/android/gms/games/quest/QuestEntity;->a(Lcom/google/android/gms/games/quest/Quest;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final freeze()Lcom/google/android/gms/games/quest/Quest;
    .locals 0

    return-object p0
.end method

.method public final bridge synthetic freeze()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/google/android/gms/games/quest/QuestEntity;->freeze()Lcom/google/android/gms/games/quest/Quest;

    move-result-object v0

    return-object v0
.end method

.method public final getAcceptedTimestamp()J
    .locals 2

    iget-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TN:J

    return-wide v0
.end method

.method public final getBannerImageUri()Landroid/net/Uri;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TO:Landroid/net/Uri;

    return-object v0
.end method

.method public final getBannerImageUrl()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TP:Ljava/lang/String;

    return-object v0
.end method

.method public final getCurrentMilestone()Lcom/google/android/gms/games/quest/Milestone;
    .locals 2

    invoke-virtual {p0}, Lcom/google/android/gms/games/quest/QuestEntity;->iE()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/games/quest/Milestone;

    return-object v0
.end method

.method public final getDescription()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->Mm:Ljava/lang/String;

    return-object v0
.end method

.method public final getDescription(Landroid/database/CharArrayBuffer;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->Mm:Ljava/lang/String;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/il;->b(Ljava/lang/String;Landroid/database/CharArrayBuffer;)V

    return-void
.end method

.method public final getEndTimestamp()J
    .locals 2

    iget-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TQ:J

    return-wide v0
.end method

.method public final getGame()Lcom/google/android/gms/games/Game;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->Rq:Lcom/google/android/gms/games/GameEntity;

    return-object v0
.end method

.method public final getIconImageUri()Landroid/net/Uri;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TR:Landroid/net/Uri;

    return-object v0
.end method

.method public final getIconImageUrl()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TS:Ljava/lang/String;

    return-object v0
.end method

.method public final getLastUpdatedTimestamp()J
    .locals 2

    iget-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->Ty:J

    return-wide v0
.end method

.method public final getName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public final getName(Landroid/database/CharArrayBuffer;)V
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->mName:Ljava/lang/String;

    invoke-static {v0, p1}, Lcom/google/android/gms/internal/il;->b(Ljava/lang/String;Landroid/database/CharArrayBuffer;)V

    return-void
.end method

.method public final getQuestId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TM:Ljava/lang/String;

    return-object v0
.end method

.method public final getStartTimestamp()J
    .locals 2

    iget-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TU:J

    return-wide v0
.end method

.method public final getState()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->mState:I

    return v0
.end method

.method public final getType()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->AQ:I

    return v0
.end method

.method public final getVersionCode()I
    .locals 1

    iget v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->xJ:I

    return v0
.end method

.method public final hashCode()I
    .locals 1

    invoke-static {p0}, Lcom/google/android/gms/games/quest/QuestEntity;->a(Lcom/google/android/gms/games/quest/Quest;)I

    move-result v0

    return v0
.end method

.method public final iE()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gms/games/quest/Milestone;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TV:Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method

.method public final iF()J
    .locals 2

    iget-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TT:J

    return-wide v0
.end method

.method public final isDataValid()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public final isEndingSoon()Z
    .locals 6

    iget-wide v0, p0, Lcom/google/android/gms/games/quest/QuestEntity;->TT:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/32 v4, 0x1b7740

    add-long/2addr v2, v4

    cmp-long v0, v0, v2

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final toString()Ljava/lang/String;
    .locals 1

    invoke-static {p0}, Lcom/google/android/gms/games/quest/QuestEntity;->b(Lcom/google/android/gms/games/quest/Quest;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/games/quest/QuestEntityCreator;->a(Lcom/google/android/gms/games/quest/QuestEntity;Landroid/os/Parcel;I)V

    return-void
.end method
