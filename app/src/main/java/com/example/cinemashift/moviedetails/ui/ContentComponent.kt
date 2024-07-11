package com.example.cinemashift.moviedetails.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.cinemashift.R
import com.example.cinemashift.common.data.model.Movie

@Composable
fun ContentComponent(movieItem: Movie)
{
    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://shift-backend.onrender.com${movieItem.img}"),
                contentDescription = movieItem.originalName,
                modifier = Modifier
                    .size(400.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)
                    )
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
            Text(text = "IMDB",
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
                        tint = getColorOfStarFromRating(movieItem.userRatings.imdb, index)
                    )
                }
            }
            Text(
                text = stringResource(R.string.movie_details_description),
                fontSize = 30.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = movieItem.description,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                color =  Color.Black
            )
            Text(
                text = stringResource(R.string.movie_details_actors),
                fontSize = 30.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
                )
            Column {
                movieItem.actors.map {
                    Text(
                        text = it.fullName,
                        color = Color.Black,
                        fontSize = 20.sp)
                }
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
