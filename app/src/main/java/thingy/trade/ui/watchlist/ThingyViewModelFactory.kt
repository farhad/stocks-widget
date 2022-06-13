package thingy.trade.ui.watchlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import thingy.trade.data.StockRepository
import thingy.trade.data.WatchListRepository

class ThingyViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when (modelClass) {
            WatchListViewModel::class -> {
                return WatchListViewModel(WatchListRepository(StockRepository())) as T
            }
        }

        throw IllegalArgumentException()

    }
}