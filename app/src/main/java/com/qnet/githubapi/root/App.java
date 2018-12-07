package com.qnet.githubapi.root;
import android.app.Application;
import com.qnet.githubapi.services.DemoService;
import com.qnet.githubapi.services.GitHubAPIService;
import com.qnet.githubapi.services.UpgradeService;
public class App extends Application {

    AppComponent appComponent;

    DemoService demo;

    UpgradeService upgrade;

    GitHubAPIService gitHubAPIService;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .gitHubServiceModule(new GitHubServiceModule())
                .build();
        demo = appComponent.getDemoService();
        upgrade = appComponent.getUpgradeService();
        gitHubAPIService = appComponent.getGitHubAPIService();

    }

    public DemoService getDemoService (){
        return demo;
    }

    public UpgradeService getUpgradeService() {
        return upgrade;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public GitHubAPIService getGitHubAPIService() {
        return gitHubAPIService;
    }
}
