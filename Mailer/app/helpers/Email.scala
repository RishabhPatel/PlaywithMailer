package helpers

import play.api.Play.current
import com.typesafe.config._
import org.apache.commons.mail._
import play.api.Logger

object Email {

  def sendEmail(emailId: String, emailtemplate: String) {

    try {

      val htmlEmailTemplate = emailtemplate

      val conf = ConfigFactory.load()

      val email = new HtmlEmail()

      email.setHostName(conf.getString("rp.smtp.host"))

      email.setSmtpPort(conf.getInt("rp.smtp.port"))

      email.setAuthenticator(new DefaultAuthenticator(conf.getString("rp.smtp.user"), conf.getString("rp.smtp.password")))

      email.setSSLOnConnect(conf.getBoolean("rp.smtp.ssl"))

      email.getMailSession().getProperties().put("mail.debug", conf.getString("rp.smtp.debug"))

      email.setFrom(conf.getString("rp.smtp.from"))

      email.setSubject("TestMail")

      email.setHtmlMsg(htmlEmailTemplate)

      email.addTo(emailId)

      email.send()

    } catch {

      case ex: java.lang.NullPointerException => { Logger.info("exception = %s" format ex) }

      case ex: javax.mail.AuthenticationFailedException => { Logger.info("exception = %s" format ex) }

      case ex: EmailException => { Logger.info("exception = %s" format ex) }
    }

  }

}