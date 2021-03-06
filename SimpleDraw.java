import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JColorChooser;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Dimension;



public class SimpleDraw extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

   int lastx, lasty, newx, newy;
   int i=0;
   DrawPanel panel = new DrawPanel();
   JFileChooser fileChooser = new JFileChooser();
   Color color=null;
   int pentype=1;
   int stamptype=0;
   Image img;

   public void actionPerformed(ActionEvent e) {
     if(e.getActionCommand().equals("New")){
       SimpleDraw frame = new SimpleDraw();
       frame.setSize(900,600);
       frame.setLocationRelativeTo(null);
       frame.init();
     }
     if(e.getActionCommand().equals("Clear")){
       panel.clear(panel.getWidth(),panel.getHeight());
     }

      if(e.getActionCommand().equals("Black")){
        color=Color.black;
      }else if(e.getActionCommand().equals("Red")){
        color=Color.red;
      }else if(e.getActionCommand().equals("Blue")){
        color=Color.blue;
      }else if(e.getActionCommand().equals("Green")){
        color=Color.green;
      }else if(e.getActionCommand().equals("Yellow")){
        color=Color.yellow;
      }else if(e.getActionCommand().equals("Other")) {
        JColorChooser colorchooser = new JColorChooser();
        color = colorchooser.showDialog(this,"choose a color",Color.blue);
        panel.setPenColor(color);
        panel.setColor(color);
      }
    if(e.getActionCommand().equals("mini")){
      pentype=1;
      stamptype=0;
      panel.setPenColor(Color.WHITE);
      panel.setPenWidth(5);
    }else if(e.getActionCommand().equals("midium")){
      pentype=1;
      stamptype=0;
      panel.setPenColor(Color.WHITE);
      panel.setPenWidth(10);
    }else if(e.getActionCommand().equals("big")){
      pentype=1;
      stamptype=0;
      panel.setPenColor(Color.WHITE);
      panel.setPenWidth(20);
    }

    if(e.getActionCommand().equals("width1"))
     panel.setPenWidth(1);
    else if(e.getActionCommand().equals("width5"))
     panel.setPenWidth(5);
    else if(e.getActionCommand().equals("width10"))
     panel.setPenWidth(10);
    else if(e.getActionCommand().equals("width20"))
     panel.setPenWidth(20);

     if(e.getActionCommand().equals("normal")){
       stamptype=0;
       pentype=1;
     }else if(e.getActionCommand().equals("double")){
       stamptype=0;
       pentype=2;
     }else if(e.getActionCommand().equals("en")){
       stamptype=0;
       pentype=3;
     }else if(e.getActionCommand().equals("rainbow")){
       stamptype=0;
       pentype=4;
     }

    if(e.getActionCommand().equals("Open")){
      int returnVal = fileChooser.showOpenDialog(this);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
      	panel.openFile(fileChooser.getSelectedFile());
      }
    }
    if(e.getActionCommand().equals("Save")){
      int returnVal = fileChooser.showSaveDialog(this);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
      	panel.saveFile(fileChooser.getSelectedFile());
      }
    }
    if(e.getActionCommand().equals("frame1")){
      panel.openFile(new File("frame1.png"));
    }else if(e.getActionCommand().equals("frame2")){
      panel.openFile(new File("frame2.png"));
    }else if(e.getActionCommand().equals("frame3")){
      panel.openFile(new File("frame3.png"));
    }else if(e.getActionCommand().equals("frame4")){
      panel.openFile(new File("frame4.png"));
    }else if(e.getActionCommand().equals("frame5")){
      panel.openFile(new File("frame5.png"));
    }else if(e.getActionCommand().equals("frame6")){
      panel.openFile(new File("frame6.png"));
    }

    if(e.getActionCommand().equals("small1")){
      this.setSize(600,400);
    }else if(e.getActionCommand().equals("midium1")){
      this.setSize(900,600);
    }else if(e.getActionCommand().equals("large1")){
      this.setSize(1200,756);
    }else if(e.getActionCommand().equals("small2")){
      this.setSize(600,400);
      panel.createBuffer(600,356);
    }else if(e.getActionCommand().equals("midium2")){
      this.setSize(900,600);
      panel.createBuffer(900,556);
    }else if(e.getActionCommand().equals("large2")){
      this.setSize(1200,900);
      panel.createBuffer(1200,856);
    }
    if(e.getActionCommand().equals("blackcircle")){
      pentype=0;
      stamptype=1;
      color=Color.black;
    }else if(e.getActionCommand().equals("redcircle")){
      pentype=0;
      stamptype=1;
      color=Color.red;
    }else if(e.getActionCommand().equals("bluecircle")){
      pentype=0;
      stamptype=1;
      color=Color.blue;
    }else if(e.getActionCommand().equals("greencircle")){
      pentype=0;
      stamptype=1;
      color=Color.green;
    }else if(e.getActionCommand().equals("yellowcircle")){
      pentype=0;
      stamptype=1;
      color=Color.yellow;
    }else if(e.getActionCommand().equals("othercircle")){
      pentype=0;
      stamptype=1;
      JColorChooser colorchooser = new JColorChooser();
      color = colorchooser.showDialog(this,"choose a color",Color.blue);
    }else if(e.getActionCommand().equals("stamp2")){
      pentype=0;
      stamptype=2;
    }else if(e.getActionCommand().equals("stamp3")){
      pentype=0;
      stamptype=3;
    }else if(e.getActionCommand().equals("stamp4")){
      pentype=0;
      stamptype=4;
    }if(e.getActionCommand().equals("blackshikaku")){
      pentype=0;
      stamptype=5;
      color=Color.black;
    }else if(e.getActionCommand().equals("redshikaku")){
      pentype=0;
      stamptype=5;
      color=Color.red;
    }else if(e.getActionCommand().equals("blueshikaku")){
      pentype=0;
      stamptype=5;
      color=Color.blue;
    }else if(e.getActionCommand().equals("greenshikaku")){
      pentype=0;
      stamptype=5;
      color=Color.green;
    }else if(e.getActionCommand().equals("yellowshikaku")){
      pentype=0;
      stamptype=5;
      color=Color.yellow;
    }else if(e.getActionCommand().equals("othershikaku")){
      pentype=0;
      stamptype=5;
      JColorChooser colorchooser = new JColorChooser();
      color = colorchooser.showDialog(this,"choose a color",Color.blue);
    }else if(e.getActionCommand().equals("stamp6")){
      pentype=0;
      stamptype=6;
      img = Toolkit.getDefaultToolkit().getImage("./stamp6.png");
    }else if(e.getActionCommand().equals("stamp7")){
      pentype=0;
      stamptype=7;
      img = Toolkit.getDefaultToolkit().getImage("./stamp7.png");
    }else if(e.getActionCommand().equals("stamp8")){
      pentype=0;
      stamptype=8;
      img = Toolkit.getDefaultToolkit().getImage("./stamp8.png");
    }else if(e.getActionCommand().equals("stamp9")){
      pentype=0;
      stamptype=9;
      img = Toolkit.getDefaultToolkit().getImage("./stamp9.png");
    }else if(e.getActionCommand().equals("stamp10")){
      pentype=0;
      stamptype=10;
      img = Toolkit.getDefaultToolkit().getImage("./stamp10.png");
    }else if(e.getActionCommand().equals("stamp11")){
      pentype=0;
      stamptype=11;
      img = Toolkit.getDefaultToolkit().getImage("./stamp11.png");
    }
  }

   public void mouseDragged(MouseEvent e) {
       newx=e.getX();
       newy=e.getY();
       if(pentype==1){
         panel.drawLine(lastx,lasty-44,newx,newy-44);
       }else if(pentype==2){
         panel.drawLine(lastx,lasty-50,newx,newy-50);
         panel.drawLine(lastx,lasty-30,newx,newy-30);
       }else if(pentype==3){
         if(color==null){
           panel.setColor(Color.black);
         }else{
           panel.setColor(color);
         }
         panel.setStroke(5.0f);
         panel.drawOval(lastx,lasty-50,50,50);
       }else if(pentype==4){
         panel.setPenColor(Color.red);
         panel.drawLine(lastx,lasty-55,newx,newy-55);
         panel.setPenColor(Color.orange);
         panel.drawLine(lastx,lasty-50,newx,newy-50);
         panel.setPenColor(Color.yellow);
         panel.drawLine(lastx,lasty-45,newx,newy-45);
         panel.setPenColor(Color.green);
         panel.drawLine(lastx,lasty-40,newx,newy-40);
         panel.setPenColor(Color.cyan);
         panel.drawLine(lastx,lasty-35,newx,newy-35);
         panel.setPenColor(Color.blue);
         panel.drawLine(lastx,lasty-30,newx,newy-30);
         panel.setPenColor(Color.magenta);
         panel.drawLine(lastx,lasty-25,newx,newy-25);
       }
       lastx=newx;
       lasty=newy;
   }
   public void mouseMoved(MouseEvent e) {
	 }
   public void mouseClicked(MouseEvent e) {
   }
   public void mousePressed(MouseEvent e) {
     lastx=e.getX();
     lasty=e.getY();
     if(stamptype==1){
       panel.setColor(color);
       panel.drawOval(e.getX()-40,e.getY()-75,100,100);
     }else if(stamptype==2){
       panel.setColor(Color.black);
       panel.fillOval(e.getX()-5,e.getY()-50,40,40);
       panel.fillOval(e.getX()-17,e.getY()-70,30,30);
       panel.fillOval(e.getX()+17,e.getY()-70,30,30);
     }else if(stamptype==3){
       panel.setColor(Color.black);
       panel.fillOval(e.getX()-5,e.getY()-50,40,40);
       panel.fillOval(e.getX()-17,e.getY()-70,30,30);
       panel.fillOval(e.getX()+17,e.getY()-70,30,30);
       panel.setColor(Color.red);
       panel.fillOval(e.getX()-3,e.getY()-60,15,15);
       panel.fillOval(e.getX()+9,e.getY()-57,12,12);
       panel.fillOval(e.getX()+19,e.getY()-60,15,15);
       panel.setColor(Color.black);
     }else if(stamptype==4){
       panel.setColor(Color.yellow);
       panel.fillOval(e.getX()-20,e.getY()-75,60,60);
       panel.setColor(Color.black);
       panel.fillOval(e.getX()-5,e.getY()-65,10,20);
       panel.fillOval(e.getX()+15,e.getY()-65,10,20);
       panel.setStroke(5.0f);
       panel.drawArc(e.getX()-5,e.getY()-50,32,20,180,180);
     }else if(stamptype==5){
       panel.setColor(color);
       panel.drawRect(e.getX()-40,e.getY()-75,100,100);
     }else if(stamptype==6||stamptype==7||stamptype==8||stamptype==9||stamptype==10||stamptype==11){
       panel.drawImage(img, e.getX()-40,e.getY()-75, this);
     }

   }
   public void mouseReleased(MouseEvent e) {
   }

   public void mouseEntered(MouseEvent e) {
     if(i==0){
       panel.setPenColor(Color.white);
       panel.drawLine(0,0,0,0);
       i++;
       panel.setPenColor(Color.black);
     }
   }
   public void mouseExited(MouseEvent e) {
   }
   private void addMenuItem(JMenu targetMenu, String itemName, String actionName, ActionListener listener) {
 		JMenuItem menuItem = new JMenuItem(itemName);
 		menuItem.setActionCommand(actionName);
 		menuItem.addActionListener(listener);
 		targetMenu.add(menuItem);
 	 }

   private void init() {
      this.setTitle("????????????????????????????????????");
      this.setBackground(Color.cyan);
      this.addMouseListener(this);
      this.addMouseMotionListener(this);


      //??????????????????
      JMenuBar menubar=new JMenuBar();
  		JMenu menuFile = new JMenu("????????????");
  		this.addMenuItem(menuFile,"??????","New",this);
  		this.addMenuItem(menuFile,"??????","Open",this);
  		this.addMenuItem(menuFile,"??????","Save",this);
      this.addMenuItem(menuFile,"?????????","Clear",this);

      JMenu menuCanvas = new JMenu("???????????????");
      JMenu menuSmall = new JMenu("???");
      this.addMenuItem(menuSmall, "??????????????????????????????", "small1", this);
      this.addMenuItem(menuSmall, "?????????????????????????????????", "small2", this);
      JMenu menuMidium = new JMenu("???");
      this.addMenuItem(menuMidium, "??????????????????????????????", "midium1", this);
      this.addMenuItem(menuMidium, "?????????????????????????????????", "midium2", this);
      JMenu menuLarge = new JMenu("???");
      this.addMenuItem(menuLarge, "??????????????????????????????", "large1", this);
      this.addMenuItem(menuLarge, "?????????????????????????????????", "large2", this);

  		JMenu menuPen = new JMenu("??????");
      JMenu menuPensaki = new JMenu("???????????????");
      this.addMenuItem(menuPensaki,"????????????","normal",this);//pentype=1
      this.addMenuItem(menuPensaki,"?????????","double",this);//pentype=2
      this.addMenuItem(menuPensaki,"???","en",this);
      this.addMenuItem(menuPensaki,"???","rainbow",this);

      JMenu menuColor = new JMenu("???");
  		this.addMenuItem(menuColor, "??????", "Black", this);
      this.addMenuItem(menuColor, "??????", "Red", this);
      this.addMenuItem(menuColor, "??????", "Blue", this);
      this.addMenuItem(menuColor, "??????", "Green", this);
      this.addMenuItem(menuColor, "??????", "Yellow", this);
      this.addMenuItem(menuColor, "??????????????????", "Other", this);
  		JMenu menuWidth = new JMenu("??????");
  		this.addMenuItem(menuWidth, "??????", "width1", this);
  		this.addMenuItem(menuWidth, "??????", "width5", this);
  		this.addMenuItem(menuWidth, "??????", "width10", this);
  		this.addMenuItem(menuWidth, "??????", "width20", this);
      JMenu menuEraser = new JMenu("????????????");
      this.addMenuItem(menuEraser, "???", "mini", this);
      this.addMenuItem(menuEraser, "???", "midium", this);
      this.addMenuItem(menuEraser, "???", "big", this);
      JMenu menuFrame = new JMenu("????????????");
      this.addMenuItem(menuFrame, "??????", "frame1", this);
      this.addMenuItem(menuFrame,"???","frame2",this);
      this.addMenuItem(menuFrame,"?????????","frame3",this);
      this.addMenuItem(menuFrame,"?????????","frame4",this);
      this.addMenuItem(menuFrame,"??????????????????","frame5",this);
      this.addMenuItem(menuFrame,"???????????????","frame6",this);
      JMenu menuStamp = new JMenu("????????????");
      JMenu maruStamp = new JMenu("??????");
      this.addMenuItem(maruStamp,"??????","blackcircle",this);//stamptype=1
      this.addMenuItem(maruStamp,"??????","redcircle",this);
      this.addMenuItem(maruStamp,"??????","bluecircle",this);
      this.addMenuItem(maruStamp,"??????","greencircle",this);
      this.addMenuItem(maruStamp,"??????","yellowcircle",this);
      this.addMenuItem(maruStamp,"??????????????????","othercircle",this);
      JMenu shikakuStamp = new JMenu("?????????");
      this.addMenuItem(shikakuStamp,"??????","blackshikaku",this);
      this.addMenuItem(shikakuStamp,"??????","redshikaku",this);
      this.addMenuItem(shikakuStamp,"??????","blueshikaku",this);
      this.addMenuItem(shikakuStamp,"??????","greenshikaku",this);
      this.addMenuItem(shikakuStamp,"??????","yellowshikaku",this);
      this.addMenuItem(shikakuStamp,"??????????????????","othershikaku",this);
      this.addMenuItem(menuStamp,"????????????","stamp2",this);//stamptype=2
      this.addMenuItem(menuStamp,"?????????","stamp3",this);//stamptype=3
      this.addMenuItem(menuStamp,"???????????????","stamp4",this);//stamptype=4
      this.addMenuItem(menuStamp,"?????????????????????????????????","stamp6",this);
      this.addMenuItem(menuStamp,"?????????","stamp7",this);
      this.addMenuItem(menuStamp,"???","stamp8",this);
      this.addMenuItem(menuStamp,"???????????????","stamp9",this);
      this.addMenuItem(menuStamp,"?????????????????????","stamp10",this);
      this.addMenuItem(menuStamp,"???????????????","stamp11",this);

      menuPen.add(menuPensaki);
  		menuPen.add(menuWidth);
      menuPen.add(menuColor);
      menuStamp.add(maruStamp);
      menuStamp.add(shikakuStamp);
      menuCanvas.add(menuSmall);
      menuCanvas.add(menuMidium);
      menuCanvas.add(menuLarge);
      menubar.add(menuFile);
      menubar.add(menuCanvas);
  		menubar.add(menuPen);
      menubar.add(menuEraser);
      menubar.add(menuFrame);
      menubar.add(menuStamp);
  		this.setJMenuBar(menubar);

      this.getContentPane().add(panel);
      this.setVisible(true);//????????????????????????
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//??????????????????????????????????????????????????????????????????????????????
    }

    public static void main(String[] args) {
      SimpleDraw frame = new SimpleDraw();//SimpleDraw??????????????????????????????frame?????????
      frame.setSize(900,600);//?????????????????????????????????????????????????????????????????????????????????
      frame.setLocationRelativeTo(null);//???????????????????????????????????????
      frame.init();

    }

}
