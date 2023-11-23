package com.example.cupcake.test
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.cupcake.CupcakeApp
import org.junit.Before
import org.junit.Rule

class CupcakeScrenNavigationTest {
    private lateinit var navController: TestNavHostController


    @get: Rule
    val composTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setupCupCakeNavHost(){
        composTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            CupcakeApp(navController = navController)
        }
    }
}
