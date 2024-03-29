package LineChart;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;


@SuppressWarnings("serial")
public class frameChart extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public frameChart() 
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					frameChart frame = new frameChart();
					frame.setVisible(true);
					String query = "SELECT * FROM Data";
					JDBCCategoryDataset data = new JDBCCategoryDataset("jdbc:mysql://localhost/Mhs","com.mysql.jdbc.Driver","root","root");
					data.executeQuery(query);
					JFreeChart chart = ChartFactory.createLineChart("Index Prestasi","Nama", "Nilai", data,PlotOrientation.VERTICAL,true, true, false);
					ChartPanel cPanel = new ChartPanel(chart);
					frame.setContentPane(cPanel);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
