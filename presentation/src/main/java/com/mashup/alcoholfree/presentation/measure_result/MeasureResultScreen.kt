package com.mashup.alcoholfree.presentation.measure_result

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.theme.Grey800
import com.mashup.alcoholfree.presentation.ui.theme.Grey900
import com.mashup.alcoholfree.presentation.ui.theme.H1
import com.mashup.alcoholfree.presentation.ui.theme.H4
import com.mashup.alcoholfree.presentation.ui.theme.H5
import com.mashup.alcoholfree.presentation.ui.theme.SubPurple
import com.mashup.alcoholfree.presentation.ui.theme.SubPurple16
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle4
import com.mashup.alcoholfree.presentation.ui.theme.White
import com.mashup.alcoholfree.presentation.ui.theme.White40

private val rootHorizontalPadding = 16.dp

@Composable
fun MeasureResultScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        /* TODO: 서버(?)에서 받아올 예정 */
        MeasureResultHeader(
            status = "미쳤다.",
            userName = "우진",
            sojuCount = 4,
        )

        MeasureAlcoholCupCountBox(
            modifier = Modifier.padding(top = 8.dp),
            alcoholCupCount = 25,
        )

        MeasureResultInfoItems(
            modifier = Modifier.padding(
                top = 32.dp,
                start = rootHorizontalPadding,
                end = rootHorizontalPadding
            ),
            kcal = 132,
            alcohol = 16.9f,
            time = "3시간 20분",
        )

        Divider(
            modifier = Modifier.padding(
                top = 40.dp,
                start = rootHorizontalPadding,
                end = rootHorizontalPadding
            ),
            color = White40,
        )
    }
}

@Composable
fun MeasureResultHeader(status: String, userName: String, sojuCount: Int) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "오늘의 주량은?", style = H5, color = Grey900)
        Text(text = status, style = H1, color = White)
        Text(
            text = "평소 ${userName}님의 주량 대비, 소주를 ${sojuCount}잔 더 마셨어요.",
            style = SubTitle3,
            color = Grey800,
        )
    }
}

@Composable
fun MeasureAlcoholCupCountBox(modifier: Modifier = Modifier, alcoholCupCount: Int) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = SubPurple16)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            text = "총 ${alcoholCupCount}잔",
            style = SubTitle3,
            color = SubPurple,
        )
    }
}

@Composable
fun MeasureResultInfoItems(
    modifier: Modifier = Modifier,
    kcal: Int,
    alcohol: Float,
    time: String,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        /* TODO: icon 변경 되어야함 */
        MeasureResultInfoItem(
            imageResId = R.drawable.icon_clock,
            mainText = "$kcal Kcal",
            subText = "오늘 마신 술 칼로리",
        )
        MeasureResultInfoItem(
            imageResId = R.drawable.icon_clock,
            mainText = "${alcohol}%",
            subText = "평균 도수",
        )
        MeasureResultInfoItem(
            imageResId = R.drawable.icon_clock,
            mainText = time,
            subText = "마신 시간",
        )
    }
}

@Composable
fun MeasureResultInfoItem(
    imageResId: Int,
    mainText: String,
    subText: String,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = imageResId), contentDescription = null)
        Text(text = mainText, style = H4, color = White)
        Text(text = subText, style = SubTitle4, color = Grey900)
    }
}

@Preview
@Composable
fun MeasureResultScreenPreview() {
    MeasureResultScreen()
}
