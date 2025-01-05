package leet_code

import java.util.*
import kotlin.Comparator

fun main() {
    val logs = arrayOf("dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero")
    val answer = reorderLogFiles(logs)
    println(answer.contentToString())
}

fun reorderLogFiles(logs: Array<String>): Array<String> {
    val letterList = mutableListOf<String>()
    val digitList = mutableListOf<String>()
    for (log in logs) {
        if (Character.isDigit(log.split(" ")[1][0])) {
            digitList.add(log)
        } else {
            letterList.add(log)
        }
    }

    letterList.sortWith(Comparator { s1: String, s2: String ->
        val s1x = s1.split(" ", limit = 2)
        val s2x = s2.split(" ", limit = 2)
        val compared = s1x[1].compareTo(s2x[1])
        if (compared == 0) {
            s1x[0].compareTo(s2x[0])
        } else {
            compared
        }
    })
    letterList.addAll(digitList)

    return letterList.toTypedArray()
}
