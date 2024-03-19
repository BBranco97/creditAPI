package petads.credit.app.kotlin.repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import petads.credit.app.kotlin.entit.Credit

import java.util.*

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
    //query key worlds
    fun findByCreditCode(creditCode: UUID) : Credit?

    //native query
    @Query(value = "SELECT * FROM CREDIT WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Credit>
}