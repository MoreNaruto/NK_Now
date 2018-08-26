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
import android.widget.ImageView;
import android.widget.TextView;

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
        startBestInFilmBanner();
        startTrendingFilmsBanner();
        startNewFilmBanner();
        setURLLinksForViews();

        super.onViewCreated(view, savedInstanceState);
    }

    private void startBestInFilmBanner() {
        View sunDance = getActivity().getLayoutInflater().inflate(R.layout.featured_film_6, null);
        View tribeca = getActivity().getLayoutInflater().inflate(R.layout.featured_film_6, null);
        View cannes = getActivity().getLayoutInflater().inflate(R.layout.featured_film_6, null);
        View berlin = getActivity().getLayoutInflater().inflate(R.layout.featured_film_6, null);
        View venice = getActivity().getLayoutInflater().inflate(R.layout.featured_film_6, null);
        View rainDance = getActivity().getLayoutInflater().inflate(R.layout.featured_film_6, null);
        View tiff = getActivity().getLayoutInflater().inflate(R.layout.featured_film_6, null);

        ImageView sunDanceImageView = sunDance.findViewById(R.id.best_in_fest_image_view);
        TextView sunDanceTitle = sunDance.findViewById(R.id.best_in_fest_title);
        ImageView tribecaImageView = tribeca.findViewById(R.id.best_in_fest_image_view);
        TextView tribecaTitle = tribeca.findViewById(R.id.best_in_fest_title);
        ImageView cannesImageView = cannes.findViewById(R.id.best_in_fest_image_view);
        TextView cannesTitle = cannes.findViewById(R.id.best_in_fest_title);
        ImageView berlinImageView = berlin.findViewById(R.id.best_in_fest_image_view);
        TextView berlinTitle = berlin.findViewById(R.id.best_in_fest_title);
        ImageView veniceImageView = venice.findViewById(R.id.best_in_fest_image_view);
        TextView veniceTitle = venice.findViewById(R.id.best_in_fest_title);
        ImageView rainDanceImageView = rainDance.findViewById(R.id.best_in_fest_image_view);
        TextView rainDanceTitle = rainDance.findViewById(R.id.best_in_fest_title);
        ImageView tiffImageView = tiff.findViewById(R.id.best_in_fest_image_view);
        TextView tiffTitle = tiff.findViewById(R.id.best_in_fest_title);

        sunDanceImageView.setBackgroundResource(R.drawable.sundance);
        sunDanceTitle.setText(R.string.sundance);
        tribecaImageView.setBackgroundResource(R.drawable.tribeca);
        tribecaTitle.setText(R.string.tribeca);
        cannesImageView.setBackgroundResource(R.drawable.cannes);
        cannesTitle.setText(R.string.cannes);
        berlinImageView.setBackgroundResource(R.drawable.berlin);
        berlinTitle.setText(R.string.berlin);
        veniceImageView.setBackgroundResource(R.drawable.venice);
        veniceTitle.setText(R.string.venice);
        rainDanceImageView.setBackgroundResource(R.drawable.raindance);
        rainDanceTitle.setText(R.string.rain_dance);
        tiffImageView.setBackgroundResource(R.drawable.tiff);
        tiffTitle.setText(R.string.tiff);

        List<View> bestInFilmsBannerListViews = new ArrayList<>();
        bestInFilmsBannerListViews.add(sunDance);
        bestInFilmsBannerListViews.add(tribeca);
        bestInFilmsBannerListViews.add(cannes);
        bestInFilmsBannerListViews.add(berlin);
        bestInFilmsBannerListViews.add(venice);
        bestInFilmsBannerListViews.add(rainDance);
        bestInFilmsBannerListViews.add(tiff);

        List<String> bestInFilmsTitle = new ArrayList<>();
        bestInFilmsTitle.add(".");
        bestInFilmsTitle.add(".");
        bestInFilmsTitle.add(".");
        bestInFilmsTitle.add(".");
        bestInFilmsTitle.add(".");
        bestInFilmsTitle.add(".");
        bestInFilmsTitle.add(".");

        binding.bestInFestBanner.start(bestInFilmsBannerListViews, bestInFilmsTitle, 2, 500, R.drawable.ic_launcher);
    }

    private void setURLLinksForViews() {
        binding.originalFilmsImageView.setOnClickListener(v -> goToUrl("https://www.newkingstonfilm.com/nk-films"));
        binding.nkLinkImageView.setOnClickListener(v -> goToUrl("https://www.newkingstonfilm.com/nk-link"));
        binding.nkLiveImageView.setOnClickListener(v -> goToUrl("https://www.newkingstonfilm.com"));
    }

    private void startTrendingFilmsBanner() {
        View featuredFilmThree = getActivity().getLayoutInflater().inflate(R.layout.featured_film_3, null);
        View featuredFilmFour = getActivity().getLayoutInflater().inflate(R.layout.featured_film_4, null);
        View featuredFilmFive = getActivity().getLayoutInflater().inflate(R.layout.featured_film_5, null);

        List<View> trendingFilmsBannerListViews = new ArrayList<>();
        trendingFilmsBannerListViews.add(featuredFilmThree);
        trendingFilmsBannerListViews.add(featuredFilmFour);
        trendingFilmsBannerListViews.add(featuredFilmFive);

        List<String> trendingFilmsBannerListTitles = new ArrayList<>();
        trendingFilmsBannerListTitles.add("Film Access");
        trendingFilmsBannerListTitles.add("Sports");
        trendingFilmsBannerListTitles.add("Music");


        binding.trendingFilmsBanner.start(trendingFilmsBannerListViews, trendingFilmsBannerListTitles, 2, 500, R.drawable.ic_launcher);
    }

    private void startNewFilmBanner() {
        View featuredFilmOne = getActivity().getLayoutInflater().inflate(R.layout.featured_film_1, null);
        View featuredFilmTwo = getActivity().getLayoutInflater().inflate(R.layout.featured_film_2, null);

        List<View> newFilmsBannerListViews = new ArrayList<>();
        newFilmsBannerListViews.add(featuredFilmOne);
        newFilmsBannerListViews.add(featuredFilmTwo);

        List<String> newFilmsBannerListTitles = new ArrayList<>();
        newFilmsBannerListTitles.add(".");
        newFilmsBannerListTitles.add(".");

        binding.newFilmsBanner.start(newFilmsBannerListViews, newFilmsBannerListTitles, 2, 500, R.drawable.ic_launcher);
    }

    private void goToUrl(String url) {
        Uri parsedUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, parsedUrl);
        startActivity(launchBrowser);
    }
}
