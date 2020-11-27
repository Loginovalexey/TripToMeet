package ru.triptomeet.ui.mainscreen.impressionscreen.pictures

import android.view.View
import coil.load
import kotlinx.android.synthetic.main.item_image.view.*
import ru.triptomeet.model.entity.detailedimpression.ImpressionImage
import ru.triptomeet.ui.base.onitemclicklistener.IOnItemClickListener
import ru.triptomeet.ui.base.viewholder.BaseViewHolder

/**
 *  Класс для отрисовки изображения в галерее в соответствии с полученными данными
 */

class ImpressionPicturesViewHolder(itemView: View) : BaseViewHolder<ImpressionImage>(itemView) {

    override fun onBind(item: ImpressionImage, onItemClickListener: IOnItemClickListener?): View {
        super.onBind(item, onItemClickListener)
        itemView.apply {
            impressionTopImage.load(item.imageId)
        }
        return itemView
    }
}