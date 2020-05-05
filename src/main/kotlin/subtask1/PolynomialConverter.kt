package subtask1

import kotlin.math.abs

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isNullOrEmpty()) {
            return null
        }

        var result = ""

        numbers.forEachIndexed { index, item ->
            result += getPart(index, item, numbers.size - 1)
        }

        return result
    }

    private fun getPart(index: Int, item: Int, maxIndex: Int): String {
        if (index == 0) {
            return getFirstElement(maxIndex, item, index)
        }

        if (index == maxIndex)
            return getLastElement(item)

        return getBetweenElement(maxIndex, item, index)
    }

    private fun getFirstElement(maxIndex: Int, item: Int, index: Int): String {
        if (maxIndex == 0) return item.toString()
        if (maxIndex == 1) return "${item}x"
        return "${item}x^${maxIndex - index}"
    }

    private fun getBetweenElement(maxIndex: Int, item: Int, index: Int): String {
        if (item == 0) return ""
        if (index == (maxIndex - 1)) {
            if (item == 1) return " + x"
            if (item == -1) return " - x"
            return if (item > 0) " + ${item}x"
            else " - ${item}x"
        }

        return if (item > 0) {
            if (item == 1) " + x^${maxIndex - index}"
            else " + ${item}x^${maxIndex - index}"
        } else {
            if (item == -1) " - x^${maxIndex - index}"
            else " - ${abs(item)}x^${maxIndex - index}"
        }
    }

    private fun getLastElement(item: Int): String {
        return when {
            item > 0 -> return " + $item"
            item < 0 -> return " - ${abs(item)}"
            else -> ""
        }
    }
}
