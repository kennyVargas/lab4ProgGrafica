package com.informatica.umsa.collision2djuego;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.Random;

public class Renderiza extends GLSurfaceView implements Renderer {
	private Context context;
	int ancho,alto;
	/* Objetos */
	private CirculoGrafico  c3_g;
	private Circulo  c3;
	private RectanguloGrafico r1_g, r2_g, r3_g,r4_g,r5_g,r6_g,r7_g,r8_g,r9_g,r10_g,r11_g,r12_g,r13_g,r14_g,r15_g,r16_g,r17_g,r18_g,r19_g,r20_g,r21_g,r22_g,r23_g,r24_g,rbizq,rbder;
	private Rectangulo r1, r2, r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,rizq,rder;

	private int vecNum[] =new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	Random rand = new Random();
	private  boolean b1=true,b2=b1,b3=b1,b4=b1,b5=b1,b6=b1,b7=b1,b8=b1,b9=b1,b10=b1,b11=b1,b12=b1,b13=b1,b14=b1,b15=b1,b16=b1,b17=b1,b18=b1,b19=b1,b20=b1,b21=b1,b22=b1,b23=b1,b24=b1;
	private  boolean bolvec[]=new boolean[]{};
	private int vec[] =new int[] {0,1,2,3,4,5,6,7};
	/* Desplazamientos e Incrementos */

	private float x_c3 = -2, y_c3 =  -5.5f;
    private float x_r3 =  0, y_r3 = -8.5f;

    //-----BOTONES-----------
	private  float biqz_x=-5, bizq_y=-11.5f;
	private  float bder_x=3,bder_y=-11.5f;
	//_________________
	private float x_r1 = -5, y_r1 = 7.5f;
	private float x_r2 =  -3.5f, y_r2 = 7.5f;
    private float x_r5 =  -2, y_r5 = 7.5f;
    private float x_r6 =  -0.5f, y_r6 = 7.5f;
	private float x_r7 =  -0.5f, y_r7 = 7.5f;
	private float x_r8 =  0.5f, y_r8 = 7.5f;
	private float x_r9 =  2, y_r9 = 7.5f;
	private float x_r10 =  3.5f, y_r10 = 7.5f;

	private float x_r4 =  -5, y_r4 = 6; //abajo
	private float x_r11 =  -3.5f, y_r11 = 6; //abajo
	private float x_r12 =  -2, y_r12 = 6; //abajo
	private float x_r13 =  -0.5f, y_r13 = 6; //abajo
	private float x_r14 =  0.8f, y_r14 = 6; //abajo
	private float x_r15 =  2, y_r15 = 6; //abajo
	private float x_r16 =  3.5f, y_r16 = 6; //abajo
	private float x_r17 =  5, y_r17 = 6; //abajo

	private float x_r18 =  -5, y_r18 = 3; //abajo
	private float x_r19 =  -1, y_r19 = 3; //abajo
	private float x_r20 =  3, y_r20 = 3; //abajo
	private float x_r21 =  -5, y_r21 = 1; //abajo
	private float x_r22 =  -1, y_r22 = 1; //abajo
	private float x_r23 =  3, y_r23 = 1; //abajo
	private float x_r24 =  0, y_r24 = -1; //abajo

	// VELOVCIDADS DE OBJ

	private float xVelocidad_c3 = (float)rand.nextDouble()*0.4f, yVelocidad_c3 = (float)rand.nextDouble()*0.4f;


	private float xVelocidad_r3 = -0.40f, yVelocidad_r3 = 0;

	private SonidoSoundPool sonido1, sonido2, sonido3;


