package com.mira.android.baseball

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.CompoundButton
import android.widget.ToggleButton
import androidx.core.os.persistableBundleOf

class MainActivity : AppCompatActivity() {
    private lateinit var toggleCrowdButton: ToggleButton
    private lateinit var crowdAudio: MediaPlayer
    private  var toggleIsChecked: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Toggle Button Listener for Ambient Crowd Noise (crowdaudio.wav in raw)
        toggleCrowdButton = findViewById(R.id.toggleCrowdButton)
        crowdAudio = MediaPlayer.create(this,R.raw.crowdaudio)
        toggleCrowdButton.setOnCheckedChangeListener{buttonView, toggleIsChecked ->
            if (toggleIsChecked){
                crowdAudio = MediaPlayer.create(this,R.raw.crowdaudio)
                crowdAudio.start()
            }
            else{
                crowdAudio.stop()
                crowdAudio.release()
            }

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