package exp.xp.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import exp.xp.layout.VFlowLayout;

/**
 * <PRE>
 * 升级界面
 * </PRE>
 * <br/><B>PROJECT : </B> exp-xml-paper
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2015-06-01
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class Update extends JFrame {

	/** 序列化唯一标识 */
	private static final long serialVersionUID = 8637813186139218150L;

	/** 屏幕宽度 */
	private final int winWidth = 
			(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	/** 屏幕高度 */
	private final int winHigh = 
			(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	/** 界面初始宽度 */
	private int width = 300;
	
	/** 界面初始高度 */
	private int high = 130;
	
	/** 根面板 */
	private JPanel rootPanel;
	
	/** 进度条 */
	private JProgressBar progressBar;
	
	/** 提示信息 */
	private JLabel tips;
	
	/**
	 * 构造函数
	 */
	public Update() {
		super("Update");
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
		JPanel updatePanel = new JPanel(new VFlowLayout()); {
			progressBar = new JProgressBar(0, 100);
			progressBar.setValue(0);
			tips = new JLabel("It's looking for the latest version...");
			
			updatePanel.add(progressBar);
			updatePanel.add(tips);
		}
		rootPanel.add(updatePanel, BorderLayout.CENTER);
	}
	
	/**
	 * 显示界面
	 */
	public void display() {
		this.setVisible(true);
		
		Thread thread = new Thread() {
			public void run() {
				for(int val = 0; val <= 100; val += 10) {
					progressBar.setValue(val);
					tSleep(500);
				}
				tips.setForeground(Color.RED);
				tips.setText("老实说这升级功能并没有什么卵用...  >o<");
			};
		};
		thread.start();
	}

	/**
	 * 休眠
	 * @param millis 休眠时间
	 */
	private void tSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			//
		}
	}
	
}
