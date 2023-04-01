package alexandrethauvin.test.mediaretriever.ui.activities

import alexandrethauvin.test.mediaretriever.ui.composables.MainScreen
import alexandrethauvin.test.mediaretriever.ui.theme.MediaRetrieverTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediaRetrieverTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}