package br.com.bank.controllers


import br.com.bank.entities.Account
import br.com.bank.repositories.AccountRepository
import br.com.bank.services.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/accounts")
class AccountController(val accountService: AccountService, val repository: AccountRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody account: Account) = accountService.create(account)

    @GetMapping
    fun getAll(): List<Account> = accountService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<Account> =
        accountService.getById(id).map{
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())


    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody account: Account) : ResponseEntity<Account> =
        accountService.update(id, account).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> =
        repository.findById(id).map {
            repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())



}