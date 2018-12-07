package com.qnet.githubapi.home;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class SimpleAdapterServiceModule {
    Context context;

    public SimpleAdapterServiceModule(Context context) {
        this.context = context;
    }

    @Provides
    public SimpleAdapterService provideSimpleAdapter(){
        return new SimpleAdapterService(this.context);
    }
}
