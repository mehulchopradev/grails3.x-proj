package firstapp

class HomeController {

    static layout = 'public'

    def greetingService
    // GreetingService greetingService

    HomService homService

    def index() {
        if (!session.user.username) {
            redirect controller: 'accounts', action: 'login'
        }

        def student = session.user
        def books = Book.list(sort: 'pages', order: 'asc')
        books.each {
            def studentsIssuedBooks = it.students
            def foundStudent = studentsIssuedBooks.any { it.id == student.id }
            if (foundStudent) {
                it.notYetIssued = false;
            } else {
                it.notYetIssued = true;
            }
        }

        [books: books, message: greetingService.greetingOfDay()]
    }

    def issueBook(Long id) {
        def student = session.user
        def book = Book.get(id)

        student = student.merge()
        student.addToBooks(book)

        try {
            student.save(flush: true, failOnError: true)
        } catch (err) {
            println err
            render "Error"
            return
        }

        redirect action: 'index'
    }

    def returnBook(Long id) {
        def student = session.user

        student = student.merge()
        def book = Book.get(id)

        student.removeFromBooks book
        try {
            student.save(flush: true, failOnError: true)
        } catch (err) {
            println err
            render "Error"
            return
        }

        redirect action: 'index'
    }

    def transfer(Long id) {
        def student = session.user

        [book: Book.get(id), students: Student.findAllByIdNotEqual(student.id)]
    }

    def performTransfer(Long studentId, Long bookId) {
        def fromStudent = session.user
        fromStudent = fromStudent.merge()

        def toStudent = Student.get(studentId)
        def book = Book.get(bookId)

        try {
            this.homService.transferBook(fromStudent, toStudent, book)
        } catch (err) {
            println err
            render "Error"
            return
        }

        redirect action: 'index'
    }
}
