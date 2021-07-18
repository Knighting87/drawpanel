import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class DrawPanel extends JPanel {

	BufferedImage bufferImage=null;
	Graphics2D bufferGraphics=null;
	Color currentColor=Color.black;
	//Color currentPaintColor=Color.black;
	Float currentWidth=10.0f;

	public void setPenColor(Color newColor) {
		currentColor = newColor;
	}
	public void setPenWidth(float newWidth) {
		currentWidth = newWidth;
	}
	public void setColor(Color newColor){
		//currentColor = newColor;
		bufferGraphics.setColor(newColor);
	}
	public void setStroke(Float width){
		BasicStroke wideStroke = new BasicStroke(width);
    bufferGraphics.setStroke(wideStroke);
	}

	public void createBuffer(int width, int height) {
       //バッファ用のImageとGraphicsを用意する
		bufferImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
		bufferGraphics=bufferImage.createGraphics(); //getGraphicsと似ているが、戻り値がGraphics2D。
		bufferGraphics.setBackground(Color.white);
		bufferGraphics.clearRect(0, 0, width, height); //バッファクリア
		repaint();
	}

	public void openFile(File file2open){
		BufferedImage pictureImage;
		try {
			pictureImage = ImageIO.read(file2open);
		} catch(Exception e){
			System.out.println("Error: reading file="+file2open.getName());
			return;
		}
		this.createBuffer(this.getWidth(),this.getHeight());
		bufferGraphics.drawImage(pictureImage,0,0,getSize().width, getSize().height,this);
		repaint();
	}
	public void saveFile(File file2save) {
		try {
			ImageIO.write(bufferImage, "jpg", file2save);
		} catch (Exception e) {
			System.out.println("Error: writing file="+file2save.getName());
			return;
		}
	}
	public void drawLine(int x1, int y1, int x2, int y2){
		if(null==bufferGraphics) {
		 	this.createBuffer(this.getWidth(),this.getHeight());  //バッファをまだ作ってなければ作る
		}
		bufferGraphics.setStroke(new BasicStroke(currentWidth ,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
		bufferGraphics.setColor(currentColor);
		bufferGraphics.drawLine(x1, y1, x2, y2); // バッファに描画する
		repaint();//再描画するためpaintComponentを呼び出す。
 	}
	public void drawOval(int x, int y, int w, int h){
		if(null==bufferGraphics) {
		 	this.createBuffer(this.getWidth(),this.getHeight());  //バッファをまだ作ってなければ作る
		}
		bufferGraphics.drawOval(x,y,w,h);
		repaint();
	}
	public void drawRect(int x, int y, int w, int h){
		if(null==bufferGraphics) {
		 	this.createBuffer(this.getWidth(),this.getHeight());  //バッファをまだ作ってなければ作る
		}
		bufferGraphics.drawRect(x,y,w,h);
		repaint();
	}
	public void drawImage(Image img,int x,int y,ImageObserver observer){
		bufferGraphics.drawImage(img,x,y,observer);
		repaint();
	}
	public void drawArc(int x, int y, int w, int h,int startAngle, int arcAngle){
		if(null==bufferGraphics) {
		 	this.createBuffer(this.getWidth(),this.getHeight());  //バッファをまだ作ってなければ作る
		}
		bufferGraphics.drawArc(x,y,w,h,startAngle,arcAngle);
		repaint();
	}

	public void clear(int w,int h) {
		if(null==bufferGraphics) {
		 	this.createBuffer(this.getWidth(),this.getHeight());  //バッファをまだ作ってなければ作る
		}
    bufferGraphics.setColor(Color.WHITE);
    bufferGraphics.fillRect(0, 0, w, h);
    repaint();
  }
	public void fillOval(int x, int y, int w, int h){
		if(null==bufferGraphics) {
		 	this.createBuffer(this.getWidth(),this.getHeight());  //バッファをまだ作ってなければ作る
		}
		bufferGraphics.fillOval(x,y,w,h);
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);//他に描画するものがあるかもしれないので親を呼んでおく
		if(null!=bufferImage) g.drawImage(bufferImage, 0,0, getSize().width, getSize().height,this);//バッファを表示する

	}

}
