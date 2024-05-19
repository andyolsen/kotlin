package com.example.myapplication.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.myapplication.TimeZoneHelper
import com.example.myapplication.TimeZoneHelperImpl
import com.example.myapplication.android.ui.dialogs.MeetingDialog
import com.example.myapplication.android.ui.cards.NumberTimeCard
import com.example.myapplication.android.ui.dialogs.isSelected

@Composable
fun FindMeetingScreen(timezoneStrings: List<String>) {

    // Create a TimezoneHelperImpl instance. This is defined in the shared library (so it's reusable across platforms).
    val timezoneHelper: TimeZoneHelper = TimeZoneHelperImpl()

    // Remember various bits of state used in this screen.
    val listState = rememberLazyListState()
    val startTime = remember { mutableIntStateOf(8) }    // 8am
    val endTime   = remember { mutableIntStateOf(17) }   // 5pm

    val selectedTimeZones = remember {
        val selected = SnapshotStateMap<Int, Boolean>()
        for (i in 0..timezoneStrings.size-1)
            selected[i] = true
        selected
    }

    val showMeetingDialog = remember { mutableStateOf(false) }
    val meetingHours = remember { SnapshotStateList<Int>() }

    // Display the "meeting" dialog?
    if (showMeetingDialog.value) {
        MeetingDialog(meetingHours) {
            showMeetingDialog.value = false
        }
    }

    // The entire UI for this screen will be a single column. The column will display:
    //   - Text "Text Range".
    //   - Two NumberTimeCard panels, so the user can choose start and end times.
    //   - Text "Time Zones".
    //   - A bunch of time zones name, with a checkbox to select/deselect.
    //   - "Search" button.
    Column(Modifier.fillMaxSize()) {

        Spacer(Modifier.size(16.dp))

        Text(text = "Time Range",
             modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally),
             style = MaterialTheme.typography.displaySmall)

        Spacer(Modifier.size(16.dp))

        Row(Modifier
              .fillMaxWidth()
              .padding(start = 4.dp, end = 4.dp)
              .wrapContentWidth(Alignment.CenterHorizontally)) {

            Spacer(modifier = Modifier.size(16.dp))
            NumberTimeCard("Start", startTime)
            Spacer(modifier = Modifier.size(32.dp))
            NumberTimeCard("End", endTime)
        }

        Spacer(Modifier.size(16.dp))

        Row(Modifier
              .fillMaxWidth()
              .padding(start = 4.dp, end = 4.dp)) {

            Text(text = "Time Zones",
                 modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally),
                 style = MaterialTheme.typography.displaySmall)
        }

        Spacer(Modifier.size(16.dp))

        LazyColumn(state = listState,
                   modifier = Modifier.weight(0.6F).fillMaxWidth(),
                   contentPadding = PaddingValues(16.dp)) {

            itemsIndexed(timezoneStrings) { i, timezone ->

                Surface(modifier = Modifier.padding(8.dp).fillMaxWidth(),
                        color = MaterialTheme.colorScheme.background) {

                    Row(Modifier.fillMaxWidth()) {
                        Checkbox(checked = isSelected(selectedTimeZones, i), onCheckedChange = {selectedTimeZones[i] = it })
                        Text(timezone, Modifier.align(Alignment.CenterVertically))
                    }
                }
            }
        }

        Spacer(Modifier.weight(0.1f))

        Row(Modifier
              .fillMaxWidth()
              .weight(0.3F)
              .wrapContentWidth(Alignment.CenterHorizontally)
              .padding(start = 4.dp, end = 4.dp)) {

            OutlinedButton(
                colors = ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.primaryContainer, contentColor = MaterialTheme.colorScheme.primary),
                onClick = {
                    meetingHours.clear()
                    meetingHours.addAll(timezoneHelper.search(startTime.value, endTime.value, getSelectedTimezones(timezoneStrings, selectedTimeZones)))
                    showMeetingDialog.value = true
                }) {

                Text("Search")
            }
        }

        Spacer(Modifier.size(16.dp))
    }
}

fun getSelectedTimezones(
    timezoneStrings: List<String>,
    selectedStates: Map<Int, Boolean>
): List<String> {

    val selectedTimezones = mutableListOf<String>()
    selectedStates.keys.map {
        val timezone = timezoneStrings[it]
        if (isSelected(selectedStates, it) && !selectedTimezones.contains(timezone)) {
            selectedTimezones.add(timezone)
        }
    }
    return selectedTimezones
}