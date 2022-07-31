package kr.lul.study.list.model

import android.util.Log
import kr.lul.study.list.domain.Data

class DataModelImpl : DataModel {
    companion object {
        val TAG = DataModelImpl::class.simpleName
    }

    /**
     * @return `offset` 부터 20개의 더미 데이터.
     */
    override fun load(offset: Long): List<Data> {
        Log.v(TAG, "#load args : offset=$offset")

        val data = (offset + 1..offset + 20)
            .map { Data(it, "title #$it", "body $it ".repeat(it.toInt()).trim()) }

        Log.v(TAG, "#load return : $data")
        return data
    }
}