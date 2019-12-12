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
 * ��Ϸ���н������
 * @author xgq
 *
 */
public class RankPanel extends JPanel{
	
	Image bg_rank =ImageUtil.getImage("img/bg4.jpg");
	Font font=new Font("����",Font.BOLD,18);
	
	JTable table;//���
	
	public RankPanel() {
		// ��ʼ�������Ϣ
		initPanel();
		//��ʼ�������Ϣ
		initTable();
		//������
		addComponents();
	}
	
	//������
	private void addComponents() {
		this.add(table);
		
	}
	//��ʼ�����
	private void initTable() {
//		Object [][] rowData = {{1,"����",87,"2019-1-1"},
//				{2,"����",77,"2019-1-1"},
//				{3,"����",65,"2019-1-1"},
//				{4,"����",99,"2019-1-1"}};
		RankDao rankDao=new RankDao();
		List<RankVo> ranks = rankDao.selectRanks(4);
		//ת����ά����
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
		
		Object [] columnNames = {"����","����","����","ʱ��"};
		table =new JTable(rowData, columnNames) {
			//��д��Ⱦ��Ԫ��
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				// TODO Auto-generated method stub
				 Component cell = super.prepareRenderer(renderer, row, column);
				//���õ�Ԫ�񱳾�͸��
				 if (cell instanceof JComponent) {
//					1.ǿתΪJComponent
					 ((JComponent) cell).setOpaque(false);
				}
				 
				 
				 return cell;
				
			
			}
		};//���ݣ�����
		
		table.setBounds(100,180,500,300);
		//��������
		table.setFont(font);
		table.setForeground(Color.cyan);
		//�����и�
		table.setRowHeight(40);
		//���ò��ɱ༭
		table.setEnabled(false);
		table.setShowGrid(false);
//		table.setBackground(Color.green);
		table.setOpaque(false);
		
		
		
	}
	//���������Ϣ
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
