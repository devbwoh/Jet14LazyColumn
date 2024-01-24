package kr.ac.kumoh.ce.prof01.jet14lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.prof01.jet14lazycolumn.ui.theme.Jet14LazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jet14LazyColumnTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        SongList()
    }
}

@Composable
fun SongList() {
   LazyColumn(
       verticalArrangement = Arrangement.spacedBy(4.dp),
       contentPadding = PaddingValues(horizontal = 4.dp)
   ) {
       items(30) {
           SongItem(it)
       }
   }
}

@Composable
fun SongItem(index: Int) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(8.dp)
    ) {
        SongTitle("노래 $index")
        SingerName("이 노래를 부른 가수는 $index 입니다")
    }
}

@Composable
fun SongTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer),
        fontSize = 30.sp,
        color = MaterialTheme.colorScheme.primary,
    )
}

@Composable
fun SingerName(name: String) {
    Text(
        text = name,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer),
        fontSize = 20.sp,
        color = MaterialTheme.colorScheme.secondary,
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Jet14LazyColumnTheme {
        MainScreen()
    }
}