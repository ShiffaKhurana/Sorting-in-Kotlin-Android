package com.example.shiffa.kotlintask

abstract class Car(
    var name: String,
    var release_year: Int,
    var price: Double){}

class CarModel1(name:String, release_year: Int, price: Double, var horsepower: Int): Car(name,release_year,price)
{}


class CarModel2(name:String, release_year: Int, price: Double, var trailer: Int): Car(name,release_year,price)
{}


class CarModel3(name:String, release_year: Int, price: Double, var rare_camera:String ): Car(name,release_year,price)
{}