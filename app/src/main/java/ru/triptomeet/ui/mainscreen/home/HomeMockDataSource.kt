package ru.triptomeet.ui.mainscreen.home

import android.content.Context
import android.content.res.Resources
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import ru.triptomeet.R
import ru.triptomeet.model.entity.*

/**
 * Класс-"заглушка" с данными для отображения на экране "Home"
 */

class HomeMockDataSource : KoinComponent {
    val context: Context by inject()
    val resources: Resources = context.resources
    fun getData() = Home(
        imageId = R.drawable.top_home_image,
        title = context.resources.getString(R.string.Budapest),
        forYou = listOf(
            ForYou(
                1,
                R.drawable.trip_to_old_town,
                resources.getString(R.string.oldTownWalk),
                90,
                600
            ),
            ForYou(6, R.drawable.geysers, resources.getString(R.string.geyzersTrip), 120, 1700),
            ForYou(
                2,
                R.drawable.ascend_to_mount,
                resources.getString(R.string.ascentToMount),
                80,
                900
            ),
            ForYou(
                3,
                R.drawable.trip_to_old_town,
                resources.getString(R.string.oldTownWalk),
                90,
                600
            ),
            ForYou(
                4,
                R.drawable.geysers, resources.getString(R.string.geyzersTrip), 120, 1700
            ),
            ForYou(
                5,
                R.drawable.ascend_to_mount,
                resources.getString(R.string.ascentToMount),
                80,
                900
            )
        ),
        inspirations =  listOf(
            InspirationForGallery(1,
                R.drawable.inspiration_old_town_streets,
                resources.getString(R.string.oldTownStreets)
            ),
            InspirationForGallery(2,
                R.drawable.inspiration_rooftop_walks,
                resources.getString(R.string.rooftopWalks)
            ),
            InspirationForGallery(3,
                R.drawable.inspiration_old_town_streets,
                resources.getString(R.string.oldTownStreets)
            ),
            InspirationForGallery(4,
                R.drawable.inspiration_rooftop_walks,
                resources.getString(R.string.rooftopWalks)

            )
        ),
        popular = listOf(
            Popular(1,
                R.drawable.trip_to_old_town,
                resources.getString(R.string.oldTownWalk),
                90,
                600
            ),
            Popular(5, R.drawable.geysers, resources.getString(R.string.geyzersTrip), 120, 1700),
            Popular(
                2,
                R.drawable.ascend_to_mount,
                resources.getString(R.string.ascentToMount),
                80,
                900
            ),
            Popular(
                3,
                R.drawable.trip_to_old_town,
                resources.getString(R.string.oldTownWalk),
                90,
                600
            ),
            Popular(6,R.drawable.geysers, resources.getString(R.string.geyzersTrip), 120, 1700),
            Popular(
                4,
                R.drawable.ascend_to_mount,
                resources.getString(R.string.ascentToMount),
                80,
                900
            )
        ),
        locals =  listOf(
            Local(
                1,
                R.drawable.zalan_shakay,
                "Залан Шекей",
                listOf("Музыка", "Спорт", "История"),
                600
            ),
            Local(
                2,
                R.drawable.emilia_racne,
                "Эмилия Рацне",
                listOf("Музыка", "Ночная жизнь"),
                400
            ),
            Local(
                3,
                R.drawable.gabor_bognar,
                "Габор Бокнар",
                listOf("Музыка", "Спорт", "Иностранные языки"),
                400
            ),
            Local(
                4,
                R.drawable.laslo_silad,
                "Ласло Силадь",
                listOf("Музыка", "Спорт"),
                0
            )
        )
    )
}