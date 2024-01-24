package kr.ac.kumoh.ce.prof01.jet14lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kr.ac.kumoh.ce.prof01.jet14lazycolumn.ui.theme.Jet14LazyColumnTheme

class MainActivity : ComponentActivity() {
    private val viewModel: SongViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.add(Song("사랑은 늘 도망가", "임영웅"))
        viewModel.add(Song("소주 한 잔", "임창정"))
        viewModel.add(Song("화장을 고치고", "왁스"))
        viewModel.add(Song("멀어져 간 사람아", "박상민"))

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
//    val songs = listOf(
//        "사랑은 늘 도망가",
//        "소주 한 잔",
//        "화장을 고치고",
//        "멀어져 간 사람아",
//    )
    val viewModel: SongViewModel = viewModel()

   LazyColumn(
       verticalArrangement = Arrangement.spacedBy(4.dp),
       contentPadding = PaddingValues(horizontal = 4.dp)
   ) {
       items(viewModel.songs) {
           SongItem(it)
       }
   }
}

@Composable
fun SongItem(song: Song) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(8.dp)
    ) {
        SongTitle(song.title)
        SingerName(song.singer)
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