package com.example.testmircod.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpAppCompatFragment
import javax.inject.Inject


abstract class MoxyFragment : MvpAppCompatFragment(), BaseView, HasAndroidInjector {

    companion object {
        private const val TAG = "MoxyFragment"
    }

    @Inject lateinit var androidInjector : DispatchingAndroidInjector<Any>


    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    protected abstract val layout: Int

    private var viewCompositeDisposable: CompositeDisposable? = null

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewCompositeDisposable = CompositeDisposable()
        return inflater.inflate(layout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isProvideEvent())
            view.setOnTouchListener { _, _ -> true }

        onViewPrepare(savedInstanceState)
    }

    protected open fun isProvideEvent(): Boolean = false

    protected fun postThreadView(f: () -> Unit) {
        view?.post(f)
    }

    final override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        onViewDestroyed()
        viewCompositeDisposable?.dispose()
        super.onDestroyView()
    }

    protected open fun onViewPrepare(savedInstanceState: Bundle?) {}

    protected open fun onViewDestroyed() {}

    open fun onBackPressed(): Boolean {
        return false
    }

    override fun showSnackBar(text: String, duration: Int) {
        view?.let {
            Snackbar.make(it, text, duration)
                .show()
        }

    }

}