package thingy.trade.data

interface Repository<T> {

    fun findAll(): List<T>

    fun find(params: Map<String, Any>): List<T>
}