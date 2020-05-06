package subtask4

import kotlin.math.pow
import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 3) return null
        val square = number * number
        val previousRootSquare = number - 1

        val temp = getMemberList(square, previousRootSquare)
        return temp
    }

    private fun getMemberList(inputRemain: Int, previousRootSquare: Int): Array<Int>? {
        for (currentRoot in previousRootSquare downTo 1 step 1) {
            val currentRemain = inputRemain - currentRoot.toDouble().pow(2)

            if (currentRemain < 0) return null

            if (currentRemain == 0.0) return arrayOf(currentRoot)

            val square = sqrt(currentRemain).toInt()
            val nextSquareRoot =
                if (square >= currentRoot) getMemberList(currentRemain.toInt(), currentRoot - 1)
                else getMemberList(currentRemain.toInt(), square)

            return if (nextSquareRoot?.isNotEmpty() == true) {
                nextSquareRoot + arrayOf(currentRoot)
            } else null
        }

        return null
    }
}
