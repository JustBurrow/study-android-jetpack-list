package kr.lul.study.list.app.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import kr.lul.study.list.R
import kr.lul.study.list.app.ui.theme.ListTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : ComponentActivity() {
    companion object {
        val TAG = MainActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(TAG, "#onCreate args : savedInstanceState=$savedInstanceState")
        super.onCreate(savedInstanceState)

        setContent {
            ListTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainActivityLayout()
                }
            }
        }
    }
}

@Composable
fun MainActivityLayout() {
    val context = LocalContext.current
    Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            context.startActivity(Intent(context, LazyColumnActivity::class.java))
        }) {
            Text(
                text = context.getString(R.string.main_nav_target_label_lazy_column),
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            context.startActivity(Intent(context, InfiniteScrollActivity::class.java))
        }) {
            Text(
                text = context.getString(R.string.main_nav_target_infinite_scroll),
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    ListTheme {
        MainActivityLayout()
    }
}