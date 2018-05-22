package com.gimba.handbookkt.database;


import android.content.ContentValues;
import android.content.Context;

import com.gimba.handbookkt.controllers.main.ListContract;
import com.gimba.handbookkt.entity.Article;

import org.jetbrains.annotations.Nullable;

import java.util.List;


public class ArticleController implements ListContract.Model {
    Context contenxt;
    SqliteHelper sqliteHelper;
    public ArticleController(Context contenxt){
        this.contenxt = contenxt;
        sqliteHelper  = new SqliteHelper(contenxt);
    }
    public Article getArticle(String name){
        return sqliteHelper.getArticle(name);
    }


    public boolean saveArticleData(Article article){
        ContentValues cv = new ContentValues();
        cv.put(ArticleTable.COL_NAME_ARTICLE,article.getNameActicle());
        cv.put(ArticleTable.COL_TAGS_ARTICLE,article.getTags());
        cv.put(ArticleTable.COL_TEXT,article.getArticleText());
        return sqliteHelper.insertArticle(ArticleTable.TABLE_NAME,cv);
    }

    @Nullable
    @Override
    public List<Article> loadFromNet() {
        return null;
    }


    @Nullable
    @Override
    public List<Article> loadAllArticles() {
        return sqliteHelper.getAllArticle();
    }
}

