package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.models.PropertyModel


@Composable
fun SearchResultScreen(viewModel: SearchResultViewModel, onItemClick: (String) -> Unit) {
    val properties by viewModel.properties.observeAsState(emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Search Results",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn {
            items(properties) { property ->
                PropertyItem(property = property, onClick = { onItemClick(property.id.toString()) })
            }
        }
    }
}


@Composable
fun PropertyItem(property: PropertyModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            AsyncImage(
                model = property.photo,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = property.project_name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "${property.attributes.bedrooms} Beds • ${property.attributes.bathrooms} Baths • ${property.attributes.area_size} sqft",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
            Text(
                text = "$${property.attributes.price}/mo",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Green,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
