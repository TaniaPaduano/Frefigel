package com.example.frefigel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class Panthome : AppCompatActivity() {

    private val list = mutableListOf<CarouselItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panthome)
        val carousel:ImageCarousel = findViewById(R.id.carousel)
        list.add(CarouselItem("https://i.pinimg.com/736x/2e/ea/c0/2eeac098db7ed68c3fb57e6b235e249d.jpg"))
        list.add(CarouselItem("https://http2.mlstatic.com/D_NQ_NP_809494-MLM51900551136_102022-O.jpg"))
        list.add(CarouselItem("https://cdn.foodandwineespanol.com/2018/02/FbTama-Roca-1-383x239.jpg"))
        carousel.addData(list)
    }
}