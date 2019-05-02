package com.son.effect;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FrameImage {
    private String name;
    private BufferedImage image;
    public int getImagewitdh(){
        return image.getWidth ();
    }
    public int getImageHeight(){
        return image.getHeight ();
    }
    public void draw(Graphics2D g2,int x,int y){
        g2.drawImage(image,x-image.getWidth()/2,y-image.getHeight ()/2,null);
    }


    public  BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FrameImage(String name, BufferedImage image){
        this.name=name;
        this.image=image;
    }
    public FrameImage(FrameImage frameImage){
        image=new BufferedImage ( frameImage.getImagewitdh (),frameImage.getImageHeight (),
                frameImage.getImage ().getType ());
        Graphics g=image.getGraphics ();
        g.drawImage ( frameImage.getImage (),0,0,null );
    }
}
