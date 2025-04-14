//Basic Game Application
// Basic Object, Image, Movement
// Threaded

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

//*******************************************************************************

public class BasicGameApp implements Runnable {

    Vehicle Car1;
    Vehicle Car2;
    Vehicle Ball;

    boolean isColliding1 = false;
    boolean isColliding2 = false;
    boolean isColliding3 = false;
    boolean isColliding4 = false;
    boolean isColliding5 = false;
    boolean isColliding6 = false;
    boolean isColliding7 = false;
    boolean isColliding8 = false;
    boolean isColliding9 = false;
    boolean isColliding10 = false;
    boolean isColliding11 = false;
    boolean isColliding12 = false;

    int randChange1 = (int)(Math.random()*5+2);
    int randChange2 = (int)(Math.random()*5+2);
    int randChange3 = (int)(Math.random()*5+2);
    int randChange4 = (int)(Math.random()*5+2);

    Image BackgroundPic;

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 1000;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() { // BasicGameApp constructor

        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game
        Car1 = new Vehicle(300,400,0,2,150,100);
        Car1.pic = Toolkit.getDefaultToolkit().getImage("Car1R.png");

        Car2 = new Vehicle(300,200,0,randChange4,150,100);
        Car2.pic = Toolkit.getDefaultToolkit().getImage("Car2L.png");

        Ball = new Vehicle(450,400,5,5,100,100);
        Ball.pic = Toolkit.getDefaultToolkit().getImage("Ball.png");

        BackgroundPic = Toolkit.getDefaultToolkit().getImage("Field.png");

    } // end BasicGameApp constructor


//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.

