package com.example.TP1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CarRentalService {
    private ArrayList<Car> cars  = new ArrayList<Car>();

    public CarRentalService() {
        cars.add(new Car("11AA22", "Ferrari", 1000) );
        cars.add(new Car("33BB44", "Porsche", 2222) );
    }

    /*
    On obtient la liste des voitures
    quand on utilise http://localhost:8080/cars

    à partir d'un mot clé, obtenir tous les résultats
    regarde fichier qui  a @restcontroller,
    puis regarde dans quelle méthode a /cars
     */
    @GetMapping("/cars")
    public ArrayList<Car> getListOfCars(){
        return this.cars;
    }

    // entre accolades donc peut varier
    // lien entre platenumber de l'url et value="platenumber,
    // le 3ème platenumber peut être changé
    @GetMapping("/cars/{plateNumber}")
    public Car getCar(@PathVariable(value="plateNumber") String plateNumber){
        // on parcours et on cherche la voiture avec la même plaque
        for (int i = 0; i < cars.size(); i++) {

            // si on trouve une voiture avec la même plaque,
            // retourne la voiture concernée
            if ( cars.get(i).getPlateNumber().equals(plateNumber) ){
                return cars.get(i);
            }
        }
        return null;
    }

    // explication PUT
    // objectif de modifier le brand à aaa pour la platenumber en question
    // (par exemple)

    @PutMapping("/cars")
    public void rent(@RequestBody Car car) throws org.springframework.web.server.ResponseStatusException{
        System.out.println(car);

        //boolean trouve_voiture = false;

        for (int i = 0; i < cars.size(); i++) {

            // si on trouve une voiture avec la même plaque,
            if ( cars.get(i).getPlateNumber().equals(car.getPlateNumber()) ){

                //trouve_voiture = true;
                if (car.getRented() == true){
                    System.out.println("Cette voiture est déjà louée.");
                }
                else {
                    System.out.println("Cette voiture n'est pas encore louée. Location en cours...");
                    car.setRented(true);
                }
                return;
            } // fin if
        } // fin boucle for

        // si on trouve pas
        // code trouvé sur https://stackoverflow.com/a/54539641
        //if (trouve_voiture == false) {
        throw new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        //}

        // parcourir le tableau de à la recherche d'une voiture de plaque plaque
        // si voiture trouvé
        //  si rented = true => louer
        //  sinon ramener
        // si voiture non trouvé
        //  envoyer HtttsStattus NOT-FOUND

        // requestbody se base sur ce que l'utilisateur saisit

    } // fin rent

    //add a new car
    @PostMapping("/cars")
    public ArrayList<Car> addCar(@RequestBody Car car) throws Exception {
        System.out.println(car);
        for (Car c : cars) {
            if (car.getPlateNumber().equals(c.getPlateNumber()) ) {
                System.out.println("Plate Number already exists");
            }
            else {
                cars.add(car);
                return cars;
            }
        }
        return null;
        /* ALTERNATIVE SANS VERIFICATIONS
        System.out.println(car);
        cars.add(car);
        return cars;
        */

    }


}
