package kr.lul.study.list.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.lul.study.list.domain.Data
import kr.lul.study.list.model.DataModel
import javax.inject.Inject

@HiltViewModel
class InfiniteScrollViewModel @Inject constructor(
    private val dataModel: DataModel
) : ViewModel() {
    companion object {
        val TAG = InfiniteScrollViewModel::class.simpleName
    }

    fun load(): List<Data> {
        val list = dataModel.load(0L)
        Log.v(TAG, "#load return : $list")
        return list
    }
}