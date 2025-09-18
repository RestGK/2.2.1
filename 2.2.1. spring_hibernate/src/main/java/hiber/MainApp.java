package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User ivan = new User("Ivan", "Red", "i.red@mail.ru");
      User piter = new User("Piter", "Dark", "pdark@mail.ru");
      User fred = new User("Fred", "Green", "dangreen@mail.ru");
      User alex = new User("Alex", "Smit", "smit@mail.ru");

      Car lada = new Car("Tank", 223);
      Car volvo = new Car("Volvo", 173);
      Car bmw = new Car("BMW", 151);
      Car toyota = new Car("Toyota", 48);

      ivan.setCar(lada);
      piter.setCar(volvo);
      fred.setCar(bmw);
      alex.setCar(toyota);

      userService.add(ivan);
      userService.add(piter);
      userService.add(fred);
      userService.add(alex);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user + " "+ user.getCar());
      }

      System.out.println(userService.getUserByCar("toyota", 48));

      context.close();
   }
}
