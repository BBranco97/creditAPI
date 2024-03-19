package petads.credit.app.kotlin.service.implementation

import org.springframework.stereotype.Service
import petads.credit.app.kotlin.entit.Customer
import petads.credit.app.kotlin.repository.CustomerRepository
import petads.credit.app.kotlin.service.ICustomerService

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow{ throw RuntimeException("Id não encontradp") }
    }

    override fun delete(id: Long){
        return this.customerRepository.deleteById(id)
    }

    //update vai ser feito na camada de controle
}