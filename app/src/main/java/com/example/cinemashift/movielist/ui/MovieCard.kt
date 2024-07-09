package com.example.cinemashift.movielist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.cinemashift.R
import com.example.cinemashift.movielist.data.model.Movie

@Composable
fun MovieCard(movieItem: Movie)
{
    Card(
        modifier = Modifier
            .fillMaxSize(0.9f)
            .padding(10.dp),
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://shift-backend.onrender.com${movieItem.img}"),
                contentDescription = movieItem.originalName,
                modifier = Modifier.size(400.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                    .background(Color.White)
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = movieItem.genres[0],
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = movieItem.country.name + ", " + getYearFromDate(movieItem.releaseDate),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
        Column(
            modifier = Modifier.padding(start = 10.dp)) {
            Text(
                text = "${movieItem.name} (${movieItem.ageRating})",
                fontSize = 30.sp,
                color = Color.Black
            )
            Text(text = "Кинопоиск",
                fontSize = 20.sp,
                fontWeight = FontWeight.Light)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                repeat(10) { index ->
                    Icon(
                        painter = rememberAsyncImagePainter(model = R.drawable.star),
                        contentDescription = null,
                        tint = getColorOfStarFromRating(movieItem.userRatings.kinopoisk, index)
                    )
                }
            }
            ElevatedButton(
                onClick = {},
                modifier = Modifier
            ) {
                Text(
                    stringResource(id = R.string.movie_list_button),
                    fontSize = 20.sp
                )
            }
        }
    }
}

fun getYearFromDate(date: String): String
{
    if (date.split(' ').size == 1)
        return date
    else
        return date.split(' ')[2]
}

fun getColorOfStarFromRating(rating: String, index: Int): Color
{
    if (index <= rating.toDouble().toInt())
        return Color.Yellow
    else
        return Color.Black
}