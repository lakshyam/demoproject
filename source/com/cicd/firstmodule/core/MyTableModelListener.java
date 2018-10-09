package com.cicd.firstmodule.core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/*
 *  This class listens for changes made to the data in the table via the
 *  TableCellEditor. When editing is started, the value of the cell is saved
 *  When editing is stopped the new value is saved. When the oold and new
 *  values are different, then the provided Action is invoked.
 *
 *  The source of the Action is a TableCellListener instance.
 */
public class MyTableModelListener implements TableModelListener {

	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTable table = new JTable(tableModel);
	private JPanel statusPanel = new JPanel();
	private JLabel statusLabel = new JLabel();
	
	public String[] columns = new String[]{ "Column1 ", "Column 2" };
	

	MyTableModelListener() {
		
	}
	
	
	private DefaultTableModel getDefaultTableMode() {
		return this.tableModel;
	}
	
	private JTable getDataTable() {
		return this.table;
	}

	public void tableChanged(TableModelEvent e) {
		int firstRow = e.getFirstRow();
		int lastRow = e.getLastRow();
		int index = e.getColumn();

		switch (e.getType()) {
		case TableModelEvent.INSERT:
			for (int i = firstRow; i <= lastRow; i++) {
				statusLabel.setText(" Insert" );
			}
			break;
		case TableModelEvent.UPDATE:
			if (firstRow == TableModelEvent.HEADER_ROW) {
				if (index == TableModelEvent.ALL_COLUMNS) {
					statusLabel.setText(" A column was added");
				} else {
					statusLabel.setText(" in header changed");
				}
			} else {
				for (int i = firstRow; i <= lastRow; i++) {
					if (index == TableModelEvent.ALL_COLUMNS) {
						statusLabel.setText(" All columns have changed");
					} else {
						statusLabel.setText(" index " + index);
					}
				}
			}
			break;
		case TableModelEvent.DELETE:
			for (int i = firstRow; i <= lastRow; i++) {
				System.out.println(i);
			}
			break;
		}
	}
	
	public static void main(String... args) {


		MyTableModelListener modelListener = new MyTableModelListener();
		
		modelListener.getDefaultTableMode().addColumn("Column 1.");
		modelListener.getDefaultTableMode().addColumn("Column 2.");
		
		
	    
	    
	    Object[][] rowData = new Object[][]
	    		{
	    			{"One 1 ", "Two 1" },
	    			{"One 2",  "Two 2" },
	    			{"One 3",  "Two 3" },
	    		};
	    		

	    modelListener.getDefaultTableMode().addRow(rowData);
		
		
	    modelListener.getDefaultTableMode().addTableModelListener(new MyTableModelListener());
	    
	    
	    JFrame frame = new JFrame();
	    frame.setLayout(new GridLayout(3, 1));
	    frame.setSize(500,300);
	    frame.add(modelListener.getDataTable());
	    
//
//	    JPanel tablePanel = new JPanel(new GridLayout(400, 100));
//	    tablePanel.setPreferredSize(new Dimension(frame.getWidth(), 100));
//	    //tablePanel.add(modelListener.getDataTable());
//	    JScrollPane scrollPane = new JScrollPane(modelListener.getDataTable()); 
//	    tablePanel.add(scrollPane, BorderLayout.CENTER);
//	    tablePanel.setVisible(true);
//	    frame.getContentPane().add(tablePanel);
		

//		JPanel buttonPanel = new MyTableModelListener().getButtonPanel(frame.getWidth());
//		buttonPanel.setPreferredSize(new Dimension(frame.getWidth(), 80));
//		frame.add(buttonPanel, BorderLayout.CENTER);
//
//	    JPanel statusPanel = new MyTableModelListener().getStatusBar();
//	    statusPanel.setPreferredSize(new Dimension(20, 10));
//		frame.add(statusPanel, BorderLayout.SOUTH);

		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
	
	private  JPanel getStatusBar() {
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

		
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));

		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(statusLabel);
		
		return statusPanel;
	}
	
	private JPanel getButtonPanel(int width) {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setSize(new Dimension(width, 30));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton add    = new JButton(" Add ");
		JButton remove = new JButton(" Remove ");
		
		buttonPanel.add(add);
		buttonPanel.add(remove);
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		return buttonPanel;
	}
}
	

