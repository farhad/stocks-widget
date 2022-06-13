package thingy.trade.data

import thingy.trade.model.QuoteTag
import thingy.trade.model.Stock

class StockRepository : Repository<Stock> {

    companion object {
        const val WATCH_LIST_NAME = "watch_list_name"
    }

    override fun findAll(): List<Stock> {
        throw IllegalArgumentException("use find() method")
    }

    override fun find(params: Map<String, Any>): List<Stock> {
        return when (params[WATCH_LIST_NAME].toString()) {

            "TSX" -> {
                listOf(
                    Stock(
                        "CVE", "Cenous Energy Inc.", 12_523_457.00,
                        ask = QuoteTag(30.09, -0.61, -1.99),
                        bid = QuoteTag(30.05)
                    ),
                    Stock(
                        "BTE", "Baytex Energy Corp", 10_894_579.00,
                        ask = QuoteTag(8.84),
                        bid = QuoteTag(8.82, -0.18, -2.00),
                    ),
                    Stock(
                        "SU", "Suncor Energy Inc", 9_971_100.00,
                        ask = QuoteTag(52.78, -0.27, -0.51),
                        bid = QuoteTag(52.73)
                    )
                )
            }

            "TSXV" -> {
                listOf()
            }

            "DJIA" -> {
                listOf()
            }

            "NASDAQ" -> {
                listOf()
            }

            "S&P 500" -> {
                listOf()
            }

            "FTSE 100" -> {
                listOf()
            }

            "Hang Seng" -> {
                listOf()
            }

            "Nikkei 255" -> {
                listOf()
            }
            else -> listOf()
        }
    }
}