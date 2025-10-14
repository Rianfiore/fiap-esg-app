package br.com.fiap.compareja

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

/**
 * Unit tests para a aplicação CompareJa
 * Executa no ambiente de desenvolvimento (host)
 */
class ExampleUnitTest {
    
    @Before
    fun setUp() {
        // Configuração inicial para os testes
    }
    
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    
    @Test
    fun subtraction_isCorrect() {
        assertEquals(2, 4 - 2)
    }
    
    @Test
    fun multiplication_isCorrect() {
        assertEquals(8, 4 * 2)
    }
    
    @Test
    fun division_isCorrect() {
        assertEquals(2, 4 / 2)
    }
    
    @Test
    fun string_concatenation_isCorrect() {
        val result = "Compare" + "Ja"
        assertEquals("CompareJa", result)
    }
    
    @Test
    fun boolean_logic_isCorrect() {
        assertTrue(true)
        assertFalse(false)
    }
}