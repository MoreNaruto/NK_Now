package ao.now.nk.nk_now_app.activities

import android.animation.ArgbEvaluator
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.yarolegovich.discretescrollview.DiscreteScrollView
import kotlinx.android.synthetic.main.activity_intro_page.*
import android.support.v4.content.ContextCompat
import ao.now.nk.nk_now_app.adapters.TrendingVideoAdapter
import ao.now.nk.nk_now_app.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.featured_film_1.view.*
import kotlinx.android.synthetic.main.featured_film_2.view.*
import kotlinx.android.synthetic.main.featured_film_3.view.*
import kotlinx.android.synthetic.main.fragment_film_page.view.*


class IntroPageActivity : AppCompatActivity(),
        DiscreteScrollView.ScrollListener<TrendingVideoAdapter.ViewHolder>,
        DiscreteScrollView.OnItemChangedListener<TrendingVideoAdapter.ViewHolder>{

    private var evaluator: ArgbEvaluator? = null
    private var currentOverlayColor: Int = 0
    private var overlayColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_page)

        evaluator = ArgbEvaluator()
        currentOverlayColor = ContextCompat.getColor(this, R.color.currentItemOverlay)
        overlayColor = ContextCompat.getColor(this, R.color.itemOverlay)

        val featuredFilmOne = layoutInflater.inflate(R.layout.featured_film_1, null)
        val featuredFilmTwo = layoutInflater.inflate(R.layout.featured_film_2, null)
        val featuredFilmThree = layoutInflater.inflate(R.layout.featured_film_3, null)

        val views = listOf<View>(featuredFilmOne, featuredFilmTwo, featuredFilmThree)
        val titles = listOf("Title One", "Title Two", "Title Three")

        decent_banner.start(views, titles, 2, 500, R.drawable.ic_launcher)
        val trendingVideos = listOf(
                R.drawable.trending_videos_one,
                R.drawable.trending_videos_two,
                R.drawable.trending_videos_three,
                R.drawable.trending_videos_four,
                R.drawable.trending_videos_six)

        trending_videos_discrete_scroll_view.setOffscreenItems(trendingVideos.size)
        trending_videos_discrete_scroll_view.addScrollListener(this)
        trending_videos_discrete_scroll_view.addOnItemChangedListener(this)
        trending_videos_discrete_scroll_view.adapter = TrendingVideoAdapter(trendingVideos)
    }

    override fun onScroll(scrollPosition: Float, currentPosition: Int, newPosition: Int, currentHolder: TrendingVideoAdapter.ViewHolder?, newCurrent: TrendingVideoAdapter.ViewHolder?) {
        currentHolder?.setOverlayColor(interpolate(currentOverlayColor, overlayColor))
        newCurrent?.setOverlayColor(interpolate(overlayColor, currentOverlayColor))
    }

    override fun onCurrentItemChanged(viewHolder: TrendingVideoAdapter.ViewHolder?, adapterPosition: Int) {
        viewHolder?.setOverlayColor(currentOverlayColor)
    }

    private fun interpolate(currentOverlayColor: Int, overlayColor: Int): Int {
        return evaluator?.evaluate(2.0f, currentOverlayColor, overlayColor) as Int
    }
}