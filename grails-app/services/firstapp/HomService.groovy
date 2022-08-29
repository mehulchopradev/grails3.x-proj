package firstapp

import grails.gorm.transactions.Transactional

@Transactional
class HomService {

    def transferBook(Student fromStudent, Student toStudent, Book book) {
        println "Service called"
        fromStudent.removeFromBooks book
        try {
            fromStudent.save(flush: true, failOnError: true)
        } catch (err) {
            println err
            throw err
        }

        toStudent.addToBooks book
        try {
            // trying to create a deliberate error in the second part of the transaction
            // toStudent.country = null

            toStudent.save(flush: true, failOnError: true)
        } catch (err) {
            println err
            throw err // throwing an exception will cause the transaction rollback functionality
        }
    }
}
