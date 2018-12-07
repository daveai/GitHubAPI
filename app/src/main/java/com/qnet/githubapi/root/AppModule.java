package com.qnet.githubapi.root;

import com.qnet.githubapi.di.AppScope;
import com.qnet.githubapi.services.DemoService;
import com.qnet.githubapi.services.UpgradeService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @AppScope
    DemoService provideDemoService(){
        return new DemoService("Default msg");
    }
    @Provides
    @AppScope
    UpgradeService provideUpgradeService(DemoService demo){
        return new UpgradeService("1.0.0", demo);
    }

}
