package ru.triptomeet.ui.searchlocation

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.lang.reflect.Type

const val MAX_SEARCH_HISTORY = 10
const val HISTORY_PREF_KEY = "searchKey"

class SearchLocationViewModel : ViewModel(), KoinComponent {
    val context: Context by inject()

    fun saveSearchLocation(location: String) {

        val sharedPreferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)
        val edit: SharedPreferences.Editor = sharedPreferences.edit()

        val gson = Gson()
        var json: String? = sharedPreferences.getString(HISTORY_PREF_KEY, null)
        val type: Type = object : TypeToken<MutableList<String?>?>() {}.type

        val searchList =
            if (json != null) gson.fromJson<MutableList<String>>(
                json,
                type
            ) else mutableListOf()


        if (!isLocationSaved(location, searchList)) {
            if (searchList.size >= MAX_SEARCH_HISTORY) searchList.removeAt(0)
            searchList.add(location)
        }

        json = gson.toJson(searchList)
        edit.putString(HISTORY_PREF_KEY, json)
        edit.apply()
    }

    private fun isLocationSaved(location: String, list: List<String>): Boolean {
        var result = false
        list.forEach { if (it.equals(location, true)) result = true }
        return result
    }
}


