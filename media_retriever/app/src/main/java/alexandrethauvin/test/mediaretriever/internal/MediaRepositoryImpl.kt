package alexandrethauvin.test.mediaretriever.internal

import alexandrethauvin.test.mediaretriever.models.Media
import javax.inject.Inject

internal class MediaRepositoryImpl @Inject constructor(private val mediaDatasource: MediaDatasource): MediaRepository {
    override suspend fun getLatestEpisodes(): List<Media> = mediaDatasource.getLatestEpisodes().mediaList
}