package alexandrethauvin.test.mediaretriever.api

import alexandrethauvin.test.mediaretriever.models.Media

interface GetLatestEpisodes {
    suspend operator fun invoke(): List<Media>
}