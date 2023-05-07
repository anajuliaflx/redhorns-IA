
import robocode.*;
import java.awt.Color;

// o tamanho do robo é de 45 pixel

/**
 * Teste1 - a robot by (Edmilson F.)
 */
//Api do robocode
public class Teste1 extends Robot
{
	//metodo responsavel pela execução do robo
	public void run() {
		
		// Cores do: Chassi, Canhão, Radar, Bala e Arco
		setColors(Color.red, Color.black, Color.white, Color.red, Color.black ); 

		// Cria o loop responsavel pela movimentação do robo
		while(true) {
			
			// anda para a frente(quantidade de pixel)
			ahead(100);
            // gira o cano para a diretira (graus)
			turnRight(360);
            // anda para tras(pixel)
			back(100);
            // gira o cano para a esquerda(graus)
			turnLeft(360);
		}
	}

	// indica oque fazer quando ver um outro robo
	public void onScannedRobot(ScannedRobotEvent e) {
       // marca um robo e o seu nome
        String robotank = e.getName();
        // pegar a distancia em relação ao robo marcado
        double distancia = e.getDistance();
        //se a distancia em relação ao robo marcado for menor que (pixel)
        // potencia do disparo
        if(distancia <135){
            fire (3);
        }else{
            fire(1);
        }
        // dano, energia gasta e anergiarecebedia pos acerto:
        // disparo/energia
        //1-1;2-2;3-3;
        // dano causado/energia restaurada
        //1+3;2+6;3+9;
        // disparo com acerto/dano causado
        //1-4;2-10;3-16;
		
	}

	// oque faz se for atingido por uma bala
	public void onHitByBullet(HitByBulletEvent e) {
		//semelhante a regra de movimentação
		back(10);
	}
	
	// oque fazer quando bate em uma parede, regras semelhantes a de movimentação
	public void onHitWall(HitWallEvent e) {
		// anda para tras(pixel)
		back(150);

	}	
}