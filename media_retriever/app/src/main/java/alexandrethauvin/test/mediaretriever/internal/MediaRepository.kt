package alexandrethauvin.test.mediaretriever.internal

import alexandrethauvin.test.mediaretriever.models.Media

interface MediaRepository {

    suspend fun getLatestEpisodes(): List<Media>
}