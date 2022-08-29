package firstapp

class PublicationHouse {

    String name

    Integer ratings

    static hasMany = [books: Book] // addToBooks(Book)
    // lazily loaded

    static constraints = {
    }

    String toString() {
        this.name
    }
}
