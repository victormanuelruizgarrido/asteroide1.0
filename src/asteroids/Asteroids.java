package asteroids;


//Importaciones de paquetes de javafx y java.
//Importacion para poder hacer las lista asteroide y bala.
import java.util.ArrayList;
//Importacion para generar un numero aleatorio
import java.util.Random;
//Importacion para poder generar la animacion
import javafx.animation.AnimationTimer;
//Importacion para generar la aplicacion
import javafx.application.Application;
//Importacion para posicionar las puntuaciones
import javafx.geometry.Pos;
//Diferente tipos de importaciones para la ventana
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


//Creacion de metodo publico de la clase acteroide donde se extiende la aplicacion.
//Nota:En ella crearemos lo que tengamos que utilizar mas de una vez en esta clase sea de donde sea.
public class Asteroids extends Application {
    //Creacion de una variable llamada nave de clase Nave.
    Nave nave = new Nave();
    //Creacion de la variable bala1 de tipo Bala sin inicializar.
    Bala bala1;
    //Creacion de la variable asteroide de tipo Asteroide.
    Asteroide asteroide;
    //Creacion de la listaAsteroide que contendran Asteroide.
    ArrayList<Asteroide> listaAsteroide = new ArrayList();
    //Creacion de la listaBala que contendra Bala
    ArrayList <Bala> listaBalas = new ArrayList();
    //Creacion variable tipo asteroide inicializada en null
    Asteroide asteroideEliminar=null;
    //Creacion de la variable tipo Bala inicializada en null
    Bala balaEliminar=null;
    //Creacion de variable finPartida de tipo Text que contendra el siguiente texto.
    Text finPartida = new Text("Fin del juego has derrotado al número total de asteroides.");
    //Creacion de variable tipo string incializada en null
    String TEXT_SIZE = null;
    //Creacion de la variable tipo Text
    Text textScore;
    //Creacion de una variable entera sin inicializar
    int score;
    //Creacion de variable boleana inicializada en falso.
    boolean finPar = false; 
    boolean finPar2 = false; 
    //Creacion de variable entera la cual no podremos modificar por ser final
    final int anchoPantalla = 600;
    final int largoPantalla = 800;
    //Creacion de variables de tipo double sin inicializar
    double posicionAstX;
    double posicionAstY;
    
    
    @Override
    //Metodo publico de tiipo void
    public void start(Stage primaryStage) {
        //Crearemos el root de tipo Pane
        Pane root = new Pane();
        //Creamos la scene de tipo Scene donde le asignamos valores como el root y medidas.
        Scene scene = new Scene(root, largoPantalla, anchoPantalla);
        //Nombramos nuestra scene
        primaryStage.setTitle("vamosPracticando");
        //Le asignamos nuestra scene
        primaryStage.setScene(scene);
        //Mostramo nuestra scene
        primaryStage.show();
        //Añadimos hijos al root de tipo nave el metodo getGrupoNave
        root.getChildren().add(nave.getGrupoNave());
        //Creamos una variable tipo Random
        Random posAst = new Random();
        //Creamos un bucle donde asignamos que valdra 3.
        for(int i=0; i<3; i++){
                    //Inicializamos la variable asteroide de tipo Astoroide con las siguiente posiciones.
                    asteroide = new Asteroide( posicionAstX, posicionAstY);
                    //Cogemos los asteroides de la lista y lo guardamos en la variable asteroide 
                    listaAsteroide.add(asteroide);
                    //Posicionamos el asteroide con el numero aleatorio que hemos generado anteriormente
                    asteroide.posAsteroideX=posAst.nextInt(largoPantalla);
                    asteroide.posAsteroideY=posAst.nextInt(anchoPantalla);
                    //Anadimos hijos al root en este caso asteroide con el metodo mostrarAsteroide.
                    root.getChildren().add(asteroide.mostrarAsteroide());
                    
                }
        //Layout principal
        HBox paneScores = new HBox();
        paneScores.setTranslateY(20);
        paneScores.setMinWidth(largoPantalla);
        paneScores.setAlignment(Pos.CENTER);
        paneScores.setSpacing(100);
        root.getChildren().add(paneScores);
        //Layout puntuacion actual
        HBox paneActualScores = new HBox();
        paneActualScores.setSpacing(10);
        paneScores.getChildren().add(paneActualScores);
        //Layout puntuacion maxima
        HBox paneMaximaScores = new HBox();
        paneMaximaScores.setSpacing(10);
        paneScores.getChildren().add(paneMaximaScores);
        //Texto de etiqueta para puntuacion
        Text textoTituloPuntuacion = new Text("Score");
        textoTituloPuntuacion.setFont(Font.font(TEXT_SIZE));
        textoTituloPuntuacion.setFill(Color.BLUE);
        //Texto para puntuacion
        textScore = new Text("0");
        textScore.setFont(Font.font(TEXT_SIZE));
        textScore.setFill(Color.BLUE);
        //Texto de etiqueta para puntuacion
        Text textoTituloMaximaPuntuacion = new Text("Max.Score");
        textoTituloMaximaPuntuacion.setFont(Font.font(TEXT_SIZE));
        textoTituloMaximaPuntuacion.setFill(Color.BLUE);
        //Texto para puntuacion
        Text textoMaximaPuntuacion = new Text("0");
        textoMaximaPuntuacion.setFont(Font.font(TEXT_SIZE));
        textoMaximaPuntuacion.setFill(Color.BLUE);
        //Añadir los textos a los layaut reservados
        paneActualScores.getChildren().add(textoTituloPuntuacion);
        paneActualScores.getChildren().add(textScore);
        paneMaximaScores.getChildren().add(textoTituloMaximaPuntuacion);
        paneMaximaScores.getChildren().add(textoMaximaPuntuacion);
        
        
        //Creamos la animacionAsteroide de tipo AnimationTimer
        AnimationTimer animacionAsteroide = new AnimationTimer(){
            @Override
            public void handle(long now) {
                //Comprobacion si la variable es verdadera y asigaciones.
                if(finPar==true){
                    //Posicionamiento color y tipo de letra de finPartida
                    finPartida.setLayoutX(250);
                    finPartida.setLayoutY(250);
                    finPartida.setFill(Color.BLUE);
                    finPartida.setFont(Font.font(TEXT_SIZE));
                    //Asignamos el metodo asteroideInvisible
                    asteroide.asteroideInvisible();
                    //Asignamos el metodo balaInvisible
                    bala1.balaInvisible();
                    //Asignamos el metodo naveInvisible
                    nave.naveInvisible();
                    this.stop();
                    root.getChildren().add(finPartida);
                }
                //Comprobacion si la variable es verdadera y asigaciones.
                if(finPar2==true){
                    finPartida.setLayoutX(300);
                    finPartida.setLayoutY(250);
                    finPartida.setFill(Color.BLUE);
                    finPartida.setFont(Font.font(TEXT_SIZE));
                    asteroide.asteroideInvisible();
                    nave.naveInvisible();
                    this.stop();
                    root.getChildren().add(finPartida);
                }
                //Recorrido de la listaAsteroide desde 0 hasta su tamaño de 1 en 1
                for(int i=0; i<listaAsteroide.size(); i++){
                    //Asignamos a la variable asteroides los asteroides cogido de la lista
                    asteroide = listaAsteroide.get(i);
                    //Asignacion de un metodo al asteroide.
                    asteroide.moverAsteroide();
                }
                //Recorrido de la listaBalas desde 0 hasta su tamaño de 1 en 1
                for(int i=0; i<listaBalas.size(); i++){
                    Bala bala1= listaBalas.get(i);
                    bala1.moverBala();
                }
                //Recorrido de la listaBalas desde 0 hasta su tamaño de 1 en 1
                for(int i=0; i<listaBalas.size(); i++){
                    //Asignacion a la variable bala1 las balas cogido de la lista.
                    bala1= listaBalas.get(i);
                    //Comprobacion de la posicion de la bala fuera de los limites.
                    if(bala1.getPosBalaX()>largoPantalla || bala1.getPosBalaX()<0){
                        //Asignamos un metodo a la mariable bala1
                        bala1.balaInvisible();
                        //Borramos la bala anterior de la lista
                        listaBalas.remove(bala1);
                    }
                }
                //Recorrido de la listaBalas desde 0 hasta su tamaño de 1 en 1
                for(int i=0; i<listaBalas.size(); i++){
                    //Asignacion a la variable bala1 las balas cogido de la lista.
                    bala1= listaBalas.get(i);
                    //Comprobacion de la posicion de la bala fuera de los limites.
                    if(bala1.getPosBalaY()>anchoPantalla || bala1.getPosBalaX()<0){
                        //Asignamos un metodo a la mariable bala1
                        bala1.balaInvisible();
                        //Borramos la bala anterior de la lista
                        listaBalas.remove(bala1);
                    }
                }
                //Asignaciion falsa a la variable buleana asteroideInv
                boolean asteroideInv=false;
                //Recorrido de la listaAsteroide desde 0 hasta su tamaño de 1 en 1
                for(int i=0; i<listaAsteroide.size(); i++){
                    //Asignacion a la variable asteroides los asteroides codigo de la lista.
                    asteroide=listaAsteroide.get(i);
                    /*Comprobacion del metodo getColision comprobado atraves de los dos metodos
                    uno de clase asteroide llamado mostrarAsteroide que nos retorna un poligono
                    y otro de la clase nave que nos retorna la figura de la nave*/
                    if(getColision(asteroide.mostrarAsteroide(), nave.getPolNave())){
                        //Asignamos un metodo de la nave.
                        nave.naveInvisible();
                        //Pasamos a true la variable buleana asteroideInv
                        asteroideInv=true;
                    }
                }
                //Comprobamos si asteroideInv es true
                if(asteroideInv==true){
                    //Recorrido de la listaAsteroide desde 0 hasta su tamaño de 1 en 1
                    for(int i=0; i<listaAsteroide.size(); i++){
                        //Asignamos un metodo a los asteroides cogido de la lista.
                        listaAsteroide.get(i).asteroideInvisible();
                    }
                    //Borramos listaAsteroide
                    listaAsteroide.removeAll(listaAsteroide);
                    //Pasamos a true la variable finPar2
                    finPar2=true;
                }; 
                //Recorrido de la listaBalas desde 0 hasta su tamaño de 1 en 1
                for(int i=0; i<listaBalas.size(); i++){
                    //Asignacion a la variable bala1 las balas cogido de la lista.
                    bala1=listaBalas.get(i);
                    //Recorrido de la listaAsteroide desde 0 hasta su tamaño de 1 en 1
                    for(int e=0; e<listaAsteroide.size(); e++){
                        //Asignacion a la variable asteroide las asteroide cogido de la lista.
                        asteroide=listaAsteroide.get(e);
                        /*Comprobacion del metodo getColision comprobado atraves de los dos metodos
                    uno de clase asteroide llamado mostrarAsteroide que nos retorna un poligono
                    y otro de la clase bala que nos retorna otro poligono*/
                        if (getColision(asteroide.mostrarAsteroide(),bala1.mostrarBala())){
                            //Guardo la bala en balaEliminar
                            balaEliminar=bala1;
                            //Asigno el metodo balaInvisible a balaEliminar
                            balaEliminar.balaInvisible();
                            asteroideEliminar=asteroide;
                            asteroideEliminar.asteroideInvisible();
                            //Aumento el numero de la variable score de tipo entero
                            score++;
                            //Modifico los datos con el valor de la variable score
                            textScore.setText(String.valueOf(score));
                        }
                    }
                    //Borro de la listaAsteroide el asteroideEliminar
                    listaAsteroide.remove(asteroideEliminar);
                    //Compruebo sii la lista esta vacia
                    if(listaAsteroide.isEmpty()){
                        //Asigno true en la variable finPar
                        finPar=true;
                    }
                }
                //Elimino balaEliminar de la listaBala
                listaBalas.remove(balaEliminar);
                //Recorrido de la listaAsteroide desde 0 hasta su tamaño de 1 en 1
                for(int i=0; i<listaAsteroide.size(); i++){
                    //Asignacion a la variable asteroide las asteroide cogido de la lista.
                    asteroide=listaAsteroide.get(i);
                    //Asigno el metodo checkearBordes al asteroide
                    asteroide.checkearBordes();
                }
                //Asigno el metodo mover a la nave.
                nave.mover();
            }
            
        };
        //Doy comienzo a la aplicacion
        animacionAsteroide.start();
       

        scene.setOnKeyPressed((KeyEvent event)-> {
            switch(event.getCode()){
                //Disponemos de diferentes casos de presionado en el teclado
                case UP:
                    //Asignamos el metodo de la clase nave acereraNave cuando pulsamos up
                    nave.acereraNave();
                    break;
                case DOWN:
                    //Asignamos el metodo de la clase nave reducirNave cuando pulsamos DOWN
                    nave.reducirNave();
                     break;       
                case RIGHT:
                    //Asignamos el metodo de la clase nave giroNaveDerecha cuando pulsamos RIGHT
                    nave.giroNaveDerecha();
                    break;                    
                case LEFT:
                    //Asignamos el metodo de la clase nave giroNaveIzquierda cuando pulsamos LEFT
                    nave.giroNaveIzquierda();
                    break;
                case SPACE:
                    //Inicializamos la variable bala1 con los siguientes parametros la posicion y el giro
                    bala1 = new Bala(nave.getNavePosX(),nave.getNavePosY(),nave.giroNave());
                    //Añadimos una bala1 a la listaBala cuando presionamos
                    listaBalas.add(bala1);
                    //Asignamos a bala1 el metodo dispararBala
                    bala1.dispararBala();
                    //Añadimos la bala al root con el parametro mostrarBala
                    root.getChildren().add(bala1.mostrarBala());
                    break;
                
                } 
        });
        
        
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch(event.getCode()){
                //Disponemos de diferentes casos cuando dejamos de presionar el teclado
                case LEFT:
                    //Asignamos un metodo a la nave
                    nave.ponerVelGiro0();
                    break;
                case RIGHT:
                    //Asignamos un metodo a la nave
                    nave.ponerVelGiro0();
                    break; 
            }
        });
         
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    //Creamos el metodo getColision de tipo boolean para comprobar dos poligonos
    private boolean getColision(Polygon obj1, Polygon obj2){
        return !Shape.intersect(obj1, obj2).getBoundsInLocal().isEmpty();
    }
    
}