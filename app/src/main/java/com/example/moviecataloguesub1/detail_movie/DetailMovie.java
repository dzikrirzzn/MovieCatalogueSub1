package com.example.moviecataloguesub1.detail_movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviecataloguesub1.R;
import com.example.moviecataloguesub1.list_movie.ListMovie;
import com.example.moviecataloguesub1.list_movie.MovieModel;

public class DetailMovie extends AppCompatActivity {
    private TextView tvTitle, tvOverview;
    private ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tv_txt_overview);
        imgPoster = findViewById(R.id.img_poster);
        MovieModel movieModel = getIntent().getParcelableExtra(ListMovie.SELECTED_MOVIE);
        tvTitle.setText(movieModel.getTitle());
        tvOverview.setText(movieModel.getOverview());
        imgPoster.setImageResource(movieModel.getPoster());
        setTitle(movieModel.getTitle());
    }
}
