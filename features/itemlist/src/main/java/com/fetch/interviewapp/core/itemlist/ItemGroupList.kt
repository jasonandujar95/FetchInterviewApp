package com.fetch.interviewapp.core.itemlist

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fetch.core.model.ItemGroup

@Composable
fun ItemGroupsList(
    itemGroups: List<ItemGroup>,
    modifier: Modifier = Modifier,
    groupContent: @Composable (ItemGroup) -> Unit
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(itemGroups) { group ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                groupContent(group)
            }
        }
    }
}