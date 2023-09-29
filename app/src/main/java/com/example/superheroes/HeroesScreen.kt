package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.Hero
import com.example.superheroes.ui.theme.SuperheroesTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_medium),
            end = dimensionResource(R.dimen.padding_small),
            bottom = dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.medium)) {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_small))) {
            Column(modifier = Modifier.weight(3f)) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = stringResource(hero.descriptionRes),
                modifier = Modifier.weight(1f)
                    .clip(MaterialTheme.shapes.small)
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