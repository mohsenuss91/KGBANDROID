.class Lcom/millennialmedia/android/InlineVideoView$7;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/media/MediaPlayer$OnPreparedListener;


# instance fields
.field final synthetic this$0:Lcom/millennialmedia/android/InlineVideoView;


# direct methods
.method constructor <init>(Lcom/millennialmedia/android/InlineVideoView;)V
    .locals 0

    iput-object p1, p0, Lcom/millennialmedia/android/InlineVideoView$7;->this$0:Lcom/millennialmedia/android/InlineVideoView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPrepared(Landroid/media/MediaPlayer;)V
    .locals 2

    iget-object v0, p0, Lcom/millennialmedia/android/InlineVideoView$7;->this$0:Lcom/millennialmedia/android/InlineVideoView;

    iget-object v0, v0, Lcom/millennialmedia/android/InlineVideoView;->inlineParams:Lcom/millennialmedia/android/InlineVideoView$InlineParams;

    iget-boolean v0, v0, Lcom/millennialmedia/android/InlineVideoView$InlineParams;->autoPlay:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/millennialmedia/android/InlineVideoView$7;->this$0:Lcom/millennialmedia/android/InlineVideoView;

    #calls: Lcom/millennialmedia/android/InlineVideoView;->makeTransparent()V
    invoke-static {v0}, Lcom/millennialmedia/android/InlineVideoView;->access$400(Lcom/millennialmedia/android/InlineVideoView;)V

    :cond_0
    iget-object v0, p0, Lcom/millennialmedia/android/InlineVideoView$7;->this$0:Lcom/millennialmedia/android/InlineVideoView;

    iget-object v1, p0, Lcom/millennialmedia/android/InlineVideoView$7;->this$0:Lcom/millennialmedia/android/InlineVideoView;

    iget-object v1, v1, Lcom/millennialmedia/android/InlineVideoView;->inlineParams:Lcom/millennialmedia/android/InlineVideoView$InlineParams;

    iget v1, v1, Lcom/millennialmedia/android/InlineVideoView$InlineParams;->currentPosition:I

    invoke-virtual {v0, v1}, Lcom/millennialmedia/android/InlineVideoView;->seekTo(I)V

    iget-object v0, p0, Lcom/millennialmedia/android/InlineVideoView$7;->this$0:Lcom/millennialmedia/android/InlineVideoView;

    iget-object v0, v0, Lcom/millennialmedia/android/InlineVideoView;->inlineParams:Lcom/millennialmedia/android/InlineVideoView$InlineParams;

    iget-boolean v0, v0, Lcom/millennialmedia/android/InlineVideoView$InlineParams;->autoPlay:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/millennialmedia/android/InlineVideoView$7;->this$0:Lcom/millennialmedia/android/InlineVideoView;

    iget-object v0, v0, Lcom/millennialmedia/android/InlineVideoView;->inlineParams:Lcom/millennialmedia/android/InlineVideoView$InlineParams;

    iget-boolean v0, v0, Lcom/millennialmedia/android/InlineVideoView$InlineParams;->isInitialPlayBack:Z

    if-nez v0, :cond_2

    :cond_1
    iget-object v0, p0, Lcom/millennialmedia/android/InlineVideoView$7;->this$0:Lcom/millennialmedia/android/InlineVideoView;

    invoke-virtual {v0}, Lcom/millennialmedia/android/InlineVideoView;->getHeight()I

    :goto_0
    iget-object v0, p0, Lcom/millennialmedia/android/InlineVideoView$7;->this$0:Lcom/millennialmedia/android/InlineVideoView;

    iget-object v1, p0, Lcom/millennialmedia/android/InlineVideoView$7;->this$0:Lcom/millennialmedia/android/InlineVideoView;

    invoke-virtual {v1}, Lcom/millennialmedia/android/InlineVideoView;->getDuration()I

    move-result v1

    #setter for: Lcom/millennialmedia/android/InlineVideoView;->duration:I
    invoke-static {v0, v1}, Lcom/millennialmedia/android/InlineVideoView;->access$202(Lcom/millennialmedia/android/InlineVideoView;I)I

    return-void

    :cond_2
    iget-object v0, p0, Lcom/millennialmedia/android/InlineVideoView$7;->this$0:Lcom/millennialmedia/android/InlineVideoView;

    iget-object v0, v0, Lcom/millennialmedia/android/InlineVideoView;->inlineParams:Lcom/millennialmedia/android/InlineVideoView$InlineParams;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/millennialmedia/android/InlineVideoView$InlineParams;->isInitialPlayBack:Z

    goto :goto_0
.end method
