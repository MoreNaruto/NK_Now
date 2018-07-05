package ao.now.nk.nk_now_app.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ao.now.nk.nk_now_app.R;
import it.chengdazhi.decentbanner.DecentBanner;

public class FilmFragment extends Fragment {
    public static final String TAG = FilmFragment.class.getSimpleName();
    private DecentBanner newFilmsBanner;
    private DecentBanner trendingFilmsBanner;
    private List<View> newFilmsBannerListViews;
    private List<View> trendingFilmsBannerListViews;
    private List<String> newFilmsBannerListTitles;
    private List<String> trendingFilmsBannerListTitles;

    public static FilmFragment newInstance() {
        Bundle args = new Bundle();

        FilmFragment fragment = new FilmFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_film_page, container, false);
        
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        newFilmsBanner = getActivity().findViewById(R.id.new_films_banner);
        trendingFilmsBanner = getActivity().findViewById(R.id.trending_films_banner);

        View featuredFilmOne = getActivity().getLayoutInflater().inflate(R.layout.featured_film_1, null);
        View featuredFilmTwo = getActivity().getLayoutInflater().inflate(R.layout.featured_film_2, null);
        View featuredFilmThree = getActivity().getLayoutInflater().inflate(R.layout.featured_film_3, null);
        View featuredFilmFour = getActivity().getLayoutInflater().inflate(R.layout.featured_film_4, null);
        View featuredFilmFive = getActivity().getLayoutInflater().inflate(R.layout.featured_film_5, null);

        newFilmsBannerListViews = new ArrayList<>();
        newFilmsBannerListViews.add(featuredFilmOne);
        newFilmsBannerListViews.add(featuredFilmTwo);


        trendingFilmsBannerListViews = new ArrayList<>();
        trendingFilmsBannerListViews.add(featuredFilmThree);
        trendingFilmsBannerListViews.add(featuredFilmFour);
        trendingFilmsBannerListViews.add(featuredFilmFive);

        newFilmsBannerListTitles = new ArrayList<>();
        newFilmsBannerListTitles.add(".");
        newFilmsBannerListTitles.add(".");

        trendingFilmsBannerListTitles = new ArrayList<>();
        trendingFilmsBannerListTitles.add("Film Access");
        trendingFilmsBannerListTitles.add("Sports");
        trendingFilmsBannerListTitles.add("Music");

        newFilmsBanner.start(newFilmsBannerListViews, newFilmsBannerListTitles, 2, 500, R.drawable.ic_launcher);
        trendingFilmsBanner.start(trendingFilmsBannerListViews, trendingFilmsBannerListTitles, 2, 500, R.drawable.ic_launcher);
        super.onViewCreated(view, savedInstanceState);
    }
}
