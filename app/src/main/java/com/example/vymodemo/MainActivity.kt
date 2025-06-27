package com.example.vymodemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.vymodemo.db.model.User
import com.example.vymodemo.di.RepositoryModule
import com.example.vymodemo.ui.theme.VymoDemoTheme
import com.example.vymodemo.viewmodel.MyViewModel
import com.example.vymodemo.viewmodel.MyViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var repositoryModule: RepositoryModule

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = MyViewModelFactory(repositoryModule)
        viewModel = ViewModelProvider(this, viewModelFactory)[MyViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            VymoDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) { user ->
                        viewModel.addUser(user)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    onClickSave: (User) -> Unit
) {

    var firstNameValue by remember { mutableStateOf("Enter First Name") }
    var lastNameValue by remember { mutableStateOf("Enter Last Name") }
    var emailValue by remember { mutableStateOf("Enter Email") }
    var phoneValue by remember { mutableLongStateOf(0L) }
    var cityValue by remember { mutableStateOf("Enter City") }

    Column(
        modifier = modifier
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = firstNameValue,
            onValueChange = { value ->
                firstNameValue = value
            }
        )
        TextField(
            value = lastNameValue,
            onValueChange = { value ->
                lastNameValue = value
            }
        )
        TextField(
            value = emailValue,
            onValueChange = { value ->
                emailValue = value
            }
        )
        TextField(
            value = phoneValue.toString(),
            onValueChange = { value ->
                phoneValue = value.toLong()
            }
        )
        TextField(
            value = cityValue,
            onValueChange = { value ->
                cityValue = value
            }
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        Button(
            onClick = {
                onClickSave(
                    User(
                        firstName = firstNameValue,
                        lastName = lastNameValue,
                        email = emailValue,
                        phone = phoneValue,
                        city = cityValue
                    )
                )
            }
        ) {
            Text("Save")
        }
    }
}
