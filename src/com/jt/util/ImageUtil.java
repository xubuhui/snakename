package com.jt.util;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author xgq
 * ͼƬ������
 */

public class ImageUtil {
	//����ͼƬ·����ȡImage
	public static Image getImage(String fileName) {
		return getImageIcon(fileName).getImage();
	}
	
	public static ImageIcon getImageIcon(String fileName) {
		return new ImageIcon(fileName);
 }
}