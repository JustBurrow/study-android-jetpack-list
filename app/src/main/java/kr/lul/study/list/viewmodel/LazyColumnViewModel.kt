package kr.lul.study.list.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.lul.study.list.domain.Data
import kr.lul.study.list.model.DataModel
import javax.inject.Inject

@HiltViewModel
class LazyColumnViewModel @Inject constructor() : ViewModel() {
    companion object {
        val TAG = LazyColumnViewModel::class.simpleName
    }

    @Inject
    lateinit var dataModel: DataModel

    fun load(): List<Data> = dataModel.load(0L)
}
