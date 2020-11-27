package ru.triptomeet.ui.mainscreen.impressionscreen.pictures

import ru.triptomeet.model.entity.detailedimpression.ImpressionImage
import ru.triptomeet.ui.base.datasource.StaticDataSource

/**
 * Объект этого класса передается в конструктор класса ImpressionPicturesFragment
 * для показа данных в разделе отзывов.
 */

class PicturesMockDataSource(private val pictures: List<ImpressionImage>) :
    StaticDataSource<ImpressionImage>() {
    override suspend fun getData(): List<ImpressionImage> = pictures
}

