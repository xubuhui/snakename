package com.jt.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.jt.dao.RankDao;
import com.jt.util.ImageUtil;
import com.jt.vo.RankVo;



/**
 * 游戏排行界面面板
 * @author xgq
 *
 */
public class RankPanel extends JPanel{
	
	Image bg_rank =ImageUtil.getImage("img/bg4.jpg");
	Font font=new Font("楷体",Font.BOLD,18);
	
	JTable table;//表格
	
	public RankPanel() {
		// 初始化面板信息
		initPanel();
		//初始化组件信息
		initTable();
		//添加组件
		addComponents();
	}
	
	//添加组件
	private void addComponents() {
		this.add(table);
		
	}
	//初始化表格
	private void initTable() {
//		Object [][] rowData = {{1,"张三",87,"2019-1-1"},
//				{2,"李四",77,"2019-1-1"},
//				{3,"马武",65,"2019-1-1"},
//				{4,"赵六",99,"2019-1-1"}};
		RankDao rankDao=new RankDao();
		List<RankVo> ranks = rankDao.selectRanks(4);
		//转换二维数组
		Object [][] rowData = new Object[ranks.size()][4];
		for (int i = 0; i < ranks.size(); i++) {
			RankVo rank=ranks.get(i);
			String username = rank.getUsername();
			int score = rank.getScore();
			String date = rank.getDate();
			rowData[i][0]=i+1;
			rowData[i][1]=username;
			rowData[i][2]=score;
			rowData[i][3]=date;
		}
		
		Object [] columnNames = {"排名","姓名","分数","时间"};
		table =new JTable(rowData, columnNames) {
			//重写渲染单元格
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				// TODO Auto-generated method stub
				 Component cell = super.prepareRenderer(renderer, row, column);
				//设置单元格背景透明
				 if (cell instanceof JComponent) {
//					1.强转为JComponent
					 ((JComponent) cell).setOpaque(false);
				}
				 
				 
				 return cell;
				
			
			}
		};//数据，列名
		
		table.setBounds(100,180,500,300);
		//设置字体
		table.setFont(font);
		table.setForeground(Color.cyan);
		//设置行高
		table.setRowHeight(40);
		//设置不可编辑
		table.setEnabled(false);
		table.setShowGrid(false);
//		table.setBackground(Color.green);
		table.setOpaque(false);
		
		
		
	}
	//创建面板信息
	private void initPanel() {
		 
		this.setBounds(0,0,700,500);
		this.setLayout(null);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(bg_rank, 0, 0, this);
	}
	
	 
	

}
