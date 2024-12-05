package com.example.tweetytube.presentation.components.top_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tweetytube.R
import com.example.tweetytube.ui.theme.*

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 8.dp, end = 18.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.logo_minimal),
                contentDescription = "Tweety Tube Logo",
                modifier = Modifier.size(70.dp)
            )
            Row {
                Text("Tweety", fontSize = 26.sp, color = primaryLight, fontWeight = FontWeight.Bold)
                Text("Tube", fontSize = 26.sp, color = MaterialTheme.colorScheme.outline)
            }
        }
        Row {
            Icon(
                modifier = Modifier
                    .size(26.dp)
                    .clickable{ TODO("Implement Search") },
                painter = painterResource(id = R.drawable.search_solid),
                contentDescription = "Search",
                tint = MaterialTheme.colorScheme.outline
            )
        }
    }
}