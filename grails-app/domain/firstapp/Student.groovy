package firstapp

class Student {
    // has two extra attributes
    // id, version
    String username

    String password

    String country

    Character gender

    static hasOne = [contact: Contact] // one to one -- eagerly loaded

    static hasMany = [books: Book] // addToBooks, removeFromBooks, Set books

    static constraints = {
        username maxSize: 20, unique: true, email: true
        password maxSize: 8
        country maxSize: 3
        gender nullable: true
        contact unique: true, nullable: true
    }

    String toString() {
        this.username
    }
}
