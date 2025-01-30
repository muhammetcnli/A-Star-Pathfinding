import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    private final Panel panel;

    public KeyHandler(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
    if(code == KeyEvent.VK_ENTER){
        panel.search();
        panel.autoSearch();
    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
