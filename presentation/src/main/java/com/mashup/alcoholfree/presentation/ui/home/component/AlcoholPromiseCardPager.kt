package com.mashup.alcoholfree.presentation.ui.home.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholPromiseCardState
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AlcoholPromiseCardPager(
    modifier: Modifier = Modifier,
    cardList: List<AlcoholPromiseCardState>,
) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        pageCount = cardList.size,
        modifier = modifier,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 40.dp),
    ) { page ->
        AlcoholPromiseCard(
            modifier = Modifier.graphicsLayer {
                val pageOffset = (
                    (pagerState.currentPage - page) + pagerState
                        .currentPageOffsetFraction
                    ).absoluteValue

                lerp(
                    start = 0.85f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f),
                ).also { scale ->
                    scaleX = scale
                    scaleY = scale
                }

                alpha = lerp(
                    start = 0.5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f),
                )
            },
            state = cardList[page],
        )
    }
}