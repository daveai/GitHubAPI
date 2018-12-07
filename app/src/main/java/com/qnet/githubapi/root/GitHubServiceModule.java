package com.qnet.githubapi.root;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qnet.githubapi.di.AppScope;
import com.qnet.githubapi.services.GitHubAPIService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class GitHubServiceModule {
    @Provides
    @AppScope
    GitHubAPIService provideGitHubAPIService(Retrofit retrofit){
        return new GitHubAPIService(retrofit);
    }
    @Provides
    @AppScope
    Gson provideGson(){
        return new GsonBuilder()
                .setLenient()
                .create();
    }
    @Provides
    @AppScope
    Retrofit provideRetrofit( Gson gson ){
        final String BASE_URL = "https://api.github.com/";
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
