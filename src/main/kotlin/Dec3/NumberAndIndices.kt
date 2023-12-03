package Dec3

sealed class GridPosition(
    open val rowIndex: Int,
    open val colIndex: Int
) {
    data class NumberAndIndices(
        val num: Int,
        override val rowIndex: Int,
        override val colIndex: Int,
        val colEndIndex: Int
    ) : GridPosition(rowIndex, colIndex)

    data class Star(
        override val rowIndex: Int,
        override val colIndex: Int
    ) : GridPosition(rowIndex, colIndex)

    data class Nothing(
        override val rowIndex: Int,
        override val colIndex: Int
    ) : GridPosition(rowIndex, colIndex)
}
