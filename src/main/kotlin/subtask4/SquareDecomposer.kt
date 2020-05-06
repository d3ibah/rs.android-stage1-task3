package subtask4

import kotlin.math.pow
import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {

        var square = number * number
//
//        var nextNumber = number - 1
//
//        var nextSquare = nextNumber * nextNumber
//
//        var remain = square - nextSquare
//
//        if (remain > 1) {
//            var rootSquare = sqrt(remain.toDouble()).toInt()
//        }

//        val squareList = mutableListOf<Int>()
//        val someObjectList = mutableListOf<SomeObject>()
//        for (num in number-1 downTo 1 step 1) {
//            squareList.add(num*num)
//        }


//        getNextPart(number - 1)?.let {
//            someObjectList.add(it)
//        }

//        squareList.forEach {
//
//            println("square is $it")
//        }

//        throw NotImplementedError("Not implemented")
        return getNextPart(square, number)
    }

    fun getNextPart(inputRemain: Int, previousRootSquare: Int): Array<Int>? {
        for (currentRoot in previousRootSquare downTo 1) {
            var currentRemain = inputRemain - currentRoot.toDouble().pow(2)
            if (currentRemain < 0) return null
            if (currentRemain == 0.0) return arrayOf(currentRoot.toInt())

            val square = sqrt(currentRemain).toInt()
            val nextSquareRoot =
                if (square >= currentRoot) getNextPart(currentRemain.toInt(), currentRoot - 1)
                else getNextPart(currentRemain.toInt(), square)

            return if (nextSquareRoot?.isNotEmpty() == true) { nextSquareRoot + arrayOf(currentRoot) }
            else null
        }

        return null
    }
}

class SomeObject(private val inputRemain: Int) {
    var rootSquare = sqrt(inputRemain.toDouble()).toInt()
    var outputRemain = inputRemain - (rootSquare * rootSquare)
        get
}
