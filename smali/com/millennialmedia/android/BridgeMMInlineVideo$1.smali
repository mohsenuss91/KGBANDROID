.class Lcom/millennialmedia/android/BridgeMMInlineVideo$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Lcom/millennialmedia/android/MMJSResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/millennialmedia/android/BridgeMMInlineVideo;

.field final synthetic val$parameters:Ljava/util/HashMap;


# direct methods
.method constructor <init>(Lcom/millennialmedia/android/BridgeMMInlineVideo;Ljava/util/HashMap;)V
    .locals 0

    iput-object p1, p0, Lcom/millennialmedia/android/BridgeMMInlineVideo$1;->this$0:Lcom/millennialmedia/android/BridgeMMInlineVideo;

    iput-object p2, p0, Lcom/millennialmedia/android/BridgeMMInlineVideo$1;->val$parameters:Ljava/util/HashMap;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Lcom/millennialmedia/android/MMJSResponse;
    .locals 4

    iget-object v0, p0, Lcom/millennialmedia/android/BridgeMMInlineVideo$1;->this$0:Lcom/millennialmedia/android/BridgeMMInlineVideo;

    iget-object v0, v0, Lcom/millennialmedia/android/BridgeMMInlineVideo;->mmWebViewRef:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/millennialmedia/android/MMWebView;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/millennialmedia/android/MMWebView;->getMMLayout()Lcom/millennialmedia/android/MMLayout;

    move-result-object v1

    new-instance v2, Lcom/millennialmedia/android/InlineVideoView$InlineParams;

    iget-object v3, p0, Lcom/millennialmedia/android/BridgeMMInlineVideo$1;->val$parameters:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/millennialmedia/android/MMWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/millennialmedia/android/InlineVideoView$InlineParams;-><init>(Ljava/util/HashMap;Landroid/content/Context;)V

    invoke-virtual {v1, v2}, Lcom/millennialmedia/android/MMLayout;->initInlineVideo(Lcom/millennialmedia/android/InlineVideoView$InlineParams;)V

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "usingStreaming="

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/millennialmedia/android/MMLayout;->isVideoPlayingStreaming()Z

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/millennialmedia/android/MMJSResponse;->responseWithSuccess(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/millennialmedia/android/MMJSResponse;->responseWithError()Lcom/millennialmedia/android/MMJSResponse;

    move-result-object v0

    goto :goto_0
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/millennialmedia/android/BridgeMMInlineVideo$1;->call()Lcom/millennialmedia/android/MMJSResponse;

    move-result-object v0

    return-object v0
.end method
