package com.example.kotlinarchitechure

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinarchitechure.viewModel.DiceViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity {

    private lateinit var viewModel: DiceViewModel

    private val imageViews by lazy {
        arrayOf<ImageView>(die1, die2, die3, die4, die5)
    }

    constructor() : super()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(DiceViewModel::class.java)
        viewModel.headline.observe(this, Observer {
            headline.text = it
        })
        viewModel.dice.observe(this, Observer {
            updateDisplay(it)
        })

        //lifecycle Observer
        lifecycle.addObserver(MyLifecycleObserver())

        fab.setOnClickListener {
            viewModel.rollDice()
        }
    }

    private fun fabClickHandeler() {
    }

    private fun updateDisplay(dice: IntArray) {
        for (i in 0 until imageViews.size) {
            val drawableId = when (dice[i]) {
                1 -> R.drawable.die_1
                2 -> R.drawable.die_2
                3 -> R.drawable.die_3
                4 -> R.drawable.die_4
                5 -> R.drawable.die_5
                6 -> R.drawable.die_6
                else -> R.drawable.die_6
            }
            imageViews[i].setImageResource(drawableId)
        }
    }
}
