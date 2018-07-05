package ao.now.nk.nk_now_app.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.bumptech.glide.Glide

import android.support.annotation.ColorInt
import android.widget.FrameLayout
import ao.now.nk.nk_now_app.R
import ao.now.nk.nk_now_app.activities.VideoActivity

class TrendingVideoAdapter(images: List<Int>) : RecyclerView.Adapter<TrendingVideoAdapter.ViewHolder>() {
    private val images: List<*>

    init {
        this.images = images
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.trending_view_card, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setOnClickAction()
        Glide.with(holder.itemView.context)
                .load(images[position])
                .into(holder.image)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        private val overlay: FrameLayout = itemView.findViewById(R.id.overlay)

        fun setOverlayColor(@ColorInt color: Int) {
            overlay.setBackgroundColor(color)
        }

        fun setOnClickAction() {
            itemView.setOnClickListener({
                val intent = Intent(it.context, VideoActivity::class.java)
                it.context.startActivity(intent)
            })
        }
    }
}
