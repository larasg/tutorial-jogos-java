
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.*;

public class Game extends JFrame implements KeyListener{
	int FPS = 60;
	int janelaAltura = 500;
	int janelaLargura = 500;
	int xBola = 100;
	int yBola = 100;
	BufferedImage buffer; // Serve como uma tela secundária; O desenho será feito primeiro nele e depois será transferido para tela;
	boolean sair = false;

	ImageIcon bola = new ImageIcon("imagens/bola.png");
	
	public void inicializa(){
		setTitle("Bola Rolando");
		setSize (janelaLargura, janelaAltura);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout (null);
		setVisible(true);
		buffer = new BufferedImage(janelaLargura, janelaAltura, BufferedImage.TYPE_INT_ARGB);
		addKeyListener(this);
	}

	public void desenhaGraficos(){
		Graphics g = getGraphics(); 
		Graphics bbg = buffer.getGraphics();

		bbg.setColor(new Color(0,0,0));
		bbg.fillRect(0,0,janelaLargura,janelaAltura);

		bbg.drawImage(bola.getImage(), xBola, yBola,this);
		g.drawImage(buffer, 0, 0, this);
	
	}


	public void executar(){
		inicializa();
		while(!sair){
		  desenhaGraficos();
		  try{
		  	Thread.sleep(1000/FPS);
		  }catch(Exception e){
		  	System.out.println("Thread interrompida");
		  }
		}

	}

	//-------------------------------------------------------------------------------

	public void keyPressed(KeyEvent e){
		int codTeclaPressionada = e.getKeyCode();

		if(codTeclaPressionada == e.VK_LEFT){
			xBola -= 10;
		}

		if(codTeclaPressionada == e.VK_RIGHT){
			xBola += 10;
		}

		if(codTeclaPressionada == e.VK_UP){
			yBola -= 10;
		}

		if(codTeclaPressionada == e.VK_DOWN){
			yBola += 10;
		}

		if(codTeclaPressionada == e.VK_ESCAPE){
			sair = true;
		}

	}

	public void keyReleased(KeyEvent e){
	}

	public void keyTyped(KeyEvent e){
	}



	public static void main(String[] args) {
		Game game = new Game();
		game.executar();
	}
}