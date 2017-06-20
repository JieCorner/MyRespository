package com.news.management.bean;

import java.awt.Rectangle;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.util.Iterator;  
  
import javax.imageio.ImageIO;  
import javax.imageio.ImageReadParam;  
import javax.imageio.ImageReader;  
import javax.imageio.stream.ImageInputStream;  
  
public class CutPicture {  
    private String srcpath;  
    private String subpath;  
    public void setSrcpath(String srcpath) {  
        this.srcpath = srcpath;  
    }  
    public void setSubpath(String subpath) {  
        this.subpath = subpath;  
    }  
    private int x;  
    private int y;  
    private int width;  
    private int height;  
    public CutPicture() {  
    }  
    public CutPicture(int x, int y, int width, int height) {  
        this.x = x;  
        this.y = y;  
        this.width = width;  
        this.height = height;  
    }  
    public void cut() throws IOException {  
        FileInputStream is = null;  
        ImageInputStream iis = null;  
        try {  
            is = new FileInputStream(srcpath);  
            Iterator<ImageReader> it = ImageIO  
                    .getImageReadersByFormatName("jpg");  
            ImageReader reader = it.next();  
            iis = ImageIO.createImageInputStream(is);  
            reader.setInput(iis, true);  
            ImageReadParam param = reader.getDefaultReadParam();  
            Rectangle rect = new Rectangle(x, y, width, height);  
            param.setSourceRegion(rect);  
            BufferedImage bi = reader.read(0, param);  
            ImageIO.write(bi, "jpg", new File(subpath));  
        } finally {  
            if (is != null)  
                is.close();  
            if (iis != null)  
                iis.close();  
        }  
  
    }  
}  
