package com.cicd.firstmodule.core;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.*;
import javax.swing.event.*;

public class MyTable extends JFrame implements ActionListener, TableModelListener {

 	private JTable table;
 	private JButton getValue;
 	private JPanel statusPanel = new JPanel();
 	private JLabel statusLabel = new JLabel();
 	
	public MyTable() {

		getContentPane().setLayout( new FlowLayout() );

		DefaultTableModel tableModel;

		Object[] columnNames = new Object[]{"Column 1","Column 2","Column 3"};
		Object[][] rowData = {
			{"1", "2", "3"},
			{"4", "5", "6"},
			{"7", "8", "9"},
			{"10", "11", "12"},
			{"13", "14", "15"},
			{"16", "17", "18"},
			{"19", "20", "21"},
			{"22", "23", "24"}
		};

		tableModel = new DefaultTableModel(rowData, columnNames);
		tableModel.addTableModelListener( this );

		table = new JTable(tableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(280, 100));
		getContentPane().add(scrollPane);

		getValue = new JButton( "Get Value" );
		getValue.addActionListener( this );
		getContentPane().add( getValue );
		
		getContentPane().add(getStatusBar());

		setVisible( true );
		setSize( 320, 200 );
	}

	public void tableChanged( TableModelEvent e ) {
		DefaultTableModel model = (DefaultTableModel)e.getSource();

		int row = e.getFirstRow();
		int column = e.getColumn();

		TableCellRenderer  render = table.getCellRenderer(row, column);

		String cellValue = String.valueOf( table.getValueAt(row, column) );

		Component rendererComp = render.getTableCellRendererComponent(table, cellValue, true, true,
				row, column);

		
		Pattern patten = Pattern.compile("^[a-zA-Z]");
		Matcher matcher = patten.matcher(cellValue);
		System.out.println(matcher.find());
		boolean flag = Pattern.matches("^[a-zA-Z]", cellValue);
		
		System.out.println(" Pattern match..?" + flag + " Cell Value.. "+  cellValue);
		
		if(!flag) {
		   rendererComp.setForeground(Color.red);
		   rendererComp .setBackground(Color.blue);
		   statusLabel.setText("Invalid Data. Please enter only characters");
		   statusLabel.setForeground(Color.RED);
		   return ;
		}
		
		
//		JOptionPane.showMessageDialog(this,
//			"Value at (" + row + "," + column + ") changed to " + "\'" + cellValue + "\'");
		
	}

	public void actionPerformed( ActionEvent evt ) {
		int row = table.getSelectedRow();
		int column = table.getSelectedColumn();

		if ( evt.getSource() == getValue ) {
			String value = String.valueOf( table.getValueAt(row,column) );
			JOptionPane.showMessageDialog( this,
				"Value at (" + row + "," + column + ") is " + "\'" + value + "\'");
		}		
	}

  	public static void main ( String[] args ) {
  			MyTable frm = new MyTable();
    		frm.setVisible(true);
    		frm.setSize( 350, 250 );
	}
  	
	private  JPanel getStatusBar() {
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

		
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));

		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(statusLabel);
		
		return statusPanel;
	}

}