package com.example.myapplication.android.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.mutableIntStateOf

import com.example.myapplication.android.ui.theme.MyAppTheme
import com.example.myapplication.android.ui.dialogs.AddTimeZoneDialog
import com.example.myapplication.android.ui.screens.FindMeetingScreen
import com.example.myapplication.android.ui.screens.TimeZoneScreen

// Our application comprises 2 Screen objects (one or the other will be displayed).
sealed class Screen(val title: String) {
    data object TimeZonesScreen : Screen("Timezones")   // This is screen 0.
    data object FindTimeScreen  : Screen("Find Time")    // This is screen 1.
}

// Create items to be displayed on the navigation bar at the bottom of the view.
data class BottomNavigationItem(
    val label: String,
    val icon: ImageVector
)

val bottomNavigationItems = listOf(
    BottomNavigationItem(Screen.TimeZonesScreen.title, Icons.Filled.Search),
    BottomNavigationItem(Screen.FindTimeScreen.title,Icons.Filled.Place)
)

// Create the main view (this function receives a @Composable function that creates the top-bar.
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainView(topBarFun: @Composable (Int) -> Unit) {

    // JetPack Compose uses the "remember" function to retain state for a @Composable item across recomposes (re-displays).
    val screenToDisplay = remember { mutableIntStateOf(0) }
    val showAddDialog = remember { mutableStateOf(false) }

    // Hold an observable collection of time zones. When the collection changes, it will trigger a recompose.
    val currentTimezoneStrings = remember { SnapshotStateList<String>() }

    // Call MyAppTheme(), and pass in a @Composable lambda that specifies the content to display in that theme.
    MyAppTheme {

        // Call Scaffold(), and pass in a @Composable lambda to build the UI content.
        Scaffold(

            // Set the topBar parameter to a @Composable function (lambda).
            topBar = { topBarFun(screenToDisplay.value) },

            // Set the floatingActionButton parameter to a @Composable function (lambda).
            floatingActionButton = {

                // If the current screen is the "timezones" screen...
                if (screenToDisplay.value == 0) {

                    // Create a FloatingActionButton object to display a "+" icon.
                    FloatingActionButton(
                        modifier = Modifier.padding(16.dp),
                        onClick = { showAddDialog.value = true }
                    ) {
                        Icon(Icons.Default.Add,null)
                    }
                }
            },

            // Set the bottomBar parameter to a @Composable function (lambda).
            bottomBar = {

                // Create a NavigationBar object to let the user choose which screen to display.
                NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {

                    // Create all the navigation bar items.
                    bottomNavigationItems.forEachIndexed { i, bottomNavigationItem ->

                        NavigationBarItem(
                            colors = NavigationBarItemDefaults.colors(selectedTextColor=Color.White, unselectedTextColor=Color.Black),
                            label = { Text(bottomNavigationItem.label, style = MaterialTheme.typography.displaySmall) },
                            icon = { Icon(bottomNavigationItem.icon, contentDescription = bottomNavigationItem.label) },
                            selected = screenToDisplay.value == i,
                            onClick = { screenToDisplay.value = i }
                        )
                    }
                }
            }
        ) {

            // Decide whether to display the "Add timezone" dialog box.
            if (showAddDialog.value) {

                // Create an AddTimeZoneDialog object to let the user add a new time zone.
                AddTimeZoneDialog(

                    // When the user clicks "Add", add the new timezone (if not already added), and close the dialog.
                    onAdd = { newTimezones ->
                        showAddDialog.value = false
                        for (zone in newTimezones) {
                            if (!currentTimezoneStrings.contains(zone)) {
                                currentTimezoneStrings.add(zone)
                            }
                        }
                    },

                    // When the user clicks "Cancel",  close the dialog.
                    onDismiss = { showAddDialog.value = false }
                )
            }

            // Decide which screen to display in the main view.
            when (screenToDisplay.value) {
                0 -> TimeZoneScreen(currentTimezoneStrings)
                1 -> FindMeetingScreen(currentTimezoneStrings)
            }
        }
    }
}