package j230530;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class PanelTest {
	private Frame f;
	private Panel p;
	private Button ok, cencel;
	private Frame tf1;
	
	public void PanelTest(){
		f = new Frame("Panel example");
		ok = new Button("전송");
		cancel = new Button("삭제");
		tf1 = new TextField ("Input...");
		p= new Panel();
		
	}
	public void startFrame() {
		f.add(400,400);
		p.setBackground(true);
		p.add(ok);
		p.add(cancel);
		f.add(p,BorderLayout.CENTER);
		f.setSize(400,400);
		f.setVisible(true);
		//Frame f=new Frame("Frame Demo");
		
	
	public static void main(String[] args) {
		PanelTest g= new PanelTest();
		g.startFrame();
	}

}
