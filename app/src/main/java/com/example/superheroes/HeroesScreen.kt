package com.example.superheroes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero

    @Composable
    fun HeroesList(
        heroes: List<Hero>,
        modifier: Modifier = Modifier,
        contentPadding: PaddingValues = PaddingValues(0.dp)
    ){
        val visibleState = remember {
            MutableTransitionState(false).apply {
                targetState = true
            }
        }


        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn(
                animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
            ),
            exit = fadeOut(),
            modifier = modifier
        ) {
            LazyColumn(
                contentPadding = contentPadding
            ){
                itemsIndexed(heroes) {index, hero ->

                }
            }
        }
    }



@Composable
fun HeroListItem(
    hero: Hero,
    modifier:  Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ){

        }
    }
}