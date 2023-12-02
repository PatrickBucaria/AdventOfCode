package Dec2

data class MinSetPossible(
    val red: Int,
    val green: Int,
    val blue: Int
) {
    fun getPower(): Int {
        return red*green*blue
    }
}
