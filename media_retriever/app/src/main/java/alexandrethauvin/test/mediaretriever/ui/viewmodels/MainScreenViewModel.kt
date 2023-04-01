package alexandrethauvin.test.mediaretriever.ui.viewmodels

import alexandrethauvin.test.mediaretriever.api.GetLatestEpisodes
import alexandrethauvin.test.mediaretriever.models.MediaFetchingState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class MainScreenViewModel @Inject constructor(private val getLatestEpisodes: GetLatestEpisodes): ViewModel() {

    private val _mediaFetchingState = MutableStateFlow<MediaFetchingState>(MediaFetchingState.Loading)
    val mediaFetchingState = _mediaFetchingState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val result = getLatestEpisodes()
                _mediaFetchingState.emit(MediaFetchingState.Success(result))
            }
            catch (e: Exception){
                Timber.e("error while fetching media list: ${e.localizedMessage}")
                _mediaFetchingState.emit(MediaFetchingState.Error)
            }
        }
    }

    fun setNeutralState() = viewModelScope.launch {
        _mediaFetchingState.emit(MediaFetchingState.Neutral)
    }
}