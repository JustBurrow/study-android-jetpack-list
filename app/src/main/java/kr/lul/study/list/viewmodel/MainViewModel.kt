package kr.lul.study.list.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.lul.study.list.model.DataModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val dataModel: DataModel
) : ViewModel() {
    companion object {
        val TAG = MainViewModel::class.simpleName
    }
}