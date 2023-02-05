package br.com.bank.repositories

import br.com.bank.entities.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long> {



}