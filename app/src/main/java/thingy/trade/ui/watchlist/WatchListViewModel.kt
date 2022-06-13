package thingy.trade.ui.watchlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import thingy.trade.data.WatchListRepository

class WatchListViewModel(private val watchListRepository: WatchListRepository) : ViewModel() {

    private val _watchList: MutableStateFlow<WatchListsViewState> = MutableStateFlow(WatchListsViewState.Idle)
    val watchList: StateFlow<WatchListsViewState> = _watchList

    init {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                _watchList.emit(WatchListsViewState.Success(watchListRepository.findAll()))
            } catch (e: Exception) {
                _watchList.emit(WatchListsViewState.Error(e.message.toString()))
            }
        }
    }
}