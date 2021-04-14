package com.example.starter

import org.junit.jupiter.api.Test


class MainTest {

    @Test
    fun test() {
        val num : Int
        num = 42
        println("num ${num}")
    }

    @Test
    fun test2() {
        val num: Int = 42
        val num2 = 42

        println("num : ${num} num2 : ${num2}")
    }

    @Test
    fun test3() {
        for(i in 10 downToUntil 1) {
            println(i);
        }


        val list = arrayListOf("10","11","1001");
        for((index, el) in list.withIndex()) {
            println("index : $index, el : ${el}");
        }
    }

    infix fun Int.downToUntil(to: Int): IntProgression {
        return IntProgression.fromClosedRange(this, to+1, -1)
    }

    class Person(
            val name: String,
            val age: Int
    )

}
