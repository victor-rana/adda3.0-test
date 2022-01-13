package women.fashion.compare.clothes.shop.womenshopping.offers.utils.common

import women.fashion.compare.clothes.shop.womenshopping.offers.R
import java.util.regex.Pattern

object Validator {

    private val EMAIL_ADDRESS = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    private const val MIN_PASSWORD_LENGTH = 6

    fun validateLoginFields(email: String?, password: String?): List<Validation> =
        ArrayList<Validation>().apply {
            when {
                email.isNullOrBlank() ->
                    add(Validation(Validation.Field.EMAIL, Resource.error(R.string.email_field_empty)))
                !EMAIL_ADDRESS.matcher(email).matches() ->
                    add(Validation(Validation.Field.EMAIL, Resource.error(R.string.email_field_invalid)))
                else ->
                    add(Validation(Validation.Field.EMAIL, Resource.success()))
            }
            when {
                password.isNullOrBlank() ->
                    add(Validation(Validation.Field.PASSWORD, Resource.error(R.string.password_field_empty)))
                password.length < MIN_PASSWORD_LENGTH ->
                    add(Validation(Validation.Field.PASSWORD, Resource.error(R.string.password_field_small_length)))
                else -> add(Validation(Validation.Field.PASSWORD, Resource.success()))
            }
        }

    fun validateSignupFields(email: String?, password: String?, cnfPassword: String?): List<Validation> =
        ArrayList<Validation>().apply {
            when {
                email.isNullOrBlank() ->
                    add(Validation(Validation.Field.EMAIL, Resource.error(R.string.email_field_empty)))
                !EMAIL_ADDRESS.matcher(email).matches() ->
                    add(Validation(Validation.Field.EMAIL, Resource.error(R.string.email_field_invalid)))
                else ->
                    add(Validation(Validation.Field.EMAIL, Resource.success()))
            }
            when {
                password.isNullOrBlank() ->
                    add(Validation(Validation.Field.PASSWORD, Resource.error(R.string.password_field_empty)))
                password.length < MIN_PASSWORD_LENGTH ->
                    add(Validation(Validation.Field.PASSWORD, Resource.error(R.string.password_field_small_length)))
                else -> add(Validation(Validation.Field.PASSWORD, Resource.success()))
            }
            when {
                cnfPassword.isNullOrBlank() ->
                    add(Validation(Validation.Field.CNF_PASSWORD, Resource.error(R.string.password_field_empty)))
                cnfPassword.length < MIN_PASSWORD_LENGTH ->
                    add(Validation(Validation.Field.CNF_PASSWORD, Resource.error(R.string.password_field_small_length)))
                else -> add(Validation(Validation.Field.CNF_PASSWORD, Resource.success()))
            }

        }

    fun validateEmail(email: String?):Boolean {
        return when {
            email.isNullOrBlank() ->
                false
            !EMAIL_ADDRESS.matcher(email).matches() ->
                false
            else ->
                true
        }

     }

    fun validatePassword(password: String?):Boolean{
        return when {
            password.isNullOrBlank() ->
                false
            password.length<6 ->
                false
            else ->
                true
        }

    }

}



data class Validation(val field: Field, val resource: Resource<Int>) {

    enum class Field {
        EMAIL,
        PASSWORD,
        CNF_PASSWORD
    }
}
