package thingy.trade.model

data class WatchList(
    val symbol: String,
    val country: String,
    val quote: QuoteTag,
    val stocks: List<Stock>
)