        while (true) {
            moveThings();  //move all the game objects
            Collide();
            render();  // paint the graphics
            pause(10); // sleep for 10 ms
        }
    }

    public void moveThings() {
        //call the move() code for each object
        Car1.move();
        Car2.move();
        Ball.move();

        if(Car1.dx > 0){
            Car1.pic = Toolkit.getDefaultToolkit().getImage("Car1R.png");
        }
        else{
            Car1.pic = Toolkit.getDefaultToolkit().getImage("Car1L.png");
        }

        if(Car2.dx > 0){
            Car2.pic = Toolkit.getDefaultToolkit().getImage("Car2R.png");
        }
        else{
            Car2.pic = Toolkit.getDefaultToolkit().getImage("Car2L.png");
        }
    }

    public void Collide() {
        if (!Car1.hitboxL.intersects(Ball.hitboxR)) {
            isColliding1 = false;
        }
        if (!Car1.hitboxL.intersects(Car2.hitboxR)) {
            isColliding2 = false;
        }
        if (!Car2.hitboxL.intersects(Ball.hitboxR)) {
            isColliding3 = false;
        }
        if (!Car1.hitboxT.intersects(Ball.hitboxB)) {
            isColliding4 = false;
        }
        if (!Car1.hitboxT.intersects(Car2.hitboxB)) {
            isColliding5 = false;
        }
        if (!Car2.hitboxT.intersects(Ball.hitboxB)) {
            isColliding6 = false;
        }
        if (!Car1.hitboxR.intersects(Ball.hitboxL)) {
            isColliding7 = false;
        }
        if (!Car1.hitboxR.intersects(Car2.hitboxL)) {
            isColliding8 = false;
        }
        if (!Car2.hitboxR.intersects(Ball.hitboxL)) {
            isColliding9 = false;
        }
        if (!Car1.hitboxB.intersects(Ball.hitboxT)) {
            isColliding10 = false;
        }
        if (!Car1.hitboxB.intersects(Car2.hitboxT)) {
            isColliding11 = false;
        }
        if (!Car2.hitboxB.intersects(Ball.hitboxT)) {
            isColliding12 = false;
        }


        if (Car1.hitboxL.intersects(Ball.hitboxR) && !isColliding1) {
            Car1.dx = -Car1.dx;
            Ball.dx = -Ball.dx;
            isColliding1 = true;
        }
        if (Car1.hitboxL.intersects(Car2.hitboxR) && !isColliding2) {
            Car1.dx = -Car1.dx;
            Car2.dx = -Car2.dx;
            isColliding2 = true;
        }
        if (Car2.hitboxL.intersects(Ball.hitboxR) && !isColliding3) {
            Car2.dx = -Car2.dx;
            Ball.dx = -Ball.dx;
            isColliding3 = true;
        }
        if (Car1.hitboxT.intersects(Ball.hitboxB) && !isColliding4) {
            Car1.dy = -Car1.dy;
            Ball.dy = -Ball.dy;
            isColliding4 = true;
        }
        if (Car1.hitboxT.intersects(Car2.hitboxB) && !isColliding5) {
            Car1.dy = -Car1.dy;
            Car2.dy = -Car2.dy;
            isColliding5 = true;
        }
        if (Car2.hitboxT.intersects(Ball.hitboxB) && !isColliding6) {
            Car2.dy = -Car2.dy;
            Ball.dy = -Ball.dy;
            isColliding6 = true;
        }
        if (Car1.hitboxR.intersects(Ball.hitboxL) && !isColliding7) {
            Car1.dx = -Car1.dx;
            Ball.dx = -Ball.dx;
            isColliding7 = true;
        }
        if (Car1.hitboxR.intersects(Car2.hitboxL) && !isColliding8) {
            Car1.dx = -Car1.dx;
            Car2.dx = -Car2.dx;
            isColliding8 = true;
        }
        if (Car2.hitboxR.intersects(Ball.hitboxL) && !isColliding9) {
            Car2.dx = -Car2.dx;
            Ball.dx = -Ball.dx;
            isColliding9 = true;
        }
        if (Car1.hitboxB.intersects(Ball.hitboxT) && !isColliding10) {
            Car1.dy = -Car1.dy;
            Ball.dy = -Ball.dy;
            isColliding10 = true;
        }
        /*if (Car1.hitboxB.intersects(Car2.hitboxT) && !isColliding11) {
            Car1.dy = -Car1.dy;
            Car2.dy = -Car2.dy;
            isColliding11 = true;
        }*/
        if (Car2.hitboxB.intersects(Ball.hitboxT) && !isColliding12) {
            System.out.println("car 2 bottom ball top");
            Car2.dy = -Car2.dy;
            Ball.dy = -Ball.dy;
            isColliding12 = true;
        }
    }


    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        g.drawImage(BackgroundPic, 0,0,WIDTH,HEIGHT,null);
        g.drawImage(Car1.pic, Car1.xpos, Car1.ypos, Car1.width, Car1.height, null);
        g.drawImage(Car2.pic, Car2.xpos, Car2.ypos, Car2.width, Car2.height, null);
        g.drawImage(Ball.pic, Ball.xpos, Ball.ypos, Ball.width, Ball.height, null);
        //draw the images
        g.drawRect(Car1.hitboxL.x,Car1.hitboxL.y+20,20,Car1.hitboxL.height-40);
        g.drawRect(Car1.hitboxR.x+130,Car1.hitboxR.y+20,20,Car1.hitboxR.height-40);
        g.drawRect(Car1.hitboxT.x+20,Car1.hitboxT.y,Car1.hitboxT.width-40,20);
        g.drawRect(Car1.hitboxB.x+20,Car1.hitboxB.y+80,Car1.hitboxB.width-40,20);

        g.drawRect(Car2.hitboxL.x,Car2.hitboxL.y+20,20,Car2.hitboxL.height-40);
        g.drawRect(Car2.hitboxR.x+130,Car2.hitboxR.y+20,20,Car2.hitboxR.height-40);
        g.drawRect(Car2.hitboxT.x+20,Car2.hitboxT.y,Car2.hitboxT.width-40,20);
        g.drawRect(Car2.hitboxB.x+20,Car2.hitboxB.y+80,Car2.hitboxB.width-40,20);

        g.drawRect(Ball.hitboxL.x,Ball.hitboxL.y+20,20,Ball.hitboxL.height-40);
        g.drawRect(Ball.hitboxR.x+80,Ball.hitboxR.y+20,20,Ball.hitboxR.height-40);
        g.drawRect(Ball.hitboxT.x+20,Ball.hitboxT.y,Ball.hitboxT.width-40,20);
        g.drawRect(Ball.hitboxB.x+20,Ball.hitboxB.y+80,Ball.hitboxB.width-40,20);

        g.dispose();
        bufferStrategy.show();
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(true);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!
        JFrame jf = new JFrame();
        jf.setSize(1000,1000);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

}