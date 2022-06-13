package thingy.trade.ui.watchlist

import thingy.trade.model.WatchList

sealed class WatchListsViewState {

    object Idle : WatchListsViewState()
    data class Success(val items: List<WatchList>) : WatchListsViewState()
    data class Error(val message: String) : WatchListsViewState()
}