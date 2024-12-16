package com.example.tweetytube.features.details.data.remote;

import com.example.tweetytube.features.details.data.remote.response.CreditsDto;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/tweetytube/features/details/data/remote/CreditsApi;", "", "getCredits", "Lcom/example/tweetytube/features/details/data/remote/response/CreditsDto;", "movieId", "", "apiKey", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface CreditsApi {
    
    @retrofit2.http.GET(value = "movie/{movieId}/credits")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCredits(@retrofit2.http.Path(value = "movieId")
    int movieId, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.tweetytube.features.details.data.remote.response.CreditsDto> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}