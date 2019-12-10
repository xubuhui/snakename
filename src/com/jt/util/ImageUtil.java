package com.jt.util;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author xgq
 * 图片工具类
 */

public class ImageUtil {
	//根据图片路径获取Image
	public static Image getImage(String fileName) {
		return getImageIcon(fileName).getImage();
	}
	
	public static ImageIcon getImageIcon(String fileName) {
		return new ImageIcon(fileName);
 }
}