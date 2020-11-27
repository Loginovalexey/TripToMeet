package ru.triptomeet.ui.base.fragment

import android.os.Bundle
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import ru.triptomeet.model.entity.Identifiable
import ru.triptomeet.ui.base.adapter.PagingAdapter
import ru.triptomeet.ui.base.datasource.PagingDataSource
import ru.triptomeet.ui.base.paging.LoaderStateAdapter
import ru.triptomeet.ui.base.viewmodel.PagingBaseViewModel

/**
 * Обобщенный класс фрагмента для списков с пагинацией
 * @param fragmentId id фрагмента, содержащего список
 * @param containerId id самого списка (RecyclerView, LinearLayout)
 * @param progressShowing флаг показа прогресса загрузки
 * @param itemId - идентификатор элемента списка
 * @param viewHolderType - тип ViewHolder, согласно которому будут отрисовываться элементы
 * списка и связываться с данными
 * @param entitiesSource - источник данных
 */
abstract class PagingBaseFragment<Entity : Identifiable> @ExperimentalPagingApi constructor(
    fragmentId: Int,
    containerId: Int,
    progressShowing: Boolean = false,
    override val itemId: Int,
    override val viewHolderType: Class<*>,
    override val entitiesSource: PagingDataSource<Entity>

) : BaseFragment<Entity>(
    fragmentId,
    containerId,
    progressShowing
) {
    /**
     * Создается ViewModel для работы со списками с пагинацией
     */
    @ExperimentalPagingApi
    override val viewModel by lazy { PagingBaseViewModel(entitiesSource) }

    /**
     * Создается адаптер для работы со списками с пагинацией
     */
    lateinit var pagingAdapter: PagingAdapter<Entity>

    @ExperimentalPagingApi
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        //действия после отрисовки фрагмента
        super.onActivityCreated(savedInstanceState)
        bindAdapterToContainer()
    }

    /**
     * Передача полученных данных в адаптер
     */
    override suspend fun processResult(it: Any) {
        pagingAdapter.submitData(it as PagingData<Entity>)
    }

    //Присоединение адаптера к списку
    private fun bindAdapterToContainer() {
        //Адаптер присоединяется с учетом обработки случаев отсутствия сети и необходимости
        //подгрузки недостающих данных
        pagingAdapter = PagingAdapter(itemId, viewHolderType, onItemClickListenerForView)
        (container as RecyclerView).adapter = pagingAdapter.withLoadStateFooter(
            LoaderStateAdapter(pagingAdapter::retry)
        )
    }


}
