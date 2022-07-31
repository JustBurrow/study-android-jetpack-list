package kr.lul.study.list.app.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.lul.study.list.domain.Data
import kotlin.math.min

@Composable
fun DataView(data: Data) {
    Column(modifier = Modifier.padding(3.dp)) {
        Text(text = data.title, color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = data.body.substring(0, min(50, data.body.length)), color = Color.Gray, fontSize = 15.sp)
    }
}

@Composable
@Preview(showBackground = true)
fun DataViewPreview() {
    DataView(Data(1L, "title tile title title", "body ".repeat(50).trim()))
}