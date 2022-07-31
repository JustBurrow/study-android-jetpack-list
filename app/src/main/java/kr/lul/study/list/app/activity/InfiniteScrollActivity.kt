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
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import kr.lul.study.list.app.activity.InfiniteScrollActivity.Companion.TAG
import kr.lul.study.list.app.ui.component.DataCard
import kr.lul.study.list.app.ui.theme.ListTheme
import kr.lul.study.list.domain.Data
import kr.lul.study.list.viewmodel.InfiniteScrollViewModel

@AndroidEntryPoint
class InfiniteScrollActivity : ComponentActivity() {
    companion object {
        val TAG = InfiniteScrollActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(TAG, "#onCreate args : savedInstanceState=$savedInstanceState")
        super.onCreate(savedInstanceState)

        setContent {
            ListTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    InfiniteScrollActivityLayout()
                }
            }
        }
    }
}

@Composable
fun InfiniteScrollActivityLayout(
    dummyList: List<Data>? = null,
    viewModel: InfiniteScrollViewModel = viewModel()
) {
    val listState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentPadding = PaddingValues(3.dp),
        state = listState
    ) {
        val items = dummyList ?: viewModel.list
        if (items.isEmpty()) {
            viewModel.load()
        }
        Log.v(TAG, "#layout : items=$items")
        items(items) {
            DataCard(it)
        }
    }

    listState.OnBottomReached {
        Log.v(TAG, "#onBottomReached")
        viewModel.load()
    }
}

/**
 * - 다음 데이터를 읽어야 하는지 판단.
 * - 다음 데이터 로딩.
 */
@Composable
fun LazyListState.OnBottomReached(
    loadMore: () -> Unit
) {
    /**
     * 다음 데이터를 로딩해야 하는지 판단.
     */
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisible = layoutInfo.visibleItemsInfo.lastOrNull()
                ?: return@derivedStateOf true
            lastVisible.index == layoutInfo.totalItemsCount - 1
        }
    }

    // 실행시 `shouldLoadMore`를 모니터링.
    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .collect {
                if (it) { // 다음 로딩 상태가 `true`가 되면
                    loadMore() // 새 데이터 로딩.
                }
            }
    }
}

@Preview(showBackground = true)
@Composable
fun InfiniteScrollActivityPreview() {
    ListTheme {
        InfiniteScrollActivityLayout(DUMMY_DATA)
    }
}