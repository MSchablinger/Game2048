package at.htlleonding.mobilecomputing.game2048.engine

data class GameState (
    val board: List<List<Int>> = listOf(
        listOf(0,0,0,0),
        listOf(0,0,0,0),
        listOf(0,0,0,0),
        listOf(0,0,0,0)
    ),
    val name: String = "no name"
)

{
    fun toStringBaseClass(): String {
        return super.toString()
    }
}