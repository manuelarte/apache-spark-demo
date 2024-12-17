package com.github.manuelarte.demo

import java.io.Serializable
import java.math.BigDecimal

data class DividendSum(val company: String, val amount: BigDecimal): Serializable {

    fun add(other: DividendSum): DividendSum {
        if (!company.equals(other.company, true)) {
            throw IllegalArgumentException("Company $company is not equal to ${other.company}")
        }
        return copy(amount = amount + other.amount)
    }
}