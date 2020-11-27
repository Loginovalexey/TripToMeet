package ru.triptomeet.ui.base.fragment

import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.triptomeet.model.entity.Identifiable
import ru.triptomeet.ui.base.DataResult
import ru.triptomeet.ui.base.adapter.IBaseAdapter
import ru.triptomeet.ui.base.adapter.StaticAdapter
import ru.triptomeet.ui.base.datasource.IDataSource
import ru.triptomeet.ui.base.viewmodel.StaticBaseViewModel

/**
 * Обобщенный класс фрагмента для статичных списков (без пагинации)
 * @param fragmentId id фрагмента, содержащего список
 * @param containerId id самого списка (RecyclerView, LinearLayout)
 * @param progressShowing флаг показа прогресса загрузки
 * @param itemId - идентификатор элемента списка
 * @param viewHolderType - тип ViewHolder, согласно которому будут отрисовываться элементы
 * списка и связываться с данными
 * @param entitiesSource - источник данных
 */
abstract class StaticBaseFragment<Entity : Identifiable>(
    fragmentId: Int,
    containerId: Int,
    progressShowing: Boolean = false,
    override val itemId: Int,
    override val viewHolderType: Class<*>,
    override val entitiesSource: IDataSource

) : BaseFragment<Entity>(
    fragmentId,
    containerId,
    progressShowing
) {
    /**
     * ViewModel для статичных списков
     */
    override val viewModel by lazy {
        StaticBaseViewModel<Entity>(entitiesSource)
    }

    /**
     * Обработка результата при получении статичного списка
     */
    override suspend fun processResult(it: Any) {
        when (it) {
            is DataResult.Error -> renderError(it.error)
            is DataResult.Loading -> {//renderLoading(it.isLoading)
                 }
            is DataResult.Success<*> -> renderOk(it.data as List<Entity>?)
        }
    }

    //Измненение и перерисовка элемента списка
    fun <Entity : Identifiable> changeItem(position: Int, newValue: Entity) {
        with(container.adapter as StaticAdapter<*>) {
            items?.toMutableList()?.set(position, newValue)
            notifyItemChanged(position)
        }
    }

    //Получить элемент списка по позиции
    fun <Entity : Identifiable> getItem(position: Int) =
        ((container.adapter as StaticAdapter<*>).items as List)[position]

    //При получении списка к виджету списка присоединяется адаптер с полученным списком
    private fun renderOk(data: List<Entity>?) {
        container.adapter = StaticAdapter(data as MutableList<Entity>,
            itemId,
            viewHolderType,
            onItemClickListenerForView)
    }

    //Действия при получении ошибки
    private fun renderError(error: Throwable) {
        error.message?.let { message ->
            Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
        }
    }
}

private var ViewGroup.adapter: IBaseAdapter?
    get() {
        return if (this is RecyclerView) this.adapter as StaticAdapter<*> else null
    }
    //Конкретизация типа адаптера как [StaticAdapter] для RecyclerView и LinearLayout
    set(adapter) {
        adapter?.let {
            if (this is RecyclerView)
                this.adapter = adapter as StaticAdapter<*>
            else if (this is LinearLayout) {
                this.adapter = adapter as StaticAdapter<*>
            }
        }
    }

//Функция расширения для LinearLayout - отрисовка списка при присоединении адаптера
private var LinearLayout.adapter: StaticAdapter<*>
    get() = adapter
    set(adapter) {
        removeAllViews()
        adapter.items?.let {
            for (position in adapter.items.indices) {
                val holder = adapter.onCreateViewHolder(
                    this, adapter.getItemViewType(position))
                adapter.onBindViewHolder(holder, position)
                addView(holder.itemView)
            }
        }
    }
