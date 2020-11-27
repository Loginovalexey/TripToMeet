package ru.triptomeet.ui.mainscreen.impressionscreen.pictures

import ru.triptomeet.R
import ru.triptomeet.model.entity.detailedimpression.ImpressionImage
import ru.triptomeet.ui.base.datasource.IDataSource
import ru.triptomeet.ui.base.fragment.StaticBaseFragment

/**
 * Галерея изображений на экране "Впечатление" (Impression)
 */

class PicturesFragment(entitiesSource: IDataSource) : StaticBaseFragment<ImpressionImage>(
    itemId = R.layout.item_image,
    fragmentId = R.layout.layer_impression_pictures,
    containerId = R.id.picturesLayerInImpressionScreen,
    viewHolderType = ImpressionPicturesViewHolder::class.java,
    entitiesSource = entitiesSource
)