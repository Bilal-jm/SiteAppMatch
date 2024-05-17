package com.example.siteappmatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.siteappmatch.ui.theme.SiteAppMatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiteAppMatchTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var showLiveMatches by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Button(
                onClick = { showLiveMatches = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(text = "Match en cours")
            }

            Button(
                onClick = { showLiveMatches = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Match terminé")
            }

            if (showLiveMatches) {
                MatchEnCoursScreen()
            }
        }
    }
}

@Composable
fun MatchEnCoursScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        MatchItem(
            team1Name = "Real Madrid",
            team1LogoUrl = "https://upload.wikimedia.org/wikipedia/fr/5/56/Logo_Real_Madrid.svg",
            team1Score = 1,
            team2Name = "Paris Saint Germain",
            team2LogoUrl = "https://upload.wikimedia.org/wikipedia/fr/a/a7/Logo_Paris_Saint-Germain.svg",
            team2Score = 4
        )
    }
}

@Composable
fun MatchItem(
    team1Name: String,
    team1LogoUrl: String,
    team1Score: Int,
    team2Name: String,
    team2LogoUrl: String,
    team2Score: Int
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Team 1 Logo
                Image(
                    painter = rememberImagePainter(team1LogoUrl),
                    contentDescription = "Team 1 Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Team 1 Name
                Text(text = team1Name)
            }

            // Team 1 Score
            Text(text = "$team1Score")

            // Separator
            Text(text = "-")

            // Team 2 Score
            Text(text = "$team2Score")

            Row(verticalAlignment = Alignment.CenterVertically) {
                // Team 2 Name
                Text(text = team2Name)

                Spacer(modifier = Modifier.width(8.dp))

                // Team 2 Logo
                Image(
                    painter = rememberImagePainter(team2LogoUrl),
                    contentDescription = "Team 2 Logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    SiteAppMatchTheme {
        MainScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun MatchEnCoursScreenPreview() {
    SiteAppMatchTheme {
        MatchEnCoursScreen()
    }
}
