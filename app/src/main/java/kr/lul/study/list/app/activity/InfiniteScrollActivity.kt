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
    initContents: List<Data> = listOf(),
    viewModel: InfiniteScrollViewModel = viewModel()
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentPadding = PaddingValues(3.dp)
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
fun InfiniteScrollActivityPreview() {
    ListTheme {
        InfiniteScrollActivityLayout(DUMMY_DATA)
    }
}