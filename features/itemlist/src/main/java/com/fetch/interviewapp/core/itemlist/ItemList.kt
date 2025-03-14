package com.fetch.interviewapp.core.itemlist

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fetch.core.model.ItemGroup

@Composable
fun ItemsList(
    itemGroups: List<ItemGroup>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(itemGroups.size) { group ->
            GroupCard(
                group = itemGroups[group],
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
        }
    }
}