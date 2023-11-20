package com.indeas.restspringkotlin

import com.indeas.restspringkotlin.exceptions.UnsupportedMathOperationException
import com.indeas.restspringkotlin.service.MathService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.sqrt

@RestController
class MathController {

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {
        if(!MathService.isNumeric(numberOne) || !MathService.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return MathService.convertToDouble(numberOne) + MathService.convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {
        if(!MathService.isNumeric(numberOne) || !MathService.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return MathService.convertToDouble(numberOne) - MathService.convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun mult(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {
        if(!MathService.isNumeric(numberOne) || !MathService.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return MathService.convertToDouble(numberOne) * MathService.convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {
        if(!MathService.isNumeric(numberOne) || !MathService.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return MathService.convertToDouble(numberOne) / MathService.convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/med/{numberOne}/{numberTwo}"])
    fun med(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {
        if(!MathService.isNumeric(numberOne) || !MathService.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please set a numeric value")
        return (MathService.convertToDouble(numberOne) + MathService.convertToDouble(numberTwo)) / 2
    }

    @RequestMapping(value = ["/square-root/{number}"])
    fun sqrt(@PathVariable(value = "number") numberOne: String?): Double {
        if(!MathService.isNumeric(numberOne)) throw UnsupportedMathOperationException("Please set a numeric value")
        return sqrt(MathService.convertToDouble(numberOne))
    }
}