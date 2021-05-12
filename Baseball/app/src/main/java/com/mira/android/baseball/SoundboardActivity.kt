package com.mira.android.baseball

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SoundboardActivity : AppCompatActivity() {
    private lateinit var letsGoButton: Button
    private lateinit var itsTimeButton: Button
    private lateinit var loveButton: Button
    private lateinit var goneButton: Button
    private lateinit var dingerButton: Button
    private lateinit var kButton: Button
    private lateinit var chonaButton: Button
    private lateinit var chargeButton: Button
    private lateinit var boomButton: Button
    private lateinit var oceanButton: Button
    private lateinit var ourYearButton: Button
    private lateinit var impossibleButton: Button
    private lateinit var chikaButton: Button
    private lateinit var takeMeOutButton: Button
    private lateinit var giantsButton: Button
    private lateinit var letsGoAudio: MediaPlayer
    private lateinit var itsTimeAudio: MediaPlayer
    private lateinit var loveAudio: MediaPlayer
    private lateinit var goneAudio: MediaPlayer
    private lateinit var dingerAudio: MediaPlayer
    private lateinit var kAudio: MediaPlayer
    private lateinit var chonaAudio: MediaPlayer
    private lateinit var chargeAudio: MediaPlayer
    private lateinit var boomAudio: MediaPlayer
    private lateinit var oceanAudio: MediaPlayer
    private lateinit var ourYearAudio: MediaPlayer
    private lateinit var impossibleAudio: MediaPlayer
    private lateinit var chikaAudio: MediaPlayer
    private lateinit var takeMeOutAudio: MediaPlayer
    private lateinit var giantsAudio: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soundboard)

        letsGoButton = findViewById(R.id.letsGoButton)
        itsTimeButton = findViewById(R.id.itsTimeButton)
        loveButton = findViewById(R.id.loveButton)
        goneButton = findViewById(R.id.goneButton)
        dingerButton = findViewById(R.id.dingerButton)
        kButton = findViewById(R.id.kButton)
        chonaButton = findViewById(R.id.chonaButton)
        chargeButton = findViewById(R.id.chargeButton)
        boomButton = findViewById(R.id.boomButton)
        oceanButton = findViewById(R.id.oceanButton)
        ourYearButton = findViewById(R.id.ourYearButton)
        impossibleButton = findViewById(R.id.impossibleButton)
        chikaButton = findViewById(R.id.chikaButton)
        takeMeOutButton = findViewById(R.id.takeMeOutButton)
        giantsButton = findViewById(R.id.giantsButton)

        //Let's Go Button Listener and Audio Handling
        letsGoAudio = MediaPlayer.create(this, R.raw.letsgododgers)
        letsGoButton.setOnClickListener{
            letsGoAudio.start()
        }

        //It's Time Button Listener and Audio Handling
        itsTimeAudio = MediaPlayer.create(this, R.raw.itfdb)
        itsTimeButton.setOnClickListener{
            itsTimeAudio.start()
        }

        //Love Button Listener and Audio Handling
        loveAudio = MediaPlayer.create(this, R.raw.ilovela)
        loveButton.setOnClickListener{
            loveAudio.start()
        }

        //Gone Button Listener and Audio Handling
        goneAudio = MediaPlayer.create(this, R.raw.sheisgone)
        goneButton.setOnClickListener{
            goneAudio.start()
        }

        //Dinger Button Listener and Audio Handling
        dingerAudio = MediaPlayer.create(this, R.raw.homersong)
        dingerButton.setOnClickListener {
            dingerAudio.start()
        }

        //K Button Listener and Audio Handling
        kAudio = MediaPlayer.create(this, R.raw.k)
        kButton.setOnClickListener {
            kAudio.start()
        }


        //Chona Button Listener and Audio Handling
        chonaAudio = MediaPlayer.create(this, R.raw.lachona)
        chonaButton.setOnClickListener {
            chonaAudio.start()
        }

        //Charge Button Listener and Audio Handling
        chargeAudio = MediaPlayer.create(this, R.raw.charge)
        chargeButton.setOnClickListener {
            chargeAudio.start()
        }

        //Boom Button Listener and Audio Handling
        boomAudio = MediaPlayer.create(this, R.raw.boomboomboom)
        boomButton.setOnClickListener {
            boomAudio.start()
        }

        //Ocean Button Listener and Audio Handling
        oceanAudio = MediaPlayer.create(this, R.raw.muncyocean)
        oceanButton.setOnClickListener {
            oceanAudio.start()
        }

        //Our Year Button Listener and Audio Handling
        ourYearAudio = MediaPlayer.create(this, R.raw.ouryear)
        ourYearButton.setOnClickListener {
            ourYearAudio.start()
        }

        //Impossible Button Listener and Audio Handling
        impossibleAudio = MediaPlayer.create(this, R.raw.theimpossible)
        impossibleButton.setOnClickListener {
            impossibleAudio.start()
        }

        //Chika Button Listener and Audio Handling
        chikaAudio = MediaPlayer.create(this, R.raw.chika)
        chikaButton.setOnClickListener {
            chikaAudio.start()
        }

        //Take Me Out Button Listener and Audio Handling
        takeMeOutAudio = MediaPlayer.create(this, R.raw.takemeout)
        takeMeOutButton.setOnClickListener {
            takeMeOutAudio.start()
        }

        //Giants Suck Button Listener and Audio Handling
        giantsAudio = MediaPlayer.create(this, R.raw.giantssuck)
        giantsButton.setOnClickListener {
            giantsAudio.start()
        }

    }

    override fun onStop() {
        super.onStop()
        //All MediaPLayer objects used in Soundboard are released
        letsGoAudio.release()
        itsTimeAudio.release()
        loveAudio.release()
        goneAudio.release()
        dingerAudio.release()
        kAudio.release()
        chonaAudio.release()
        chargeAudio.release()
        boomAudio.release()
        oceanAudio.release()
        ourYearAudio.release()
        impossibleAudio.release()
        chikaAudio.release()
        takeMeOutAudio.release()
        giantsAudio.release()
    }

    companion object{
        fun newIntent(packageContext: Context): Intent {
            return Intent(packageContext, SoundboardActivity::class.java).apply {
            }
        }
    }
}