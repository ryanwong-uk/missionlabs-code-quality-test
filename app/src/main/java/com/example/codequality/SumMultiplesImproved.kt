package com.example.codequality

import java.text.NumberFormat
import kotlin.math.floor

class SumMultiplesImproved {
    /*
     * ***********************************************************************************************************************************
     * Problem description
     *
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     *
     * This implementation solves the problem using mathematics approach which is O(1) which involves on Data Structure.
     * If we want to skip using Coroutines, it can be rather safe to run on UI-thread.
     *
     * We simply calculate the following values:
     * A: The sum of all multiplies of 3 for the range below the upper limit (exclusive)
     * B: The sum of all multiplies of 5 for the range below the upper limit (exclusive)
     * C: The sum of all multiplies of 15 (the GCD, or I call that LCM, of 3 and 5) for the range below the upper limit (exclusive)
     * The answer is A+B-C.
     *
     * We could implement a function to calculate the GCD if we want to support the calculation of other numbers,
     * Reference: https://www.programiz.com/kotlin-programming/examples/hcf-gcd
     * but it is not needed for our use case.
     * ***********************************************************************************************************************************
     */

    fun sumMultiplesOfThreeAndFive(upperBound: Int): Int {
        val sumMultipliesOfThree = 3 sumOfMultiplesTo upperBound
        val sumMultipliesOfFive = 5 sumOfMultiplesTo upperBound
        val sumMultipliesOfFifteen = 15 sumOfMultiplesTo upperBound

        return sumMultipliesOfThree + sumMultipliesOfFive - sumMultipliesOfFifteen
    }

    // Handle the case that the input is a string
    fun sumMultiplesOfThreeAndFive(upperBound: String): Int {
        return try {
            (NumberFormat.getInstance().parse(upperBound))?.let { upperBoundNumeric ->
                sumMultiplesOfThreeAndFive(upperBoundNumeric.toInt())
            } ?: 0
        } catch (ex: java.text.ParseException) {
            ex.printStackTrace()
            0
        }
    }
}


// Helpers
// --------
infix fun Int.sumOfMultiplesTo(upperBound: Int): Int {
    val ceiling = upperBound - 1
    return (this * floor(ceiling / this.toDouble()) * (floor(ceiling / this.toDouble()) + 1) / 2).toInt()
}