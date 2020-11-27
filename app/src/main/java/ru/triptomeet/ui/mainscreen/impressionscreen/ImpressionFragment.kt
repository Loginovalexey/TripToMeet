package ru.triptomeet.ui.mainscreen.impressionscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.load
import kotlinx.android.synthetic.main.item_local_for_impression_screen.*
import kotlinx.android.synthetic.main.screen_impression.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import ru.triptomeet.R
import ru.triptomeet.model.entity.detailedimpression.Impression
import ru.triptomeet.ui.MainActivity
import ru.triptomeet.ui.base.DataResult
import ru.triptomeet.ui.mainscreen.impressionscreen.pictures.PicturesFragment
import ru.triptomeet.ui.mainscreen.impressionscreen.pictures.PicturesMockDataSource
import ru.triptomeet.ui.mainscreen.impressionscreen.reviews.ReviewsDataSource
import ru.triptomeet.ui.mainscreen.impressionscreen.reviews.ReviewsFragment
import ru.triptomeet.ui.mainscreen.impressionscreen.spinners.SpinnerFragment
import ru.triptomeet.utils.getMonthNameByNumber

/**
 * Экран "Вдохновение" - туристическое предложение для пользователя
 */

class ImpressionFragment : Fragment() {

    private val impressionViewModel: ImpressionViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.screen_impression, container, false)
    }

    override fun onStart() {
        super.onStart()
        impressionToolbar.setNavigationOnClickListener {
            (requireActivity() as MainActivity).onBackPressed()
        }
        observe()
    }

    //Ожидание получения данных
    private fun observe() {
        lifecycleScope.launch {
            impressionViewModel.fetch()
                .distinctUntilChanged()
                .collectLatest { processResult(it) }
        }
    }

    //Действия при получении данных
    @SuppressLint("UseCompatLoadingForDrawables", "SimpleDateFormat")
    private fun processResult(result: DataResult) {
        when (result) {
            is DataResult.SuccessAny<*> ->
                (result.data as Impression).also {
                    createTop(it)
                    createLocal(it)
                    createTextLayers(it)
                    createPictures(it)
                    createSpinnerOptions(it)
                    createReview(it)

                }
        }
    }

    //Показ верхнего изображения и титра
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun createTop(impression: Impression) {
        impression.also {
            impressionTopImage.load(it.imageId)
            impressionTopTitle.text = it.title
        }
    }

    //Показ данных о местом жителе, который оказывает туристическую услугу
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun createLocal(impression: Impression) {
        impression.local.also {
            reviewItemImage.load(it.imageId)
            reviewItemName.text = it.name
            reviewItemMonth.text = getMonthNameByNumber(it.month)
            reviewItemYear.text = it.year.toString()
            impressionCommentsCount.text = it.commentsCount.toString()
            impressionLikesCount.text = it.likesCount.toString()
        }
    }

    //Показ описания туристической услуги
    private fun createTextLayers(impression: Impression) {
        mainDescription.text = impression.mainDescription
        impression.description1?.let {
            impressionDescriptionPart1.visibility = VISIBLE
            impressionDescriptionPart1.text = impression.description1
        }
        impression.description2?.let {
            impressionDescriptionPart2.visibility = VISIBLE
            impressionDescriptionPart2.text = impression.description2
        }
    }

    //Отображение галереи картинок
    private fun createPictures(impression: Impression) {
        impression.images?.let {
            val impressionPicturesFragment = PicturesFragment(PicturesMockDataSource(it))
            val fragmentTransaction = childFragmentManager
                .beginTransaction()
            fragmentTransaction.add(R.id.picturesLayer, impressionPicturesFragment)
            fragmentTransaction.commit()
        }
    }

    //Показ раскрывающихся опций
    private fun createSpinnerOptions(impression: Impression) {
        impression.spinnerOptions.let {
            val fragmentTransaction =
                childFragmentManager
                    .beginTransaction()
            for (i in 0..(impression.spinnerOptions.lastIndex))
                fragmentTransaction.add(
                    R.id.spinnerOptionsLayer,
                    SpinnerFragment(
                        impression.spinnerOptions[i].first,
                        impression.spinnerOptions[i].second
                    )
                )
            fragmentTransaction.commit()
        }
    }

    //Отображения списка отзывов
    private fun createReview(impression: Impression) {
        impression.comments?.let {
            val commentsFragment = ReviewsFragment(ReviewsDataSource(it))
            val fragmentTransaction = childFragmentManager
                .beginTransaction()
            fragmentTransaction.add(R.id.commentsLayer, commentsFragment)
            fragmentTransaction.commit()
        }
    }
}
