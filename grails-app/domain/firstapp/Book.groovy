package firstapp

class Book {

    String title

    Integer pages

    Float price

    Integer noOfCopies

    PublicationHouse publicationHouse

    Boolean notYetIssued

    static transients = ['notYetIssued']

    static belongsTo = [PublicationHouse, Student] // lazily loaded

    static hasMany = [students: Student]

    static constraints = {
        title maxSize: 20, unique: true
        pages min: 1
        price nullable: true
    }

    String toString() {
        this.title
    }
}
