package com.example.myapplication.android.ui.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.android.ui.helpers.NumberPicker

@Composable
fun NumberTimeCard(label: String, hour: MutableState<Int>) {

    // Create a Card (panel) to display a piece of text and a NumberPicker widget.
    Card(shape = RoundedCornerShape(8.dp),
         border = BorderStroke(1.dp, Color.White),
         elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {

        Row(Modifier.padding(16.dp)) {
            Text(text = label, color = Color.Black, modifier = Modifier.align(Alignment.CenterVertically), style = MaterialTheme.typography.displayMedium)
            Spacer(modifier = Modifier.size(16.dp))
            NumberPicker(hour = hour, range = IntRange(0, 23), onStateChanged = {hour.value = it })
        }
    }
}