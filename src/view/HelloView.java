package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class HelloView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Timer timer;
	Thread t;
	
	public HelloView() {
		
		init();
		timer.start();
		t.start();
		initView();
	}
	
	public void initView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CodeJava\\App\\Img\\Ark.png"));
		setSize(450, 300);
		setTitle("HỆ THỐNG QUẢN LÝ");
		setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\CodeJava\\App\\Img\\Logo-VNU - Copy.png"));
		lblNewLabel.setBounds(10, 10, 416, 198);
		contentPane.add(lblNewLabel);
		
		progressBar_chao = new JProgressBar();
		progressBar_chao.setFont(new Font("Tahoma", Font.BOLD, 12));
		progressBar_chao.setStringPainted(true);
		progressBar_chao.setForeground(Color.BLUE);
		progressBar_chao.setBounds(10, 230, 416, 23);
		contentPane.add(progressBar_chao);	
		
		jLabel_status = new JLabel("   Khởi động ứng dụng...");
		jLabel_status.setFont(new Font("Tahoma", Font.BOLD, 10));
		jLabel_status.setBounds(10, 208, 218, 23);
		contentPane.add(jLabel_status);
		
		this.setVisible(true);
	}
	
	public void init() {		
		
	timer =	new Timer(40, new ActionListener() {			
		@Override
		public void actionPerformed(ActionEvent e) {
			int value = progressBar_chao.getValue();
			if(value < 100) {
				progressBar_chao.setValue(value + 1);
					
			}else {
				HelloView.this.dispose();
				timer.stop();
				new MainView();
			}
		}
			
	});
	
	t = new Thread() {
	int i = -1;
	@Override
	public void run() {
		while(true){
			try {
				i++;
                if(i==20)jLabel_status.setText("   Đang khởi tạo...");
                if(i==50)jLabel_status.setText("   Đang kết dữ liệu...");
                if(i==90)jLabel_status.setText("   Chuẩn bị vào chương trình...");
                if(i==100){
                    HelloView.this.dispose();
                    break; 
                }
                    Thread.sleep(40);   //tạm dừng hoạt động trong 40 ms
            	} catch (InterruptedException ex) {
            		break;
            	}
		}
	}
		
	};
	
	}
	
	private JPanel contentPane;
	private JProgressBar progressBar_chao;
	private JLabel jLabel_status;
	private JLabel lblNewLabel;
}