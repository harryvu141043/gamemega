package com.son.effect;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

public class CacheDataloader {
    private static CacheDataloader instance;
    private Hashtable<String, FrameImage> frameImages;
    private Hashtable<String, Animation> animations;
    private String framefile = "data/frame.txt";
    private String animationfile = "data/animation.txt";

    private CacheDataloader() {
    }

    public static CacheDataloader getInstance() {
        if (instance == null)
            instance = new CacheDataloader ();
        return instance;
    }

    public void LoadFrame() throws IOException {
        frameImages = new Hashtable<String,FrameImage> ();
        FileReader fr = new FileReader ( framefile );
        BufferedReader br = new BufferedReader ( fr );
        String line = null;
        if (br.readLine () == null) {
            System.out.println ( "no data" );
            throw new IOException ();
        } else {
            fr = new FileReader ( framefile );
            br = new BufferedReader ( fr );
            while ((line = br.readLine ()).equals ( "" )) ;
            int n = Integer.parseInt ( line );
            for (int i = 0; i < n; i++) {
                FrameImage frame = new FrameImage ();
                while ((line = br.readLine ()).equals ( "" )) ;
                frame.setName ( line );

                while ((line = br.readLine ()).equals ( "" )) ;
                String[] str = line.split ( " " );
                String path = str[1];

                while ((line = br.readLine ()).equals ( "" )) ;
                str = line.split ( " " );
                int x = Integer.parseInt ( line );

                while ((line = br.readLine ()).equals ( "" )) ;
                str = line.split ( " " );
                int y = Integer.parseInt ( line );

                while ((line = br.readLine ()).equals ( "" )) ;
                str = line.split ( " " );
                int w = Integer.parseInt ( line );

                while ((line = br.readLine ()).equals ( "" )) ;
                str = line.split ( " " );
                int h = Integer.parseInt ( line );

                BufferedImage imageData = ImageIO.read ( new File ( path ) );
                BufferedImage image = imageData.getSubimage ( x, y, w, h );
                frame.setImage ( image );
                instance.frameImages.put ( frame.getName (), frame );
            }
        }
        br.close ();
    }

    public void LoadData() throws IOException {

        LoadFrame ();
        LoadAnimation ();

    }

    public Animation getAnimation(String name) {
        Animation animation = new Animation ( instance.animations.get ( name ) );
        return animation;
    }

    public FrameImage getFrameImage(String name) {

        FrameImage frameImage = new FrameImage (instance.frameImages.get(name));
        return frameImage;
    }

    public void LoadAnimation() throws IOException {

        animations = new Hashtable<String,Animation> ();

        FileReader fr = new FileReader ( animationfile );
        BufferedReader br = new BufferedReader ( fr );

        String line = null;

        if (br.readLine () == null) {
            System.out.println ( "No data" );
            throw new IOException ();
        } else {

            fr = new FileReader ( animationfile );
            br = new BufferedReader ( fr );

            while ((line = br.readLine ()).equals ( "" )) ;
            int n = Integer.parseInt ( line );

            for (int i = 0; i < n; i++) {

                Animation animation = new Animation ();

                while ((line = br.readLine ()).equals ( "" )) ;
                animation.setName ( line );

                while ((line = br.readLine ()).equals ( "" )) ;
                String[] str = line.split ( " " );

                for (int j = 0; j < str.length; j += 2)
                    animation.add ( getFrameImage ( str[j] ), Double.parseDouble ( str[j + 1] ) );

                instance.animations.put ( animation.getName (), animation );
            }
        }
        br.close ();
    }
}
