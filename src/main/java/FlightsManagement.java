import com.ab.flightsmanagement.dao.PassengerDao;
import com.ab.flightsmanagement.domain.Flight;
import com.ab.flightsmanagement.domain.Passenger;
import com.ab.flightsmanagement.domain.Ticket;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Arpit Bhardwaj
 */
public class FlightsManagement {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Flight flight = (Flight) context.getBean("flight");

        flight.print();
        System.out.println(flight.getId());
        flight.setId("AA5678");

        System.out.println(flight.getCompany());

        for (Passenger passenger : flight.getPassengers()) {
            System.out.println(passenger.getName());
            passenger.print();
        }

        Ticket ticket = (Ticket) context.getBean("ticket");
        ticket.setNumber("0987654321");

        PassengerDao passengerDaoImpl =
                (PassengerDao) context.getBean("passengerDaoImpl");
        //passengerDaoImpl.getPassenger(1).print();
        //passengerDaoImpl.getPassenger(1).print();

        Passenger mike = new Passenger();
        mike.setName("Mike");
        mike.setCountry("ZZ");
        passengerDaoImpl.insert(mike);

        context.close();
    }
}
