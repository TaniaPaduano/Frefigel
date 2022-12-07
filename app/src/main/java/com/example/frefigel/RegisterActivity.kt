package com.example.frefigel


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.frefigel.models.ResponseHttp
import com.example.frefigel.models.User
import com.example.frefigel.providers.UsersProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    val TAG = "RegisterActivity"

    var imageViewGoToLogin: ImageView? = null
    var editTextName: EditText? = null
    var editTextAddress: EditText? = null
    var editTextEmail: EditText? = null
    var editTextRole: EditText? = null
    var editTextPassword: EditText? = null
    var buttonRegister: Button? = null

    var usersProvider = UsersProvider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        imageViewGoToLogin = findViewById(R.id.returRPhome)
        editTextName = findViewById(R.id.edittext_name)
        editTextAddress = findViewById(R.id.edittext_address)
        editTextEmail = findViewById(R.id.edittext_email)
        editTextRole = findViewById(R.id.edittext_role)
        buttonRegister = findViewById(R.id.btn_register)


        imageViewGoToLogin?.setOnClickListener { goToProducts() }
        buttonRegister?.setOnClickListener { register() }
    }


    private fun register() {
        val name = editTextName?.text.toString()
        val address = editTextAddress?.text.toString()
        val email = editTextEmail?.text.toString()
        val phone = editTextRole?.text.toString()
        val password = editTextPassword?.text.toString()
        val role = editTextRole?.text.toString()

        if (isValidForm(name = name, address = address, email = email, password = password, role = role)) {

            val user = User(
                name = name,
                address = address,
                email = email,
                password = password,
                role = role
            )

            usersProvider.register(user)?.enqueue(object: Callback<ResponseHttp> {
                override fun onResponse(call: Call<ResponseHttp>, response: Response<ResponseHttp>) {

                    Toast.makeText(this@RegisterActivity, response.body()?.message, Toast.LENGTH_LONG).show()

                    Log.d(TAG, "Response: ${response}" )
                    Log.d(TAG, "Body: ${response.body()}" )
                }

                override fun onFailure(p0: Call<ResponseHttp>, t: Throwable) {
                    Log.d(TAG, "Se produjo un error ${t.message}")
                    Toast.makeText(this@RegisterActivity, "Se produjo un error ${t.message}", Toast.LENGTH_LONG).show()
                }

            })

        }

    }

    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun isValidForm(
        name: String,
        address: String,
        email: String,
        password: String,
        role: String,
    ): Boolean {

        if (name.isBlank()) {
            Toast.makeText(this, "Debes ingresar el nombre", Toast.LENGTH_SHORT).show()
            return false
        }

        if (address.isBlank()) {
            Toast.makeText(this, "Debes ingresar el apellido", Toast.LENGTH_SHORT).show()
            return false
        }

        if (email.isBlank()) {
            Toast.makeText(this, "Debes ingresar el email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.isBlank()) {
            Toast.makeText(this, "Debes ingresar el contraseña", Toast.LENGTH_SHORT).show()
            return false
        }

        if (role.isBlank()) {
            Toast.makeText(this, "Debes ingresar el role", Toast.LENGTH_SHORT).show()
            return false
        }



        if (!email.isEmailValid()) {
            Toast.makeText(this, "El email no es valido", Toast.LENGTH_SHORT).show()
            return false
        }



        return true
    }

    private fun goToProducts() {
        val i = Intent(this, ProfileActivity::class.java)
        startActivity(i)
    }
}