package com.example.myapplication.android.ui.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.myapplication.android.R

// This @Composable function creates a dialog box, so the user can see meeting times feasible for all selected timezones.
@Composable
fun MeetingDialog(
    hours: List<Int>,
    onDismiss: () -> Unit) {

    Dialog(onDismiss) {

        // The entire UI for this dialog will be a single column. The column will display:
        //   - The text "Meeting times".
        //   - A list of all feasible meeting times.
        //   - A "Done" button.
        Column(Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {

            val listState = rememberLazyListState()

            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Meeting Times",
                style = MaterialTheme.typography.bodyMedium
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth().height(170.dp),
                contentPadding = PaddingValues(16.dp),
                state = listState,
                ) {

                items(hours) { hour ->
                    Surface(
                        modifier = Modifier.padding(8.dp).fillMaxWidth(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(hour.toString())
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.size(16.dp))

            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { onDismiss() }
            ) {
                Text("Done")
            }
        }
    }
}