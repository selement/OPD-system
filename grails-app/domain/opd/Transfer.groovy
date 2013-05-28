package opd

class Transfer {
	String comment
    String location
	String type
	Date date

	static belongsTo = [nurse:Nurse , doctor:Doctor, patient:Patient]
    static constraints = {
            nurse nullable:true
    		comment nullable:true
    		type nullable:true
    		date nullable:true
            location nullable:true
    }
}
