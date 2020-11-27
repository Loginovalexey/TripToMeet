package ru.triptomeet.application

object Constants {

    /**
     * Длитеьность анимации на экране Splash
     */
    const val SPLASH_EPISODE_DURATION = 3000

    /**
     * Константы для работы с веб-сервером
     */
    const val BASE_URL = "http://10.0.2.2:8189/travel/"
    const val LOGIN_URL = "auth/"
    const val ADVERTS_URL = "api/v1/adverts/"
    const val CODE_OK = 200


    /**
     * Константы для пагинации
     * @see DEFAULT_PAGE_INDEX номер начальной страницы
     * @see DEFAULT_INITIAL_LOAD_SIZE количество элементов, загружаемых в начале
     * @see DEFAULT_PAGE_SIZE размер страницы
     * @see DEFAULT_PREFETCH_DISTANCE дистанция до следующего запуска загрузки данных
     */
    const val DEFAULT_PAGE_INDEX = 1
    const val DEFAULT_INITIAL_LOAD_SIZE = 5
    const val DEFAULT_PAGE_SIZE = 5
    const val DEFAULT_PREFETCH_DISTANCE = 5

}