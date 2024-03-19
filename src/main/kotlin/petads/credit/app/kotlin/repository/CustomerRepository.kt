package petads.credit.app.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import petads.credit.app.kotlin.entit.Customer

@Repository
interface CustomerRepository: JpaRepository<Customer, Long>