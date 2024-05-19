package com.example.myapplication.android.ui.helpers

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// This @Composable function allows the user to swipe a TimeZone card, to delete it.
@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun <T> AnimatedSwipeDismiss(
    modifier: Modifier = Modifier,
    item: T,
    background: @Composable (dismissedValue: DismissValue) -> Unit,
    content: @Composable (dismissedValue: DismissValue) -> Unit,
    directions: Set<DismissDirection> = setOf(DismissDirection.EndToStart),
    enter: EnterTransition = expandVertically(),
    exit: ExitTransition = shrinkVertically(tween(500)),
    onDismiss: (T) -> Unit
) {
    val dismissState = rememberDismissState( confirmValueChange = {
        if (it == DismissValue.DismissedToStart) {
            onDismiss(item)
        }
        true
    })
    val isDismissed = dismissState.isDismissed(DismissDirection.EndToStart)

    AnimatedVisibility(
        modifier = modifier,
        visible = !isDismissed,
        enter = enter,
        exit = exit
    ) {
        SwipeToDismiss(
            modifier = modifier,
            state = dismissState,
            directions = directions,
            background = { background(dismissState.currentValue) },
            dismissContent = { content(dismissState.currentValue) }
        )
    }
}