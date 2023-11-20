package com.indeas.restspringkotlin

import com.indeas.restspringkotlin.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun mult(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/med/{numberOne}/{numberTwo}"])
    fun med(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2
    }

    @RequestMapping(value = ["/square-root/{number}"])
    fun sqrt(@PathVariable(value = "number") numberOne: String?): Double {
        if(!isNumeric(numberOne)) throw UnsupportedMathOperationException("Please set a numeric value")
        return sqrt(convertToDouble(numberOne))
    }

    private fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]""".toRegex())
    }
}