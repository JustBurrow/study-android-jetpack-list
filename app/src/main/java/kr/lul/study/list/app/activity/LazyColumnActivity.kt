package kr.lul.study.list.app.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import kr.lul.study.list.app.activity.LazyColumnActivity.Companion.TAG
import kr.lul.study.list.app.ui.component.DataCard
import kr.lul.study.list.app.ui.theme.ListTheme
import kr.lul.study.list.domain.Data
import kr.lul.study.list.viewmodel.LazyColumnViewModel

@AndroidEntryPoint
class LazyColumnActivity : ComponentActivity() {
    companion object {
        val TAG = LazyColumnActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(TAG, "#onCreate args : savedInstanceState=$savedInstanceState")
        super.onCreate(savedInstanceState)

        setContent {
            ListTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    LazyColumnActivityLayout()
                }
            }
        }
    }
}

@Composable
fun LazyColumnActivityLayout(
    initContents: List<Data> = listOf(),
    viewModel: LazyColumnViewModel = viewModel()
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentPadding = PaddingValues(3.dp)    // 아이템 목록과 컨테이너 사이의 여백. 자식 UI(아이템. 이경우엔 `DataCard`) 사이의 여백이 아니다.
    ) {
        val items = initContents.ifEmpty { viewModel.load() }
        Log.v(TAG, "#layout : items=$items")
        items(items) {
            DataCard(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnActivityPreview() {
    ListTheme {
        LazyColumnActivityLayout((1..21).map { Data(it.toLong(), "title #$it", "body #$it ".repeat(it).trim()) })
    }
}