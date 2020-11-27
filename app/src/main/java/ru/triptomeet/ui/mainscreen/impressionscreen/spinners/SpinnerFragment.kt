package ru.triptomeet.ui.mainscreen.impressionscreen.spinners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import coil.load
import kotlinx.android.synthetic.main.item_spinner_option.*
import ru.triptomeet.R

/**
 * Класс для отображения кастомного выпадающего списка
 */

class SpinnerFragment(
    val title: String,
    private val description: String?,
    private var isOpened: Boolean = true
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.item_spinner_option, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewContent()
        initClickListeners()
        renderState()
    }

    private fun initViewContent() {
        isOpened = false
        impressionSpinnerTitle.text = title
        impressionSpinnerDescription.text = description
    }

    private fun initClickListeners() {
        with(impressionSpinnerTitle) {
            setOnClickListener { moveVertical() }
            setOnClickListener { moveVertical() }
        }
    }

    private fun renderState() {

        //Вспомогательная функция для конвертации DP в пиксели
        fun dpToPx(number: Int) = (resources.displayMetrics.density).toInt() * number

        //Отображение открытого и закрытого элемента
        if (isOpened) {
            impressionSpinnerIcon.load(R.drawable.ic_arrowup)
            (impressionSpinnerDescription.layoutParams as ConstraintLayout.LayoutParams).topMargin =
                dpToPx(16)
            impressionSpinnerDescription.visibility = View.VISIBLE
        } else {
            impressionSpinnerIcon.load(R.drawable.ic_arrowdown)
            (impressionSpinnerDescription.layoutParams as ConstraintLayout.LayoutParams)
                .goneTopMargin
            impressionSpinnerDescription.visibility = View.GONE
        }
    }

    private fun changeState() {
        isOpened = !isOpened
    }

    private fun moveVertical() {
        changeState()
        renderState()
    }
}