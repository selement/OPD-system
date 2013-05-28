package opd

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class Previewtransferslip2Composer extends GrailsComposer {
def test
def tin
def symid
def dname
    def afterCompose = { window ->
        // initialize components here
        tin = session.patient
		symid = Patient.findById(tin.id)
			$("#name").val(tin.firstname + " " +tin.lastname)
			$("#idcard").val(tin.idcard)
			$("#tel").val(tin.tel)
			$("#diagnose").val(symid.symptoms.diagnose[0])
		dname = Patient.findByIdcard($("#idcard").val())
			$("#dtransfer").val(dname.symptoms.doctor.firstname[0]+ " " + dname.symptoms.doctor.lastname[0])
		test = Transfer.findByPatient(dname)
			$("#location").val(test.location)
			$("#timetransfer").val(test.date)

         $("#printbtn").on("click", {
				redirect(uri:'/transfer/printtransferslip2.zul')
			})
         $("#backbtn").on("click", {
				redirect(uri:'/transfer/transferOut.zul')
			})
    }
}
