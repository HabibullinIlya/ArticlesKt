package com.gimba.handbookkt.controllers.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gimba.handbookkt.MyRetrofit;
import com.gimba.handbookkt.R;
import com.gimba.handbookkt.entity.Article;
import com.gimba.handbookkt.network.ArticlesApi;
import com.gimba.handbookkt.utils.OnItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gimba on 22.05.2018.
 */

public class ListArticleActivity extends AppCompatActivity implements ListContract.View{
    private List<Article> articles;
    private RecyclerView rv;
    ArticleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_article);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));

        //set fake data.

        fakeData();
        ListActivityPresenter presenter = new ListActivityPresenter(this,this);
        presenter.loadArticles();
    }

    private void fakeData(){
        articles = new ArrayList<>();
        articles.add(new Article("", "", ""));

    }
    @Override
    public void showArticles(@NotNull final List<Article> articles) {
        adapter = new ArticleAdapter(articles);
        rv.setAdapter(adapter);
        final List<Article> temp = articles;
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(ListArticleActivity.this,ArticleActivity.class);
                intent.putExtra("name",temp.get(position).getNameActicle());
                intent.putExtra("tags",temp.get(position).getTags());
                intent.putExtra("text",temp.get(position).getArticleText());
                startActivity(intent);
            }
        });
    }
}
