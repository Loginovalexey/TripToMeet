package ru.triptomeet.ui.mainscreen.inspirationsscreen

import android.content.Context
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import ru.triptomeet.R
import ru.triptomeet.model.entity.InspirationForList
import ru.triptomeet.ui.base.datasource.StaticDataSource

/**
 * Класс-"заглушка" с данными для отображения на экране "Вдохновение" (Impression)
 */

class InspirationsMockDataSource : StaticDataSource<InspirationForList>(),KoinComponent {
    val context: Context by inject()
    override suspend fun getData():List<InspirationForList> = listOf(
        InspirationForList(
            1,
            R.drawable.screen_inspirations_old_town_streets,
            context.resources.getString(R.string.oldTownStreets),
            74,
            10
        ),
        InspirationForList(
            2,
            R.drawable.screen_inspirations_near_the_town,
            context.resources.getString(R.string.nearTheTown),
            120,
            19
        ),
        InspirationForList(
            3,
            R.drawable.screen_inspirations_rooftop_walks,
            context.resources.getString(R.string.travelToDebrecen),
            321,
            22
        ),
        InspirationForList(
            4,
            R.drawable.screen_inspirations_all_about_flights,
            context.resources.getString(R.string.allAboutFlights),
            120,
            19
        ),
        InspirationForList(
            5,
            R.drawable.screen_inspirations_buda_fortress,
            context.resources.getString(R.string.budaFortress),
            321,
            22
        ),
        InspirationForList(
            6,
            R.drawable.screen_inspirations_rooftop_walks,
            context.resources.getString(R.string.rooftopWalks),
            67,
            27
        )
    )

}