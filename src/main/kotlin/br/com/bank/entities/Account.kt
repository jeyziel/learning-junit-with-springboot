package br.com.bank.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity(name = "accounts")
class Account (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    var name: String,
    var document: String,
    var phone: String,
) {

}

