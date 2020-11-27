package ru.triptomeet.ui.searchlocation

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import ru.triptomeet.model.entity.SearchLocation
import ru.triptomeet.ui.base.datasource.StaticDataSource
import java.lang.reflect.Type

class SearchLocationDataSource : StaticDataSource<SearchLocation>(),
    KoinComponent {
    val context: Context by inject()
    override suspend fun getData(): List<SearchLocation> =
        getLastSearchLocations(context)

    private fun getLastSearchLocations(context: Context): List<SearchLocation> {
        val sharedPreferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)
        val gson = Gson()
        val json: String? = sharedPreferences.getString(HISTORY_PREF_KEY, null)
        val type: Type = object : TypeToken<List<String?>?>() {}.type

        val searchList = mutableListOf<SearchLocation>()
        json?.let {
            gson.fromJson<MutableList<String>>(json, type).run {
                forEach {
                    searchList.add(
                        SearchLocation(
                            id = 0,
                            location = it
                        )
                    )
                }
            }
        }

        return searchList
    }
}