package com.example.tweetytube.features.movieList.presentation.components.searchFilter

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tweetytube.ui.theme.*

@Composable
fun FilterChip(text: String, icon: Int, isSelected: Boolean = false, onClick: () -> Unit) {

    FilterChip(
        modifier = Modifier.padding(horizontal = 4.dp),
        onClick = onClick,
        colors = FilterChipDefaults.filterChipColors(
            labelColor = MaterialTheme.colorScheme.outline,
            selectedLabelColor = bgLight,
            selectedLeadingIconColor = bgLight,
            selectedContainerColor = secondaryLight,
        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = isSelected,
            selected = isSelected,
            borderColor = MaterialTheme.colorScheme.primary,
            selectedBorderColor = Color.Transparent,
            borderWidth = 1.dp
        ),
        shape = RoundedCornerShape(32.dp),
        label = {
            Text(text=text, modifier = Modifier.padding(horizontal = 4.dp))
        },
        selected = isSelected,
        leadingIcon = if (isSelected) {
            {
                Icon(
                    modifier = Modifier.size(20.dp).padding(start = 4.dp),
                    painter = painterResource(id = icon),
                    contentDescription = "Search",
                )
            }
        } else {
            null
        },
    )
}
