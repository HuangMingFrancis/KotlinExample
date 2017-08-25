package com.francis.kotlinexample.ui.activity

import android.content.Intent
import android.graphics.Typeface
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import com.francis.kotlinexample.R
import com.francis.kotlinexample.mvp.contract.SplashContract
import com.francis.kotlinexample.mvp.presenter.SplashPresenter
import com.francis.kotlinexample.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * 启动时的加载页
 */
class SplashActivity(override var mPresenter: SplashContract.Presenter = SplashPresenter()) :
        BaseMvpActivity<SplashContract.View, SplashContract.Presenter>(), SplashContract.View {
    override fun getLayoutId(): Int {
        //设置全屏
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        return R.layout.activity_splash
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //设置全屏
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
//        setContentView(R.layout.activity_splash)
//    }

    override fun initData() {
        mPresenter.getServerAppVersion()

        //设置字体
        val font: Typeface = Typeface.createFromAsset(this.assets, "fonts/Lobster-1.4.otf")
        tv_name_english.typeface = font
        tv_english_intro.typeface = font

        setAnimation()
    }

    private fun setAnimation() {
        val alphaAnimation = AlphaAnimation(0.1f, 1.0f)
        alphaAnimation.duration = 1000
        val scaleAnimation = ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f)
        scaleAnimation.duration = 1000
        val animationSet = AnimationSet(true)
        animationSet.addAnimation(alphaAnimation)
        animationSet.addAnimation(scaleAnimation)
        animationSet.duration = 1000
        iv_icon_splash.startAnimation(animationSet)
        animationSet.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(Intent(getContext(), HomeActivity::class.java))
                finish()
            }
        })

    }

    override fun initListener() {
    }

}
