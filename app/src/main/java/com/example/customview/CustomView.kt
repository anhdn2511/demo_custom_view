package com.example.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

@SuppressLint("ResourceAsColor")
class CustomView(ctx: Context, attrs: AttributeSet? = null,) : View(ctx, attrs) {
    private val TAG = "customView"
    private val mTitle = "View"
    private val mDescription = "Description bla bla"
    private val mImage = ResourcesCompat.getDrawable(resources, R.drawable.ic_launcher_background, null)
    private val mButton = RectF()
    private val mTextButton = "Continue"

    private val mTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    private val mButtonPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mTextButtonPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)

    private val mImageSize = (100 * resources.displayMetrics.density).toInt()
    private val mButtonWidth = (80 * resources.displayMetrics.density).toInt()
    private val mButtonHeight = (25 * resources.displayMetrics.density).toInt()

    init {
        mTextPaint.color = Color.BLACK
        mTextPaint.textSize = 14 * resources.displayMetrics.scaledDensity
        mTextPaint.textAlign = Paint.Align.LEFT

        mButtonPaint.color = Color.parseColor("#2FAE5F")
        mButtonPaint.textSize = 14 * resources.displayMetrics.scaledDensity

        mTextButtonPaint.color = Color.WHITE
        mTextButtonPaint.textSize = 14 * resources.displayMetrics.scaledDensity
        mTextButtonPaint.textAlign = Paint.Align.CENTER
        mTextButtonPaint.typeface = Typeface.DEFAULT_BOLD
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.d(TAG, "onMeasure")
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = mImageSize

        val resolvedWidth = resolveSize(width, widthMeasureSpec)
        val resolvedHeight = resolveSize(height, heightMeasureSpec)

        val measuredWidth = MeasureSpec.makeMeasureSpec(resolvedWidth, widthMeasureSpec)
        val measuredHeight = MeasureSpec.makeMeasureSpec(resolvedHeight, heightMeasureSpec)

        setMeasuredDimension(measuredWidth, measuredHeight)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        mImage?.setBounds(0, 0, mImageSize, mImageSize)
        mButton.set((measuredWidth - mButtonWidth).toFloat(),
            (mImageSize - mButtonHeight).toFloat(),
            measuredWidth.toFloat(),
            measuredHeight.toFloat()
        )
    }

    override fun onDraw(canvas: Canvas?) {
        Log.d(TAG, "onDraw")

        drawTitle(canvas)
        drawDescription(canvas)
        drawImage(canvas)
        drawContinueButton(canvas)
    }

    private fun drawTitle(canvas: Canvas?) {
        val x = mImageSize + mTextPaint.textSize/2
        val y = mTextPaint.textSize * 3 /2
        canvas?.drawText(mTitle, x, y, mTextPaint)
    }

    private fun drawDescription(canvas: Canvas?) {
        val x = mImageSize + mTextPaint.textSize/2
        val y = mTextPaint.textSize * 7/2
        canvas?.drawText(mDescription, x, y, mTextPaint)
    }

    private fun drawImage(canvas: Canvas?) {
        if (canvas != null) {
            mImage?.draw(canvas)
        }
    }

    private fun drawContinueButton(canvas: Canvas?) {
        canvas?.drawRoundRect(mButton, 20F, 20F, mButtonPaint)
        val x = mButton.centerX()
        val y = mButton.centerY() + mTextButtonPaint.textSize/3
        canvas?.drawText(mTextButton, x, y, mTextButtonPaint)
    }


}