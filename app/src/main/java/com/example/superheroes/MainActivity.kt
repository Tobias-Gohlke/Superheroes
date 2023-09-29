package com.example.superheroes

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository.heroes
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SuperheroApp()
                }
            }
        }
    }
}

@Composable
fun SuperheroApp(modifier: Modifier = Modifier) {
    LazyColumn {
        items(heroes) {
            HeroItem(hero = it)
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card() {
        Row(modifier = Modifier.fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_small))) {
            Column(modifier = Modifier.weight(3f)) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.displayMedium
                )
            }
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = stringResource(hero.descriptionRes),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroPreview() {
    SuperheroesTheme(darkTheme = false) {
        SuperheroApp()
    }
}

@Preview
@Composable
fun HeroDarkThemePreview() {
    SuperheroesTheme(darkTheme = true) {
        SuperheroApp()
    }
}