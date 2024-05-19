package com.example.myapplication.android.ui.cards

import androidx.compose.runtime.Composable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text

import com.example.myapplication.android.ui.theme.myTypography

@Composable
fun LocalTimeCard(city: String, time: String, date: String) {

    // Create a box with a white background and internal padding.
    // Effectively this creates a white border around the interior content.
    Box(Modifier
          .fillMaxWidth()
          .height(140.dp)
          .background(Color.White)
          .padding(8.dp)
    ) {

        // Create a Card (panel) for all the interior content.
        Card(shape = RoundedCornerShape(8.dp),
             elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
             modifier = Modifier.fillMaxWidth()) {

            // Create a box with a blue-ish background.
            Box(Modifier.background(Color(0xFF1e88e5)).padding(8.dp)) {

                // Create a horizontal row
                Row(Modifier.fillMaxWidth()) {

                    // The LHS column of the row, left-aligned.
                    Column(horizontalAlignment = Alignment.Start) {
                        Spacer(modifier = Modifier.weight(1.0f))
                        Text("Your Location", style = myTypography.displayMedium)
                        Spacer(Modifier.height(8.dp))
                        Text(city, style = myTypography.displaySmall)
                        Spacer(Modifier.height(8.dp))
                    }

                    // A bit of space.
                    Spacer(modifier = Modifier.weight(1.0f))

                    // The RHS column of the row, right-aligned.
                    Column(horizontalAlignment = Alignment.End) {
                        Spacer(modifier = Modifier.weight(1.0f))
                        Text(time, style = myTypography.displayLarge)
                        Spacer(Modifier.height(8.dp))
                        Text(date, style = myTypography.displaySmall)
                        Spacer(Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}