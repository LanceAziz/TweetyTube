package com.example.tweetytube.features.supplementary.bottomBar;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavHostController;
import com.example.tweetytube.R;
import com.example.tweetytube.ui.theme.*;
import com.example.tweetytube.core.utils.Screen;
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic;
import com.exyte.animatednavbar.animation.indendshape.Height;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/example/tweetytube/features/supplementary/bottomBar/NavBarItems;", "", "icon", "", "navigation", "Lcom/example/tweetytube/core/utils/Screen;", "(Ljava/lang/String;IILcom/example/tweetytube/core/utils/Screen;)V", "getIcon", "()I", "getNavigation", "()Lcom/example/tweetytube/core/utils/Screen;", "Favourite", "Feed", "Profile", "app_debug"})
public enum NavBarItems {
    /*public static final*/ Favourite /* = new Favourite(0, null) */,
    /*public static final*/ Feed /* = new Feed(0, null) */,
    /*public static final*/ Profile /* = new Profile(0, null) */;
    private final int icon = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.example.tweetytube.core.utils.Screen navigation = null;
    
    NavBarItems(@androidx.annotation.DrawableRes()
    int icon, com.example.tweetytube.core.utils.Screen navigation) {
    }
    
    public final int getIcon() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.tweetytube.core.utils.Screen getNavigation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.example.tweetytube.features.supplementary.bottomBar.NavBarItems> getEntries() {
        return null;
    }
}