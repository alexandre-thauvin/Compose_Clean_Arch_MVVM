package alexandrethauvin.test.mediaretriever.internal

import alexandrethauvin.test.mediaretriever.api.MediaService
import javax.inject.Inject

internal class MediaDatasource @Inject constructor(private val mediaService: MediaService) {

    suspend fun getLatestEpisodes() = mediaService.getLatestEpisodes()
}