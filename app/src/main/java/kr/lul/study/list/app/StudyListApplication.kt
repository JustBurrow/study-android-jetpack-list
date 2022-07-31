package kr.lul.study.list.app

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import kr.lul.study.list.model.DataModel
import javax.inject.Inject

@HiltAndroidApp
class StudyListApplication : Application() {
    companion object {
        val TAG = StudyListApplication::class.simpleName
    }

    @Inject
    lateinit var dataModel: DataModel

    override fun onCreate() {
        Log.v(TAG, "#onCreate start.")
        super.onCreate()

        Log.v(TAG, "#onCreate : dataModel=$dataModel")
    }
}