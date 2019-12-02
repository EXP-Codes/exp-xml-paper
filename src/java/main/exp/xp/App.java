package exp.xp;

import exp.xp.ui.XmlPaper;
import exp.xp.utils.BeautyEye;

/**
 * <PRE>
 * 程序实例
 * </PRE>
 * <br/><B>PROJECT : </B> exp-xml-paper
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2015-06-01
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class App {

	private final String appName = "exp-xml-paper";
	
	private static volatile App instance;
	
	private App(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				clean();
			}
		});
		
		init();
		run();
	}
	
	public static void createInstn(String[] args) {
		if(instance == null) {
			synchronized (App.class) {
				if(instance == null) {
					instance = new App(args);
				}
			}
		}
	}
	
	private void init() {
		BeautyEye.init();
	}
	
	private void run() {
		XmlPaper.createInstn(appName);
	}
	
	private void clean() {
		
	}
	
}
