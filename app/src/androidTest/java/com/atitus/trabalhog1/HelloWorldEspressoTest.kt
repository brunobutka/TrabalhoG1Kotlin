package com.atitus.trabalhog1

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith
import com.google.common.truth.Truth.assertThat
import org.junit.Assert
import java.math.RoundingMode


@RunWith(AndroidJUnit4::class)
@LargeTest
class HelloWorldEspressoTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.atitus.trabalhog1", appContext.packageName)
    }

    @Test
    fun verificaAlertaQuandoNomeFazio() {
        // Lança a MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // Simula um clique no botão de Avançar da tela inicial
        onView(withId(R.id.btnAvancarTelaInicial)).perform(click())

        // Verifica se a mensagem de alerta é exibida na tela
        onView(withId(android.R.id.message)).check(matches(isDisplayed()))
    }

    @Test
    fun verificaPassagemCorretaDoNomeInserido(){
        // Lança a MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        val nomeInformado = "Bruno Butka"

        // Simula o insert de um nome e o clique no botão de Avançar da tela inicial
        onView(withId(R.id.txtNome)).perform(typeText(nomeInformado))
        onView(withId(R.id.btnAvancarTelaInicial)).perform(click())

        // Verifica se o nome inserido no primeiro campo é exibido corretamente na segunda tela
        onView(withId(R.id.txtUserName)).check(matches(withText("Ola $nomeInformado")))
    }
}