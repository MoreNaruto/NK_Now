package ao.now.nk.nk_now_app.activities

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*
import ao.now.nk.nk_now_app.R
import com.bumptech.glide.Glide

class VideoActivity : AppCompatActivity() {

    private var mediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val path = "https://www.youtube.com/watch?v=R04nDFZGvdM"
        val path1 = "http://www.youtube.com/embed/$path?autoplay=1&vq=small"
        val uri: Uri? = Uri.parse(path1)

        videoView.setVideoPath(
                "http://www.ebookfrenzy.com/android_book/movie.mp4")

        mediaController = MediaController(this)
        mediaController?.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()

    }

}
