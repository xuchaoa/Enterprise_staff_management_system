package graphical;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login_listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String username_str = e.getActionCommand();
        System.out.println(username_str);
    }
}
