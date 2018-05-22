package com.gimba.handbookkt.entity


class Person(var firstName:String) {
    var lastName: String? = null
    var addres: String? = null
    var car: String? = null
}
fun foo(){
    var person = Person("cat")
    person.firstName
}