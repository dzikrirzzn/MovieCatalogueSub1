package com.example.moviecataloguesub1.list_movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.moviecataloguesub1.R;
import com.example.moviecataloguesub1.detail_movie.DetailMovie;

import java.util.ArrayList;

public class ListMovie extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListMovieAdapter mAdapter;

    private ArrayList<MovieModel> modelList = new ArrayList<>();
    public static final String SELECTED_MOVIE = "selected_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        findViews();
        setAdapter();
    }

    private void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void setAdapter() {


        modelList.add(new MovieModel(getResources().getString(R.string.title_a_star), getString(R.string.overview_a_star), R.drawable.poster_a_star));
        modelList.add(new MovieModel(getResources().getString(R.string.title_aquaman), getString(R.string.overview_aquaman), R.drawable.poster_aquaman));
        modelList.add(new MovieModel(getResources().getString(R.string.title_avengerinfinity), getString(R.string.overview_avengerinvinity), R.drawable.poster_avengerinfinity));
        modelList.add(new MovieModel(getResources().getString(R.string.title_bohemian), getString(R.string.overview_bohemian), R.drawable.poster_bohemian));
        modelList.add(new MovieModel(getResources().getString(R.string.title_deadpool), getString(R.string.overview_deadpool), R.drawable.dp));
        modelList.add(new MovieModel(getResources().getString(R.string.title_spiderman), getString(R.string.overview_spiderman), R.drawable.poster_spiderman));
        modelList.add(new MovieModel(getResources().getString(R.string.title_mortalengine), getString(R.string.overview_mortalengine), R.drawable.poster_mortalengine));
        modelList.add(new MovieModel(getResources().getString(R.string.title_venom), getString(R.string.overview_venom), R.drawable.poster_venom));
        modelList.add(new MovieModel(getResources().getString(R.string.title_preman), getString(R.string.overview_preman), R.drawable.poster_preman));
        modelList.add(new MovieModel(getResources().getString(R.string.title_bumblebee), getString(R.string.overview_bumbleee), R.drawable.poster_bumblebee));
        modelList.add(new MovieModel(getResources().getString(R.string.title_solo), getString(R.string.overview_solo), R.drawable.solo));
        modelList.add(new MovieModel(getResources().getString(R.string.title_joker), getString(R.string.overview_joker), R.drawable.joker));
        modelList.add(new MovieModel(getResources().getString(R.string.title_SpidermanFFH), getString(R.string.overview_spdffh), R.drawable.ffh));


        mAdapter = new ListMovieAdapter(ListMovie.this, modelList);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new ListMovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, MovieModel model) {
                Intent goToDetailMovie = new Intent(ListMovie.this, DetailMovie.class);
                goToDetailMovie.putExtra(ListMovie.SELECTED_MOVIE, model);
                startActivity(goToDetailMovie);
            }
        });


    }
}
