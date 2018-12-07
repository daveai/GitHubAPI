package com.qnet.githubapi.home;

import com.qnet.githubapi.di.ActivityScope;
import com.qnet.githubapi.services.DemoService;
import com.qnet.githubapi.services.FooService;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {
    @Provides
    @ActivityScope
    FooService provideFooService(DemoService demo){
        return new FooService(demo);
    }
}
