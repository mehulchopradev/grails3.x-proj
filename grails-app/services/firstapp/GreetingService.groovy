package firstapp

import grails.gorm.transactions.Transactional

import java.time.LocalTime

@Transactional
class GreetingService {
    // singleton
    // never have state in the object (instance variables) when service is singleton

    String greetingOfDay() {
        LocalTime localTime = LocalTime.now()
        int hour = localTime.getHour()

        def message
        switch (hour) {
            case 0..<12: message = 'Good Morning'
                break
            case 12..<16: message = 'Good Afternoon'
                break
            default: message = 'Good Evening'
        }

        return message
    }
}
