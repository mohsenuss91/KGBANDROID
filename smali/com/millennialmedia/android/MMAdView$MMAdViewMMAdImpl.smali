.class Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;
.super Lcom/millennialmedia/android/MMLayout$MMLayoutMMAdImpl;


# instance fields
.field final synthetic this$0:Lcom/millennialmedia/android/MMAdView;


# direct methods
.method public constructor <init>(Lcom/millennialmedia/android/MMAdView;Landroid/content/Context;)V
    .locals 1

    iput-object p1, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->this$0:Lcom/millennialmedia/android/MMAdView;

    invoke-direct {p0, p1, p2}, Lcom/millennialmedia/android/MMLayout$MMLayoutMMAdImpl;-><init>(Lcom/millennialmedia/android/MMLayout;Landroid/content/Context;)V

    new-instance v0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl$1;

    invoke-direct {v0, p0, p1}, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl$1;-><init>(Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;Lcom/millennialmedia/android/MMAdView;)V

    iput-object v0, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->mmWebViewClientListener:Lcom/millennialmedia/android/MMWebViewClient$MMWebViewClientListener;

    return-void
.end method


# virtual methods
.method animateTransition()V
    .locals 1

    iget-object v0, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->this$0:Lcom/millennialmedia/android/MMAdView;

    iget-object v0, v0, Lcom/millennialmedia/android/MMAdView;->refreshAnimationimageView:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl$2;

    invoke-direct {v0, p0}, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl$2;-><init>(Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;)V

    invoke-static {v0}, Lcom/millennialmedia/android/MMSDK;->runOnUiThread(Ljava/lang/Runnable;)V

    :cond_0
    return-void
.end method

.method getReqType()Ljava/lang/String;
    .locals 1

    const-string v0, "getad"

    return-object v0
.end method

.method getRequestCompletedAction()Ljava/lang/String;
    .locals 1

    const-string v0, "millennialmedia.action.ACTION_GETAD_SUCCEEDED"

    return-object v0
.end method

.method getRequestFailedAction()Ljava/lang/String;
    .locals 1

    const-string v0, "millennialmedia.action.ACTION_GETAD_FAILED"

    return-object v0
.end method

.method public hasCachedVideoSupport()Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method insertUrlAdMetaValues(Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->this$0:Lcom/millennialmedia/android/MMAdView;

    iget v0, v0, Lcom/millennialmedia/android/MMAdView;->height:I

    if-lez v0, :cond_0

    const-string v0, "hsht"

    iget-object v1, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->this$0:Lcom/millennialmedia/android/MMAdView;

    iget v1, v1, Lcom/millennialmedia/android/MMAdView;->height:I

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    iget-object v0, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->this$0:Lcom/millennialmedia/android/MMAdView;

    iget v0, v0, Lcom/millennialmedia/android/MMAdView;->width:I

    if-lez v0, :cond_1

    const-string v0, "hswd"

    iget-object v1, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->this$0:Lcom/millennialmedia/android/MMAdView;

    iget v1, v1, Lcom/millennialmedia/android/MMAdView;->width:I

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    invoke-super {p0, p1}, Lcom/millennialmedia/android/MMLayout$MMLayoutMMAdImpl;->insertUrlAdMetaValues(Ljava/util/Map;)V

    return-void
.end method

.method public isBanner()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method isLifecycleObservable()Z
    .locals 1

    iget-object v0, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->this$0:Lcom/millennialmedia/android/MMAdView;

    invoke-virtual {v0}, Lcom/millennialmedia/android/MMAdView;->getWindowToken()Landroid/os/IBinder;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method isTransitionAnimated()Z
    .locals 1

    iget-object v0, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->this$0:Lcom/millennialmedia/android/MMAdView;

    iget v0, v0, Lcom/millennialmedia/android/MMAdView;->transitionType:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method prepareTransition(Landroid/graphics/Bitmap;)V
    .locals 2

    iget-object v0, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->this$0:Lcom/millennialmedia/android/MMAdView;

    iget-object v0, v0, Lcom/millennialmedia/android/MMAdView;->refreshAnimationimageView:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    iget-object v0, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->this$0:Lcom/millennialmedia/android/MMAdView;

    iget-object v0, v0, Lcom/millennialmedia/android/MMAdView;->refreshAnimationimageView:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    iget-object v0, p0, Lcom/millennialmedia/android/MMAdView$MMAdViewMMAdImpl;->this$0:Lcom/millennialmedia/android/MMAdView;

    iget-object v0, v0, Lcom/millennialmedia/android/MMAdView;->refreshAnimationimageView:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->bringToFront()V

    return-void
.end method
