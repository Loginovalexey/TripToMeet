package ru.triptomeet.ui.splashscreen

import android.graphics.RectF
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator
import com.flaviofaria.kenburnsview.Transition
import com.flaviofaria.kenburnsview.TransitionGenerator
import ru.triptomeet.application.Constants.SPLASH_EPISODE_DURATION
import kotlin.math.abs


//Класс настроек анимации для Splash-экрана

class BackgroundTransitionGenerator : TransitionGenerator {
    private val transitionDuration: Long
    private val transitionInterpolator: Interpolator
    private var lastTransition: Transition? = null
    private var lastDrawableBounds: RectF? = null
    private var forward = false


    companion object {
        private const val DEFAULT_TRANSITION_DURATION = SPLASH_EPISODE_DURATION * 10
        private val DEFAULT_TRANSITION_INTERPOLATOR: Interpolator = LinearInterpolator()
        private var MIN_RECT_FACTOR = 0.9f
        private fun haveSameAspectRatio(r1: RectF, r2: RectF): Boolean {
            return abs(getRectRatio(r1) - getRectRatio(r2)) <= 0.01f
        }

        private fun getRectRatio(rect: RectF): Float {
            return rect.width() / rect.height()
        }

    }

    init {
        transitionDuration = DEFAULT_TRANSITION_DURATION.toLong()
        transitionInterpolator = DEFAULT_TRANSITION_INTERPOLATOR
    }

    fun setMinRectFactor(f: Float) {
        MIN_RECT_FACTOR = f
    }

    override fun generateNextTransition(drawableBounds: RectF, viewport: RectF): Transition? {

        val drawableRatio = getRectRatio(drawableBounds)
        val viewportRectRatio = getRectRatio(viewport)
        val startRect: RectF
        val endRect: RectF
        if (drawableRatio >= viewportRectRatio) {
            val w: Float = drawableBounds.height() * viewportRectRatio
            val h: Float = drawableBounds.height()
            startRect = RectF(0f, 0f, w, h)
            endRect = generateRandomRect(
                drawableBounds,
                viewport
            ) //new RectF((drawableBounds.width() - w), drawableBounds.height(),drawableBounds.width(), h);
        } else {
            val w: Float = drawableBounds.width()
            val h: Float = drawableBounds.width() / viewportRectRatio
            startRect = RectF(0f, 0f, w, h)
            endRect = generateRandomRect(
                drawableBounds,
                viewport
            ) //new RectF(0, drawableBounds.height() - h, w, drawableBounds.height());
        }
        if (!drawableBounds.equals(lastDrawableBounds) || !haveSameAspectRatio(
                lastTransition!!.destinyRect,
                viewport
            )
        ) {
            forward = false
        }
        forward = !forward
        lastTransition = if (forward) {
            Transition(startRect, endRect, transitionDuration, transitionInterpolator)
        } else {
            Transition(endRect, startRect, transitionDuration, transitionInterpolator)
        }
        lastDrawableBounds = RectF(drawableBounds)
        return lastTransition
    }

    private fun generateRandomRect(drawableBounds: RectF, viewportRect: RectF): RectF {
        val drawableRatio = getRectRatio(drawableBounds)
        val viewportRectRatio = getRectRatio(viewportRect)
        val maxCrop: RectF
        maxCrop = if (drawableRatio > viewportRectRatio) {
            val r: Float = drawableBounds.height() / viewportRect.height() * viewportRect.width()
            val b: Float = drawableBounds.height()
            RectF(0f, 0f, r, b)
        } else {
            val r: Float = drawableBounds.width()
            val b: Float = drawableBounds.width() / viewportRect.width() * viewportRect.height()
            RectF(0f, 0f, r, b)
        }
        val factor = MIN_RECT_FACTOR
        val width: Float = factor * maxCrop.width()
        val height: Float = factor * maxCrop.height()
        val widthDiff = (drawableBounds.width() - width)
        val heightDiff = (drawableBounds.height() - height)
        return RectF(
            widthDiff,
            heightDiff,
            widthDiff + width,
            heightDiff + height
        )
    }


}