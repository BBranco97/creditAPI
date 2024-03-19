package petads.credit.app.kotlin.service.implementation

import org.springframework.stereotype.Service
import petads.credit.app.kotlin.entit.Credit
import petads.credit.app.kotlin.repository.CreditRepository
import petads.credit.app.kotlin.service.ICreditService
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
            //não da para alterar val
        } //consulta - existe um customer associado
        return this.creditRepository.save(credit)
    }

    //native query
    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomerId(customerId)
    }

    //query key worlds
    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Código não encontrado"))
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Acesso negado")
        //cliente nao pode ver o credit de outro cliente
    }
}