.class public Lcom/adsdk/sdk/video/VAST$Ad$Wrapper;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "Wrapper"
.end annotation


# instance fields
.field VASTAdTagUri:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        name = "VASTAdTagURI"
    .end annotation
.end field

.field adSystem:Lcom/adsdk/sdk/video/VAST$Ad$AdSystem;
    .annotation runtime Lorg/simpleframework/xml/Element;
        name = "AdSystem"
    .end annotation
.end field

.field creatives:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adsdk/sdk/video/VAST$Ad$Creative;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        name = "Creatives"
        required = false
    .end annotation
.end field

.field error:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        name = "Error"
        required = false
    .end annotation
.end field

.field impressions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adsdk/sdk/video/VAST$Ad$Impression;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
