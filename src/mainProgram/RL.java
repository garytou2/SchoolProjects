package mainProgram;

import java.awt.*;
import java.io.*;

/**
 * Helper Methods' class
 * <div></div>
 *  Copyright (C) 2018  Gary Tou and Michael Schwamborn
 *  <div></div>
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * <div></div>
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * <div></div>
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 * 
 *
 */
public class RL {
//Fonts
	/**
	 * load True Type Fonts
	 * @param path to the TTF file
	 * @return the True Type Font
	 */
	public static Font loadFont(String path) {
		Font ttfBase = null;
  		Font ttfReal = null;
		try {
			InputStream myStream = new BufferedInputStream(new FileInputStream(path));
			ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
			ttfReal = ttfBase.deriveFont(Font.PLAIN, 24);
			return ttfReal;
		} catch (Exception ex) {
	        ex.printStackTrace();
	        BackEnd.logs.update.ERROR("Font could not be loaded from  " + path);
	        System.err.println("Font could not be loaded from  " + path);
	        return null;
	    }
    }
	
	//Load fonts
	private static Font Main = loadFont(config.KollektifFilePath); //Main font
	private static Font Title = loadFont(config.RubikFilePath); //Title Font
	private static Font Text = loadFont(config.CairoFilePath); //Regular Text font
	
	//for dynamic font size
	private static double width = config.screenWidth;
	private static double height = config.screenWidth;
	//private static double width = 0;
	//private static double height = 0;
	private static float both = (float) (width + height);
	
	//Color
	public static Color ForestGreen = Color.decode("#33B523");
	
//preset font sizes		NOTE: IF A USER FONT VAR EXISTS, USE THAT ONE. Vars that don't have user vars can not be changed by the user
	//stats
		public static Font TeacherName = Main.deriveFont(Font.BOLD, both/70);
			public static Font userTeacherName = TeacherName; //user changed size
		public static Font otherInfo = Title.deriveFont(Font.PLAIN, both/200);
			public static Font userOtherInfo = otherInfo;
	//preferences
		public static Font preferencesTitle = Title.deriveFont(Font.BOLD, both/80);
		public static Font preferencesText = Text.deriveFont(Font.PLAIN, both/170);
	//message center
		public static Font scanMessage = Text.deriveFont(Font.BOLD, both/150);
		public static Font otherMessage = Text.deriveFont(Font.BOLD, both/230);
			public static Font userOtherMessage = otherMessage;
		
	//table
		public static Font tableTitle = Title.deriveFont(Font.BOLD, both/250);
		public static Font tableClearButton = Text.deriveFont(Font.PLAIN, both/250);
		public static Font tableText = Text.deriveFont(Font.PLAIN, both/200);
	//scan
		public static Font scan = Main.deriveFont(Font.BOLD, both/100);
			public static Font userScan = scan;

	
//Color
	/**
	 * Easily get Color Object for color string name<br>
	 * Example of use: pane.setBackground(RL.color("ELECTRIC_BLUE"));
	 * @param color Enter a color. Example: "SMOKEY_BLACK", "DARK_GUNMETAL", "LAVENDER_GRAY", "ELECTRIC_BLUE", "KEPPEL"
	 * @return Color Object of color name entered
	 * @exception ColorException
	 */
	public static Color color(String color) { //PRAM COLOR NAME, RETURN COLOR
		switch(color){
		case "SMOKEY_BLACK": 
			Color SMOKEY_BLACK = new Color(0x0B0C10);
			return SMOKEY_BLACK;
		case "DARK_GUNMETAL": 
			Color DARK_GUNMETAL = new Color(0x1F2833);
			return DARK_GUNMETAL;
		case "LAVENDER_GRAY": 
			Color LAVENDER_GRAY = new Color(0xC5C6C7);
			return LAVENDER_GRAY;
		case "ELECTRIC_BLUE": 
			Color ELECTRIC_BLUE = new Color(0x66FCF1);
			return ELECTRIC_BLUE;
		case "KEPPEL": 
			Color KEPPEL = new Color(0x45A29E);
			return KEPPEL;
		default:
			ColorException.StringError(color);
			return null;
		}
	}
	public static String colorHex(String color) { //PRAM COLOR NAME, RETURN COLOR HEX #
		switch(color){
		case "SMOKEY_BLACK": 
			String SMOKEY_BLACK = new String("0B0C10");
			return SMOKEY_BLACK;
		case "DARK_GUNMETAL": 
			String DARK_GUNMETAL = new String("1F2833");
			return DARK_GUNMETAL;
		case "LAVENDER_GRAY": 
			String LAVENDER_GRAY = new String("C5C6C7");
			return LAVENDER_GRAY;
		case "ELECTRIC_BLUE": 
			String ELECTRIC_BLUE = new String("66FCF1");
			return ELECTRIC_BLUE;
		case "KEPPEL": 
			String KEPPEL = new String("45A29E");
			return KEPPEL;
		default:
			ColorException.StringError(color);
			return null;
		}
	}
	public static Color color(int color) { //PRAM INT NAME, RETURN COLOR
		switch(color){
		case 1: 
			Color SMOKEY_BLACK = new Color(0x0B0C10);
			return SMOKEY_BLACK;
		case 2: 
			Color DARK_GUNMETAL = new Color(0x1F2833);
			return DARK_GUNMETAL;
		case 3: 
			Color LAVENDER_GRAY = new Color(0xC5C6C7);
			return LAVENDER_GRAY;
		case 4: 
			Color ELECTRIC_BLUE = new Color(0x66FCF1);
			return ELECTRIC_BLUE;
		case 5: 
			Color KEPPEL = new Color(0x45A29E);
			return KEPPEL;
		default:
			ColorException.intError(color);
			return null;
		}
	}
	public static String colorHex(int color) { //PRAM INT NAME, RETURN COLOR HEX #
		switch(color){
		case 1: 
			String SMOKEY_BLACK = new String("0B0C10");
			return SMOKEY_BLACK;
		case 2: 
			String DARK_GUNMETAL = new String("1F2833");
			return DARK_GUNMETAL;
		case 3: 
			String LAVENDER_GRAY = new String("C5C6C7");
			return LAVENDER_GRAY;
		case 4: 
			String ELECTRIC_BLUE = new String("66FCF1");
			return ELECTRIC_BLUE;
		case 5: 
			String KEPPEL = new String("45A29E");
			return KEPPEL;
		default:
			ColorException.intError(color);
			return null;
		}
	}
	/**
	 * Color Exceptions for when an invalid color name or int is entered
	 * 
	 * @author Gary
	 *
	 */
	private static class ColorException extends Exception{
		ColorException(String str)
		{
		   super(str);
		}
		private static void StringError(String color) {
			try {
		       	throw new ColorException("\"" + color + "\" " +  "does not exist in the RL.java interface");
				}
			catch (ColorException e) {
				e.printStackTrace();
			}
		}
		private static void intError(int color) {
			try {
		       	throw new ColorException("\"" + color + "\" " +  "does not exist in the RL.java interface. Try numbers 1-5");
				}
			catch (ColorException e) {
				e.printStackTrace();
			}
		}
	}
}
