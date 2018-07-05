package ao.now.nk.nk_now_app.fragments;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.ArrayList;

import ao.now.nk.nk_now_app.R;
import ao.now.nk.nk_now_app.adapters.TrendingVideoAdapter;

public class ProfileFragment extends Fragment implements
        DiscreteScrollView.ScrollListener<TrendingVideoAdapter.ViewHolder>,
        DiscreteScrollView.OnItemChangedListener<TrendingVideoAdapter.ViewHolder> {
    public static final String TAG = ProfileFragment.class.getSimpleName();
    private ArgbEvaluator argbEvaluator = null;
    private int currentOverlayColor = 0;
    private int overlayColor = 0;

    public static ProfileFragment newInstance() {
        Bundle args = new Bundle();

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        argbEvaluator = new ArgbEvaluator();
        currentOverlayColor = ContextCompat.getColor(this.getContext().getApplicationContext(), R.color.currentItemOverlay);
        overlayColor = ContextCompat.getColor(this.getContext().getApplicationContext(), R.color.itemOverlay);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DiscreteScrollView featureFilmsDiscreteScrollView = getActivity().findViewById(R.id.favorite_feature_films_discrete_scroll_view);
        DiscreteScrollView shortFilmsDiscreteScrollView = getActivity().findViewById(R.id.favorite_short_films_discrete_scroll_view);
        DiscreteScrollView originalFilmsDiscreteScrollView = getActivity().findViewById(R.id.favorite_original_films_discrete_scroll_view);
        DiscreteScrollView documentariesDiscreteScrollView = getActivity().findViewById(R.id.favorite_documentaries_discrete_scroll_view);
        DiscreteScrollView musicDiscreteScrollView = getActivity().findViewById(R.id.favorite_music_discrete_scroll_view);
        DiscreteScrollView nkLiveDiscreteScrollView = getActivity().findViewById(R.id.nk_live_discrete_scroll_view);
        DiscreteScrollView nkLinkDiscreteScrollView = getActivity().findViewById(R.id.nk_link_discrete_scroll_view);

        ArrayList<Integer> featureFilms = new ArrayList<>();
        ArrayList<Integer> shortFilms = new ArrayList<>();
        ArrayList<Integer> originalFilms = new ArrayList<>();
        ArrayList<Integer> documentariesFilms = new ArrayList<>();
        ArrayList<Integer> musicFilms = new ArrayList<>();
        ArrayList<Integer> nkLiveFilms = new ArrayList<>();
        ArrayList<Integer> nkLinkFilms = new ArrayList<>();

        featureFilms.add(R.drawable.trending_videos_one);
        featureFilms.add(R.drawable.trending_videos_two);

        shortFilms.add(R.drawable.trending_videos_three);
        shortFilms.add(R.drawable.trending_videos_four);

        originalFilms.add(R.drawable.trending_videos_six);
        originalFilms.add(R.drawable.background_five);

        documentariesFilms.add(R.drawable.background_four);
        documentariesFilms.add(R.drawable.background_three);

        musicFilms.add(R.drawable.background_one);
        musicFilms.add(R.drawable.background_two);

        nkLiveFilms.add(R.drawable.nk_live);
        nkLiveFilms.add(R.drawable.documentaries);

        nkLinkFilms.add(R.drawable.nk_link);
        nkLinkFilms.add(R.drawable.features);

        featureFilmsDiscreteScrollView.setOffscreenItems(featureFilms.size());
        featureFilmsDiscreteScrollView.addScrollListener(this);
        featureFilmsDiscreteScrollView.addOnItemChangedListener(this);
        featureFilmsDiscreteScrollView.setAdapter(new TrendingVideoAdapter(featureFilms));

        shortFilmsDiscreteScrollView.setOffscreenItems(shortFilms.size());
        shortFilmsDiscreteScrollView.addScrollListener(this);
        shortFilmsDiscreteScrollView.addOnItemChangedListener(this);
        shortFilmsDiscreteScrollView.setAdapter(new TrendingVideoAdapter(shortFilms));

        originalFilmsDiscreteScrollView.setOffscreenItems(originalFilms.size());
        originalFilmsDiscreteScrollView.addScrollListener(this);
        originalFilmsDiscreteScrollView.addOnItemChangedListener(this);
        originalFilmsDiscreteScrollView.setAdapter(new TrendingVideoAdapter(originalFilms));

        documentariesDiscreteScrollView.setOffscreenItems(documentariesFilms.size());
        documentariesDiscreteScrollView.addScrollListener(this);
        documentariesDiscreteScrollView.addOnItemChangedListener(this);
        documentariesDiscreteScrollView.setAdapter(new TrendingVideoAdapter(documentariesFilms));

        musicDiscreteScrollView.setOffscreenItems(musicFilms.size());
        musicDiscreteScrollView.addScrollListener(this);
        musicDiscreteScrollView.addOnItemChangedListener(this);
        musicDiscreteScrollView.setAdapter(new TrendingVideoAdapter(musicFilms));

        nkLiveDiscreteScrollView.setOffscreenItems(nkLiveFilms.size());
        nkLiveDiscreteScrollView.addScrollListener(this);
        nkLiveDiscreteScrollView.addOnItemChangedListener(this);
        nkLiveDiscreteScrollView.setAdapter(new TrendingVideoAdapter(nkLiveFilms));

        nkLinkDiscreteScrollView.setOffscreenItems(nkLinkFilms.size());
        nkLinkDiscreteScrollView.addScrollListener(this);
        nkLinkDiscreteScrollView.addOnItemChangedListener(this);
        nkLinkDiscreteScrollView.setAdapter(new TrendingVideoAdapter(nkLinkFilms));
    }

    @Override
    public void onCurrentItemChanged(@Nullable TrendingVideoAdapter.ViewHolder viewHolder, int adapterPosition) {
        viewHolder.setOverlayColor(currentOverlayColor);
    }

    @Override
    public void onScroll(float scrollPosition, int currentPosition, int newPosition, @Nullable TrendingVideoAdapter.ViewHolder currentHolder, @Nullable TrendingVideoAdapter.ViewHolder newCurrent) {
        currentHolder.setOverlayColor(interpolate(currentOverlayColor, overlayColor));
        newCurrent.setOverlayColor(interpolate(overlayColor, currentOverlayColor));
    }

    private int interpolate(int currentOverlayColor, int overlayColor) {
        return (int) argbEvaluator.evaluate(2.0f, currentOverlayColor, overlayColor);
    }
}
