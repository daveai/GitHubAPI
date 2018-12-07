package com.qnet.githubapi.services;
import com.qnet.githubapi.pojo.GitHubRepoPojo;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;

public class GitHubAPIService {
    Retrofit retrofit;
    public GitHubAPIService(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
    public Call<List<GitHubRepoPojo>> getPublicRepo(){
        GitHubAPI gitHubAPI = retrofit.create(GitHubAPI.class);
        Call<List<GitHubRepoPojo>> call = gitHubAPI.getRepoFromRemote();
        return call;
    }
}
