package ao.now.nk.nk_now_app.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
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
import ao.now.nk.nk_now_app.databinding.FragmentFilmPageBinding;
import it.chengdazhi.decentbanner.DecentBanner;

public class FilmFragment extends Fragment {
    public static final String TAG = FilmFragment.class.getSimpleName();
    private FragmentFilmPageBinding binding;

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_film_page, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        View featuredFilmOne = getActivity().getLayoutInflater().inflate(R.layout.featured_film_1, null);
        View featuredFilmTwo = getActivity().getLayoutInflater().inflate(R.layout.featured_film_2, null);
        View featuredFilmThree = getActivity().getLayoutInflater().inflate(R.layout.featured_film_3, null);
        View featuredFilmFour = getActivity().getLayoutInflater().inflate(R.layout.featured_film_4, null);
        View featuredFilmFive = getActivity().getLayoutInflater().inflate(R.layout.featured_film_5, null);

        List<View> newFilmsBannerListViews = new ArrayList<>();
        newFilmsBannerListViews.add(featuredFilmOne);
        newFilmsBannerListViews.add(featuredFilmTwo);

        List<View> trendingFilmsBannerListViews = new ArrayList<>();
        trendingFilmsBannerListViews.add(featuredFilmThree);
        trendingFilmsBannerListViews.add(featuredFilmFour);
        trendingFilmsBannerListViews.add(featuredFilmFive);

        List<String> newFilmsBannerListTitles = new ArrayList<>();
        newFilmsBannerListTitles.add(".");
        newFilmsBannerListTitles.add(".");

        List<String> trendingFilmsBannerListTitles = new ArrayList<>();
        trendingFilmsBannerListTitles.add("Film Access");
        trendingFilmsBannerListTitles.add("Sports");
        trendingFilmsBannerListTitles.add("Music");

        binding.newFilmsBanner.start(newFilmsBannerListViews, newFilmsBannerListTitles, 2, 500, R.drawable.ic_launcher);
        binding.trendingFilmsBanner.start(trendingFilmsBannerListViews, trendingFilmsBannerListTitles, 2, 500, R.drawable.ic_launcher);

        binding.originalFilmsImageView.setOnClickListener(v -> goToUrl("https://www.newkingstonfilm.com/nk-films"));
        binding.nkLinkImageView.setOnClickListener(v -> goToUrl("https://www.newkingstonfilm.com/nk-link"));
        binding.nkLiveImageView.setOnClickListener(v -> goToUrl("https://www.newkingstonfilm.com"));
        super.onViewCreated(view, savedInstanceState);
    }

    private void goToUrl(String url) {
        Uri parsedUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, parsedUrl);
        startActivity(launchBrowser);
    }
}
