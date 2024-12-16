package com.example.tweetytube.features.details.domain.repo;

import com.example.tweetytube.core.utils.Resource;
import com.example.tweetytube.features.details.domain.model.Credits;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/tweetytube/features/details/domain/repo/CreditsRepo;", "", "getCredits", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/tweetytube/core/utils/Resource;", "", "Lcom/example/tweetytube/features/details/domain/model/Credits;", "movieId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CreditsRepo {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCredits(int movieId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.tweetytube.core.utils.Resource<java.util.List<com.example.tweetytube.features.details.domain.model.Credits>>>> $completion);
}