package com.atitus.trabalhog1


import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun validarSoma() {
        val soma = 2 + 2
        val resultadoEsperado = 4

        assertEquals(resultadoEsperado, soma)
    }

    @Test
    fun testCalculo() {
        val fragmento = ThirdFragment()
        val resultado = fragmento.calculo(10f, 20f, 30f)
        assertEquals(BigDecimal("6.67"), resultado)
    }

    @Test
    fun validarTamanhoString() {
        val string = "Hello, world!"
        val length = string.length
        val resultadoEsperado = 13
        assertEquals(resultadoEsperado, length)
    }

    @Test
    fun validarConcatenacaoString() {
        val string1 = "Ola"
        val string2 = ", tudo bem?"
        val concatenacao = string1 + string2
        val resultadoEsperado = "Ola, tudo bem?"
        assertEquals(resultadoEsperado, concatenacao)
    }

    @Test
    fun validarSomaLista() {
        val list = listOf(1, 2, 3, 4)
        val soma = list.sum()
        val resultadoEsperado = 10
        assertEquals(resultadoEsperado, soma)
    }


}