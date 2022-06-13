package thingy.trade.data

import thingy.trade.model.QuoteTag
import thingy.trade.model.WatchList

class WatchListRepository(val stockRepository: StockRepository) : Repository<WatchList> {

    override fun findAll(): List<WatchList> {
        return listOf(
            WatchList(
                "TSX", "CA",
                QuoteTag(current = 20_274.82, change = -298.07, percentage = -1.41),
                stockRepository.find(mapOf(StockRepository.WATCH_LIST_NAME to "TSX"))
            )
        )
    }

    override fun find(params: Map<String, Any>): List<WatchList> {
        return listOf()
    }
}