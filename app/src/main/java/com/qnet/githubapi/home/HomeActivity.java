package com.qnet.githubapi.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.qnet.githubapi.R;
import com.qnet.githubapi.pojo.GitHubRepoPojo;
import com.qnet.githubapi.root.App;
import com.qnet.githubapi.services.DemoService;
import com.qnet.githubapi.services.FooService;
import com.qnet.githubapi.services.GitHubAPIService;
import com.qnet.githubapi.services.UpgradeService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    @Inject
    FooService fooService;

    @Inject
    SimpleAdapterService simpleAdapterService;

    ListView reposListView;

    List<String> reposArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeComponent homeComponent = DaggerHomeComponent.builder()
                .homeModule(new HomeModule())
                .simpleAdapterServiceModule(new SimpleAdapterServiceModule(this))
                .appComponent(((App)getApplication()).getAppComponent())
                .build();

        homeComponent.inject(this);

        App app = (App) getApplication();

        reposListView = (ListView) findViewById(R.id.reposListView);

        reposArray = new ArrayList<String>();



        GitHubAPIService gitHubAPIService = app.getGitHubAPIService();





        gitHubAPIService.getPublicRepo().enqueue(new Callback<List<GitHubRepoPojo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepoPojo>> call, Response<List<GitHubRepoPojo>> response) {
                if (response.isSuccessful()) {
                    for (GitHubRepoPojo repo : response.body()) {
                        Log.i("Retrofit output", repo.getFullName());
                        reposArray.add(repo.getName());
                        simpleAdapterService.setItems(reposArray);
                        ArrayAdapter<String> adapter = simpleAdapterService.getSimpleAdapter();
                        reposListView.setAdapter(adapter);
                    }
                } else {
                    System.out.println("Retrofit error" + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepoPojo>> call, Throwable t) {

            }
        });




        Toast.makeText(this, fooService.getDemo().getMsg(), Toast.LENGTH_SHORT).show();
    }
}
