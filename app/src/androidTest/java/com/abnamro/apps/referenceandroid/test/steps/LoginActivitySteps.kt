//Contains all the step definitions for login steps declared in login feature

package com.abnamro.apps.referenceandroid.test.steps


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.abnamro.apps.referenceandroid.MainActivity
import com.abnamro.apps.referenceandroid.test.screens.LoginScreen
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then

import cucumber.api.java.en.When


class LoginActivitySteps {

    private val loginScreen = LoginScreen()
    private val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Before
    fun setup() {
        //Nothing is done here now, but can be used for generating mocks
    }

    @After
    fun tearDown() {
        activityRule.finishActivity()
    }

    @Given("^I start the application$")
    fun i_start_app() {
        activityRule.launchActivity(null)
    }

    @And("^I enter (\\S+) in the email field$")
    fun i_enter_a_valid_email(email: String) {
        //Checking if empty email is entered or not
        if(email=="empty") onView(withId(loginScreen.emailField())).perform(clearText())
        else onView(withId(loginScreen.emailField())).perform(typeText(email))
    }

    @And("^I enter (\\S+) in the password field$")
    fun i_enter_a_valid_password(password: String) {
        onView(withId(loginScreen.passwordField())).perform(typeText(password))
    }

    @When("^I click submit button$")
    fun i_click_submit_button() {
        onView(withId(loginScreen.submitButton())).perform(click())
    }

    @Then("^I see successful login (\\S+)$")
    fun i_see_successful_login_message(message: String) {
        //checking if the successful login message is displayed or not
        onView(withId(loginScreen.successfulLoginMessage())).check(matches(isDisplayed()))
        //checking if the successful login message is the correct one or not
        onView(withId(loginScreen.successfulLoginMessage())).check(matches(withText(message)))
    }

    @Then("^I see error shown for email field as '(.*)'$")
    fun i_see_email_error_message(message: String) {
        //checking if correct error message is displayed or not
        onView(withId(loginScreen.emailField())).check(matches(hasErrorText(message)))
    }

    @Then("^I see error shown for password field as '(.*)'$")
    fun i_see_password_error_message(message: String) {
        //checking if correct error message is displayed or not
        onView(withId(loginScreen.passwordField())).check(matches(hasErrorText(message)))
    }

}
