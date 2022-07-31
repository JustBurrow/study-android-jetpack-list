package kr.lul.study.list.app.activity

import kr.lul.study.list.domain.Data

val DUMMY_DATA = (1..21).map {
    Data(it.toLong(), "Title #$it", "body #$it ".repeat(it).trim())
}