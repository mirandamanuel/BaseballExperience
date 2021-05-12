package com.mira.android.baseball

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var toggleCrowdButton: ToggleButton
    private lateinit var soundboardButton: Button
    private lateinit var scoresButton: Button
    private lateinit var scheduleButton: Button
    private lateinit var standingsButton: Button
    private lateinit var crowdAudio: MediaPlayer
    private  var toggleIsChecked: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toggle Button Listener for Ambient Crowd Noise (crowdaudio.wav in raw)
        toggleCrowdButton = findViewById(R.id.toggleCrowdButton)
        crowdAudio = MediaPlayer.create(this, R.raw.crowdaudio)
        toggleCrowdButton.setOnCheckedChangeListener{ buttonView, toggleIsChecked ->
            if (toggleIsChecked){
                crowdAudio = MediaPlayer.create(this, R.raw.crowdaudio)
                crowdAudio.start()
            }
            else{
                crowdAudio.stop()
                crowdAudio.release()
            }

        }

        //Soundboard Button Listener and Initialization
        soundboardButton = findViewById(R.id.soundboard_button)
        soundboardButton.setOnClickListener{
            val intent = SoundboardActivity.newIntent(this@MainActivity)
            startActivity(intent)
        }

        //Scores Button Listener and Initialization
        scoresButton = findViewById(R.id.scores_button)
        scoresButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mlb.com/dodgers/scores"))
            startActivity(browserIntent)
        }

        //Schedule Button Listener and Initialization
        scheduleButton = findViewById(R.id.schedule_button)
        scheduleButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mlb.com/dodgers/schedule"))
            startActivity(browserIntent)
        }

        //Standings Button Listener and Initialization
        standingsButton = findViewById(R.id.standings_button)
        standingsButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mlb.com/dodgers/standings"))
            startActivity(browserIntent)
        }

        //This if statement helps maintain the state of "toggleCrowdButton" through orientation changes
        if (savedInstanceState != null){
            crowdAudio.stop()   //fixes bug of duplicating audio when orientation changes
            toggleIsChecked = savedInstanceState.getBoolean("toggleIsChecked")  //restores ambient audio from "toggleCrowdButton" if it was playing
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("toggleChecked", toggleIsChecked)   //saves the state of "toggleCrowdButton"
        crowdAudio.release()    //if the MediaPlayer "crowdAudio" hasn't been released by toggling button off, it will happen here
    }
}