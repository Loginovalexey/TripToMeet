package ru.triptomeet.ui

import androidx.fragment.app.Fragment

//Интерфейс смены фрагментов
interface IOnCallChangeScreen {
    fun replaceFragment(fragment: Fragment)
    fun addFragment(fragment: Fragment)
}