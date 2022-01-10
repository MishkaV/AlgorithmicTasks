fun simpleChecksForString(str: String) {
    val bracketsList = arrayListOf('(', ')', '{', '}', '[', ']')

    if (str.isEmpty() || str.isBlank())
        throw Exception("Empty string")
    str.forEach { bracket ->
        if (bracket !in bracketsList)
            throw Exception("Bad character")
    }
}

fun checkBrackets(str: String): Boolean {
    var roundBracket = 0 // (
    var curlyBracket = 0  // {
    var squareBracket = 0 // [

    simpleChecksForString(str)

    str.forEach { bracket ->
        when (bracket) {
            '(' -> roundBracket++
            '{' -> curlyBracket++
            '[' -> squareBracket++
            ')' -> if (roundBracket > 0) roundBracket-- else throw Exception("Not enough open brackets for $bracket")
            '}' -> if (curlyBracket > 0) curlyBracket-- else throw Exception("Not enough open brackets for $bracket")
            ']' -> if (roundBracket > 0) squareBracket-- else throw Exception("Not enough open brackets for $bracket")
        }
    }
    if (roundBracket != 0 || curlyBracket != 0 || squareBracket != 0)
        return false
    return true
}
