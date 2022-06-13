package thingy.trade.model

data class Stock(
    val symbol: String,
    val name: String,
    val volume: Double,
    val ask: QuoteTag,
    val bid: QuoteTag
)