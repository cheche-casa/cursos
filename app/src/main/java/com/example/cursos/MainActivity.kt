package com.example.cursos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursos.model.Topic
import com.example.cursos.ui.theme.CursosTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.cursos.data.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CursosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicList(Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun TopicList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(DataSource.topics) { topic ->
            CursosCard(topic)
        }
    }
}

@Composable
fun CursosCard(topic: Topic) {
    Card(modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp)
    ) {
        Row(modifier = Modifier.height(68.dp)){
            Box {
                Image(
                    painter = painterResource(topic.imageResourceId),
                    contentDescription = stringResource(topic.stringResourceId),
                    modifier = Modifier
                        .width(68.dp)
                        .height(68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            TextosCard(topic = topic)
        }
    }
}

@Composable
fun TextosCard(topic: Topic, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
        .height(68.dp)
    ){
        Text(modifier = modifier
            .padding(bottom = 8.dp)
            .align(Alignment.CenterHorizontally),
            text = LocalContext.current.getString(topic.stringResourceId),
            //style = MaterialTheme.typography.bodyMedium,
            fontSize = 10.sp
        )
        TotalCard(topic = topic)
    }
}

@Composable
fun TotalCard(topic: Topic, modifier: Modifier = Modifier){
    Row{
        Image(modifier = Modifier
                .padding(start = 16.dp),
            painter = painterResource(R.drawable.ic_grain),
            contentDescription = null,
            //contentScale = ContentScale.Crop
        )
        Text(modifier = modifier
                .padding(start = 8.dp),
            text = topic.Total.toString(),
            fontSize = 12.sp,
            //style = MaterialTheme.typography.labelMedium,
            //textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CursosPreview() {
    CursosTheme {
        TopicList(Modifier.padding(8.dp))
    }
}