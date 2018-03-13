package asteroids;

//Importaciones de paquetes de javafx y java.
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


//Creamos una clase publica asteroide
public class Asteroide {
    //Declaracion de variables de diferentes tipos
    //Variable de tipo poligo dibujoAsteroide
    private final Polygon dibujoAsteroide = new Polygon();
    //Variable de tipo entero con final
    private final int anchoPantalla = 600;
    private final int largoPantalla = 800;
    //Variables de tipo double
    double posAsteroideX;
    double posAsteroideY;
    //Variable de tipo double pribada para esta clase.
    private double velAsteroideX=0;
    private double velAsteroideY=1;
    
    //Creacion del asteroide de tipo publico con los siguientes parametros
    public Asteroide(double posAsteroideX,double posAsteroideY){
        //Asignacion del dibujo del asteroide
        dibujoAsteroide.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -30.0, 20.0,
            -15.0, 40.0,
            15.0, 40.0,
            20.0, 0.0 
        });
        //Pintamos el asteroide
        dibujoAsteroide.setFill(Color.BROWN);
        //Creamos una variable de tipo random
        Random velAst = new Random();
        //Asignamos a la variable velAsteroide el contenido de la variable random
        velAsteroideX=velAst.nextDouble();
        velAsteroideY=velAst.nextDouble();
        //Posicionamos al dibujo del asteroide.
        dibujoAsteroide.setLayoutX(posAsteroideX);
        dibujoAsteroide.setLayoutY(posAsteroideY);
    }
    
    //Creamos un metodo de tipo void llamado moverAsteroide
    public void moverAsteroide(){
        //Sumamos e igualamos a la posicion la velocidad y despues lo posicionamos en los dos eje x and y.
        posAsteroideX+=velAsteroideX;
        dibujoAsteroide.setLayoutX(posAsteroideX);
        posAsteroideY+=velAsteroideY;
        dibujoAsteroide.setLayoutY(posAsteroideY);
    }
    //Creamos un metodo llamado checkearBordes de tipo void 
    public void checkearBordes(){
    //Comprobaciones de posicionamiento del asteroide.    
    if(posAsteroideX<=0){
        mostrarAsteroide().setTranslateX(posAsteroideX=largoPantalla);
        }else{
            if(posAsteroideX>=largoPantalla){
                mostrarAsteroide().setTranslateX(posAsteroideX=0);
            }
    }
    if(posAsteroideY <=0){
        mostrarAsteroide().setTranslateY(posAsteroideY=anchoPantalla);
        }else{

            if(posAsteroideY>=anchoPantalla){
                mostrarAsteroide().setTranslateY(posAsteroideY=0);
           }
    }
        
    }
    //Creamos un metodo de tipo void 
    public void asteroideInvisible(){
        //Asignamos al dibujo de asteroide la visilidad en falso
        dibujoAsteroide.setVisible(false);
    }
    //Creamos un metodo de tipo poligono llamado mostrarAsteroide
    public Polygon mostrarAsteroide(){
        //Retornamos el poligono dibujoAsteroide
        return dibujoAsteroide;
    }
    
    
    
}