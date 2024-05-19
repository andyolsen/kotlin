package com.example.myapplication.android.ui.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimeZoneCard(timezone: String, hours: Double, time: String, date: String) {

    // Create a box with a white background and internal padding.
    // Effectively this creates a white border around the interior content.
    Box(Modifier
          .fillMaxSize()
          .height(120.dp)
          .background(Color.White)
          .padding(8.dp)) {

        // Create a Card (panel) for all the interior content.
        Card(shape = RoundedCornerShape(8.dp),
             border = BorderStroke(1.dp, Color.Gray),
             elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
             modifier = Modifier.fillMaxWidth()) {

            // Create a box with a white background.
            Box(Modifier.background(color = Color.White).padding(16.dp)) {

                // Create a horizontal row.
                Row(Modifier.fillMaxWidth()) {

                    // The LHS column of the row, left-aligned.
                    Column(horizontalAlignment = Alignment.Start) {

                        // The name of the timezone (e.g. Europe/Copenhagen.
                        Text(text = timezone,
                             style = TextStyle(
                                 color = Color.Black,
                                 fontWeight = FontWeight.Bold,
                                 fontSize = 20.sp)
                            )

                        Spacer(Modifier.weight(1.0f))

                        // The number of hours different from the current timezone.
                        Row {
                            Text(text = hours.toString(),
                                 style = TextStyle(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp)
                            )
                            Text(text = " hours from local",
                                 style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 14.sp)
                            )
                        }
                    }

                    // A bit of space.
                    Spacer(modifier = Modifier.weight(1.0f))

                    // The RHS column of the row, right-aligned.
                    Column(horizontalAlignment = Alignment.End) {

                        // The current time in the timezone.
                        Text(text = time,
                             style = TextStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp)
                        )

                        Spacer(Modifier.weight(1.0f))

                        // The current date in the timezone.
                        Text(text = date,
                             style = TextStyle(
                                color = Color.Black,
                                fontSize = 12.sp)
                        )
                    }
                }
            }
        }
    }
}