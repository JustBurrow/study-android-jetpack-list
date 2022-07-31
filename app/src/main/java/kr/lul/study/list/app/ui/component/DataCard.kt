package kr.lul.study.list.app.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.lul.study.list.domain.Data

@Composable
fun DataCard(data: Data) {
    fun Data.bodySummarized(): Boolean = 50 < body.length
    fun Data.bodySummarize(): String {
        return if (bodySummarized())
            "${body.substring(0, 50)}..."
        else
            body
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(3.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(6.dp)
        ) {
            Text(text = data.title, color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = data.bodySummarize(), color = Color.Gray, fontSize = 15.sp)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DataCardPreview() {
    DataCard(Data(1L, "title tile title title", "body ".repeat(50).trim()))
}