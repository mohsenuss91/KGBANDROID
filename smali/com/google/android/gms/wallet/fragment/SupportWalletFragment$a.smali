.class Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$a;
.super Lcom/google/android/gms/internal/lm$a;


# instance fields
.field private akm:Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$OnStateChangedListener;

.field private final akn:Lcom/google/android/gms/wallet/fragment/SupportWalletFragment;


# direct methods
.method constructor <init>(Lcom/google/android/gms/wallet/fragment/SupportWalletFragment;)V
    .locals 0

    invoke-direct {p0}, Lcom/google/android/gms/internal/lm$a;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$a;->akn:Lcom/google/android/gms/wallet/fragment/SupportWalletFragment;

    return-void
.end method


# virtual methods
.method public a(IILandroid/os/Bundle;)V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$a;->akm:Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$OnStateChangedListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$a;->akm:Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$OnStateChangedListener;

    iget-object v1, p0, Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$a;->akn:Lcom/google/android/gms/wallet/fragment/SupportWalletFragment;

    invoke-interface {v0, v1, p1, p2, p3}, Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$OnStateChangedListener;->onStateChanged(Lcom/google/android/gms/wallet/fragment/SupportWalletFragment;IILandroid/os/Bundle;)V

    :cond_0
    return-void
.end method

.method public a(Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$OnStateChangedListener;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$a;->akm:Lcom/google/android/gms/wallet/fragment/SupportWalletFragment$OnStateChangedListener;

    return-void
.end method
