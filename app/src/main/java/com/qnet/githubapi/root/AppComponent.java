package com.qnet.githubapi.root;
import android.app.Application;

import com.qnet.githubapi.di.AppScope;
import com.qnet.githubapi.services.DemoService;
import com.qnet.githubapi.services.GitHubAPIService;
import com.qnet.githubapi.services.UpgradeService;
import dagger.Component;
@Component(modules = {AppModule.class, GitHubServiceModule.class})
@AppScope
public interface AppComponent {
    DemoService getDemoService();
    UpgradeService getUpgradeService();
    GitHubAPIService getGitHubAPIService();
}
