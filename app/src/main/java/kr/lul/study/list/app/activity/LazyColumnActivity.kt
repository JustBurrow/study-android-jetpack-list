package kr.lul.study.list.app.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kr.lul.study.list.app.ui.theme.ListTheme

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
fun LazyColumnActivityLayout() {
    val context = LocalContext.current
    LazyColumn(content = {})
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ListTheme {
        LazyColumnActivityLayout()
    }
}