	public Renderiza(Context contexto) {
		super(contexto);

		sonido1 = new SonidoSoundPool(contexto, "0437.ogg");
		sonido2 = new SonidoSoundPool(contexto, "0438.ogg");
		sonido3 = new SonidoSoundPool(contexto, "0564.ogg");

		this.setRenderer(this);
		this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {

		c3_g = new CirculoGrafico(0.5f, 360, true);
		c3 = new Circulo(0, 0, 0.5f);

		//---BOTON
		rbizq=new RectanguloGrafico(0,0,2,3);
		rizq=new Rectangulo(0,0,2,3);
		rbder=new RectanguloGrafico(0,0,2,3);
		rder=new Rectangulo(0,0,2,3);
		//
		r1_g = new RectanguloGrafico(0, 0, 1, 1);
		r1 = new Rectangulo(0, 0, 1, 1);
		r2_g = new RectanguloGrafico(0, 0, 1, 1);
		r2 = new Rectangulo(0, 0, 1, 1);
		r3_g = new RectanguloGrafico(0, 0, 2, 1);
		r3 = new Rectangulo(0, 0, 2, 1);
        r4_g = new RectanguloGrafico(0, 0, 1, 1);
		r4 = new Rectangulo(0, 0, 1, 1);
		r5_g = new RectanguloGrafico(0, 0, 1, 1);
		r5 = new Rectangulo(0, 0, 1, 1);
		r6_g = new RectanguloGrafico(0, 0, 1, 1);
		r6 = new Rectangulo(0, 0, 1, 1);
		r7_g = new RectanguloGrafico(0, 0, 1, 1);
		r7 = new Rectangulo(0, 0, 1, 1);
		r8_g = new RectanguloGrafico(0, 0, 1, 1);
		r8 = new Rectangulo(0, 0, 1, 1);
		r9_g = new RectanguloGrafico(0, 0, 1, 1);
		r9 = new Rectangulo(0, 0, 1, 1);
		r10_g = new RectanguloGrafico(0, 0, 1, 1);
		r10 = new Rectangulo(0, 0, 1, 1);
		r11_g = new RectanguloGrafico(0, 0, 1, 1);
		r11 = new Rectangulo(0, 0, 1, 1);
		r12_g = new RectanguloGrafico(0, 0, 1, 1);
		r12 = new Rectangulo(0, 0, 1, 1);
		r13_g = new RectanguloGrafico(0, 0, 1, 1);
		r13 = new Rectangulo(0, 0, 1, 1);
		r14_g = new RectanguloGrafico(0, 0, 1, 1);
		r14 = new Rectangulo(0, 0, 1, 1);
		r15_g = new RectanguloGrafico(0, 0, 1, 1);
		r15 = new Rectangulo(0, 0, 1, 1);
		r16_g = new RectanguloGrafico(0, 0, 1, 1);
		r16 = new Rectangulo(0, 0, 1, 1);
		r17_g = new RectanguloGrafico(0, 0, 1, 1);
		r17 = new Rectangulo(0, 0, 1, 1);
		r18_g = new RectanguloGrafico(0, 0, 2, 1);
		r18 = new Rectangulo(0, 0, 2, 1);
		r19_g = new RectanguloGrafico(0, 0, 2, 1);
		r19 = new Rectangulo(0, 0, 2, 1);
		r20_g = new RectanguloGrafico(0, 0, 2, 1);
		r20 = new Rectangulo(0, 0, 2, 1);
		r21_g = new RectanguloGrafico(0, 0, 2, 1);
		r21 = new Rectangulo(0, 0, 2, 1);
		r22_g = new RectanguloGrafico(0, 0, 2, 1);
		r22 = new Rectangulo(0, 0, 2, 1);
		r23_g = new RectanguloGrafico(0, 0, 2, 1);
		r23 = new Rectangulo(0, 0, 2, 1);
		r24_g = new RectanguloGrafico(0, 0, 2, 1);
		r24 = new Rectangulo(0, 0, 2, 1);



		gl.glClearColor(0, 0, 0, 0);
	}


	public void dibujaCirculo3(GL10 gl){
		gl.glPushMatrix();
		gl.glTranslatef(x_c3, y_c3, 0);
		c3.x = x_c3;
		c3.y = y_c3;
		gl.glColor4f(88/255f, 21/255f, 159/255f,0);
		c3_g.dibuja(gl);
		gl.glPopMatrix();
	}

	public void dibujaRectangulo1(GL10 gl,boolean br1){
		if(br1){
			gl.glPushMatrix();
			gl.glTranslatef(x_r1, y_r1, 0);
			r1.x = x_r1;
			r1.y = y_r1;

			if(vecNum[0]==vec[0]){
				gl.glColor4f(0, 1, 0, 0);
			}
			else if(vecNum[0]==vec[1]){
				gl.glColor4f(133/255f, 181/255f, 253/255f, 1);
			}
			else if(vecNum[0]==vec[2]){
				gl.glColor4f(0,1,0,0);
			}
			else if(vecNum[0]==vec[3]){
				gl.glColor4f(1, 204/255f, 0,0);
			}
			else if(vecNum[0]==vec[4]){
				gl.glColor4f(1, 125/255f, 2/255f,0);
			}
			else if(vecNum[0]==vec[5]){
				gl.glColor4f(1,0,0,0);
			}
			else{
				gl.glColor4f(1,1,1,0);
			}
			r3_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}

	public void dibujaRectangulo2(GL10 gl,boolean br1){
		if(br1){
		gl.glPushMatrix();
		gl.glTranslatef(x_r2, y_r2, 0);
		r2.x = x_r2;
		r2.y = y_r2;
		if(vecNum[1]==vec[0]){
			gl.glColor4f(200/255f, 2/255f, 3/255f, 0);
		}
		else if(vecNum[1]==vec[1]){
			gl.glColor4f(133/255f, 181/255f, 253/255f, 1);
		}
		else if(vecNum[1]==vec[2]){
			gl.glColor4f(87, 137, 15,0);
		}
		else if(vecNum[1]==vec[3]){
			gl.glColor4f(1, 204/255f, 0,0);
		}
		else if(vecNum[1]==vec[4]){
			gl.glColor4f(1, 125/255f, 2/255f,0);
		}
		else if(vecNum[1]==vec[5]){
			gl.glColor4f(1,0,0,0);
		}
		else{
			gl.glColor4f(1,1,1,0);
		}
		r2_g.dibuja(gl);
		gl.glPopMatrix();
	}
	}

    public void dibujaRectangulo4(GL10 gl,boolean br1) {
		if (br1)
		{
			gl.glPushMatrix();
			gl.glTranslatef(x_r4, y_r4, 0);
			r4.x = x_r4;
			r4.y = y_r4;
			if (vecNum[3] == vec[0]) {
				gl.glColor4f(122/255f, 11/255f, 141/255f, 0);
			} else if (vecNum[3] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[3] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[3] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[3] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[3] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r4_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo5(GL10 gl ,boolean br1 ){
		if(br1){
			gl.glPushMatrix();
			gl.glTranslatef(x_r5, y_r5, 0);
			r5.x = x_r5;
			r5.y = y_r5;
			if(vecNum[4]==vec[0]){
				gl.glColor4f(226/255f, 236/255f, 113/255f, 0);
			}
			else if(vecNum[4]==vec[1]){
				gl.glColor4f(133/255f, 181/255f, 253/255f, 1);
			}
			else if(vecNum[4]==vec[2]){
				gl.glColor4f(0,1,0,0);
			}
			else if(vecNum[4]==vec[3]){
				gl.glColor4f(1, 204/255f, 0,0);
			}
			else if(vecNum[4]==vec[4]){
				gl.glColor4f(1, 125/255f, 2/255f,0);
			}
			else if(vecNum[4]==vec[5]){
				gl.glColor4f(1,0,0,0);
			}
			else{
				gl.glColor4f(1,1,1,0);
			}
			r5_g.dibuja(gl);
			gl.glPopMatrix();
		}

	}
	public void dibujaRectangulo6(GL10 gl ,boolean br1){
		if(br1){
			gl.glPushMatrix();
			gl.glTranslatef(x_r6, y_r6, 0);
			r6.x = x_r6;
			r6.y = y_r6;
			if(vecNum[5]==vec[0]){
				gl.glColor4f(235/255f, 64/255f, 57/255f, 0);
			}
			else if(vecNum[5]==vec[1]){
				gl.glColor4f(133/255f, 181/255f, 253/255f, 1);
			}
			else if(vecNum[5]==vec[2]){
				gl.glColor4f(0,1,0,0);
			}
			else if(vecNum[5]==vec[3]){
				gl.glColor4f(1, 204/255f, 0,0);
			}
			else if(vecNum[5]==vec[4]){
				gl.glColor4f(1, 125/255f, 2/255f,0);
			}
			else if(vecNum[5]==vec[5]){
				gl.glColor4f(1,0,0,0);
			}
			else{
				gl.glColor4f(1,1,1,0);
			}
			r6_g.dibuja(gl);
			gl.glPopMatrix();

		}

	}
	public void dibujaRectangulo7(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r7, y_r7, 0);
			r7.x = x_r7;
			r7.y = y_r7;
			if (vecNum[6] == vec[0]) {
				gl.glColor4f(99/255f, 87/255f, 22/255f, 0);
			} else if (vecNum[6] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[6] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[6] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[6] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[6] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r7_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo8(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r8, y_r8, 0);
			r8.x = x_r8;
			r8.y = y_r8;
			if (vecNum[7] == vec[0]) {
				gl.glColor4f(20/255f, 137/255f, 73/255f, 0);
			} else if (vecNum[7] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[7] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[7] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[7] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[7] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r8_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo9(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r9, y_r9, 0);
			r9.x = x_r9;
			r9.y = y_r9;
			if (vecNum[8] == vec[0]) {
				gl.glColor4f(90/255f, 13/255f, 35/255f, 0);
			} else if (vecNum[8] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[8] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[8] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[8] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[8] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r9_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo11(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r11, y_r11, 0);
			r11.x = x_r11;
			r11.y = y_r11;
			if (vecNum[10] == vec[0]) {
				gl.glColor4f(177/255f, 233/255f, 42/255f, 0);
			} else if (vecNum[10] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[10] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[10] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[10] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[10] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r11_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo12(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r12, y_r12, 0);
			r12.x = x_r12;
			r12.y = y_r12;
			if (vecNum[11] == vec[0]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[11] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[11] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[11] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[11] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[11] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r12_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo13(GL10 gl,boolean br1) {
		if (br1) {


			gl.glPushMatrix();
			gl.glTranslatef(x_r13, y_r13, 0);
			r13.x = x_r13;
			r13.y = y_r13;
			if (vecNum[12] == vec[0]) {
				gl.glColor4f(234/255f, 40/255f, 37/255f, 0);
			} else if (vecNum[12] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[12] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[12] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[12] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[12] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}

			r13_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo14(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r14, y_r14, 0);
			r14.x = x_r14;
			r14.y = y_r14;
			if (vecNum[13] == vec[0]) {
				gl.glColor4f(38/255f, 103/255f, 171/255f, 0);
			} else if (vecNum[13] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[13] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[13] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[13] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[13] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r14_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo15(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r15, y_r15, 0);
			r15.x = x_r15;
			r15.y = y_r15;
			if (vecNum[14] == vec[0]) {
				gl.glColor4f(0, 130/255f, 0, 0);
			} else if (vecNum[14] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[14] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[14] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[14] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[14] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r15_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo16(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r16, y_r16, 0);
			r16.x = x_r16;
			r16.y = y_r16;
			if (vecNum[15] == vec[0]) {
				gl.glColor4f(204/255f, 141/255f, 254/255f, 0);
			} else if (vecNum[15] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[15] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[15] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[15] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[15] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r16_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo17(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r17, y_r17, 0);
			r17.x = x_r17;
			r17.y = y_r17;
			if (vecNum[16] == vec[0]) {
				gl.glColor4f(255/255f, 204/255f, 0, 0);
			} else if (vecNum[16] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[16] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[16] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[16] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[16] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r17_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo18(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r18, y_r18, 0);
			r18.x = x_r18;
			r18.y = y_r18;
			if (vecNum[17] == vec[0]) {
				gl.glColor4f(129/255f, 182/255f, 73/255f, 0);
			} else if (vecNum[17] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[17] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[17] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[17] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[17] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r18_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo19(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r19, y_r19, 0);
			r19.x = x_r19;
			r19.y = y_r19;
			if (vecNum[18] == vec[0]) {
				gl.glColor4f(213/255f, 66/255f, 47/255f, 0);
			} else if (vecNum[18] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[18] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[18] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[18] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[18] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r19_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo20(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r20, y_r20, 0);
			r20.x = x_r20;
			r20.y = y_r20;
			if (vecNum[19] == vec[0]) {
				gl.glColor4f(6/255f, 201/255f, 255/255f, 0);
			} else if (vecNum[19] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[19] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[19] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[19] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[19] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r20_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo21(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r21, y_r21, 0);
			r21.x = x_r21;
			r21.y = y_r21;
			if (vecNum[20] == vec[0]) {
				gl.glColor4f(0, 0, 1, 0);
			} else if (vecNum[20] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[20] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[20] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[20] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[20] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r21_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo22(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r22, y_r22, 0);
			r22.x = x_r22;
			r22.y = y_r22;
			if (vecNum[21] == vec[0]) {
				gl.glColor4f(0, 0, 1, 0);
			} else if (vecNum[21] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[21] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[21] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[21] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[21] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r22_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo23(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r23, y_r23, 0);
			r23.x = x_r23;
			r23.y = y_r23;
			if (vecNum[22] == vec[0]) {
				gl.glColor4f(0, 0, 1, 0);
			} else if (vecNum[22] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[22] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[20] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[22] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[22] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r23_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo24(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r24, y_r24, 0);
			r24.x = x_r24;
			r24.y = y_r24;
			if (vecNum[23] == vec[0]) {
				gl.glColor4f(0, 0, 1, 0);
			} else if (vecNum[23] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[23] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[23] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[23] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[20] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r24_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo10(GL10 gl,boolean br1) {
		if (br1) {
			gl.glPushMatrix();
			gl.glTranslatef(x_r10, y_r10, 0);
			r10.x = x_r10;
			r10.y = y_r10;
			if (vecNum[9] == vec[0]) {
				gl.glColor4f(84/255f, 0, 42/255f, 0);
			} else if (vecNum[9] == vec[1]) {
				gl.glColor4f(133 / 255f, 181 / 255f, 253 / 255f, 1);
			} else if (vecNum[9] == vec[2]) {
				gl.glColor4f(0, 1, 0, 0);
			} else if (vecNum[9] == vec[3]) {
				gl.glColor4f(1, 204 / 255f, 0, 0);
			} else if (vecNum[9] == vec[4]) {
				gl.glColor4f(1, 125 / 255f, 2 / 255f, 0);
			} else if (vecNum[9] == vec[5]) {
				gl.glColor4f(1, 0, 0, 0);
			} else {
				gl.glColor4f(1, 1, 1, 0);
			}
			r10_g.dibuja(gl);
			gl.glPopMatrix();
		}
	}
	public void dibujaRectangulo3(GL10 gl){

			gl.glPushMatrix();
			gl.glTranslatef(x_r3, y_r3, 0);
			r3.x = x_r3;
			r3.y = y_r3;
			gl.glColor4f(1, 125/255f, 2/255f,0);
			r3_g.dibuja(gl);
			gl.glPopMatrix();
		}
	public void dibujaRectanguloIzq(GL10 gl){
		gl.glPushMatrix();
		gl.glTranslatef(biqz_x, bizq_y, 0);
		rizq.x = biqz_x;
		rizq.y = bizq_y;
		gl.glColor4f(31/255f, 0, 63/255f,0);
		rbizq.dibuja(gl);
		gl.glPopMatrix();
	}
	public void dibujaRecngujoDer(GL10 gl){
		gl.glPushMatrix();
		gl.glTranslatef(bder_x, bder_y, 0);
		rder.x = bder_x;
		rder.y = bder_y;
		gl.glColor4f(31/255f, 0, 63/255f,0);
		rbder.dibuja(gl);
		gl.glPopMatrix();
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		/* Colisi�n de dos circulos */
		 //dibujaCirculo1(gl);
		//dibujaCirculo2(gl);

		/* Colisi�n circulo y rect�ngulo */
		dibujaCirculo3(gl);
		dibujaRectangulo3(gl);
		dibujaRectangulo1(gl,b1);
		dibujaRectangulo4(gl,b4);
		dibujaRectangulo2(gl,b2);
		dibujaRectangulo5(gl,b5);
		dibujaRectangulo6(gl,b6);
		dibujaRectangulo7(gl,b7);
		dibujaRectangulo8(gl,b8);
		dibujaRectangulo9(gl,b9);
		dibujaRectangulo10(gl,b10);
		dibujaRectangulo11(gl,b11);
		dibujaRectangulo12(gl,b12);
		dibujaRectangulo13(gl,b13);
		dibujaRectangulo14(gl,b14);
		dibujaRectangulo15(gl,b15);
		dibujaRectangulo16(gl,b16);
		dibujaRectangulo17(gl,b17);
		dibujaRectangulo18(gl,b18);
		dibujaRectangulo19(gl,b19);
		dibujaRectangulo20(gl,b20);
		dibujaRectangulo21(gl,b21);
		dibujaRectangulo22(gl,b22);
		dibujaRectangulo23(gl,b23);
		dibujaRectangulo24(gl,b24);


		if (seSobreponen(c3, r1)) {
			vecNum[0]=vecNum[0]+1;
			if(vecNum[0]>6){
				b1=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r2)) {
			vecNum[1]=vecNum[1]+1;
			if(vecNum[1]>6){
				b2=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r3)) {
				//xVelocidad_c3 = (float)rand.nextDouble()*0.4f;
				yVelocidad_c3 = (float)rand.nextDouble()*0.4f;
				//xVelocidad_c3 = -xVelocidad_c3;
				//yVelocidad_c3 = -yVelocidad_c3;

		}
		if (seSobreponen(c3, r4)) {
			vecNum[3]=vecNum[3]+1;
			if(vecNum[3]>6){
				b4=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r5)) {
			vecNum[4]=vecNum[4]+1;
			if(vecNum[4]>6){
				b5=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r6)) {
			vecNum[5]=vecNum[5]+1;
			if(vecNum[5]>6){
				b6=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r7)) {
			vecNum[6]=vecNum[6]+1;
			if(vecNum[6]>6){
				b7=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r8)) {
			vecNum[7]=vecNum[7]+1;
			if(vecNum[7]>6){
				b8=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r9)) {
			vecNum[8]=vecNum[8]+1;
			if(vecNum[8]>6){
				b9=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r10)) {
			vecNum[9]=vecNum[9]+1;
			if(vecNum[9]>6){
				b10=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r11)) {
			vecNum[10]=vecNum[10]+1;
			if(vecNum[10]>6){
				b11=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r12)) {
			vecNum[11]=vecNum[11]+1;
			if(vecNum[11]>6){
				b12=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r13)) {
			vecNum[12]=vecNum[12]+1;
			if(vecNum[12]>6){
				b13=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r14)) {
			vecNum[13]=vecNum[13]+1;
			if(vecNum[13]>6){
				b14=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r15)) {
			vecNum[14]=vecNum[14]+1;
			if(vecNum[14]>6){
				b15=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r16)) {
			vecNum[15]=vecNum[15]+1;
			if(vecNum[15]>6){
				b16=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r17)) {
			vecNum[16]=vecNum[16]+1;
			if(vecNum[16]>6){
				b17=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r18)) {
			vecNum[17]=vecNum[17]+1;
			if(vecNum[17]>6){
				b18=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r19)) {
			vecNum[18]=vecNum[18]+1;
			if(vecNum[18]>6){
				b19=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r20)) {
			vecNum[19]=vecNum[19]+1;
			if(vecNum[19]>6){
				b20=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r21)) {
			vecNum[20]=vecNum[20]+1;
			if(vecNum[20]>6){
				b21=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r22)) {
			vecNum[21]=vecNum[21]+1;
			if(vecNum[21]>6){
				b22=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r23)) {
			vecNum[22]=vecNum[22]+1;
			if(vecNum[22]>6){
				b23=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}
		if (seSobreponen(c3, r24)) {
			vecNum[23]=vecNum[23]+1;
			if(vecNum[23]>6){
				b24=false;
			}else{
				xVelocidad_c3 = -xVelocidad_c3;
				yVelocidad_c3 = -yVelocidad_c3;
			}
		}



		x_c3 = x_c3 + xVelocidad_c3;
		if (x_c3 < -4.5 || x_c3 > 4.5) // izq y der
			xVelocidad_c3 = -xVelocidad_c3;

		y_c3 = y_c3 + yVelocidad_c3;
		if (y_c3 < -8.5 || y_c3 > 8.5) // izq y der
			yVelocidad_c3 = -yVelocidad_c3;

		/*
		x_r3 = x_r3 + xVelocidad_r3;
		if (x_r3 < -5 || x_r3 > 3f) // izq y der
			xVelocidad_r3 = -xVelocidad_r3;
		*/
		dibujaRectangulo3(gl);

		dibujaRecngujoDer(gl);
		dibujaRectanguloIzq(gl);
		gl.glFlush();
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int w, int h) {
		ancho=w;
		alto=h;
		gl.glViewport(0, 0, w, h);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluOrtho2D(gl, -5, 5, -11, 11);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	public boolean seSobreponen(Rectangulo r1, Rectangulo r2) {
		return (r1.x < r2.x + r2.ancho && r1.x + r1.ancho >  r2.x  &&
				r1.y < r2.y + r2.alto && r1.y	+ r1.alto > r2.y);
	}

	public float distancia2(float x1, float y1, float x2, float y2) {
		return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
	}

	public boolean seSobreponen(Circulo c1, Circulo c2) {
		float distanciaCentros2 = distancia2(c1.x, c1.y, c2.x, c2.y);
		float sumaRadios2 =(c1.radio + c2.radio) * (c1.radio + c2.radio);
		return distanciaCentros2 <= sumaRadios2;
	}

	public boolean seSobreponen(Circulo c, Rectangulo r) {
		float x0 = c.x;
		float y0 = c.y;

		if (c.x < r.x) {
			x0 = r.x;
		} else if (c.x > r.x + r.ancho) {
			x0 = r.x + r.ancho;
		}

		if (c.y < r.y) {
			y0 = r.y;
		} else if (c.y > r.y + r.alto) {
			y0 = r.y + r.alto;
		}

		float d2 = distancia2(c.x, c.y, x0, y0);
		return  d2 < c.radio * c.radio;
	}

	private boolean puntoEstadentroDelRectangulo(float posx,float posy,int x,int y,int ancho,int alto){

		return (x<posx && posx<x + ancho &&
				y<posy && posy <y + alto);
	}


	@Override
	public boolean onTouchEvent(MotionEvent e){
		float posx=e.getX();
		float posy=e.getY();
		if(e.getAction()==MotionEvent.ACTION_UP) {
			posx = ((posx / (float) ancho) * 10) - 5;
			posy = ((1 - posy / (float) alto) * 22) - 11;

			if(puntoEstadentroDelRectangulo(posx,posy,-5,-11,2,3)) {
				//Toast.makeText(context.getApplicationContext(), "izq", Toast.LENGTH_SHORT).show();
				if(xVelocidad_r3 == 0)
					xVelocidad_r3 = -0.4f;
				x_r3 = x_r3 + xVelocidad_r3;
				if (x_r3 < -5 || x_r3 > 3f) // izq y der
					xVelocidad_r3 = 0;
				else
					x_r3 = x_r3 + xVelocidad_r3;
			}

			if(puntoEstadentroDelRectangulo(posx,posy,3,-11,2,3)) {
				//Toast.makeText(context.getApplicationContext(), "der", Toast.LENGTH_SHORT).show();
				if(xVelocidad_r3 == 0)
					xVelocidad_r3 = -0.4f;
				x_r3 = x_r3 - xVelocidad_r3;
				if (x_r3 < -5 || x_r3 > 3f) // izq y der
					xVelocidad_r3 = 0;
				else
					x_r3 = x_r3 - xVelocidad_r3;
			}
		}
		return true;
	}


}
