package exp.xp.ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exp.xp.layout.VFlowLayout;

/**
 * <PRE>
 * 版本界面
 * </PRE>
 * <br/><B>PROJECT : </B> exp-xml-paper
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2015-06-01
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class About extends JFrame {

	/** 序列化唯一标识 */
	private static final long serialVersionUID = -1111433651089959809L;
	
	/** 屏幕宽度 */
	private final int winWidth = 
			(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	/** 屏幕高度 */
	private final int winHigh = 
			(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	/** 界面初始宽度 */
	private int width = 350;
	
	/** 界面初始高度 */
	private int high = 180;
	
	/** 根面板 */
	private JPanel rootPanel;
	
	/**
	 * 构造函数
	 */
	public About() {
		super("About");
		this.setSize(width, high);
		this.setLocation((winWidth / 2 - width / 2), (winHigh / 2 - high / 2));
		
		this.rootPanel = new JPanel(new BorderLayout());
		this.setContentPane(rootPanel);
		initComponents();
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
			}
		});
	}

	/**
	 * 初始化组件
	 */
	private void initComponents() {
		JPanel iconPanel = new JPanel(new BorderLayout()); {
			URL imageUrl = this.getClass().getResource("xIcon.png");
			JLabel icon = new JLabel(new ImageIcon(imageUrl));
			iconPanel.add(icon, BorderLayout.CENTER);
		}
		rootPanel.add(iconPanel, BorderLayout.WEST);
		
		JPanel infoPanel = new JPanel(new VFlowLayout()); {
			JLabel name = new JLabel("    Exp-Xml-Paper");
			JLabel empty1 = new JLabel("");
			JLabel version = new JLabel("    Version : 1.0.0.0");
			JLabel build = new JLabel(  "    Build id: 20150528-0022");
			JLabel empty2 = new JLabel("");
			JLabel author = new JLabel( "    Author  : Exp");
			infoPanel.add(name);
			infoPanel.add(empty1);
			infoPanel.add(version);
			infoPanel.add(build);
			infoPanel.add(empty2);
			infoPanel.add(author);
		}
		rootPanel.add(infoPanel, BorderLayout.CENTER);
	}
	
	/**
	 * 显示界面
	 */
	public void display() {
		this.setVisible(true);
	}
	
}
