package com.qnet.githubapi.services;

import com.qnet.githubapi.pojo.GitHubRepoPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubAPI {
    @GET("repositories")
    Call<List<GitHubRepoPojo>> getRepoFromRemote();
}
