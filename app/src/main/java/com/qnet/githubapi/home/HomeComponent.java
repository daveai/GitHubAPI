package com.qnet.githubapi.home;

import com.qnet.githubapi.di.ActivityScope;
import com.qnet.githubapi.root.AppComponent;
import com.qnet.githubapi.services.FooService;

import dagger.Component;

@Component(modules = {HomeModule.class, SimpleAdapterServiceModule.class}, dependencies = {AppComponent.class})
@ActivityScope
public interface HomeComponent {
    void inject(HomeActivity target);
}
