package subtask5

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.contains("-")) return null

        val resultList = mutableListOf<String>()
        var neighboursArray: Array<Char>

        number.forEachIndexed { index, charNumber ->
            val numberList = number.toCharArray().toMutableList()
            getNeighbour(charNumber)?.let {
                neighboursArray = it
                neighboursArray.forEach { neighbourChar ->
                    numberList[index] = neighbourChar
                    var string: String = ""
                    numberList.forEach {
                        string += it
                    }
                    resultList.add(string)
                }
            }
        }

        return resultList.map { it }.toTypedArray()
    }

    fun getNeighbour(number: Char): Array<Char>? {
        return when (number) {
            '0' -> arrayOf('8')
            '1' -> arrayOf('2', '4')
            '2' -> arrayOf('1', '3', '5')
            '3' -> arrayOf('2', '6')
            '4' -> arrayOf('1', '5', '7')
            '5' -> arrayOf('2', '4', '6', '8')
            '6' -> arrayOf('3', '5', '9')
            '7' -> arrayOf('4', '8')
            '8' -> arrayOf('5', '7', '9', '0')
            '9' -> arrayOf('6', '8')
            else -> null
        }
    }
}
