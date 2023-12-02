package Dec2

data class Drawing(
    val red: Int,
    val green: Int,
    val blue: Int
) {
    fun isPossibleGivenValues(
        numRed: Int,
        numGreen: Int,
        numBlue: Int
    ) : Boolean {
        return red <= numRed && green <= numGreen && blue <= numBlue
    }
}
