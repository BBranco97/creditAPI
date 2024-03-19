package petads.credit.app.kotlin.service

import petads.credit.app.kotlin.entit.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)

    //upgrade = findById + save
}