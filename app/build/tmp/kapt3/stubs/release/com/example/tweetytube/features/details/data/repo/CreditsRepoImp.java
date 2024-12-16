package com.example.tweetytube.features.details.data.repo;

import android.util.Log;
import com.example.tweetytube.core.utils.Resource;
import com.example.tweetytube.features.details.data.local.CreditsDatabase;
import com.example.tweetytube.features.details.data.remote.CreditsApi;
import com.example.tweetytube.features.details.domain.model.Credits;
import com.example.tweetytube.features.details.domain.repo.CreditsRepo;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/tweetytube/features/details/data/repo/CreditsRepoImp;", "Lcom/example/tweetytube/features/details/domain/repo/CreditsRepo;", "creditsApi", "Lcom/example/tweetytube/features/details/data/remote/CreditsApi;", "creditsDatabase", "Lcom/example/tweetytube/features/details/data/local/CreditsDatabase;", "(Lcom/example/tweetytube/features/details/data/remote/CreditsApi;Lcom/example/tweetytube/features/details/data/local/CreditsDatabase;)V", "getCredits", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/tweetytube/core/utils/Resource;", "", "Lcom/example/tweetytube/features/details/domain/model/Credits;", "movieId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class CreditsRepoImp implements com.example.tweetytube.features.details.domain.repo.CreditsRepo {
    @org.jetbrains.annotations.NotNull()
    private final com.example.tweetytube.features.details.data.remote.CreditsApi creditsApi = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.tweetytube.features.details.data.local.CreditsDatabase creditsDatabase = null;
    
    @javax.inject.Inject()
    public CreditsRepoImp(@org.jetbrains.annotations.NotNull()
    com.example.tweetytube.features.details.data.remote.CreditsApi creditsApi, @org.jetbrains.annotations.NotNull()
    com.example.tweetytube.features.details.data.local.CreditsDatabase creditsDatabase) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCredits(int movieId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.tweetytube.core.utils.Resource<java.util.List<com.example.tweetytube.features.details.domain.model.Credits>>>> $completion) {
        return null;
    }
}