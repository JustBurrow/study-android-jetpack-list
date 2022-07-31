package kr.lul.study.list.model

import kr.lul.study.list.domain.Data

interface DataModel {
    fun load(offset: Long): List<Data>
}
