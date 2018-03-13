package asteroids;

//Importaciones de paquetes de javafx y java.
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

//Creamos una clase publica Nave
public class Nave {
    //Creacion de variables de tipo double
    private double velocidadNaveY = 0;
    private double velocidadNaveX = 0;
    private double posicionNaveY =500;
    private double posicionNaveX =400;
    private double velocidadAbsoluta =0.3;
    private double giroNave;
    private double giroNaveRadianes;
    private double velocidadGiro;
    //Creacion de variables de tipo int
    private int centroNave;
    private int anchoNave = 15;
    private int anchoPantalla = 600;
    private int largoPantalla = 800;
    //Nombramos una variable de tipo group
    Group grupoNave;
    //Creamos una variable de tipo poligono
    Polygon poligono;
    //Creamos variables de tipo rectangle
    Rectangle rect2;
    Rectangle rect1;
    
    //Creamos la nave de tipo publico
    public Nave(){
        //Creamos el grupo y se lo igualamos a la variable de tipo grupo
        grupoNave = new Group();
        //Creamos el poligono y se lo igualamos a la variable de tipo poligono
        poligono = new Polygon();
        //Dibujamos los punto del dibujo del poligono creado anteriormente
        poligono.getPoints().addAll(new Double[]{
            0.0, -20.0,
            -15.0, 20.0,
            15.0, 20.0 
        });
        //Pintamo el poligo de un color
        poligono.setFill(Color.BLUE);
        //Creamos los rectangulos y se lo igualamos a las variable de tipo rectangulo
        rect1 = new Rectangle(7, 5);
        rect2 = new Rectangle(7, 5);
        //Posicionamos los rectangulos
        rect1.setTranslateX(-13);
        rect2.setTranslateX(6);
        rect1.setTranslateY(20);
        rect2.setTranslateY(20);
        //Pintamos los rectangulos
        rect1.setFill(Color.BLUE);
        rect2.setFill(Color.BLUE);
        //Anadimos al grupo el poligono y los dos rectangulos
        grupoNave.getChildren().addAll(poligono, rect1,rect2);
        //Posicionamos el grupo
        grupoNave.setTranslateX(posicionNaveX);
        grupoNave.setTranslateY(posicionNaveY);
    }
    //Creamos un metodo de tipo void
    public void mover(){
        //Posicionamos el grupoNave a la posicion de la nave
        grupoNave.setTranslateX(posicionNaveX);
        grupoNave.setTranslateY(posicionNaveY);
        //Sumamos e igualamos la posicion con la velocidad
        posicionNaveX+=velocidadNaveX;
        posicionNaveY+=velocidadNaveY;
        //Rotamos la nave 90 grados
        grupoNave.setRotate(giroNave+90);
        //Sumamaos e igualamos el giroNave con la VelocidadGiro
        giroNave+=velocidadGiro;
        //Convertimos a radianas la variable gironave y la introducimos en la varible giroNaveRadianes
        giroNaveRadianes=Math.toRadians(giroNave); 
        //Comprobamos los limites de la pantalla y si soobrepasn trasladamos las posiciones
        if(posicionNaveX<=0){
            //Ponemos la barra en la posicion 0 para que no se nos valla
            grupoNave.setTranslateX(posicionNaveX=largoPantalla);
            }else{
                //Para no sobrepasar el vorde inferior
                if(posicionNaveX>=largoPantalla){
                    grupoNave.setTranslateX(posicionNaveX=0);
                }
        }
        if(posicionNaveY <= 0){
            //Ponemos la barra en la posicion 0 para que no se nos valla
            grupoNave.setTranslateY(posicionNaveY=anchoPantalla);
            }else{
                //Para no sobrepasar el vorde inferior
                if(posicionNaveY>=anchoPantalla){
                    grupoNave.setTranslateY(posicionNaveY=0);
               }
        }
        grupoNave.setTranslateY(posicionNaveY);
    }
    //Creamos un metodo de tipo dooble para retorna la variable de tipo double posicionNaveX
    public double getNavePosX(){
        return posicionNaveX;
    }
    //Creamos un metodo de tipo dooble para retorna la variable de tipo double posicionNaveY
    public double getNavePosY(){
        return posicionNaveY;      
    }
    //Creamos un metodo de tipo void donde vamos a poner falso la visivilidad de lo que contiene el grupoNave
    public void naveInvisible(){
        poligono.setVisible(false);
        rect1.setVisible(false);
        rect2.setVisible(false);
    }
    //Creamos un metodo de tipo void
    public void acereraNave(){
        //Igualamaos y sumamos la posicion con la velocidad
        posicionNaveX+=velocidadNaveX;
        posicionNaveY+=velocidadNaveY;
        //Igualamos la conversion en radianes de una variable a otra
        giroNaveRadianes=Math.toRadians(giroNave);
        //Summamos e igualamosel seno a velocidad desde la variable de GiroNaveRadian y lo multiplicamos por la velocidad absoluta
        velocidadNaveX+=Math.cos(giroNaveRadianes)*velocidadAbsoluta;
        velocidadNaveY+=Math.sin(giroNaveRadianes)*velocidadAbsoluta;
    }
    //Creamos un metodo de tipo void
    public void reducirNave(){
        posicionNaveX+=velocidadNaveX;
        posicionNaveY+=velocidadNaveY;
        giroNaveRadianes=Math.toRadians(giroNave);
        //En este metodo todo es similar al anterior meno lo siguiente que lo restamos.
        velocidadNaveX-=Math.cos(giroNaveRadianes)*velocidadAbsoluta;
        velocidadNaveY-=Math.sin(giroNaveRadianes)*velocidadAbsoluta;
    }
    //creamos un metodo de tipo double para retornar una variable de tipo double
    public double giroNave(){
        return giroNave;
    }
    //creamos un metodo de tipo double para retornar una variable de tipo double
    public double giroNaveRadianes(){
        return giroNaveRadianes;
    }
    //Creamos un metodo de tipo void
    public void giroNaveDerecha(){
        //Igualamos la velocidad de giro a 5
        velocidadGiro=5;
        //Sumamos e igualamos giroNave a la velocidadGiro
        giroNave+=velocidadGiro;
        //Igualamos la variable giroNave al resto de la operacion
        giroNave=giroNave%360;
    }
    //Creamos un metodo de tipo void
    public void giroNaveIzquierda(){
        //Igualamos y restamos en 5 la velocidadGiro
        velocidadGiro=-5;
        //Restamos e igualamos giroNave a la velocidadGiro
        giroNave-=velocidadGiro;
        //Igualamos la variable giroNave al resto de la operacion
        giroNave=giroNave%360;
    }
    //Creamos un metodo de tipo void para poner la velocidadGiro a 0
    public void ponerVelGiro0(){
        velocidadGiro=0;
    }
    //creamos un metodo de tipo double para retornar una variable de tipo double
    public double getVelocidadNaveX(){
       return velocidadNaveX;
    }
    //creamos un metodo de tipo double para retornar una variable de tipo double
    public double getVelocidadNaveY(){
       return velocidadNaveX;
    }
    //Creamos un metodo de tipo group donde retornamos el grupoNave
    public Group getGrupoNave(){
        return grupoNave;
    }
    //Creamos un metodo de tipo poligono donde retornamos el poligono
    public Polygon getPolNave(){
        return poligono;
    }
    
                
                
    
    
}