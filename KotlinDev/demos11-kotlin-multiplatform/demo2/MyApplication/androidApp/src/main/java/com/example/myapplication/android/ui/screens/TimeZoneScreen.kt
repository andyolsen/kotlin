package com.example.myapplication.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.TimeZoneHelperImpl
import com.example.myapplication.android.ui.helpers.AnimatedSwipeDismiss
import com.example.myapplication.android.ui.cards.LocalTimeCard
import com.example.myapplication.android.ui.cards.TimeZoneCard
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeZoneScreen(currentTimezoneStrings: SnapshotStateList<String>) {

    // Create a TimezoneHelperImpl instance. This is defined in the shared library (so it's reusable across platforms).
    val timezoneHelper = TimeZoneHelperImpl()

    // A "composable function" (UI element) uses the "remember API" to remember state across multiple re-renders (recompositions).
    val timezones = rememberLazyListState()

    // The entire UI for this screen will be a single column. The column will display:
    //   - A LocalTimeCard panel displaying the current local time.
    //   - A bunch of TimeZoneCard panels displaying time zones selected by the user.
    Column(Modifier.fillMaxSize()) {

        // Remember the current local time (this is mutable, it will be updated every 60 seconds - see the LaunchedEffect below).
        // Note the Kotlin "by" keyword - it's like a computed getter/setter, i.e. whenever you access "time" it'll be via the provided code.
        var time by remember { mutableStateOf(timezoneHelper.currentTime()) }

        // Launch a coroutine (similar to a lightweight thread) to update the current time every 60 seconds.
        LaunchedEffect(Unit) {
            while (true) {
                time = timezoneHelper.currentTime()
                delay(60_000) // Every 60 seconds
            }
        }

        // Display the local time, at the top of the screen.
        LocalTimeCard(
            city = timezoneHelper.currentTimeZone(),
            time = time,
            date = timezoneHelper.getDate(timezoneHelper.currentTimeZone())
        )

        Spacer(modifier = Modifier.size(16.dp))

        // Display a bunch of items vertically stacked (only display the ones in viewport).
        LazyColumn(state = timezones) {

            items(items = currentTimezoneStrings, key = { timezone -> timezone }) { timezoneString ->

                // Allow the user to swipe a TimeZoneCard panel to delete it.
                AnimatedSwipeDismiss(
                    item = timezoneString,
                    background = { _ ->
                        Box(modifier = Modifier
                                        .fillMaxSize()
                                        .height(50.dp)
                                        .background(Color.Red)
                                        .padding(start = 20.dp, end = 20.dp)
                        ) {
                            val alpha = 1f
                            Icon(Icons.Filled.Delete,
                                contentDescription = "Delete",
                                modifier = Modifier.align(Alignment.CenterEnd),
                                tint = Color.White.copy(alpha = alpha)
                            )
                        }
                    },

                    // This is the important bit. Display a TimezoneCard panel.
                    content = {
                        TimeZoneCard(
                            timezone = timezoneString,
                            hours = timezoneHelper.hoursFromTimeZone(timezoneString),
                            time = timezoneHelper.getTime(timezoneString),
                            date = timezoneHelper.getDate(timezoneString)
                        )
                    },
                    onDismiss = { zone ->
                        if (currentTimezoneStrings.contains(zone)) {
                            currentTimezoneStrings.remove(zone)
                        }
                    }
                )
            }
        }
    }
}