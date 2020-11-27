package ru.triptomeet.ui.mainscreen.impressionscreen

import android.content.Context
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import ru.triptomeet.R
import ru.triptomeet.model.entity.detailedimpression.Impression
import ru.triptomeet.model.entity.detailedimpression.Review
import ru.triptomeet.model.entity.detailedimpression.ImpressionImage
import ru.triptomeet.model.entity.detailedimpression.ImpressionLocal

/**
 * Класс-"заглушка" с данными для отображения на экране "Вдохновение" (Impression)
 */

class ImpressionMockDataSource : KoinComponent {
    val context: Context by inject()

    fun getData() = Impression(
        imageId = R.drawable.trip_to_debrecen,
        title = context.resources.getString(R.string.impressionScreenTitle),
        mainDescription = context.resources.getString(R.string.impressionScreenMainDescription),
        local = ImpressionLocal(
            1,
            R.drawable.emilia_racne,
            context.resources.getString(R.string.emiliyaRance),
            3, 2020,
            321,
            22
        ),
        description1 = context.resources.getString(R.string.impressionScreenDescription1),

        images = listOf(
            ImpressionImage(1, R.drawable.impression_pict1),
            ImpressionImage(2, R.drawable.impression_pict2),
            ImpressionImage(3, R.drawable.impression_pict1),
            ImpressionImage(4, R.drawable.impression_pict2),
            ImpressionImage(5, R.drawable.impression_pict1),
            ImpressionImage(6, R.drawable.impression_pict2)
        ),

        description2 = context.resources.getString(R.string.impressionScreenDescription2),

        spinnerOptions = listOf(
            Pair(context.resources.getString(R.string.whereToDiner), null),
            Pair(context.resources.getString(R.string.whereToStop), null),
            Pair(context.resources.getString(R.string.howToReach), null),
            Pair(context.resources.getString(R.string.howLongTrip),
                context.resources.getString(R.string.howLongTripAnswer)
            )
        ),
        listOf(
            Review(
                1,
                R.drawable.gabor_bognar,
                context.getString(R.string.marcoSalen),
                6,
                2020,
                content = context.getString(R.string.marcoSalenReview)

            ),
            Review(
                2,
                R.drawable.laslo_silad,
                context.getString(R.string.ivanneGranke),
                5,
                2020,
                content = context.getString(R.string.ivanneGrankeReview)
            )
        )
    )
}