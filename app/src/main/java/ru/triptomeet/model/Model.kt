package ru.triptomeet.model

/**
 * Модель для хранения и обмена данных в приложении
 **/
class Model {

    /**
     * Массив с дентификаторами выбранных категорий развлечений
     */

    val checkedQuestions: ArrayList<Int> = ArrayList()

    /**
     * Выбранный заказ
     */
    var currentAdvertId: Int? = null

    /**
     * Полученный токен
     */

    lateinit var authToken:String

    /**
     * Идентификатор пользователя
     */
    val userId: Int = 1

    /**
     * Изменение массива с идентификаторами категорий развлечений в зависимости от выбора
     */

    fun checkQuestion(questionId: Int):Boolean {
        val isChecked = checkedQuestions.contains(questionId)

        if (isChecked)
            checkedQuestions.remove(questionId)
        else
            checkedQuestions.add(questionId)
        return !isChecked
    }

    /**
     * Запрос - выбрана ли категория развлечений
     */
    fun isQuestionChecked(questionId: Int): Boolean = checkedQuestions.contains(questionId)
}