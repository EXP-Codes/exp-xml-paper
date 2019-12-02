package exp.xp.ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * <PRE>
 * 异常信息打印界面
 * </PRE>
 * <br/><B>PROJECT : </B> exp-xml-paper
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2015-06-01
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class Error extends JFrame {

	/** 序列化唯一标识 */
	private static final long serialVersionUID = 1196699895273393507L;

	/** 屏幕宽度 */
	private final int winWidth = 
			(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	/** 屏幕高度 */
	private final int winHigh = 
			(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	/** 界面初始宽度 */
	private int width = 600;
	
	/** 界面初始高度 */
	private int high = 500;
	
	/** 根面板 */
	private JPanel rootPanel;
	
	/** 异常信息标签 */
	private JTextArea errInfo;
	
	/** 单例 */
	private static volatile Error instance;
	
	/**
	 * 构造函数
	 */
	public Error() {
		super("Error Details");
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
	 * 创建界面单例
	 */
	public static Error getInstn() {
		if(instance == null) {
			synchronized (Error.class) {
				if(instance == null) {
					instance = new Error();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponents() {
		this.errInfo = new JTextArea();
		errInfo.setEditable(false);
		rootPanel.add(new JScrollPane(errInfo), BorderLayout.CENTER);
	}
	
	/**
	 * 显示界面
	 * @param e 异常信息
	 */
	public void display(Throwable e) {
		if(e != null) {
			StringBuilder sb = new StringBuilder();
			sb.append(e.getMessage()).append("\r\n");
			
			StackTraceElement[] sts = e.getStackTrace();
			for(StackTraceElement st : sts) {
				sb.append("    ").append(st.toString()).append("\r\n");
			}
			errInfo.setText(sb.toString());
			errInfo.setCaretPosition(0);
		}
		
		this.setVisible(true);
	}
	
}
