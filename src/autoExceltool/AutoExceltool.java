package autoExceltool;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AutoExceltool implements ActionListener
{
	private JFrame frame;
	
	private JLabel lbCmntyName;
	
	private JTextField tfCmntyName1;              //问题是Oparation中的外层if循环使里面的flag没有执行，需要继续修改
	private JTextField tfCmntyName2;
	private JTextField tfCmntyName3;
	private JTextField tfCmntyName4;
	private JTextField tfCmntyName5;
	
	private JButton btnProcess;
	
	private JButton btnProcess1;
	
	public static String text1;
	public static String text2;
	public static String text3;
	public static int text4;
	public static String text5;
	
	Oparation result = new Oparation();	//需要拿到外面，要不然数据会被覆盖
	
	public static void main(String[] args)
	{
		AutoExceltool tool = new AutoExceltool();
		tool.invitView();
//		Judge jd = new Judge();
//		jd.judgeUnit("A2");
	}
	
	private void invitView()
	{
		frame = new JFrame("自动生成小区门牌工具");
		Container c = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //关闭窗口时退出程序   EXIT是关闭窗口时推出执行的程序，DISPOSE是只关闭窗口
		
		JPanel contentPanel = createContentPanel();
		c.add(contentPanel, BorderLayout.BEFORE_FIRST_LINE);
		
		JPanel btnPanel = createBtnPanel();
		c.add(btnPanel, BorderLayout.SOUTH);
		
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private JPanel createContentPanel()
	{
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridBagLayout());
		
		lbCmntyName = new JLabel("小区名称");           //标签的内容
		tfCmntyName1 = new JTextField();              //输入框的内容
		//GridBagConstraints详见收藏百科
		contentPanel.add(lbCmntyName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(50,  50,  0,  50), 0, 0));
		contentPanel.add(tfCmntyName1, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(50,  -40,  0,  50), 0, 0));
		
		lbCmntyName = new JLabel("输入楼栋号用逗号隔开"); 
		tfCmntyName2 = new JTextField();
		
		
		contentPanel.add(lbCmntyName, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(50,  50,  0,  50), 0, 0));
		contentPanel.add(tfCmntyName2, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(50,  -40,  0,  50), 0, 0));
		
		lbCmntyName = new JLabel("输入单元数"); 
		tfCmntyName3 = new JTextField();
		
		
		contentPanel.add(lbCmntyName, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(50,  50,  0,  50), 0, 0));
		contentPanel.add(tfCmntyName3, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(50,  -40,  0,  50), 0, 0));
		
		lbCmntyName = new JLabel("共有几层"); 
		tfCmntyName4 = new JTextField();             
		
		contentPanel.add(lbCmntyName, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(50,  50,  0,  50), 0, 0));
		contentPanel.add(tfCmntyName4, new GridBagConstraints(1, 3, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(50,  -40,  0,  50), 0, 0));
		
		lbCmntyName = new JLabel("每层几户"); 
		tfCmntyName5 = new JTextField();             
		
		contentPanel.add(lbCmntyName, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(50,  50,  0,  50), 0, 0));
		contentPanel.add(tfCmntyName5, new GridBagConstraints(1, 4, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(50,  -40,  0,  50), 0, 0));
		
		return contentPanel;
	}
	
	private JPanel createBtnPanel()
	{
		JPanel btnPanel = new JPanel();
		
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnProcess1 = new JButton("继续新增");
		btnPanel.add(btnProcess1);
		btnProcess1.addActionListener(this);
		
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnProcess = new JButton("生成");
		btnPanel.add(btnProcess);
		btnProcess.addActionListener(this);//What's this?
		
		return btnPanel;
	}
	
	private void process()
	{
		
	//	do {
			Read rd = new Read();
			apartment apt = rd.readData();
			//apartment apt = rd.readData(text1,text2,text3,text4,text5);
			result.operation(apt.getName(),apt.getStory(),apt.getOutdoor(),apt.getFf_length(),
					apt.getFloor(),apt.getUn_length(),apt.getUnit());
			//result.operation(apt);
	//	}
	//	while(judge==1);
		result.output();	//一定要用最开始建的对象，否则这个对象的list和原始的list不是一个，值便为空
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnProcess)
		{
			JOptionPane.showMessageDialog(frame, "生成成功");
	    //	int judge = 0;
			
			text1 = tfCmntyName1.getText();
			text2 = tfCmntyName2.getText();
			
			text3 = tfCmntyName3.getText();    //强制转换
			
			text4 = Integer.parseInt(tfCmntyName4.getText());
			text5 = tfCmntyName5.getText();
			
						
			process();
		//	System.out.println(apt.getName()+"\t"+apt.getFf_length()+"\t"+apt.getUn_length()+"\t"+apt.getStory());
			
		}
		if(e.getSource() == btnProcess1)
		{
	//	    int judge = 1;
			text1 = tfCmntyName1.getText();
			text2 = tfCmntyName2.getText();
			text3 = tfCmntyName3.getText();    //强制转换
			text4 = Integer.parseInt(tfCmntyName4.getText());
			text5 = tfCmntyName5.getText();
			
			process();
			tfCmntyName2.setText("");
			tfCmntyName3.setText("");
			tfCmntyName4.setText("");
			tfCmntyName5.setText("");
			JOptionPane.showMessageDialog(frame, "请继续输入数据");
			
			
		}
	}
}


