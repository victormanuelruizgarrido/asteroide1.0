package asteroids;

//Importaciones de paquetes de javafx.
import javafx.scene.shape.Polygon;

public class Bala {
    //Creacion de variables de tipo double
    private double posicionBalaY = 0;
    private double posicionBalaX = 0;
    private double velocidadAbsolutaBala = 10;
    private double velocidadBalaX = 0;
    private double velocidadBalaY = 0;
    private double giroBala;
    private double giroBalaRadianes;
    //Creacion de variable bala tipo poligono
    Polygon bala = new Polygon();
    
    //Creacion de la bala de tipo publico con los diferentes parametros de posicion y giro
    public Bala(double navePosX, double navePosY,double giroNave) {
        //Dibujamos la bala con los diferentes puntos 
        bala.getPoints().addAll(new Double[]{
                        0.0, -2.0,
                        -3.0, 10.0,
                        -2.0, 10.0,
                        -2.0, 15.0,
                        2.0, 15.0,
                        2.0, 10.0,
                        3.0, 10.0,
                        0.0, -2.0
        });
        //Posicionamos la bala e igualamos posiciones y giro ectraido de la nave
        bala.setLayoutX(navePosX);
        posicionBalaX=navePosX;
        bala.setLayoutY(navePosY);
        posicionBalaY=navePosY;
        bala.setRotate(giroNave+90);
        giroBala=giroNave;
    }
    //Creamos un metodo de tipo void llamado moverBala
    public void moverBala(){
        //Posicionamos la bala. Sumamos e igualamos la posicion a la velocidad.
        bala.setLayoutX(posicionBalaX);
        posicionBalaX+=velocidadBalaX;
        bala.setLayoutY(posicionBalaY);
        posicionBalaY+=velocidadBalaY;
        //Hacemos la conversion matematica de radianes y la metemos en variable.
        giroBalaRadianes=Math.toRadians(giroBala);
    }
    //Creamos un metodo de tipo void llamado despararBala
    public void dispararBala(){
        //Hacemos la conversion matematica de radianes y la metemos en variable
        giroBalaRadianes=Math.toRadians(giroBala);
        //Hacemos la conversion del seno y coseno del angulo en radiane y multiplicamos por velAbs
        velocidadBalaX=Math.cos(giroBalaRadianes)*velocidadAbsolutaBala;
        velocidadBalaY=Math.sin(giroBalaRadianes)*velocidadAbsolutaBala;
        //Posicionamos la bala. Sumamos e igualamos la posicion a la velocidad.
        bala.setLayoutX(posicionBalaX);
        posicionBalaX+=velocidadBalaX;
        bala.setLayoutY(posicionBalaY);
        posicionBalaY+=velocidadBalaY;
    }
    //Creamos un metodo de tipo double que nos retornara la variable de tipo double
    public double getPosBalaX(){
        return posicionBalaX;
    }
    //Creamos un metodo de tipo double que nos retornara la variable de tipo double
    public double getPosBalaY(){
        return posicionBalaY;
    }
    //Creamos un metodo de tipo void 
    public void balaInvisible(){
        //Asignamos al dibujo de asteroide la visilidad en falso
        bala.setVisible(false);
    }
    //Creamos un metodo de tipo poligono llamado mostrarBala
    public Polygon mostrarBala(){
        //Retornamos el poligono bala
        return bala;
    }
    
    
}