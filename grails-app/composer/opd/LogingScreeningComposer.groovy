package opd

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class LogingScreeningComposer extends GrailsComposer {
def user
    def afterCompose = { window ->
        if (session['user'])
			redirect(uri:'/screenings/searchInScreening.zul')
		else {
			$("window").setVisible(true)
	        $("#login").on("click", {

	        	user = Nurse.findByUserAndPassword($("#username").val(), $("#password").val())
	        	if (user) {
	        		session.user = user
	        		redirect(uri:'/screenings/searchInScreening.zul')
	        	} else alert("ไม่ถูกต้อง")
	        })
        }
  
    }
}
