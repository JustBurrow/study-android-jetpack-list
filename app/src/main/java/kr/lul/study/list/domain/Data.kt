package kr.lul.study.list.domain

class Data(
    val id: Long,
    val title: String,
    val body: String
) {
    init {
        assert(0L < id)
        assert(title.isNotEmpty())
    }

    override fun toString() = "${Data::class.simpleName}(id=$id, title=$title, body=$body)"
}