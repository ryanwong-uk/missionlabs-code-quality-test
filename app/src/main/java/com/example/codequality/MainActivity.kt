package com.example.codequality

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.codequality.ui.theme.CodeQualityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeQualityTheme {
                Surface(color = MaterialTheme.colors.background) {
                    var showAnswer by remember { mutableStateOf(false) }
                    var input: String by remember { mutableStateOf("") }
                    var sum by remember { mutableStateOf(0) }
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(bottom = 16.dp),
                            text = stringResource(id = R.string.problem_example),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier = Modifier.padding(bottom = 16.dp),
                            text = stringResource(id = R.string.problem_question)
                        )
                        OutlinedTextField(
                            value = input,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.padding(bottom = 16.dp),
                            label = { Text("Enter an upper bound") },
                            onValueChange = {
                                showAnswer = false
                                if (it.isDigitsOnly()) {
                                    input = it
                                }
                            }
                        )
                        Button(
                            modifier = Modifier.padding(bottom = 16.dp),
                            onClick = {
                                sum = SumMultiplesImproved().sumMultiplesOfThreeAndFive(
                                    upperBound = if (input.isBlank()) 0 else input.toInt()
                                )
                                showAnswer = true
                            }
                        ) {
                            Text(getString(R.string.show_solution))
                        }

                        if (showAnswer) {
                            Text(getString(R.string.the_answer_is, sum))
                        }
                    }
                }
            }
        }
    }
}