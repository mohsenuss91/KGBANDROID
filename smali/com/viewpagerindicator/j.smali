.class public final Lcom/viewpagerindicator/j;
.super Ljava/lang/Object;


# static fields
.field public static final CirclePageIndicator:[I = null

.field public static final CirclePageIndicator_android_background:I = 0x1

.field public static final CirclePageIndicator_android_orientation:I = 0x0

.field public static final CirclePageIndicator_centered:I = 0x2

.field public static final CirclePageIndicator_fillColor:I = 0x4

.field public static final CirclePageIndicator_gap:I = 0x7

.field public static final CirclePageIndicator_pageColor:I = 0x5

.field public static final CirclePageIndicator_radius:I = 0x6

.field public static final CirclePageIndicator_snap:I = 0x8

.field public static final CirclePageIndicator_strokeColor:I = 0x9

.field public static final CirclePageIndicator_strokeWidth:I = 0x3

.field public static final LinePageIndicator:[I = null

.field public static final LinePageIndicator_android_background:I = 0x0

.field public static final LinePageIndicator_centered:I = 0x1

.field public static final LinePageIndicator_gapWidth:I = 0x6

.field public static final LinePageIndicator_lineWidth:I = 0x5

.field public static final LinePageIndicator_selectedColor:I = 0x2

.field public static final LinePageIndicator_strokeWidth:I = 0x3

.field public static final LinePageIndicator_unselectedColor:I = 0x4

.field public static final TitlePageIndicator:[I = null

.field public static final TitlePageIndicator_android_background:I = 0x2

.field public static final TitlePageIndicator_android_textColor:I = 0x1

.field public static final TitlePageIndicator_android_textSize:I = 0x0

.field public static final TitlePageIndicator_clipPadding:I = 0x4

.field public static final TitlePageIndicator_footerColor:I = 0x5

.field public static final TitlePageIndicator_footerIndicatorHeight:I = 0x8

.field public static final TitlePageIndicator_footerIndicatorStyle:I = 0x7

.field public static final TitlePageIndicator_footerIndicatorUnderlinePadding:I = 0x9

.field public static final TitlePageIndicator_footerLineHeight:I = 0x6

.field public static final TitlePageIndicator_footerPadding:I = 0xa

.field public static final TitlePageIndicator_linePosition:I = 0xb

.field public static final TitlePageIndicator_selectedBold:I = 0xc

.field public static final TitlePageIndicator_selectedColor:I = 0x3

.field public static final TitlePageIndicator_titlePadding:I = 0xd

.field public static final TitlePageIndicator_topPadding:I = 0xe

.field public static final UnderlinePageIndicator:[I = null

.field public static final UnderlinePageIndicator_android_background:I = 0x0

.field public static final UnderlinePageIndicator_fadeDelay:I = 0x3

.field public static final UnderlinePageIndicator_fadeLength:I = 0x4

.field public static final UnderlinePageIndicator_fades:I = 0x2

.field public static final UnderlinePageIndicator_selectedColor:I = 0x1

.field public static final ViewPagerIndicator:[I = null

.field public static final ViewPagerIndicator_vpiCirclePageIndicatorStyle:I = 0x0

.field public static final ViewPagerIndicator_vpiIconPageIndicatorStyle:I = 0x1

.field public static final ViewPagerIndicator_vpiLinePageIndicatorStyle:I = 0x2

.field public static final ViewPagerIndicator_vpiTabPageIndicatorStyle:I = 0x4

.field public static final ViewPagerIndicator_vpiTitlePageIndicatorStyle:I = 0x3

.field public static final ViewPagerIndicator_vpiUnderlinePageIndicatorStyle:I = 0x5


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0xa

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/viewpagerindicator/j;->CirclePageIndicator:[I

    const/4 v0, 0x7

    new-array v0, v0, [I

    fill-array-data v0, :array_1

    sput-object v0, Lcom/viewpagerindicator/j;->LinePageIndicator:[I

    const/16 v0, 0xf

    new-array v0, v0, [I

    fill-array-data v0, :array_2

    sput-object v0, Lcom/viewpagerindicator/j;->TitlePageIndicator:[I

    const/4 v0, 0x5

    new-array v0, v0, [I

    fill-array-data v0, :array_3

    sput-object v0, Lcom/viewpagerindicator/j;->UnderlinePageIndicator:[I

    const/4 v0, 0x6

    new-array v0, v0, [I

    fill-array-data v0, :array_4

    sput-object v0, Lcom/viewpagerindicator/j;->ViewPagerIndicator:[I

    return-void

    nop

    :array_0
    .array-data 0x4
        0xc4t 0x0t 0x1t 0x1t
        0xd4t 0x0t 0x1t 0x1t
        0xc0t 0x0t 0x1t 0x7ft
        0xc2t 0x0t 0x1t 0x7ft
        0xc4t 0x0t 0x1t 0x7ft
        0xc5t 0x0t 0x1t 0x7ft
        0xc6t 0x0t 0x1t 0x7ft
        0xc7t 0x0t 0x1t 0x7ft
        0xc8t 0x0t 0x1t 0x7ft
        0xc9t 0x0t 0x1t 0x7ft
    .end array-data

    :array_1
    .array-data 0x4
        0xd4t 0x0t 0x1t 0x1t
        0xc0t 0x0t 0x1t 0x7ft
        0xc1t 0x0t 0x1t 0x7ft
        0xc2t 0x0t 0x1t 0x7ft
        0xc3t 0x0t 0x1t 0x7ft
        0xcat 0x0t 0x1t 0x7ft
        0xcbt 0x0t 0x1t 0x7ft
    .end array-data

    :array_2
    .array-data 0x4
        0x95t 0x0t 0x1t 0x1t
        0x98t 0x0t 0x1t 0x1t
        0xd4t 0x0t 0x1t 0x1t
        0xc1t 0x0t 0x1t 0x7ft
        0xcct 0x0t 0x1t 0x7ft
        0xcdt 0x0t 0x1t 0x7ft
        0xcet 0x0t 0x1t 0x7ft
        0xcft 0x0t 0x1t 0x7ft
        0xd0t 0x0t 0x1t 0x7ft
        0xd1t 0x0t 0x1t 0x7ft
        0xd2t 0x0t 0x1t 0x7ft
        0xd3t 0x0t 0x1t 0x7ft
        0xd4t 0x0t 0x1t 0x7ft
        0xd5t 0x0t 0x1t 0x7ft
        0xd6t 0x0t 0x1t 0x7ft
    .end array-data

    :array_3
    .array-data 0x4
        0xd4t 0x0t 0x1t 0x1t
        0xc1t 0x0t 0x1t 0x7ft
        0xd7t 0x0t 0x1t 0x7ft
        0xd8t 0x0t 0x1t 0x7ft
        0xd9t 0x0t 0x1t 0x7ft
    .end array-data

    :array_4
    .array-data 0x4
        0xbat 0x0t 0x1t 0x7ft
        0xbbt 0x0t 0x1t 0x7ft
        0xbct 0x0t 0x1t 0x7ft
        0xbdt 0x0t 0x1t 0x7ft
        0xbet 0x0t 0x1t 0x7ft
        0xbft 0x0t 0x1t 0x7ft
    .end array-data
.end method
