package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;


import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String showSomeCars(@RequestParam(value = "count", defaultValue = "5") int count,
                               Model model) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("BMW", "blue", 5));
        carList.add(new Car("Renault", "black", 5));
        carList.add(new Car("Nissan", "green", 4));
        carList.add(new Car("Skoda", "silver", 5));
        carList.add(new Car("Kia", "blue", 5));

        if (count >= 5) {
            model.addAttribute("cars", carService.getSomeNumberOfCars(carList, 5));
        } else {
            model.addAttribute("cars", carService.getSomeNumberOfCars(carList, count));
        }
        return "cars";
    }
}
