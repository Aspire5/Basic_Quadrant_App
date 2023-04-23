package com.example.basicquadrantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicquadrantapp.ui.theme.BasicQuadrantAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicQuadrantAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrants()
                }
            }
        }
    }
}

@Composable
fun Quadrant(title: String, desc: String, bgcolor: Color, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize(1f)
            .background(color = bgcolor)
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = desc,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ComposeQuadrants(){
    Column(Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)){
            Quadrant(
                title = "Text composable" ,
                desc = "Displays text and follows Material Design guidelines.",
                bgcolor = Color.Green,
                modifier = Modifier.weight(1f,true)
            )
            Quadrant(
                title = "Image composable",
                desc = "Creates a composable that lays out and draws a given Painter class object.",
                bgcolor = Color.Yellow,
                modifier = Modifier.weight(1f,true)
            )
        }
        Row(modifier = Modifier.weight(1f)){
            Quadrant(
                title = "Row composable" ,
                desc = "A layout composable that places its children in a horizontal sequence.",
                bgcolor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = "Column composable",
                desc = "A layout composable that places its children in a vertical sequence.",
                bgcolor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    BasicQuadrantAppTheme {
        ComposeQuadrants()
    }
}