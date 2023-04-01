package alexandrethauvin.test.mediaretriever.models

internal sealed class MediaFetchingState {
    data class Success(val mediaList: List<Media>): MediaFetchingState()
    object Error: MediaFetchingState()
    object Loading: MediaFetchingState()

    object Neutral: MediaFetchingState()
}