package kr.lul.study.list.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.lul.study.list.domain.Data
import kr.lul.study.list.model.DataModel
import javax.inject.Inject

@HiltViewModel
class InfiniteScrollViewModel @Inject constructor() : ViewModel() {
    companion object {
        val TAG = InfiniteScrollViewModel::class.simpleName
    }

    var list by mutableStateOf(mutableListOf<Data>())
        private set

    @Inject
    lateinit var dataModel: DataModel

    fun load(): List<Data> {
        val list = dataModel.load(0L)
        this.list.addAll(list)
        Log.v(TAG, "#load return : $list")
        return list
    }
}
