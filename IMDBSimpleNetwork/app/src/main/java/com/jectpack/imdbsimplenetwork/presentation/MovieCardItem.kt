package com.jectpack.imdbsimplenetwork.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jectpack.imdbsimplenetwork.data.network.model.Edge

@Composable
fun MovieCard(edge: Edge) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),

        ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            AsyncImage(
                modifier = Modifier
                    .heightIn(200.dp)
                    .width(150.dp)
                    .padding(10.dp)
                    .align(Alignment.CenterVertically),
                model = edge.node.entity.primaryImage.url,
                contentDescription = "Image for ${edge.node.entity.titleText}",
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 15.dp)
            ) {
                Text(
                    text = "Title Goes Here",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp) // Space between title and ratings
                )

                Text(
                    text = "Ratings: 4.5/5", // Example rating
                    modifier = Modifier.padding(bottom = 8.dp) // Space between ratings and description
                )

                Text(
                    text = "This is a description of the item. It provides additional information about the item shown in the image.",
                    maxLines = 3, // Limit the number of lines to display
                    overflow = TextOverflow.Ellipsis // Handle overflow with ellipsis
                )
                Spacer(modifier = Modifier.weight(1f)) // Takes up remaining space
                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier
                        .align(Alignment.End)
                        // Align to the bottom end (right)
                        .padding(16.dp) // Add padding to position away from the edges
                ) {
                    Text(text = "Next")
                }

            }

        }
    }

}