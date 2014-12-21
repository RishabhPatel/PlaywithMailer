package controllers

import play.api._
import play.api.mvc._
import helpers.Email._

object Application extends Controller {

  def index = Action {
    val getEmailTemplate = views.html.emailer.testmail("Welcome!")
    val emailId = "test@gmail.com"
    helpers.Email.sendEmail(emailId, getEmailTemplate.toString)
    Ok("Easiest way run to mailer!")
  }

}