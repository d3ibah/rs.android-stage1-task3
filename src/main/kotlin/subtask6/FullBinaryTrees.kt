package subtask6

class FullBinaryTrees {

    companion object {
        private const val SHORT_LIST_NODES = ",0,0"
        private const val SHORT_LIST_LISTS = ",null,null"
        private const val ROOT_ELEMENT = "0"
    }

    fun stringForNodeCount(count: Int): String {
        when {
            count % 2 == 0 -> return "[]"
            count == 1 -> return "[[0]]"
        }
        val list = getSequences(count - 1, ROOT_ELEMENT, 0)

        return list.joinToString("][", "[", "]")
    }

    private fun getSequences(count: Int, rootElement: String, node: Int): ArrayList<String> {
        return if (count == 0) arrayListOf(rootElement)
        else {
            val sequences: ArrayList<String> = getSequences(count - 2, "$rootElement$SHORT_LIST_NODES", node + 1)

            if (node > 0) sequences.addAll(getSequences(count, "$rootElement$SHORT_LIST_LISTS", node - 1))

            sequences
        }
    }
}
