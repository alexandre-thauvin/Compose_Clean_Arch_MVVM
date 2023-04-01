package alexandrethauvin.test.mediaretriever.ui.composables

import alexandrethauvin.test.mediaretriever.R
import alexandrethauvin.test.mediaretriever.WindowSize
import alexandrethauvin.test.mediaretriever.collectAsLifecycleAwareState
import alexandrethauvin.test.mediaretriever.models.Media
import alexandrethauvin.test.mediaretriever.models.MediaFetchingState
import alexandrethauvin.test.mediaretriever.rememberWindowSizeClass
import alexandrethauvin.test.mediaretriever.ui.theme.MediaRetrieverTheme
import alexandrethauvin.test.mediaretriever.ui.viewmodels.MainScreenViewModel
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen() {
    val viewModel: MainScreenViewModel = hiltViewModel()
    val state by viewModel.mediaFetchingState.collectAsLifecycleAwareState()

    MainScreenContent(state = state, viewModel::setNeutralState)
}

@Composable
private fun MainScreenContent(state: MediaFetchingState, setNeutralState: () -> Unit) {
    val isExpanded = LocalContext.current.rememberWindowSizeClass() == WindowSize.Expanded

    when (state) {
        is MediaFetchingState.Success -> {
            if (isExpanded) {
                ExpandedContent(mediaList = state.mediaList)
            } else {
                CompactContent(mediaList = state.mediaList)
            }
        }

        is MediaFetchingState.Error -> {
            Toast.makeText(LocalContext.current, stringResource(id = R.string.unknown_error), Toast.LENGTH_LONG).show()
            setNeutralState()
        }

        is MediaFetchingState.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .wrapContentSize(),
                    color = Color.Blue,
                    strokeWidth = ProgressIndicatorDefaults.CircularStrokeWidth
                )
            }
        }
        else -> { }
    }
}

@Composable
private fun ExpandedContent(
    modifier: Modifier = Modifier,
    mediaList: List<Media>
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        content = {
            itemsIndexed(items = mediaList) { index, media ->
                MediaItem(modifier = Modifier.heightIn(min = 180.dp), media = media)
            }
        })
}

@Composable
private fun CompactContent(
    modifier: Modifier = Modifier,
    mediaList: List<Media>
) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(mediaList) {
            MediaItem(media = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MediaRetrieverTheme {
        MainScreenContent(
            MediaFetchingState.Success(
                listOf(Media(title = "toto", duration = 1000, urn = "my urn"))
            ), { }
        )
    }
}