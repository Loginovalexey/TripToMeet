package ru.triptomeet.ui.base.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import ru.triptomeet.model.entity.Identifiable
import ru.triptomeet.ui.base.datasource.IDataSource
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListenerForView
import ru.triptomeet.ui.base.viewmodel.BaseViewModel


/**Обобщающий класс для фрагментов-наследников, определяющий основные переменные и методы
 *
 * @param fragmentId id фрагмента, содержащего список(конкретизируется наследником)
 * @param containerId id самого списка (RecyclerView, LinearLayout) (конкретизируется наследником)
 * @param progressShowing флаг показа прогресса загрузки
 * будет отрисовываться и связываться с данными
 *
 * @property itemId - идентификатор элемента списка
 * @property viewHolderType - тип ViewHolder, согласно которому будут отрисовываться элементы
 * списка и связываться с данными
 * @property entitiesSource - источник данных, определяемый в конкретной реализации
 * классом-наследником
 * @property onItemClickListenerForView - объект для обработки нажатий элементов списка
 * */


abstract class BaseFragment<Entity : Identifiable>(
    val fragmentId: Int,
    val containerId: Int,
    var progressShowing: Boolean
) : Fragment() {

    abstract val itemId: Int

    abstract val viewHolderType: Class<*>

    abstract val entitiesSource: IDataSource

    /**
     * ViewModel определяется наследником
     */
    abstract val viewModel: BaseViewModel<Entity>


    var onItemClickListenerForView: IOnItemClickListenerForView<Entity>? = null

    //Контейнер списка будет надйен по идентификатору
    val container by lazy { requireActivity().findViewById(containerId) as ViewGroup }

    //Прогресс-бар будет показываться, если в наследнике progressShowing = true
    private var progressBar: ProgressBar? = null

    //Виджет parentContainer используется для отрисовки прогресс-бара
    private var parentContainer: ViewGroup? = null


    override fun onCreateView(
        inflater: LayoutInflater, parentContainer: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(fragmentId, parentContainer, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Если фрагмент реализует интерфейс IOnItemClickListenerForView,
        //значит, он будет использоваться для обработки нажатий на элементы списка
        onItemClickListenerForView = if (this is IOnItemClickListenerForView<*>)
            (this as IOnItemClickListenerForView<Entity>)
        else
            null
    }

    @ExperimentalPagingApi
    override fun onStart() {
        super.onStart()
        //действия после отрисовки фрагмента
        observe()
    }

    //Получение данных от ViewModel
    @ExperimentalPagingApi
    private fun observe() =
        lifecycleScope.launch {
            (viewModel.fetch() as Flow<*>)
                .distinctUntilChanged()
                .collectLatest { it?.let { processResult(it) } }
        }

    /**
     * Метод получения данных определяется в классе-наслиднике
     */
    abstract suspend fun processResult(it: Any)

    //Добавление в середину контейнера прогресс-бара при необходимости показать прогресс загрузки
    private fun initProgressShowing() {
        if (progressShowing) {
            progressBar = ProgressBar(requireActivity()).apply {
                layoutParams =
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    ).apply { gravity = Gravity.CENTER }
            }
            parentContainer?.addView(progressBar)
            progressBar!!.visibility = INVISIBLE
        }
    }

    //Смена состояний показа-скрытия прогресс бара
    protected fun renderLoading(loading: Boolean) {
        progressBar?.let {
            if (loading)
                it.visibility = View.VISIBLE
            else
                it.visibility = View.GONE
        }

    }
}


