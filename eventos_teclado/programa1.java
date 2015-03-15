
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game extends JFrame{
	int FPS = 30;
	int janelaAltura = 500;
	int janelaLargura = 500;
	BufferedImage buffer; // Serve como uma tela secundária; O desenho será feito primeiro nele e depois será transferido para tela;

	ImageIcon bola = new ImageIcon("/imagens/bola.png");
	
	public void inicializa(){
		setTitle("Bola Rolando");
		setSize (janelaLargura, janelaAltura);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		buffer = new BufferedImage(janelaLargura, janelaAltura, BufferedImage.TYPE_INT_RGB);
	}

	public void desenhaGraficos(){
		Graphics g = getGraphics(); 
		Graphics bbg = buffer.getGraphics();

		bbg.drawImage(bola.getImage(), 100,100,this);

		g.drawImage(buffer, 0, 0, this);
	}


	public void executar(){
		inicializa();
		while(true){
			desenhaGraficos();
		}

	}


	public static void main(String[] args) {
		Game game = new Game();
		game.executar();
	}
}