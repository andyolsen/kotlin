package com.example.myapplication.android.ui.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.myapplication.TimeZoneHelper
import com.example.myapplication.TimeZoneHelperImpl

import kotlinx.coroutines.*

fun isSelected(selectedStates: Map<Int, Boolean>, index: Int): Boolean {
    return (selectedStates.containsKey(index) && (true == selectedStates[index]))
}

// This @Composable function creates a dialog box, so the user can add a timezone.
@Composable
fun AddTimeZoneDialog(
    timezoneHelper: TimeZoneHelper = TimeZoneHelperImpl(),
    onAdd: (List<String>) -> Unit,
    onDismiss: () -> Unit
) = Dialog(onDismissRequest = onDismiss) {

    // The entire UI for this dialog will be a single column. The column will display:
    //   - An OutlinedTextField where the user can enter the name of a timezone to search for.
    //   - A list of all known timezones.
    //   - A "Cancel" button and an "Add" button.

    Column(Modifier
             .fillMaxWidth()
             .background(MaterialTheme.colorScheme.background, RoundedCornerShape(8.dp))
             .padding(16.dp)
    ) {

        // Remember state for this @Composable UI element.
        val timeZoneStrings by remember { mutableStateOf(timezoneHelper.getTimeZoneStrings().toList()) }
        val selectedStates = remember { SnapshotStateMap<Int, Boolean>() }
        val listState = rememberLazyListState()
        val searchValue = remember { mutableStateOf("") }
        val coroutineScope = rememberCoroutineScope()
        val focusRequester = remember { FocusRequester() }

        // Create an OutlinedTextField where the user can enter the name of a timezone to search for.
        OutlinedTextField(

            // We want a single-line text box.
            singleLine = true,

            // Populate the text box with the "remembered" state.
            value = searchValue.value,

            // Get focus initially.
            modifier = Modifier.focusRequester(focusRequester).fillMaxWidth(),

            // On every keystroke, scroll the list of timezones into view.
            onValueChange = {   // NOTE: Lambda starts here.
                searchValue.value = it
                if (searchValue.value.isEmpty()) {

                    // This syntax return@OutlinedTextField is a called a "qualified return". It returns from the current lambda (see NOTE comment above).
                    // If you just said return, it would return from the current function, i.e. OutlinedTextField().
                    return@OutlinedTextField
                }

                // Keystroke by keystroke, search all the available timezones for the one just entered by the user.
                val index = searchZones(searchValue.value, timeZoneStrings = timeZoneStrings)
                if (index != -1) {

                    // Launch a coroutine (like a lightweight thread) to scroll the timezone into view.
                    coroutineScope.launch {listState.animateScrollToItem(index) }
                }
            },

            // Display an X at the end of the text box, to clear the content.
            trailingIcon = {
                IconButton(onClick = { searchValue.value = ""}) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = "Cancel",
                    )
                }
            }
        )

        DisposableEffect(Unit) {
            focusRequester.requestFocus()
            onDispose { }
        }

        Spacer(modifier = Modifier.size(16.dp))

        // Display a list of timezones that the user can select/deselect. It's a "LazyColumn", i.e. only display the ones visible.
        LazyColumn(
            modifier = Modifier.fillMaxWidth().height(170.dp),
            contentPadding = PaddingValues(16.dp),
            state = listState,

            ) {
            itemsIndexed(timeZoneStrings) { i, timezone ->

                // Display a timezone item in the "selected" or "unselected" color.
                Surface(
                    modifier = Modifier.padding(8.dp).fillMaxWidth(),
                    color = if (isSelected(selectedStates,i)) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
                ) {
                    // If the user clicks the item, toggle its selected/unselected state.
                    Row(Modifier
                            .toggleable(
                                value = isSelected(selectedStates, i),
                                onValueChange = { selectedStates[i] = it })
                            .fillMaxWidth(),
                    ) {
                        Text(timezone)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        // Display Cancel and Add buttons.
        Row(modifier = Modifier.align(Alignment.End)) {
            Button(onClick = { onDismiss() } ) {
                Text(text = "Cancel")
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(onClick = { onAdd(getTimezones(selectedStates,timeZoneStrings) )} ) {
                Text("Add")
            }
        }
    }
}

fun searchZones(searchString: String, timeZoneStrings: List<String>): Int {
    var timezone = timeZoneStrings.firstOrNull { it.startsWith(searchString, ignoreCase = true) }
    if (timezone == null) {
        timezone = timeZoneStrings.firstOrNull { it.contains(searchString, ignoreCase = true) }
    }
    if (timezone != null) {
        return timeZoneStrings.indexOf(timezone)
    }
    return -1
}

fun getTimezones(selectedStates: Map<Int, Boolean>, timeZoneStrings: List<String>): List<String> {
    val timezoneIndexes = selectedStates.map { if (it.value) it.key else -1 }
    val timezones = mutableListOf<String>()
    timezoneIndexes.forEach {
        if (it != -1) {
            timezones.add(timeZoneStrings[it])
        }
    }
    return timezones
}