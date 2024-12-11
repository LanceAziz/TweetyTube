package com.example.tweetytube.features.movieList.presentation.components.searchFilter

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tweetytube.R

@Composable
fun FilterChip(text:String) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        modifier=Modifier.padding(horizontal = 8.dp),
        onClick = { selected = !selected },
        label = {
            Text(text)
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.search_solid),
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.outline
                )
            }
        } else {
            null
        },
    )
}
