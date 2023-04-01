package alexandrethauvin.test.mediaretriever.ui.composables

import alexandrethauvin.test.mediaretriever.models.Media
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val spacerHeight = 24.dp
private val textHorizontalPadding = 8.dp

@Composable
internal fun MediaItem(
    modifier: Modifier = Modifier,
    media: Media
) {
    Column(
        modifier = modifier
            .border(border = BorderStroke(1.dp, color = Color.Black))
    )
    {
        Spacer(
            modifier = Modifier
                .height(spacerHeight)
                .fillMaxWidth()
        )
        Text(
            modifier = Modifier.padding(horizontal = textHorizontalPadding),
            text = media.title,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            modifier = Modifier.padding(horizontal = textHorizontalPadding),
            text = media.duration.toString(),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(
            modifier = Modifier
                .height(spacerHeight)
                .fillMaxWidth()
        )
    }
}