package com.informatica.umsa.collision2djuego

import android.support.v7.app.AppCompatActivity
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;

class MainActivity : AppCompatActivity() {
    var superficie: GLSurfaceView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        superficie = Renderiza(this);
        setContentView(superficie);

    }
}
