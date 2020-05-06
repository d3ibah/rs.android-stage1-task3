package subtask5

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.contains("-")) return null

        val numberList = number.toCharArray().toMutableList()

        var resultList = mutableListOf<String>()
        var neighboursArray = emptyArray<Char>()

        number.forEachIndexed { index, charNumber ->
            getNeighbour(charNumber)?.let {
                neighboursArray = it
                neighboursArray.forEach { neighbourChar ->
                    numberList[index] = neighbourChar
                    resultList.add(numberList.toString())
                }
            }

//            result.add()
        }

        var resultArray: Array<String> = emptyArray()
        resultArray.plus(resultList)

        return resultArray
    }

    fun getNeighbour(number: Char) : Array<Char>? {
        return when(number) {
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
