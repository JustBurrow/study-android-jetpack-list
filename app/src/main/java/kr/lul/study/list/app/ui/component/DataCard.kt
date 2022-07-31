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
    /**
     * `body`가 너무 길어서 요약됐는지 여부.
     * @return 요약해야 할 길이면 `true`.
     */
    fun Data.bodySummarized(): Boolean = 50 < body.length

    /**
     * 본문이 너무 길어서 화면에 전부 출력하기 어려울 때 쓰는 요약하기.
     */
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
            .padding(3.dp), // 외곽선은 여백(패딩) 안쪽으로 생긴다.
        shape = MaterialTheme.shapes.medium,    // 둥근 외곽선
        elevation = 6.dp    // 그림자 표시용.
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(6.dp)  // 외곽선 안쪽에 여백을 주기 위해  사용.
        ) {
            Text(text = data.title, color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(3.dp))    // 제목과 본문 사이의 공간.
            Text(text = data.bodySummarize(), color = Color.Gray, fontSize = 15.sp)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DataCardPreview() {
    DataCard(Data(1L, "title tile title title", "body ".repeat(50).trim()))
}